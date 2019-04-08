package kr.or.ddit.utils;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.vo.ExpndtrAnactFileVO;
import kr.or.ddit.vo.ExpndtrAnactVO;
import kr.or.ddit.vo.HnfInptFileVO;
import kr.or.ddit.vo.NoticeFileVO;
import kr.or.ddit.vo.PrpslFileVO;

// <bean name="attachFileMapper" class="kr.or.ddit.utils.AttachFileMapper"/>
@Component
public class NoticeAttachFileMapper {
	public NoticeFileVO mapping(MultipartFile item, String bo_id){
		NoticeFileVO fileItemInfo = null;
		if(item.getSize() == 0){
			return fileItemInfo;
		}
		if(item != null){
				fileItemInfo = new NoticeFileVO();
				fileItemInfo.setNotice(bo_id);
				// item.getName() : d:\temp\a.png or a.png
				// a.png
				String fileName = FilenameUtils.getName(item.getOriginalFilename());
				fileItemInfo.setNotice_file_nm(fileName);
				
				fileItemInfo.setNotice_file_save_nm(generateID(fileName));
				
				fileItemInfo.setNotice_file_ty(item.getContentType());
				fileItemInfo.setNotice_file_size(String.valueOf(item.getSize()));
				
				
				saveFile(fileItemInfo.getNotice_file_save_nm(), item);
		}
		return fileItemInfo;
	}
	
	public NoticeFileVO updateMapping(MultipartFile item, NoticeFileVO getfileItem){
		NoticeFileVO fileItemInfo = getfileItem;
		if(item.getSize() == 0){
			return getfileItem;
		}
		if(item != null){
			String fileName = FilenameUtils.getName(item.getOriginalFilename());
			fileItemInfo.setNotice_file_nm(fileName);
			
			fileItemInfo.setNotice_file_save_nm(generateID(fileName));
			
			fileItemInfo.setNotice_file_ty(item.getContentType());
			fileItemInfo.setNotice_file_size(String.valueOf(item.getSize()));
			
			
			saveFile(fileItemInfo.getNotice_file_save_nm(), item);
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
