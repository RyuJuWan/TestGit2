package kr.or.ddit.dy_reprt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.dy_reprt.dao.IDy_reprtDao;
import kr.or.ddit.file.dao.IDy_reprtFileDao;
import kr.or.ddit.log.dao.ILogDao;
import kr.or.ddit.utils.CSVFile;
import kr.or.ddit.utils.ReprtAttachFileMapper;
import kr.or.ddit.vo.ReprtFileVO;
import kr.or.ddit.vo.ReprtVO;

@Service("dy_reprtService")
public class IDy_reprtServiceImpl implements IDy_reprtService {
	
	@Autowired
	private IDy_reprtDao dao;
	
	@Autowired
	private ReprtAttachFileMapper fileMapper;
	
	@Autowired
	private IDy_reprtFileDao itemDao;
	
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
	public List<ReprtVO> reprtPageList(Map<String, String> params)
			throws Exception {
		return dao.reprtPageList(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public String insertDy_reprt(ReprtVO reprtInfo,
			List<Map<String, Object>> nounList) throws Exception {
		String reprt_id = dao.insertDy_reprt(reprtInfo);
		ReprtFileVO reprtFileInfo = fileMapper.mapping(reprtInfo.getFileitem(), reprt_id);
		if(reprtFileInfo != null) itemDao.insertReprtFile(reprtFileInfo);
		csvFile.makeCSV(nounList, reprt_id, "D:\\temp\\fileDocBase");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("prjct_id", reprtInfo.getReprt_prjct());
		params.put("empl_id", reprtInfo.getReprt_empl());
		if(reprtInfo.getReprt_ty_id() == "week"){
			params.put("log_cn", "주간보고서(" + reprtInfo.getReprt_nm() + ") 작성");
		} else {
			params.put("log_cn", "월간보고서(" + reprtInfo.getReprt_nm() + ") 작성");
		}
		logDao.insertLog(params);
		return reprt_id;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public ReprtVO reprtView(Map<String, String> params) throws Exception {
		return dao.reprtView(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void updateDy_reprt(ReprtVO reprtInfo,
			List<Map<String, Object>> nounList) throws Exception {
		dao.updateDy_reprt(reprtInfo);
		ReprtFileVO reprtFileInfo = fileMapper.mapping(reprtInfo.getFileitem(), reprtInfo.getReprt_id());
		if(reprtFileInfo != null) itemDao.updateReprtFile(reprtFileInfo);
		csvFile.makeCSV(nounList, reprtInfo.getReprt_id(), "D:\\temp\\fileDocBase");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("prjct_id", reprtInfo.getReprt_prjct());
		params.put("empl_id", reprtInfo.getReprt_empl());
		if(reprtInfo.getReprt_ty_id() == "week"){
			params.put("log_cn", "주간보고서(" + reprtInfo.getReprt_nm() + ") 수정");
		} else {
			params.put("log_cn", "월간보고서(" + reprtInfo.getReprt_nm() + ") 수정");
		}
		logDao.insertLog(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void deleteReprt(Map<String, String> params) throws Exception {
		itemDao.deleteReprtFile(params);
	}

}
