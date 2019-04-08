package kr.or.ddit.empl.chtt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empl/chtt/")
public class ChttController {
	
	@RequestMapping("chttList")
	public String chttList(){
		return "empl/chtt/chttList";
	}
	@RequestMapping("chttForm")
	public String chttForm(){
		return "empl/chtt/chttForm";
	}
	
	
	

	
}















