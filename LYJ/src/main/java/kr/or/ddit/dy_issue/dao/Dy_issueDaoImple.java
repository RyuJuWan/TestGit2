package kr.or.ddit.dy_issue.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.IpcrVO;
import kr.or.ddit.vo.IssueVO;
import kr.or.ddit.vo.PrjctVO;
import kr.or.ddit.vo.RiskVO;
import kr.or.ddit.vo.SttusVO;
@Repository
public class Dy_issueDaoImple implements IDy_issueDao {
	
	@Autowired
	private SqlMapClient client;

	@Override
	public String insertBoard(IssueVO issueInfo) throws Exception {
		return  (String) client.insert("issue.insertBoard", issueInfo);
	}

	@Override
	public void updateBoard(IssueVO issueInfo) throws Exception {
		client.update("issue.updateBoard", issueInfo);
	}

	@Override
	public void deleteBoard(Map<String, String> params) throws Exception {
		client.update("issue.deleteBoard", params);
	}

	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return (int) client.queryForObject("issue.totalCount", params);
	}

	@Override
	public List<IssueVO> boardList(Map<String, String> params) throws Exception {
		return client.queryForList("issue.boardList", params);
	}

	@Override
	public IssueVO boardViewInfo(Map<String, String> params) throws Exception {
		return (IssueVO) client.queryForObject("issue.boardViewInfo", params);
	}

	@Override
	public String getPrjctName(Map<String, String> params) throws Exception {
		return (String) client.queryForObject("issue.getPrjctName", params);
	}

	@Override
	public List<EmplVO> getPrjctEmpl(Map<String, String> params)
			throws Exception {
		return client.queryForList("issue.getPrjctEmpl", params);
	}

	@Override
	public List<PrjctVO> getAllPrjct() throws Exception {
		return client.queryForList("issue.getAllPrjct");
	}

	@Override
	public List<RiskVO> getAllRisk(Map<String, String> params) throws Exception {
		return client.queryForList("issue.getAllRisk", params);
	}

	@Override
	public List<IpcrVO> getAllIpcr() throws Exception {
		return client.queryForList("issue.getAllIpcr");
	}

	@Override
	public List<SttusVO> getAllSttus() throws Exception {
		return client.queryForList("issue.getAllSttus");
	}

	@Override
	public List<IssueVO> selectSttueBoardList(Map<String, String> params)
			throws Exception {
		return client.queryForList("issue.selectSttueBoardList", params);
	}

	@Override
	public int sttusCount(Map<String, String> params) throws Exception {
		return (int) client.queryForObject("issue.sttusCount", params);
	}

	@Override
	public List<IssueVO> selectListSchdul(Map<String, String> params)
			throws Exception {
		return client.queryForList("issue.selectListSchdul", params);
	}

}
