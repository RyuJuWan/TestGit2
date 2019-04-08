package kr.or.ddit.sanctn_line.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.vo.SanctnLineVO;

@Repository("sanctnlineDao")
public class ISanctnlineDaoImpl implements ISanctnlineDao{
	@Autowired
	private SqlMapClient client;
	
	@Override
	public List<SanctnLineVO> sanctnlineList(Map<String, String> params)
			throws Exception {
		return client.queryForList("sanctnline.sanctnlineList", params);
	}

}
