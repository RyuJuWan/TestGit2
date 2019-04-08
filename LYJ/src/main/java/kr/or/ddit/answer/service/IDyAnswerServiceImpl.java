package kr.or.ddit.answer.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.answer.dao.IDyAnswerDao;
import kr.or.ddit.vo.AnswerVO;

@Service("dyAnswerService")
public class IDyAnswerServiceImpl implements IDyAnswerService{
	@Autowired
	private IDyAnswerDao dao;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<AnswerVO> frbList(Map<String, String> params) throws Exception {
		return dao.frbList(params);
	}

//	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
//	@Override
//	public int totalCount(Map<String, String> params) throws Exception {
//		return dao.totalCount(params);
//	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public String insertFrb(AnswerVO frbInfo) throws Exception {
		return dao.insertFrb(frbInfo);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public AnswerVO frbInfo(Map<String, String> params) throws Exception {
		return dao.frbInfo(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void deleteFrb(Map<String, String> params) throws Exception {
		dao.deleteFrb(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void modifyFrb(AnswerVO frbInfo) throws Exception {
		dao.modifyFrb(frbInfo);
	}

//	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
//	@Override
//	public void frbView(Map<String, String> param) throws Exception {
//		dao.frbView(param);
//	}
}
