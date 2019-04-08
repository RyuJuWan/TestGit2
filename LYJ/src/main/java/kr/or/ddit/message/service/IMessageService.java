package kr.or.ddit.message.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MessageVO;



public interface IMessageService {
	
	
	public List<MessageVO> messageList(Map<String, String> params) throws Exception;
	
	public MessageVO messageInfo(Map<String, String> params) throws Exception;
	
	public void messageDelete(Map<String, String> params) throws Exception;
	
	public void messageInsert(MessageVO messageInfo)throws Exception;
	
	public String messageIssueCount(Map<String,String> params) throws Exception;
	
	public String messageWbsCount(Map<String,String> params) throws Exception;
	
	
	
}
