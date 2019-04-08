package kr.or.ddit.vo;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Administrator
 *
 */
@Component
public class MtgVO {
	private String rnum;
	private String mtg_id                   ;
	private String mtg_prjct                ;
	private String mtg_dt                   ;
	private String mtg_nm                   ;
	private String mtg_cn                   ;
	private String mtg_video_alt            ;
	private String mtg_place                ;
	private String mtg_empl                 ;
	private String mtg_date                 ;
	private String mtg_sanctn_id            ;
	private String mtg_specfpapers_ty_id    ;
	private MultipartFile fileitem;
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public String getMtg_id() {
		return mtg_id;
	}
	public void setMtg_id(String mtg_id) {
		this.mtg_id = mtg_id;
	}
	public String getMtg_prjct() {
		return mtg_prjct;
	}
	public void setMtg_prjct(String mtg_prjct) {
		this.mtg_prjct = mtg_prjct;
	}
	public String getMtg_dt() {
		return mtg_dt;
	}
	public void setMtg_dt(String mtg_dt) {
		this.mtg_dt = mtg_dt;
	}
	public String getMtg_nm() {
		return mtg_nm;
	}
	public void setMtg_nm(String mtg_nm) {
		this.mtg_nm = mtg_nm;
	}
	public String getMtg_cn() {
		return mtg_cn;
	}
	public void setMtg_cn(String mtg_cn) {
		this.mtg_cn = mtg_cn;
	}
	public String getMtg_video_alt() {
		return mtg_video_alt;
	}
	public void setMtg_video_alt(String mtg_video_alt) {
		this.mtg_video_alt = mtg_video_alt;
	}
	public String getMtg_place() {
		return mtg_place;
	}
	public void setMtg_place(String mtg_place) {
		this.mtg_place = mtg_place;
	}
	public String getMtg_empl() {
		return mtg_empl;
	}
	public void setMtg_empl(String mtg_empl) {
		this.mtg_empl = mtg_empl;
	}
	public String getMtg_date() {
		return mtg_date;
	}
	public void setMtg_date(String mtg_date) {
		this.mtg_date = mtg_date;
	}
	public String getMtg_sanctn_id() {
		return mtg_sanctn_id;
	}
	public void setMtg_sanctn_id(String mtg_sanctn_id) {
		this.mtg_sanctn_id = mtg_sanctn_id;
	}
	public String getMtg_specfpapers_ty_id() {
		return mtg_specfpapers_ty_id;
	}
	public void setMtg_specfpapers_ty_id(String mtg_specfpapers_ty_id) {
		this.mtg_specfpapers_ty_id = mtg_specfpapers_ty_id;
	}
	public MultipartFile getFileitem() {
		return fileitem;
	}
	public void setFileitem(MultipartFile fileitem) {
		this.fileitem = fileitem;
	}
	
	
}
