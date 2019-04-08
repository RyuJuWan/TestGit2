package kr.or.ddit.hnfInpt.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.HnfInptPlanVO;
import kr.or.ddit.vo.HnfInptVO;
import kr.or.ddit.vo.PrjctVO;
import kr.or.ddit.vo.PrpslVO;
import kr.or.ddit.vo.SanctnLineVO;
import kr.or.ddit.vo.SanctnPapersTyVO;


public interface IHnfInptService {
	public HnfInptVO boardInfo(String boNo) throws Exception;
	
	public String insertBoard(HnfInptVO boardVO) throws Exception;
	
	public void updateBoard(HnfInptVO boardVO, Map<String, String> params) throws Exception;
	
	public int totalCount() throws Exception;
	
	public List<HnfInptVO> boardList(Map<String, String> params) throws Exception;
	
	public HnfInptVO boardView(Map<String, String> params) throws Exception;
	
	public int totalCount_plan() throws Exception;
	
	public List<PrjctVO> getAllPrjct() throws Exception;
	
	public List<PrpslVO> getAllPrpsl() throws Exception;
	
	public List<SanctnLineVO> getAllSanctn_Line() throws Exception;
	
	public List<SanctnPapersTyVO> getAllSanctn_Papers_Ty() throws Exception;
	
	public List<HnfInptPlanVO> getAllHnfInptPlanList() throws Exception;
	
	public String getPrjctName(Map<String, String> params);
}
