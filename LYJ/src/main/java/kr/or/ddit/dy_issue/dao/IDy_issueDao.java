package kr.or.ddit.dy_issue.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.IpcrVO;
import kr.or.ddit.vo.IssueVO;
import kr.or.ddit.vo.PrjctVO;
import kr.or.ddit.vo.RiskVO;
import kr.or.ddit.vo.SttusVO;

public interface IDy_issueDao {
	public String insertBoard(IssueVO issueInfo)throws Exception;
	
	public void updateBoard(IssueVO issueInfo) throws Exception;
	
	public void deleteBoard(Map<String, String> params) throws Exception;
	
	public int totalCount(Map<String, String> params) throws Exception;
	
	public List<IssueVO> boardList(Map<String, String> params) throws Exception;
	
	public List<IssueVO> selectSttueBoardList(Map<String, String> params) throws Exception;
	
	public IssueVO boardViewInfo(Map<String, String> params) throws Exception;
	
	public String getPrjctName(Map<String, String> params) throws Exception;
	
	public List<EmplVO> getPrjctEmpl(Map<String, String> params) throws Exception;
	
	public List<PrjctVO> getAllPrjct() throws Exception;
	
	public List<RiskVO> getAllRisk(Map<String, String> params) throws Exception;
	
	public List<IpcrVO> getAllIpcr() throws Exception;
	
	public List<SttusVO> getAllSttus() throws Exception;
	
	public int sttusCount(Map<String, String> params) throws Exception;
	
	public List<IssueVO> selectListSchdul(Map<String, String> params) throws Exception;
}
