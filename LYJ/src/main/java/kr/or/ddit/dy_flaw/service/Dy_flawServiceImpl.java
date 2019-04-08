package kr.or.ddit.dy_flaw.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.dy_flaw.dao.IDy_flawDao;
import kr.or.ddit.log.dao.ILogDao;
import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.FlawVO;
import kr.or.ddit.vo.IpcrVO;
import kr.or.ddit.vo.SttusVO;
@Service
public class Dy_flawServiceImpl implements IDy_flawService {
	
	@Autowired
	private IDy_flawDao dao;
	
	@Autowired
	private ILogDao logDao;
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void insertBoard(FlawVO flawInfo) throws Exception {
		dao.insertBoard(flawInfo);
		Map<String, String> params = new HashMap<String, String>();
	      params.put("prjct_id", flawInfo.getFlaw_prjct());
	      params.put("empl_id", flawInfo.getFlaw_regist());
	      params.put("log_cn", "결함(" + flawInfo.getFlaw_nm() + ") 작성");
	      logDao.insertLog(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void updateBoard(FlawVO flawInfo) throws Exception {
		dao.updateBoard(flawInfo);
		Map<String, String> params = new HashMap<String, String>();
	      params.put("prjct_id", flawInfo.getFlaw_prjct());
	      params.put("empl_id", flawInfo.getFlaw_regist());
	      params.put("log_cn", "결함(" + flawInfo.getFlaw_nm() + ") 수정");
	      logDao.insertLog(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return dao.totalCount(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<FlawVO> boardList(Map<String, String> params) throws Exception {
		return dao.boardList(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public FlawVO boardViewInfo(Map<String, String> params) throws Exception {
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
	public int flawSttusCount(Map<String, String> params) throws Exception {
		return dao.flawSttusCount(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<FlawVO> selectListSechdul(Map<String, String> params)
			throws Exception {
		return dao.selectListSechdul(params);
	}

}
