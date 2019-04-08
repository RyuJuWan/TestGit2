package kr.or.ddit.empl.message.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empl/message/")
public class MessageController {
	
	@RequestMapping("messageView")
	public String messageView(){
		return "empl/message/messageView";
	}
	
	@RequestMapping("messageForm")
	public String messageForm(){
		return "empl/message/messageForm";
	}
	@RequestMapping("fdbckMessageView")
	public String fdbckMessageView(){
		return "empl/message/fdbckMessageView";
	}
	
	@RequestMapping("fdbckMessageForm")
	public String fdbckMessageForm(){
		return "empl/message/fdbckMessageForm";
	}

	
}















