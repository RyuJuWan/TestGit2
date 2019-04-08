package kr.or.ddit.utils;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.vo.MtgFileVO;
import kr.or.ddit.vo.ReprtFileVO;

@Component
public class ReprtAttachFileMapper {
	public ReprtFileVO mapping(MultipartFile item, String reprt_id){
		ReprtFileVO fileItemInfo = null;
		if(item.getSize() == 0){
			return fileItemInfo;
		}
		if(item != null){
				fileItemInfo = new ReprtFileVO();
				fileItemInfo.setReprt(reprt_id);
				String fileName = FilenameUtils.getName(item.getOriginalFilename());
				fileItemInfo.setReprt_file_nm(fileName);
				
				fileItemInfo.setReprt_file_save_nm(generateID(fileName));
				
				fileItemInfo.setReprt_file_ty(item.getContentType());
				fileItemInfo.setReprt_file_size(String.valueOf(item.getSize()));
				
				
				saveFile(fileItemInfo.getReprt_file_save_nm(), item);
		}
		return fileItemInfo;
	}
	
	public ReprtFileVO updateMapping(MultipartFile item, ReprtFileVO getfileItem){
		ReprtFileVO fileItemInfo = getfileItem;
		if(item.getSize() == 0){
			return getfileItem;
		}
		if(item != null){
			String fileName = FilenameUtils.getName(item.getOriginalFilename());
			fileItemInfo.setReprt_file_nm(fileName);
			
			fileItemInfo.setReprt_file_save_nm(generateID(fileName));
			
			fileItemInfo.setReprt_file_ty(item.getContentType());
			fileItemInfo.setReprt_file_size(String.valueOf(item.getSize()));
			
			
			saveFile(fileItemInfo.getReprt_file_save_nm(), item);
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
