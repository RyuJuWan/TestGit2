package kr.or.ddit.file.service;

import java.util.Map;

import kr.or.ddit.vo.ReprtFileVO;

public interface IDy_reprtFileService {
	/**
	 * 보고서 파일을 삽입하는 메서드
	 * @param reprtFileInfo
	 * @author LYJ
	 * @since 2019.03.11
	 * @throws Exception
	 */
	public void insertReprtFile(ReprtFileVO reprtFileInfo) throws Exception;
	
	/**
	 * 보고서의 파일을 가져오는 메서드
	 * @param params 보고서 id
	 * @return 보고서 파일
	 * @author LYJ
	 * @since 2019.03.11
	 * @throws Exception
	 */
	public ReprtFileVO fileItemInfo(Map<String, String> params) throws Exception;
}
