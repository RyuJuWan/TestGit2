package kr.or.ddit.empl.file.controller;

import java.io.File;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.utils.HnfInptAttachFileMapper;
import kr.or.ddit.vo.HnfInptFileVO;
import kr.or.ddit.vo.HnfInptVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/empl/file/")
public class hnfInptFileController {
	@Autowired
	private HnfInptAttachFileMapper fileMapper;
	
	@RequestMapping("fileUploadForm")
	public void fileUploadForm(){
		
	}
	
	@RequestMapping("fileUpload")
	public String fileUpload(@RequestParam HnfInptVO hnfInptInfo,@RequestParam MultipartFile file){
		HnfInptFileVO item = this.fileMapper.mapping(file, hnfInptInfo.getHnf_inpt_actpln_id());
		String fileName= ((HnfInptFileVO) item).getHnf_inpt_file_save_nm();
		return "redirect:empl/file/fileUploadForm.do?fileName=" + fileName ;
	}
}
