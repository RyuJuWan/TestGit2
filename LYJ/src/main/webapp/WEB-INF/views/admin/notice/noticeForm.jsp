<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#btnList').click(function(){
		 swal({
	          title: "게시글 등록을 취소하시겠습니까?",
	          text: "목록으로 돌아가기",
	          type: "info",
	          showCancelButton: true,
	          confirmButtonClass: "btn-danger",
	          confirmButtonText: "확인",
	          cancelButtonText: "취소",
	          closeOnConfirm: false,
	          closeOnCancel: false
	        },
	        function(isConfirm) {
	          if (isConfirm) {
	            swal("게시글등록을 취소하시겠습니까?", "게시글 등록 취소!", "success");
	            location.href = '${pageContext.request.contextPath}/admin/notice/noticeList.do';
	            
	          } else {
	            swal("취소되었습니다", "You Cancelled", "error");
	            false;
	          }
	      });
		
	});
	
  	$('#btnInsert').click(function(){
  		swal({
	          title: "게시글을 등록하시겠습니까?",
	          text: "게시글 등록",
	          type: "info",
	          showCancelButton: true,
	          confirmButtonClass: "btn-danger",
	          confirmButtonText: "확인",
	          cancelButtonText: "취소",
	          closeOnConfirm: false,
	          closeOnCancel: false
	        },
	        function(isConfirm) {
	          if (isConfirm) {
	            swal("게시글을 등록하시겠습니까?", "게시글 등록!", "success");
	            $('form').submit();
	            true;
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

<form id="insertNotice" action="${pageContext.request.contextPath }/admin/notice/insertNotice.do" 
	class="form-horizontal"
	method="post"
	enctype="multipart/form-data">
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
	                    		<h4 class="form-section"><i class="ft-clipboard"></i>게시글 등록</h4>
	                    	<div class="form-body" style="margin-right: 300px">
			                    <div class="form-group row">
	                            	<label class="col-md-3 label-control" for="projectinput1">제목</label>
	                            	<input type="hidden" name="notice_empl" value="${LOGIN_ADMININFO.admin_id}">
		                            <div class="col-md-9">
		                            	<input type="text" id="notice_nm" class="form-control" name="notice_nm" style="width: 900px">
		                            </div>
		                        </div>

								<div class="form-group row">
									<label class="col-md-3 label-control">Select File</label>
									<div class="col-md-9">
										<label id="projectinput8" class="file center-block">
											<input type="file" id="fileitem" name="fileitem">
											<span class="file-custom"></span>
										</label>
									</div>
								</div>
								<div class="form-group" style="margin-left: 300px">
									<div class="card-content collapse show">
									<div class="card-body">
										<div class="form-group">
											<textarea name="notice_cn" id="notice_cn" cols="30" rows="15" class="ckeditor">
											</textarea>
										</div>
									</div>
								</div>
								</div>
							</div>

	                        
	                        <div class="form-actions" align="right">
								<button type="button" id="btnInsert" class="btn btn-primary btn-min-width mr-1 mb-1"><i class="fa fa-check-square-o"></i> 등록</button>
								<button type="button" id="btnList" class="btn btn-danger btn-min-width mr-1 mb-1" style="float: left" value="목록"><i class="ft-x">취소</i></button>
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