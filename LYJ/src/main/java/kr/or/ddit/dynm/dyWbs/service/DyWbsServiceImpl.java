package kr.or.ddit.dynm.dyWbs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.dynm.dyWbs.dao.IDyWbsDao;
import kr.or.ddit.log.dao.ILogDao;
import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.IpcrVO;
import kr.or.ddit.vo.SmlCatVO;
import kr.or.ddit.vo.SttusVO;
import kr.or.ddit.vo.WBSVO;
import kr.or.ddit.vo.WorkTyVO;
@Service
public class DyWbsServiceImpl implements IDyWbsService {
	
	@Autowired
	private IDyWbsDao dao;
	
	@Autowired
	private ILogDao logDao;
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public String insertBoard(WBSVO flawInfo) throws Exception {
		String wbs_id = dao.insertBoard(flawInfo);
		
		Map<String, String> params = new HashMap<String, String>();
	      params.put("prjct_id", flawInfo.getWbs_prjct());
	      params.put("empl_id", flawInfo.getWbs_strt_empl());
	      params.put("log_cn", "회의록(" + flawInfo.getWbs_work_nm() + ") 작성");
	      logDao.insertLog(params);
	      
	      return wbs_id;
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void updateBoard(WBSVO flawInfo) throws Exception {
		dao.updateBoard(flawInfo);
		
		Map<String, String> params = new HashMap<String, String>();
	      params.put("prjct_id", flawInfo.getWbs_prjct());
	      params.put("empl_id", flawInfo.getWbs_strt_empl());
	      params.put("log_cn", "회의록(" + flawInfo.getWbs_work_nm() + ") 작성");
	      logDao.insertLog(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return dao.totalCount(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<WBSVO> boardList(Map<String, String> params) throws Exception {
		return dao.boardList(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public WBSVO boardViewInfo(Map<String, String> params) throws Exception {
		return dao.boardViewInfo(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public String getPrjctName(Map<String, String> params) throws Exception {
		return dao.getPrjctName(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<EmplVO> getPrjctEmpl(Map<String, String> params)
			throws Exception {
		return dao.getPrjctEmpl(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<IpcrVO> getAllIpcr() throws Exception {
		return dao.getAllIpcr();
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<SttusVO> getAllSttus() throws Exception {
		return dao.getAllSttus();
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<SmlCatVO> getSmlCat() throws Exception {
		return dao.getSmlCat();
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<WorkTyVO> getWorkTy() throws Exception {
		return dao.getWorkTy();
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<WBSVO> wbsListByPrjctID(Map<String, String> params)
			throws Exception {
		return dao.wbsListByPrjctID(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public int wbsSttusCount(Map<String, String> params) throws Exception {
		return dao.wbsSttusCount(params);
	}

}
