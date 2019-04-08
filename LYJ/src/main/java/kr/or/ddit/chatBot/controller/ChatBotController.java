package kr.or.ddit.chatBot.controller;

import java.util.List;

import kr.or.ddit.vo.CHB_KeyboardVO;
import kr.or.ddit.vo.CHB_MessageVO;
import kr.or.ddit.vo.CHB_RequstMessageVO;
import kr.or.ddit.vo.CHB_ResponseMessageVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.watson.developer_cloud.assistant.v1.Assistant;
import com.ibm.watson.developer_cloud.assistant.v1.model.InputData;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.assistant.v1.model.RuntimeIntent;

@Controller
@RequestMapping("/empl/chatbot/")
public class ChatBotController {
	
	@RequestMapping("chatbotList")
	public String chttbotList(){
		return "empl/chttbot/chttbotList";
	}
	
	@RequestMapping("message")
	@ResponseBody
	public String message(@RequestParam String content, @RequestParam String type)throws Exception{
		
		CHB_ResponseMessageVO res_vo = new CHB_ResponseMessageVO();
		CHB_MessageVO mes_vo = new CHB_MessageVO();
		CHB_KeyboardVO keyboard = new CHB_KeyboardVO();
		keyboard.setType("text");
		
		res_vo.setKeyboard(keyboard);
		if(!type.equals("text"))
		{
			mes_vo.setText("텍스트 타입만 허용하고 있습니다.");
			
			res_vo.setMessage(mes_vo);
			String getMessage = mes_vo.getText();
			return getMessage;
		}
		
		//텍스트 요청 받기 -> 사용자가 챗봇에게 보내는 메세지
		String query= content;
		
		//왓슨
		Assistant service = new Assistant("2018-08-06");
		service.setUsernameAndPassword("apikey", "__4I3f1O2GbULIOcsGaqe6hRvpMGZCv8eO2jMegfYl57");
		String workspaceId = "99c0c546-0c39-4bf5-8383-859162a35ef3";
		
		// Start assistant with empty message.
	    MessageOptions options = new MessageOptions.Builder(workspaceId).build();
	    
	    
	    // 입력한 사용자의 요청을 넣음
	    InputData input = new InputData.Builder(query).build();//위에서 입력받은 사용자의 요청을 여기로 넣어준다.
	    options = new MessageOptions.Builder(workspaceId).input(input).build();
	    
	    MessageResponse mes_response = service.message(options).execute();      
	    List<RuntimeIntent> responseIntents = mes_response.getIntents();
	    
	    // If an intent was detected, print it to the console.
	    if(responseIntents.size() > 0) {
	    	System.out.println("Detected intent: #" + responseIntents.get(0).getIntent());
	    }
	    
	    String answer = mes_response.getOutput().getText().get(0);
	    
	    try {
			mes_vo.setText(answer);
			res_vo.setMessage(mes_vo);
			String getMessage = mes_vo.getText();
			return getMessage;
		} catch (NullPointerException exNull) {
			mes_vo.setText("올바른 질문을 입력해주세요");
			res_vo.setMessage(mes_vo);
			String getMessage = mes_vo.getText();
			return getMessage;
		} catch (Exception e) {
			e.printStackTrace();
			mes_vo.setText("서버붐");
			res_vo.setMessage(mes_vo);
			String getMessage = mes_vo.getText();
			return getMessage;
		}
	}
}
