package kr.or.ddit.dy_issue.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.IpcrVO;
import kr.or.ddit.vo.IssueVO;
import kr.or.ddit.vo.PrjctVO;
import kr.or.ddit.vo.RiskVO;
import kr.or.ddit.vo.SttusVO;

public interface IDy_issueService {
	/**
	 * 이슈를 추가하는 메서드
	 * @param 이슈를 추가할 때 필요한 데이터들
	 * @return none
	 * @author 최준열
	 */
	public String insertBoard(IssueVO issueInfo) throws Exception;
	
	/**
	 * 이슈를 수정하는 메서드
	 * @param 이슈의 수정할 부분의 데이터들
	 * @return none
	 * @author 최준열
	 */
	public void updateBoard(IssueVO issueInfo) throws Exception;
	
	/**
	 * 이슈의 삭제여부를 'y'로 수정하는 메서드
	 * @param 선택한 이슈의 id
	 * @return none
	 * @author 최준열
	 */
	public void deleteBoard(Map<String, String> params) throws Exception;
	
	/**
	 * 이슈들의 총 갯수를 구하는 메서드
	 * @param none
	 * @return 이슈들의 총 갯수
	 * @author 최준열
	 */
	public int totalCount(Map<String, String> params) throws Exception;
	
	/**
	 * 이슈들을 리스트로 가져오는 메서드
	 * @param 검색어(프로젝트 명, 이슈 명, 등록자, 담당자)
	 * @return 이슈들의 리스트들
	 * @author 최준열
	 */
	public List<IssueVO> boardList(Map<String, String> params) throws Exception;
	
	/**
	 * 진행상태에 따른 이슈들의 리스트를 가져오는 메서드
	 * @param params 진행상태의 id(sttus_id = issue_sttus)
	 * @return 검색한 이슈들의 리스트
	 * @author 최준열
	 */
	public List<IssueVO> selectSttueBoardList(Map<String, String> params) throws Exception;
	
	/**
	 * View에서 선택한 이슈의 정보들
	 * @param 선택한 이슈의 id
	 * @return 선택한 이슈들의 정보들
	 * @author 최준열
	 */
	public IssueVO boardViewInfo(Map<String, String> params) throws Exception;
	
	/**
	 * 선택한 이슈의 대한 프로젝트 명을 가져오는 메서드
	 * @param 이슈에 저장된 프로젝트 id
	 * @return 프로젝트 명
	 * @author 최준열
	 */
	public String getPrjctName(Map<String, String> params) throws Exception;
	
	/**
	 * 프로젝트에 참여된 팀원들의 정보를 가져오는 메서드
	 * @param 이슈에 저장된 프로젝트 id
	 * @return 프로젝트 참여된 팀원들의 정보들
	 * @author 최준열
	 */
	public List<EmplVO> getPrjctEmpl(Map<String, String> params) throws Exception;
	
	/**
	 * 모든 프로젝트의 각각의 정보를 가져오는 메서드
	 * @param none
	 * @return 모든 프로젝트들의 각각의 정보들
	 * @author 최준열
	 */
	public List<PrjctVO> getAllPrjct() throws Exception;
	
	/**
	 * 모든 리스크의 각각의 정보를 가져오는 메서드
	 * @param none
	 * @return 모든 리스크의 각각의 정보들
	 * @author 최준열
	 */
	public List<RiskVO> getAllRisk(Map<String, String> params) throws Exception;
	
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
	
	public int sttusCount(Map<String, String> params) throws Exception;
	
	/**
	 * 스케줄에 넣게 될 리스트를 가져오는 메서드
	 * @param params prjct_id, loginID를 바탕
	 * @return 모든 상태의 각각의 정보들
	 * @author 최준열
	 */
	public List<IssueVO> selectListSchdul(Map<String, String> params) throws Exception;
}
