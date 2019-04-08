package kr.or.ddit.file.dao;


import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ExpndtrAnactFileVO;

public interface ExpndtrAnactFileDao {
	public void insertExpFile(ExpndtrAnactFileVO ExpFileInfo) throws Exception;
	
	public List<ExpndtrAnactFileVO> expFileList(Map<String, String> params) throws Exception;
	
	public ExpndtrAnactFileVO fileItemInfo(Map<String, String> params) throws Exception;
	
	public void updateExpFile(ExpndtrAnactFileVO expndFileInfo) throws Exception;
	
	public int expFileListSize() throws Exception;
	

}
