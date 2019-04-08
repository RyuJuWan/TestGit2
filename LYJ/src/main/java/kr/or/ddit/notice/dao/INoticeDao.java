package kr.or.ddit.notice.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.RqppsVO;

public interface INoticeDao {
	public List<NoticeVO> noticeList(Map<String, String> params) throws Exception;
	public int totalCount(Map<String, String> params) throws Exception;
	public NoticeVO noticeInfo(Map<String, String> params ) throws Exception;
	public String insertNotice(NoticeVO noticeInfo) throws Exception;
	public void hit(String notice_id) throws Exception;
	public void updateNotice(NoticeVO noticeInfo) throws Exception;
	public void deleteNotice(Map<String, String> params) throws Exception;
	
}
