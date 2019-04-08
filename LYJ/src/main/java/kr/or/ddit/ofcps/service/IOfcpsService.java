package kr.or.ddit.ofcps.service;

import java.util.List;

import kr.or.ddit.vo.OfcpsVO;

public interface IOfcpsService {
	/**
	 * 직위 리스트를 가져오는 메서드
	 * @return 직위 리스트
	 * @author LYJ
	 * @since 2019.02.22
	 * @throws Exception
	 */
	public List<OfcpsVO> ofcpsList() throws Exception;
}
