package kr.or.ddit.expndtr_anact.dao;

import java.util.List;
import java.util.Map;












import kr.or.ddit.vo.ExpndtrAnactVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;












import com.ibatis.sqlmap.client.SqlMapClient;

@Repository("expndtrAnactDao")
public class IExpndtrAnactDaoImpl implements IExpndtrAnactDao {
	
	@Autowired
	private SqlMapClient client;

	@Override
	public List<ExpndtrAnactVO> expndtrAnactList(Map<String, String> params)
			throws Exception {
		return client.queryForList("expndtrAnact.expndtrAnactList",params);
	}

	@Override
	public ExpndtrAnactVO expndtrAnactInfo(Map<String, String> params)
			throws Exception {
		return (ExpndtrAnactVO) client.queryForObject("expndtrAnact.expndtrAnactInfo", params);
	}

	@Override
	public String insertExpndtrAnact(ExpndtrAnactVO expndtrAnactInfo)
			throws Exception {
		return (String) client.insert("expndtrAnact.insertExpndtrAnact", expndtrAnactInfo);
	}

	@Override
	public void updateExpndtrAnact(ExpndtrAnactVO expndtrAnactInfo)
			throws Exception {
		 client.update("expndtrAnact.updateExpndtrAnact",expndtrAnactInfo);
	}

	@Override
	public void deleteExpndtrAnact(Map<String, String> params) throws Exception {
		client.delete("expndtrAnact.deleteExpndtrAnact",params);		
	}

	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return (int) client.queryForObject("expndtrAnact.totalCount",params);
	}




}
