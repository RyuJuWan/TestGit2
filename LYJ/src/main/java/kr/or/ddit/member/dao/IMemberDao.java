package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.AdminVO;
import kr.or.ddit.vo.EmplVO;

public interface IMemberDao {
	/**
	 * admin으로 로그인할 때 admin의 정보를 가져오는 메서드
	 * @param params admin의 아이디, 비밀번호
	 * @return admin의 정보
	 * @author LYJ
	 * @since 2019.02.20
	 * @throws Exception
	 */
	public AdminVO adminInfo(Map<String, String> params) throws Exception;
	
	/**
	 * empl의 id에 대응하는 empl의 정보를 가져오는 메서드
	 * @param params empl의 id
	 * @return empl의 정보
	 * @author LYJ
	 * @since 2019.02.21 
	 * @throws Exception
	 */
	public EmplVO emplInfo(Map<String, String> params) throws Exception;
	
	/**
	 * empl을 수정하는 메서드
	 * @param emplInfo empl의 정보
	 * @author LYJ
	 * @since 2019.02.21
	 * @throws Exception
	 */
	public void updateEmplInfo(EmplVO emplInfo) throws Exception;
	
	/**
	 * 사원 리스트를 가져오는 메서드(한 페이지)
	 * @param StartCount, EndCount
	 * @return 사원 리스트
	 * @author LYJ
	 * @since 2019.02.28
	 * @throws Exception
	 */
	public List<EmplVO> emplPageList(Map<String, String> params) throws Exception;
	
	/**
	 * 사원 수를 가져오는 메서드
	 * @param params 사원이 속한 부서
	 * @return 사원 수
	 * @author LYJ
	 * @since 2019.02.28
	 * @throws Exception
	 */
	public int totalCount(Map<String, String> params) throws Exception;
	
	/**
	 * 사원을 등록하는 메서드
	 * @param emplInfo 사원 정보(사번, 이름, 비밀번호)
	 * @author LYJ
	 * @since 2019.02.28
	 * @throws Exception
	 */
	public void insertEmpl(EmplVO emplInfo) throws Exception;
	
	public List<EmplVO> selectDeptEmpl(Map<String, String > params) throws Exception;
	
	public List<EmplVO> emplList() throws Exception;
	
	public List<EmplVO> selectPrjctEmpl(Map<String, String> params) throws Exception;
}
