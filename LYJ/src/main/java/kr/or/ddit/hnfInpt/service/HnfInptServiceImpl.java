package kr.or.ddit.hnfInpt.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.file.dao.IHnfInptFileDao;
import kr.or.ddit.hnfInpt.dao.IHnfInptDao;
import kr.or.ddit.utils.HnfInptAttachFileMapper;
import kr.or.ddit.vo.HnfInptFileVO;
import kr.or.ddit.vo.HnfInptPlanVO;
import kr.or.ddit.vo.HnfInptVO;
import kr.or.ddit.vo.PrjctVO;
import kr.or.ddit.vo.PrpslVO;
import kr.or.ddit.vo.SanctnLineVO;
import kr.or.ddit.vo.SanctnPapersTyVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import sun.org.mozilla.javascript.internal.regexp.SubString;
@Service
public class HnfInptServiceImpl implements IHnfInptService {
	@Autowired
	private IHnfInptDao dao;
	
	@Autowired
	private IHnfInptFileDao itemDao;
	
	@Autowired
	private HnfInptAttachFileMapper fileMapper;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public HnfInptVO boardInfo(String boNo) throws Exception {
		return dao.boardInfo(boNo);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public String insertBoard(HnfInptVO boardVO) throws Exception {
		String bo_id = dao.insertBoard(boardVO);
		HnfInptFileVO hnfInptFileInfo = fileMapper.mapping(boardVO.getFileitem(), bo_id);
		if(hnfInptFileInfo != null){
			itemDao.insertHnfInptFile(hnfInptFileInfo);			
		}
		return bo_id;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void updateBoard(HnfInptVO boardVO, Map<String, String> params) throws Exception {
		String hnf_inpt = boardVO.getHnf_inpt_actpln_id();
		HnfInptFileVO getfileItem = itemDao.fileItemInfo(params);
		HnfInptFileVO hnfInptFileInfo = null;
		
		if(getfileItem == null){
			hnfInptFileInfo = fileMapper.mapping(boardVO.getFileitem(), hnf_inpt);
			if(hnfInptFileInfo != null){
				itemDao.insertHnfInptFile(hnfInptFileInfo);
			}
		} else{
			hnfInptFileInfo = fileMapper.updateMapping(boardVO.getFileitem(), getfileItem);
			itemDao.updateHnfInptFile(hnfInptFileInfo);
		}
		
		String inpt = (boardVO.getHnf_inpt_actpln_inpt()).substring(0, 10);
		String clos = (boardVO.getHnf_inpt_actpln_clos()).substring(0, 10);
		
		boardVO.setHnf_inpt_actpln_inpt(inpt);
		boardVO.setHnf_inpt_actpln_clos(clos);
		System.out.println(boardVO);
		dao.updateBoard(boardVO);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public int totalCount() throws Exception {
		return dao.totalCount();
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<HnfInptVO> boardList(Map<String, String> params)
			throws Exception {
		return dao.boardList(params);
	}
    
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public HnfInptVO boardView(Map<String, String> params) throws Exception {
		return dao.boardView(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public int totalCount_plan() throws Exception {
		return dao.totalCount_plan();
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<PrjctVO> getAllPrjct() throws Exception {
		return dao.getAllPrjct();
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<PrpslVO> getAllPrpsl() throws Exception {
		return dao.getAllPrpsl();
	}
    
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<SanctnLineVO> getAllSanctn_Line() throws Exception {
		return dao.getAllSanctn_Line();
	}
    
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<SanctnPapersTyVO> getAllSanctn_Papers_Ty() throws Exception {
		return dao.getAllSanctn_Papers_Ty();
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<HnfInptPlanVO> getAllHnfInptPlanList() throws Exception {
		return dao.getAllHnfInptPlanList();
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public String getPrjctName(Map<String, String> params) {
		String prjctNM = null;
		try {
			prjctNM = dao.getPrjctName(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prjctNM;
	}
	
}
