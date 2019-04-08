package kr.or.ddit.dy_mtg.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kaist.swrc.jhannanum.comm.Eojeol;
import kr.ac.kaist.swrc.jhannanum.comm.Sentence;
import kr.ac.kaist.swrc.jhannanum.hannanum.Workflow;
import kr.ac.kaist.swrc.jhannanum.hannanum.WorkflowFactory;
import kr.ac.kaist.swrc.jhannanum.plugin.MajorPlugin.MorphAnalyzer.ChartMorphAnalyzer.ChartMorphAnalyzer;
import kr.ac.kaist.swrc.jhannanum.plugin.MajorPlugin.PosTagger.HmmPosTagger.HMMTagger;
import kr.or.ddit.dy_mtg.dao.IDy_mtgDao;
import kr.or.ddit.file.dao.IDy_mtgFileDao;
import kr.or.ddit.log.dao.ILogDao;
import kr.or.ddit.utils.CSVFile;
import kr.or.ddit.utils.MtgAttachFileMapper;
import kr.or.ddit.vo.MtgFileVO;
import kr.or.ddit.vo.MtgVO;

@Service("dy_mtgService")
public class IDy_mtgServiceImpl implements IDy_mtgService {
	
	@Autowired
	private IDy_mtgDao dao;
	
	@Autowired
	private MtgAttachFileMapper fileMapper;
	
	@Autowired
	private IDy_mtgFileDao itemDao;
	
	@Autowired
	private CSVFile csvFile;
	
	@Autowired
	private ILogDao logDao;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return dao.totalCount(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<MtgVO> mtgPageList(Map<String, String> params) throws Exception {
		return dao.mtgPageList(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public String insertDy_mtg(MtgVO mtgInfo, List<Map<String, Object>> nounList) throws Exception {
		String mtg_id = dao.insertDy_mtg(mtgInfo);
		MtgFileVO mtgFileInfo = fileMapper.mapping(mtgInfo.getFileitem(), mtg_id);
		if(mtgFileInfo != null) itemDao.insertMtgFile(mtgFileInfo);
		csvFile.makeCSV(nounList, mtg_id, "D:\\temp\\fileDocBase");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("prjct_id", mtgInfo.getMtg_prjct());
		params.put("empl_id", mtgInfo.getMtg_empl());
		params.put("log_cn", "회의록(" + mtgInfo.getMtg_nm() + ") 작성");
		logDao.insertLog(params);
		return mtg_id;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public MtgVO mtgView(Map<String, String> params) throws Exception {
		return dao.mtgView(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void updateDy_mtg(MtgVO mtgInfo, List<Map<String, Object>> nounList)
			throws Exception {
		dao.updateDy_mtg(mtgInfo);
		MtgFileVO mtgFileInfo = fileMapper.mapping(mtgInfo.getFileitem(), mtgInfo.getMtg_id());
		if(mtgFileInfo != null) itemDao.updateMtgFile(mtgFileInfo);
		csvFile.makeCSV(nounList, mtgInfo.getMtg_id(), "D:\\temp\\fileDocBase");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("prjct_id", mtgInfo.getMtg_prjct());
		params.put("empl_id", mtgInfo.getMtg_empl());
		params.put("log_cn", "회의록(" + mtgInfo.getMtg_nm() + ") 수정");
		logDao.insertLog(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void deleteMtg(Map<String, String> params) throws Exception {
		itemDao.deleteMtgFile(params);
		
	}

}
