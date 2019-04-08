package kr.or.ddit.dy_flaw.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.FlawVO;
import kr.or.ddit.vo.IpcrVO;
import kr.or.ddit.vo.SttusVO;

public interface IDy_flawDao {
	public void insertBoard(FlawVO flawInfo) throws Exception;
	
	public void updateBoard(FlawVO flawInfo) throws Exception;
	
	public int totalCount(Map<String, String> params) throws Exception;
	
	public List<FlawVO> boardList(Map<String, String> params) throws Exception;
	
	public FlawVO boardViewInfo(Map<String, String> params) throws Exception;
	
	public String getPrjctName(Map<String, String> params) throws Exception;
	
	public List<EmplVO> getPrjctEmpl(Map<String, String> params) throws Exception;
	
	public List<IpcrVO> getAllIpcr() throws Exception;
	
	public List<SttusVO> getAllSttus() throws Exception;
	
	public int flawSttusCount(Map<String, String> params) throws Exception;
	
	public List<FlawVO> selectListSechdul(Map<String, String> params) throws Exception;
}
