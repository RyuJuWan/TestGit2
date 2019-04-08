package kr.or.ddit.ofcps.dao;

import java.util.List;

import kr.or.ddit.vo.OfcpsVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository("ofcpsDao")
public class IOfcpsDaoImpl implements IOfcpsDao {
	
	@Autowired
	private SqlMapClient client;

	@Override
	public List<OfcpsVO> ofcpsList() throws Exception {
		return client.queryForList("ofcps.ofcpsList");
	}
}
