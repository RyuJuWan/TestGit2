package kr.or.ddit.role.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.role.dao.IRoleDao;
import kr.or.ddit.vo.RoleVO;

@Service("roleService")
public class IRoleServiceImpl implements IRoleService {
	
	@Autowired
	private IRoleDao dao;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<RoleVO> roleList() throws Exception {
		return dao.roleList();
	}

}
