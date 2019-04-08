package kr.or.ddit.prjct_hist.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.PrjctHistVO;

public interface IPrjctHistService {
	/**
	 * 한 사원의 프로젝트 이력 리스트 전부를 가져오는 메서드
	 * @param params 사원의 id
	 * @return 한 사원의 프로젝트 이력 리스트 전부
	 * @author LYJ
	 * @since 2019.02.23
	 * @throws Exception
	 */
	public List<PrjctHistVO> prjctHistList(Map<String, String> params) throws Exception;
	
	/**
	 * 한 사원의 프로젝트 이력 개수를 알려주는 메서드
	 * @param params 사원 id
	 * @return 한 사원의 프로젝트 이력 개수
	 * @author LYJ
	 * @since 2019.02.25
	 * @throws Exception
	 */
	public int totalCount(Map<String, String> params) throws Exception;
	
	/**
	 * 한 사원의 프로젝트 이력 리스트를 가져오는 메서드(한 페이지 단위)
	 * @param params 사원 id, startCount, endCount
	 * @return 한 사원의 프로젝트 이력 리스트
	 * @author LYJ
	 * @since 2019.02.25
	 * @throws Exception
	 */
	public List<PrjctHistVO> prjctHistPageList(Map<String, String> params) throws Exception;
	
	/**
	 * 한 사원의 프로젝트 이력을 등록하는 메서드
	 * @param prjctHistInfo 프로젝트 이력
	 * @author LYJ
	 * @since 2019.02.26
	 * @throws Exception
	 */
	public void insertPrjctHist(PrjctHistVO prjctHistInfo) throws Exception;
	
	/**
	 * 프로젝트 이력 하나의 정보를 가져오는 메서드
	 * @param params 프로젝트 이력 id
	 * @return 프로젝트 이력 정보
	 * @author LYJ
	 * @since 2019.02.26
	 * @throws Exception
	 */
	public PrjctHistVO prjctHistView(Map<String, String> params) throws Exception;
	
	/**
	 * 프로젝트 이력을 삭제하는 메서드
	 * @param params 프로젝트 이력 id
	 * @author LYJ
	 * @since 2019.02.27
	 * @throws Exception
	 */
	public void deletePrjctHist(Map<String, String> params) throws Exception;
	
	
	/**
	 * 프로젝트 팀원리스트를 불러오는 메서드
	 * @param params 프로젝트 ID
	 * @return 프로젝트 팀원리스트
	 * @author 김유나
	 * @since 2019.03.14
	 * @throws Exception
	 */
	public List<PrjctHistVO> prjctMemberList(Map<String, String> params) throws Exception;
}
