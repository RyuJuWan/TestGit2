package kr.or.ddit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InitLoginController {
	
	@RequestMapping("login")
	public String login(){
		return "member/login/login";
	}
}
