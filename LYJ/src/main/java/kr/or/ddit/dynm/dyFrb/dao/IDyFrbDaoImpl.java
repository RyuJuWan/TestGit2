package kr.or.ddit.dynm.dyFrb.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.vo.DynmFrbVO;

@Repository("dy_frbDao")
public class IDyFrbDaoImpl implements IDyFrbDao{
	@Autowired
	private SqlMapClient client;
	
	@Override
	public List<DynmFrbVO> frbList(Map<String, String> params) throws Exception {
		return client.queryForList("dyFrb.frbList", params);
	}

	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return (int) client.queryForObject("dyFrb.totalCount", params);
	}

	@Override
	public String insertFrb(DynmFrbVO frbInfo) throws Exception {
		return (String) client.insert("dyFrb.insertFrb", frbInfo);
	}

	@Override
	public DynmFrbVO frbInfo(Map<String, String> params) throws Exception {
		return (DynmFrbVO) client.queryForObject("dyFrb.frbInfo", params);
	}

	@Override
	public void deleteFrb(Map<String, String> params) throws Exception {
		client.update("dyFrb.deleteFrb", params);
	}

	@Override
	public void modifyFrb(DynmFrbVO frbInfo) throws Exception {
		client.update("dyFrb.modifyFrb", frbInfo);
	}

	@Override
	public void frbView(Map<String, String> param) throws Exception {
		client.update("dyFrb.frbView", param);
	}
}
