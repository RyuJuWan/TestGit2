package kr.or.ddit.vo;

import org.springframework.stereotype.Component;

@Component
public class PrjctVO {
	private String rnum;
	private String prjct_id      ;
	private String prjct_nm      ;
	private String prjct_inpt    ;
	private String prjct_clos    ;
	private String prjct_nmbr    ;
	private String prjct_cn      ;
	private String prjct_prpsl   ;
	private String prjct_empl    ;
	private String prjct_wbs_num ;
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public String getPrjct_id() {
		return prjct_id;
	}
	public void setPrjct_id(String prjct_id) {
		this.prjct_id = prjct_id;
	}
	public String getPrjct_nm() {
		return prjct_nm;
	}
	public void setPrjct_nm(String prjct_nm) {
		this.prjct_nm = prjct_nm;
	}
	public String getPrjct_inpt() {
		return prjct_inpt;
	}
	public void setPrjct_inpt(String prjct_inpt) {
		this.prjct_inpt = prjct_inpt;
	}
	public String getPrjct_clos() {
		return prjct_clos;
	}
	public void setPrjct_clos(String prjct_clos) {
		this.prjct_clos = prjct_clos;
	}
	public String getPrjct_nmbr() {
		return prjct_nmbr;
	}
	public void setPrjct_nmbr(String prjct_nmbr) {
		this.prjct_nmbr = prjct_nmbr;
	}
	public String getPrjct_cn() {
		return prjct_cn;
	}
	public void setPrjct_cn(String prjct_cn) {
		this.prjct_cn = prjct_cn;
	}
	public String getPrjct_prpsl() {
		return prjct_prpsl;
	}
	public void setPrjct_prpsl(String prjct_prpsl) {
		this.prjct_prpsl = prjct_prpsl;
	}
	public String getPrjct_empl() {
		return prjct_empl;
	}
	public void setPrjct_empl(String prjct_empl) {
		this.prjct_empl = prjct_empl;
	}
	public String getPrjct_wbs_num() {
		return prjct_wbs_num;
	}
	public void setPrjct_wbs_num(String prjct_wbs_num) {
		this.prjct_wbs_num = prjct_wbs_num;
	}
	
	
}
