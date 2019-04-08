package kr.or.ddit.dept.dao;

import java.util.List;

import kr.or.ddit.vo.DeptVO;

public interface IDeptDao {
	/**
	 * 부서 리스트를 가져오는 메서드
	 * @return 부서 리스트
	 * @author LYJ
	 * @since 2019.02.22
	 * @throws Exception
	 */
	public List<DeptVO> deptList() throws Exception;

}
