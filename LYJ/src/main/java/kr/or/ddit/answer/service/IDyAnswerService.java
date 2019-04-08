package kr.or.ddit.answer.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.AnswerVO;


public interface IDyAnswerService {
	public List<AnswerVO> frbList(Map<String, String> params) throws Exception;
//	public int totalCount(Map<String, String> params) throws Exception;
	public String insertFrb(AnswerVO frbInfo) throws Exception;
	public AnswerVO frbInfo(Map<String, String> params) throws Exception;
	public void deleteFrb(Map<String, String> params) throws Exception;
	public void modifyFrb(AnswerVO frbInfo) throws Exception;
//	public void frbView(Map<String, String> param) throws Exception;
}
