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
	$('#tblEmpl tr:gt(0)').click(function(){
		var empl_id = $(this).find('td:eq(1) input').val();
		if('${LOGIN_EMPLINFO.empl_id}' == empl_id){
			location.href = "${pageContext.request.contextPath}/empl/member/emplView.do";
		} else {
			location.href = "${pageContext.request.contextPath}/empl/member/emplView2.do?empl_id=" + empl_id;
		}
	});
});
</script>
</head>
<body>
<div class="app-content content">
      <div class="content-wrapper">
        <div class="content-header row">
          <div class="content-header-left col-md-8 col-12 mb-2 breadcrumb-new  " style="margin-left: 270px" align="left">
            <h3 class="content-header-title mb-0 d-inline-block">사원정보 조회</h3>
            <div class="row breadcrumbs-top d-inline-block">
              <div class="breadcrumb-wrapper col-12">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="index.html">Home</a>
                  </li>
                  <li class="breadcrumb-item"><a href="#">Users</a>
                  </li>
                  <li class="breadcrumb-item active">Contacts
                  </li>
                </ol>
              </div>
            </div>
          </div>
        </div>
        
        <div class="content-detached content-right">
          <div class="content-body"><section class="row">
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
	                <!-- Task List table -->
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
					        	<c:forEach items="${emplPageList}" var="emplPageInfo">
					        		<tr>
					        			<td>
											${emplPageInfo.rnum}	
					        			</td>
					        			<td>
					        				<input type="hidden" value="${emplPageInfo.empl_id}">
					        				${emplPageInfo.empl_id}
					        			</td>
					        			<td>
					        				${emplPageInfo.empl_nm}
					        			</td>
					        			<td>
					        				<c:forEach items="${deptList}" var="deptInfo">
					        					<c:if test="${deptInfo.dept_id eq emplPageInfo.empl_dept}">
					        						${deptInfo.dept_nm}
					        					</c:if>
					        				</c:forEach>
					        			</td>
					        			<td>
					        				<c:forEach items="${ofcpsList}" var="ofcpsInfo">
					        					<c:if test="${ofcpsInfo.ofcps_id eq emplPageInfo.empl_ofcps}">
					        						${ofcpsInfo.ofcps_nm}
					        					</c:if>
					        				</c:forEach>
					        			</td>
					        			<td>
					        				${emplPageInfo.empl_mail}
					        			</td>
					        		</tr>
					        	</c:forEach>
					        </tbody>
					    </table>
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
<!--         <div class="card-head"> -->
<!--             <div class="media p-1"> -->
<!--                 <div class="media-left pr-1"><span class="avatar avatar-sm avatar-online rounded-circle"><img src="../../../app-assets/images/portrait/small/avatar-s-1.png" alt="avatar"><i></i></span></div> -->
<!--                 <div class="media-body media-middle"> -->
<!--                     <h5 class="media-heading">Margaret Govan</h5> -->
<!--                 </div> -->
<!--             </div> -->
<!--         </div> -->
        <!-- contacts search -->
<!--         <div class="card-body border-top-blue-grey border-top-lighten-5"> -->
<!--             <div class="bug-list-search"> -->
<!--                 <div class="bug-list-search-content"> -->
<!--                     <form action="#"> -->
<!--                         <div class="position-relative"> -->
<!--                             <input type="search" id="search-contacts" class="form-control" placeholder="Search contacts..."> -->
<!--                             <div class="form-control-position"> -->
<!--                                 <i class="fa fa-search text-size-base text-muted"></i> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </form> -->
<!--                 </div> -->
<!--             </div> -->
<!--         </div> -->
        <!-- /contacts search -->

        <!-- Groups-->
        <div class="card-body">
            <p class="lead">부서</p>
            <ul class="list-group">
	            <li class="list-group-item">
	                <span class="badge badge-primary badge-pill float-right">
	                	${emplTotalCount}
	                </span> 
	                <a href="${pageContext.request.contextPath}/empl/member/emplList.do?deptFilter="> 
	                	전체
	                </a>
	            </li>
            	<c:set var="dept_num" value="1"></c:set>
            	<c:forEach items="${totalCountPerDeptList}" var="totalCountPerDept">
	                <li class="list-group-item">
	                    <span class="badge badge-primary badge-pill float-right">
	                    	${totalCountPerDept}
	                    </span> 
	                    <a href="${pageContext.request.contextPath}/empl/member/emplList.do?deptFilter=de00${dept_num}"> 
	                    	개발${dept_num}팀
	                    </a>
	                </li>
	                <c:set var="dept_num" value="${dept_num + 1}"></c:set>
            	</c:forEach>
            </ul>
        </div>
        <!--/ Groups-->
    </div>
    <!--/ Predefined Views -->

</div>
          </div>
        </div>
      </div>
    </div>
</body>
</html>