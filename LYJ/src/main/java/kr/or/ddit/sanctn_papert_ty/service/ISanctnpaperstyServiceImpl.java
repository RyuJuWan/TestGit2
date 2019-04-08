package kr.or.ddit.sanctn_papert_ty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.sanctn_papert_ty.dao.ISanctnpaperstyDao;
import kr.or.ddit.vo.SanctnPapersTyVO;

@Service("sanctnpapersty")
public class ISanctnpaperstyServiceImpl implements ISanctnpaperstyService{
	@Autowired
	private ISanctnpaperstyDao dao;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<SanctnPapersTyVO> sanctnpaperstyList(Map<String, String> params)
			throws Exception {
		return dao.sanctnpaperstyList(params);
	}
	
}
