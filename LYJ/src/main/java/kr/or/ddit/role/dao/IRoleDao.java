package kr.or.ddit.role.dao;

import java.util.List;

import kr.or.ddit.vo.RoleVO;

public interface IRoleDao {
	/**
	 * 역할 리스트를 가져오는 메서드
	 * @return 역할 리스트
	 * @author LYJ
	 * @since 2019.02.26
	 * @throws Exception
	 */
	public List<RoleVO> roleList() throws Exception;

}
