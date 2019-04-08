package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.vo.AdminVO;
import kr.or.ddit.vo.EmplVO;

@Repository("memberDao")
public class IMemberDaoImpl implements IMemberDao {
	@Autowired
	private SqlMapClient client;
	
	@Override
	public AdminVO adminInfo(Map<String, String> params) throws Exception {
		return (AdminVO) client.queryForObject("member.adminInfo", params);
	}

	@Override
	public EmplVO emplInfo(Map<String, String> params) throws Exception{
		return (EmplVO) client.queryForObject("member.emplInfo", params);
	}

	@Override
	public void updateEmplInfo(EmplVO emplInfo) throws Exception {
		client.update("member.updateEmplInfo", emplInfo);
	}

	@Override
	public List<EmplVO> emplPageList(Map<String, String> params)
			throws Exception {
		return client.queryForList("member.emplPageList", params);
	}

	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return (int) client.queryForObject("member.totalCount", params);
	}

	@Override
	public void insertEmpl(EmplVO emplInfo) throws Exception {
		client.insert("member.insertEmpl", emplInfo);
	}

	@Override
	public List<EmplVO> selectDeptEmpl(Map<String, String> params)
			throws Exception {
		return client.queryForList("member.selectDeptEmpl", params);
	}

	@Override
	public List<EmplVO> emplList() throws Exception {
		return client.queryForList("member.emplList");
	}

	@Override
	public List<EmplVO> selectPrjctEmpl(Map<String, String> params)
			throws Exception {
		return client.queryForList("member.selectPrjctEmpl",params);
	}

}
