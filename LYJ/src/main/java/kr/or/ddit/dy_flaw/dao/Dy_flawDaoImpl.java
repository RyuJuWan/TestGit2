package kr.or.ddit.dy_flaw.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.FlawVO;
import kr.or.ddit.vo.IpcrVO;
import kr.or.ddit.vo.SttusVO;
@Repository
public class Dy_flawDaoImpl implements IDy_flawDao {

	@Autowired
	private SqlMapClient client;
	
	@Override
	public void insertBoard(FlawVO flawInfo) throws Exception {
		client.insert("flaw.insertBoard", flawInfo);
	}

	@Override
	public void updateBoard(FlawVO flawInfo) throws Exception {
		client.update("flaw.updateBoard", flawInfo);
	}

	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return (int) client.queryForObject("flaw.totalCount", params);
	}

	@Override
	public List<FlawVO> boardList(Map<String, String> params) throws Exception {
		return client.queryForList("flaw.boardList", params);
	}

	@Override
	public FlawVO boardViewInfo(Map<String, String> params) throws Exception {
		return (FlawVO) client.queryForObject("flaw.boardViewInfo", params);
	}

	@Override
	public String getPrjctName(Map<String, String> params) throws Exception {
		return (String) client.queryForObject("flaw.getPrjctName", params);
	}

	@Override
	public List<EmplVO> getPrjctEmpl(Map<String, String> params)
			throws Exception {
		return client.queryForList("flaw.getPrjctEmpl", params);
	}

	@Override
	public List<IpcrVO> getAllIpcr() throws Exception {
		return client.queryForList("flaw.getAllIpcr");
	}

	@Override
	public List<SttusVO> getAllSttus() throws Exception {
		return client.queryForList("flaw.getAllSttus");
	}

	@Override
	public int flawSttusCount(Map<String, String> params) throws Exception {
		return (int) client.queryForObject("flaw.flawSttusCount", params);
	}

	@Override
	public List<FlawVO> selectListSechdul(Map<String, String> params)
			throws Exception {
		return client.queryForList("flaw.selectListSechdul", params);
	}

}
