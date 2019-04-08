package kr.or.ddit.answer.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.AnswerVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;


@Repository("dyAnswerDao")
public class IDyAnswerDaoImpl implements IDyAnswerDao{
	@Autowired
	private SqlMapClient client;
	
	@Override
	public List<AnswerVO> frbList(Map<String, String> params) throws Exception {
		return client.queryForList("answer.answList", params);
	}

//	@Override
//	public int totalCount(Map<String, String> params) throws Exception {
//		return (int) client.queryForObject("answer.totalCount", params);
//	}

	@Override
	public String insertFrb(AnswerVO frbInfo) throws Exception {
		return (String) client.insert("answer.insertAnsw", frbInfo);
	}

	@Override
	public AnswerVO frbInfo(Map<String, String> params) throws Exception {
		return (AnswerVO) client.queryForObject("answer.answInfo", params);
	}

	@Override
	public void deleteFrb(Map<String, String> params) throws Exception {
		client.update("answer.deleteAnsw", params);
	}

	@Override
	public void modifyFrb(AnswerVO frbInfo) throws Exception {
		client.update("answer.modifyAnsw", frbInfo);
	}

//	@Override
//	public void frbView(Map<String, String> param) throws Exception {
//		client.update("answer.frbView", param);
//	}
}
