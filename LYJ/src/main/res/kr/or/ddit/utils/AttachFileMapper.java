package kr.or.ddit.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.vo.FileItemVO;

// <bean name="attachFileMapper" class="kr.or.ddit.utils.AttachFileMapper"/>
@Component
public class AttachFileMapper {
	public List<FileItemVO> mapping(MultipartFile[] items, String bo_no){
		List<FileItemVO> fileItemList = new ArrayList<FileItemVO>();
		if(items != null){
			FileItemVO fileItemInfo;
			for(MultipartFile item : items){
				fileItemInfo = new FileItemVO();
				fileItemInfo.setFile_bo_no(bo_no);
				
				// item.getName() : d:\temp\a.png or a.png
				// a.png
				String fileName = FilenameUtils.getName(item.getOriginalFilename());
				fileItemInfo.setFile_name(fileName);
				
				fileItemInfo.setFile_save_name(generateID(fileName));
				
				fileItemInfo.setFile_content_type(item.getContentType());
				fileItemInfo.setFile_size(String.valueOf(item.getSize()));
				
				fileItemList.add(fileItemInfo);
				
				saveFile(fileItemInfo.getFile_save_name(), item);
			}
		}
		return fileItemList;
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
