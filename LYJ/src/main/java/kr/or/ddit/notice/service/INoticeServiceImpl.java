package kr.or.ddit.notice.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.file.dao.NoticeFileDao;
import kr.or.ddit.notice.dao.INoticeDao;
import kr.or.ddit.utils.NoticeAttachFileMapper;
import kr.or.ddit.vo.NoticeFileVO;
import kr.or.ddit.vo.NoticeVO;

@Service("noticeService")
public class INoticeServiceImpl implements INoticeService {

	@Autowired
	private INoticeDao dao;
		
	@Autowired
	private NoticeFileDao itemDao;
	
	@Autowired
	private NoticeAttachFileMapper fileMapper;
	

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<NoticeVO> noticeList(Map<String, String> params) throws Exception {
		return dao.noticeList(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public NoticeVO noticeInfo(Map<String, String> params) throws Exception {
		return dao.noticeInfo(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return dao.totalCount(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public String insertNotice(NoticeVO noticeInfo) throws Exception {
		dao.insertNotice(noticeInfo);
		String bo_id = noticeInfo.getNotice_id();
		NoticeFileVO noticeFileInfo = fileMapper.mapping(noticeInfo.getFileitem(), bo_id);
		if(noticeFileInfo != null) {
			itemDao.insertNoticeFile(noticeFileInfo);
		}
		return bo_id;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void hit(String notice_id) throws Exception {
		dao.hit(notice_id);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void updateNotice(NoticeVO noticeInfo, Map<String, String> params) throws Exception {
		String notice = noticeInfo.getNotice_id();
		NoticeFileVO getfileItem = itemDao.fileItemInfo(params);
		NoticeFileVO noticeFileInfo = null;
		
		if(getfileItem == null ){
			noticeFileInfo = fileMapper.mapping(noticeInfo.getFileitem(), notice);
			if(noticeFileInfo != null ){
				itemDao.insertNoticeFile(noticeFileInfo);
			}
		}else{
			noticeFileInfo =fileMapper.updateMapping(noticeInfo.getFileitem(), getfileItem);
			itemDao.updateNoticeFile(noticeFileInfo);
		}
		
		dao.updateNotice(noticeInfo);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void deleteNotice(Map<String, String> params) throws Exception {
		dao.deleteNotice(params);
	}
	
	
	

}
