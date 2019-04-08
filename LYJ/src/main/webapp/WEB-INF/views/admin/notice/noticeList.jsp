<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
   $('#btnForm').click(function(){
      location.href = '${pageContext.request.contextPath}/admin/notice/noticeForm.do';
   });
   
   
   $('table tr:gt(0)').click(function(){
	   var notice_id = $(this).find('td:eq(0) input').val();
	   $(location).attr('href', '${pageContext.request.contextPath}/admin/notice/noticeView.do?notice_id=' + notice_id);
   });
});
</script>
</head>
<body>
<div class="content-body"><!-- Zero configuration table -->
<section id="configuration">
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title">공지사항</h4>
                    <a class="heading-elements-toggle"><i class="fa fa-ellipsis-v font-medium-3"></i></a>
                    <div class="heading-elements">
                        <ul class="list-inline mb-0">
                            <li><a data-action="collapse"><i class="ft-minus"></i></a></li>
                            <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                            <li><a data-action="expand"><i class="ft-maximize"></i></a></li>
                            <li><a data-action="close"><i class="ft-x"></i></a></li>
                        </ul>
                        
                    </div>
                </div>
                <div class="card-content collapse show">
                    <div class="card-body card-dashboard">
                          <form action="/empl/notice/noticeList.do" method="post" class="form-inline pull-right" >
		                        <select class="form-control" name="search_keycode" style="margin: 3px; height: 40px" >
		                           <option value="TOTAL">전체</option>
		                           <option value="TITLE">제목</option>
		                           <option value="CONTENT">내용</option>
		                        </select>
		                        <input id="search_keyword" name="search_keyword" type="text" placeholder="검색어 입력..." class="form-control" style="height: 40px"/>
		                         <button type="submit" class="btn btn-warning btn-min-width mr-1 mb-1" style="margin-left:3px; height: 40px; margin-top: 12px">검색</button>
		                         <button type="button" id="btnForm" class="btn btn-danger btn-min-width mr-1 mb-1" value="계획서등록" style="  margin-top: 12px; width: 100px;height: 40px " >게시글 작성</button>
		                  </form>
                      
                    <div class="table-responsive">
                        <table class="table mb-0">
                            <thead class="bg-teal bg-lighten-4">
                                <tr>
                                    <th scope="col" width="5%" style="text-align:center">No</th>
									<th scope="col" width="55%" style="text-align:center">제목</th>
									<th scope="col" width="20%" style="text-align:center">작성일</th>
									<th scope="col" width="10%" style="text-align:center">조회수</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach items="${noticeList }" var="notice">
                            		<tr>
                            			<td style="text-align:center"><input type="hidden" value="${notice.notice_id }">${notice.rnum}</td>
                            			<td>${notice.notice_nm }</td>
                            			<td style="text-align:center">${notice.notice_date }</td>
                            			<td style="text-align:center">${notice.notice_inquiry }</td>
                            		</tr>
                            	</c:forEach>
                            </tbody>
                        </table>
                       ${pagingUtil}
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
			
    </div>
    </div>
    </div>
</body>
</html>