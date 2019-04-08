package kr.or.ddit.dy_reprt.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ReprtVO;

public interface IDy_reprtService {
	/**
	 * 보고서 개수를 가져오는 메서드
	 * @param params 해당 프로젝트 id, 보고서 유형
	 * @return 보고서 개수
	 * @author LYJ
	 * @since 2019.03.08
	 * @throws Exception
	 */
	public int totalCount(Map<String, String> params) throws Exception;
	
	/**
	 * 보고서 리스트를 가져오는 메서드(한 페이지)
	 * @param params StartCount, EndCount, 보고서 유형
	 * @return
	 * @throws Exception
	 */
	public List<ReprtVO> reprtPageList(Map<String, String> params) throws Exception;
	
	/**
	 * 보고서를 작성하는 메서드
	 * @param reprtInfo 보고서
	 * @return 파일
	 * @author LYJ
	 * @since 2019.03.08
	 * @throws Exception
	 */
	public String insertDy_reprt(ReprtVO reprtInfo, List<Map<String, Object>> nounList) throws Exception;
	
	/**
	 * 보고서를 조회하는 메서드
	 * @param params 회의록id, 보고서 유형
	 * @return 보고서
	 * @author LYJ
	 * @since 2019.03.08
	 * @throws Exception
	 */
	public ReprtVO reprtView(Map<String, String> params) throws Exception;
	
	/**
	 * 보고서를 수정하는 메서드
	 * @param reprtInfo 보고서, nounList 워드클라우드를 만들기 위한 명사 모음
	 * @author LYJ
	 * @since 2019.03.08
	 * @throws Exception
	 */
	public void updateDy_reprt(ReprtVO reprtInfo, List<Map<String, Object>> nounList) throws Exception;
	
	/**
	 * 보고서를 삭제하는 메서드
	 * @param params 회의록 id, 보고서 유형
	 * @author LYJ
	 * @since 2019.03.08
	 * @throws Exception
	 */
	public void deleteReprt(Map<String, String> params) throws Exception;
}
