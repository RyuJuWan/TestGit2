package kr.or.ddit.dynm.dyWbs.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.IpcrVO;
import kr.or.ddit.vo.SmlCatVO;
import kr.or.ddit.vo.SttusVO;
import kr.or.ddit.vo.WBSVO;
import kr.or.ddit.vo.WorkTyVO;

public interface IDyWbsDao {
	public String insertBoard(WBSVO flawInfo) throws Exception;
	
	public void updateBoard(WBSVO flawInfo) throws Exception;
	
	public int totalCount(Map<String, String> params) throws Exception;
	
	public List<WBSVO> boardList(Map<String, String> params) throws Exception;
	
	public WBSVO boardViewInfo(Map<String, String> params) throws Exception;
	
	public String getPrjctName(Map<String, String> params) throws Exception;
	
	public List<EmplVO> getPrjctEmpl(Map<String, String> params) throws Exception;
	
	public List<IpcrVO> getAllIpcr() throws Exception;
	
	public List<SttusVO> getAllSttus() throws Exception;
	
	public List<SmlCatVO> getSmlCat() throws Exception;
	
	public List<WorkTyVO> getWorkTy() throws Exception;
	
	public List<WBSVO> wbsListByPrjctID(Map<String, String> params)throws Exception;
	
	public int wbsSttusCount(Map<String, String> params) throws Exception;
}
