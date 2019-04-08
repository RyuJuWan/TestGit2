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
 	width: 15px;
 	height: 15px;
 }
 #ifDeleteFileName{
 	display: none;
 }
</style>

<script type="text/javascript">
$(function(){
	$('#btnList').click(function(){
		location.href = '${pageContext.request.contextPath}/empl/dy_expndtr_anact/dy_expndtr_anactList.do?prjct_id=${prjct_id}';
	});
	
	$('#btnModity').click(function(){
		location.href = '${pageContext.request.contextPath}/empl/dy_expndtr_anact/dy_expndtr_anactUpdate.do?prjct_id=${prjct_id}&expndtr_anact_id='+${expndtrAnactInfo.expndtr_anact_id};
	});
	
	$('#btnDelete').click(function(){
		location.href = '${pageContext.request.contextPath}/empl/dy_expndtr_anact/deleteExpndtrAnact.do?prjct_id=${prjct_id}&expndtr_anact_id='+${expndtrAnactInfo.expndtr_anact_id};
	});
});
</script>
</head>
<body>
        <div class="content-body"><section class="card">
	<div id="invoice-template" class="card-body">
		<!-- Invoice Company Details -->
		<div id="invoice-company-details" class="row">
			<div class="col-md-6 col-sm-12 text-center text-md-left">
				<div class="media">
					<img src="../../../app-assets/images/logo/logo-80x80.png" alt="company logo" class=""/>
			<div class="col-md-6 col-sm-12 text-center text-md-left" style="margin-top: 10px">
				<h2>지출결의서</h2>
				<p class="pb-3"># ${expndtrAnactInfo.expndtr_anact_nm }</p>
			</div>
				</div>
			</div>
		</div>
		<div id="invoice-items-details" class="pt-2">
			<div class="row">
				<div class="col-md-7 col-sm-12" style="margin-left: 300px">
					<p class="lead">지출결의서</p>
					<div class="table-responsive">
						<table class="table" style="font-size: 16px;">
						  <tbody>
						  	<tr>
						  		<td>지출결의서 명</td>
						  		<td class="text-right">${expndtrAnactInfo.expndtr_anact_nm }</td>
						  	</tr>
						  	<tr>
						  		<td>작성자 :</td>
						  		<td class="text-right">${expndtrAnactInfo.expndtr_anact_wrter }</td>
						  	</tr>
						  	<tr>
						  		<td class="text-bold-800">프로젝트명:</td>
						  		<td class="text-bold-800 text-right"> ${expndtrAnactInfo.expndtr_anact_prjct_id }</td>
						  	</tr>
						  	<tr>
						  		<td>작성일자:</td>
						  		<td class="pink text-right">${expndtrAnactInfo.expndtr_anact_date }</td>
						  	</tr>
						  	<tr class="bg-grey bg-lighten-4">
						  		<td class="text-bold-800">금액</td>
						  		<td class="text-bold-800 text-right"><b>$ ${expndtrAnactInfo.expndtr_anact_amount }</b></td>
						  	</tr>
						  </tbody>
						</table>
					</div>
				</div>
				
			</div>
			<div class="row">
				<div class="" style="margin-left: 310px; margin-top: 10px">
					<table class="table"  style="font-size: 16px;  max-width:900px; height: auto;" >
					  <thead >
					    <tr>
					      <th>#</th>
					      <th width="540">내용</th>
					      <th class="text-right">결재선ID</th>
					      <th class="text-right">결재서류유형ID</th>
					    </tr>
					  </thead>
					  <tbody>
					    <tr>
					      <th scope="row"> </th>
					      <td>${expndtrAnactInfo.expndtr_anact_cn }</td>
					      <td class="text-right">${expndtrAnactInfo.expndtr_anact_sanctn_id }</td>
					      <td class="text-right">${expndtrAnactInfo.expndtr_anact_papers_ty_id }</td>
					    </tr>
					  </tbody>
					</table>
				</div>
				
			</div>
				 <div style="margin-left: 300px">
				<h4 class="form-section" ><i class="fa fa-paperclip"></i> 자료 파일</h4>
				 	<c:if test="${empty expFileInfo}">
                       	<div class="form-group">
                          		<label id="projectinput7" class="file center-block">
                           	  	<input type="file" id="fileitem" name="fileitem">
                          		</label>
                       	</div>					 	
				 	</c:if>
				 	<c:if test="${!empty expFileInfo}">
				 		<div id="emptyFile">
	                        <label id="exp_id" onclick="javascript:location.href='${pageContext.request.contextPath}/empl/dy_expndtr_anact/fileDownload.do?exp=${expFileInfo.getExpndtr_anact()}';">
	                        	${expFileInfo.getExpndtr_anact_file_nm()}
	                        </label>
				 		</div>
				 	</c:if>
				 </div>
		</div>

		<!-- Invoice Footer -->
		<div id="invoice-footer">
			<div class="col-md-7 col-sm-12" style="margin-left: 300px">
					<h6>Terms & Condition</h6>
					<p>You know, being a test pilot isn't always the healthiest business in the world. We predict too much for the next year and yet far too little for the next 10.</p>
			</div>
			<div class="row">
				<div class="col-md-5 col-sm-12 text-center" style="margin-left: 800px">
					<div class="text-center" align="right">
						<p>Authorized person</p>
						<img src="../../../app-assets/images/pages/signature-scan.png" alt="signature" class="height-100"/>
						<h6>Amanda Orton</h6>
						<p class="text-muted">Managing Director</p>
					</div>
					 <div class="form-actions" >
						<button type="button" id="btnList" class="btn btn-primary btn-lg my-1" style="margin-right: 10px;"  ><i class="fa fa-eye"></i> 목록</button>
						<button type="button" id="btnDelete" class="btn btn-warning btn-lg my-1"><i class="ft-x"></i> 삭제</button>
						<button type="button" id="btnModity"  class="btn btn-danger btn-lg my-1"><i class="fa fa-paper-plane-o"></i> 수정</button>
					</div>
			</div>
		</div>
		<!--/ Invoice Footer -->

	</div>
</section>
        </div>
      </div>
</body>
</html>