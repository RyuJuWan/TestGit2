package kr.or.ddit.file.dao;

import java.util.Map;

import kr.or.ddit.vo.MtgFileVO;
import kr.or.ddit.vo.MtgVO;

public interface IDy_mtgFileDao {
	
	/**
	 * 회의록 파일을 삽입하는 메서드
	 * @param mtgFileInfo
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
	
	/**
	 * 회의록의 파일을수정하는 메서드
	 * @param mtgFileInfo 회의록 파일
	 * @author LYJ
	 * @since 2019.03.08
	 * @throws Exception
	 */
	public void updateMtgFile(MtgFileVO mtgFileInfo) throws Exception;
	
	/**
	 * 회의록의 파일을 삭제하는 메서드
	 * @param params 회의록 id
	 * @author LYJ
	 * @since 2019.03.08
	 * @throws Exception
	 */
	public void deleteMtgFile(Map<String, String> params) throws Exception;

}
