package kr.or.ddit.notice.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.NoticeVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;


@Repository("noticeDao")
public class INoticeDaoImpl implements INoticeDao {

   @Autowired
   private SqlMapClient client;

   @Override
   public List<NoticeVO> noticeList(Map<String, String> params) throws Exception {
      return client.queryForList("notice.noticeList",params);
   }

   @Override
   public NoticeVO noticeInfo(Map<String, String> params) throws Exception {
      return (NoticeVO) client.queryForObject("notice.noticeInfo", params);
   }

   @Override
   public int totalCount(Map<String, String> params) throws Exception {
      return (int) client.queryForObject("notice.totalCount", params);
   }

   @Override
   public String insertNotice(NoticeVO noticeInfo) throws Exception {
      return (String) client.insert("notice.insertNotice", noticeInfo);
   }

   @Override
   public void hit(String notice_id) throws Exception {
      client.update("notice.hit", notice_id);
   }

   @Override
   public void updateNotice(NoticeVO noticeInfo) throws Exception {
      client.update("notice.updateNotice", noticeInfo);
   }

   @Override
   public void deleteNotice(Map<String, String> params) throws Exception {
      client.update("notice.deleteNotice", params);
   }
   

}