package kr.or.ddit.vo;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ReprtVO {
	private String rnum;
	private String reprt_id                    ;
	private String reprt_prjct                 ;
	private String reprt_nm                    ;
	private String reprt_cn                    ;
	private String reprt_empl                  ;
	private String reprt_ty_id                 ;
	private String reprt_date                  ;
	private String reprt_start                 ;
	private String reprt_clos                  ;
	private String reprt_atchmnfl              ;
	private String reprt_sanctn_id             ;
	private String reprt_specfpapers_ty_id     ;
	private MultipartFile fileitem;
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public String getReprt_id() {
		return reprt_id;
	}
	public void setReprt_id(String reprt_id) {
		this.reprt_id = reprt_id;
	}
	public String getReprt_prjct() {
		return reprt_prjct;
	}
	public void setReprt_prjct(String reprt_prjct) {
		this.reprt_prjct = reprt_prjct;
	}
	public String getReprt_nm() {
		return reprt_nm;
	}
	public void setReprt_nm(String reprt_nm) {
		this.reprt_nm = reprt_nm;
	}
	public String getReprt_cn() {
		return reprt_cn;
	}
	public void setReprt_cn(String reprt_cn) {
		this.reprt_cn = reprt_cn;
	}
	public String getReprt_empl() {
		return reprt_empl;
	}
	public void setReprt_empl(String reprt_empl) {
		this.reprt_empl = reprt_empl;
	}
	public String getReprt_ty_id() {
		return reprt_ty_id;
	}
	public void setReprt_ty_id(String reprt_ty_id) {
		this.reprt_ty_id = reprt_ty_id;
	}
	public String getReprt_date() {
		return reprt_date;
	}
	public void setReprt_date(String reprt_date) {
		this.reprt_date = reprt_date;
	}
	public String getReprt_start() {
		return reprt_start;
	}
	public void setReprt_start(String reprt_start) {
		this.reprt_start = reprt_start;
	}
	public String getReprt_clos() {
		return reprt_clos;
	}
	public void setReprt_clos(String reprt_clos) {
		this.reprt_clos = reprt_clos;
	}
	public String getReprt_atchmnfl() {
		return reprt_atchmnfl;
	}
	public void setReprt_atchmnfl(String reprt_atchmnfl) {
		this.reprt_atchmnfl = reprt_atchmnfl;
	}
	public String getReprt_sanctn_id() {
		return reprt_sanctn_id;
	}
	public void setReprt_sanctn_id(String reprt_sanctn_id) {
		this.reprt_sanctn_id = reprt_sanctn_id;
	}
	public String getReprt_specfpapers_ty_id() {
		return reprt_specfpapers_ty_id;
	}
	public void setReprt_specfpapers_ty_id(String reprt_specfpapers_ty_id) {
		this.reprt_specfpapers_ty_id = reprt_specfpapers_ty_id;
	}
	public MultipartFile getFileitem() {
		return fileitem;
	}
	public void setFileitem(MultipartFile fileitem) {
		this.fileitem = fileitem;
	}
	
}
