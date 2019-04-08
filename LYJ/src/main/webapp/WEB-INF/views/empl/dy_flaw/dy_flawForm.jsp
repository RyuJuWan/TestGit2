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
	$('#flawForm').submit(function(){
		var flag = true;
		if($('input[name=flaw_nm]').val() == null || $('input[name=flaw_nm]').val() == ""){
			alert("올바른 명이 아닙니다. 결함 명을 다시 입력해주세요.");
			flag = false;
		}
		else if(!$('input[name=flaw_compt]').val().validDay()){
			alert("올바른 완료 기한이 아닙니다. 날짜를 확인해주십시요.");
			flag = false;
		}
		return flag;
	});
	
	$('#btnList').click(function(){
		location.href = '${pageContext.request.contextPath}/empl/dy_flaw/dy_flawList.do?prjct_id=${prjct_id}';
	});
});
</script>
</head>
<body>
     <div class="content-body">
    <form id="flawForm" class="form-horizontal" method="post" action="${pageContext.request.contextPath}/empl/dy_flaw/dy_flawInsert.do">
		<div style="width: 3150px" align="left">
			<section id="horizontal-form-layouts">
				<div class="col-md-6" >
					<div class="card">
						<div class="card-header">
							<h4 class="card-title" id="basic-layout-colored-form-control">결함 등록</h4>
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
									<div class="row"  >
											<div class="col-md-6"  >
													<div class="form-group">
													<label for="empl_nm">결함명</label>
													<input class="form-control" type="text" id="flaw_nm" name="flaw_nm">
												</div>
											</div>
											<div class="col-md-6"  >
													<div class="form-group">
													<label for="empl_nm">해당 프로젝트명</label>
													<input type="hidden" id="flaw_prjct" name="flaw_prjct" value="${prjct_id}">
													<input disabled="disabled" class="form-control  " type="text" id="empl_nm" name="empl_nm" value="${prjct_nm}">
												</div>
											</div>
										</div>
										<div class="row"  >
											<div class="col-md-6"  >
												<div class="form-group">
													<label for="flaw_compt">완료 기한</label>
													<input type="date" id="flaw_compt" class="form-control  " name="flaw_compt">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label for="flaw_opetr_day">결함 처리일</label>
													<input type="date" id="flaw_opetr_day" class="form-control  " name="flaw_opetr_day">
												</div>
											</div>
										</div>
										<div class="row"  >
											<div class="col-md-6"  >
													<div class="form-group">
													<label for="empl_nm">결함 등록자</label>
													<input type="hidden" name="flaw_regist" value="${sessionScope.LOGIN_EMPLINFO.empl_id}">
													<input disabled="disabled" class="form-control  " type="text" id="flaw_regist" name="flaw_regist2" value="${sessionScope.LOGIN_EMPLINFO.empl_id}">
												</div>
											</div>
											<div class="col-md-6"  >
													<div class="form-group">
													<label for="flaw_chrg">결함 담당자</label>
													<select id="flaw_chrg" name="flaw_chrg" class="form-control">
														<option value="">none</option>
														<c:if test="${!empty prjctEmpl}">
															<c:forEach var="i" begin="0" end="${prjctEmpl.size() - 1}" step="1">
																<option value="${prjctEmpl.get(i).getEmpl_id()}">${prjctEmpl.get(i).getEmpl_nm()}</option>
															</c:forEach>
														</c:if>
													</select>
												</div>
											</div>
										</div>
										<div class="row">	
											<div class="col-md-6">
												<div class="form-group">
													<label for="flaw_ipcr">중요도</label>
													<select id="flaw_ipcr" name="flaw_ipcr" class="form-control">
														<c:forEach var="i" begin="0" end="${ipcrList.size() - 1}" step="1">
															<option value="${ipcrList.get(i).getIpcr_id()}">${ipcrList.get(i).getIpcr_nm()}</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label for="flaw_sttus">진행상태</label>
													<select id="flaw_sttus" name="flaw_sttus" class="form-control">
														<c:forEach var="i" begin="0" end="${sttusList.size() - 1}" step="1">
															<option value="${sttusList.get(i).getSttus_id()}">${sttusList.get(i).getSttus_nm()}</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group">
												<div class="card-content collapse show">
													<div class="card-body">
													<label for="projectinput8" style="margin-left: 3px;">결함 내용</label>
														<div class="form-group">
															<textarea name="flaw_cn" id="ckeditor" cols="30" rows="15" class="ckeditor">
															</textarea>
														</div>
													</div>
												</div>
											</div>
										</div>
										
			                        <div class="form-actions right">
				                        <button type="button" class="btn btn-warning mr-1"><i class="ft-x"></i> 취소</button>
										<button type="submit" class="btn btn-primary"><i class="fa fa-check-square-o"></i> 등록</button>
										<button type="button" id="btnList" class="btn btn-danger btn-min-width mr-1 mb-1" style="float: left" value="목록"><i class="fa fa-eye">목록</i></button>
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