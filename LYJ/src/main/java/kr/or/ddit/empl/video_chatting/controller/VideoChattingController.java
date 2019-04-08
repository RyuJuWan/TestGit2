package kr.or.ddit.empl.video_chatting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empl/videoChatting/")
public class VideoChattingController {
	
	@RequestMapping("videoChattingList")
	public String videoChattingList(){
		return "empl/videoChatting/videoChattingList";
	}

	
}















