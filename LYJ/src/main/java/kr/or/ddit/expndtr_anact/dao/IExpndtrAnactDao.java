package kr.or.ddit.expndtr_anact.dao;

import java.util.List;
import java.util.Map;

import javax.naming.NoInitialContextException;

import sun.security.util.PropertyExpander.ExpandException;
import kr.or.ddit.vo.ExpndtrAnactVO;
import kr.or.ddit.vo.ReqreSpecfVO;

public interface IExpndtrAnactDao {
	public List<ExpndtrAnactVO> expndtrAnactList(Map<String, String> params) throws Exception;
	public ExpndtrAnactVO expndtrAnactInfo(Map<String, String > params) throws Exception;
	public String insertExpndtrAnact(ExpndtrAnactVO expndtrAnactInfo) throws Exception;
	public void updateExpndtrAnact(ExpndtrAnactVO expndtrAnactInfo) throws Exception;
	public void deleteExpndtrAnact(Map<String, String> params) throws Exception;
	public int totalCount(Map<String, String> params) throws Exception;
} 
