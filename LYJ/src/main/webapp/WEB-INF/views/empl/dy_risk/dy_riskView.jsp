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
	CKEDITOR.instances.ckeditor.setData('${riskInfo.risk_cn}');
	CKEDITOR.instances.ckeditor.config.autoParagraph = false;
	CKEDITOR.instances.ckeditor.config.fillEmptyBlocks = false;
	CKEDITOR.instances.ckeditor.config.fullPage = false;
	CKEDITOR.instances.ckeditor.config.ignoreEmptyParagraph = true;
	CKEDITOR.instances.ckeditor.config.enterMode = CKEDITOR.ENTER_BR;

	$('#btnList').click(function(){
		location.href = '${pageContext.request.contextPath}/empl/dy_risk/dy_riskList.do?prjct_id=${prjct_id}';
	});
});
</script>
</head>
<body>
      <div class="content-body">
    <form id="riskView" class="form-horizontal" method="post" action="${pageContext.request.contextPath}/empl/dy_risk/dy_riskUpdate.do">
		<div style="width: 3150px" align="left">
			<section id="horizontal-form-layouts">
				<div class="col-md-6" >
					<div class="card">
						<div class="card-header">
							<h4 class="card-title" id="basic-layout-colored-form-control">리스크 조회</h4>
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
										<h4 class="form-section"><i class="fa fa-eye"></i> About Risk</h4>
										<div class="row"  >
											<div class="col-md-6"  >
													<div class="form-group">
													<label for="empl_nm">리스크 명</label>
													<input class="form-control" type="hidden" id="risk_id" name="risk_id" value="${riskInfo.getRisk_id() }">
													<input class="form-control" type="text" id="risk_nm" name="risk_nm" value="${riskInfo.getRisk_nm() }">
												</div>
											</div>
										</div>
										<div class="row"  >
											<div class="col-md-6"  >
													<div class="form-group">
													<label for="empl_nm">해당 프로젝트명</label>
													<input type="hidden" id="risk_prjct" name="risk_prjct" value="${prjct_id}">
													<input disabled="disabled" class="form-control  " type="text" id="empl_nm" name="empl_nm" value="${prjct_nm}">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label for="empl_bir">완료기한</label>
													<input type="date" id="risk_compt" class="form-control" name="risk_compt" value="${fn:substring(requestScope.riskInfo.getRisk_compt(), 0, 10)}">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label for="empl_bir">등록일</label>
													<input type="date" id="risk_regist_day" class="form-control" name="risk_regist_day" value="${fn:substring(requestScope.riskInfo.getRisk_regist_day(), 0, 10)}">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label for="empl_bir">처리일</label>
													<input type="date" id="risk_opetr_day" class="form-control" name="risk_opetr_day" value="${fn:substring(requestScope.riskInfo.getRisk_opetr_day(), 0, 10)}">
												</div>
											</div>
										</div>
										<div class="row"  >
											<div class="col-md-6"  >
													<div class="form-group">
													<label for="empl_nm">리스크 등록자</label>
													<c:forEach var="i" begin="0" end="${prjctEmpl.size() - 1}" step="1">
															<c:if test="${riskInfo.getRisk_regist() eq prjctEmpl.get(i).getEmpl_id()}">
																<input type="hidden" id="risk_regist" name="risk_regist" value="${riskInfo.getRisk_regist()}">
																<input disabled="disabled" class="form-control" type="text" id="risk_regist2" name="risk_regist2" value="${prjctEmpl.get(i).getEmpl_nm()}">
															</c:if>
													</c:forEach>
												</div>
											</div>
											<div class="col-md-6"  >
													<div class="form-group">
													<label for="empl_nm">리스크 담당자</label>
													<select id="risk_chrg" name="risk_chrg" class="form-control">
														<c:choose>
															<c:when test="${empty prjctEmpl || empty riskInfo.getRisk_chrg()}">
																<option selected="selected" value="">none</option>
																<c:if test="${!empty prjctEmpl}">
																	<c:forEach var="i" begin="0" end="${prjctEmpl.size() - 1}" step="1">
																		<option value="${prjctEmpl.get(i).getEmpl_id()}">${prjctEmpl.get(i).getEmpl_nm()}</option>
																	</c:forEach>
																</c:if>
															</c:when>
															<c:otherwise>
																<c:forEach var="i" begin="0" end="${prjctEmpl.size() - 1}" step="1">
																	<c:choose>
																		<c:when test="${riskInfo.getRisk_chrg() eq prjctEmpl.get(i).getEmpl_id()}">
																			<option selected="selected" value="${prjctEmpl.get(i).getEmpl_id()}">${prjctEmpl.get(i).getEmpl_nm()}</option>
																		</c:when>
																		<c:otherwise>
																			<option value="${prjctEmpl.get(i).getEmpl_id()}">${prjctEmpl.get(i).getEmpl_nm()}</option>
																		</c:otherwise>
																	</c:choose>
																</c:forEach>
															</c:otherwise>
														</c:choose>
													</select>
												</div>
											</div>
										</div>
										<div class="row">	
											<div class="col-md-6">
												<div class="form-group">
													<label for="empl_dept">중요도</label>
													<select id="risk_ipcr" name="risk_ipcr" class="form-control">
														<c:forEach var="i" begin="0" end="${ipcrList.size() - 1}" step="1">
															<c:choose>
																<c:when test="${riskInfo.getRisk_ipcr() eq ipcrList.get(i).getIpcr_id() }">
																	<option selected="selected" value="${ipcrList.get(i).getIpcr_id()}">${ipcrList.get(i).getIpcr_nm()}</option>
																</c:when>
																<c:otherwise><option value="${ipcrList.get(i).getIpcr_id()}">${ipcrList.get(i).getIpcr_nm()}</option></c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label for="empl_dept">진행상태</label>
													<select id="risk_sttus" name="risk_sttus" class="form-control">
														<c:if test="${!empty sttusList}">
															<c:forEach var="i" begin="0" end="${sttusList.size() - 1}" step="1">
																<c:choose>
																	<c:when test="${riskInfo.getRisk_sttus() eq sttusList.get(i).getSttus_id()}">
																		<option selected="selected" value="${sttusList.get(i).getSttus_id()}">${sttusList.get(i).getSttus_nm()}</option>
																	</c:when>
																	<c:otherwise><option value="${sttusList.get(i).getSttus_id()}">${sttusList.get(i).getSttus_nm()}</option></c:otherwise>
																</c:choose>
															</c:forEach>
														</c:if>
													</select>
												</div>
											</div>
											<div class="form-group">
												<div class="card-content collapse show">
													<div class="card-body">
													<label for="projectinput8" style="margin-left: 3px;">리스크 내용</label>
														<div class="form-group">
															<textarea name="risk_cn" id="ckeditor" cols="30" rows="15" class="ckeditor">
															</textarea>
														</div>
													</div>
												</div>
											</div>
										</div>
										
			                        <div class="form-actions right">
				                        <button type="reset" class="btn btn-warning mr-1"><i class="ft-x"></i> 취소</button>
										<button type="submit" class="btn btn-primary"><i class="fa fa-check-square-o"></i> 수정</button>
										<button type="button" id="btnList" class="btn btn-danger btn-min-width mr-1 mb-1" style="float: left" value="목록"><i class="fa fa-eye">목록</i></button>
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