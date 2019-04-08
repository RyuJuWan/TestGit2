package kr.or.ddit.vo;

import org.springframework.stereotype.Component;

@Component
public class ReprtFileVO {
	private String reprt_file_id     ;
	private String reprt_file_nm     ;
	private String reprt_file_save_nm;
	private String reprt             ;
	private String reprt_file_ty     ;
	private String reprt_file_size   ;
	private String reprt_file_sttus  ;
	private String reprt_file_date   ;
	private String reprt_file_inquiry;
	
	public String getReprt_file_id() {
		return reprt_file_id;
	}
	public void setReprt_file_id(String reprt_file_id) {
		this.reprt_file_id = reprt_file_id;
	}
	public String getReprt_file_nm() {
		return reprt_file_nm;
	}
	public void setReprt_file_nm(String reprt_file_nm) {
		this.reprt_file_nm = reprt_file_nm;
	}
	public String getReprt_file_save_nm() {
		return reprt_file_save_nm;
	}
	public void setReprt_file_save_nm(String reprt_file_save_nm) {
		this.reprt_file_save_nm = reprt_file_save_nm;
	}
	public String getReprt() {
		return reprt;
	}
	public void setReprt(String reprt) {
		this.reprt = reprt;
	}
	public String getReprt_file_ty() {
		return reprt_file_ty;
	}
	public void setReprt_file_ty(String reprt_file_ty) {
		this.reprt_file_ty = reprt_file_ty;
	}
	public String getReprt_file_size() {
		return reprt_file_size;
	}
	public void setReprt_file_size(String reprt_file_size) {
		this.reprt_file_size = reprt_file_size;
	}
	public String getReprt_file_sttus() {
		return reprt_file_sttus;
	}
	public void setReprt_file_sttus(String reprt_file_sttus) {
		this.reprt_file_sttus = reprt_file_sttus;
	}
	public String getReprt_file_date() {
		return reprt_file_date;
	}
	public void setReprt_file_date(String reprt_file_date) {
		this.reprt_file_date = reprt_file_date;
	}
	public String getReprt_file_inquiry() {
		return reprt_file_inquiry;
	}
	public void setReprt_file_inquiry(String reprt_file_inquiry) {
		this.reprt_file_inquiry = reprt_file_inquiry;
	}
}
