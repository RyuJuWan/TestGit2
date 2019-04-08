package kr.or.ddit.dynm.dyRecsRoomFile.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.DynmRecsroomFileVO;

public interface DyRecsRoomFileDao {
	public DynmRecsroomFileVO fileItemInfo(Map<String, String> params) throws Exception;
	
	public List<DynmRecsroomFileVO> DyRecsRoomFileList(Map<String, String> params) throws Exception;
	
	public void insertDyRecsRoomFile(DynmRecsroomFileVO PrpslFileInfo) throws Exception;
	
	public void updateDyRecsRoomFile(DynmRecsroomFileVO PrpslFileInfo) throws Exception;
	
	public int DyRecsRoomFileListSize() throws Exception;
}
