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
		location.href = '${pageContext.request.contextPath}/user/frb/frbList.do';
	});
});
</script>
</head>
<body>

<form action="${pageContext.request.contextPath }/empl/qna/insertQna.do " class="form-horizontal">
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
		                            <div class="col-md-9">
		                            	<input type="text" id="qna_nm" class="form-control" placeholder="First Name" name="qna_nm" style="width: 900px">
		                            </div>
		                        </div>
		                        
			                    <div class="form-group row">
	                            	<label class="col-md-3 label-control" for="projectinput1">비밀번호</label>
		                            <div class="col-md-9">
		                            	<input type="text" id="qna_pass" class="form-control" placeholder="First Name" name="qna_pass" style="width: 900px">
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

	                        <input type="hidden" name="qna_empl" value="${LOGIN_EMPLINFO.empl_id }">
	                        <input type="hidden" name="qna_grp" id="qna_grp" value="${qna.qna_grp }">
	                        <div class="form-actions">
								<button type="reset" class="btn btn-warning mr-1"><i class="ft-x"></i> 취소</button>
								<button type="submit" class="btn btn-primary"><i class="fa fa-check-square-o"></i> 등록</button>
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