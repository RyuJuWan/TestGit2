package kr.or.ddit.dy_risk.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.IpcrVO;
import kr.or.ddit.vo.RiskVO;
import kr.or.ddit.vo.SttusVO;

public interface IDy_riskService {
	/**
	 * 리스크를 추가하는 메서드
	 * @param riskInfo 리스크를 추가할 때 필요한 데이터들
	 * @return none
	 * @author 최준열
	 */
	public void insertBoard(RiskVO riskInfo) throws Exception;
	
	/**
	 * 리스크를 수정하는 메서드
	 * @param riskVO 리스크의 수정할 부분의 데이터들
	 * @return none
	 * @author 최준열
	 */
	public void updateBoard(RiskVO riskVO) throws Exception;
	
	/**
	 * 리스크들의 총 갯수를 구하는 메서드
	 * @param params 리스크들의 총 갯수
	 * @return none
	 * @author 최준열
	 */
	public int totalCount(Map<String, String> params) throws Exception;
	
	/**
	 * 리스크들의 총 리스트를 가져오는 메서드
	 * @param params 검색어(등록자, 담당자)
	 * @return none
	 * @author 최준열
	 */
	public List<RiskVO> boardList(Map<String, String> params) throws Exception;
	
	/**
	 * View에서 선택한 리스크의 정보들
	 * @param 선택한 리스크의 id
	 * @return 선택한 리스크들의 정보들
	 * @author 최준열
	 */
	public RiskVO boardViewInfo(Map<String, String> params) throws Exception;
	
	/**
	 * 선택한 리스크의 대한 프로젝트 명을 가져오는 메서드
	 * @param 리스크에 저장된 프로젝트 id
	 * @return 프로젝트 명
	 * @author 최준열
	 */
	public String getPrjctName(Map<String, String> params) throws Exception;
	
	/**
	 * 프로젝트에 참여된 팀원들의 정보를 가져오는 메서드
	 * @param 리스크에 저장된 프로젝트 id
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
}
