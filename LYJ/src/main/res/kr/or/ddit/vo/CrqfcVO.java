package kr.or.ddit.vo;

import org.springframework.stereotype.Component;

@Component
public class CrqfcVO {
	private String crqfc_id  ;
	private String crqfc_nm  ;
	public String getCrqfc_id() {
		return crqfc_id;
	}
	public void setCrqfc_id(String crqfc_id) {
		this.crqfc_id = crqfc_id;
	}
	public String getCrqfc_nm() {
		return crqfc_nm;
	}
	public void setCrqfc_nm(String crqfc_nm) {
		this.crqfc_nm = crqfc_nm;
	}
	
	
}
