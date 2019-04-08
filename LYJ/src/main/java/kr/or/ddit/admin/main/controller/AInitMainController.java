package kr.or.ddit.admin.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class AInitMainController {
	
	@RequestMapping("main")
	public String initScreen(){
		return "admin/init/initScreen";
	}
}
