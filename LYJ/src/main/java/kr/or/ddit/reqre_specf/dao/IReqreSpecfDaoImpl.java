package kr.or.ddit.reqre_specf.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ReqreSpecfVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sun.misc.Cleaner;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository("reqreSpecfDao")
public class IReqreSpecfDaoImpl implements IReqreSpecfDao {
	
	@Autowired
	private SqlMapClient client;

	@Override
	public String insertReqreSpecf(ReqreSpecfVO reqreSpecfInfo)
			throws Exception {
		return (String) client.insert("reqreSpecf.insertReqreSpecf",reqreSpecfInfo);
	}

	@Override
	public String getPrjctName(Map<String, String> params) throws Exception {
		return (String) client.queryForObject("reqreSpecf.getPrjctName", params);
	}

	@Override
	public ReqreSpecfVO reqreSpecfInfo(Map<String, String> params)
			throws Exception {
		return (ReqreSpecfVO) client.queryForObject("reqreSpecf.reqreSpecfInfo",params);
	}

	@Override
	public List<ReqreSpecfVO> reqreSpecfList() throws Exception {
		return client.queryForList("reqreSpecf.reqreSpecfList");
	}

	@Override
	public void updateReqreSpecf(ReqreSpecfVO reqreSpecfInfo) throws Exception {
		client.update("reqreSpecf.updateReqreSpecf",reqreSpecfInfo);
	}

	@Override
	public String getReqreSpecfId(Map<String, String> params) throws Exception {
		return (String) client.queryForObject("reqreSpecf.getReqreSpecfId", params);
	}
	

}
