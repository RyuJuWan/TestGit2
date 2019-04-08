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
	$('#btnList').click(function(){
		location.href = '${pageContext.request.contextPath}/empl/dy_expndtr_anact/dy_expndtr_anactList.do?prjct_id=${prjct_id}';
	});
	
	$('#form').submit(function(){
		return true;
	})
	
});
</script>
</head>
<body>
        <div class="content-body">
         <form id="form" 
         action="${pageContext.request.contextPath }/empl/dy_expndtr_anact/insertExpndtrAnact.do?prjct_id=${prjct_id}" 
         class="form-horizontal" 
         method="post"
         enctype="multipart/form-data">
        <section class="card">
	<div id="invoice-template" class="card-body">
		<div id="invoice-company-details" class="row">
			<div class="col-md-6 col-sm-12 text-center text-md-left">
				<div class="media">
					<img src="../../../app-assets/images/logo/logo-80x80.png" alt="company logo" class=""/>
					<div class="col-md-6 col-sm-12 text-center text-md-left" style="margin-top: 30px">
						<h2>지출결의서</h2>
					</div>
				</div>
			</div>
		</div>
		<div id="invoice-items-details" class="pt-2">
			<div class="row">
				<div class="col-md-7 col-sm-12" style="margin-left: 300px">
					<p class="lead">지출결의서</p>
					<div class="table-responsive">
						<table class="table" style="font-size: 16px; ">
						  <tbody>
						  	<tr>
						  		<td>지출결의서 명</td>
						  		<td class="text-right">
						  		<input class="form-control col-md-5" style="margin-left: 400px; height: 28px" type="text" id="expndtr_anact_nm" name="expndtr_anact_nm"></td>
						  	</tr>
						  	<tr>
						  		<td>작성자 :</td>
						  		<td class="text-right">
						  		<input type="hidden" name="expndtr_anact_wrter" value="${LOGIN_EMPLINFO.empl_id}">
						  		<input class="form-control col-md-5" disabled="disabled" style="margin-left: 400px; height: 28px" 
						  		type="text" id="expndtr_anact_wrter" name="expndtr_anact_wrter " value="${LOGIN_EMPLINFO.empl_id}"></td>
						  	</tr>
						  	<tr>
						  		<td class="text-bold-800">프로젝트명:</td>
						  		<td class="text-bold-800 text-right"> 
						  		<input class="form-control col-md-5" style="margin-left: 400px; height: 28px" 
						  		type="text" id="expndtr_anact_prjct_id" name="expndtr_anact_prjct_id" value="${prjct_id }"></td>
						  	</tr>
						  	<tr>
						  		<td>작성일자:</td>
						  		<td class="pink text-right">
							  		<input class="form-control col-md-5" disabled="disabled" style="margin-left: 400px; height: 28px"
							  		 type="text" id="expndtr_anact_date" name="expndtr_anact_date" value="${today }">
						  		</td>
						  	</tr>
						  	<tr class="bg-grey bg-lighten-4">
						  		<td class="text-bold-800">금액</td>
						  		<td class="text-bold-800 text-right">
						  		<b><input class="form-control col-md-5"  style="margin-left: 400px; height: 28px"
						  		 type="text" id="expndtr_anact_amount" name="expndtr_anact_amount"> </b></td>
						  	</tr>
						  </tbody>
						</table>
					</div>
				</div>
				
			</div>
			
			<div class="row" >
				<div class="form-group">
					<div class="card-content collapse show">
						<div class="card-body" style="margin-left: 300px; ">
						<label for="projectinput8" style="margin-left: 3px; ">내용</label>
							<div class="form-group" style="padding-right: 350px">
								<textarea name="expndtr_anact_cn" id="expndtr_anact_cn" cols="30" rows="15" class="ckeditor">
								</textarea>
							</div>
						</div>
					</div>
				</div>
				<div class="" style="margin-left: 310px; margin-top: 10px">
					<table class="table"  style="font-size: 16px;" >
					  <thead >
					    <tr>
					      <th width="450" class="text-left">결재선ID</th>
					      <th width="450" class="text-left">결재서류유형ID</th>
					    </tr>
					  </thead>
					  <tbody>
					    <tr>
					      <td class="text-right">
						      <select class="form-control" name="expndtr_anact_sanctn_id" style=" height: 35px">
		           	                <option>결재선유형</option>
									<c:forEach items="${sanctnlineList }" var="sanctnline">
			        	                   <option value="${sanctnline.sanctn_line_id }">${sanctnline.sanctn_line_nm }</option>
									</c:forEach>
		                       </select>
	                        </td>
					      <td class="text-right">
				      		<select class="form-control" name="expndtr_anact_papers_ty_id" style=" height: 35px" >
            	               <option>결재서류유형</option>
		            	         <c:forEach items="${sanctnpaperstyList }" var="sanctnpapersty">   
		        	                   <option value="${sanctnpapersty.sanctn_papers_ty_id }">${sanctnpapersty.sanctn_papers_ty_nm }</option>
								</c:forEach>
		                    </select>
						</td>
					    </tr>
					  </tbody>
					</table>
					<div class="form-group" style="margin-left: 30px">
						<label>Select File</label>
						<label id="projectinput7" class="file center-block">
							<input type="file"  id="fileitem" name="fileitem" >
							<span class="file-custom"></span>
						</label>
					</div>
					
        			
				</div>
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
					<button type="button" id="btnList" class="btn btn-primary btn-lg my-1" style="margin-right: 10px;" ><i class="fa fa-eye"></i> 목록</button>
					<button type="submit"  class="btn btn-danger btn-lg my-1"><i class="fa fa-paper-plane-o"></i> 등록</button>
				</div>
			</div>
		</div>
		<!--/ Invoice Footer -->

	</div>
</section>
</form>
        </div>
</body>
</html>