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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<script type="text/javascript">
$(function(){
	CKEDITOR.instances.ckeditor.setData('${noticeInfo.notice_cn}');
	
	$('#btnList').click(function(){
		location.href = '${pageContext.request.contextPath}/admin/notice/noticeList.do';
	});
	
	$('#btnModity').click(function(){
		location.href = '${pageContext.request.contextPath}/admin/notice/noticeUpdate.do?notice_id='+${noticeInfo.notice_id};
	});
	

	$('#btnDelete').click(function(){
		 swal({
	          title: "게시글을 정말 삭제하시겠습니까?",
	          text: "삭제된 게시글은 복구할 수 없습니다.",
	          type: "warning",
	          showCancelButton: true,
	          confirmButtonClass: "btn-danger",
	          confirmButtonText: "확인",
	          cancelButtonText: "취소",
	          closeOnConfirm: false,
	          closeOnCancel: false
	        },
	        function(isConfirm) {
	          if (isConfirm) {
	            swal("삭제되었어요!", "Your file was successfully deleted!", "success");
				location.href = '${pageContext.request.contextPath}/admin/notice/deleteNotice.do?notice_id='+${noticeInfo.notice_id};
	            
	          } else {
	            swal("취소되었습니다", "You Cancelled", "error");
	            false;
	          }
	      });
	});
	
});
</script>
</head>
<body>
<form class="form-horizontal">
<div class="content-body"><!-- Basic CKEditor start -->
<section id="horizontal-form-layouts">
	<div class="row">
	    <div class="col-md-12">
	        <div class="card">
	            <div class="card-header">
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
	            <div class="card-content collpase show">
	                <div class="card-body">
						<div class="card-text">
						</div>
	                    <form class="form form-horizontal">
	                    		<h4 class="form-section"><i class="ft-clipboard"></i>공지사항</h4>
	                    	<div class="form-body" style="margin-right: 300px">
			                    <div class="form-group row">
	                            	<label class="col-md-3 label-control" for="projectinput1">제목</label>
		                            <div class="col-md-9">
		                            	<input type="text" id="notice_nm" class="form-control" 
		                            	name="notice_nm" style="width: 900px" value="${noticeInfo.notice_nm }" disabled="disabled">
		                            	<input type="hidden" value="${noticeInfo.notice_id }"name="notice_id">
		                            </div>
		                        </div>

								<div style="margin-left: 300px">
									<h4 class="form-section" ><i class="fa fa-paperclip"></i> 자료 파일</h4>
									 	<c:if test="${!empty noticeFileInfo}">
									 		<div id="emptyFile">
						                        <label id="notice" onclick="javascript:location.href='${pageContext.request.contextPath}/admin/notice/fileDownload.do?notice=${noticeFileInfo.getNotice()}';">
						                        	${noticeFileInfo.getNotice_file_nm()}
						                        </label>
									 		</div>
									 	</c:if>
									 </div>
								<div class="form-group" style="margin-left: 300px">
									<div class="card-content collapse show">
									<div class="card-body">
										<div class="form-group">
											<textarea name="ckeditor" id="ckeditor" cols="30" rows="15" class="ckeditor" disabled="disabled">
											</textarea>
										</div>
									</div>
								</div>
								</div>
							</div>
	                        
							
							   <div class="form-actions" align="right">
								<!--  <button type="button" id="btnDelete" class="btn btn-warning mr-1"><i class="ft-x"></i> 삭제</button>  -->
								 <button type="button" id="btnDelete" class="btn btn-warning mr-1"  ><i class="ft-x"></i> 삭제</button> 
								<button type="button" id="btnModity" class="btn btn-primary"><i class="fa fa-check-square-o"></i> 수정</button>
								<button type="button" id="btnList" class="btn btn-danger btn-min-width mr-1 mb-1" style="float: left" value="목록"><i class="fa fa-eye">목록</i></button>
							</div>
	                    </form>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
</section>

  </body>
</html>