package kr.or.ddit.dy_risk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.dy_risk.dao.IDy_riskDao;
import kr.or.ddit.log.dao.ILogDao;
import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.IpcrVO;
import kr.or.ddit.vo.RiskVO;
import kr.or.ddit.vo.SttusVO;
@Service
public class Dy_riskServiceImpl implements IDy_riskService {
	
	@Autowired
	private IDy_riskDao dao;
	
	@Autowired
	private ILogDao logDao;
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void insertBoard(RiskVO riskInfo) throws Exception {
		dao.insertBoard(riskInfo);
		Map<String, String> params = new HashMap<String, String>();
	      params.put("prjct_id", riskInfo.getRisk_prjct());
	      params.put("empl_id", riskInfo.getRisk_regist());
	      params.put("log_cn", "리스크(" + riskInfo.getRisk_nm() + ") 작성");
	      logDao.insertLog(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void updateBoard(RiskVO riskVO) throws Exception {
		dao.updateBoard(riskVO);
		Map<String, String> params = new HashMap<String, String>();
	      params.put("prjct_id", riskVO.getRisk_prjct());
	      params.put("empl_id", riskVO.getRisk_regist());
	      params.put("log_cn", "리스크(" + riskVO.getRisk_nm() + ") 수정");
	      logDao.insertLog(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return dao.totalCount(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<RiskVO> boardList(Map<String, String> params) throws Exception {
		return dao.boardList(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public RiskVO boardViewInfo(Map<String, String> params) throws Exception {
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

}
