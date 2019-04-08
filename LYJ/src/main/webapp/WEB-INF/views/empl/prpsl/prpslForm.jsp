<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$('#btnList')
				.click(
						function() {
							location.href = '${pageContext.request.contextPath}/empl/prpsl/prpslList.do';
						});

		$('#form').submit(function() {
// 			alert($('#fileitem').val());
			return true;
		})
	});
</script>
</head>
<body>
	<form id="form"
		action="${pageContext.request.contextPath}/empl/prpsl/prpslInsert.do"
		class="form-horizontal" 
		enctype="multipart/form-data"
		role="form"
		method="post">
		<div class="content-body">
			<section id="basic-form-layouts">
			<div class="row match-height">
				<div class="col-md-6">
					<div class="card" style="width: 1100px;">
						<div class="card-header">
							<h4 class="card-title" id="basic-layout-form">제안요청서</h4>
							<a class="heading-elements-toggle"><i
								class="fa fa-ellipsis-v font-medium-3"></i></a>
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

								<!-- 						<form class="form"> -->


								<h4 class="form-section">
									<i class="fa fa-paperclip"></i> Requirements
								</h4>

								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput1">제안서ID : </label> <input
												type="text" id="projectinput1" class="form-control"
												placeholder="제안서ID" name="prpsl_id">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput2">제안서 명:</label> <input type="text"
												id="projectinput2" class="form-control" placeholder="제안서 명"
												name="prpsl_nm">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput1">프로젝트 시작일: </label> <input
												type="date" id="projectinput3" class="form-control"
												placeholder="프로젝트 시작일" name="prpsl_prjct_start">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput2">프로젝트 마감일:</label> <input
												type="date" id="projectinput4" class="form-control"
												placeholder="프로젝트 마감일" name="prpsl_prjct_clos">
										</div>
									</div>
								</div>

								<div class="form-group">
									<label>Select File</label> <label id="projectinput7"
										class="file center-block"> <input type="file"
										id="fileitem" name="fileitem"> <span
										class="file-custom"></span>
									</label>
								</div>

								<div class="form-group">
									<label for="projectinput8">About Project</label>
									<div class="card-content collapse show">
										<div class="card-body">
											<div class="form-group">
												<textarea name="prpsl_cn" id="ckeditor" cols="30" rows="15"
													class="ckeditor">
													
												</textarea>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label for="projectinput5">제안요청서ID : </label> <select
											id="projectinput5" name="prpsl_rqpps_id" class="form-control">
											<!-- 												<option value="none" selected="selected" disabled="">미결재</option> -->
											<c:forEach items="${rqppsInfoList }" var="rqppsInfo">
												<c:if
													test="${rqppsInfo.rqpps_id }==${prpslInfo.prpsl_rqpps_id }">
													<option selected="selected" value="${rqppsInfo.rqpps_id}">${rqppsInfo.rqpps_nm }</option>
												</c:if>
												<option value="${rqppsInfo.rqpps_id}">${rqppsInfo.rqpps_nm }</option>
											</c:forEach>
										</select> <label for="projectinput5">결재선ID : </label> <select
											id="projectinput5" name="prpsl_sanctn_id"
											class="form-control">
											<!-- 												<option value="none" selected="" disabled="">미결재</option> -->
											<c:forEach items="${sanctnlineList }" var="sanctnline">
												<c:if
													test="${sanctnline.sanctn_line_id }==${prpslInfo.prpsl_sanctn_id }">
													<option selected="selected"
														value="${sanctnline.sanctn_line_id }">${sanctnline.sanctn_line_nm }</option>
												</c:if>
												<option value="${sanctnline.sanctn_line_id }">${sanctnline.sanctn_line_nm }</option>
											</c:forEach>

										</select> <label for="projectinput5">결재서류유형ID : </label> <select
											id="projectinput5" name="prpsl_papers_ty"
											class="form-control">
											<!-- 												<option value="none" selected="" disabled="">미결재</option> -->
											<c:forEach items="${sanctnpaperstyList }"
												var="sanctnpapersty">
												<c:if
													test="${sanctnpapersty.sanctn_papers_ty_id }==${prpslInfo.prpsl_papers_ty }">
													<option selected="selected"
														value="${sanctnpapersty.sanctn_papers_ty_id }">${sanctnpapersty.sanctn_papers_ty_nm }</option>
												</c:if>
												<option value="${sanctnpapersty.sanctn_papers_ty_id }">${sanctnpapersty.sanctn_papers_ty_nm }</option>
											</c:forEach>
										</select>
									</div>
								</div>

							</div>
							<input type="hidden" name="prpsl_empl"
								value="${LOGIN_EMPLINFO.empl_id}">
							<div class="form-actions">
								<button type="reset"
									class="btn btn-danger round btn-min-width mr-1 mb-1">
									<i class="ft-x"></i> 취소
								</button>
								<button type="submit"
									class="btn btn-warning round btn-min-width mr-1 mb-1">
									<i class="fa fa-check-square-o"></i> 등록
								</button>
								<button type="button" id="btnList"
									class="btn btn-primary round btn-min-width mr-1 mb-1"
									style="float: left" value="목록">
									<i class="fa fa-eye">목록</i>
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>