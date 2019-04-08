package kr.or.ddit.prpsl.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.PrpslVO;

public interface IPrpslDao {
	public List<PrpslVO> prpslList(Map<String,String> params) throws Exception;
	public int totalCount(Map<String, String> params) throws Exception ;
	public PrpslVO prpsInfo(Map<String, String> param) throws Exception ;
	public void prpslModify(PrpslVO prpslInfo) throws Exception;
	public void deletePrpsl(Map<String, String> params) throws Exception;
	public void prpslInsert(PrpslVO prpslInfo) throws Exception;
	public List<PrpslVO> getPrpslId() throws Exception;

}
