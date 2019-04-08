package kr.or.ddit.message.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.vo.MessageVO;


@Repository
public class MessageDaoImpl implements IMessageDao {

	@Autowired
	private SqlMapClient client;

	@Override
	public List<MessageVO> messageList(Map<String, String> params)
			throws Exception {
		
		return client.queryForList("message.messageList",params);
	}

	@Override
	public MessageVO messageInfo(Map<String, String> params) throws Exception {
		return (MessageVO) client.queryForObject("message.messageInfo",params);
	}

	@Override
	public void messageDelete(Map<String, String> params) throws Exception {
		client.update("message.messageDelete",params);
	}

	@Override
	public void messageInsert(MessageVO messageInfo) throws Exception {
		client.insert("message.messageInsert",messageInfo);
	}

	@Override
	public String messageIssueCount(Map<String, String> params)
			throws Exception {
		String issueCount= (String) client.queryForObject("message.messageIssueCount",params);
		return issueCount;
	}

	@Override
	public String messageWbsCount(Map<String, String> params) throws Exception {
		String wbsCount= (String) client.queryForObject("message.messageWbsCount",params);
		return wbsCount;
	}
	
	

}
