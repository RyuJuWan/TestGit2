package kr.or.ddit.empl.file.controller;

import kr.or.ddit.utils.ExpndtrAnactAttachFileMapper;
import kr.or.ddit.vo.ExpndtrAnactFileVO;
import kr.or.ddit.vo.ExpndtrAnactVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



@Controller
@RequestMapping("/empl/file/expndtrAnact/")
public class expndtrAnactFileController {
	
	@Autowired
	private ExpndtrAnactAttachFileMapper fileMapper;
	
	@RequestMapping("fileUploadForm")
	public void fileUploadForm(){
		
	}
	
	@RequestMapping("fileUpload")
	public String fileUpload(
			@RequestParam ExpndtrAnactVO expndtrAnactInfo,
			@RequestParam MultipartFile file
			){
		ExpndtrAnactFileVO item = this.fileMapper.mapping(file, expndtrAnactInfo.getExpndtr_anact_id());
		String fileName = ((ExpndtrAnactFileVO)item).getExpndtr_anact_file_save_nm();
		
		return "redirect:empl/file/expndtrAnact/fileUploadForm.do?fileName=" + fileName ;
	}
	

}
