package kr.or.ddit.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ExpndtrAnactVO {
	private String rnum;
	private String expndtr_anact_id           ;
	private String expndtr_anact_nm           ;
	private String expndtr_anact_prjct_id     ;
	private String expndtr_anact_wrter        ;
	private String expndtr_anact_date         ;
	private String expndtr_anact_sanctn_id    ;
	private String expndtr_anact_papers_ty_id ;
	private String expndtr_anact_expndtr      ;
	private String expndtr_anact_amount       ;
	private String expndtr_anact_cn           ;
	private MultipartFile fileitem;
	private List<ExpndtrAnactVO> exfiVO;
	private List<PrjctVO> prjVO;
	
	
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public String getExpndtr_anact_id() {
		return expndtr_anact_id;
	}
	public void setExpndtr_anact_id(String expndtr_anact_id) {
		this.expndtr_anact_id = expndtr_anact_id;
	}
	public String getExpndtr_anact_nm() {
		return expndtr_anact_nm;
	}
	public void setExpndtr_anact_nm(String expndtr_anact_nm) {
		this.expndtr_anact_nm = expndtr_anact_nm;
	}
	public String getExpndtr_anact_prjct_id() {
		return expndtr_anact_prjct_id;
	}
	public void setExpndtr_anact_prjct_id(String expndtr_anact_prjct_id) {
		this.expndtr_anact_prjct_id = expndtr_anact_prjct_id;
	}
	public String getExpndtr_anact_wrter() {
		return expndtr_anact_wrter;
	}
	public void setExpndtr_anact_wrter(String expndtr_anact_wrter) {
		this.expndtr_anact_wrter = expndtr_anact_wrter;
	}
	public String getExpndtr_anact_date() {
		return expndtr_anact_date;
	}
	public void setExpndtr_anact_date(String expndtr_anact_date) {
		this.expndtr_anact_date = expndtr_anact_date;
	}
	public String getExpndtr_anact_sanctn_id() {
		return expndtr_anact_sanctn_id;
	}
	public void setExpndtr_anact_sanctn_id(String expndtr_anact_sanctn_id) {
		this.expndtr_anact_sanctn_id = expndtr_anact_sanctn_id;
	}
	public String getExpndtr_anact_papers_ty_id() {
		return expndtr_anact_papers_ty_id;
	}
	public void setExpndtr_anact_papers_ty_id(String expndtr_anact_papers_ty_id) {
		this.expndtr_anact_papers_ty_id = expndtr_anact_papers_ty_id;
	}
	public String getExpndtr_anact_expndtr() {
		return expndtr_anact_expndtr;
	}
	public void setExpndtr_anact_expndtr(String expndtr_anact_expndtr) {
		this.expndtr_anact_expndtr = expndtr_anact_expndtr;
	}
	public String getExpndtr_anact_amount() {
		return expndtr_anact_amount;
	}
	public void setExpndtr_anact_amount(String expndtr_anact_amount) {
		this.expndtr_anact_amount = expndtr_anact_amount;
	}
	public String getExpndtr_anact_cn() {
		return expndtr_anact_cn;
	}
	public void setExpndtr_anact_cn(String expndtr_anact_cn) {
		this.expndtr_anact_cn = expndtr_anact_cn;
	}
	public MultipartFile getFileitem() {
		return fileitem;
	}
	public void setFileitem(MultipartFile fileitem) {
		this.fileitem = fileitem;
	}
	public List<ExpndtrAnactVO> getExfiVO() {
		return exfiVO;
	}
	public void setExfiVO(List<ExpndtrAnactVO> exfiVO) {
		this.exfiVO = exfiVO;
	}
	public List<PrjctVO> getPrjVO() {
		return prjVO;
	}
	public void setPrjVO(List<PrjctVO> prjVO) {
		this.prjVO = prjVO;
	}
	
	

}
