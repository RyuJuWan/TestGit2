package kr.or.ddit.vo;

import org.springframework.stereotype.Component;

@Component
public class MtgFileVO {
	private String mtg_file_id     ;
	private String mtg_file_nm     ;
	private String mtg_file_save_nm;
	private String mtg             ;
	private String mtg_file_ty     ;
	private String mtg_file_size   ;
	private String mtg_file_sttus  ;
	private String mtg_file_date   ;
	private String mtg_file_inquiry;
	public String getMtg_file_id() {
		return mtg_file_id;
	}
	public void setMtg_file_id(String mtg_file_id) {
		this.mtg_file_id = mtg_file_id;
	}
	public String getMtg_file_nm() {
		return mtg_file_nm;
	}
	public void setMtg_file_nm(String mtg_file_nm) {
		this.mtg_file_nm = mtg_file_nm;
	}
	public String getMtg_file_save_nm() {
		return mtg_file_save_nm;
	}
	public void setMtg_file_save_nm(String mtg_file_save_nm) {
		this.mtg_file_save_nm = mtg_file_save_nm;
	}
	public String getMtg() {
		return mtg;
	}
	public void setMtg(String mtg) {
		this.mtg = mtg;
	}
	public String getMtg_file_ty() {
		return mtg_file_ty;
	}
	public void setMtg_file_ty(String mtg_file_ty) {
		this.mtg_file_ty = mtg_file_ty;
	}
	public String getMtg_file_size() {
		return mtg_file_size;
	}
	public void setMtg_file_size(String mtg_file_size) {
		this.mtg_file_size = mtg_file_size;
	}
	public String getMtg_file_sttus() {
		return mtg_file_sttus;
	}
	public void setMtg_file_sttus(String mtg_file_sttus) {
		this.mtg_file_sttus = mtg_file_sttus;
	}
	public String getMtg_file_date() {
		return mtg_file_date;
	}
	public void setMtg_file_date(String mtg_file_date) {
		this.mtg_file_date = mtg_file_date;
	}
	public String getMtg_file_inquiry() {
		return mtg_file_inquiry;
	}
	public void setMtg_file_inquiry(String mtg_file_inquiry) {
		this.mtg_file_inquiry = mtg_file_inquiry;
	}
}
