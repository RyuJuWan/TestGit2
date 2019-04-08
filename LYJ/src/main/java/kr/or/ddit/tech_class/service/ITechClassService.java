package kr.or.ddit.tech_class.service;

import java.util.List;

import kr.or.ddit.vo.TechClassVO;

public interface ITechClassService {
	/**
	 * 기술등급 리스트를 가져오는 메서드
	 * @return 기술등급 리스트
	 * @author LYJ
	 * @since 2019.02.22
	 * @throws Exception
	 */
	public List<TechClassVO> techClassList() throws Exception;
}
