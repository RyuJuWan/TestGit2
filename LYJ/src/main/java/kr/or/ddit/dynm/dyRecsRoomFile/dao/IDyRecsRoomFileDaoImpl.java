package kr.or.ddit.dynm.dyRecsRoomFile.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.vo.DynmRecsroomFileVO;
@Repository
public class IDyRecsRoomFileDaoImpl implements DyRecsRoomFileDao {
	
	@Autowired
	private SqlMapClient client;
	
	@Override
	public DynmRecsroomFileVO fileItemInfo(Map<String, String> params)
			throws Exception {
		return (DynmRecsroomFileVO) client.queryForObject("dyRecsRoomFile.dyRecsRoomFileInfo", params);
	}
	
	@Override
	public List<DynmRecsroomFileVO> DyRecsRoomFileList(Map<String, String> params)
			throws Exception {
		return null;
	}
	
	@Override
	public void insertDyRecsRoomFile(DynmRecsroomFileVO prpslFileInfo)
			throws Exception {
			client.insert("dyRecsRoomFile.insertdyRecsRoomFile", prpslFileInfo);
	}

	@Override
	public int DyRecsRoomFileListSize() throws Exception {
		return (int) client.queryForObject("dyRecsRoomFile.dyRecsRoomFileListSize");
	}

	@Override
	public void updateDyRecsRoomFile(DynmRecsroomFileVO prpslFileInfo)
			throws Exception {
		try {
			client.startTransaction();
			client.update("dyRecsRoomFile.updatedyRecsRoomFile", prpslFileInfo);
			client.commitTransaction();
		} finally{
			client.endTransaction();
		}
	}

}
