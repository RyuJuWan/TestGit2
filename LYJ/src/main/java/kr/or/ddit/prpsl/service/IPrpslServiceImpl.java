package kr.or.ddit.prpsl.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.file.dao.IHnfInptFileDao;
import kr.or.ddit.file.dao.IPrpslFileDaoImpl;
import kr.or.ddit.file.dao.PrpslFileDao;
import kr.or.ddit.log.dao.ILogDao;
import kr.or.ddit.prpsl.dao.IPrpslDao;
import kr.or.ddit.utils.HnfInptAttachFileMapper;
import kr.or.ddit.utils.PrpslAttachFileMapper;
import kr.or.ddit.vo.HnfInptFileVO;
import kr.or.ddit.vo.PrpslFileVO;
import kr.or.ddit.vo.PrpslVO;

@Service("prplsService")
public class IPrpslServiceImpl implements IPrpslService {

	@Autowired
	private IPrpslDao dao;
	
	@Autowired
	private PrpslFileDao itemDao;
	
	@Autowired
	private PrpslAttachFileMapper fileMapper;
	
	@Autowired
	private ILogDao logDao;
	
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<PrpslVO> prpslList(Map<String, String> params) throws Exception {
		List<PrpslVO> prpslList =null;
		prpslList =(List<PrpslVO>) dao.prpslList(params);
		return prpslList;
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		int totalCount=0;
		totalCount=dao.totalCount(params);
		return totalCount;
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public PrpslVO prpsInfo(Map<String, String> param) throws Exception {
		PrpslVO prpslInfo =null;
		prpslInfo = dao.prpsInfo(param);
		
		return prpslInfo;
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void prpslModify(PrpslVO prpslInfo, Map<String,String> params) throws Exception {
		String prpsl = prpslInfo.getPrpsl_id();
		PrpslFileVO getfileItem = itemDao.fileItemInfo(params);
		PrpslFileVO prpslFileInfo = null;
		
		if(getfileItem == null){
			prpslFileInfo = fileMapper.mapping(prpslInfo.getFileitem(), prpsl);
			if(prpslFileInfo != null){
				itemDao.insertPrpslFile(prpslFileInfo);
			}
		} else{
			prpslFileInfo = fileMapper.updateMapping(prpslInfo.getFileitem(), getfileItem);
			itemDao.updatePrpslFile(prpslFileInfo);
		}
		
		String inpt = (prpslInfo.getPrpsl_prjct_start()).substring(0, 10);
		String clos = (prpslInfo.getPrpsl_prjct_clos()).substring(0, 10);
		
		prpslInfo.setPrpsl_prjct_start(inpt);
		prpslInfo.setPrpsl_prjct_clos(clos);
//		
//		Map<String, String> params2 = new HashMap<String, String>();
//	      params2.put("prjct_id", prpslInfo.getPrpsl_id());
//	      params2.put("empl_id", prpslInfo.getPrpsl_empl());
//	      params2.put("log_cn", "회의록(" + prpslInfo.getPrpsl_nm() + ") 수정");
//	      logDao.insertLog(params2);
//		
		
		dao.prpslModify(prpslInfo);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void deletePrpsl(Map<String, String> params) throws Exception {
		dao.deletePrpsl(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public String prpslInsert(PrpslVO prpslInfo) throws Exception {
		dao.prpslInsert(prpslInfo);
		String bo_id = prpslInfo.getPrpsl_id();
		PrpslFileVO prpslFileInfo = fileMapper.mapping(prpslInfo.getFileitem(), bo_id);
		if(prpslFileInfo != null){
			itemDao.insertPrpslFile(prpslFileInfo);			
		}
//		Map<String, String> params2 = new HashMap<String, String>();
//	      params2.put("prjct_id", prpslInfo.getPrpsl_id());
//	      params2.put("empl_id", prpslInfo.getPrpsl_empl());
//	      params2.put("log_cn", "회의록(" + prpslInfo.getPrpsl_nm() + ") 수정");
//	      logDao.insertLog(params2);
//		
		
		
		return bo_id;
//		dao.prpslInsert(prpslInfo);
		
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<PrpslVO> getPrpslId()
			throws Exception {
		return dao.getPrpslId();
	}

}
