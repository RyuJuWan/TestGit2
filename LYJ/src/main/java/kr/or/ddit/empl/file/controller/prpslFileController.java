package kr.or.ddit.empl.file.controller;


import kr.or.ddit.utils.PrpslAttachFileMapper;
import kr.or.ddit.vo.PrpslFileVO;
import kr.or.ddit.vo.PrpslVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/empl/file/prpsl/")
public class prpslFileController {
	@Autowired
	private PrpslAttachFileMapper fileMapper;
	
	@RequestMapping("fileUploadForm")
	public void fileUploadForm(){
		
	}
	
	@RequestMapping("fileUpload")
	public String fileUpload(@RequestParam PrpslVO prpslInfo,@RequestParam MultipartFile file){
		PrpslFileVO item = this.fileMapper.mapping(file, prpslInfo.getPrpsl_id());
		String fileName= ((PrpslFileVO) item).getPrpsl_file_save_nm();
		return "redirect:empl/file/prpsl/fileUploadForm.do?fileName=" + fileName ;
	}
}
