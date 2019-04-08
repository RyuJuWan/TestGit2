package kr.or.ddit.frb.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.vo.FrbVO;

@Repository("frbDao")
public class IFrbDaoImpl implements IFrbDao{
	@Autowired
	private SqlMapClient client;
	
	@Override
	public List<FrbVO> frbList(Map<String, String> params) throws Exception {
		return client.queryForList("frb.frbList", params);
	}

	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return (int) client.queryForObject("frb.totalCount", params);
	}

	@Override
	public String insertFrb(FrbVO frbInfo) throws Exception {
		return (String) client.insert("frb.insertFrb", frbInfo);
	}

	@Override
	public FrbVO frbInfo(Map<String, String> params) throws Exception {
		return (FrbVO) client.queryForObject("frb.frbInfo", params);
	}

	@Override
	public void deleteFrb(Map<String, String> params) throws Exception {
		client.update("frb.deleteFrb", params);
	}

	@Override
	public void modifyFrb(FrbVO frbInfo) throws Exception {
		client.update("frb.modifyFrb", frbInfo);
	}

	@Override
	public void frbView(Map<String, String> param) throws Exception {
		client.update("frb.frbView", param);
	}
}
