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
</script>
</head>
<body>
     <div class="content-body">
    <form action="${pageContext.request.contextPath }/empl/dy_reqre_specf/insertReqreSpecf.do" class="form-horizontal" method="post">
		<div style="width: 3150px" align="left">
			<section id="horizontal-form-layouts">
				<div class="col-md-6" >
					<div class="card">
						<div class="card-header">
							<h4 class="card-title" id="basic-layout-colored-form-control">요구사항정의서</h4>
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
								<form action="${pageContext.request.contextPath}/empl/dy_reqre_specf/insertReqreSpecf.do">
									<div class="form-body" style=" margin-left: 300px; margin-right: 300px;" >
										<h4 class="form-section"><i class="fa fa-eye"></i> About Project</h4>
										<div class="row"  >
											<div class="col-md-6"  >
													<div class="form-group">
													<label for="empl_nm">요구사항정의서 명</label>
													<input class="form-control" type="text" id="reqre_specf_nm" name="reqre_specf_nm">
													<input type="hidden" name="reqre_specf_empl" value="${LOGIN_EMPLINFO.empl_id}">
												</div>
											</div>
										</div>
										<div class="row"  >
											<div class="col-md-6"  >
													<div class="form-group">
													<label for="empl_nm">프로젝트 명</label>
													<input class="form-control" disabled="disabled" value="${prjNm }" type="text" >
													<input class="form-control"  name="reqre_specf_prjct_id"  value="${prjct_id }" type="hidden" >
												</div>
											</div>
												<div class="col-md-6"  >
														<div class="form-group">
														<label for="empl_nm">작성일자</label>
														<input type="text" id="reqre_specf_wrting_date" class="form-control" disabled="disabled" value="${today }" name="reqre_specf_wrting_date">
													</div>
												</div>
										</div>
										<div class="row">	
											<div class="col-md-6"  >
												<div class="form-group">
													<label for="projectinput5">결재선ID </label>
													<select class="form-control" name="reqre_specf_sanctn_id" style="margin: 3px; height: 40px">
						            	                <option>결재선유형</option>
														<c:forEach items="${sanctnlineList }" var="sanctnline">
								        	                   <option value="${sanctnline.sanctn_line_id }">${sanctnline.sanctn_line_nm }</option>
														</c:forEach>
							                        </select>
												</div>
											</div>
											<div class="col-md-6"  >
												<div class="form-group">
													<label for="projectinput5">결재서류유형ID </label>
													<select class="form-control" name="reqre_specf_papers_ty_id" style="margin: 3px; height: 40px" >
						            	               <option>결재서류유형</option>
								            	         <c:forEach items="${sanctnpaperstyList }" var="sanctnpapersty">   
								        	                   <option value="${sanctnpapersty.sanctn_papers_ty_id }">${sanctnpapersty.sanctn_papers_ty_nm }</option>
														</c:forEach>
								                    </select>
												</div>
											</div>
											<div class="form-group">
												<div class="card-content collapse show">
													<div class="card-body">
													<label for="projectinput8" style="margin-left: 3px;">내용</label>
														<div class="form-group">
															<textarea name="reqre_specf_cn" id="reqre_specf_cn" cols="30" rows="15" class="ckeditor">
															</textarea>
														</div>
													</div>
												</div>
											</div>
										</div>
										
			                        <div class="form-actions right">
										<button type="submit" class="btn btn-danger btn-min-width mr-1 mb-1"><i class="fa fa-check-square-o"></i> 등록</button>
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