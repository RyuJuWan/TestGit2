package kr.or.ddit.dy_mtg.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MtgVO;

public interface IDy_mtgService {
	
	/**
	 * 회의록 개수를 가져오는 메서드
	 * @param params 해당 프로젝트 id
	 * @return 회의록 개수
	 * @author LYJ
	 * @since 2019.03.05
	 * @throws Exception
	 */
	public int totalCount(Map<String, String> params) throws Exception;
	
	/**
	 * 회의록 리스트를 가져오는 메서드(한 페이지)
	 * @param params StartCount, EndCount
	 * @return 회의록 리스트
	 * @author LYJ
	 * @since 2019.03.05
	 * @throws Exception
	 */
	public List<MtgVO> mtgPageList(Map<String, String> params) throws Exception;
	
	/**
	 * 회의록을 작성하는 메서드
	 * @param mtgInfo 회의록, nounList 워드클라우드를 만들기 위한 명사 모음
	 * @author LYJ
	 * @return 파일
	 * @since 2019.03.06
	 * @throws Exception
	 */
	public String insertDy_mtg(MtgVO mtgInfo, List<Map<String, Object>> nounList) throws Exception;
	
	/**
	 * 회의록을 조회하는 메서드
	 * @param params 회의록id
	 * @return 회의록
	 * @author LYJ
	 * @since 2019.03.06
	 * @throws Exception
	 */
	public MtgVO mtgView(Map<String, String> params) throws Exception;
	
	/**
	 * 회의록을 수정하는 메서드
	 * @param mtgInfo 회의록, nounList 워드클라우드를 만들기 위한 명사 모음
	 * @author LYJ
	 * @since 2019.03.08
	 * @throws Exception
	 */
	public void updateDy_mtg(MtgVO mtgInfo, List<Map<String, Object>> nounList) throws Exception;
	
	/**
	 * 회의록을 삭제하는 메서드
	 * @param params 회의록 id
	 * @author LYJ
	 * @since 2019.03.08
	 * @throws Exception
	 */
	public void deleteMtg(Map<String, String> params) throws Exception;
}
