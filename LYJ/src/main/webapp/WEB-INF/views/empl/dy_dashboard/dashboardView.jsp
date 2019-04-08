<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<div class="content-body"><!-- Analytics charts -->
<div class="row">
    <div class="col-lg-12 col-md-12 col-12">
        <div class="card">
            <div class="card-header no-border-bottom">
                <h4 class="card-title">프로젝트 대시보드</h4>
                <a class="heading-elements-toggle"><i class="ft-more-horizontal font-medium-3"></i></a>
                <div class="heading-elements">
                    <div class="btn-group" role="group" aria-label="Basic example">
                        <button type="button" class="btn btn-outline-primary btn-round active">Hourly</button>
                        <button type="button" class="btn btn-outline-primary btn-round">Day</button>
                        <button type="button" class="btn btn-outline-primary btn-round">Month</button>
                    </div>
                </div>
            </div>
            <div class="card-content">
                <div class="card-body">
                    <div class="row my-1">
                        <div class="col-lg-4 col-12 p-1 border-right-blue-grey border-right-lighten-5">
                            <div class="text-center">
                            
                                <h3>15,678</h3>
                                <p class="text-muted">Total Visit <span class="success darken-2"><i class="ft-arrow-up"></i> 4.27%</span></p>
                                <div id="sp-bar-total-cost"></div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-12 p-1 border-right-blue-grey border-right-lighten-5">
                            <div class="text-center">
                                <h3>8,630</h3>
                                <p class="text-muted">Unique Visitor <span class="danger darken-2"><i class="ft-arrow-down"></i> 2.30%</span></p>
                                <div id="sp-stacked-bar-total-sales"></div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-12 p-1">
                            <div class="text-center">
                                <h3>32,454</h3>
                                <p class="text-muted">Page Views <span class="success darken-2"><i class="ft-arrow-up"></i> 8.16%</span></p>
                                <div id="sp-tristate-bar-total-revenue"></div>
                            </div>
                        </div>
                    </div>

                    <ul class="list-inline text-center mt-3">
                        <li>
                            <h6><i class="ft-circle danger"></i> Page Views</h6>
                        </li>
                        <li>
                            <h6><i class="ft-circle success pl-1"></i> Total Visit</h6>
                        </li>
                        <li>
                            <h6><i class="ft-circle warning pl-1"></i> Unique Visitor</h6>
                        </li>
                    </ul>
                    <div class="row">
                     	<div id="chart_div2" style="margin-left: 100px"></div>
                         <div id="bar_chart_div"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--/ Analytics charts -->
<div class="row match-height">
    <div class="col-xl-6 col-lg-12">
        <div class="card">
            <div class="card-content">
	            <div class="card-body">
	            	<h4>팀원관리</h4>
	                <div class="table-responsive" style="margin-top: 30px">
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
                   		</div>
				    </div>
        </div>
    </div>
    <div class="col-xl-6 col-lg-12">
        <div class="card">
            <div class="card-header no-border">
                <h4 class="card-title">결함 게시판</h4>
                <a class="heading-elements-toggle"><i class="ft-more-horizontal font-medium-3"></i></a>
                <div class="heading-elements">
                    <ul class="list-inline mb-0">
                        <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="card-content">
                <div id="audience-list-scroll" class="table-responsive height-300 position-relative">
                    <table class="table mb-0">
                        <thead>
                            <tr>
                             	<th>발생 일자</th>
				                <th>결함명</th>
				                <th>담당자</th>
				                <th>중요도</th>				                
				                <th>진행상태 명</th>				                
				                <th>진행률</th>
                            </tr>
                        </thead>
                        <tbody>
 <tr role="row" class="even">
									<c:if test="${!empty flawList}">
										<c:forEach items="${flawList}" var="flawInfo">
											<tr>
												<input id="flaw_id" name="flaw_id" type="hidden" value="${flawInfo.getFlaw_id()}">
												<td>${fn:substring(flawInfo.getFlaw_regist_day(), 0, 10)}</td>
												<td>${flawInfo.getFlaw_nm() }</td>
												<c:choose>
													<c:when test="${!empty flawInfo.getFlaw_chrg()}">
														<c:forEach items="${prjctEmpl3}" var="emplInfo">
															<c:if test="${flawInfo.getFlaw_chrg() == emplInfo.getEmpl_id()}">
																<td>${emplInfo.getEmpl_nm()}</td>
															</c:if>															
														</c:forEach>
													</c:when>
													<c:otherwise>
														<td>없음</td>
													</c:otherwise>
												</c:choose>
												<td>
													<c:choose>
														<c:when test="${flawInfo.getFlaw_ipcrVO().getIpcr_nm() eq '낮음'}"><span class="badge badge-default badge-info">낮음</span></c:when>
														<c:when test="${flawInfo.getFlaw_ipcrVO().getIpcr_nm() eq '보통'}"><span class="badge badge-default badge-success">보통</span></c:when>
														<c:when test="${flawInfo.getFlaw_ipcrVO().getIpcr_nm() eq '높음'}"><span class="badge badge-default badge-warning">높음</span></c:when>
														<c:when test="${flawInfo.getFlaw_ipcrVO().getIpcr_nm() eq '긴급'}"><span class="badge badge-default badge-danger">긴급</span></c:when>
														<c:otherwise><span class="badge badge-default badge-primary">${flawInfo.getFlaw_ipcrVO().getIpcr_nm()}</span></c:otherwise>
													</c:choose>
												</td>
												<td>
													<c:choose>
														<c:when test="${flawInfo.getFlaw_sttusVO().getSttus_nm() eq '신규'}"><span class="badge badge-default badge-info">신규</span></c:when>
														<c:when test="${flawInfo.getFlaw_sttusVO().getSttus_nm() eq '진행'}"><span class="badge badge-default badge-success">진행</span></c:when>
														<c:when test="${flawInfo.getFlaw_sttusVO().getSttus_nm() eq '해결'}"><span class="badge badge-default badge-warning">해결</span></c:when>
														<c:when test="${flawInfo.getFlaw_sttusVO().getSttus_nm() eq '의견'}"><span class="badge badge-default badge-primary">의견</span></c:when>
														<c:when test="${flawInfo.getFlaw_sttusVO().getSttus_nm() eq '완료'}"><span class="badge badge-default badge-info">완료</span></c:when>
														<c:otherwise><span class="badge badge-default badge-danger">${flawInfo.getFlaw_sttusVO().getSttus_nm()}</span></c:otherwise>
													</c:choose>
												</td>
												<td>${flawInfo.getFlaw_sttusVO().getSttus_progrs() } %
													<div class="progress progress-sm">
													   	<c:choose>
															<c:when test="${flawInfo.getFlaw_sttusVO().getSttus_nm() eq '신규'}"><div aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-gradient-x-info" role="progressbar" style="width:${flawInfo.getFlaw_sttusVO().getSttus_progrs()}%" aria-valuenow="${flawInfo.getFlaw_sttusVO().getSttus_progrs()}"></div></c:when>
															<c:when test="${flawInfo.getFlaw_sttusVO().getSttus_nm() eq '진행'}"><div aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-gradient-x-success" role="progressbar" style="width:${flawInfo.getFlaw_sttusVO().getSttus_progrs()}%" aria-valuenow="${flawInfo.getFlaw_sttusVO().getSttus_progrs()}"></div></c:when>
															<c:when test="${flawInfo.getFlaw_sttusVO().getSttus_nm() eq '해결'}"><div aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-gradient-x-warning" role="progressbar" style="width:${flawInfo.getFlaw_sttusVO().getSttus_progrs()}%" aria-valuenow="${flawInfo.getFlaw_sttusVO().getSttus_progrs()}"></div></c:when>
															<c:when test="${flawInfo.getFlaw_sttusVO().getSttus_nm() eq '의견'}"><div aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-gradient-x-primary" role="progressbar" style="width:${flawInfo.getFlaw_sttusVO().getSttus_progrs()}%" aria-valuenow="${flawInfo.getFlaw_sttusVO().getSttus_progrs()}"></div></c:when>
															<c:when test="${flawInfo.getFlaw_sttusVO().getSttus_nm() eq '완료'}"><div aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-gradient-x-info" role="progressbar" style="width:${flawInfo.getFlaw_sttusVO().getSttus_progrs()}%" aria-valuenow="${flawInfo.getFlaw_sttusVO().getSttus_progrs()}"></div></c:when>
															<c:otherwise><div aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-gradient-x-danger" role="progressbar" style="width:${flawInfo.getFlaw_sttusVO().getSttus_progrs()}%" aria-valuenow="${flawInfo.getFlaw_sttusVO().getSttus_progrs()}"></div></c:otherwise>
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
								<c:if test="${empty flawList}">
									존재하는 데이터가 없습니다.
								</c:if>
						</div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Analytics map based session -->
<div class="row">
    <div class="col-12">
        <div class="card box-shadow-0">
            <div class="card-content">
                <div class="row">
                    <div class="col-xl-8 col-lg-12">
                    
                         <div class="card-content">
                <div class="card-body">
                    <p>이슈 게시판 <span class="float-right"><a href="project-summary.html" target="_blank">Issue Summary <i class="ft-arrow-right"></i></a></span></p>
                </div>
                <div class="table-responsive">
                    <table id="recent-orders" class="table table-hover mb-0">
                        <thead>
                            <tr>
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
                   
                </div>
            </div>                    </div>
                    <div class="col-xl-4 col-lg-12">
                        <div class="card-body">
                            <h4 class="card-title py-1 text-center">이슈 현황</h4>
                            <div class="row">
                                <div class="col-xl-12 col-lg-6 col-sm-12">
                                    <div class="card-body">
						                <table class="columns">
										      <tr>
										        <td><div id="piechart_div" style="border: 1px solid #ccc"></div></td>
										        <td><div id="barchart_div" style="border: 1px solid #ccc"></div></td>
										      </tr>
						   				 </table>
						            </div>
						           </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Analytics map based session -->

<!-- Analytics map based session -->
<div class="row">
    <div class="col-12">
        <div class="card box-shadow-0">
            <div class="card-content">
                <div class="row">
                    <div class="col-xl-8 col-lg-12">
                         <div class="card-content">
                <div class="card-body">
                    <p>리스크 게시판 <span class="float-right"><a href="project-summary.html" target="_blank">Issue Summary <i class="ft-arrow-right"></i></a></span></p>
                </div>
                <div class="card-body">
	                <div class="table-responsive" style="margin-top: 30px">
		                <table id="tblEmpl" class="table table-white-space table-bordered row-grouping display no-wrap icheck table-middle">
					        <thead>
					            <tr>
					                <th>발생 일자</th>
					                <th>리스크명</th>
					                <th>담당자</th>
					                <th>중요도</th>
					                <th>진행상태 명</th>				                
					                <th>진행률</th>
					            </tr>
					        </thead>
					        <tbody>
					        <tr role="row" class="even">
									<c:if test="${!empty riskList2}">
										<c:forEach items="${riskList2}" var="riskInfo">
											<tr>
												<input id="risk_id" name="risk_id" type="hidden" value="${riskInfo.getRisk_id()}">
												<td>${fn:substring(riskInfo.getRisk_regist_day(), 0, 10)}</td>
												<td>${riskInfo.getRisk_nm() }</td>
												<c:choose>
													<c:when test="${!empty riskInfo.getRisk_chrg()}">
														<c:forEach items="${prjctEmpl2}" var="emplInfo">
															<c:if test="${riskInfo.getRisk_chrg() == emplInfo.getEmpl_id()}">
																<td>${emplInfo.getEmpl_nm()}</td>
															</c:if>															
														</c:forEach>
													</c:when>
													<c:otherwise>
														<td>없음</td>
													</c:otherwise>
												</c:choose>
												<td>
													<c:choose>
														<c:when test="${riskInfo.getRisk_ipcrVO().getIpcr_nm() eq '낮음'}"><span class="badge badge-default badge-info">낮음</span></c:when>
														<c:when test="${riskInfo.getRisk_ipcrVO().getIpcr_nm() eq '보통'}"><span class="badge badge-default badge-success">보통</span></c:when>
														<c:when test="${riskInfo.getRisk_ipcrVO().getIpcr_nm() eq '높음'}"><span class="badge badge-default badge-warning">높음</span></c:when>
														<c:when test="${riskInfo.getRisk_ipcrVO().getIpcr_nm() eq '긴급'}"><span class="badge badge-default badge-danger">긴급</span></c:when>
														<c:otherwise><span class="badge badge-default badge-primary">${riskInfo.getRisk_ipcrVO().getIpcr_nm()}</span></c:otherwise>
													</c:choose>
												</td>
												<td>
														<c:choose>
															<c:when test="${riskInfo.getRisk_sttusVO().getSttus_nm() eq '신규'}"><span class="badge badge-default badge-info">신규</span></c:when>
															<c:when test="${riskInfo.getRisk_sttusVO().getSttus_nm() eq '진행'}"><span class="badge badge-default badge-success">진행</span></c:when>
															<c:when test="${riskInfo.getRisk_sttusVO().getSttus_nm() eq '해결'}"><span class="badge badge-default badge-warning">해결</span></c:when>
															<c:when test="${riskInfo.getRisk_sttusVO().getSttus_nm() eq '의견'}"><span class="badge badge-default badge-primary">의견</span></c:when>
															<c:when test="${riskInfo.getRisk_sttusVO().getSttus_nm() eq '완료'}"><span class="badge badge-default badge-info">완료</span></c:when>
															<c:otherwise><span class="badge badge-default badge-danger">${riskInfo.getRisk_sttusVO().getSttus_nm()}</span></c:otherwise>
														</c:choose>
												</td>
												<td>${riskInfo.getRisk_sttusVO().getSttus_progrs() } %
													<div class="progress progress-sm">
													   	<c:choose>
															<c:when test="${riskInfo.getRisk_sttusVO().getSttus_nm() eq '신규'}"><div aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-gradient-x-info" role="progressbar" style="width:${riskInfo.getRisk_sttusVO().getSttus_progrs()}%" aria-valuenow="${riskInfo.getRisk_sttusVO().getSttus_progrs()}"></div></c:when>
															<c:when test="${riskInfo.getRisk_sttusVO().getSttus_nm() eq '진행'}"><div aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-gradient-x-success" role="progressbar" style="width:${riskInfo.getRisk_sttusVO().getSttus_progrs()}%" aria-valuenow="${riskInfo.getRisk_sttusVO().getSttus_progrs()}"></div></c:when>
															<c:when test="${riskInfo.getRisk_sttusVO().getSttus_nm() eq '해결'}"><div aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-gradient-x-warning" role="progressbar" style="width:${riskInfo.getRisk_sttusVO().getSttus_progrs()}%" aria-valuenow="${riskInfo.getRisk_sttusVO().getSttus_progrs()}"></div></c:when>
															<c:when test="${riskInfo.getRisk_sttusVO().getSttus_nm() eq '의견'}"><div aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-gradient-x-primary" role="progressbar" style="width:${riskInfo.getRisk_sttusVO().getSttus_progrs()}%" aria-valuenow="${riskInfo.getRisk_sttusVO().getSttus_progrs()}"></div></c:when>
															<c:when test="${riskInfo.getRisk_sttusVO().getSttus_nm() eq '완료'}"><div aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-gradient-x-info" role="progressbar" style="width:${riskInfo.getRisk_sttusVO().getSttus_progrs()}%" aria-valuenow="${riskInfo.getRisk_sttusVO().getSttus_progrs()}"></div></c:when>
															<c:otherwise><div aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-gradient-x-danger" role="progressbar" style="width:${riskInfo.getRisk_sttusVO().getSttus_progrs()}%" aria-valuenow="${riskInfo.getRisk_sttusVO().getSttus_progrs()}"></div></c:otherwise>
														</c:choose>
											        </div>
												</td>
											</tr>
										</c:forEach>
									</c:if>
								</tr>
					        </tbody>
					    </table>
					    	
								</div>
                   		</div>
           				 </div>
					 </div>
					 <div class="col-xl-4 col-lg-12">
                        <div class="card-body">
                            <div class="card">
            <div class="card-header no-border">
                <h4 class="card-title">공지사항</h4>
                <a class="heading-elements-toggle"><i class="ft-more-horizontal font-medium-3"></i></a>
                <div class="heading-elements">
                    <ul class="list-inline mb-0">
                        <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="card-content">
                <div id="audience-list-scroll" class="table-responsive height-300 position-relative">
                    <table class="table mb-0">
                        <thead>
                            <tr>
                                <th scope="col" width="5%" style="text-align:center">No</th>
								<th scope="col" width="55%" style="text-align:center">제목</th>
								<th scope="col" width="20%" style="text-align:center">작성일</th>
								<th scope="col" width="10%" style="text-align:center">조회수</th>
                            </tr>
                        </thead>
                       		<tbody>
								<c:forEach items="${dyNoticeList}" var="frb">
								<tr>
									<td><input type="hidden" value="${frb.dynm_notice_id}">${frb.rnum}</td>
									<td>${frb.dynm_notice_nm }</td>
									<td>${frb.dynm_notice_date }</td>
									<td>${frb.dynm_notice_inquiry }</td>
								</tr>
							</c:forEach>
					        </tbody>
						</table>
						 ${pagingUtil}
                </div>
            </div>
        </div>
                        </div>
                    </div>
					 
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Analytics map based session -->

<!-- Analytics map based session -->
<div class="row">
    <div class="col-12">
        <div class="card box-shadow-0">
            <div class="card-content">
                <div class="row">
                    <div class="col-xl-12 col-lg-12">
                         <div class="card-content">
                <div class="card-body">
                    <p>업무관리게시판 <span class="float-right"><a href="project-summary.html" target="_blank">Issue Summary <i class="ft-arrow-right"></i></a></span></p>
                </div>
                <div class="table-responsive">
                    <table id="recent-orders" class="table table-hover mb-0">
                        <thead>
                            <tr>
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
                            <tr role="row" class="even">
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
				        </tr>
                        </tbody>
                    </table>
                   
               				 </div>
           				 </div>
					 </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Analytics map based session -->

<!-- Audience by country -->
<div class="row match-height">
    <div class="col-xl-6 col-lg-12">
        <div class="card">
            <div class="card-content">
	            
				    </div>
        </div>
    </div>
    <div class="col-xl-6 col-lg-12">
        
    </div>
</div>
        </div>
      </div>
    </div>
</body>
<script type="text/javascript">
	var flawTotalCount = ${flawCount1} + ${flawCount2} + ${flawCount3} +${flawCount4} + ${flawCount5};
	var wbsTotalCount = ${wbsCount1} + ${wbsCount2} + ${wbsCount3} +${wbsCount4} + ${wbsCount5};
      // Load Charts and the corechart and barchart packages.
      google.charts.load('current', {'packages':['corechart']});

      // Draw the pie chart and bar chart when Charts is loaded.
      google.charts.setOnLoadCallback(drawChart);
      
      function drawChart() {

        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addRows([
          ['신규', ${issueCount1}],
          ['진행', ${issueCount2}],
          ['해결', ${issueCount3}],
          ['의견', ${issueCount4}],
          ['완료', ${issueCount5}]
        ]);

        var piechart_options = {title:'이슈차트',
                       width:400,
                       height:300};
        var piechart = new google.visualization.PieChart(document.getElementById('piechart_div'));
        piechart.draw(data, piechart_options);

        var barchart_options = {title:'이슈 차트',
                       width:auto,
                       height:auto,
                       legend: 'none'};
        var barchart = new google.visualization.BarChart(document.getElementById('barchart_div'));
        barchart.draw(data, barchart_options);
      }
      
 		google.charts.load('current', {'packages':['bar','corechart']});
      
      function schedulerSuccessAndFailChart() {
          var data = google.visualization.arrayToDataTable([
                 ["Title","전체", {role:'annotation'}, "완료", {role:'annotation'}],
                          [""
                  ,wbsTotalCount, wbsTotalCount //성공데이터
                  ,${wbsCount5}, ${wbsCount5}] //실패데이터
         ]);
   
         var barChartOption = {
                 bars: 'vertical',
                 height :260,
                 width :1000,
                 legend: { position: "top" },
                 isStacked: false,
                 tooltip:{textStyle : {fontSize:12}, showColorCode : true},
                 animation: { //차트가 뿌려질때 실행될 애니메이션 효과
                   startup: true,
                   duration: 1000,
                   easing: 'linear' },
                 annotations: {
                     textStyle: {
                       fontSize: 15,
                       bold: true,
                       italic: true,
                       color: '#99B898',
                       auraColor: '#FECEA8',
                       opacity: 0.8
                     }
                }
          };
   
         var chart = new google.visualization.BarChart(document.getElementById('bar_chart_div'));
   
         chart.draw(data, barChartOption);
         //반응형 그래프 출력 - 반응형 그래프를 원하지 않을 시 제거하거나 주석처리 하세요.
         window.addEventListener('resize', function() { chart.draw(data, barChartOption); }, false);
      }
   
      google.charts.setOnLoadCallback(schedulerSuccessAndFailChart);
      google.charts.setOnLoadCallback(drawChart2);
      function drawChart2() {
      	var data2 = new google.visualization.DataTable();
      	data2.addColumn('string', '인물 ');
      	data2.addColumn('number', ' 취득수 ');
      	data2.addRows([
      			['신규', ${flawCount1}], ['진행', ${flawCount2}],
      			['해결', ${flawCount3}], ['의견', ${flawCount4}],
      			['완료', ${flawCount5}]
      	]);

      	var opt2 = {
      		'title': '결함 차트 ',
      		'width': 400, 'height': 300,
      	};

      	var chart2 = new google.visualization.BarChart(
      			document.getElementById('chart_div2'));
      	chart2.draw(data2, opt2);
      	
      }
      
</script>
</html>