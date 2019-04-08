package kr.or.ddit.dy_flaw.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.FlawVO;
import kr.or.ddit.vo.IpcrVO;
import kr.or.ddit.vo.SttusVO;

public interface IDy_flawService {
	/**
	 * 결함을 추가하는 메서드
	 * @param flawInfo 결함를 추가할 때 필요한 데이터들
	 * @return none
	 * @author 최준열
	 */
	public void insertBoard(FlawVO flawInfo) throws Exception;
	
	/**
	 * 결함을 수정하는 메서드
	 * @param flawInfo 결함의 수정할 부분의 데이터들
	 * @return none
	 * @author 최준열
	 */
	public void updateBoard(FlawVO flawInfo) throws Exception;
	
	/**
	 * 결함들의 총 갯수를 구하는 메서드
	 * @param params 결함들의 총 갯수
	 * @return none
	 * @author 최준열
	 */
	public int totalCount(Map<String, String> params) throws Exception;
	
	/**
	 * 결함들의 총 리스트를 가져오는 메서드
	 * @param params 검색어(등록자, 담당자)
	 * @return none
	 * @author 최준열
	 */
	public List<FlawVO> boardList(Map<String, String> params) throws Exception;
	
	/**
	 * View에서 선택한 결함의 정보들
	 * @param params 선택한 결함의 id
	 * @return 선택한 결함들의 정보들
	 * @author 최준열
	 */
	public FlawVO boardViewInfo(Map<String, String> params) throws Exception;
	
	/**
	 * 선택한 결함의 대한 프로젝트 명을 가져오는 메서드
	 * @param params 결함에 저장된 프로젝트 id
	 * @return 프로젝트 명
	 * @author 최준열
	 */
	public String getPrjctName(Map<String, String> params) throws Exception;
	
	/**
	 * 프로젝트에 참여된 팀원들의 정보를 가져오는 메서드
	 * @param params 결함에 저장된 프로젝트 id
	 * @return 프로젝트 참여된 팀원들의 정보들
	 * @author 최준열
	 */
	public List<EmplVO> getPrjctEmpl(Map<String, String> params) throws Exception;
	
	/**
	 * 모든 중요도의 각각의 정보를 가져오는 메서드
	 * @param none
	 * @return 모든 중요도의 각각의 정보들
	 * @author 최준열
	 */
	public List<IpcrVO> getAllIpcr() throws Exception;
	
	/**
	 * 모든 상태의 각각의 정보를 가져오는 메서드
	 * @param none
	 * @return 모든 상태의 각각의 정보들
	 * @author 최준열
	 */
	public List<SttusVO> getAllSttus() throws Exception;

	public int flawSttusCount(Map<String, String> params) throws Exception;
	
	/**
	 * 스케줄에 필요한 데이터를 가져오는 메서드
	 * @param params - prjct_id, flaw_chrg
	 * @return 해당 정보
	 * @author 최준열
	 */
	public List<FlawVO> selectListSechdul(Map<String, String> params) throws Exception;
}
