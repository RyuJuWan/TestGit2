<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#deleteFileName{
	width : 15px;
	height : 15px;
}
#ifDeleteFileName{
	display : none;
}
</style>
<script type="text/javascript">
$(function(){
	$('#mtg_id').val('${mtgInfo.mtg_id}');
	$('#mtg_nm').val('${mtgInfo.mtg_nm}');
	if('${mtgInfo.mtg_video_alt}' == 'y') {
		$('#yes').prop('checked', true);
	} else {
		$('#no').prop('checked', true);
	}
	
	CKEDITOR.instances.ckeditor.setData('${mtgInfo.mtg_cn}');
	CKEDITOR.instances.ckeditor.config.autoParagraph = false;
	CKEDITOR.instances.ckeditor.config.fillEmptyBlocks = false;
	CKEDITOR.instances.ckeditor.config.fullPage = false;
	CKEDITOR.instances.ckeditor.config.ignoreEmptyParagraph = true;
	CKEDITOR.instances.ckeditor.config.enterMode = CKEDITOR.ENTER_BR;
	
	$('#deleteFileName').click(function(){
		$.ajax({
			url : '${pageContext.request.contextPath}/empl/dy_mtg/fileExistence.do',
			type : 'POST',
			dataType : 'JSON',
			error : function(result){
				alert("State | " + result.message);
			},
			success : function(result){
				$('#ifDeleteFileName').attr("style", "display: block");
				$('#notEmptyFile').attr("style", "display: none");
			}
		});
		return false;
		$('#frmMtgView').submit(function(){
			if($('input[name="mtg_video_alt_radio"]').val() == 'yes'){
				$('#mtg_video_alt').val($('#yes').val());
			} else $('#mtg_video_alt').val($('#no').val());
		});
	});
	
	$('#btnMtgList').click(function(){
		location.href = '${pageContext.request.contextPath}/empl/dy_mtg/dy_mtgList.do?prjct_id=${prjct_id}';
	});
	
	$('#frmMtgView').submit(function(){
		if($('input[name="mtg_video_alt_radio"]').val() == 'yes'){
			$('#mtg_video_alt').val($('#yes').val());
		} else $('#mtg_video_alt').val($('#no').val());
	});
	
	$('#btnDeleteMtg').click(function(){
		var mtg_id = $('#mtg_id').val();
		location.href = '${pageContext.request.contextPath}/empl/dy_mtg/deleteMtg.do?prjct_id=${prjct_id}&mtg_id=' + mtg_id;
	});
});
</script>
</head>
<body>
     <div class="content-body">
    <form id="frmMtgView" class="form-horizontal" action="${pageContext.request.contextPath}/empl/dy_mtg/updateDy_mtg.do?prjct_id=${prjct_id}" method="post" enctype="multipart/form-data">
		<div style="width: 3150px" align="left">
			<section id="horizontal-form-layouts">
				<div class="col-md-6" >
					<div class="card">
						<div class="card-header">
							<h4 class="card-title" id="basic-layout-colored-form-control">회의록 조회</h4>
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
													<input type="hidden" id="mtg_id" name="mtg_id"/>
												</div>
											</div>
										<div class="row"  >
											<div class="col-md-6">
												<div class="form-group">
													<label>작성자 : ${emplInfo.empl_nm}</label>
												</div>
											</div>
											<div class="col-md-6"  >
													<div class="form-group">
													<label>회의일시 : ${mtgInfo.mtg_dt}</label>
												</div>
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
										</div>
										<div class="row">	
											<div class="col-md-6">
												<label>첨부파일</label>
												<c:if test="${empty mtgFileInfo}">
													<div class="form-group">
														<label class="file center-block">
															<input type="file" id="fileitem" name="fileitem" >
															<span class="file-custom"></span>
														</label>
													</div>
												</c:if>
												<c:if test="${not empty mtgFileInfo}">
													<div class="form-group" id="notEmptyFile">
														<label class="file center-block" onclick="javascript:location.href='${pageContext.request.contextPath}/empl/dy_mtg/fileDownload.do?mtg=${mtgFileInfo.mtg}';">
															${mtgFileInfo.mtg_file_nm}
														</label>
														<button id="deleteFileName"></button>
													</div>
													<div class="form-group" id="ifDeleteFileName">
														<label class="file center-block">
															<input type="file" id="fileitem" name="fileitem" >
															<span class="file-custom"></span>
														</label>
													</div>
												</c:if>
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
									
									<c:if test="${emplInfo.empl_id eq mtgInfo.mtg_empl}">
				                        <div class="form-actions right">
					                        <button type="button" id="btnDeleteMtg" class="btn btn-warning mr-1"><i class="ft-x"></i> 삭제</button>
											<button type="submit" class="btn btn-primary"><i class="fa fa-check-square-o"></i> 수정</button>
											<button type="button" id="btnMtgList" class="btn btn-danger btn-min-width mr-1 mb-1" style="float: left" value="목록"><i class="fa fa-eye">목록</i></button>
										</div>
									</c:if>	
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