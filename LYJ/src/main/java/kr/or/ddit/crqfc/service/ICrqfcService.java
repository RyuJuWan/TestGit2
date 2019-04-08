package kr.or.ddit.crqfc.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.CrqfcHoldVO;
import kr.or.ddit.vo.CrqfcVO;

public interface ICrqfcService {
	/**
	 * 자격증 리스트를 가져오는 메서드
	 * @return 자격증 리스트
	 * @author LYJ
	 * @since 2019.02.23
	 * @throws Exception
	 */
	public List<CrqfcVO> crqfcList() throws Exception;
	
	/**
	 * 한 사원이 보유한 자격증 리스트를 가져오는 메서드(한 페이지 단위)
	 * @param params 사원 id, startCount, endCount
	 * @return 한 사원이 보유한 자격증 리스트
	 * @author LYJ
	 * @since 2019.02.23
	 * @throws Exception
	 */
	public List<CrqfcHoldVO> crqfcHoldPageList(Map<String, String> params) throws Exception;
	
	/**
	 * 한 사원이 보유한 자격증의 개수를 알려주는 메서드
	 * @param params 사원 id
	 * @return 한 사원이 보유한 자격증의 개수
	 * @author LYJ
	 * @since 2019.02.23
	 * @throws Exception
	 */
	public int totalCount(Map<String, String> params) throws Exception;
	
	/**
	 * 보유 자격증을 등록하는 메서드
	 * @param crqfcHoldInfo 사원 id, 자격증 id
	 * @author LYJ
	 * @since 2019.02.25
	 * @throws Exception
	 */
	public void insertCrqfcHold(CrqfcHoldVO crqfcHoldInfo) throws Exception;
	
	/**
	 * 한 사원이 보유한 자격증 리스트 전부를 가져오는 메서드
	 * @param params 사원 id
	 * @return 한 사원이 보유한 자격증 리스트 전부
	 * @author LYJ
	 * @since 2019.02.25
	 * @throws Exception
	 */
	public List<CrqfcHoldVO> crqfcHoldList(Map<String, String> params) throws Exception;
	
	/**
	 * 보유 자격증을 삭제하는 메서드
	 * @param crqfcHoldInfo 삭제할 자격증 정보
	 * @author LYJ
	 * @since 2019.02.27 
	 * @throws Exception
	 */
	public void deleteCrqfcHold(CrqfcHoldVO crqfcHoldInfo) throws Exception;
}
