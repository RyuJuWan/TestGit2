<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$('#btnList').click(function(){
		location.href = '${pageContext.request.contextPath}/admin/qna/qnaList.do';
	});
	CKEDITOR.instances.ckeditor.setData('${qnaInfo.qna_cn}');
	CKEDITOR.instances.ckeditor.config.autoParagraph = false;
	CKEDITOR.instances.ckeditor.config.fillEmptyBlocks = false;
	CKEDITOR.instances.ckeditor.config.fullPage = false;
	CKEDITOR.instances.ckeditor.config.ignoreEmptyParagraph = true;
	CKEDITOR.instances.ckeditor.config.enterMode = CKEDITOR.ENTER_BR;
	
	$('#deletebtn').click(function(){
		location.href = '${pageContext.request.contextPath}/admin/qna/deleteQnaInfo.do?qna_id=${qnaInfo.qna_id}';
	});
	$('#btnReply').click(function(){
		location.href = '${pageContext.request.contextPath}/admin/qna/qnaReplyForm.do?qna_id=${qna_id}';
	})
});
</script>
</head>
<body>

<form action="${pageContext.request.contextPath }/admin/qna/modifyQnaInfo.do?qna_id=${qnaInfo.qna_id }" class="form-horizontal" id="asdf">
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
	                    		<h4 class="form-section"><i class="ft-clipboard"></i>문의사항 게시판</h4>
	                    	<div class="form-body" style="margin-right: 300px">
			                    <div class="form-group row">
	                            	<label class="col-md-3 label-control" for="projectinput1">제목</label>
		                            <div class="col-md-9">
		                            	<input type="text" id="qna_nm" class="form-control" 
		                            	placeholder="First Name" name="qna_nm" style="width: 900px"
		                            	value="${qnaInfo.qna_nm }">
		                            </div>
		                        </div>
		                        
		                        <div class="form-group row">
	                            	<label class="col-md-3 label-control" for="projectinput1">비밀번호</label>
		                            <div class="col-md-9">
		                            	<input type="password" id="qna_pass" class="form-control" 
		                            	placeholder="First Name" name="qna_pass" style="width: 900px"
		                            	value="${qnaInfo.qna_pass }">
		                            </div>
		                        </div>

		                        <div class="form-group row">
									<label class="col-md-3 label-control" for="projectinput5">작성자</label>
									<div class="col-md-9">
		                            	<input type="text" id="qna_empl" class="form-control" 
		                            	placeholder="Company Name" name="qna_empl" style="width: 600px"
		                            	value="${qnaInfo.qna_empl }">
		                            </div>
		                        </div>

								<div class="form-group row">
									<label class="col-md-3 label-control">Select File</label>
									<div class="col-md-9">
										<label id="projectinput8" class="file center-block">
											<input type="file" id="file">
											<span class="file-custom"></span>
										</label>
									</div>
								</div>
								<div class="form-group" style="margin-left: 300px">
									<div class="card-content collapse show">
									<div class="card-body">
										<div class="form-group">
											<textarea name="qna_cn" id="ckeditor" cols="30" rows="15" class="ckeditor">
											</textarea>
										</div>
									</div>
								</div>
								</div>
							</div>
						</form>
	                        <input type="hidden" name="qna_id" id="qna_id" value="${qna_id}">
	                        <input type="hidden" name="qna_grp" id="qna_grp" value="${qnaInfo.qna_grp }">
	                        <div class="form-actions">
								<button type="button" name="deletebtn" id="deletebtn" class="btn btn-warning mr-1"><i class="ft-x"></i>삭제</button>
								<button type="submit" class="btn btn-primary"><i class="fa fa-check-square-o"></i> 수정</button>
								<button type="button" id="btnList" class="btn btn-danger btn-min-width mr-1 mb-1" style="float: left" value="목록"><i class="fa fa-eye">목록</i></button>
								<button type="button" id="btnReply" class="btn btn-danger btn-min-width mr-1 mb-1" style="float: left" value="목록"><i class="fa fa-eye">답글</i></button>
							</div>
	                    </form>
</section>


  </body>
</html>