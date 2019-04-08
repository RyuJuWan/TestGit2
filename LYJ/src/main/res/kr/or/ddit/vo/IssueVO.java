package kr.or.ddit.vo;

public class IssueVO {
	private String rnum;
	private String issue_id;
	private String issue_prjct;
	private String issue_risk;
	private String issue_nm;
	private String issue_regist_day;
	private String issue_opetr_day;
	private String issue_compt;
	private String issue_regist;
	private String issue_chrg;
	private String issue_cn;
	private String issue_ipcr;
	private String issue_sttus;
	private String issue_delete;
	private IpcrVO issue_ipcrVO;
	private SttusVO issue_sttusVO;
	
	public String getIssue_id() {
		return issue_id;
	}
	public void setIssue_id(String issue_id) {
		this.issue_id = issue_id;
	}
	public String getIssue_prjct() {
		return issue_prjct;
	}
	public void setIssue_prjct(String issue_prjct) {
		this.issue_prjct = issue_prjct;
	}
	public String getIssue_risk() {
		return issue_risk;
	}
	public void setIssue_risk(String issue_risk) {
		this.issue_risk = issue_risk;
	}
	public String getIssue_nm() {
		return issue_nm;
	}
	public void setIssue_nm(String issue_nm) {
		this.issue_nm = issue_nm;
	}
	public String getIssue_regist_day() {
		return issue_regist_day;
	}
	public void setIssue_regist_day(String issue_regist_day) {
		this.issue_regist_day = issue_regist_day;
	}
	public String getIssue_opetr_day() {
		return issue_opetr_day;
	}
	public void setIssue_opetr_day(String issue_opetr_day) {
		this.issue_opetr_day = issue_opetr_day;
	}
	public String getIssue_compt() {
		return issue_compt;
	}
	public void setIssue_compt(String issue_compt) {
		this.issue_compt = issue_compt;
	}
	public String getIssue_regist() {
		return issue_regist;
	}
	public void setIssue_regist(String issue_regist) {
		this.issue_regist = issue_regist;
	}
	public String getIssue_chrg() {
		return issue_chrg;
	}
	public void setIssue_chrg(String issue_chrg) {
		this.issue_chrg = issue_chrg;
	}
	public String getIssue_cn() {
		return issue_cn;
	}
	public void setIssue_cn(String issue_cn) {
		this.issue_cn = issue_cn;
	}
	public String getIssue_ipcr() {
		return issue_ipcr;
	}
	public void setIssue_ipcr(String issue_ipcr) {
		this.issue_ipcr = issue_ipcr;
	}
	public String getIssue_sttus() {
		return issue_sttus;
	}
	public void setIssue_sttus(String issue_sttus) {
		this.issue_sttus = issue_sttus;
	}
	public String getIssue_delete() {
		return issue_delete;
	}
	public void setIssue_delete(String issue_delete) {
		this.issue_delete = issue_delete;
	}
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public IpcrVO getIssue_ipcrVO() {
		return issue_ipcrVO;
	}
	public SttusVO getIssue_sttusVO() {
		return issue_sttusVO;
	}
	public void setIssue_ipcrVO(IpcrVO issue_ipcrVO) {
		this.issue_ipcrVO = issue_ipcrVO;
	}
	public void setIssue_sttusVO(SttusVO issue_sttusVO) {
		this.issue_sttusVO = issue_sttusVO;
	}
}
