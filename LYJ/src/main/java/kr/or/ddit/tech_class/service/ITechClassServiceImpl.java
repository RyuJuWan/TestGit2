package kr.or.ddit.tech_class.service;

import java.util.List;

import kr.or.ddit.tech_class.dao.ITechClassDao;
import kr.or.ddit.vo.TechClassVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("techClassService")
public class ITechClassServiceImpl implements ITechClassService {
	
	@Autowired
	private ITechClassDao dao;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<TechClassVO> techClassList() throws Exception {
		return dao.techClassList();
	}

}
