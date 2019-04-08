package kr.or.ddit.dynm.dyNotice.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.DynmNoticeVO;
import kr.or.ddit.vo.NoticeVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;


@Repository("dyNoticeDao")
public class IDyNoticeDaoImpl implements IDyNoticeDao {

	@Autowired
	private SqlMapClient client;

	@Override
	public List<DynmNoticeVO> noticeList(Map<String, String> params) throws Exception {
		return client.queryForList("dyNotice.noticeList",params);
	}

	@Override
	public DynmNoticeVO noticeInfo(Map<String, String> params) throws Exception {
		return (DynmNoticeVO) client.queryForObject("dyNotice.noticeInfo", params);
	}

	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return (int) client.queryForObject("dyNotice.totalCount", params);
	}

	@Override
	public String insertNotice(DynmNoticeVO noticeInfo) throws Exception {
		return (String) client.insert("dyNotice.insertNotice", noticeInfo);
	}

	@Override
	public void hit(String notice_id) throws Exception {
		client.update("dyNotice.hit", notice_id);
	}

	@Override
	public void updateNotice(DynmNoticeVO noticeInfo) throws Exception {
		client.update("dyNotice.updateNotice", noticeInfo);
	}

	@Override
	public void deleteNotice(Map<String, String> params) throws Exception {
		client.update("dyNotice.deleteNotice", params);
	}
	

}
