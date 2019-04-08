package kr.or.ddit.log.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.LogVO;

public interface ILogService {
	/**
	 * 프로젝트의 로그 리스트를 가져오는 메서드
	 * @return 프로젝트의 로그 리스트
	 * @param 프로젝트id
	 * @author LYJ
	 * @since 2019.03.15
	 * @throws Exception
	 */
	public List<LogVO> prjctLogList(Map<String, String> params) throws Exception;
	
	/**
	 * 모든 로그를 삭제하는 메서드
	 * @author LYJ
	 * @since 2019.03.15
	 * @throws Exception
	 */
	public void deleteAllLog() throws Exception;
	
	/**
	 * 로그를 삽입하는 메서드
	 * @param params 프로젝트 id, 로그 내용, 로그 변경자
	 * @author LYJ
	 * @since 2019.03.16
	 * @throws Exception
	 */
	public void insertLog(Map<String, String> params) throws Exception;
}
