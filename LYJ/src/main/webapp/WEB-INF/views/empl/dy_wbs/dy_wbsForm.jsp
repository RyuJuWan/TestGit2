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
	

	var prjct_id='${prjct_id}';
	$('#btnList').click(function(){
		location.href ='${pageContext.request.contextPath}/empl/dy_wbs/dy_wbsList.do?prjct_id='+prjct_id;
	});
});
</script>
</head>
<body>
     <div class="content-body">
    <form id="riskView" class="form-horizontal" method="post" action="${pageContext.request.contextPath}/empl/dy_wbs/dy_wbsInsert.do">
		<div style="width: 3150px" align="left">
			<section id="horizontal-form-layouts">
				<div class="col-md-6" >
					<div class="card">
						<div class="card-header">
							<h4 class="card-title" id="basic-layout-colored-form-control">업무관리게시글 등록</h4>
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
							 <form class="form form-horizontal form-bordered">
	                    	<div class="form-body">
	                    		<h4 class="form-section"><i class="ft-user"></i> Personal Info</h4>
			                    <div class="form-group row">
	                            	<label class="col-md-3 label-control" for="projectinput1">일감 명</label>
		                            <div class="col-md-9">
		                            	<input type="hidden" id="wbs_id" class="form-control" placeholder="First Name" name="wbs_id" value="${wbsInfo.wbs_id}">
		                            	<input type="text" id="wbs_work_nm" class="form-control" placeholder="First Name" name="wbs_work_nm" >
		                            </div>
		                        </div>
		                        <div class="form-group row">
	                            	<label class="col-md-3 label-control" for="projectinput1">일감 등록자</label>
		                            <div class="col-md-9">
		                            	<input type="text" id="wbs_strt_empl" class="form-control" placeholder="First Name" name="wbs_strt_empl" value="${LOGIN_EMPLINFO.empl_id}">
		                            </div>
		                        </div>
		                     
		                        <div class="form-group row">
	                            	<label class="col-md-3 label-control" for="projectinput2">해당 프로젝트명</label>
									<div class="col-md-9">
	                            		<input type="hidden" id="wbs_prjct" class="form-control" placeholder="Last Name" name="wbs_prjct" value="${prjct_id}">
	                            		<input type="text" id="prjct_nm" class="form-control" placeholder="Last Name" name="prjct_nm" disabled="disabled" value="${prjct_nm }">
	                            	</div>
		                        </div>
		                           

		                        <div class="form-group row last">
		                            <label class="col-md-3 label-control" for="projectinput4">일감유형ID</label>
		                            <div class="col-md-9">
		                            	<select id="wbs_work_id" name="wbs_work_id" class="form-control">
		                            		<c:forEach items="${workTyList}" var="workTyInfo">
<%-- 		                            			<c:if test="${wbsInfo.wbs_work_id }==${workTyInfo.work_ty_id}"> --%>
<%-- 													<option value="${workTyInfo.work_ty_id}" selected="selected">${workTyInfo.work_ty_nm }</option> --%>
<%-- 												</c:if> --%>
			                                	<option value="${workTyInfo.work_ty_id}">${workTyInfo.work_ty_nm }</option>
			                                </c:forEach>
			                            </select>
		                            </div>
		                        </div>

								<h4 class="form-section"><i class="fa fa-eye"></i> About WBS</h4>
								<div class="form-group row">
	                            	<label class="col-md-3 label-control" for="projectinput1">일감 담당자</label>
		                            <div class="col-md-9">
		                            	<select id="wbs_chrg" name="wbs_chrg" class="form-control">
			                                <c:forEach items="${prjctEmpl}" var="emplInfo">
<%-- 			                                	<c:if test="${wbsInfo.wbs_chrg }==${emplInfo.empl_id}"> --%>
<%-- 			                                		<option value="${emplInfo.empl_id}" selected="selected" >${emplInfo.empl_nm }</option> --%>
<%-- 												</c:if> --%>
			                                	<option value="${emplInfo.empl_id}">${emplInfo.empl_nm }</option>
			                                </c:forEach>
			                            </select>
		                            </div>
		                        </div>

<!-- 		                        <div class="form-group row"> -->
<!-- 									<label class="col-md-3 label-control" for="projectinput5">등록일</label> -->
<!-- 									<div class="col-md-9"> -->
<!-- 		                            	<input type="text" id="projectinput5" class="form-control" placeholder="Company Name" name="company"> -->
<!-- 		                            </div> -->
<!-- 		                        </div> -->

		                        <div class="form-group row">
		                        	<label class="col-md-3 label-control" for="projectinput6">완료기한</label>
		                        	<div class="col-md-9">
		                        		<input type="date" id="wbs_compt" class="form-control" name="wbs_compt" >
		                            </div>
		                        </div>

		                        <div class="form-group row">
		                        	<label class="col-md-3 label-control" for="projectinput7">처리일</label>
		                        	<div class="col-md-9">
			                            <input type="date" id="wbs_date" class="form-control" name="wbs_date" >
		                            </div>
		                        </div>
		                       
		                         


								<div class="form-group row last">
									<label class="col-md-3 label-control" for="projectinput9">일감 내용</label>
									<div class="col-md-9">
										<textarea name="wbs_work_cn" id="ckeditor" cols="30" rows="15" class="ckeditor">
											
										</textarea>
									</div>
								</div>
								<h4 class="form-section"><i class="ft-clipboard"></i> Requirements</h4>
								<div class="row" style="margin-left: 380px"  >
											<div class="col-md-6">
												<div class="form-group">
													<label for="empl_dept">소분류ID</label>
														<select id="wbs_sml" name="wbs_sml" class="form-control">
				                                			<c:forEach items="${smcaList}" var="smcaInfo">
<%-- 				                                				<c:if test="${wbsInfo.wbs_sml }==${smcaInfo.sml_cat_id}"> --%>
<%-- 							                                		<option value="${smcaInfo.sml_cat_id}" selected="selected" >${smcaInfo.sml_cat_nm }</option> --%>
<%-- 																</c:if> --%>
							                                	<option value="${smcaInfo.sml_cat_id}" >${smcaInfo.sml_cat_nm }</option>
							                                </c:forEach>
				                            			</select>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label for="empl_dept">진행상태ID</label>
													<select id="wbs_progrs" name="wbs_progrs" class="form-control">
			                                			<c:forEach items="${sttusList}" var="sttusInfo">
<%-- 			                                				<c:if test="${wbsInfo.wbs_sml }==${sttusInfo.sttus_id}"> --%>
<%-- 						                                		<option value="${sttusInfo.wbs_progrs}" selected="selected" >${sttusInfo.sttus_nm }</option> --%>
<%-- 															</c:if> --%>
						                                	<option value="${sttusInfo.sttus_id}" >${sttusInfo.sttus_nm }</option>
						                                </c:forEach>
			                            			</select>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label for="empl_dept">중요도ID</label>
													<select id="wbs_imp" name="wbs_imp" class="form-control">
			                                			<c:forEach items="${ipcrList}" var="ipcrInfo">
<%-- 			                                				<c:if test="${wbsInfo.wbs_imp }==${ipcrInfo.ipcr_id}"> --%>
<%-- 						                                		<option value="${ipcrInfo.ipcr_id}" selected="selected" >${ipcrInfo.ipcr_nm }</option> --%>
<%-- 															</c:if> --%>
						                                	<option value="${ipcrInfo.ipcr_id}" >${ipcrInfo.ipcr_nm }</option>
						                                </c:forEach>
			                            			</select>
												</div>
											</div>
											
								</div>
							</div>


	                         <div class="form-actions right">
				                        <button type="reset" class="btn btn-warning mr-1"><i class="ft-x"></i> 취소</button>
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