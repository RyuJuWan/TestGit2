package kr.or.ddit.vo;

public class CHB_ResponseMessageVO {
	private CHB_MessageVO message;
	private CHB_KeyboardVO keyboard;
	
	public CHB_MessageVO getMessage() {
		return message;
	}
	public CHB_KeyboardVO getKeyboard() {
		return keyboard;
	}
	public void setMessage(CHB_MessageVO message) {
		this.message = message;
	}
	public void setKeyboard(CHB_KeyboardVO keyboard) {
		this.keyboard = keyboard;
	}
}
