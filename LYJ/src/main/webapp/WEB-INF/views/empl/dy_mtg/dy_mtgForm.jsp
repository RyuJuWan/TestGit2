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
	$('#btnMtgList').click(function(){
		location.href = '${pageContext.request.contextPath}/empl/dy_mtg/dy_mtgList.do?prjct_id=${prjct_id}';
	});
	
	$('#frmMtgForm').submit(function(){
		if($('input[name="mtg_video_alt_radio"]').val() == 'yes'){
			$('#mtg_video_alt').val($('#yes').val());
		} else $('#mtg_video_alt').val($('#no').val());
	});
});
</script>
</head>
<body>
     <div class="content-body">
    <form id="frmMtgForm" class="form-horizontal" action="${pageContext.request.contextPath}/empl/dy_mtg/insertDy_mtg.do?prjct_id=${prjct_id}" method="post" enctype="multipart/form-data">
		<div style="width: 3150px" align="left">
			<section id="horizontal-form-layouts">
				<div class="col-md-6" >
					<div class="card">
						<div class="card-header">
							<h4 class="card-title" id="basic-layout-colored-form-control">회의록 작성</h4>
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
													<label for="mtg_nm">회의명</label>
													<input class="form-control" type="text" id="mtg_nm" name="mtg_nm">
												</div>
											</div>
										</div>
										<div class="row"  >
											<div class="col-md-6"  >
													<div class="form-group">
													<label for="mtg_dt">회의일시</label>
													<input class="form-control  " type="date" id="mtg_dt" name="mtg_dt">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label for="mtg_place">회의장소</label>
													<input type="text" id="mtg_place" class="form-control  " name="mtg_place">
												</div>
											</div>
										</div>
										<div class="row"  >
											<div class="col-md-6"  >
												<div class="form-group">
													<label for="mtg_video_alt">화상회의여부</label>
														<div class="input-group"  >
															<div class="d-inline-block custom-control custom-radio mr-1" >
				                                                <input type="radio" name="mtg_video_alt_radio" class="custom-control-input" id="yes" value="y" checked="checked">
				                                                <label class="custom-control-label" for="yes">예</label>
				                                            </div>
				                                            <div class="d-inline-block custom-control custom-radio">
				                                                <input type="radio" name="mtg_video_alt_radio" class="custom-control-input" id="no" value="n">
				                                                <label class="custom-control-label" for="no">아니오</label>
				                                            </div>
				                                            <input type="hidden" name="mtg_video_alt" id="mtg_video_alt"/>
														</div>
												</div>
											</div>
											<div class="col-md-6"  >
													<div class="form-group">
													<label for="mtg_sanctn_id">결재선</label>
													<select id="mtg_sanctn_id" name="mtg_sanctn_id" class="form-control">
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
													<label style="margin-left: 3px;">회의 내용</label>
														<div class="form-group">
															<textarea name="mtg_cn" id="ckeditor" cols="30" rows="15" class="ckeditor">
															</textarea>
														</div>
													</div>
												</div>
											</div>
										</div>
										
			                        <div class="form-actions right">
				                        <button type="button" class="btn btn-warning mr-1"><i class="ft-x"></i> 취소</button>
										<button type="submit" class="btn btn-primary"><i class="fa fa-check-square-o"></i> 등록</button>
										<button type="button" id="btnMtgList" class="btn btn-danger btn-min-width mr-1 mb-1" style="float: left" value="목록"><i class="fa fa-eye">목록</i></button>
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