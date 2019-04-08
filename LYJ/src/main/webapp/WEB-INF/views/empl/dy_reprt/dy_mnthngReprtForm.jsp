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
	$('#btnMnthngReprtList').click(function(){
		location.href = '${pageContext.request.contextPath}/empl/dy_reprt/dy_mnthngReprtList.do?prjct_id=${prjct_id}';
	});
});
</script>
</head>
<body>
     <div class="content-body">
    <form id="frmMnthngReprtForm" class="form-horizontal" action="${pageContext.request.contextPath}/empl/dy_reprt/insertDy_mnthngReprt.do?prjct_id=${prjct_id}" method="post" enctype="multipart/form-data">
		<div style="width: 3150px" align="left">
			<section id="horizontal-form-layouts">
				<div class="col-md-6" >
					<div class="card">
						<div class="card-header">
							<h4 class="card-title" id="basic-layout-colored-form-control">월간보고서 작성</h4>
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
													<label for="reprt_nm">보고서명</label>
													<input class="form-control" type="text" id="reprt_nm" name="reprt_nm">
												</div>
											</div>
										</div>
										<div class="row"  >
											<div class="col-md-6"  >
													<div class="form-group">
													<label for="reprt_start">보고서 시작일</label>
													<input class="form-control  " type="date" id="reprt_start" name="reprt_start">
												</div>
											</div>
											<div class="col-md-6"  >
													<div class="form-group">
													<label for="reprt_clos">보고서 종료일</label>
													<input class="form-control  " type="date" id="reprt_clos" name="reprt_clos">
												</div>
											</div>
										</div>
										<div class="row"  >
											<div class="col-md-6"  >
													<div class="form-group">
													<label for="reprt_sanctn_id">결재선</label>
													<select id="reprt_sanctn_id" name="reprt_sanctn_id" class="form-control">
														<c:forEach var="sanctnLineInfo" items="${sanctnLineList}">
															<option value="${sanctnLineInfo.sanctn_line_id}">
																<c:out value="${sanctnLineInfo.sanctn_line_nm}"></c:out>
															</option>
														</c:forEach>
													</select>
												</div>
											</div>
										</div>
										<div class="row">	
											<div class="col-md-6">
												<div class="form-group">
													<label>첨부파일</label>
													<label class="file center-block">
														<input type="file" id="file" name="fileitem" >
														<span class="file-custom"></span>
													</label>
												</div>
											</div>
											<div class="form-group">
												<div class="card-content collapse show">
													<div class="card-body">
													<label style="margin-left: 3px;">보고서 내용</label>
														<div class="form-group">
															<textarea name="reprt_cn" id="ckeditor" cols="30" rows="15" class="ckeditor">
															</textarea>
														</div>
													</div>
												</div>
											</div>
										</div>
										
			                        <div class="form-actions right">
				                        <button type="button" class="btn btn-warning mr-1"><i class="ft-x"></i> 취소</button>
										<button type="submit" class="btn btn-primary"><i class="fa fa-check-square-o"></i> 등록</button>
										<button type="button" id="btnMnthngReprtList" class="btn btn-danger btn-min-width mr-1 mb-1" style="float: left" value="목록"><i class="fa fa-eye">목록</i></button>
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