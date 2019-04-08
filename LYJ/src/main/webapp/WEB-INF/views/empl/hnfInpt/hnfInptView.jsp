<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
 #deleteFileName{
 	width: 15px;
 	height: 15px;
 }
 #ifDeleteFileName{
 	display: none;
 }
</style>
<script type="text/javascript">
$(function(){
   $('#btnList').click(function(){
      location.href = '${pageContext.request.contextPath}/empl/hnfInpt/hnfInptList.do';
   });
   var fnmClick = null;
   $('#deleteFileName').click(function(){
	   if(!authenticationChk()) return false;
	   $.ajax({
		   url : '${pageContext.request.contextPath}/empl/hnfInpt/fileExistence.do',
		   type : 'POST',
		   dataType : 'JSON',
		   success : function(result){
			   $('#ifDeleteFileName').attr("style","display: block");
			   $('#emptyFile').attr("style","display: none");
		   },
		   error : function(result){
				alert("State | " + result.message);		   
		   }
	   });
	   return false;
	   $('form').submit(function(){
		    if(!authenticationChk()) return false;
			var flag = true;
			if(!$('input[name=hnf_inpt_actpln_inpt]').val().validDay()){
				alert("잘못된 날짜입니다. 바르게 입력해주세요.1");
				return false;
			}
			if(!$('input[name=hnf_inpt_actpln_clos]').val().validDay()){
				alert("잘못된 날짜입니다. 바르게 입력해주세요.2");
				return false;
			}
			return flag;
	   })
   });
   
   $('input[name=hnf_inpt_actpln_id]').val('${requestScope.hnfInptInfo.hnf_inpt_actpln_id}')
   $('input[name=hnf_inpt_plan_id2]').val('${requestScope.hnfInptInfo.hnf_inpt_plan_id}');
   $('input[name=prjct_nm]').val('${requestScope.prjctNM}');
   $('input[name=hnf_inpt_actpln_prpsl2]').val('${requestScope.hnfInptInfo.hnf_inpt_actpln_prpsl}');
   $('input[name=hnf_inpt_actpln_empl2]').val('${requestScope.hnfInptInfo.hnf_inpt_actpln_empl}');
   $('input[name=hnf_inpt_actpln_inpt]').val('${fn:substring(requestScope.hnfInptInfo.hnf_inpt_actpln_inpt,0,10)}');
   $('input[name=hnf_inpt_actpln_clos]').val('${fn:substring(requestScope.hnfInptInfo.hnf_inpt_actpln_clos,0,10)}');
   $('input[name=hnf_inpt_plan_id]').val('${requestScope.hnfInptInfo.hnf_inpt_plan_id}');
   $('input[name=hnf_inpt_actpln_prpsl2]').val('${requestScope.hnfInptInfo.hnf_inpt_actpln_prpsl}');
   $('input[name=hnf_inpt_actpln_empl2]').val('${requestScope.hnfInptInfo.hnf_inpt_actpln_empl}');
   
   function authenticationChk(){
   	if(${requestScope.hnfInptInfo.hnf_inpt_actpln_empl != sessionScope.LOGIN_EMPLINFO.empl_id}){
   		alert('다른 사람이 작성한 글은 수정할 수 없습니다.');
   		return false;
   	}
   	
   	return true;
   }
});
</script>
</head>
<body>
<form action="${pageContext.request.contextPath}/empl/hnfInpt/updateHnfInpt.do" class="form-horizontal" method="post" enctype="multipart/form-data">
<div class="content-body"><!-- Basic CKEditor start -->
<section id="basic-form-layouts">
   <div class="row match-height">
      <div class="col-md-6">
         <div class="card" style="width: 1100px;">
            <div class="card-header">
               <h4 class="card-title" id="basic-layout-form">인원투입 계획서</h4>
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
               <div class="card-body">
                  <form class="form" role="form"/">
                  <div class="table-responsive" align="right">
												<table class="table table-bordered mb-0 table-striped" style="width: 400px; text-align: center; height: 20px;" >
														<tr>
															<td rowspan='2' style="vertical-align: middle; ">결재</td>
															<td >과장</td>
															<td>부장</td>
															<td>이사</td>
														</tr>
														<tr>
															<td  style="height: 50px"> </td>
															<td > </td>
															<td> </td>
														</tr>
												</table>
											</div>
                     <div class="form-body">
                        <h4 class="form-section"><i class="ft-user"></i> 인원투입계획서</h4>
                     
                        <div class="row">
                           <div class="col-md-6">
                              <div class="form-group">
                                 <label for="projectinput3" >인원투입 계획 :</label>
                                 <input type="hidden" name="hnf_inpt_actpln_id">
                                 <input disabled="disabled" type="text" id="projectinput3" class="form-control" placeholder="ID" name="hnf_inpt_plan_id2">
                                 <input  type="hidden" class="form-control" placeholder="ID" name="hnf_inpt_plan_id">
                                 <label for="projectinput4">프로젝트 명 :</label>
                                 <input disabled="disabled" type="text" id="projectinput4" class="form-control" placeholder="PROJECT_NAME" name="prjct_nm">
                              </div>
                           </div>

                           <div class="col-md-6">
                              <div class="form-group">
                                 <label for="projectinput4">제안서 ID :</label>
                                 <input disabled="disabled" type="text" id="projectinput4" class="form-control" placeholder="ID2" name="hnf_inpt_actpln_prpsl2">
                                 <input  type="hidden" class="form-control" placeholder="ID" name="hnf_inpt_actpln_prpsl">
                              </div>
                           </div>
                           <div class="col-md-6">
                              <div class="form-group">
                                 <label for="projectinput4">작성자</label>
                                 <input type="text" disabled="disabled" id="projectinput4" class="form-control" placeholder="WRITER ID" name="hnf_inpt_actpln_empl2">
                                 <input type="hidden" name="hnf_inpt_actpln_empl">
                              </div>
                           </div>
                           <div class="col-md-6">
                              <div class="form-group">
                                 <label for="projectinput4">프로젝트 투입일</label>
                                 <input type="date" id="projectinput4" class="form-control" placeholder="YYYY-MM-DD" name="hnf_inpt_actpln_inpt">
                              </div>
                           </div>
                           <div class="col-md-6">
                              <div class="form-group">
                                 <label for="projectinput4">프로젝트 마감일</label>
                                 <input type="date" id="projectinput4" class="form-control" placeholder="YYYY-MM-DD" name="hnf_inpt_actpln_clos">
                              </div>
                           </div>
                        </div>
                        <h4 class="form-section"><i class="fa fa-paperclip"></i> 자료 파일</h4>
					 	<c:if test="${empty hnfInptFileInfo}">
                        	<div class="form-group">
                           		<label id="projectinput7" class="file center-block">
                            	  	<input type="file" id="fileitem" name="fileitem">
                           		</label>
                        	</div>					 	
					 	</c:if>
					 	<c:if test="${!empty hnfInptFileInfo}">
					 		<div id="emptyFile">
		                        <label id="efl_id" onclick="javascript:location.href='${pageContext.request.contextPath}/empl/hnfInpt/fileDownload.do?hnf_inpt=${hnfInptFileInfo.getHnf_inpt()}';">
		                        	${hnfInptFileInfo.getHnf_inpt_file_nm()}
		                        </label>
							 	<button id="deleteFileName"></button>
					 		</div>
						 	<div id="ifDeleteFileName" class="form-group">
                           		<label id="projectinput7" class="file center-block">
                            	  	<input type="file" id="fileitem" name="fileitem">
                           		</label>
                        	</div>	
					 	</c:if>
                        <h4 class="form-section"><i class="fa fa-paperclip"></i> 투입 인원 정보</h4>
                        <table class="table table-striped table-bordered zero-configuration" id="tblHnfInpt" style="margin: 70px 30px 10px 0px" >
                            <thead>
                                <tr>
                                    <th>사원 번호</th>
                                    <th>사원 명</th>
                                    <th>역활</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<tr>
                            		<td>A</td>
                            		<td>B</td>
                            		<td>C</td>
                            	</tr>
                            	<tr>
                            		<td>A</td>
                            		<td>B</td>
                            		<td>C</td>
                            	</tr>
                            	<tr>
                            		<td>A</td>
                            		<td>B</td>
                            		<td>C</td>
                            	</tr>
                            <%-- 	<c:forEach items="${hnfInptList }" var="hnfInptInfo">
	                                <tr>
	                                	<td>${hnfInptInfo.rnum }</td>
	                                	<td align="left">${hnfInptInfo.prjVO.get(0).prjct_nm} 인원투입계획서</td>
	                                	<td>${hnfInptInfo.prjVO.get(0).prjct_nm }</td>
	                                	<td>${hnfInptInfo.hnf_inpt_actpln_empl }</td>
	                                	<td>${hnfInptInfo.hnf_inpt_actpln_date }</td>
	                                </tr>
                            	</c:forEach> --%>
                            </tbody>
                        </table>
              
              
                     <div class="form-actions">
                        <button type="button" id="deleteHnfInpt" class="btn btn-danger round btn-min-width mr-1 mb-1" style="width: 100px; height: 40px;"><i class="ft-x"></i> 삭제</button>
                        <button type="submit" class="btn btn-warning round btn-min-width mr-1 mb-1" style="width: 100px; height: 40px;"><i class="fa fa-check-square-o"></i> 수정</button>
                        <button type="button" id="btnList" class="btn btn-primary round btn-min-width mr-1 mb-1" style="width: 100px; height: 40px;"><i class="fa fa-eye"></i> 목록</button>
                     </div>
                  </form>
               </div>
            </div>
         </div>
      </div>

 </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->


</form>
  </body>
</html>