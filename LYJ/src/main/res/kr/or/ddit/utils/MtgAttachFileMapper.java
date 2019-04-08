package kr.or.ddit.utils;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.vo.MtgFileVO;

@Component
public class MtgAttachFileMapper {
	public MtgFileVO mapping(MultipartFile item, String mtg_id){
		MtgFileVO fileItemInfo = null;
		if(item.getSize() == 0){
			return fileItemInfo;
		}
		if(item != null){
				fileItemInfo = new MtgFileVO();
				fileItemInfo.setMtg(mtg_id);
				String fileName = FilenameUtils.getName(item.getOriginalFilename());
				fileItemInfo.setMtg_file_nm(fileName);
				
				fileItemInfo.setMtg_file_save_nm(generateID(fileName));
				
				fileItemInfo.setMtg_file_ty(item.getContentType());
				fileItemInfo.setMtg_file_size(String.valueOf(item.getSize()));
				
				
				saveFile(fileItemInfo.getMtg_file_save_nm(), item);
		}
		return fileItemInfo;
	}
	
	public MtgFileVO updateMapping(MultipartFile item, MtgFileVO getfileItem){
		MtgFileVO fileItemInfo = getfileItem;
		if(item.getSize() == 0){
			return getfileItem;
		}
		if(item != null){
			String fileName = FilenameUtils.getName(item.getOriginalFilename());
			fileItemInfo.setMtg_file_nm(fileName);
			
			fileItemInfo.setMtg_file_save_nm(generateID(fileName));
			
			fileItemInfo.setMtg_file_ty(item.getContentType());
			fileItemInfo.setMtg_file_size(String.valueOf(item.getSize()));
			
			
			saveFile(fileItemInfo.getMtg_file_save_nm(), item);
		}
		return fileItemInfo;
	}
	
	private void saveFile(String fileSaveName, MultipartFile item) {
		File saveFile = new File(GlobalConstant.FILE_PATH, fileSaveName);
		
		try {
			item.transferTo(saveFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String generateID(String fileName){
		// a.png => a and png
		// a
		String baseName = FilenameUtils.getBaseName(fileName);
		// png
		String extension = FilenameUtils.getExtension(fileName);
		
		// a4232423423421243123434.png
		String genID = UUID.randomUUID().toString().replace("-", "");
		
		return baseName + genID + "." + extension;
	}
}
