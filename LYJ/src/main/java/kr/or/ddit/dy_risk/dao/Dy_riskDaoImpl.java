package kr.or.ddit.dy_risk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.IpcrVO;
import kr.or.ddit.vo.RiskVO;
import kr.or.ddit.vo.SttusVO;
@Repository
public class Dy_riskDaoImpl implements IDy_riskDao {
	
	@Autowired
	private SqlMapClient client;
	
	@Override
	public void insertBoard(RiskVO riskInfo) throws Exception {
		client.insert("risk.insertBoard", riskInfo);
	}

	@Override
	public void updateBoard(RiskVO riskVO) throws Exception {
		client.update("risk.updateBoard", riskVO);
	}

	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return (int) client.queryForObject("risk.totalCount", params);
	}

	@Override
	public List<RiskVO> boardList(Map<String, String> params) throws Exception {
		return client.queryForList("risk.boardList", params);
	}

	@Override
	public RiskVO boardViewInfo(Map<String, String> params) throws Exception {
		return (RiskVO) client.queryForObject("risk.boardViewInfo", params);
	}

	@Override
	public String getPrjctName(Map<String, String> params) throws Exception {
		return (String) client.queryForObject("risk.getPrjctName", params);
	}

	@Override
	public List<EmplVO> getPrjctEmpl(Map<String, String> params)
			throws Exception {
		return client.queryForList("risk.getPrjctEmpl", params);
	}

	@Override
	public List<IpcrVO> getAllIpcr() throws Exception {
		return client.queryForList("risk.getAllIpcr");
	}

	@Override
	public List<SttusVO> getAllSttus() throws Exception {
		return client.queryForList("risk.getAllSttus");
	}

}
