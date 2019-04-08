package kr.or.ddit.vo;

import org.springframework.stereotype.Component;

@Component
public class HnfInptPlanVO {
	private String hnf_inpt_plan_id     ;
	private String hnf_inpt_empl_id     ;
	private String hnf_inpt_role_id     ;
	private String hnf_inpt_plan_inpt   ;
	private String hnf_inpt_plan_clos   ;
	public String getHnf_inpt_plan_id() {
		return hnf_inpt_plan_id;
	}
	public void setHnf_inpt_plan_id(String hnf_inpt_plan_id) {
		this.hnf_inpt_plan_id = hnf_inpt_plan_id;
	}
	public String getHnf_inpt_empl_id() {
		return hnf_inpt_empl_id;
	}
	public void setHnf_inpt_empl_id(String hnf_inpt_empl_id) {
		this.hnf_inpt_empl_id = hnf_inpt_empl_id;
	}
	public String getHnf_inpt_role_id() {
		return hnf_inpt_role_id;
	}
	public void setHnf_inpt_role_id(String hnf_inpt_role_id) {
		this.hnf_inpt_role_id = hnf_inpt_role_id;
	}
	public String getHnf_inpt_plan_inpt() {
		return hnf_inpt_plan_inpt;
	}
	public void setHnf_inpt_plan_inpt(String hnf_inpt_plan_inpt) {
		this.hnf_inpt_plan_inpt = hnf_inpt_plan_inpt;
	}
	public String getHnf_inpt_plan_clos() {
		return hnf_inpt_plan_clos;
	}
	public void setHnf_inpt_plan_clos(String hnf_inpt_plan_clos) {
		this.hnf_inpt_plan_clos = hnf_inpt_plan_clos;
	}
	
	
}
