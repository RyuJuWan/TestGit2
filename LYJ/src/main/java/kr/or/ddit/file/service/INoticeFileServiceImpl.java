package kr.or.ddit.file.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.file.dao.ExpndtrAnactFileDao;
import kr.or.ddit.file.dao.NoticeFileDao;
import kr.or.ddit.vo.ExpndtrAnactFileVO;
import kr.or.ddit.vo.NoticeFileVO;
import kr.or.ddit.vo.NoticeVO;

@Service
public class INoticeFileServiceImpl implements NoticeFileService{
	
	@Autowired
	private NoticeFileDao dao;

	@Override
	public void insertNoticeFile(NoticeFileVO noticeFileInfo)  {
		try {
			dao.insertNoticeFile(noticeFileInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<NoticeFileVO> noticeFileList(Map<String, String> params)
			throws Exception {
		return null;
	}

	@Override
	public NoticeFileVO fileItemInfo(Map<String, String> params)
			 {
		NoticeFileVO noticeFileInfo = null;
		try {
			noticeFileInfo = dao.fileItemInfo(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticeFileInfo;
	}

	@Override
	public void updateNoticeFile(NoticeFileVO noticeFileInfo) {
		try {
			dao.updateNoticeFile(noticeFileInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int noticeFileListSize() throws Exception {
		return dao.noticeFileListSize();
	}


	

}
