package kr.or.ddit.file.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.HnfInptFileVO;
import kr.or.ddit.vo.PrpslFileVO;

public interface PrpslFileService {
	public PrpslFileVO fileItemInfo(Map<String, String> params);
	
	public List<PrpslFileVO> prpslFileList(Map<String, String> params);
	
	public void insertPrpslFile(PrpslFileVO prpslFileInfo);
	
	public void updatePrpslFile(PrpslFileVO prpslFileInfo);
	
	public int prpslFileListSize() throws Exception;
}
