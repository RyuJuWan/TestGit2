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
	$(function() {
		$('#rqpps_sanctn_line').val('${rqppsInfo.rqpps_sanctn_line }');
		$('#rqpps_papers_ty').val('${rqppsInfo.rqpps_papers_ty}');
		$('#rqpps_cn').val('${rqppsInfo.rqpps_cn}');
		$('#btnList').click(function(){
			location.href = '${pageContext.request.contextPath}/empl/rqpps/rqppsList.do';
		});
		
		$('#deletebtn').click(function(){
			location.href='${pageContext.request.contextPath}/empl/rqpps/deleteRqppsInfo.do?rqpps_id=${rqppsInfo.rqpps_id}';
		})
	});
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/empl/rqpps/modifyRqppsInfo.do" 
			class="form-horizontal">
		<div class="content-body">
			<!-- Basic CKEditor start -->
			<section id="basic-form-layouts">
			<div class="row match-height" style="width: 3150px" align="left">
				<div class="col-md-6">
					<div class="card" >
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
						<div class="card-content collapse show"  style=" margin-left: 200px; margin-right: 200px;">
							<div class="card-body"  >
								<form class="form">
								<div class="table-responsive" align="right" >
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
									<h4 class="form-section"><i class="fa fa-paperclip"></i> Requirements</h4>
									<div class="row">
									<div class="col-md-6">
										<label for="projectinput1">결재선ID:</label>
										<div class="form-group">
											<select class="form-control" name="rqpps_sanctn_line" id="rqpps_sanctn_line"
												style="margin: 3px; height: 40px">
												<option>결재선유형</option>
												<c:forEach items="${sanctnlineList }" var="sanctnline">
												<c:if test="${sanctnline.sanctn_line_id }==${rqppsInfo.rqpps_sanctn_line }"></c:if>
													<option id="sanctn_line_id" selected="selected" value="${sanctnline.sanctn_line_id }">${sanctnline.sanctn_line_nm }</option>
												</c:forEach>
													<option value="${sanctnline.sanctn_line_id }">${sanctnline.sanctn_line_nm }</option>
											</select>
										</div>
									</div>

									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput1">결재서류유형ID:</label> 
											<select	class="form-control" name="rqpps_papers_ty" id="rqpps_papers_ty"
												style="margin: 3px; height: 40px">
												<option>결재서류유형</option>
												<c:forEach items="${sanctnpaperstyList }" var="sanctnpapersty">
												<c:if test="${sanctnpapersty.sanctn_papers_ty_id }==${rqppsInfo.rqpps_papers_ty }">
													<option id="sanctn_papers_ty_id" selected="selected" value="${sanctnpapersty.sanctn_papers_ty_id }">${sanctnpapersty.sanctn_papers_ty_nm }</option>
													</c:if>
													<option value="${sanctnpapersty.sanctn_papers_ty_id }">${sanctnpapersty.sanctn_papers_ty_nm }</option>
												</c:forEach>
											</select>
										</div>
									</div>

									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput1">제안요청서명:</label> <input type="text"
												id="rqpps_nm" class="form-control" placeholder="First Name"
												name="rqpps_nm" value="${rqppsInfo.rqpps_nm }">
										</div>
									</div>

									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput1">제안요청서ID:</label> <input
												type="text" id="rqpps_id" class="form-control"
												placeholder="First Name" name="rqpps_id" value="${rqppsInfo.rqpps_id }">
										</div>
									</div>

									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput1">공고기관명:</label> <input type="text"
												id="rqpps_pblanc" class="form-control"
												placeholder="First Name" name="rqpps_pblanc" value="${rqppsInfo.rqpps_pblanc}">
										</div>
									</div>

									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput1">수요기관명:</label> <input type="text"
												id="rqpps_dmand" class="form-control"
												placeholder="First Name" name="rqpps_dmand" value="${rqppsInfo.rqpps_dmand}">
										</div>
									</div>

									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput1">제안서마감일:</label> <input type="text"
												id="rqpps_clos_date" class="form-control"
												placeholder="First Name" name="rqpps_clos_date" value="${rqppsInfo.rqpps_clos_date}">
										</div>
									</div>

									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput1">예산:</label> <input type="text"
												id="rqpps_budget" class="form-control"
												placeholder="First Name" name="rqpps_budget" value="${rqppsInfo.rqpps_budget}">
										</div>
									</div>

									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput1">인력계획:</label> <input type="text"
												id="rqpps_hnf_plan" class="form-control"
												placeholder="First Name" name="rqpps_hnf_plan" value="${rqppsInfo.rqpps_hnf_plan}">
										</div>
									</div>

									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput1">프로젝트시작일:</label> <input
												type="text" id="rqpps_prjct_start" class="form-control"
												placeholder="First Name" name="rqpps_prjct_start" value="${rqppsInfo.rqpps_prjct_start}">
										</div>
									</div>

									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput1">프로젝트마감일:</label> <input
												type="text" id="rqpps_prjct_clos" class="form-control"
												placeholder="First Name" name="rqpps_prjct_clos" value="${rqppsInfo.rqpps_prjct_clos}">
										</div>
									</div>
							</div>
							<div class="form-group">
								<label>Select File</label> <label id="projectinput7"
									class="file center-block"> <input type="file" id="file">
									<span class="file-custom"></span>
								</label>
							</div>

							<div class="form-group">
								<label for="projectinput8">About Project</label>
								<div class="card-content collapse show">
									<div class="card-body">
										<div class="form-group">
											<textarea name="rqpps_cn" id="rqpps_cn" cols="30" rows="15"
												class="ckeditor">
                        <table align="right" border="1"
													bordercolor="#ccc" cellpadding="5" cellspacing="0"
													style="border-collapse: collapse" name="rqpps_cn" id="rqpps_cn" > 
                        </table>
                     </textarea>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row" style="margin-left: 30px">
							<div class="col-md-6">
								<div class="form-group">
									<label for="projectinput5">결재 상태</label> <select
										id="projectinput5" name="interested" class="form-control">
										<option value="none" selected="" disabled="">미결재</option>
										<option value="design">결재</option>
										<option value="development">미결재</option>
										<option value="illustration">반려</option>
										<option value="branding">대기</option>
									</select>
								</div>
							</div>

						</div>
						<div class="form-actions right" style="margin-left: 30px">
							<button type="button" id="btnList" class="btn btn-danger btn-min-width mr-1 mb-1"
								style="width: 100px; height: 40px;  float: left;"   >
								<i class="fa fa-eye"></i> 목록
							</button>
							<button type="button" class="btn btn-primary btn-min-width mr-1 mb-1 "
								style="width: 100px; height: 40px;" name="deletebtn" id="deletebtn">
								<i class="ft-x"></i> 삭제
							</button>
							<button type="submit" class="btn btn-warning btn-min-width mr-1 mb-1"
								style="width: 100px; height: 40px;">
								<i class="fa fa-check-square-o"></i> 수정
							</button>
						
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