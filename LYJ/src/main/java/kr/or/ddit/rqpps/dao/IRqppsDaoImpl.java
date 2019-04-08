package kr.or.ddit.rqpps.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.vo.RqppsVO;

@Repository("rqppsDao")
public class IRqppsDaoImpl implements IRqppsDao{
	@Autowired
	private SqlMapClient client;

	@Override
	public List<RqppsVO> rqppsList(Map<String, String> params) throws Exception {
		return client.queryForList("rqpps.rqppsList", params);
	}

	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return (int) client.queryForObject("rqpps.totalCount", params);
	}

	@Override
	public RqppsVO rqppsInfo(Map<String, String> params) throws Exception {
		return (RqppsVO) client.queryForObject("rqpps.rqppsInfo", params);
	}

	@Override
	public String insertRqpps(RqppsVO rqppsInfo) throws Exception {
		return (String) client.insert("rqpps.insertRqpps", rqppsInfo);
	}


	@Override
	public void modifyRqpps(RqppsVO rqppsInfo) throws Exception {
		client.update("rqpps.modifyRqpps", rqppsInfo);
	}

	@Override
	public void deleteRqpps(Map<String, String> params) throws Exception {
		client.delete("rqpps.deleteRqpps", params);
	}

}
