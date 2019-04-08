package kr.or.ddit.vo;

import org.springframework.stereotype.Component;

@Component
public class OfcpsVO {
	private String ofcps_id ;
	private String ofcps_nm ;
	public String getOfcps_id() {
		return ofcps_id;
	}
	public void setOfcps_id(String ofcps_id) {
		this.ofcps_id = ofcps_id;
	}
	public String getOfcps_nm() {
		return ofcps_nm;
	}
	public void setOfcps_nm(String ofcps_nm) {
		this.ofcps_nm = ofcps_nm;
	}
	
	
}
