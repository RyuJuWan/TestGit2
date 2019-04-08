package kr.or.ddit.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class RolePagingUtilCrqfc {
	private int crqfcCurrentPage;		// 현재 페이지 번호
	private int totalCount;			// 전체 게시글 갯수
	private int totalPage;			// 전체 페이지 갯수
	private int blockCount = 10;	// 페이지별 출력될 게시글 갯수
	private int blockPage = 5;		// 페이지별 출력될 페이지네이션 메뉴 갯수
	private int startPage;			// 페이지별 출력될 페이지네이션 시작 페이지 번호
	private int endPage;			// 페이지별 출력될 페이지네이션 끝 페이지 번호
	private int startCount;			// 페이지별 출력될 게시글 중 시작 게시글 번호
	private int endCount;			// 페이지별 출력될 게시글 중 끝 게시글 번호
	
	private String params = "";			// 리스트 출력 jsp에 현재 게시글번호 파라미터 외 파라미터들을 조합
	private StringBuffer pageHtmls = new StringBuffer();	// 페이지네이션 컨텐츠 저장
	private HttpServletRequest request;
	
	public RolePagingUtilCrqfc(int totalCount, int crqfcCurrentPage, HttpServletRequest request) {
		super();
		this.totalCount = totalCount;
		this.crqfcCurrentPage = crqfcCurrentPage;
		this.request = request;
		
		makePageHtml();
	}
	
	public RolePagingUtilCrqfc(int totalCount, int crqfcCurrentPage, HttpServletRequest request, int blockCount, int blockPage) {
		super();
		this.totalCount = totalCount;
		this.crqfcCurrentPage = crqfcCurrentPage;
		this.request = request;
		this.blockCount = blockCount;
		this.blockPage = blockPage;
		
		makePageHtml();
	}
	
	private void makePageHtml() {
		// Math.ceil(10.5)
		this.totalPage = (int) Math.ceil(this.totalCount / (double)this.blockCount);
		
		if(this.totalPage == 0){
			this.totalPage = 1;
		}
		
		// 페이지별 출력될 시작, 끝 게시글 번호(rnum)
		this.startCount = this.totalCount - (this.crqfcCurrentPage - 1) * this.blockCount;
		this.endCount = this.startCount - this.blockCount + 1;
		
		if(this.endCount < 0){
			this.endCount = 1;
		}
		
		// 이전 |1|2|3|4|5| 다음
		this.startPage = ((this.crqfcCurrentPage - 1) / this.blockPage * this.blockPage) + 1;
		this.endPage = this.startPage + this.blockPage - 1;
		
		if(this.endPage > this.totalPage){
			this.endPage = this.totalPage;
		}
		
		String requestURI = this.request.getRequestURI();
		
//		Enumeration<String> paramKeys = this.request.getParameterNames();
//		while(paramKeys.hasMoreElements()){
//			String key = paramKeys.nextElement();
//			if("crqfcCurrentPage".intern() != key.intern()){
//				String[] values = this.request.getParameterValues(key);
//				for(String value : values){
//					// search_keycode=TOTAL&search_keyword=검색어&
//					this.params += key + "=" + value + "&";
//				}
//			}
//		}
		
		int prev_page = crqfcCurrentPage - 1;
		int next_page = crqfcCurrentPage + 1;
//		
//		this.pageHtmls.append("<script type='text/javascript'>");
//		this.pageHtmls.append("function changeCrqfcPage(pageNum){                                                    ");
//		this.pageHtmls.append("	$.ajax({                                                                             ");
//		this.pageHtmls.append("		type : 'POST',                                                                           ");
//		this.pageHtmls.append("		dataType : 'JSON',                                                                       ");
//		this.pageHtmls.append("		data : {crqfcCurrentPage : pageNum},                                                     ");
//		this.pageHtmls.append("		url : 'changeCrqfcPage.do',               ");
//		this.pageHtmls.append("		error : function(result){                                                                ");
//		this.pageHtmls.append("			alert('자격증 페이징 처리 실패');                                                    ");
//		this.pageHtmls.append("		},                                                                                       ");
//		this.pageHtmls.append("		success : function(result){                                                              ");
//		this.pageHtmls.append("			 alert('일단성공');");
//		this.pageHtmls.append("			 code='';");
//		this.pageHtmls.append("			 $.each(result, function(i){");
//		this.pageHtmls.append("			 	code += '<tr><td><input type=hidden value=' + result.crqfcHoldPageList[i].crqfc_hold_empl + '/' + result.crqfcHoldPageList[i].crqfc_hold_crqfc + '/>' + result.crqfcHoldPageList[i].rnum + '</td>'");
//		this.pageHtmls.append("			 	$.each(");
//		
//						code += "<tr><td>" + res[i].id + "</td>";
//						code += "<td>" + res[i].name + "</td>";
//						code += "<td>" + res[i].addr + "</td>";
//						code += "<td>" + res[i].tel + "</td>";
//						code += "<td>" + res[i].mail + "</td></tr>";
//					})
//					code += "</table>";
//					$('#result').html(code);                                                                            ");
//		this.pageHtmls.append("			 for()");
//		this.pageHtmls.append("			 for()");
//		this.pageHtmls.append("			 for()");
//		this.pageHtmls.append("		}                                                                                        ");
//		this.pageHtmls.append("	});                                                                                          ");
//		this.pageHtmls.append("}                                                                                             ");
//		this.pageHtmls.append("</script>");
		
		// 이전 |1|2|3|4|5| 다음
		this.pageHtmls.append("<div class=''>");
		this.pageHtmls.append("<nav aria-label='Page navigation'>");
		this.pageHtmls.append("<ul class='pagination justify-content-center'>");
		
		// 이전
		if((this.crqfcCurrentPage-1)==0){
			this.pageHtmls.append("<li class='page-item disabled' ><a class='page-link' href='#'>« Prev</a></li>");
		}else{
//		    this.pageHtmls.append("<li class='page-item'><a class='page-link' onclick='changeCrqfcPage(" + prev_page + ")' aria-label='Previous'><span aria-hidden='true'>« Prev</span><span class='sr-only'>Previous</span></a></li>");
		    this.pageHtmls.append("<li class='page-item'><a class='page-link' href='"+ requestURI+"?"+params+ "crqfcCurrentPage="+(this.crqfcCurrentPage-1) +"' aria-label='Previous'><span aria-hidden='true'>« Prev</span><span class='sr-only'>Previous</span></a></li>");
		}

		
		// |1|2|3|4|5|
		for(int i=this.startPage; i<=this.endPage; i++){
			if(this.crqfcCurrentPage == i){
				this.pageHtmls.append("<li class='page-item active disabled'><a class='page-link' href='#'>" + i + "</a></li>");
			}else{
//				this.pageHtmls.append("<li class='page-item'><a class='page-link' onclick='changeCrqfcPage(" + i + ")'>" + i + "</a></li>");
				this.pageHtmls.append("<li class='page-item'><a class='page-link' href='" + requestURI + "?" + params + "crqfcCurrentPage=" + i + "'>" + i + "</a></li>");
			}
		}
		
		// 다음
		if(this.crqfcCurrentPage < this.totalPage){
//			this.pageHtmls.append("<li class='page-item'><a class='page-link' onclick='changeCrqfcPage(" + next_page + ")' aria-label='Next'><span aria-hidden='true'>Next »</span><span class='sr-only'>Next</span></a></li>");
			this.pageHtmls.append("<li class='page-item'><a class='page-link' href='" + requestURI + "?" + params + "crqfcCurrentPage=" + (this.crqfcCurrentPage + 1) + "' aria-label='Next'><span aria-hidden='true'>Next »</span><span class='sr-only'>Next</span></a></li>");
		}else{
			this.pageHtmls.append("<li class='page-item disabled'><a class='page-link' href='#'>Next »</a></li>");
		}
		
		this.pageHtmls.append("</ul>");
		this.pageHtmls.append("</nav>");
		this.pageHtmls.append("</div>");
		
	}

	public int getStartCount() {
		return startCount;
	}

	public int getEndCount() {
		return endCount;
	}

	public String getPageHtmls() {
		return pageHtmls.toString();
	}
}
