package kr.or.ddit.sanctn_papert_ty.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.SanctnPapersTyVO;

public interface ISanctnpaperstyDao {
	public List<SanctnPapersTyVO> sanctnpaperstyList(Map<String, String> params) throws Exception;
}
