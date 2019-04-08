package kr.or.ddit.dynm.dyRecsRoom.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.dynm.dyRecsRoom.dao.IDyRecsRoomDao;
import kr.or.ddit.dynm.dyRecsRoomFile.dao.DyRecsRoomFileDao;
import kr.or.ddit.log.dao.ILogDao;
import kr.or.ddit.utils.DyRecsRoomAttachFileMapper;
import kr.or.ddit.vo.DynmRecsroomFileVO;
import kr.or.ddit.vo.DynmRecsroomVO;

@Service("dyRecsRoomService")
public class IDyRecsRoomServiceImpl implements IDyRecsRoomService {

	@Autowired
	private IDyRecsRoomDao dao;
	
	@Autowired
	private DyRecsRoomFileDao itemDao;
	
	@Autowired
	private DyRecsRoomAttachFileMapper fileMapper;
	
	@Autowired
	private ILogDao logDao;
	
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<DynmRecsroomVO> dyRecsRoomList(Map<String, String> params) throws Exception {
		List<DynmRecsroomVO> dyRecsRoomList =null;
		dyRecsRoomList =(List<DynmRecsroomVO>) dao.dyRecsRoomList(params);
		return dyRecsRoomList;
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
	public DynmRecsroomVO dyRecsRoomInfo(Map<String, String> param) throws Exception {
		DynmRecsroomVO dyRecsRoomInfo =null;
		dyRecsRoomInfo = dao.dyRecsRoomInfo(param);
		
		return dyRecsRoomInfo;
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void dyRecsRoomModify(DynmRecsroomVO dyRecsRoomInfo, Map<String,String> params) throws Exception {
		String dyRecsRoom = dyRecsRoomInfo.getDynm_recsroom_id();
		DynmRecsroomFileVO getfileItem = itemDao.fileItemInfo(params);
		DynmRecsroomFileVO dyRecsRoomFileInfo = null;
		
		if(getfileItem == null){
			dyRecsRoomFileInfo = fileMapper.mapping(dyRecsRoomInfo.getFileitem(), dyRecsRoom);
			if(dyRecsRoomFileInfo != null){
				itemDao.insertDyRecsRoomFile(dyRecsRoomFileInfo);
			}
		} else{
			dyRecsRoomFileInfo = fileMapper.updateMapping(dyRecsRoomInfo.getFileitem(), getfileItem);
			itemDao.updateDyRecsRoomFile(dyRecsRoomFileInfo);
		}
		Map<String, String> params2 = new HashMap<String, String>();
	      params2.put("prjct_id", dyRecsRoomInfo.getPrjct_id());
	      params2.put("empl_id", dyRecsRoomInfo.getDynm_recsroom_empl());
	      params2.put("log_cn", "회의록(" + dyRecsRoomInfo.getDynm_recsroom_nm() + ") 수정");
	      logDao.insertLog(params2);
		
		dao.dyRecsRoomModify(dyRecsRoomInfo);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void deleteDyRecsRoom(Map<String, String> params) throws Exception {
		dao.deleteDyRecsRoom(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public String dyRecsRoomInsert(DynmRecsroomVO dyRecsRoomInfo) throws Exception {
		String bo_id = dao.dyRecsRoomInsert(dyRecsRoomInfo);
		DynmRecsroomFileVO dyRecsRoomFileInfo = fileMapper.mapping(dyRecsRoomInfo.getFileitem(), bo_id);
		if(dyRecsRoomFileInfo != null){
			itemDao.insertDyRecsRoomFile(dyRecsRoomFileInfo);			
		}
		Map<String, String> params2 = new HashMap<String, String>();
	      params2.put("prjct_id", dyRecsRoomInfo.getPrjct_id());
	      params2.put("empl_id", dyRecsRoomInfo.getDynm_recsroom_empl());
	      params2.put("log_cn", "회의록(" + dyRecsRoomInfo.getDynm_recsroom_nm() + ") 수정");
	      logDao.insertLog(params2);
		return bo_id;
		
	}
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void frbView(Map<String, String> param) throws Exception {
		dao.frbView(param);
	}

}
