package kr.or.ddit.vo;

import org.springframework.stereotype.Component;

@Component
public class RoleVO {
	private String role_id  ;
	private String role_nm  ;
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getRole_nm() {
		return role_nm;
	}
	public void setRole_nm(String role_nm) {
		this.role_nm = role_nm;
	}
	
	
}
