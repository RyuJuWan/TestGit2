package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.vo.AdminVO;
import kr.or.ddit.vo.EmplVO;

@Service("memberService")
public class IMemberServiceImpl implements IMemberService {
	
	@Autowired
	private IMemberDao dao;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public AdminVO adminInfo(Map<String, String> params) throws Exception {
		return dao.adminInfo(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public EmplVO emplInfo(Map<String, String> params) throws Exception {
		return dao.emplInfo(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void updateEmplInfo(EmplVO emplInfo) throws Exception {
		dao.updateEmplInfo(emplInfo);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<EmplVO> emplPageList(Map<String, String> params) throws Exception {
		return dao.emplPageList(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return dao.totalCount(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void insertEmpl(EmplVO emplInfo) throws Exception {
		dao.insertEmpl(emplInfo);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<EmplVO> selectDeptEmpl(Map<String, String> params)
			throws Exception {
		return dao.selectDeptEmpl(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<EmplVO> emplList() throws Exception {
		return dao.emplList();
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<EmplVO> selectPrjctEmpl(Map<String, String> params)
			throws Exception {
		return dao.selectPrjctEmpl(params);
	}

}
