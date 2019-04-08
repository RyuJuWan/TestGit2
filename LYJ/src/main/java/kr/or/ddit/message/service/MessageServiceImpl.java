package kr.or.ddit.message.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.dynm.dyWbs.dao.IDyWbsDao;
import kr.or.ddit.message.dao.IMessageDao;
import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.IpcrVO;
import kr.or.ddit.vo.MessageVO;
import kr.or.ddit.vo.SmlCatVO;
import kr.or.ddit.vo.SttusVO;
import kr.or.ddit.vo.WBSVO;
import kr.or.ddit.vo.WorkTyVO;
@Service("MessageService")
public class MessageServiceImpl implements IMessageService {
	
	@Autowired
	private IMessageDao dao;

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<MessageVO> messageList(Map<String, String> params)
			throws Exception {
		List<MessageVO> messageList= dao.messageList(params);
		return messageList;
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public MessageVO messageInfo(Map<String, String> params) throws Exception {
		MessageVO messageInfo =dao.messageInfo(params);
		return messageInfo;
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void messageDelete(Map<String, String> params) throws Exception {
		dao.messageDelete(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void messageInsert(MessageVO messageInfo) throws Exception {
		dao.messageInsert(messageInfo);
	}

	@Override
	public String messageIssueCount(Map<String, String> params)
			throws Exception {
		String issueCount = dao.messageIssueCount(params);
		return issueCount;
	}

	@Override
	public String messageWbsCount(Map<String, String> params) throws Exception {
		String wbsCount = dao.messageWbsCount(params);
		return wbsCount;
	}
	
	
	

}
