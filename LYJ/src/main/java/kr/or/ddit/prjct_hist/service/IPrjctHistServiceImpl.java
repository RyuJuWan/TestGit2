package kr.or.ddit.prjct_hist.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.prjct_hist.dao.IPrjctHistDao;
import kr.or.ddit.vo.PrjctHistVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("prjctHistService")
public class IPrjctHistServiceImpl implements IPrjctHistService {
	
	@Autowired
	private IPrjctHistDao dao;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<PrjctHistVO> prjctHistList(Map<String, String> params)
			throws Exception {
		return dao.prjctHistList(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return dao.totalCount(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<PrjctHistVO> prjctHistPageList(Map<String, String> params)
			throws Exception {
		return dao.prjctHistPageList(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void insertPrjctHist(PrjctHistVO prjctHistInfo) throws Exception {
		dao.insertPrjctHist(prjctHistInfo);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public PrjctHistVO prjctHistView(Map<String, String> params)
			throws Exception {
		return dao.prjctHistView(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public void deletePrjctHist(Map<String, String> params) throws Exception {
		dao.deletePrjctHist(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<PrjctHistVO> prjctMemberList(Map<String, String> params)
			throws Exception {
		return dao.prjctMemberList(params);
	}
}
