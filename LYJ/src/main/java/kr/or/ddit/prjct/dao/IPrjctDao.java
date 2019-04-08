package kr.or.ddit.prjct.dao;

import java.util.List;
import java.util.Map;

import sun.security.util.PropertyExpander.ExpandException;
import kr.or.ddit.vo.PrjctVO;

public interface IPrjctDao {
	/**
	 * 프로젝트 리스트 전체를 가져오는 메서드
	 * @return 프로젝트 리스트 전체
	 * @author LYJ
	 * @since 2019.02.25
	 * @throws Exception
	 */
	public List<PrjctVO> prjctList() throws Exception;
	
	/**
	 * 현재 진행 중인 프로젝트 리스트를 가져오는 메서드
	 * @return 현재 진행 중인 프로젝트 리스트
	 * @author LYJ
	 * @since 2019.03.04
	 * @throws Exception
	 */
	public List<PrjctVO> currentPrjctList() throws Exception;
	
	/**
	 * 프로젝트를 생성하는 메서드
	 * @param projectInfo
	 * @author 김유나
	 * @since 2019.03.12
	 * @throws Exception
	 */
	public void insertProject(PrjctVO projectInfo) throws Exception;
	
	public void updateProject(PrjctVO projectInfo) throws Exception;
	
	public PrjctVO projectInfo(Map<String, String> params) throws Exception;
}
