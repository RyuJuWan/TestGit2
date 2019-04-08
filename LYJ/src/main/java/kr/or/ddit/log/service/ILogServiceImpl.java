package kr.or.ddit.log.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.log.dao.ILogDao;
import kr.or.ddit.vo.LogVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("logService")
public class ILogServiceImpl implements ILogService {
	
	@Autowired
	private ILogDao dao;
	
	@Override
	public List<LogVO> prjctLogList(Map<String, String> params) throws Exception {
		return dao.prjctLogList(params);
	}
	
	@Override
	public void deleteAllLog() throws Exception {
		dao.deleteAllLog();
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void insertLog(Map<String, String> params) throws Exception {
		dao.insertLog(params);
	}

}
