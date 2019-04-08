package kr.or.ddit.crqfc.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.CrqfcHoldVO;
import kr.or.ddit.vo.CrqfcVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository("crqfcDao")
public class ICrqfcDaoImpl implements ICrqfcDao {
	
	@Autowired
	private SqlMapClient client;
	
	@Override
	public List<CrqfcVO> crqfcList() throws Exception {
		return client.queryForList("crqfc.crqfcList");
	}

	@Override
	public List<CrqfcHoldVO> crqfcHoldPageList(Map<String, String> params)
			throws Exception {
		return client.queryForList("crqfc.crqfcHoldPageList", params);
	}

	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return (int) client.queryForObject("crqfc.totalCount", params);
	}

	@Override
	public void insertCrqfcHold(CrqfcHoldVO crqfcHoldInfo) throws Exception {
		client.insert("crqfc.insertCrqfcHold", crqfcHoldInfo);
	}

	@Override
	public List<CrqfcHoldVO> crqfcHoldList(Map<String, String> params)
			throws Exception {
		return client.queryForList("crqfc.crqfcHoldList", params);
	}

	@Override
	public void deleteCrqfcHold(CrqfcHoldVO crqfcHoldInfo) throws Exception {
		client.delete("crqfc.deleteCrqfcHold", crqfcHoldInfo);
	}

}
