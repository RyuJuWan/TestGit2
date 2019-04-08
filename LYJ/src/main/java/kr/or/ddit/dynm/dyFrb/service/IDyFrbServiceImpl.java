package kr.or.ddit.dynm.dyFrb.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.dynm.dyFrb.dao.IDyFrbDao;
import kr.or.ddit.log.dao.ILogDao;
import kr.or.ddit.vo.DynmFrbVO;

@Service("dy_frbService")
public class IDyFrbServiceImpl implements IDyFrbService{
	@Autowired
	private IDyFrbDao dao;
	
	@Autowired
	private ILogDao logDao;
	
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<DynmFrbVO> frbList(Map<String, String> params) throws Exception {
		return dao.frbList(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return dao.totalCount(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public String insertFrb(DynmFrbVO frbInfo) throws Exception {
		Map<String, String> params2 = new HashMap<String, String>();
	      params2.put("prjct_id", frbInfo.getPrjct_id());
	      params2.put("empl_id", frbInfo.getDynm_frb_empl());
	      params2.put("log_cn", "회의록(" + frbInfo.getDynm_frb_nm() + ") 수정");
	      logDao.insertLog(params2);
		
		return dao.insertFrb(frbInfo);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public DynmFrbVO frbInfo(Map<String, String> params) throws Exception {
		return dao.frbInfo(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void deleteFrb(Map<String, String> params) throws Exception {
		dao.deleteFrb(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void modifyFrb(DynmFrbVO frbInfo) throws Exception {
		Map<String, String> params2 = new HashMap<String, String>();
	      params2.put("prjct_id", frbInfo.getPrjct_id());
	      params2.put("empl_id", frbInfo.getDynm_frb_empl());
	      params2.put("log_cn", "회의록(" + frbInfo.getDynm_frb_nm() + ") 수정");
	      logDao.insertLog(params2);
		dao.modifyFrb(frbInfo);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void frbView(Map<String, String> param) throws Exception {
		dao.frbView(param);
	}
}
