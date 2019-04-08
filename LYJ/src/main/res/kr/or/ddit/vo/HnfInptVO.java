package kr.or.ddit.vo;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class HnfInptVO {
	private String rnum;
	private String hnf_inpt_actpln_id;
	private String hnf_inpt_plan_id;
	private String hnf_inpt_prjct_id;
	private String hnf_inpt_actpln_prpsl;
	private String hnf_inpt_actpln_empl;
	private String hnf_inpt_actpln_date;
	private String hnf_inpt_actpln_inpt;
	private String hnf_inpt_actpln_clos;
	private String hnf_inpt_actpln_santn_id;
	private String hnf_specfpapers_ty_id;
	private MultipartFile fileitem;
	private List<HnfInptFileVO> hnfiVO;
	private List<PrjctVO> prjVO;
	
	
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public String getHnf_inpt_actpln_id() {
		return hnf_inpt_actpln_id;
	}
	public void setHnf_inpt_actpln_id(String hnf_inpt_actpln_id) {
		this.hnf_inpt_actpln_id = hnf_inpt_actpln_id;
	}
	public String getHnf_inpt_plan_id() {
		return hnf_inpt_plan_id;
	}
	public void setHnf_inpt_plan_id(String hnf_inpt_plan_id) {
		this.hnf_inpt_plan_id = hnf_inpt_plan_id;
	}
	public String getHnf_inpt_prjct_id() {
		return hnf_inpt_prjct_id;
	}
	public void setHnf_inpt_prjct_id(String hnf_inpt_prjct_id) {
		this.hnf_inpt_prjct_id = hnf_inpt_prjct_id;
	}
	public String getHnf_inpt_actpln_prpsl() {
		return hnf_inpt_actpln_prpsl;
	}
	public void setHnf_inpt_actpln_prpsl(String hnf_inpt_actpln_prpsl) {
		this.hnf_inpt_actpln_prpsl = hnf_inpt_actpln_prpsl;
	}
	public String getHnf_inpt_actpln_empl() {
		return hnf_inpt_actpln_empl;
	}
	public void setHnf_inpt_actpln_empl(String hnf_inpt_actpln_empl) {
		this.hnf_inpt_actpln_empl = hnf_inpt_actpln_empl;
	}
	public String getHnf_inpt_actpln_date() {
		return hnf_inpt_actpln_date;
	}
	public void setHnf_inpt_actpln_date(String hnf_inpt_actpln_date) {
		this.hnf_inpt_actpln_date = hnf_inpt_actpln_date;
	}
	public String getHnf_inpt_actpln_inpt() {
		return hnf_inpt_actpln_inpt;
	}
	public void setHnf_inpt_actpln_inpt(String hnf_inpt_actpln_inpt) {
		this.hnf_inpt_actpln_inpt = hnf_inpt_actpln_inpt;
	}
	public String getHnf_inpt_actpln_clos() {
		return hnf_inpt_actpln_clos;
	}
	public void setHnf_inpt_actpln_clos(String hnf_inpt_actpln_clos) {
		this.hnf_inpt_actpln_clos = hnf_inpt_actpln_clos;
	}
	public String getHnf_inpt_actpln_santn_id() {
		return hnf_inpt_actpln_santn_id;
	}
	public void setHnf_inpt_actpln_santn_id(String hnf_inpt_actpln_santn_id) {
		this.hnf_inpt_actpln_santn_id = hnf_inpt_actpln_santn_id;
	}
	public String getHnf_specfpapers_ty_id() {
		return hnf_specfpapers_ty_id;
	}
	public void setHnf_specfpapers_ty_id(String hnf_specfpapers_ty_id) {
		this.hnf_specfpapers_ty_id = hnf_specfpapers_ty_id;
	}
	public MultipartFile getFileitem() {
		return fileitem;
	}
	public void setFileitem(MultipartFile fileitems) {
		this.fileitem = fileitems;
	}
	public List<HnfInptFileVO> getHnfiVO() {
		return hnfiVO;
	}
	public void setHnfiVO(List<HnfInptFileVO> hnfiVO) {
		this.hnfiVO = hnfiVO;
	}
	public List<PrjctVO> getPrjVO() {
		return prjVO;
	}
	public void setPrjVO(List<PrjctVO> prjVO) {
		this.prjVO = prjVO;
	}
	
	
}
