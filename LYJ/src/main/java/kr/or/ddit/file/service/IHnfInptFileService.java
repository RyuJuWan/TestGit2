package kr.or.ddit.file.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.HnfInptFileVO;

public interface IHnfInptFileService {
	/**
	* 인원투입계획서의 관련 파일의 정보를 가져오는 메서드
	* @param params 인력투입계획서의 관련 정보들
	* @return 가져온 인원투입계획세의 관련 파일들의 정보
	* @author 최준열
	* @since 2019.02.20
	* @throws Exception
	*/
	public HnfInptFileVO fileItemInfo(Map<String, String> params);
	
	public List<HnfInptFileVO> HnfInptFileList(Map<String, String> params);
	
	/**
	* 인원투입계획서의 관련 파일을 추가하는 메서드
	* @param params 인력투입계획서의 관련 정보들
	* @author 최준열
	* @since 2019.02.20
	* @throws Exception
	*/
	public void insertHnfInptFile(HnfInptFileVO hnfInptFileInfo);
	
	public void updateHnfInptFile(HnfInptFileVO hnfInptFileInfo);
	
	public int hnfInptFileListSize() throws Exception;
}
