package kr.or.ddit.vo;

public class RiskVO {
	private String risk_id           ;
	private String risk_prjct        ;
	private String risk_nm           ;
	private String risk_compt        ;
	private String risk_regist_day   ;
	private String risk_regist       ;
	private String risk_chrg         ;
	private String risk_opetr_day    ;
	private String risk_cn           ;
	private String risk_ipcr         ;
	private String risk_sttus        ;
	private IpcrVO risk_ipcrVO;
	private SttusVO risk_sttusVO;
	
	public String getRisk_id() {
		return risk_id;
	}
	public void setRisk_id(String risk_id) {
		this.risk_id = risk_id;
	}
	public String getRisk_prjct() {
		return risk_prjct;
	}
	public void setRisk_prjct(String risk_prjct) {
		this.risk_prjct = risk_prjct;
	}
	public String getRisk_nm() {
		return risk_nm;
	}
	public void setRisk_nm(String risk_nm) {
		this.risk_nm = risk_nm;
	}
	public String getRisk_compt() {
		return risk_compt;
	}
	public void setRisk_compt(String risk_compt) {
		this.risk_compt = risk_compt;
	}
	public String getRisk_regist_day() {
		return risk_regist_day;
	}
	public void setRisk_regist_day(String risk_regist_day) {
		this.risk_regist_day = risk_regist_day;
	}
	public String getRisk_regist() {
		return risk_regist;
	}
	public void setRisk_regist(String risk_regist) {
		this.risk_regist = risk_regist;
	}
	public String getRisk_chrg() {
		return risk_chrg;
	}
	public void setRisk_chrg(String risk_chrg) {
		this.risk_chrg = risk_chrg;
	}
	public String getRisk_opetr_day() {
		return risk_opetr_day;
	}
	public void setRisk_opetr_day(String risk_opetr_day) {
		this.risk_opetr_day = risk_opetr_day;
	}
	public String getRisk_cn() {
		return risk_cn;
	}
	public void setRisk_cn(String risk_cn) {
		this.risk_cn = risk_cn;
	}
	public String getRisk_ipcr() {
		return risk_ipcr;
	}
	public void setRisk_ipcr(String risk_ipcr) {
		this.risk_ipcr = risk_ipcr;
	}
	public String getRisk_sttus() {
		return risk_sttus;
	}
	public void setRisk_sttus(String risk_sttus) {
		this.risk_sttus = risk_sttus;
	}
	public IpcrVO getRisk_ipcrVO() {
		return risk_ipcrVO;
	}
	public SttusVO getRisk_sttusVO() {
		return risk_sttusVO;
	}
	public void setRisk_ipcrVO(IpcrVO risk_ipcrVO) {
		this.risk_ipcrVO = risk_ipcrVO;
	}
	public void setRisk_sttusVO(SttusVO risk_sttusVO) {
		this.risk_sttusVO = risk_sttusVO;
	}
	
	
}
