package kr.or.ddit.reqre_specf.dao;

import java.util.List;
import java.util.Map;

import javax.naming.NoInitialContextException;

import kr.or.ddit.vo.ReqreSpecfVO;

public interface IReqreSpecfDao {
	public String insertReqreSpecf(ReqreSpecfVO reqreSpecfInfo) throws Exception;
	public String getPrjctName(Map<String, String> params) throws Exception;
	public ReqreSpecfVO reqreSpecfInfo(Map<String, String> params) throws Exception;
	public List<ReqreSpecfVO> reqreSpecfList() throws Exception;
	public void updateReqreSpecf(ReqreSpecfVO reqreSpecfInfo) throws Exception;
	public String getReqreSpecfId(Map<String, String> params) throws Exception;
}
