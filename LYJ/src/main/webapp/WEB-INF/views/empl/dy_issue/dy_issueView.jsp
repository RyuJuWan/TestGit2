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
	CKEDITOR.instances.ckeditor.setData('${issueInfo.issue_cn}');
	CKEDITOR.instances.ckeditor.config.autoParagraph = false;
	CKEDITOR.instances.ckeditor.config.fillEmptyBlocks = false;
	CKEDITOR.instances.ckeditor.config.fullPage = false;
	CKEDITOR.instances.ckeditor.config.ignoreEmptyParagraph = true;
	CKEDITOR.instances.ckeditor.config.enterMode = CKEDITOR.ENTER_BR;
	
	$('#btnList').click(function(){
		location.href = '${pageContext.request.contextPath}/empl/dy_issue/dy_issueList.do?prjct_id=${prjct_id}';
	});
});
</script>
</head>
<body>
     <div class="content-body">
    <form id="frmEmplView" class="form-horizontal" method="post" action="${pageContext.request.contextPath}/empl/dy_issue/dy_issueUpdate.do">
		<div style="width: 3150px" align="left">
			<section id="horizontal-form-layouts">
				<div class="col-md-6" >
					<div class="card">
						<div class="card-header">
							<h4 class="card-title" id="basic-layout-colored-form-control">이슈 조회</h4>
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
										<h4 class="form-section"><i class="fa fa-eye"></i> About Issue</h4>
										<div class="row"  >
											<div class="col-md-6"  >
													<div class="form-group">
													<label for="empl_nm">이슈명</label>
													<input class="form-control" type="hidden" id="issue_id" name="issue_id" value="${issueInfo.getIssue_id() }">
													<input class="form-control" type="text" id="issue_nm" name="issue_nm" value="${issueInfo.getIssue_nm() }">
												</div>
											</div>
											<div class="col-md-6"  >
													<div class="form-group">
													<label for="empl_nm">해당 프로젝트명</label>
													<input type="hidden" id="issue_prjct" name="issue_prjct" value="${prjct_id}">
													<input disabled="disabled" class="form-control  " type="text" id="empl_nm" name="empl_nm" value="${prjct_nm}">
												</div>
											</div>
										</div>
										<div class="row"  >
											<div class="col-md-6"  >
													<div class="form-group">
													<label for="empl_nm">관련 리스크</label>
 													<select id="issue_risk" name="issue_risk" class="form-control">
													<c:choose>
														<c:when test="${empty riskList || empty issueInfo.getIssue_risk()}">
															<option selected="selected" value="">none</option>
																<c:if test="${!empty riskList}">
																	<c:forEach var="i" begin="0" end="${riskList.size() - 1}" step="1">
																		<option value="${riskList.get(i).getRisk_id()}">${riskList.get(i).getRisk_nm()}</option>
																	</c:forEach>
																</c:if>
														</c:when>
														<c:otherwise>
															<c:forEach var="i" begin="0" end="${riskList.size()-1}" step="1">
																	<c:choose>
																		<c:when test="${issueInfo.getIssue_risk() eq riskList.get(i).getRisk_id()}">
																			<option selected="selected" value="${riskList.get(i).getRisk_id()}">${riskList.get(i).getRisk_nm()}</option>
																		</c:when>
																		<c:otherwise>
																			<option value="${riskList.get(i).getRisk_id()}">${riskList.get(i).getRisk_nm()}</option>
																		</c:otherwise>
																	</c:choose>
															</c:forEach>
														</c:otherwise>
													</c:choose>
													</select>
												</div>
											</div>
											<div class="col-md-6"  >
												<div class="form-group">
													<label for="issue_compt">완료 기한</label>
													<input type="date" id="issue_compt" class="form-control" name="issue_compt" value="${fn:substring(requestScope.issueInfo.getIssue_compt(), 0, 10)}">
												</div>
											</div>
										</div>
										<div class="row"  >
											<div class="col-md-6">
												<div class="form-group">
													<label for="issue_regist_day">이슈 등록일</label>
													<input type="date" id="issue_regist_day" class="form-control" name="issue_regist_day" value="${fn:substring(requestScope.issueInfo.getIssue_regist_day(), 0, 10)}">
												</div>
											</div>
											
											<div class="col-md-6">
												<div class="form-group">
													<label for="issue_opetr_day">이슈 처리일</label>
													<input type="date" id="issue_opetr_day" class="form-control" name="issue_opetr_day" value="${fn:substring(requestScope.issueInfo.getIssue_opetr_day(), 0, 10)}">
												</div>
											</div>
										</div>
										<div class="row"  >
											<div class="col-md-6"  >
													<div class="form-group">
													<label for="empl_nm">이슈 등록자</label>
													<c:forEach var="i" begin="0" end="${prjctEmpl.size() - 1}" step="1">
															<c:if test="${issueInfo.getIssue_regist() eq prjctEmpl.get(i).getEmpl_id()}">
																<input type="hidden" id="issue_regist" name="issue_regist" value="${issueInfo.getIssue_regist()}">
																<input disabled="disabled" class="form-control" type="text" id="issue_regist2" name="issue_regist2" value="${prjctEmpl.get(i).getEmpl_nm()}">
															</c:if>
													</c:forEach>
												</div>
											</div>
											<div class="col-md-6"  >
													<div class="form-group">
													<label for="issue_chrg">이슈 담당자</label>
													<select id="issue_chrg" name="issue_chrg" class="form-control">
														<c:choose>
															<c:when test="${empty prjctEmpl || empty issueInfo.getIssue_chrg()}">
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
																		<c:when test="${issueInfo.getIssue_chrg() eq prjctEmpl.get(i).getEmpl_id()}">
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
													<label for="issue_ipcr">중요도</label>
													<select id="issue_ipcr" name="issue_ipcr" class="form-control">
														<c:forEach var="i" begin="0" end="${ipcrList.size() - 1}" step="1">
															<c:choose>
																<c:when test="${issueInfo.getIssue_ipcr() eq ipcrList.get(i).getIpcr_id() }">
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
													<label for="issue_sttus">진행상태</label>
													<select id="issue_sttus" name="issue_sttus" class="form-control">
														<c:if test="${!empty sttusList}">
															<c:forEach var="i" begin="0" end="${sttusList.size() - 1}" step="1">
																<c:choose>
																	<c:when test="${issueInfo.getIssue_sttus() eq sttusList.get(i).getSttus_id()}">
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
													<label for="projectinput8" style="margin-left: 3px;">이슈 내용</label>
														<div class="form-group">
															<textarea name="issue_cn" id="ckeditor" cols="30" rows="15" class="ckeditor">
															</textarea>
														</div>
													</div>
												</div>
											</div>
										</div>
										
			                        <div class="form-actions right" style="margin-left: 30px">
										<button type="button" id="btnList" class="btn btn-danger btn-min-width mr-1 mb-1" style="float: left" value="목록"><i class="fa fa-eye">목록</i></button>
				                        <button type="reset" class="btn btn-warning mr-1"><i class="ft-x"></i> 취소</button>
										<button type="submit" class="btn btn-primary"><i class="fa fa-check-square-o"></i> 등록</button>
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