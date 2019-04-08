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
	$('#createWbs').click(function(){
		location.href='${pageContext.request.contextPath}/empl/dy_wbs/dy_wbsForm.do?prjct_id=${prjct_id}';	
	});
	$('#project-task-list tr:gt(0)').click(function(){
		var wbs_id=$(this).find('input[name=wbs_id]').val();
		location.href ='${pageContext.request.contextPath}/empl/dy_wbs/dy_wbsView.do?wbs_id='+wbs_id+'&prjct_id=${prjct_id}';
		
	});
});

</script>
</head>
<body>
        <div class="content-body"><section class="row">
    <div class="col-12">
        <div class="card">
            <div class="card-header">
            	<h4 class="card-title">업무관리게시판</h4>
            	<a class="heading-elements-toggle"><i class="ft-ellipsis-h font-medium-3"></i></a>
        				
        		<div class="heading-elements">
        		 		<form action="/user/freeboard/freeboardList.do" method="post" class="form-inline pull-left "  >
		                        <select class="form-control" name="search_keycode" style="margin: 10px; height: 40px; "  >
		                           <option>검색조건</option>
		                           <option value="TOTAL">전체</option>
		                           <option value="TITLE">제목</option>
		                           <option value="CONTENT">내용</option>
		                           <option value="WRITER">작성자</option>
		                        </select>
		                  </form>
            		<button class="btn btn-primary btn-sm" id="createWbs" style="margin-top: 13px;"><i class="ft-plus white"></i> 업무 등록</button>
        			<span class="dropdown">
                        <button id="btnSearchDrop1" style="margin-top: 13px;" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn btn-warning btn-sm dropdown-toggle dropdown-menu-right"><i class="ft-download white"></i></button>
                        <span aria-labelledby="btnSearchDrop1" class="dropdown-menu mt-1 dropdown-menu-right" >
                            <a href="#" class="dropdown-item"><i class="fa fa-calendar"></i> Due Date</a>
                            <a href="#" class="dropdown-item"><i class="fa fa-random"></i> Priority </a>
                            <a href="#" class="dropdown-item"><i class="fa fa-bar-chart"></i> Progress</a>
                            <a href="#" class="dropdown-item"><i class="fa fa-user"></i> Assign to</a>
                        </span>
                    </span>
        			<button class="btn btn-success btn-sm" style="margin-top: 13px;"><i class="ft-settings white"></i></button>
        			
                </div>
            </div>
            <div class="card-content">
                <div class="card-body">
	                <!-- Task List table -->
	                <div class="table-responsive">
		                <table id="project-task-list" class="table table-white-space table-bordered row-grouping display no-wrap icheck table-middle">
					        <thead>
					            <tr>
<!-- 					                <th><input type="checkbox" class="input-chk">숫자로 수정하셔도 됩니다!</th> -->
									<th>#</th>
					                <th>업무명</th>
					                <th>기능</th>
					                <th>중요도</th>				                
					                <th>진척률</th>				                
					                <th>담당자</th>
					                <th>Actions</th>
					            </tr>
					        </thead>
					        <tbody>
					        	<!-- ABC Project -->
										<c:if test="${!empty wbsList}">
											<c:forEach items="${wbsList}" var="wbsInfo">
												<tr>
													<input id="wbs_id" name="wbs_id" type="hidden"
														value="${wbsInfo.wbs_id}">
													
<!-- 													<td><input type="checkbox" class="input-chk"></td> -->
													<td><input type="hidden" value="${wbsInfo.wbs_id }">${wbsInfo.rnum}</td>
													<td>
														<!-- 					                	<a href="#" class="text-bold-600">Complete the page header</a> -->
														<p class="text-muted">${wbsInfo.wbs_work_nm}</p>
													</td>
													<td><h6 class="mb-0">
														<span class="text-bold-600">${wbsInfo.wbs_work_cn}</span>
													</td>
													<td>
													<c:choose>
														<c:when test="${wbsInfo.wbs_imp eq 'ip001'}"><span class="badge badge-default badge-info">낮음</span></c:when>
														<c:when test="${wbsInfo.wbs_imp eq 'ip002'}"><span class="badge badge-default badge-success">보통</span></c:when>
														<c:when test="${wbsInfo.wbs_imp eq 'ip003'}"><span class="badge badge-default badge-warning">높음</span></c:when>
														<c:when test="${wbsInfo.wbs_imp eq 'ip004'}"><span class="badge badge-default badge-danger">긴급</span></c:when>
														<c:otherwise><span class="badge badge-default badge-primary">${wbsInfo.wbs_imp}</span></c:otherwise>
													</c:choose>
													</td>
<!-- 													<td> -->
<%-- 													<c:choose> --%>
<%-- 														<c:when test="${wbsInfo.wbs_progrs eq 'st001'}"><span class="badge badge-default badge-info">신규</span></c:when> --%>
<%-- 														<c:when test="${wbsInfo.wbs_progrs eq 'st002'}"><span class="badge badge-default badge-success">진행</span></c:when> --%>
<%-- 														<c:when test="${wbsInfo.wbs_progrs eq 'st003'}"><span class="badge badge-default badge-warning">해결</span></c:when> --%>
<%-- 														<c:when test="${wbsInfo.wbs_progrs eq 'st004'}"><span class="badge badge-default badge-primary">의견</span></c:when> --%>
<%-- 														<c:when test="${wbsInfo.wbs_progrs eq 'st005'}"><span class="badge badge-default badge-info">완료</span></c:when> --%>
<%-- 														<c:otherwise><span class="badge badge-default badge-danger">${wbsInfo.wbs_progrs}</span></c:otherwise> --%>
<%-- 													</c:choose> --%>
<!-- 													</td> -->
													<td>${wbsInfo.getWbs_sttusVO().getSttus_progrs()} %
													<div class="progress progress-sm">
													   	<c:choose>
															<c:when test="${wbsInfo.wbs_progrs eq 'st001'}"><div aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-gradient-x-info" role="progressbar" style="width:${wbsInfo.getWbs_sttusVO().getSttus_progrs()}%" aria-valuenow="${wbsInfo.getWbs_sttusVO().getSttus_progrs()}"></div></c:when>
															<c:when test="${wbsInfo.wbs_progrs eq 'st002'}"><div aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-gradient-x-success" role="progressbar" style="width:${wbsInfo.getWbs_sttusVO().getSttus_progrs()}%" aria-valuenow="${wbsInfo.getWbs_sttusVO().getSttus_progrs()}"></div></c:when>
															<c:when test="${wbsInfo.wbs_progrs eq 'st003'}"><div aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-gradient-x-warning" role="progressbar" style="width:${wbsInfo.getWbs_sttusVO().getSttus_progrs()}%" aria-valuenow="${wbsInfo.getWbs_sttusVO().getSttus_progrs()}"></div></c:when>
															<c:when test="${wbsInfo.wbs_progrs eq 'st004'}"><div aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-gradient-x-primary" role="progressbar" style="width:${wbsInfo.getWbs_sttusVO().getSttus_progrs()}%" aria-valuenow="${wbsInfo.getWbs_sttusVO().getSttus_progrs()}"></div></c:when>
															<c:when test="${wbsInfo.wbs_progrs eq 'st005'}"><div aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-gradient-x-info" role="progressbar" style="width:${wbsInfo.getWbs_sttusVO().getSttus_progrs()}%" aria-valuenow="${wbsInfo.getWbs_sttusVO().getSttus_progrs()}"></div></c:when>
															<c:otherwise><div aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-gradient-x-danger" role="progressbar" style="width:${wbsInfo.getWbs_sttusVO().getSttus_progrs()}%" aria-valuenow="${wbsInfo.getWbs_sttusVO().getSttus_progrs()}"></div></c:otherwise>
														</c:choose>
											        </div>
												</td>

													<td class="text-center">
													${wbsInfo.wbs_chrg}
													</td>
													
													<td><span class="dropdown">
															<button id="btnSearchDrop2" type="button"
																data-toggle="dropdown" aria-haspopup="true"
																aria-expanded="false"
																class="btn btn-info dropdown-toggle">
																<i class="fa fa-cog"></i>
															</button> <span aria-labelledby="btnSearchDrop2"
															class="dropdown-menu mt-1 dropdown-menu-right"> <a
																href="#" class="dropdown-item"><i class="ft-eye"></i>
																	Open Task</a> <a href="#" class="dropdown-item"><i
																	class="ft-edit-2"></i> Edit Task</a> <a href="#"
																class="dropdown-item"><i class="ft-check"></i>
																	Complete Task</a> <a href="#" class="dropdown-item"><i
																	class="ft-upload"></i> Assign to</a>
																<div class="dropdown-divider"></div> <a href="#"
																class="dropdown-item"><i class="ft-trash"></i>
																	Delete Task</a>
														</span>
													</span></td>
												</tr>
											</c:forEach>
										</c:if>
<!-- 									</tr> -->
									
					        </tbody>
					        
						</table>
							${paging}
						</div>
					<!--/ Task List table -->
				</div>
            </div>
        </div>
    </div>
</section>
        </div>
      </div>
    </div>

</body>
</html>