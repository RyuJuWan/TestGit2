package kr.or.ddit.vo;

import org.springframework.stereotype.Component;

@Component
public class ReprtTyVO {
	private String reprt_ty_id    ;
	private String reprt_ty_nm    ;
	public String getReprt_ty_id() {
		return reprt_ty_id;
	}
	public void setReprt_ty_id(String reprt_ty_id) {
		this.reprt_ty_id = reprt_ty_id;
	}
	public String getReprt_ty_nm() {
		return reprt_ty_nm;
	}
	public void setReprt_ty_nm(String reprt_ty_nm) {
		this.reprt_ty_nm = reprt_ty_nm;
	}
}
