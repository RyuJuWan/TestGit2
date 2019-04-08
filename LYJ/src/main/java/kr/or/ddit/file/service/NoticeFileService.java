package kr.or.ddit.file.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ExpndtrAnactFileVO;
import kr.or.ddit.vo.NoticeFileVO;
import kr.or.ddit.vo.NoticeVO;

public interface NoticeFileService {
	public void insertNoticeFile(NoticeFileVO noticeFileInfo) throws Exception;
	
	public List<NoticeFileVO> noticeFileList(Map<String, String> params) throws Exception;
	
	public NoticeFileVO fileItemInfo(Map<String, String> params) throws Exception;
	
	public void updateNoticeFile(NoticeFileVO noticeFileInfo) throws Exception;
	
	public int noticeFileListSize() throws Exception;
}
