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
	$('table tr:gt(0)').click(function(){
		var rqpps_id = $(this).find('td:eq(0) input').val();
		$(location).attr('href', '${pageContext.request.contextPath}/empl/rqpps/rqppsView.do?rqpps_id=' + rqpps_id);
	});
	$('#btnForm').click(function(){
		location.href = '${pageContext.request.contextPath}/empl/rqpps/rqppsForm.do';
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
                    <h4 class="card-title">프로젝트 제안요청서</h4>
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
                       	<form action="${pageContext.request.contextPath }/empl/rqpps/rqppsList.do" method="post" class="form-inline pull-right" >
								<select class="form-control" name="search_keycode" style="margin: 3px; height: 40px">
									<option>검색조건</option>
									<option value="TOTAL">전체</option>
									<option value="TITLE">제목</option>
									<option value="CONTENT">내용</option>
									<option value="WRITER">작성자</option>
								</select>
								<input id="search_keyword" name="search_keyword" type="text" placeholder="검색어 입력..." class="form-control" style="height: 40px" />
							    <button type="submit" class="btn btn-warning btn-min-width mr-1 mb-1" style="margin-left:3px; height: 40px; margin-top: 12px">검색</button>
							    <button type="button" id="btnForm" class="btn btn-danger btn-min-width mr-1 mb-1" value="게시글등록" style="  margin-top: 12px; width: 100px;height: 40px ">게시글 등록</button>
						</form>
		                
                        <table class="table table-striped table-bordered zero-configuration"  style="margin: 70px 30px 10px 0px">
                            <thead>
                                <tr>
<!--                                 	<th>No</th> -->
                                    <th>#</th>
                                    <th>제안요청서명</th>
                                    <th>공고기관명</th>
                                    <th>사번</th>
                                    <th>작성일자</th>
                                    <th>프로젝트 시작일</th>
                                    <th>프로젝트 마감일</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${rqppsList }" var="rqpps">
                                <tr>
                               <td><input type="hidden" name="rqpps_no" value="${rqpps.rqpps_id }"/>${rqpps.rnum }</td>
<%--                                     <td>${rqpps.rqpps_id }</td> --%>
                                    <td>${rqpps.rqpps_nm }</td>
                                    <td>${rqpps.rqpps_pblanc }</td>
                                    <td>${rqpps.rqpps_empl }</td>
                                    <td>${rqpps.rqpps_wrting_date }</td>
                                    <td>${rqpps.rqpps_prjct_start }</td>
                                    <td>${rqpps.rqpps_prjct_clos }</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                         ${paging}
<!--                         <div class="col-lg-6 col-md-12"  > -->
<!-- 						<nav aria-label="Page navigation"> -->
<!-- 							<ul class="pagination justify-content-center"> -->
<!-- 								<li class="page-item"> -->
<!-- 									<a class="page-link" href="#" aria-label="Previous"> -->
<!-- 										<span aria-hidden="true">≪ Prev</span> -->
<!-- 										<span class="sr-only">Previous</span> -->
<!-- 									</a> -->
<!-- 								</li> -->
<!-- 								<li class="page-item"><a class="page-link" href="#">1</a></li> -->
<!-- 								<li class="page-item"><a class="page-link" href="#">2</a></li> -->
<!-- 								<li class="page-item active"><a class="page-link" href="#">3</a></li> -->
<!-- 								<li class="page-item"><a class="page-link" href="#">4</a></li> -->
<!-- 								<li class="page-item"><a class="page-link" href="#">5</a></li> -->
<!-- 								<li class="page-item"> -->
<!-- 									<a class="page-link" href="#" aria-label="Next"> -->
<!-- 										<span aria-hidden="true">Next ≫</span> -->
<!-- 										<span class="sr-only">Next</span> -->
<!-- 									</a> -->
<!-- 								</li> -->
<!-- 							</ul> -->
<!-- 						</nav> -->
						
<!-- 					</div> -->
				
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
</section>
    </div>
</body>
</html>