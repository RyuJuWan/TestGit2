package kr.or.ddit.dept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.dept.dao.IDeptDao;
import kr.or.ddit.vo.DeptVO;

@Service("deptService")
public class IDeptServiceImpl implements IDeptService {
	
	@Autowired
	private IDeptDao dao;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<DeptVO> deptList() throws Exception {
		return dao.deptList();
	}

}
