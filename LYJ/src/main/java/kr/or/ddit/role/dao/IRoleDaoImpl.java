package kr.or.ddit.role.dao;

import java.util.List;

import kr.or.ddit.vo.RoleVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository("roleDao")
public class IRoleDaoImpl implements IRoleDao {
	
	@Autowired
	private SqlMapClient client;
	
	@Override
	public List<RoleVO> roleList() throws Exception {
		return client.queryForList("role.roleList");
	}
	
}
