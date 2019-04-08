package kr.or.ddit.dynm.dyRecsRoomFile.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.dynm.dyRecsRoomFile.dao.DyRecsRoomFileDao;
import kr.or.ddit.log.dao.ILogDao;
import kr.or.ddit.vo.DynmRecsroomFileVO;
@Service
public class IDyRecsRoomFileServiceImpl implements DyRecsRoomFileService {
	@Autowired
	private DyRecsRoomFileDao dao;
	
	@Autowired
	private ILogDao logDao;
	
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public DynmRecsroomFileVO fileItemInfo(Map<String, String> params) {
		DynmRecsroomFileVO prpslFileInfo = null;
		try {
			prpslFileInfo = dao.fileItemInfo(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prpslFileInfo;
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<DynmRecsroomFileVO> DyRecsRoomFileList(Map<String, String> params) {
		return null;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void insertDyRecsRoomFile(DynmRecsroomFileVO prpslFileInfo) {
		try {
			dao.insertDyRecsRoomFile(prpslFileInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public int DyRecsRoomFileListSize() throws Exception {
		return dao.DyRecsRoomFileListSize();
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void updateDyRecsRoomFile(DynmRecsroomFileVO prpslFileInfo) {
		try {
			dao.updateDyRecsRoomFile(prpslFileInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
