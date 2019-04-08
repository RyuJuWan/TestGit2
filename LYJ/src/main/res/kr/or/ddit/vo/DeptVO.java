package kr.or.ddit.vo;

import org.springframework.stereotype.Component;

@Component
public class DeptVO {
	private String dept_id;
	private String dept_nm;
	
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_nm() {
		return dept_nm;
	}
	public void setDept_nm(String dept_nm) {
		this.dept_nm = dept_nm;
	}
}
