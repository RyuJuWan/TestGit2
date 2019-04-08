<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$('#btnList').click(function(){
		location.href = '${pageContext.request.contextPath}/empl/frb/frbList.do';
	});
	CKEDITOR.instances.ckeditor.setData('${frbInfo.frb_cn}');
	CKEDITOR.instances.ckeditor.config.autoParagraph = false;
	CKEDITOR.instances.ckeditor.config.fillEmptyBlocks = false;
	CKEDITOR.instances.ckeditor.config.fullPage = false;
	CKEDITOR.instances.ckeditor.config.ignoreEmptyParagraph = true;
	CKEDITOR.instances.ckeditor.config.enterMode = CKEDITOR.ENTER_BR;
	
	var frb_id = '${frbInfo.frb_id}';
	
	$('#deletebtn').click(function(){
		location.href='${pageContext.request.contextPath}/empl/frb/deleteFrbInfo.do?frb_id=${frbInfo.frb_id}';
	});
	
	$('#replyBtn').click(function(){
		var answer_cn= $('#answer_cn').val();
		location.href='${pageContext.request.contextPath }/empl/frb/insertAnswer.do?frb_id=${frbInfo.frb_id}&answer_cn='+answer_cn;
	});
});
</script>
</head>
<body>

<form action="${pageContext.request.contextPath }/empl/frb/modifyFrbInfo.do" class="form-horizontal">
<div class="content-body"><!-- Basic CKEditor start -->
<section id="horizontal-form-layouts">
	<div class="row">
	    <div class="col-md-12">
	        <div class="card">
	            <div class="card-header">
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
	            <div class="card-content collpase show">
	                <div class="card-body">
						<div class="card-text">
						</div>
	                    <form class="form form-horizontal">
	                    		<h4 class="form-section"><i class="ft-clipboard"></i>자유게시판</h4>
	                    	<div class="form-body" style="margin-right: 300px">
			                    <div class="form-group row">
	                            	<label class="col-md-3 label-control" for="projectinput1">제목</label>
		                            <div class="col-md-9">
		                            	<input type="text" id="frb_nm" class="form-control" 
		                            	placeholder="First Name" name="frb_nm" style="width: 900px"
		                            	value="${frbInfo.frb_nm }">
		                            </div>
		                        </div>

		                        <div class="form-group row">
									<label class="col-md-3 label-control" for="projectinput5">자유게시판ID</label>
									<div class="col-md-9">
		                            	<input type="text" id="frb_id" class="form-control"
		                            	 placeholder="Company Name" name="frb_id" style="width: 600px"
		                            	 value="${frbInfo.frb_id }">
		                            </div>
		                        </div>

								<div class="form-group row">
									<label class="col-md-3 label-control">Select File</label>
									<div class="col-md-9">
										<label id="projectinput8" class="file center-block">
											<input type="file" id="file">
											<span class="file-custom"></span>
										</label>
									</div>
								</div>
								<div class="form-group" style="margin-left: 300px">
									<div class="card-content collapse show">
									<div class="card-body">
										<div class="form-group">
											<textarea id="ckeditor" name="frb_cn" cols="30" rows="15" class="ckeditor">
											</textarea>
										</div>
									</div>
								</div>
								</div>
							</div>
							</form>
	                        <div class="form-actions" align="right">
								<button type="button" name="deletebtn" id="deletebtn" class="btn btn-warning mr-1"><i class="ft-x"></i> 삭제</button>
								<button type="submit" class="btn btn-primary"><i class="fa fa-check-square-o"></i> 수정</button>
								<button type="button" id="btnList" class="btn btn-danger btn-min-width mr-1 mb-1" style="float: left" value="목록"><i class="fa fa-eye">목록</i></button>
							</div>
	                    </form>
	                    <div class="card">
				<div class="card-content">
					<div class="card-body">
						<div class="media-list media-bordered">
							<h4 class="card-title">댓글</h4>
							
													<c:forEach items="${answerList }" var="answInfo">
												<c:if test="${answInfo.answer_grp eq frbInfo.getFrb_id()}">
													<div class="media">
													<c:forEach items="${emplList}" var="emplInfo">
														<c:if test="${emplInfo.empl_id eq answInfo.answer_empl}">
															<span class="media-left"> <img
																class="media-object rounded-circle"
																src="/empl/file/prpsl/${emplInfo.empl_photo }"
																alt="Generic placeholder image"
																style="width: 64px; height: 64px;" />
															</span>
														</c:if>
													</c:forEach>
														<div class="media-body">
															<span class="media-notation mt-1 float-right">${answInfo.answer_date }</span>
															<h5 class="media-heading">${ answInfo.answer_empl}</h5>
															${ answInfo.answer_cn}
															<div class="media-notation mt-1">
															<c:if test="${sessionScope.LOGIN_EMPLINFO.empl_id eq answInfo.answer_empl}">
	<!-- 															<a href="#"> <i class="ft-corner-up-left mr-0"></i>Reply</a> -->
	<%-- 															<a href="${pageContext.request.contextPath }/empl/dy_frb/modifyAnswInfo.do?answer_grp=${dyFrInfo.dynm_frb_id}"> <i class="ft-edit mr-0"></i> Edit</a> --%>
	 															<a href="${pageContext.request.contextPath }/empl/frb/deleteAnswerInfo.do?answer_id=${answInfo.answer_id}&frb_id=${frbInfo.frb_id}"> <i class="ft-edit mr-0"></i> Delete</a> 
															</c:if>
															</div>
														</div>
													</div>
												</c:if>
												</c:forEach>
												

												<div class="media">
													<c:forEach items="${emplList}" var="emplInfo">
														<c:if test="${emplInfo.empl_id eq sessionScope.LOGIN_EMPLINFO.empl_id}">
															<span class="media-left"> <img
																class="media-object rounded-circle"
																src="/empl/file/prpsl/${emplInfo.empl_photo }"
																alt="Generic placeholder image"
																style="width: 64px; height: 64px;" />
															</span>
														</c:if>
													</c:forEach>
													<div class="media-body">
														<h5 class="media-heading">${sessionScope.LOGIN_EMPLINFO.empl_id}</h5>
														<div class="row" style="margin-bottom: 0px;">
															<div class="col-md-11">
																<div class="form-group">
																	<textarea name="answer_cn"
																		class="form-control textarea-maxlength"
																		id="answer_cn"
																		 rows="3" style="width: 1200px"></textarea>
																	<div class="media-notation mt-1">
<%-- 																		<a href="${pageContext.request.contextPath }/empl/frb/insertAnswer.do?dynm_frb_id=${dyFrInfo.dynm_frb_id}&answer_cn=$('#maxLength-textarea').val()"> <i class="ft-corner-up-left mr-0"></i>Reply</a> --%>
																		<div id="replyBtn"><a href="#"> <i class="ft-edit mr-0"></i> Reply</a></div>
<!-- 																		<a href="#"> <i class="ft-trash-2 mr-0"></i>Delete</a> -->
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
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
</section>


  </body>
</html>