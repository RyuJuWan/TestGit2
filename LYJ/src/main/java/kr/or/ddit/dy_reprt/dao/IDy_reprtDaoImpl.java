package kr.or.ddit.dy_reprt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.vo.ReprtVO;

@Repository("dy_reprtDao")
public class IDy_reprtDaoImpl implements IDy_reprtDao {
	
	@Autowired
	private SqlMapClient client;
	
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return (int) client.queryForObject("reprt.totalCount", params);
	}

	@Override
	public List<ReprtVO> reprtPageList(Map<String, String> params)
			throws Exception {
		return client.queryForList("reprt.reprtPageList", params);
	}

	@Override
	public String insertDy_reprt(ReprtVO reprtInfo) throws Exception {
		return (String) client.insert("reprt.insertDy_reprt", reprtInfo);
	}

	@Override
	public ReprtVO reprtView(Map<String, String> params) throws Exception {
		return (ReprtVO) client.queryForObject("reprt.reprtView", params);
	}

	@Override
	public void updateDy_reprt(ReprtVO reprtInfo) throws Exception {
		client.update("reprt.updateDy_reprt", reprtInfo);
	}

	@Override
	public void deleteReprt(Map<String, String> params) throws Exception {
		client.delete("reprt.deleteReprt", params);
	}

}
