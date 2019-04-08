package kr.or.ddit.tech_class.dao;

import java.util.List;

import kr.or.ddit.vo.TechClassVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository("techClassDao")
public class ITechClassDaoImpl implements ITechClassDao {
	
	@Autowired
	private SqlMapClient client;
	
	@Override
	public List<TechClassVO> techClassList() throws Exception {
		return client.queryForList("techClass.techClassList");
	}

}
