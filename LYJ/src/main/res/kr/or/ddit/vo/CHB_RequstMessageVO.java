package kr.or.ddit.vo;

public class CHB_RequstMessageVO {
	
	// 메세지의 속성 : test, photo
	private String type;
	
	//자동 응답 명령어의 메세지
	private String content;

	public String getType() {
		return type;
	}

	public String getContent() {
		return content;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
