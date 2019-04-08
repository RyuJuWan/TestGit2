<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
 #deleteFileName{
 	width: 15px;
 	height: 15px;
 }
 #ifDeleteFileName{
 	display: none;
 }
</style>
<script type="text/javascript">

	$(function() {
		
		CKEDITOR.instances.ckeditor.setData('${dyRecsRoomInfo.dynm_recsroom_cn}');
		CKEDITOR.instances.ckeditor.config.autoParagraph = false;
		CKEDITOR.instances.ckeditor.config.fillEmptyBlocks = false;
		CKEDITOR.instances.ckeditor.config.fullPage = false;
		CKEDITOR.instances.ckeditor.config.ignoreEmptyParagraph = true;
		CKEDITOR.instances.ckeditor.config.enterMode = CKEDITOR.ENTER_BR;

		$('#btnList').click(function() {
							location.href = '${pageContext.request.contextPath}/empl/dy_recsroom/dy_recsroomList.do?prjct_id='
									+ '${prjct_id}';
						});

		var dynm_recsroom_id = '${dyRecsRoomInfo.dynm_recsroom_id}';

		$('#deletebtn').click(function() {
							location.href = '${pageContext.request.contextPath}/empl/dy_recsroom/dy_recsroomDelete.do?dynm_recsroom_id='
									+ dynm_recsroom_id;
						});
		$('#deleteFileName').click(function(){
//		 	   if(!authenticationChk()) return false; 
			   $.ajax({
				   url : '${pageContext.request.contextPath}/empl/dy_recsroom/fileExistence.do',
				   type : 'POST',
				   dataType : 'JSON',
				   success : function(result){
					   $('#ifDeleteFileName').attr("style","display: block");
					   $('#emptyFile').attr("style","display: none");
				   },
				   error : function(result){
						alert("State | " + result.message);
				   }
			   });
			   return false;
			    
			   $('form').submit(function(){
//		 		    if(!authenticationChk()) return false;
					return true;
			   }); 
		   });
// 		function authenticationChk(){
// 		   	if(${requestScope.hnfInptInfo.hnf_inpt_actpln_empl != sessionScope.LOGIN_EMPLINFO.empl_id}){
// 		   		alert('다른 사람이 작성한 글은 수정할 수 없습니다.');
// 		   		return false;
// 		   	}
// 			return true;
// 		   }

	});
</script>
</head>
<body>

	<form action="${pageContext.request.contextPath }/empl/dy_recsroom/dy_recsroomModify.do"
		class="form-horizontal" method="post" enctype="multipart/form-data">
		<div class="content-body">
			<!-- Basic CKEditor start -->
			<section id="horizontal-form-layouts">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<a class="heading-elements-toggle"><i
								class="fa fa-ellipsis-v font-medium-3"></i></a>
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
								<div class="card-text"></div>
								<form class="form form-horizontal">
									<h4 class="form-section">
										<i class="ft-clipboard"></i>자료실
									</h4>
									<div class="form-body" style="margin-right: 300px">
										<div class="form-group row">
											<label class="col-md-3 label-control" for="projectinput1">제목</label>
											<div class="col-md-9">
												<input type="text" id="dynm_frb_nm" class="form-control"
													placeholder="First Name" name="dynm_recsroom_nm"
													style="width: 900px"
													value="${dyRecsRoomInfo.dynm_recsroom_nm }">
											</div>
										</div>

										<div class="form-group row">
											<label class="col-md-3 label-control" for="projectinput5">자료실ID</label>
											<div class="col-md-9">
												<input type="text" id="dynm_frb_id" class="form-control"
													placeholder="Company Name" name="dynm_recsroom_id"
													style="width: 600px"
													value="${dyRecsRoomInfo.dynm_recsroom_id }">
											</div>
										</div>

										<h4 class="form-section">
											<i class="fa fa-paperclip"></i> 자료 파일
										</h4>
										<div>
											<c:if test="${empty dyRecsRoomFileInfo}">
												<div class="form-group">
													<label id="projectinput7" class="file center-block">
														<input type="file" id="fileitem" name="fileitem">
													</label>
												</div>
											</c:if>
											<c:if test="${!empty dyRecsRoomFileInfo}">
												<div id="emptyFile">
													<label id="efl_id"
														onclick="javascript:location.href='${pageContext.request.contextPath}/empl/dy_recsroom/fileDownload.do?dynm_recsroom=${dyRecsRoomFileInfo.getDynm_recsroom()}';">
														${dyRecsRoomFileInfo.getDynm_recsroom_file_nm()} </label>
													<button id="deleteFileName"></button>
												</div>
												<div id="ifDeleteFileName" class="form-group">
													<label id="projectinput7" class="file center-block">
														<input type="file" id="fileitem" name="fileitem">
													</label>
												</div>
											</c:if>
										</div>
										<div class="form-group" style="margin-left: 300px">
											<div class="card-content collapse show">
												<div class="card-body">
													<div class="form-group">
											<textarea id="ckeditor" name="dynm_recsroom_cn" cols="30"
															rows="15" class="ckeditor">
															
											</textarea>
													</div>
												</div>
											</div>
										</div>
									</div>
								</form>
								<div class="form-actions" align="right">
									<button type="button" name="deletebtn" id="deletebtn"
										class="btn btn-warning mr-1">
										<i class="ft-x"></i> 삭제
									</button>
									<button type="submit" class="btn btn-primary">
										<i class="fa fa-check-square-o"></i> 수정
									</button>
									<button type="button" id="btnList"
										class="btn btn-danger btn-min-width mr-1 mb-1"
										style="float: left" value="목록">
										<i class="fa fa-eye">목록</i>
									</button>
								</div>
								<div class="card">
									<div class="card-content">
										<div class="card-body">
<!-- 											<div class="media-list media-bordered"> -->
<!-- 												<h4 class="card-title">댓글</h4> -->
<!-- 												<div class="media"> -->
<!-- 													<span class="media-left"> <img -->
<!-- 														class="media-object rounded-circle" -->
<!-- 														src="../../../app-assets/images/portrait/small/avatar-s-12.png" -->
<!-- 														alt="Generic placeholder image" -->
<!-- 														style="width: 64px; height: 64px;" /> -->
<!-- 													</span> -->
<!-- 													<div class="media-body"> -->
<!-- 														<span class="media-notation mt-1 float-right">1 -->
<!-- 															week ago, 6:20 pm</span> -->
<!-- 														<h5 class="media-heading">Pudding marshmallow</h5> -->
<!-- 														Pudding marshmallow cheesecake. Chocolate cake apple pie -->
<!-- 														jelly-o bear claw ice cream sugar plum biscuit. Lemon -->
<!-- 														drops brownie biscuit jelly-o biscuit gummies. -->
<!-- 														<div class="media-notation mt-1"> -->
<!-- 															<a href="#"> <i class="ft-corner-up-left mr-0"></i> -->
<!-- 																Reply -->
<!-- 															</a> <a href="#"> <i class="ft-edit mr-0"></i> Edit -->
<!-- 															</a> <a href="#"> <i class="ft-trash-2 mr-0"></i> Delete -->
<!-- 															</a> -->
<!-- 														</div> -->
<!-- 													</div> -->
<!-- 												</div> -->
<!-- 												<div class="media"> -->
<!-- 													<span class="media-left"> <img -->
<!-- 														class="media-object rounded-circle" -->
<!-- 														src="../../../app-assets/images/portrait/small/avatar-s-24.png" -->
<!-- 														alt="Generic placeholder image" -->
<!-- 														style="width: 64px; height: 64px;" /> -->
<!-- 													</span> -->
<!-- 													<div class="media-body"> -->
<!-- 														<h5 class="media-heading">Oat cake</h5> -->
<!-- 														<div class="row" style="margin-bottom: 0px;"> -->
<!-- 															<div class="col-md-11"> -->
<!-- 																<div class="form-group"> -->
<!-- 																	<textarea name="maxlength-textarea" -->
<!-- 																		class="form-control textarea-maxlength" -->
<!-- 																		id="maxlength-textarea" -->
<!-- 																		placeholder="Enter upto 250 characters.." -->
<!-- 																		maxlength="250" rows="3" style="width: 1200px"></textarea> -->
<!-- 																	<div class="media-notation mt-1"> -->
<!-- 																		<a href="#"> <i class="ft-corner-up-left mr-0"></i> -->
<!-- 																			Reply -->
<!-- 																		</a> <a href="#"> <i class="ft-edit mr-0"></i> Edit -->
<!-- 																		</a> <a href="#"> <i class="ft-trash-2 mr-0"></i> -->
<!-- 																			Delete -->
<!-- 																		</a> -->
<!-- 																	</div> -->
<!-- 																</div> -->
<!-- 															</div> -->
<!-- 														</div> -->
<!-- 													</div> -->

<!-- 												</div> -->
<!-- 											</div> -->
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			</section>
		</div>
	</form>


</body>
</html>