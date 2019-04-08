package kr.or.ddit.vo;

public class CHB_MessageVO {
	
	// 사용자에게 발송될 텍스트("최대 100자 이내로")
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
