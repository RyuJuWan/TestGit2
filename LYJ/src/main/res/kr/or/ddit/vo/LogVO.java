package kr.or.ddit.vo;

import org.springframework.stereotype.Component;

@Component
public class LogVO {
	private String log_id        ;
	private String log_prjct        ;
	private String log_cn        ;
	private String log_empl_id   ;
	private String log_date      ;
	public String getLog_id() {
		return log_id;
	}
	public void setLog_id(String log_id) {
		this.log_id = log_id;
	}
	public String getLog_prjct() {
		return log_prjct;
	}
	public void setLog_prjct(String log_prjct) {
		this.log_prjct = log_prjct;
	}
	public String getLog_empl_id() {
		return log_empl_id;
	}
	public void setLog_empl_id(String log_empl_id) {
		this.log_empl_id = log_empl_id;
	}
	public String getLog_cn() {
		return log_cn;
	}
	public void setLog_cn(String log_cn) {
		this.log_cn = log_cn;
	}
	public String getLog_date() {
		return log_date;
	}
	public void setLog_date(String log_date) {
		this.log_date = log_date;
	}
	
	
}   
