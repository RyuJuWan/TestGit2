package kr.or.ddit.qna.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.qna.dao.IQnaDao;
import kr.or.ddit.vo.QnaVO;

@Service("qnaService")
public class IQnaServiceImpl implements IQnaService{
	@Autowired
	private IQnaDao dao;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<QnaVO> qnaList(Map<String, String> params) throws Exception {
		return dao.qnaList(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return dao.totalCount(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public QnaVO qnaInfo(Map<String, String> params) throws Exception {
		return dao.qnaInfo(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public String insertQna(QnaVO qnaInfo) throws Exception {
		String qna_id = dao.insertQna(qnaInfo);
		return qna_id;
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void deleteQna(Map<String, String> params) throws Exception {
		dao.deleteQna(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void modifyQna(QnaVO qnaInfo) throws Exception {
		dao.modifyQna(qnaInfo);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public void qnaView(Map<String, String> param) throws Exception {
		dao.qnaView(param);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void insertQnaReply(QnaVO qnaInfo) throws Exception {
		dao.insertQnaReply(qnaInfo);
	}

	@Override
	public int groupCount(Map<String, String> params) throws Exception {
		return dao.groupCount(params);
	}

}
