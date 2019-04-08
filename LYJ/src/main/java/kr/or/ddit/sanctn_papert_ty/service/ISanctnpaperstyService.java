package kr.or.ddit.sanctn_papert_ty.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.SanctnPapersTyVO;

public interface ISanctnpaperstyService {
	public List<SanctnPapersTyVO> sanctnpaperstyList(Map<String, String> params) throws Exception;
}
