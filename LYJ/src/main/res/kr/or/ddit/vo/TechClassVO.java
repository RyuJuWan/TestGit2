package kr.or.ddit.vo;

import org.springframework.stereotype.Component;

@Component
public class TechClassVO {
	private String tech_class_id ;
	private String tech_class_nm ;
	public String getTech_class_id() {
		return tech_class_id;
	}
	public void setTech_class_id(String tech_class_id) {
		this.tech_class_id = tech_class_id;
	}
	public String getTech_class_nm() {
		return tech_class_nm;
	}
	public void setTech_class_nm(String tech_class_nm) {
		this.tech_class_nm = tech_class_nm;
	}
	
	
}
