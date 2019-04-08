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
   $('#createIssue').click(function(){
	  location.href = '${pageContext.request.contextPath}/empl/dy_issue/dy_issueForm.do?prjct_id=${prjct_id}'; 
   });
   
   $('form').submit(function(){
// 	   alert($('input[name=search_keyword]').val());
// 	   alert($('select[name=search_keycode]').val());
   });
   
   $('#issueListTable tr:gt(0)').click(function(){
	   if(eval('${empty sessionScope.LOGIN_EMPLINFO.empl_id}')){
		   alert("로그인이 필요합니다.");
		   return false;
	   } else{
		   var issueID = $(this).find('input[name=issue_id]').val();
		   location.href = '${pageContext.request.contextPath}/empl/dy_issue/dy_issueView.do?issue_id=' + issueID +'&prjct_id=${prjct_id}';
	   }
   });
});
</script>
</head>
<body>
        <div class="content-detached content-right">
          <div class="content-body" style="height: 3404px;"><section class="row">
    <div class="col-12">
        <div class="card">
            <div class="card-header">
            	<h4 class="card-title">이슈 게시판</h4>
            	<a class="heading-elements-toggle"><i class="ft-ellipsis-h font-medium-3"></i></a>
        		<div class="heading-elements">
                    <button class="btn btn-primary btn-sm" id="createIssue"><i class="ft-plus white"></i> Create Issue</button>
            	</div>
            </div>
            <div class="card-content">
                <div class="card-body">
	                <!-- Task List table -->
	                <div class="table-responsive">
		                <div id="project-bugs-list_wrapper" class="dataTables_wrapper dt-bootstrap4">
		                		<div class="row"><div class="col-sm-12">
			                		<table id="issueListTable" class="table table-white-space table-bordered row-grouping display no-wrap icheck table-middle dataTable" role="grid" aria-describedby="project-bugs-list_info" style="position: relative;">
								        <thead>
								            <tr role="row">
								            <th class="sorting_disabled" rowspan="1" colspan="1">발생일자</th>
								            <th class="sorting_disabled" rowspan="1" colspan="1">이슈명</th>
								            <th class="sorting_disabled" rowspan="1" colspan="1">담당자</th>
								            <th class="sorting_disabled" rowspan="1" colspan="1">중요도</th>
								            <th class="sorting_disabled" rowspan="1" colspan="1">진행상태 명</th>
								            <th class="sorting_disabled" rowspan="1" colspan="1">진행률</th>
								            </tr>
								        </thead>
								        <tbody>
									        <tr role="row" class="even">
												<c:if test="${!empty issueList}">
													<c:forEach items="${issueList}" var="issueInfo">
														<tr>
															<input id="issue_id" name="issue_id" type="hidden" value="${issueInfo.getIssue_id()}">
															<td>${fn:substring(issueInfo.getIssue_regist_day(), 0, 10)}</td>
															<td>${issueInfo.getIssue_nm() }</td>
															<c:forEach items="${prjctEmpl}" var="emplInfo">
																<c:if test="${issueInfo.getIssue_chrg() == emplInfo.getEmpl_id()}">
																	<td>${emplInfo.getEmpl_nm()}</td>
																</c:if>															
															</c:forEach>
															<td>
																<c:choose>
																	<c:when test="${issueInfo.getIssue_ipcrVO().getIpcr_nm() eq '낮음'}"><span class="badge badge-default badge-info">낮음</span></c:when>
																	<c:when test="${issueInfo.getIssue_ipcrVO().getIpcr_nm() eq '보통'}"><span class="badge badge-default badge-success">보통</span></c:when>
																	<c:when test="${issueInfo.getIssue_ipcrVO().getIpcr_nm() eq '높음'}"><span class="badge badge-default badge-warning">높음</span></c:when>
																	<c:when test="${issueInfo.getIssue_ipcrVO().getIpcr_nm() eq '긴급'}"><span class="badge badge-default badge-danger">긴급</span></c:when>
																	<c:otherwise><span class="badge badge-default badge-primary">${issueInfo.getIssue_ipcrVO().getIpcr_nm()}</span></c:otherwise>
																</c:choose>
															</td>
															<td>
																<c:choose>
																	<c:when test="${issueInfo.getIssue_sttusVO().getSttus_nm() eq '신규'}"><span class="badge badge-default badge-info">신규</span></c:when>
																	<c:when test="${issueInfo.getIssue_sttusVO().getSttus_nm() eq '진행'}"><span class="badge badge-default badge-success">진행</span></c:when>
																	<c:when test="${issueInfo.getIssue_sttusVO().getSttus_nm() eq '해결'}"><span class="badge badge-default badge-warning">해결</span></c:when>
																	<c:when test="${issueInfo.getIssue_sttusVO().getSttus_nm() eq '의견'}"><span class="badge badge-default badge-primary">의견</span></c:when>
																	<c:when test="${issueInfo.getIssue_sttusVO().getSttus_nm() eq '완료'}"><span class="badge badge-default badge-info">완료</span></c:when>
																	<c:otherwise><span class="badge badge-default badge-danger">${issueInfo.getIssue_sttusVO().getSttus_nm()}</span></c:otherwise>
																</c:choose>
															</td>
															<td>
																${issueInfo.getIssue_sttusVO().getSttus_progrs()} %
															    <div class="progress progress-sm">
															    	<c:choose>
																		<c:when test="${issueInfo.getIssue_sttusVO().getSttus_nm() eq '신규'}"><div aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-gradient-x-info" role="progressbar" style="width:${issueInfo.getIssue_sttusVO().getSttus_progrs()}%" aria-valuenow="${issueInfo.getIssue_sttusVO().getSttus_progrs()}"></div></c:when>
																		<c:when test="${issueInfo.getIssue_sttusVO().getSttus_nm() eq '진행'}"><div aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-gradient-x-success" role="progressbar" style="width:${issueInfo.getIssue_sttusVO().getSttus_progrs()}%" aria-valuenow="${issueInfo.getIssue_sttusVO().getSttus_progrs()}"></div></c:when>
																		<c:when test="${issueInfo.getIssue_sttusVO().getSttus_nm() eq '해결'}"><div aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-gradient-x-warning" role="progressbar" style="width:${issueInfo.getIssue_sttusVO().getSttus_progrs()}%" aria-valuenow="${issueInfo.getIssue_sttusVO().getSttus_progrs()}"></div></c:when>
																		<c:when test="${issueInfo.getIssue_sttusVO().getSttus_nm() eq '의견'}"><div aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-gradient-x-primary" role="progressbar" style="width:${issueInfo.getIssue_sttusVO().getSttus_progrs()}%" aria-valuenow="${issueInfo.getIssue_sttusVO().getSttus_progrs()}"></div></c:when>
																		<c:when test="${issueInfo.getIssue_sttusVO().getSttus_nm() eq '완료'}"><div aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-gradient-x-info" role="progressbar" style="width:${issueInfo.getIssue_sttusVO().getSttus_progrs()}%" aria-valuenow="${issueInfo.getIssue_sttusVO().getSttus_progrs()}"></div></c:when>
																		<c:otherwise><div aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-gradient-x-danger" role="progressbar" style="width:${issueInfo.getIssue_sttusVO().getSttus_progrs()}%" aria-valuenow="${issueInfo.getIssue_sttusVO().getSttus_progrs()}"></div></c:otherwise>
																	</c:choose>
											                	</div>
															</td>
														</tr>
													</c:forEach>
												</c:if>
									        </tr>
								        </tbody>
							    	</table>
							    	${pagingUtil }
							<div align="center">
								<c:if test="${empty issueList}">
									존재하는 데이터가 없습니다.
								</c:if>
							</div>
				    </div>
				</div>
			</div>
		</div>
	</div>
</div>
</section>
          </div>
        </div>
        <div class="sidebar-detached sidebar-left">
          <div class="sidebar"><div class="bug-list-sidebar-content">
    <!-- Predefined Views -->
    <div class="card">
        <div class="card-header">
            <h4 class="card-title">진행상태</h4>
            <a class="heading-elements-toggle"><i class="ft-ellipsis-h font-medium-3"></i></a>
            <div class="heading-elements">
                <ul class="list-inline mb-0">
                    <li><a data-action="collapse"><i class="ft-minus"></i></a></li>
                    <li><a data-action="close"><i class="ft-x"></i></a></li>
                </ul>
            </div>
        </div>
        <!-- bug-list search -->
        <div class="card-content">
            <div class="card-body border-top-blue-grey border-top-lighten-5">
                <div class="bug-list-search">
                    <div class="bug-list-search-content">
                        <form action="${pageContext.request.contextPath}/empl/dy_issue/dy_issueList.do?prjct_id=${prjct_id}" method="post">
                            <div class="position-relative">
                                <input id="search_keyword" name="search_keyword" type="text" placeholder="검색어 입력..." class="form-control" style="margin-bottom: 5px"/>
                                <select class="form-control" name="search_keycode"  style="margin-bottom: 5px">
									<option>검색조건</option>
									<option value="TOTAL">전체</option>
									<option value="CONTENT">등록자</option>
									<option value="WRITER">담당자</option>
								</select>
							    <button type="submit" class="btn btn-primary form-control"  style="margin-bottom: 5px">검색</button>
                                <div class="form-control-position">
                                    <i class="ft-search text-size-base text-muted"></i>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- /bug-list search -->

            <!-- bug-list view -->
            <div class="card-body ">
                <div class="list-group">
                    <a href="${pageContext.request.contextPath}/empl/dy_issue/dy_issueList.do?prjct_id=${prjct_id}&reset=y" class="list-group-item list-group-item-action">전체</a>
                    <a href="${pageContext.request.contextPath}/empl/dy_issue/sttusIssueList.do?issue_sttus=${sttusList.get(0).getSttus_id()}&prjct_id=${prjct_id}" class="list-group-item list-group-item-action">${sttusList.get(0).getSttus_nm()}</a>
                    <a href="${pageContext.request.contextPath}/empl/dy_issue/sttusIssueList.do?issue_sttus=${sttusList.get(1).getSttus_id()}&prjct_id=${prjct_id}" class="list-group-item list-group-item-action">${sttusList.get(1).getSttus_nm()}</a>
                    <a href="${pageContext.request.contextPath}/empl/dy_issue/sttusIssueList.do?issue_sttus=${sttusList.get(2).getSttus_id()}&prjct_id=${prjct_id}" class="list-group-item list-group-item-action">${sttusList.get(2).getSttus_nm()}</a>
                    <a href="${pageContext.request.contextPath}/empl/dy_issue/sttusIssueList.do?issue_sttus=${sttusList.get(3).getSttus_id()}&prjct_id=${prjct_id}" class="list-group-item list-group-item-action">${sttusList.get(3).getSttus_nm()}</a>
                    <a href="${pageContext.request.contextPath}/empl/dy_issue/sttusIssueList.do?issue_sttus=${sttusList.get(4).getSttus_id()}&prjct_id=${prjct_id}" class="list-group-item list-group-item-action">${sttusList.get(4).getSttus_nm()}</a>
                    <a href="${pageContext.request.contextPath}/empl/dy_issue/sttusIssueList.do?issue_sttus=${sttusList.get(5).getSttus_id()}&prjct_id=${prjct_id}" class="list-group-item list-group-item-action">${sttusList.get(5).getSttus_nm()}</a>
                </div>
            </div>
        </div>
    </div>
    <!--/ Predefined Views -->
	
</div>
          </div>
        </div>
</body>
</html>