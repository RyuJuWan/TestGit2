package kr.or.ddit.file.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.HnfInptFileVO;
import kr.or.ddit.vo.PrpslFileVO;

public interface PrpslFileDao {
	public PrpslFileVO fileItemInfo(Map<String, String> params) throws Exception;
	
	public List<PrpslFileVO> PrpslFileList(Map<String, String> params) throws Exception;
	
	public void insertPrpslFile(PrpslFileVO PrpslFileInfo) throws Exception;
	
	public void updatePrpslFile(PrpslFileVO PrpslFileInfo) throws Exception;
	
	public int PrpslFileListSize() throws Exception;
}
