package kr.or.ddit.dy_issue.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.dy_issue.dao.IDy_issueDao;
import kr.or.ddit.log.dao.ILogDao;
import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.IpcrVO;
import kr.or.ddit.vo.IssueVO;
import kr.or.ddit.vo.PrjctVO;
import kr.or.ddit.vo.RiskVO;
import kr.or.ddit.vo.SttusVO;
@Service
public class Dy_issueServiceImpl implements IDy_issueService {
	
	@Autowired
	private IDy_issueDao dao;
	
	@Autowired
	private ILogDao logDao;
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public String insertBoard(IssueVO issueInfo) throws Exception {
		String iss_id=dao.insertBoard(issueInfo);
		
		Map<String, String> params = new HashMap<String, String>();
	      params.put("prjct_id", issueInfo.getIssue_prjct());
	      params.put("empl_id", issueInfo.getIssue_regist());
	      params.put("log_cn", "이슈(" + issueInfo.getIssue_nm() + ") 작성");
	      logDao.insertLog(params);
	      
	      return iss_id;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void updateBoard(IssueVO issueInfo) throws Exception {
		dao.updateBoard(issueInfo);
		Map<String, String> params = new HashMap<String, String>();
	      params.put("prjct_id", issueInfo.getIssue_prjct());
	      params.put("empl_id", issueInfo.getIssue_regist());
	      params.put("log_cn", "이슈(" + issueInfo.getIssue_nm() + ") 수정");
	      logDao.insertLog(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void deleteBoard(Map<String, String> params) throws Exception {
		dao.deleteBoard(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return dao.totalCount(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<IssueVO> boardList(Map<String, String> params) throws Exception {
		return dao.boardList(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public IssueVO boardViewInfo(Map<String, String> params) throws Exception {
		return dao.boardViewInfo(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public String getPrjctName(Map<String, String> params) throws Exception {
		return dao.getPrjctName(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<EmplVO> getPrjctEmpl(Map<String, String> params) throws Exception {
		return dao.getPrjctEmpl(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<PrjctVO> getAllPrjct() throws Exception {
		return dao.getAllPrjct();
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<RiskVO> getAllRisk(Map<String, String> params) throws Exception {
		return dao.getAllRisk(params);
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
	public List<IssueVO> selectSttueBoardList(Map<String, String> params)
			throws Exception {
		return dao.selectSttueBoardList(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public int sttusCount(Map<String, String> params) throws Exception {
		return dao.sttusCount(params);
	}

	@Override
	public List<IssueVO> selectListSchdul(Map<String, String> params)
			throws Exception {
		return dao.selectListSchdul(params);
	}

}
