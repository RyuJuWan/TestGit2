package kr.or.ddit.file.service;

import java.util.Map;

import kr.or.ddit.vo.MtgFileVO;

public interface IDy_mtgFileService {
	/**
	 * 회의록 파일을 삽입하는 메서드
	 * @param mtgInfo
	 * @author LYJ
	 * @since 2019.03.06
	 * @throws Exception
	 */
	public void insertMtgFile(MtgFileVO mtgFileInfo) throws Exception;
	
	/**
	 * 회의록의 파일을 가져오는 메서드
	 * @param params 회의록id
	 * @author LYJ
	 * @since 2019.03.06
	 * @throws Exception
	 */
	public MtgFileVO fileItemInfo(Map<String, String> params) throws Exception;

	
}
