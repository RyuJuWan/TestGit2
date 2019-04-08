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
	
	$('#empl_dept').change(function(){
		$('#empl_nm').empty();
		
		$.ajax({
	         type : 'POST',
	         dataType : 'JSON',
	         data : {empl_dept : $(this).val()},
	         url : '${pageContext.request.contextPath}/empl/project/emplManageModal.do',
	         error : function(result){
	            alert('사원조회 실패');
	         },
	         success : function(result){
				for(var i = 0; i < result.emplInfo.length; i++ ){
					var option = $("<option value='result.emplInfo[i].empl_id'>" + result.emplInfo[i].empl_nm+"</option>" );
					$('#empl_nm').append(option);
				}
	         }
	      });
	});
})
</script>
</head>
<body>
<div class="content-body">
    <form id="frmEmplView" class="form-horizontal" method="post">
		<div style=" " align="left">
			<section id="horizontal-form-layouts">
	<div class="col-12">
	    <div class="card">
	        <div class="card-head">
	            <div class="card-header">
	            	<h4 class="card-title">All Contacts</h4>
		            <a class="heading-elements-toggle"><i class="ft-ellipsis-h font-medium-3"></i></a>
        			<div class="heading-elements">
            			<span class="dropdown">
	                        <button id="btnSearchDrop1" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" class="btn btn-warning dropdown-toggle dropdown-menu-right btn-sm"><i class="ft-download-cloud white"></i></button>
	                        <span aria-labelledby="btnSearchDrop1" class="dropdown-menu mt-1 dropdown-menu-right">
	                            <a href="#" class="dropdown-item"><i class="ft-upload"></i> Import</a>
	                            <a href="#" class="dropdown-item"><i class="ft-download"></i> Export</a>
	                            <a href="#" class="dropdown-item"><i class="ft-shuffle"></i> Find Duplicate</a>
	                        </span>
	                    </span>
            			<button class="btn btn-default btn-sm"><i class="ft-settings white"></i></button>
		            </div>
	            </div>
	        </div>
	        <div class="card-content">
	            <div class="card-body">
	                <div class="table-responsive">
		                <table id="tblEmpl" class="table table-white-space table-bordered row-grouping display no-wrap icheck table-middle">
					        <thead>
					            <tr>
					                <th>번호</th>
					                <th>사번</th>
					                <th>이름</th>
					                <th>부서</th>
					                <th>직위</th>
					                <th>이메일</th>
					            </tr>
					        </thead>
					        <tbody>
					        	<c:forEach items="${emplList}" var="emplInfo">
				        			<c:forEach items="${prjctHistList1}" var="prjctHistInfo">
										<c:if test="${emplInfo.empl_id eq prjctHistInfo.prjct_hist_empl}">
											<c:if test="${prjctHistInfo.prjct_hist_prjct eq prjct_id}">
								        		<tr>
								        			<td>${emplInfo.rnum}</td>
								        			<td>${emplInfo.empl_id}</td>
								        			<td>${emplInfo.empl_nm}</td>
								        			<c:forEach items="${deptList}" var="deptInfo">
							        					<c:if test="${deptInfo.dept_id eq emplInfo.empl_dept}">
							        						<td>${deptInfo.dept_nm}</td>
							        					</c:if>
							        				</c:forEach>
								        			<c:forEach items="${ofcpsList}" var="ofcpsInfo">
							        					<c:if test="${ofcpsInfo.ofcps_id eq emplInfo.empl_ofcps}">
							        						<td>${ofcpsInfo.ofcps_nm}</td>
							        					</c:if>
							        				</c:forEach>
								        			<td>${emplInfo.empl_mail}</td>
								        		</tr>
											</c:if>
										</c:if>				        			
				        			</c:forEach>
				        		</c:forEach>
					        </tbody>
					    </table>
					    	
								</div>
							<div class="" align="right" >
		                        <button type="button" class="btn btn-danger mr-1" data-toggle="modal" data-target="#bootstrap">
									<i class="fa fa-check-square-o"></i> 팀원 초대
								</button>
							</div>
						</div>
				    </div>
				</div>
			</div>
		</section>
		</div>
		</form>
	</div>
							
							 <div class="col-lg-4 col-md-6 col-sm-12">
											<!-- Modal START-->
											<div class="modal fade text-left" id="bootstrap" tabindex="-1" role="dialog" aria-labelledby="myModalLabel35" aria-hidden="true">
											  <div class="modal-dialog" role="document">
												<div class="modal-content">
												  <div class="modal-header">
													<h3 class="modal-title" id="myModalLabel35"> 팀원 초대</h3>
													<button type="button" class="close" data-dismiss="modal" aria-label="Close">
													  <span aria-hidden="true">&times;</span>
													</button>
												  </div>
												  <form id="frmPrjctHist" action="${pageContext.request.contextPath}/empl/project/insertPrjctMember.do?prjct_id=${prjct_id}" method="post">
													<div class="modal-body">
														<fieldset class="form-group floating-label-form-group">
															<label for="email">부서</label>
															<select id="empl_dept" name="empl_dept" class="form-control">
																<option value="">전체</option>
																<c:forEach items="${deptList}" var="dept">
																	<option value="${dept.dept_id }">
																		<c:out value="${dept.dept_nm}"></c:out>
																	</option>
																</c:forEach>
															</select>
														</fieldset>
														<input type="hidden" name="prjct_hist_nm" value="${prjctInfo.prjct_nm}"> 
														<input type="hidden" name="prjct_hist_prjct" value="${prjct_id}">
														<br>
														<fieldset class="form-group floating-label-form-group">
															<label for="prjct_hist_empl">사원</label>
															<select id="prjct_hist_empl" name="prjct_hist_empl" class="form-control">
																<c:forEach items="${emplList}" var="empl">
																	<option value="${empl.empl_id }">
																		<c:out value="${empl.empl_nm}"></c:out>
																	</option>
																</c:forEach>
															</select>
														</fieldset>
														<br>
														<fieldset class="form-group floating-label-form-group">
															<label for="prjct_hist_inpt">시작일</label>
															<input type="date" id="prjct_hist_inpt" class="form-control  " name="prjct_hist_inpt">
														</fieldset>
														<br>
														<fieldset class="form-group floating-label-form-group">
															<label for="title">마감일</label>
															<input type="date" id="prjct_hist_clos" class="form-control  " name="prjct_hist_clos">
														</fieldset>
														
														<fieldset class="form-group floating-label-form-group">
															<label for="prjct_hist_role">역할</label>
															<select id="prjct_hist_role" name="prjct_hist_role" class="form-control">
																<c:forEach items="${roleList}" var="role">
																	<option value="${role.role_id }">
																		<c:out value="${role.role_nm}"></c:out>
																	</option>
																</c:forEach>
															</select>
														</fieldset>
															<div class="form-group position-relative has-icon-left">
																<label for="prjct_hist_pblanc">공고기관</label>
																<input type="text" placeholder="공고기관" class="form-control" id="prjct_hist_pblanc" name="prjct_hist_pblanc">
																<div class="form-control-position">
																	<i class="fa fa-envelope font-medium-5 line-height-1 text-muted icon-align" style="margin-top:35px"></i>
																</div>
															</div>
															<div class="form-group position-relative has-icon-left">
																<label for="prjct_hist_dmand">수요기관</label>
																<input type="text" placeholder="수요기관" class="form-control" id="prjct_hist_dmand" name="prjct_hist_dmand">
																<div class="form-control-position">
																	<i class="fa fa-envelope font-medium-5 line-height-1 text-muted icon-align" style="margin-top:35px"></i>
																</div>
															</div>
														</div>
													<div class="modal-footer">
														<input type="reset" class="btn btn-outline-secondary btn-lg" data-dismiss="modal" value="close">
														<input type="submit" class="btn btn-outline-primary btn-lg" id="btnInsertMember" value="등록" >
													</div>
												  </form>
												</div>
											  </div>
											</div>
									</div>

</body>
</html>