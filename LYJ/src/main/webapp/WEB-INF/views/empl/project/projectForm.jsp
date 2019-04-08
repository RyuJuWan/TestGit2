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
	$('#btnMain').click(function(){
		location.href='${pageContext.request.contextPath}/empl/main.do';
	});
	
})

</script>
</head>
<body>
<div class="content-body">
    <form  action="${pageContext.request.contextPath }/empl/project/insertProject.do" 
    		class="form-horizontal" method="post">
		<div style="width: 3150px" align="left">
			<section id="horizontal-form-layouts">
				<div class="col-md-6" >
					<div class="card">
						<div class="card-header">
							<h4 class="card-title" id="basic-layout-colored-form-control">프로젝트 생성</h4>
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
										<h4 class="form-section"><i class="fa fa-eye"></i> About Project</h4>
										<div class="row"  >
											<div class="col-md-6"  >
													<div class="form-group">
													<label for="prjct_nm">프로젝트명</label>
													<input class="form-control  " type="text" id="prjct_nm" name="prjct_nm">
													<input type="hidden" id="prjct_empl" name="prjct_empl" value="${LOGIN_EMPLINFO.empl_id}">
												</div>
											</div>
										</div>
										<div class="row">	
											<div class="col-md-6">
												<div class="form-group">
													<label for="prjct_inpt">프로젝트 시작일</label>
													<input type="date" id="prjct_inpt" class="form-control  " name="prjct_inpt">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label for="prjct_clos">프로젝트 마감일</label>
													<input type="date" id="prjct_clos" class="form-control " name="prjct_clos">
												</div>
											</div>
											
											<div class="col-md-6">
													<div class="form-group">
														<fieldset>
															<label for="prjct_prpsl">일감 수</label>
															<div class="input-group">
																<input type="text" class="touchspin-color" value="50" 
																data-bts-button-down-class="btn btn-primary" data-bts-button-up-class="btn btn-primary"
																id="prjct_wbs_num" name="prjct_wbs_num">
															</div>
														</fieldset>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<fieldset>
															<label for="prjct_nmbr">인원 수</label>
															<div class="input-group">
																<input type="text" class="touchspin-color"
																data-bts-button-down-class="btn btn-primary" data-bts-button-up-class="btn btn-primary"
																id="prjct_nmbr" name="prjct_nmbr"  value="50">
															</div>
														</fieldset>
													</div>
												</div>
												<div class="col-md-6">
												<div class="form-group">
													<label for="prjct_prpsl">제안서명</label>
													 <select id="prjct_prpsl" name="prjct_prpsl" class="form-control">
															<c:forEach items="${prpslList }" var="prpslInfo">
									        	                   <option value="${prpslInfo.prpsl_id }">${prpslInfo.prpsl_nm }</option>
															</c:forEach>
		                                             </select>
												</div>
											</div>
											<div class="form-group">
												<div class="card-content collapse show">
													<div class="card-body">
													<label for="projectinput8" style="margin-left: 3px;">프로젝트내용</label>
														<div class="form-group">
															<textarea name="prjct_cn" id="ckeditor" cols="30" rows="15" class="ckeditor">
															</textarea>
														</div>
													</div>
												</div>
											</div>
										</div>
								</div>
		                        <div class="form-actions right">
			                    	<button type="reset" class="btn btn-warning mr-1"><i class="ft-x"></i> 취소</button>
									<button type="submit" class="btn btn-primary"><i class="fa fa-check-square-o"></i> 등록</button>
									<button type="button" id="btnMain" class="btn btn-danger btn-min-width mr-1 mb-1" style="float: left" value="메인"><i class="fa fa-eye">목록</i></button>
								</div>
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