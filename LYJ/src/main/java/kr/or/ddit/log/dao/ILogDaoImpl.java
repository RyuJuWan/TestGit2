package kr.or.ddit.log.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.LogVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository("logDao")
public class ILogDaoImpl implements ILogDao {
	
	@Autowired
	private SqlMapClient client;
	
	@Override
	public List<LogVO> prjctLogList(Map<String, String> params) throws Exception {
		return client.queryForList("log.prjctLogList", params);
	}

	@Override
	public void deleteAllLog() throws Exception {
		client.delete("log.deleteAllLog");
	}

	@Override
	public void insertLog(Map<String, String> params) throws Exception {
		client.insert("log.insertLog", params);
	}

}
