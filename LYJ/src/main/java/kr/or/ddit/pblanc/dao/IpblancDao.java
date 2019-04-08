package kr.or.ddit.pblanc.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.PblancVO;
import kr.or.ddit.vo.PrpslVO;

public interface IpblancDao {
	public List<PblancVO> pblancList(Map<String,String> params) throws Exception;
	public int totalCount(Map<String, String> params) throws Exception ;
	public PblancVO pblancInfo(Map<String, String> param) throws Exception ;
	public void pblancModify(PblancVO pblancInfo) throws Exception;
	public void deletePblanc(Map<String, String> params) throws Exception;
	public void pblancInsert(PblancVO pblancInfo) throws Exception;
	public void pblancAll() throws Exception;
}
