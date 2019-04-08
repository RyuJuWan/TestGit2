package kr.or.ddit.dynm.dyRecsRoomFile.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.DynmRecsroomFileVO;

public interface DyRecsRoomFileService {
	public DynmRecsroomFileVO fileItemInfo(Map<String, String> params);
	
	public List<DynmRecsroomFileVO> DyRecsRoomFileList(Map<String, String> params);
	
	public void insertDyRecsRoomFile(DynmRecsroomFileVO prpslFileInfo);
	
	public void updateDyRecsRoomFile(DynmRecsroomFileVO prpslFileInfo);
	
	public int DyRecsRoomFileListSize() throws Exception;
}
