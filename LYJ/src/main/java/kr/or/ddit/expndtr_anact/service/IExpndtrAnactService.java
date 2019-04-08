package kr.or.ddit.expndtr_anact.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ExpndtrAnactVO;
import kr.or.ddit.vo.ReqreSpecfVO;

public interface IExpndtrAnactService {
	public List<ExpndtrAnactVO> expndtrAnactList(Map<String, String> params) throws Exception;
	public ExpndtrAnactVO expndtrAnactInfo(Map<String, String > params) throws Exception;
	public String insertExpndtrAnact(ExpndtrAnactVO expndtrAnactInfo) throws Exception;
	public void updateExpndtrAnact(ExpndtrAnactVO expndtrAnactInfo, Map<String, String> params) throws Exception;
	public void deleteExpndtrAnact(Map<String, String> params) throws Exception;
	public int totalCount(Map<String, String> params) throws Exception;
}
