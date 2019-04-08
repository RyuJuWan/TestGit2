package kr.or.ddit.empl.file.controller;

import kr.or.ddit.utils.NoticeAttachFileMapper;
import kr.or.ddit.vo.NoticeFileVO;
import kr.or.ddit.vo.NoticeVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



@Controller
@RequestMapping("/empl/file/notice/")
public class noticeFileController {
	
	@Autowired
	private NoticeAttachFileMapper fileMapper;
	
	@RequestMapping("fileUploadForm")
	public void fileUploadForm(){
		
	}
	
	@RequestMapping("fileUpload")
	public String fileUpload(
			@RequestParam NoticeVO noticeInfo,
			@RequestParam MultipartFile file
			){
		NoticeFileVO item = this.fileMapper.mapping(file, noticeInfo.getNotice_id());
		String fileName = ((NoticeFileVO)item).getNotice_file_save_nm();
		
		return "redirect:empl/file/notice/fileUploadForm.do?fileName=" + fileName ;
	}
	

}
