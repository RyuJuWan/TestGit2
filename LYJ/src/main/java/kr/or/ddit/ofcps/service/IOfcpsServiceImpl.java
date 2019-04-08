package kr.or.ddit.ofcps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.ofcps.dao.IOfcpsDao;
import kr.or.ddit.vo.OfcpsVO;

@Service("ofcpsService")
public class IOfcpsServiceImpl implements IOfcpsService {
	
	@Autowired
	private IOfcpsDao dao;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<OfcpsVO> ofcpsList() throws Exception {
		return dao.ofcpsList();
	}

}
