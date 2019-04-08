package kr.or.ddit.dy_risk.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.IpcrVO;
import kr.or.ddit.vo.RiskVO;
import kr.or.ddit.vo.SttusVO;

public interface IDy_riskDao {
	public void insertBoard(RiskVO riskInfo) throws Exception;
	
	public void updateBoard(RiskVO riskVO) throws Exception;
	
	public int totalCount(Map<String, String> params) throws Exception;
	
	public List<RiskVO> boardList(Map<String, String> params) throws Exception;
	
	public RiskVO boardViewInfo(Map<String, String> params) throws Exception;
	
	public String getPrjctName(Map<String, String> params) throws Exception;
	
	public List<EmplVO> getPrjctEmpl(Map<String, String> params) throws Exception;
	
	public List<IpcrVO> getAllIpcr() throws Exception;
	
	public List<SttusVO> getAllSttus() throws Exception;
}
