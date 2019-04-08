package kr.or.ddit.prpsl.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.PrpslVO;

public interface IPrpslService {
	public List<PrpslVO> prpslList(Map<String,String> params) throws Exception;
	public int totalCount(Map<String, String> params) throws Exception ;
	public PrpslVO prpsInfo(Map<String, String> param) throws Exception ;
	public void prpslModify(PrpslVO prpslInfo,Map<String, String> params) throws Exception;
	public void deletePrpsl(Map<String, String> params) throws Exception;
	public String prpslInsert(PrpslVO prpslInfo) throws Exception;
	public List<PrpslVO> getPrpslId() throws Exception;
}
