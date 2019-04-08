package kr.or.ddit.dept.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.vo.DeptVO;

@Repository("deptDao")
public class IDeptDaoImpl implements IDeptDao {
	
	@Autowired
	private SqlMapClient client;
	
	@Override
	public List<DeptVO> deptList() throws Exception {
		return client.queryForList("dept.deptList");
	}

}
