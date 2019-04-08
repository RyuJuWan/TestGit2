package kr.or.ddit.message.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.IpcrVO;
import kr.or.ddit.vo.MessageVO;
import kr.or.ddit.vo.SmlCatVO;
import kr.or.ddit.vo.SttusVO;
import kr.or.ddit.vo.WBSVO;
import kr.or.ddit.vo.WorkTyVO;

public interface IMessageDao {
	
	public List<MessageVO> messageList(Map<String, String> params) throws Exception;
	
	public MessageVO messageInfo(Map<String, String> params) throws Exception;
	
	public void messageDelete(Map<String, String> params) throws Exception;
	
	public void messageInsert(MessageVO messageInfo)throws Exception;

	public String messageIssueCount(Map<String, String> params)throws Exception;
	
	public String messageWbsCount(Map<String,String> params) throws Exception;
}
