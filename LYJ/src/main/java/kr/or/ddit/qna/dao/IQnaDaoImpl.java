package kr.or.ddit.qna.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.vo.QnaVO;

@Repository("qnaDao")
public class IQnaDaoImpl implements IQnaDao{
	@Autowired
	private SqlMapClient client;

	@Override
	public List<QnaVO> qnaList(Map<String, String> params) throws Exception {
		return client.queryForList("qna.qnaList", params);
	}

	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return (int) client.queryForObject("qna.totalCount", params);
	}

	@Override
	public QnaVO qnaInfo(Map<String, String> params) throws Exception {
		return (QnaVO) client.queryForObject("qna.qnaInfo", params);
	}

	@Override
	public String insertQna(QnaVO qnaInfo) throws Exception {
		return (String) client.insert("qna.insertQna", qnaInfo);
	}

	@Override
	public void deleteQna(Map<String, String> params) throws Exception {
		client.update("qna.deleteQna", params);
	}

	@Override
	public void modifyQna(QnaVO qnaInfo) throws Exception {
		client.update("qna.modifyQna", qnaInfo);
	}

	@Override
	public void qnaView(Map<String, String> param) throws Exception {
		client.update("qna.qnaView", param);
	}

	@Override
	public void insertQnaReply(QnaVO qnaInfo) throws Exception {
		qnaInfo.getQna_seq();
		String qna_id = qnaInfo.getQna_id();
			String qna_seq;
			if("0".intern() == qnaInfo.getQna_seq().intern()){
				qna_seq = (String) client.queryForObject("qna.incrementSeq", qnaInfo);
			}else{
				client.update("qna.updateSeq", qnaInfo);
				qna_seq = String.valueOf(Integer.parseInt(qnaInfo.getQna_seq()) + 1);
			}
			
			qnaInfo.setQna_seq(qna_seq);
			String qna_dep = String.valueOf(Integer.parseInt(qnaInfo.getQna_dep()) + 1);
			qnaInfo.setQna_dep(qna_dep);
			
			client.insert("qna.insertQnaReply", qnaInfo);
			
	}

	@Override
	public int groupCount(Map<String, String> params) throws Exception {
		return (int) client.queryForObject("qna.qnagroupCount", params);
	}

}
