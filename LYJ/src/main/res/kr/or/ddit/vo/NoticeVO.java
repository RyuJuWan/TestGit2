package kr.or.ddit.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class NoticeVO {
	private String notice_id       ;
	private String notice_nm       ;
	private String notice_empl     ;
	private String notice_cn       ;
	private String notice_inquiry  ;
	private String notice_date     ;
	private String notice_delete   ;
	private String notice_file     ;
	private MultipartFile fileitem;
	private List<NoticeVO> nofiVO;
	private String rnum;
	
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public MultipartFile getFileitem() {
		return fileitem;
	}
	public void setFileitem(MultipartFile fileitem) {
		this.fileitem = fileitem;
	}
	public List<NoticeVO> getNofiVO() {
		return nofiVO;
	}
	public void setNofiVO(List<NoticeVO> nofiVO) {
		this.nofiVO = nofiVO;
	}
	public String getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(String notice_id) {
		this.notice_id = notice_id;
	}
	public String getNotice_nm() {
		return notice_nm;
	}
	public void setNotice_nm(String notice_nm) {
		this.notice_nm = notice_nm;
	}
	public String getNotice_empl() {
		return notice_empl;
	}
	public void setNotice_empl(String notice_empl) {
		this.notice_empl = notice_empl;
	}
	public String getNotice_cn() {
		return notice_cn;
	}
	public void setNotice_cn(String notice_cn) {
		this.notice_cn = notice_cn;
	}
	public String getNotice_inquiry() {
		return notice_inquiry;
	}
	public void setNotice_inquiry(String notice_inquiry) {
		this.notice_inquiry = notice_inquiry;
	}
	public String getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(String notice_date) {
		this.notice_date = notice_date;
	}
	public String getNotice_delete() {
		return notice_delete;
	}
	public void setNotice_delete(String notice_delete) {
		this.notice_delete = notice_delete;
	}
	public String getNotice_file() {
		return notice_file;
	}
	public void setNotice_file(String notice_file) {
		this.notice_file = notice_file;
	}
	
	
}
