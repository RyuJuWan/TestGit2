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
	$('table tr:gt(0)').click(function(){
		var expndtr_anact_id = $(this).find('td:eq(0)').text();
		$(location).attr('href', '${pageContext.request.contextPath}/empl/dy_expndtr_anact/dy_expndtr_anactView.do?prjct_id=${prjct_id}&expndtr_anact_id=' + expndtr_anact_id);
	});
	$('#btnForm').click(function(){
		location.href = '${pageContext.request.contextPath}/empl/dy_expndtr_anact/dy_expndtr_anactForm.do?prjct_id=${prjct_id}';
	});
});
</script>
</head>
<body>
        <div class="content-header row">
          <div class="content-header-left col-md-6 col-12 mb-2" style="margin-left: 270px;">
            <h3 class="content-header-title">지출결의서 게시판</h3>
            <div class="row breadcrumbs-top" >
              <div class="breadcrumb-wrapper col-12">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="index.html">Home</a>
                  </li>
                  <li class="breadcrumb-item"><a href="#">Invoice</a>
                  </li>
                  <li class="breadcrumb-item active">지출결의서 게시판
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

        <div class="content-body" style="height: 3404px;">
        	<section class="row">
    <div class="col-12">
        <div class="card">
            <div class="card-head">
                <div class="card-header">
                	<h4 class="card-title">지출결의서</h4>
                	<a class="heading-elements-toggle"><i class="ft-ellipsis-h font-medium-3"></i></a>
        			<div class="heading-elements">
                        <button class="btn btn-primary btn-md" id="btnForm"><i class="ft-plus white"></i> 지출결의서 등록</button>
            			<span class="dropdown">
	                        <button id="btnSearchDrop1" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" class="btn btn-warning btn-md dropdown-toggle dropdown-menu-right"><i class="ft-download-cloud white"></i></button>
	                        <span aria-labelledby="btnSearchDrop1" class="dropdown-menu mt-1 dropdown-menu-right">
	                            <a href="#" class="dropdown-item"><i class="fa fa-calendar"></i> Due Date</a>
	                            <a href="#" class="dropdown-item"><i class="fa fa-random"></i> Priority </a>
	                            <a href="#" class="dropdown-item"><i class="fa fa-bar-chart"></i> Balance Due</a>
	                            <a href="#" class="dropdown-item"><i class="fa fa-user"></i> Assign to</a>
	                        </span>
	                    </span>
            			<button class="btn btn-success btn-md"><i class="ft-settings white"></i></button>
                	</div>
                </div>
            </div>
            <div class="card-content">
                <div class="card-body">
	                <!-- Invoices List table -->
	                <div class="table-responsive">
	                <div id="invoices-list_wrapper" class="dataTables_wrapper dt-bootstrap4">
               		<div class="row">
               			<div class="col-sm-12">
               			<table id="invoices-list" class="table table-white-space table-bordered row-grouping display no-wrap icheck table-middle dataTable" role="grid" aria-describedby="invoices-list_info" >
				        <thead>
				            <tr role="row">
				            	<th class="sorting_asc" tabindex="0" aria-controls="invoices-list" rowspan="1" colspan="1" aria-sort="ascending" aria-label=": activate to sort column descending" style="width: 34px;">
					            NO</th>
					            <th class="sorting" tabindex="0" aria-controls="invoices-list" rowspan="1" colspan="1" aria-label="Date: activate to sort column ascending" style="width: 111px;">작성일자</th>
					            <th class="sorting" tabindex="0" aria-controls="invoices-list" rowspan="1" colspan="1" aria-label="Invoice #: activate to sort column ascending" style="width: 114px;">지출결의서명</th>
					            <th class="sorting" tabindex="0" aria-controls="invoices-list" rowspan="1" colspan="1" aria-label="Order No: activate to sort column ascending" style="width:  197px;">작성내용</th>
					            <th class="sorting" tabindex="0" aria-controls="invoices-list" rowspan="1" colspan="1" aria-label="Customer Name: activate to sort column ascending" style="width: 107px;">작성자</th>
					            <th class="sorting" tabindex="0" aria-controls="invoices-list" rowspan="1" colspan="1" aria-label="Balance Due: activate to sort column ascending" style="width: 130px;">금액</th>
					            <th class="sorting" tabindex="0" aria-controls="invoices-list" rowspan="1" colspan="1" aria-label="Actions: activate to sort column ascending" style="width: 97px;">첨부파일</th>
				            </tr>
				        </thead>
				        <tbody>
				        	<c:forEach items="${expndtrAnactList }" var="expndtrAnact">
				        	<tr role="row" class="odd">
				                <td>${expndtrAnact.rnum }</td>
				                <td>${expndtrAnact.expndtr_anact_date }</td>
				                <td><a class="text-bold-600">${expndtrAnact.expndtr_anact_nm }</a></td>
				                <td>${expndtrAnact.expndtr_anact_cn }</td>
				                <td>${expndtrAnact.expndtr_anact_wrter }</td>
				                <td>$ ${expndtrAnact.expndtr_anact_amount }</td>
				                <td>
				                	<span class="dropdown">
				                        <button id="btnSearchDrop2" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" class="btn btn-primary dropdown-toggle dropdown-menu-right"><i class="ft-settings"></i></button>
				                        <span aria-labelledby="btnSearchDrop2" class="dropdown-menu mt-1 dropdown-menu-right">
				                            <a href="#" class="dropdown-item"><i class="fa fa-eye"></i> Open Task</a>
				                            <a href="#" class="dropdown-item"><i class="fa fa-pencil"></i> Edit Task</a>
				                            <a href="#" class="dropdown-item"><i class="fa fa-check"></i> Complete Task</a>
				                            <a href="#" class="dropdown-item"><i class="ft-upload"></i> Assign to</a>
				                            <a href="#" class="dropdown-item"><i class="fa fa-trash"></i> Delete Task</a>
				                        </span>
				                    </span>
				                </td>
				            </tr>
				            </c:forEach>
				            </tbody>
					</table>
					${pagingUtil}
					</div>
					
					</div>
						</div>
					</div>
					<!--/ Invoices table -->
				</div>
            </div>
        </div>
    </div>
</section>
        </div>
</body>
</html>