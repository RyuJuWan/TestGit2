package kr.or.ddit.dynm.dyNotice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.dynm.dyNotice.dao.IDyNoticeDao;
import kr.or.ddit.log.dao.ILogDao;
import kr.or.ddit.notice.dao.INoticeDao;
import kr.or.ddit.vo.DynmNoticeVO;
import kr.or.ddit.vo.NoticeVO;

@Service("dyNoticeService")
public class IDyNoticeServiceImpl implements IDyNoticeService {

	@Autowired
	private IDyNoticeDao dao;
	
	
	@Autowired
	private ILogDao logDao;
	

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<DynmNoticeVO> noticeList(Map<String, String> params) throws Exception {
		return dao.noticeList(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public DynmNoticeVO noticeInfo(Map<String, String> params) throws Exception {
		return dao.noticeInfo(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return dao.totalCount(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public String insertNotice(DynmNoticeVO noticeInfo) throws Exception {
		Map<String, String> params2 = new HashMap<String, String>();
	      params2.put("prjct_id", noticeInfo.getPrjct_id());
	      params2.put("empl_id", noticeInfo.getDynm_notice_empl());
	      params2.put("log_cn", "회의록(" + noticeInfo.getDynm_notice_nm() + ") 수정");
	      logDao.insertLog(params2);
		
		return dao.insertNotice(noticeInfo);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void hit(String notice_id) throws Exception {
		dao.hit(notice_id);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void updateNotice(DynmNoticeVO noticeInfo) throws Exception {
		Map<String, String> params2 = new HashMap<String, String>();
	      params2.put("prjct_id", noticeInfo.getPrjct_id());
	      params2.put("empl_id", noticeInfo.getDynm_notice_empl());
	      params2.put("log_cn", "회의록(" + noticeInfo.getDynm_notice_nm() + ") 수정");
	      logDao.insertLog(params2);
		dao.updateNotice(noticeInfo);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void deleteNotice(Map<String, String> params) throws Exception {
		dao.deleteNotice(params);
	}
	
	
	

}
