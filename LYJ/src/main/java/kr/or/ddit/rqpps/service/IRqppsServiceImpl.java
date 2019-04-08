package kr.or.ddit.rqpps.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.rqpps.dao.IRqppsDao;
import kr.or.ddit.vo.RqppsVO;

@Service("rqppsService")
public class IRqppsServiceImpl implements IRqppsService{
	@Autowired
	private IRqppsDao dao;

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<RqppsVO> rqppsList(Map<String, String> params) throws Exception {
		return dao.rqppsList(params);
	}
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public RqppsVO rqppsInfo(Map<String, String> params) throws Exception {
		return dao.rqppsInfo(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public String insertRqpps(RqppsVO rqppsInfo) throws Exception {
		return dao.insertRqpps(rqppsInfo);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void modifyRqpps(RqppsVO rqppsInfo) throws Exception {
		dao.modifyRqpps(rqppsInfo);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return dao.totalCount(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void deleteRqpps(Map<String, String> params) throws Exception {
		dao.deleteRqpps(params);
	}
	


}
