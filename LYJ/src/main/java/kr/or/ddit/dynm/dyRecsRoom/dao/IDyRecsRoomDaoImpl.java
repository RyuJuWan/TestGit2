package kr.or.ddit.dynm.dyRecsRoom.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.vo.DynmRecsroomVO;

@Repository("dyRecsRoomDao")
public class IDyRecsRoomDaoImpl implements IDyRecsRoomDao {

	@Autowired
	private SqlMapClient client;
	
	@Override
	public List<DynmRecsroomVO> dyRecsRoomList(Map<String, String> params) throws Exception {
		
		return (List<DynmRecsroomVO>) client.queryForList("dyRecsRoom.dyRecsRoomList",params);
	}

	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return (int) client.queryForObject("dyRecsRoom.totalCount",params);
	}

	@Override
	public DynmRecsroomVO dyRecsRoomInfo(Map<String, String> param) throws Exception {
		return (DynmRecsroomVO) client.queryForObject("dyRecsRoom.dyRecsRoomInfo",param);
	}

	@Override
	public void dyRecsRoomModify(DynmRecsroomVO dyRecsRoomInfo) throws Exception {
		client.update("dyRecsRoom.dyRecsRoomModify",dyRecsRoomInfo);
		
	}

	@Override
	public void deleteDyRecsRoom(Map<String, String> params) throws Exception {
		client.update("dyRecsRoom.dyRecsRoomDelete",params);
	}

	@Override
	public String dyRecsRoomInsert(DynmRecsroomVO dyRecsRoomInfo) throws Exception {
		return (String) client.insert("dyRecsRoom.dyRecsRoomInsert", dyRecsRoomInfo);
	}
	@Override
	public void frbView(Map<String, String> param) throws Exception {
		client.update("dyRecsRoom.frbView", param);
	}

}
