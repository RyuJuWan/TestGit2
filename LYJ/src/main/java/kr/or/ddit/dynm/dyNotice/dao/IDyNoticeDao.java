package kr.or.ddit.dynm.dyNotice.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.DynmNoticeVO;

public interface IDyNoticeDao {
	public List<DynmNoticeVO> noticeList(Map<String, String> params) throws Exception;
	public int totalCount(Map<String, String> params) throws Exception;
	public DynmNoticeVO noticeInfo(Map<String, String> params ) throws Exception;
	public String insertNotice(DynmNoticeVO noticeInfo) throws Exception;
	public void hit(String notice_id) throws Exception;
	public void updateNotice(DynmNoticeVO noticeInfo) throws Exception;
	public void deleteNotice(Map<String, String> params) throws Exception;
	
}
