package kr.or.ddit.crqfc.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.crqfc.dao.ICrqfcDao;
import kr.or.ddit.vo.CrqfcHoldVO;
import kr.or.ddit.vo.CrqfcVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("crqfcService")
public class ICrqfcServiceImpl implements ICrqfcService {
	
	@Autowired
	private ICrqfcDao dao;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<CrqfcVO> crqfcList() throws Exception {
		return dao.crqfcList();
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<CrqfcHoldVO> crqfcHoldPageList(Map<String, String> params)
			throws Exception {
		return dao.crqfcHoldPageList(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return dao.totalCount(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void insertCrqfcHold(CrqfcHoldVO crqfcHoldInfo) throws Exception {
		dao.insertCrqfcHold(crqfcHoldInfo);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<CrqfcHoldVO> crqfcHoldList(Map<String, String> params)
			throws Exception {
		return dao.crqfcHoldList(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void deleteCrqfcHold(CrqfcHoldVO crqfcHoldInfo) throws Exception {
		dao.deleteCrqfcHold(crqfcHoldInfo);
	}

}
