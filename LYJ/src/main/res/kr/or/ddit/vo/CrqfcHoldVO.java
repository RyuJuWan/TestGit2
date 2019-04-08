package kr.or.ddit.vo;

import org.springframework.stereotype.Component;

@Component
public class CrqfcHoldVO {
	private String rnum;
	private String crqfc_hold_empl  ;
	private String crqfc_hold_crqfc ;
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public String getCrqfc_hold_empl() {
		return crqfc_hold_empl;
	}
	public void setCrqfc_hold_empl(String crqfc_hold_empl) {
		this.crqfc_hold_empl = crqfc_hold_empl;
	}
	public String getCrqfc_hold_crqfc() {
		return crqfc_hold_crqfc;
	}
	public void setCrqfc_hold_crqfc(String crqfc_hold_crqfc) {
		this.crqfc_hold_crqfc = crqfc_hold_crqfc;
	}
	
	
}
