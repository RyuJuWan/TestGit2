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
	   $('#createrisk').click(function(){
		  location.href = '${pageContext.request.contextPath}/empl/dy_risk/dy_riskForm.do?prjct_id=${prjct_id}'; 
	   });
	   
	   $('#riskListTable tr:gt(0)').click(function(){
		   if(eval('${empty sessionScope.LOGIN_EMPLINFO.empl_id}')){
			   alert("로그인이 필요합니다.");
			   return false;
		   } else{
			   var risk_id = $(this).find('input[name=risk_id]').val();
			   location.href = '${pageContext.request.contextPath}/empl/dy_risk/dy_riskView.do?risk_id=' + risk_id +'&prjct_id=${prjct_id}';
		   }
	   });
	});
</script>
</head>
<body>
       <div class="content-header row">
          <div class="content-header-left col-md-6 col-12 mb-2" style="margin-left: 270px;">
            <h3 class="content-header-title">리스크 게시판</h3>
            <div class="row breadcrumbs-top" >
              <div class="breadcrumb-wrapper col-12">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/empl/main.do">Home</a>
                  </li>
                  <li class="breadcrumb-item active">리스크 게시판
                  </li>
                </ol>
              </div>
            </div>
          </div>
          <div class="content-header-right " style="margin-left: 350px; margin-top: 20px;">
            <div class="media width-250 float-right">
              <media-left class="media-middle">
                <div id="sp-bar-total-sales"><canvas width="152" height="30" style="display: inline-block; width: 152px; height: 30px; vertical-align: top;"></canvas></div>
              </media-left>
              <div class="media-body media-right text-right">
                <h3 class="m-0">$5,668</h3><span class="text-muted">Sales</span>
              </div>
            </div>
          </div>
        </div>


        <div class="content-body" style="height: 3404px;"><section class="row">
    <div class="col-12">
        <div class="card">
            <div class="card-header">
            	<h4 class="card-title">리스크 게시판</h4>
            	<a class="heading-elements-toggle"><i class="ft-ellipsis-h font-medium-3"></i></a>
        		<div class="heading-elements">
            		<button id="createrisk" class="btn btn-primary btn-sm"><i class="ft-plus white"></i> Risk Add</button>
                </div>
            </div>
            <div class="card-content">
                <div class="card-body">
	                <!-- Task List table -->
	                <div class="table-responsive">
		                <div id="project-task-list_wrapper" class="dataTables_wrapper dt-bootstrap4">
		                <div class="row">
		                <div class="col-sm-12">
		                <table id="riskListTable" class="table table-white-space table-bordered row-grouping display no-wrap icheck table-middle dataTable" role="grid" aria-describedby="project-task-list_info" style="position: relative;">
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
									<c:if test="${!empty riskList}">
										<c:forEach items="${riskList}" var="riskInfo">
											<tr>
												<input id="risk_id" name="risk_id" type="hidden" value="${riskInfo.getRisk_id()}">
												<td>${fn:substring(riskInfo.getRisk_regist_day(), 0, 10)}</td>
												<td>${riskInfo.getRisk_nm() }</td>
												<c:choose>
													<c:when test="${!empty riskInfo.getRisk_chrg()}">
														<c:forEach items="${prjctEmpl}" var="emplInfo">
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
						${pagingUtil }
						<div align="center">
								<c:if test="${empty riskList}">
									존재하는 데이터가 없습니다.
								</c:if>
						</div>
						</div>
					</div>
				</div>
			</div>
		<!--/ Task List table -->
		</div>
       </div>
      </div>
    </div>
</section>
        </div>
</body>
</html>