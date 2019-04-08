package kr.or.ddit.expndtr_anact.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.expndtr_anact.dao.IExpndtrAnactDao;
import kr.or.ddit.file.dao.ExpndtrAnactFileDao;
import kr.or.ddit.reqre_specf.dao.IReqreSpecfDao;
import kr.or.ddit.utils.ExpndtrAnactAttachFileMapper;
import kr.or.ddit.vo.ExpndtrAnactFileVO;
import kr.or.ddit.vo.ExpndtrAnactVO;
import kr.or.ddit.vo.ReqreSpecfVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("expndtrAnactService")
public class IExpndtrAnactServiceImpl implements IExpndtrAnactService {
	
	@Autowired
	private IExpndtrAnactDao dao;
	
	@Autowired
	private ExpndtrAnactFileDao itemDao;
	
	@Autowired
	private ExpndtrAnactAttachFileMapper fileMapper;

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<ExpndtrAnactVO> expndtrAnactList(Map<String, String> params)
			throws Exception {
		return dao.expndtrAnactList(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public ExpndtrAnactVO expndtrAnactInfo(Map<String, String> params)
			throws Exception {
		return dao.expndtrAnactInfo(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public String insertExpndtrAnact(ExpndtrAnactVO expndtrAnactInfo)
			throws Exception {
		dao.insertExpndtrAnact(expndtrAnactInfo);
		String bo_id = expndtrAnactInfo.getExpndtr_anact_id();
		ExpndtrAnactFileVO expndtrAnactFileInfo = fileMapper.mapping(expndtrAnactInfo.getFileitem(), bo_id);
		if(expndtrAnactFileInfo != null) {
			itemDao.insertExpFile(expndtrAnactFileInfo);
		}

		return bo_id;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void updateExpndtrAnact(ExpndtrAnactVO expndtrAnactInfo, Map<String, String> params)
			throws Exception {
		String expndtrAnact = expndtrAnactInfo.getExpndtr_anact_id();
		ExpndtrAnactFileVO getfileItem = itemDao.fileItemInfo(params);
		ExpndtrAnactFileVO expndtrAnactFileInfo = null;
		
		if(getfileItem == null ){
			expndtrAnactFileInfo = fileMapper.mapping(expndtrAnactInfo.getFileitem(), expndtrAnact);
			if(expndtrAnactFileInfo != null ){
				itemDao.updateExpFile(expndtrAnactFileInfo);
			}
		}else{
			expndtrAnactFileInfo =fileMapper.updateMapping(expndtrAnactInfo.getFileitem(), getfileItem);
			itemDao.updateExpFile(expndtrAnactFileInfo);
		}
		
		dao.updateExpndtrAnact(expndtrAnactInfo);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void deleteExpndtrAnact(Map<String, String> params) throws Exception {
		dao.deleteExpndtrAnact(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return dao.totalCount(params);
	}
	
	
	

}
