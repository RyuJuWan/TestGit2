package kr.or.ddit.rqpps.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.RqppsVO;

public interface IRqppsService {
	public List<RqppsVO> rqppsList(Map<String, String> params) throws Exception;
	public RqppsVO rqppsInfo(Map<String, String> params) throws Exception;
	public String insertRqpps(RqppsVO rqppsInfo) throws Exception;
	public void deleteRqpps(Map<String, String> params) throws Exception;
	public void modifyRqpps(RqppsVO rqppsInfo) throws Exception;
	public int totalCount(Map<String, String> params) throws Exception;
	
}
