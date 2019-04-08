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
	   if(eval('${empty sessionScope.LOGIN_EMPLINFO.empl_id}')){
		   alert("로그인이 필요합니다.");
		   return false;
	   }
      location.href = '${pageContext.request.contextPath}/empl/hnfInpt/hnfInptForm.do';
   });
   $('#tblHnfInpt tr:gt(0)').click(function(){
	   if(eval('${empty sessionScope.LOGIN_EMPLINFO.empl_id}')){
		   alert("로그인이 필요합니다.");
		   return false;
	   } else{
		   var hnfID = $(this).find('input[name=hnfInptID]').val();
		   location.href = '${pageContext.request.contextPath}/empl/hnfInpt/hnfInptView.do?hnfID=' + hnfID;
	   }
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
	                    <h4 class="card-title">프로젝트 인원투입계획서</h4>
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
	                          <form action="/user/freeboard/freeboardList.do" method="post" class="form-inline pull-right" >
		                        <select class="form-control" name="search_keycode" style="margin: 3px; height: 40px" >
		                           <option>검색조건</option>
		                           <option value="TOTAL">전체</option>
		                           <option value="TITLE">제목</option>
		                           <option value="CONTENT">내용</option>
		                           <option value="WRITER">작성자</option>
		                        </select>
		                        
		                        <input id="search_keyword" name="search_keyword" type="text" placeholder="검색어 입력..." class="form-control" style="height: 40px" />
		                        <button type="submit" class="btn btn-warning btn-min-width mr-1 mb-1" style="margin-left:3px; height: 40px; margin-top: 12px">검색</button>
		                        <button type="button" id="btnForm"  class="btn btn-danger btn-min-width mr-1 mb-1" value="게시글등록" style="  margin-top: 12px; width: 100px;height: 40px " >계획서 등록</button>
		                        
	                  		  </form>
	                      
	                        <table class="table table-striped table-bordered zero-configuration" id="tblHnfInpt" style="margin: 70px 30px 10px 0px" >
	                            <thead>
	                                <tr>
	                                    <th>인원투입계획서 명</th>
	                                    <th>프로젝트 명</th>
	                                    <th>작성자</th>
	                                    <th>작성일자</th>
	                                </tr>
	                            </thead>
	                            <tbody>
	                            	<c:forEach items="${hnfInptList }" var="hnfInptInfo">
		                                <tr>
		                                	<input name="hnfInptID" type="hidden" value="${hnfInptInfo.hnf_inpt_actpln_id }"/>
		                                	<td align="left">${hnfInptInfo.prjVO.get(0).prjct_nm} 인원투입계획서</td>
		                                	<td>${hnfInptInfo.prjVO.get(0).prjct_nm }</td>
		                                	<td>${hnfInptInfo.hnf_inpt_actpln_empl }</td>
		                                	<td>${fn:substring(hnfInptInfo.hnf_inpt_actpln_date, 0, 10) }</td>
		                                </tr>
	                            	</c:forEach>
	                            </tbody>
	                        </table>
	                        <div class="col-lg-6 col-md-12"  >
	                      		${pagingUtil}
	               			</div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</section>

</div>
</body>
</html>