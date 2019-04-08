package kr.or.ddit.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class DynmRecsroomVO {
	private String dynm_recsroom_id       ;
	private String dynm_recsroom_nm       ;
	private String dynm_recsroom_empl     ;
	private String dynm_recsroom_cn       ;
	private String dynm_recsroom_inquiry  ;
	private String dynm_recsroom_date     ;
	private String dynm_recsroom_delete   ;
	private String dynm_recsroom_file     ;
	private String prjct_id ;
	private String rnum;
	private MultipartFile fileitem;
	private List<DynmRecsroomFileVO> recsFiVO;
	private List<PrjctVO> prjVO;
	
	
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public String getDynm_recsroom_id() {
		return dynm_recsroom_id;
	}
	public void setDynm_recsroom_id(String dynm_recsroom_id) {
		this.dynm_recsroom_id = dynm_recsroom_id;
	}
	public String getDynm_recsroom_nm() {
		return dynm_recsroom_nm;
	}
	public void setDynm_recsroom_nm(String dynm_recsroom_nm) {
		this.dynm_recsroom_nm = dynm_recsroom_nm;
	}
	public String getDynm_recsroom_empl() {
		return dynm_recsroom_empl;
	}
	public void setDynm_recsroom_empl(String dynm_recsroom_empl) {
		this.dynm_recsroom_empl = dynm_recsroom_empl;
	}
	public String getDynm_recsroom_cn() {
		return dynm_recsroom_cn;
	}
	public void setDynm_recsroom_cn(String dynm_recsroom_cn) {
		this.dynm_recsroom_cn = dynm_recsroom_cn;
	}
	public String getDynm_recsroom_inquiry() {
		return dynm_recsroom_inquiry;
	}
	public void setDynm_recsroom_inquiry(String dynm_recsroom_inquiry) {
		this.dynm_recsroom_inquiry = dynm_recsroom_inquiry;
	}
	public String getDynm_recsroom_date() {
		return dynm_recsroom_date;
	}
	public void setDynm_recsroom_date(String dynm_recsroom_date) {
		this.dynm_recsroom_date = dynm_recsroom_date;
	}
	public String getDynm_recsroom_delete() {
		return dynm_recsroom_delete;
	}
	public void setDynm_recsroom_delete(String dynm_recsroom_delete) {
		this.dynm_recsroom_delete = dynm_recsroom_delete;
	}
	public String getDynm_recsroom_file() {
		return dynm_recsroom_file;
	}
	public void setDynm_recsroom_file(String dynm_recsroom_file) {
		this.dynm_recsroom_file = dynm_recsroom_file;
	}
	
	
	public String getPrjct_id() {
		return prjct_id;
	}
	public void setPrjct_id(String prjct_id) {
		this.prjct_id = prjct_id;
	}
	public MultipartFile getFileitem() {
		return fileitem;
	}
	public void setFileitem(MultipartFile fileitem) {
		this.fileitem = fileitem;
	}
	public List<DynmRecsroomFileVO> getRecsFiVO() {
		return recsFiVO;
	}
	public void setRecsFiVO(List<DynmRecsroomFileVO> recsFiVO) {
		this.recsFiVO = recsFiVO;
	}
	public List<PrjctVO> getPrjVO() {
		return prjVO;
	}
	public void setPrjVO(List<PrjctVO> prjVO) {
		this.prjVO = prjVO;
	}
	
	
}
