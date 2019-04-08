<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
	var prpsl_cn='${prpslInfo.prpsl_cn}';
	CKEDITOR.instances.ckeditor.setData('${prpslInfo.prpsl_cn}');
	CKEDITOR.instances.ckeditor.config.autoParagraph = false;
	CKEDITOR.instances.ckeditor.config.fillEmptyBlocks = false;
	CKEDITOR.instances.ckeditor.config.fullPage = false;
	CKEDITOR.instances.ckeditor.config.ignoreEmptyParagraph = true;
	CKEDITOR.instances.ckeditor.config.enterMode = CKEDITOR.ENTER_BR; 
	var prpsl_id ='${prpslInfo.prpsl_id}';
	
   $('#btndelete').click(function(){
      location.href = '${pageContext.request.contextPath}/empl/prpsl/prpslDelete.do?prpsl_id='+prpsl_id;
   });
   $('#btnList').click(function(){
      location.href = '${pageContext.request.contextPath}/empl/prpsl/prpslList.do';
   });
   $('#deleteFileName').click(function(){
// 	   if(!authenticationChk()) return false; 
	   $.ajax({
		   url : '${pageContext.request.contextPath}/empl/prpsl/fileExistence.do',
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
// 		    if(!authenticationChk()) return false;
			return true;
	   }); 
   });
   $('input[name=prpsl_prjct_start]').val('${fn:substring(prpslInfo.prpsl_prjct_start, 0, 10) }');
   $('input[name=prpsl_prjct_clos]').val('${fn:substring(prpslInfo.prpsl_prjct_clos, 0, 10) }');

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
<form action="${pageContext.request.contextPath}/empl/prpsl/prpslModify.do" class="form-horizontal" method="post" enctype="multipart/form-data">
<div class="content-body"><!-- Basic CKEditor start -->
<section id="basic-form-layouts">
   <div class="row match-height" style="width: 3150px" align="left">
      <div class="col-md-6">
         <div class="card" >
            <div class="card-header">
               <h4 class="card-title" id="basic-layout-form">제안서</h4>
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
            <div class="card-content collapse show" style=" margin-left: 200px; margin-right: 200px;">
               <div class="card-body">
                  <form class="form">
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

                        <h4 class="form-section"><i class="fa fa-paperclip"></i> Requirements</h4>

                           <div class="row">
                           <div class="col-md-6">
                              <div class="form-group">
                                 <label for="projectinput1">제안서ID : </label>
                                 <input type="text" id="projectinput1" class="form-control"  name="prpsl_id" value="${prpslInfo.prpsl_id }">
                              </div>
                           </div>
                           <div class="col-md-6">
                              <div class="form-group">
                                 <label for="projectinput2">제안서명 : </label>
                                 <input type="text" id="projectinput2" class="form-control"  name="prpsl_nm" value="${prpslInfo.prpsl_nm }">
                              </div>
                           </div>
                        </div>
                         <div class="row">
                           <div class="col-md-6">
                              <div class="form-group">
                                 <label for="projectinput1">프로젝트 시작일 : </label>
<%--                                  <input type="text" id="projectinput3" class="form-control"  name="prpsl_prjct_start" value="${fn:substring(prpslInfo.prpsl_prjct_start, 0, 10) }"> --%>
                              	 <input type="date" id="projectinput3" class="form-control" placeholder="YYYY-MM-DD" name="prpsl_prjct_start">
                              </div>
                           </div>
                           <div class="col-md-6">
                              <div class="form-group">
                                 <label for="projectinput2">프로젝트 마감일 : </label>
<%--                                  <input type="text" id="projectinput4" class="form-control" name="prpsl_prjct_clos" value="${fn:substring(prpslInfo.prpsl_prjct_clos,0,10)}"> --%>
                              	 <input type="date" id="projectinput3" class="form-control" placeholder="YYYY-MM-DD" name="prpsl_prjct_clos">
                              </div>
                           </div>
                        </div>
						 <h4 class="form-section"><i class="fa fa-paperclip"></i> 자료 파일</h4>
						 <div>
						 	<c:if test="${empty prpslFileInfo}">
	                        	<div class="form-group">
	                           		<label id="projectinput7" class="file center-block">
	                            	  	<input type="file" id="fileitem" name="fileitem">
	                           		</label>
	                        	</div>					 	
						 	</c:if>
						 	<c:if test="${!empty prpslFileInfo}">
						 		<div id="emptyFile">
			                        <label id="efl_id" onclick="javascript:location.href='${pageContext.request.contextPath}/empl/prpsl/fileDownload.do?prpsl=${prpslFileInfo.getPrpsl()}';">
			                        	${prpslFileInfo.getPrpsl_file_nm()}
			                        </label>
								 	<button id="deleteFileName"></button>
						 		</div>
							 	<div id="ifDeleteFileName" class="form-group">
	                           		<label id="projectinput7" class="file center-block">
	                            	  	<input type="file" id="fileitem" name="fileitem">
	                           		</label>
	                        	</div>	
						 	</c:if>
						 </div>

                        <div class="form-group">
						 <h4 class="form-section"><i class="fa fa-paperclip"></i>제안서 내용</h4>
                           <div class="card-content collapse show">
               <div class="card-body">
                  <div class="form-group">
                     <textarea name="prpsl_cn" id="ckeditor" cols="30" rows="15" class="ckeditor">
                    
<!--                         <div id="bo_content1"><p></p></div> -->
<!-- 						<input type="hidden" class="form-control" id="bo_content" name="bo_content" > -->
                     </textarea>
                  </div>
               </div>
            </div>
                        </div>
                     </div>
						<div class="row" >
									<div class="col-md-6" >
										<div class="form-group"  >
											<label for="projectinput5">제안요청서ID : </label>
											<select id="projectinput5" name="prpsl_rqpps_id" class="form-control">
<!-- 												<option value="none" selected="selected" disabled="">미결재</option> -->
												<c:forEach items="${rqppsInfoList }" var="rqppsInfo">
												<c:if test="${rqppsInfo.rqpps_id }==${prpslInfo.prpsl_rqpps_id }">
													<option selected="selected" value="${rqppsInfo.rqpps_id}">${rqppsInfo.rqpps_nm }</option>
												</c:if>
													<option value="${rqppsInfo.rqpps_id}">${rqppsInfo.rqpps_nm }</option>
												</c:forEach>
											</select>
											
											
											<label for="projectinput5">결재선ID : </label>
											<select id="projectinput5" name="prpsl_sanctn_id" class="form-control">
<!-- 												<option value="none" selected="" disabled="">미결재</option> -->
												<c:forEach items="${sanctnlineList }" var="sanctnline">
												<c:if test="${sanctnline.sanctn_line_id }==${prpslInfo.prpsl_sanctn_id }">
													<option selected="selected" value="${sanctnline.sanctn_line_id }">${sanctnline.sanctn_line_nm }</option>
												</c:if>
													<option value="${sanctnline.sanctn_line_id }">${sanctnline.sanctn_line_nm }</option>
												</c:forEach>
											
											</select>
											<label for="projectinput5">결재서류유형ID : </label>
											<select id="projectinput5" name="prpsl_papers_ty" class="form-control">
<!-- 												<option value="none" selected="" disabled="">미결재</option> -->
												 <c:forEach items="${sanctnpaperstyList }" var="sanctnpapersty">
												 <c:if test="${sanctnpapersty.sanctn_papers_ty_id }==${prpslInfo.prpsl_papers_ty }">
													<option selected="selected" value="${sanctnpapersty.sanctn_papers_ty_id }">${sanctnpapersty.sanctn_papers_ty_nm }</option>
												 </c:if>
													<option value="${sanctnpapersty.sanctn_papers_ty_id }">${sanctnpapersty.sanctn_papers_ty_nm }</option>
												</c:forEach>
											</select>
										</div>
									</div>

						</div>
              
              			<input type="hidden" name="prpsl_empl" value="${LOGIN_EMPLINFO.empl_id}">
                     <div class="form-actions right">
                        <button type="button" id="btndelete" name="btndelete" class="btn btn-primary btn-min-width mr-1 mb-1 " style="width: 100px; height: 40px;"><i class="ft-x"></i> 삭제</button>
                        <button type="submit" class="btn btn-warning btn-min-width mr-1 mb-1" style="width: 100px; height: 40px;"><i class="fa fa-check-square-o"></i> 수정</button>
                        <button type="button" id="btnList" name="btnList" class="btn btn-danger btn-min-width mr-1 mb-1 " style="width: 100px; height: 40px; float: left;"><i class="fa fa-eye"></i> 목록</button>
                     </div>
                  </form>
               </div>
            </div>
         </div>
      </div>
 </div>
</form>
  </body>
</html>