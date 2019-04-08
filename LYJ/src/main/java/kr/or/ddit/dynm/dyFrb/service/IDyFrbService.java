package kr.or.ddit.dynm.dyFrb.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.DynmFrbVO;

public interface IDyFrbService {
	public List<DynmFrbVO> frbList(Map<String, String> params) throws Exception;
	public int totalCount(Map<String, String> params) throws Exception;
	public String insertFrb(DynmFrbVO frbInfo) throws Exception;
	public DynmFrbVO frbInfo(Map<String, String> params) throws Exception;
	public void deleteFrb(Map<String, String> params) throws Exception;
	public void modifyFrb(DynmFrbVO frbInfo) throws Exception;
	public void frbView(Map<String, String> param) throws Exception;
}
