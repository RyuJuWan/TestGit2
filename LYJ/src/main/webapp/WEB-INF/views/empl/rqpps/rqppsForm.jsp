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
	$('#btnList').click(function(){
		location.href = '${pageContext.request.contextPath}/empl/rqpps/rqppsList.do';
	});
});
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/empl/rqpps/insertRqpps.do" 
	class="form-horizontal">
<div class="content-body"><!-- Basic CKEditor start -->
<section id="basic-form-layouts">
	<div class="row match-height">
		<div class="col-md-6">
			<div class="card" style="width: 1100px;">
				<div class="card-header">
					<h4 class="card-title" id="basic-layout-form">제안요청서</h4>
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
						<div class="card-text">
							<p>This is the most basic and default form having form sections. To add form section use <code>.form-section</code> class with any heading tags. This form has the buttons on the bottom left corner which is the default position.</p>
						</div>
						<form class="form">
							<div class="form-body">
								<h4 class="form-section"><i class="fa fa-paperclip"></i> Requirements</h4>
									<div class="row">
									
									<div class="col-md-6">
											<label for="projectinput1">결재선ID:</label>
										<div class="form-group">
									<select class="form-control" name="rqpps_sanctn_line" style="margin: 3px; height: 40px">
		            	               <option>결재선유형</option>
								<c:forEach items="${sanctnlineList }" var="sanctnline">
		        	                   <option value="${sanctnline.sanctn_line_id }">${sanctnline.sanctn_line_nm }</option>
								</c:forEach>
			                        </select>
										</div>
									</div>
									
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput1">결재서류유형ID:</label>
									<select class="form-control" name="rqpps_papers_ty" style="margin: 3px; height: 40px" >
		            	               <option>결재서류유형</option>
		            	         <c:forEach items="${sanctnpaperstyList }" var="sanctnpapersty">   
		        	                   <option value="${sanctnpapersty.sanctn_papers_ty_id }">${sanctnpapersty.sanctn_papers_ty_nm }</option>
								</c:forEach>
			                        </select>
										</div>
									</div>
									
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput1">제안요청서명:</label>
											<input type="text" id="rqpps_nm" class="form-control" placeholder="First Name" name="rqpps_nm">
										</div>
									</div>
									
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput1">제안요청서ID:</label>
											<input type="text" id="rqpps_id" class="form-control" placeholder="First Name" name="rqpps_id">
										</div>
									</div>
									
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput1">공고기관명:</label>
											<input type="text" id="rqpps_pblanc" class="form-control" placeholder="First Name" name="rqpps_pblanc">
										</div>
									</div>
									
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput1">수요기관명:</label>
											<input type="text" id="rqpps_dmand" class="form-control" placeholder="First Name" name="rqpps_dmand">
										</div>
									</div>
									
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput1">제안서마감일:</label>
											<input type="text" id="rqpps_clos_date" class="form-control" placeholder="First Name" name="rqpps_clos_date">
										</div>
									</div>
									
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput1">예산:</label>
											<input type="text" id="rqpps_budget" class="form-control" placeholder="First Name" name="rqpps_budget">
										</div>
									</div>
									
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput1">인력계획:</label>
											<input type="text" id="rqpps_hnf_plan" class="form-control" placeholder="First Name" name="rqpps_hnf_plan">
										</div>
									</div>
									
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput1">프로젝트시작일:</label>
											<input type="text" id="rqpps_prjct_start" class="form-control" placeholder="First Name" name="rqpps_prjct_start">
										</div>
									</div>
									
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput1">프로젝트마감일:</label>
											<input type="text" id="rqpps_prjct_clos" class="form-control" placeholder="First Name" name="rqpps_prjct_clos">
										</div>
									</div>
									
								</div>
								<div class="form-group">
									<label>Select File</label>
									<label id="projectinput7" class="file center-block">
										<input type="file" id="rqpps_atchmn" name="rqpps_atchmn">
										<span class="file-custom"></span>
									</label>
								</div>

								<div class="form-group">
									<label for="projectinput8">About Project</label>
									<div class="card-content collapse show">
					<div class="card-body">
						<div class="form-group">
							<textarea name="rqpps_cn" id="ckeditor" cols="30" rows="15" class="ckeditor">
							</textarea>
						</div>
					</div>
				</div>
								</div>
							</div>
							<input type="hidden" name="rqpps_empl" value="${LOGIN_EMPLINFO.empl_id}">
							<div class="form-actions">
								<button type="reset" class="btn btn-danger round btn-min-width mr-1 mb-1"><i class="ft-x"></i> 취소</button>
								<button type="submit" class="btn btn-warning round btn-min-width mr-1 mb-1"><i class="fa fa-check-square-o"></i> 등록</button>
								<button type="button" id="btnList" class="btn btn-primary round btn-min-width mr-1 mb-1" style="float: left" value="목록"><i class="fa fa-eye">목록</i></button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
<!-- Basic CKEditor end -->

<!-- Readonly CKEditor start -->
<!-- Read only CKEditor end -->

<!-- CKEditor UI Color start -->
<!-- CKEditor UI Color end -->

 </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->


</form>
  </body>
  </html>