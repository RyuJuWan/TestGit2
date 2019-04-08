<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$('#btnList').click(function(){
		location.href = '${pageContext.request.contextPath}/empl/hnfInpt/hnfInptList.do';
	});
	
	$('form').submit(function(){
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
</script>
</head>
<body>
<form action="${pageContext.request.contextPath}/empl/hnfInpt/insertHnfInpt.do" role="form" class="form-horizontal" method="post" enctype="multipart/form-data">
<div class="content-body"><!-- Basic CKEditor start -->
<section id="basic-form-layouts">
	<div class="row match-height">
		<div class="col-md-6">
			<div class="card" style="width: 1100px;">
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
				<div class="card-content collapse show">
					<div class="card-body">
						<form class="form">
							<div class="form-body">
								<h4 class="form-section"><i class="ft-user"></i> 인원투입 계획서</h4>
							
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput4">인원투입계획 ID</label>
											<select id="hnfInptPlan_id" name="hnf_inpt_plan_id" class="form-control">
                                                <c:forEach var="i" begin="0" end="${planList.size()-1 }" step="1">
                                                   <option id="hnf_inpt_plan_id"  value="${planList.get(i).getHnf_inpt_plan_id()}">
                                                      <c:out value="${planList.get(i).getHnf_inpt_plan_id()}"></c:out>
                                                   </option>
                                                </c:forEach>
                                             </select>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput4">프로젝트 명</label>
											 <select id="hnfInptPrjct_id" name="hnf_inpt_prjct_id" class="form-control">
                                                <c:forEach var="i" begin="0" end="${prjctList.size()-1 }" step="1">
                                                   <option id="hnfInpt_prjct_id"  value="${prjctList.get(i).getPrjct_id()}">
                                                      <c:out value="${prjctList.get(i).getPrjct_nm()}"></c:out>
                                                   </option>
                                                </c:forEach>
                                             </select>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput4">제안서 명</label>
											 <select id="hnfInptPrpsl_id" name="hnf_inpt_actpln_prpsl" class="form-control">
                                                <c:forEach var="i" begin="0" end="${prpslList.size()-1 }" step="1">
                                                   <option id="hnfInpt_prpsl_id"  value="${prpslList.get(i).getPrpsl_id()}">
                                                      <c:out value="${prpslList.get(i).getPrpsl_nm()}"></c:out>
                                                   </option>
                                                </c:forEach>
                                             </select>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput1">작성자</label>
											<input type="hidden" name="hnf_inpt_actpln_empl" value="${sessionScope.LOGIN_EMPLINFO.empl_id}">
											<input disabled="disabled" type="text" id="hnfInpt_empl" class="form-control" name="hnf_inpt_actpln_empl2" value="${sessionScope.LOGIN_EMPLINFO.empl_id}">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput2">작성일자</label>
											<input type="hidden" name="hnf_inpt_actpln_date" value="${today }">
											<input type="text" disabled="disabled" id="hnfInpt_day" class="form-control" placeholder="YYYY-MM-DD" name="hnf_inpt_actpln_date2" value="${today }">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput2">투입일</label>
											<input type="date" id="hnfInpt_inpt" class="form-control" placeholder="YYYY-MM-DD" name="hnf_inpt_actpln_inpt">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput2">마감일</label>
											<input type="date" id="hnfInpt_clos" class="form-control" placeholder="YYYY-MM-DD" name="hnf_inpt_actpln_clos">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput2">결재선 명</label>
											<select id="hnfInptSantn_id" name="hnf_inpt_actpln_santn_id" class="form-control">
                                                <c:forEach var="i" begin="0" end="${sanctnLineList.size()-1 }" step="1">
                                                   <option id="hnfInpt_santn_id"  value="${sanctnLineList.get(i).getSanctn_line_id()}">
                                                      <c:out value="${sanctnLineList.get(i).getSanctn_line_nm()}"></c:out>
                                                   </option>
                                                </c:forEach>
                                             </select>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput2">결재서류유형</label>
											<select id="hnf_specfpapers_ty_id" name="hnf_specfpapers_ty_id" class="form-control">
                                                <c:forEach var="i" begin="0" end="${sanctnPapersTyList.size()-1 }" step="1">
                                                   <option id="hnfInptSpecfpapers_ty_id"  value="${sanctnPapersTyList.get(i).getSanctn_papers_ty_id()}">
                                                      <c:out value="${sanctnPapersTyList.get(i).getSanctn_papers_ty_nm()}"></c:out>
                                                   </option>
                                                </c:forEach>
                                             </select>
										</div>
									</div>
								</div>


								<div class="form-group">
									<label>Select File</label>
									<label id="projectinput7" class="file center-block">
										<input type="file" id="file" name="fileitem" >
										<span class="file-custom"></span>
									</label>
								</div>
							</div>

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

 </div>
</form>
    <!-- BEGIN VENDOR JS-->
    <script src="../../../app-assets/vendors/js/vendors.min.js"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="../../../app-assets/vendors/js/ui/jquery.sticky.js"></script>
    <script src="../../../app-assets/vendors/js/charts/jquery.sparkline.min.js"></script>
    <script src="../../../app-assets/vendors/js/ui/headroom.min.js"></script>
    <script src="../../../app-assets/vendors/js/editors/ckeditor/ckeditor.js"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN ROBUST JS-->
    <script src="../../../app-assets/js/core/app-menu.js"></script>
    <script src="../../../app-assets/js/core/app.js"></script>
    <!-- END ROBUST JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="../../../app-assets/js/scripts/ui/breadcrumbs-with-stats.js"></script>
    <script src="../../../app-assets/js/scripts/editors/editor-ckeditor.js"></script>
    <!-- END PAGE LEVEL JS-->
  </body>
</html>