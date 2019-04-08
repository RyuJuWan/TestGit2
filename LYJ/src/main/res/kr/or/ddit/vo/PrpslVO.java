package kr.or.ddit.vo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PrpslVO {
	private String prpsl_id             ;
	private String prpsl_nm             ;
	private String prpsl_rqpps_id       ;
	private String prpsl_empl           ;
	private String prpsl_wrting_date    ;
	private String prpsl_cn             ;
	private String prpsl_prjct_start    ;
	private String prpsl_prjct_clos     ;
	private String prpsl_sanctn_id      ;
	private String prpsl_papers_ty      ;
	private String rnum;
	private MultipartFile fileitem;
	private List<PrpslFileVO> prfiVO;
	private List<PrjctVO> prjVO;
	
	
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public String getPrpsl_id() {
		return prpsl_id;
	}
	public void setPrpsl_id(String prpsl_id) {
		this.prpsl_id = prpsl_id;
	}
	public String getPrpsl_nm() {
		return prpsl_nm;
	}
	public void setPrpsl_nm(String prpsl_nm) {
		this.prpsl_nm = prpsl_nm;
	}
	public String getPrpsl_rqpps_id() {
		return prpsl_rqpps_id;
	}
	public void setPrpsl_rqpps_id(String prpsl_rqpps_id) {
		this.prpsl_rqpps_id = prpsl_rqpps_id;
	}
	public String getPrpsl_empl() {
		return prpsl_empl;
	}
	public void setPrpsl_empl(String prpsl_empl) {
		this.prpsl_empl = prpsl_empl;
	}
	public String getPrpsl_wrting_date() {
		return prpsl_wrting_date;
	}
	public void setPrpsl_wrting_date(String prpsl_wrting_date) {
		this.prpsl_wrting_date = prpsl_wrting_date;
	}
	public String getPrpsl_cn() {
		return prpsl_cn;
	}
	public void setPrpsl_cn(String prpsl_cn) {
		this.prpsl_cn = prpsl_cn;
	}
	public String getPrpsl_prjct_start() {
		return prpsl_prjct_start;
	}
	public void setPrpsl_prjct_start(String prpsl_prjct_start) {
		this.prpsl_prjct_start = prpsl_prjct_start;
	}
	public String getPrpsl_prjct_clos() {
		return prpsl_prjct_clos;
	}
	public void setPrpsl_prjct_clos(String prpsl_prjct_clos) {
		this.prpsl_prjct_clos = prpsl_prjct_clos;
	}
	public String getPrpsl_sanctn_id() {
		return prpsl_sanctn_id;
	}
	public void setPrpsl_sanctn_id(String prpsl_sanctn_id) {
		this.prpsl_sanctn_id = prpsl_sanctn_id;
	}
	public String getPrpsl_papers_ty() {
		return prpsl_papers_ty;
	}
	public void setPrpsl_papers_ty(String prpsl_papers_ty) {
		this.prpsl_papers_ty = prpsl_papers_ty;
	}
	public MultipartFile getFileitem() {
		return fileitem;
	}
	public void setFileitem(MultipartFile fileitem) {
		this.fileitem = fileitem;
	}
	public List<PrpslFileVO> getPrfiVO() {
		return prfiVO;
	}
	public void setPrfiVO(List<PrpslFileVO> prfiVO) {
		this.prfiVO = prfiVO;
	}
	public List<PrjctVO> getPrjVO() {
		return prjVO;
	}
	public void setPrjVO(List<PrjctVO> prjVO) {
		this.prjVO = prjVO;
	}
	
	
}
