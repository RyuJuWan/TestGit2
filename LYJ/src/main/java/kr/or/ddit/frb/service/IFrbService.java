package kr.or.ddit.frb.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.FrbVO;

public interface IFrbService {
	public List<FrbVO> frbList(Map<String, String> params) throws Exception;
	public int totalCount(Map<String, String> params) throws Exception;
	public String insertFrb(FrbVO frbInfo) throws Exception;
	public FrbVO frbInfo(Map<String, String> params) throws Exception;
	public void deleteFrb(Map<String, String> params) throws Exception;
	public void modifyFrb(FrbVO frbInfo) throws Exception;
	public void frbView(Map<String, String> param) throws Exception;
}
