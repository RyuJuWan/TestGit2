<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<script type="text/javascript">
$(function(){
	CKEDITOR.instances.ckeditor.setData('${reqreSpecfInfo.reqre_specf_cn}');
	
	CKEDITOR.instances.ckeditor.config.autoParagraph = false;
    CKEDITOR.instances.ckeditor.config.fillEmptyBlocks = false;
    CKEDITOR.instances.ckeditor.config.fullPage = false;
    CKEDITOR.instances.ckeditor.config.ignoreEmptyParagraph = true;
    CKEDITOR.instances.ckeditor.config.enterMode = CKEDITOR.ENTER_BR;
    
	$('#reqre_specf_sanctn_id').val('${reqreSpecfInfo.reqre_specf_sanctn_id}');
	$('#reqre_specf_papers_ty_id').val('${reqreSpecfInfo.reqre_specf_papers_ty_id}');
	$('#reqre_specf_cn').val('${reqreSpecfInfo.reqre_specf_cn}');
	
	$('#btnUpdate').click(function(){
  		swal({
	          title: "게시글을 수정하시겠습니까?",
	          text: "게시글 수정",
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
	            swal("게시글을 수정하시겠습니까?", "게시글 수정!", "success");
	            $('form').submit();
	            true;
	          } else {
	            swal("취소되었습니다", "You Cancelled", "error");
	            false;
	          }
	      });
  	});
	
})
</script>
</head>
<body>
     <div class="content-body">
    <form action="${pageContext.request.contextPath }/empl/dy_reqre_specf/updateReqreSpecf.do?prjct_id=${prjct_id}" class="form-horizontal" method="post">
		<div style="width: 3150px" align="left">
			<section id="horizontal-form-layouts">
				<div class="col-md-6" >
					<div class="card">
						<div class="card-header">
							<h4 class="card-title" id="basic-layout-colored-form-control">요구사항정의서</h4>
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
								<form class="form">
									<div class="form-body" style=" margin-left: 300px; margin-right: 300px;" >
										<h4 class="form-section"><i class="fa fa-eye"></i> About Project</h4>
										<div class="row"  >
											<div class="col-md-6"  >
													<div class="form-group">
													<label for="empl_nm">요구사항정의서 명</label>
													<input class="form-control" type="text" id="reqre_specf_nm" 
															name="reqre_specf_nm" value="${reqreSpecfInfo.reqre_specf_nm }">
													<input type="hidden" value="${reqreSpecfInfo.reqre_specf_id }"name="reqre_specf_id">
												</div>
											</div>
										</div>
										<div class="row"  >
											<div class="col-md-6"  >
													<div class="form-group">
													<label for="empl_nm">프로젝트 명</label>
													<input class="form-control  " type="text" disabled="disabled"
													id="reqre_specf_prjct_id" name="reqre_specf_prjct_id" value="${prjNm }" >
													<input class="form-control  " type="hidden" 
													id="reqre_specf_prjct_id" name="reqre_specf_prjct_id" value="${reqreSpecfInfo.reqre_specf_prjct_id }" >
												</div>
											</div>
										</div>
										<div class="row"  >
											<div class="col-md-6"  >
													<div class="form-group">
													<label for="empl_nm">작성자</label>
													<input class="form-control  " type="hidden" id="reqre_specf_empl" name="reqre_specf_empl"
															value="${reqreSpecfInfo.reqre_specf_empl }">
													<input class="form-control" type="text"  disabled="disabled" value="${reqreSpecfInfo.reqre_specf_empl}">
												</div>
											</div>
											<div class="col-md-6"  >
													<div class="form-group">
													<label for="empl_nm">작성일자</label>
													<input type="text" disabled="disabled" id="reqre_specf_wrting_date" class="form-control"
															 name="reqre_specf_wrting_date" value="${reqreSpecfInfo.reqre_specf_wrting_date }">
													 <input type="hidden"  id="reqre_specf_wrting_date" class="form-control"
													 name="reqre_specf_wrting_date" value="${reqreSpecfInfo.reqre_specf_wrting_date }">
												</div>
											</div>
										</div>
										<div class="row">	
											<div class="col-md-6"  >
												<div class="form-group">
													<label for="projectinput5">결재선ID </label>
													<select id="projectinput5" name="reqre_specf_sanctn_id" id="reqre_specf_sanctn_id" class="form-control">
														<c:forEach items="${sanctnlineList }" var="sanctnline">
														<c:if test="${sanctnline.sanctn_line_id }==${reqreSpecfInfo.reqre_specf_sanctn_id }">
															<option id="sanctn_line_id" selected="selected" value="${sanctnline.sanctn_line_id }">${sanctnline.sanctn_line_nm }</option>
														</c:if>
															<option value="${sanctnline.sanctn_line_id }">${sanctnline.sanctn_line_nm }</option>
														</c:forEach>
													
													</select>
												</div>
											</div>
											<div class="col-md-6"  >
												<div class="form-group">
													<label for="projectinput5">결재서류유형ID </label>
													<select id="projectinput5" name="reqre_specf_papers_ty_id" id="reqre_specf_papers_ty_id" class="form-control">
														 <c:forEach items="${sanctnpaperstyList }" var="sanctnpapersty">
														 <c:if test="${sanctnpapersty.sanctn_papers_ty_id }==${reqreSpecfInfo.reqre_specf_papers_ty_id }">
															<option id="sanctn_papers_ty_id" selected="selected" value="${sanctnpapersty.sanctn_papers_ty_id }">${sanctnpapersty.sanctn_papers_ty_nm }</option>
														 </c:if>
															<option value="${sanctnpapersty.sanctn_papers_ty_id }">${sanctnpapersty.sanctn_papers_ty_nm }</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group" style="margin-left: 25px">
												<label>Select File</label>
												<label id="projectinput7" class="file center-block">
													<input type="file"  id="fileitem" name="fileitem" >
													<span class="file-custom"></span>
												</label>
											</div>
											<div class="form-group">
												<div class="card-content collapse show">
													<div class="card-body">
														<div class="form-group">
															<textarea name="reqre_specf_cn" id="ckeditor" cols="30" rows="15" class="ckeditor">
															</textarea>
														</div>
													</div>
												</div>
											</div>
											
										</div>
										
			                        <div class="form-actions right">
										<button type="button" id="btnUpdate" class="btn btn-primary"><i class="fa fa-check-square-o"></i> 수정</button>
									</div>
								
	                        	</div>
	                        </form>
               			</div>
			        </div>
				</div>
			</div>
		</section>
		</div>
	</form>
</div>
</body>
</html>