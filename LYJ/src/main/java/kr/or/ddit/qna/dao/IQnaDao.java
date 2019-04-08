package kr.or.ddit.qna.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.QnaVO;

public interface IQnaDao {
	public List<QnaVO> qnaList(Map<String, String> params) throws Exception;
	public int totalCount(Map<String, String> params) throws Exception;
	public QnaVO qnaInfo(Map<String, String> params) throws Exception;
	public String insertQna(QnaVO qnaInfo) throws Exception;
	public void deleteQna(Map<String, String> params) throws Exception;
	public void modifyQna(QnaVO qnaInfo) throws Exception;
	public void qnaView(Map<String, String> param) throws Exception;
	public void insertQnaReply(QnaVO qnaInfo) throws Exception;
	public int groupCount(Map<String,String>params) throws Exception;

}
