package kr.or.ddit.sanctn_line.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.sanctn_line.dao.ISanctnlineDao;
import kr.or.ddit.vo.SanctnLineVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("sanctnline")
public class ISanctnlineServiceImpl implements ISanctnlineService{
	@Autowired
	private ISanctnlineDao dao;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<SanctnLineVO> sanctnlineList(Map<String, String> params)
			throws Exception {
		return dao.sanctnlineList(params);
	}

}
