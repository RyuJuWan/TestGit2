package kr.or.ddit.hnfInpt.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.HnfInptPlanVO;
import kr.or.ddit.vo.HnfInptVO;
import kr.or.ddit.vo.PrjctVO;
import kr.or.ddit.vo.PrpslVO;
import kr.or.ddit.vo.SanctnLineVO;
import kr.or.ddit.vo.SanctnPapersTyVO;

import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
@Repository
public class HnfInptDaoImpl implements IHnfInptDao {
	@Autowired
	private SqlMapClient client;
	
	/**
	* 선택한 인원투입계획서의 정보를 가져오는 메서드
	* @param params 선택한 인력투입계획서 리스트의 번호
	* @author 최준열
	* @return 선택한 인원투입계획서의 정보
	* @since 2019.02.20
	* @throws Exception
	*/
	@Override
	public HnfInptVO boardInfo(String boNo) throws Exception {
		client.update("hnfInpt.addHit", Integer.parseInt(boNo));
		return (HnfInptVO) client.queryForObject("hnfInpt.boardInfo", boNo);
	}
	
	/**
	* 인원투입계획서을 추가하는 메서드
	* @param params 인력투입계획서을 추가할 정보들
	* @return 성공여부
	* @author 최준열
	* @since 2019.02.20
	* @throws Exception
	*/
	@Override
	public String insertBoard(HnfInptVO boardVO) throws Exception {
		return (String) client.insert("hnfInpt.insertBoard", boardVO);
	}
	
	/**
	* 인원투입계획서을 수정하는 메서드
	* @param params 인력투입계획서의 수정할 정보들
	* @author 최준열
	* @since 2019.02.20
	* @throws Exception
	*/
	@Override
	public void updateBoard(HnfInptVO boardVO) throws Exception {
		client.update("hnfInpt.updateBoard", boardVO);
	}
	
	/**
	* 인원투입계획서의 전체 확인 수를 수정하는 메서드
	* @param params 인력투입계획서의 관련 정보들
	* @author 최준열
	* @since 2019.02.20
	* @throws Exception
	*/
	@Override
	public int totalCount() throws Exception {
		return (int) client.queryForObject("hnfInpt.totalCount");
	}

	/**
	* 인원투입계획서을 전체 가져오는 메서드
	* @param params 인력투입계획서을 검색할 정보들
	* @author 최준열
	* @return 전체의 인원투입계획서 정보
	* @since 2019.02.20
	* @throws Exception
	*/
	@Override
	public List<HnfInptVO> boardList(Map<String, String> params)
			throws Exception {
		return client.queryForList("hnfInpt.getAllHnfInpt", params);
	}
	
	@Override
	public HnfInptVO boardView(Map<String, String> params) throws Exception {
		return (HnfInptVO) client.queryForObject("hnfInpt.boardView", params);
	}

	/**
	* 인원투입계획서을 자료와 함께 추가하는 메서드
	* @param board 인원투입게획서를 추가할 정보
	* @param items 추가할 자료
	* @author 최준열
	* @since 2019.02.20
	* @throws Exception
	*/
	@Override
	public String insertBoard(HnfInptVO board, FileItem item)
			throws Exception {
		return (String) client.insert("hnfInpt.insertHnfInpt", board);
	}

	/**
	* 인원투입계획서의 확인 수를 추가하는 메서드
	* @param params 인력투입계획서의 관련 정보들
	* @author 최준열
	* @since 2019.02.20
	* @throws Exception
	*/
	@Override
	public void boardHit(HnfInptVO param) throws Exception {
		client.update("hnfInpt.plusHit", param);
	}

	@Override
	public int totalCount_plan() throws Exception {
		return (int) client.queryForObject("hnfInpt.totalCount_plan");
	}

	@Override
	public List<PrjctVO> getAllPrjct() throws Exception {
		return client.queryForList("hnfInpt.getAllPrjct");
	}
	
	@Override
	public List<PrpslVO> getAllPrpsl() throws Exception {
		return client.queryForList("hnfInpt.getAllPrpsl");
	}

	@Override
	public List<SanctnLineVO> getAllSanctn_Line() throws Exception {
		return client.queryForList("hnfInpt.getAllSanctn_Line");
	}

	@Override
	public List<SanctnPapersTyVO> getAllSanctn_Papers_Ty() throws Exception {
		return client.queryForList("hnfInpt.getAllSanctn_Papers_Ty");
	}

	@Override
	public List<HnfInptPlanVO> getAllHnfInptPlanList() throws Exception {
		return client.queryForList("hnfInpt.getAllHnfInptPlanList");
	}

	@Override
	public String getPrjctName(Map<String, String> params) throws Exception {
		return (String) client.queryForObject("hnfInpt.getPrjctName", params);
	}

}
