package kr.or.ddit.prjct.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.prjct.dao.IPrjctDao;
import kr.or.ddit.vo.PrjctVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("prjctService")
public class IPrjctServiceImpl implements IPrjctService {
	@Autowired
	private IPrjctDao dao;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<PrjctVO> prjctList() throws Exception {
		return dao.prjctList();
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<PrjctVO> currentPrjctList() throws Exception {
		return dao.currentPrjctList();
		
	}
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void insertProject(PrjctVO projectInfo) throws Exception {
		dao.insertProject(projectInfo);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void updateProject(PrjctVO projectInfo) throws Exception {
		dao.updateProject(projectInfo);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public PrjctVO projectInfo(Map<String, String> params) throws Exception {
		return dao.projectInfo(params);
	}

}
