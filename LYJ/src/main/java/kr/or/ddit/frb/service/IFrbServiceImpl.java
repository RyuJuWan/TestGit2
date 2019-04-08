package kr.or.ddit.frb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.frb.dao.IFrbDao;
import kr.or.ddit.vo.FrbVO;

@Service("frbService")
public class IFrbServiceImpl implements IFrbService{
	@Autowired
	private IFrbDao dao;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<FrbVO> frbList(Map<String, String> params) throws Exception {
		return dao.frbList(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return dao.totalCount(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public String insertFrb(FrbVO frbInfo) throws Exception {
		return dao.insertFrb(frbInfo);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public FrbVO frbInfo(Map<String, String> params) throws Exception {
		return dao.frbInfo(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void deleteFrb(Map<String, String> params) throws Exception {
		dao.deleteFrb(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void modifyFrb(FrbVO frbInfo) throws Exception {
		dao.modifyFrb(frbInfo);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void frbView(Map<String, String> param) throws Exception {
		dao.frbView(param);
	}
}
