package kr.or.ddit.dynm.dyRecsRoom.dao;

import java.util.List;
import java.util.Map;



import kr.or.ddit.vo.DynmRecsroomVO;

public interface IDyRecsRoomDao {
	public List<DynmRecsroomVO> dyRecsRoomList(Map<String,String> params) throws Exception;
	public int totalCount(Map<String, String> params) throws Exception ;
	public DynmRecsroomVO dyRecsRoomInfo(Map<String, String> param) throws Exception ;
	public void dyRecsRoomModify(DynmRecsroomVO dyRecsRoomInfo) throws Exception;
	public void deleteDyRecsRoom(Map<String, String> params) throws Exception;
	public String dyRecsRoomInsert(DynmRecsroomVO dyRecsRoomInfo) throws Exception;
	public void frbView(Map<String, String> param) throws Exception ;
}
