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
	CKEDITOR.instances.ckeditor.setData('${expndtrAnactInfo.expndtr_anact_cn}');
	
	CKEDITOR.instances.ckeditor.config.autoParagraph = false;
    CKEDITOR.instances.ckeditor.config.fillEmptyBlocks = false;
    CKEDITOR.instances.ckeditor.config.fullPage = false;
    CKEDITOR.instances.ckeditor.config.ignoreEmptyParagraph = true;
    CKEDITOR.instances.ckeditor.config.enterMode = CKEDITOR.ENTER_BR;
    
	$('#expndtr_anact_cn').val('${expndtrAnactInfo.expndtr_anact_cn}');
	
	$('#deleteFileName').click(function(){
//	 	   if(!authenticationChk()) return false; 
		   $.ajax({
			   url : '${pageContext.request.contextPath}/empl/dy_expndtr_anact/fileExistence.do',
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
				return true;
		   }); 
	   });
	
	
	$('select[name=expndtr_anact_sanctn_id]').val('${expndtrAnactInfo.expndtr_anact_sanctn_id}').attr('selected',true);
	$('select[name=expndtr_anact_papers_ty_id]').val('${expndtrAnactInfo.expndtr_anact_papers_ty_id}').attr('selected',true);
	
	$('#btnList').click(function(){
		location.href = '${pageContext.request.contextPath}/empl/dy_expndtr_anact/dy_expndtr_anactList.do?prjct_id=${prjct_id}';
	});
});
</script>
</head>
<body>
        <div class="content-body">
         <form action="${pageContext.request.contextPath }/empl/dy_expndtr_anact/updateExpndtrAnact.do?prjct_id=${prjct_id}&expndtr_anact_id=${expndtrAnactInfo.expndtr_anact_id }"
          class="form-horizontal" method="post" enctype="multipart/form-data">
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
						  			<input class="form-control col-md-5" style="margin-left: 400px; height: 28px" 
						  			type="text" id="expndtr_anact_nm" name="expndtr_anact_nm" value="${expndtrAnactInfo.expndtr_anact_nm }">
						  		</td>
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
						  		type="text" id="expndtr_anact_prjct_id" name="expndtr_anact_prjct_id" value="${expndtrAnactInfo.expndtr_anact_prjct_id }"></td>
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
						  		 type="text" id="expndtr_anact_amount" name="expndtr_anact_amount" value="${expndtrAnactInfo.expndtr_anact_amount }"> </b></td>
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
							<div class="form-group">
								<textarea name="expndtr_anact_cn" id="ckeditor" cols="30" rows="15" class="ckeditor">
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
				 <div style="margin-left: 30px">
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
						 	<button id="deleteFileName"></button>
				 		</div>
					 	<div id="ifDeleteFileName" class="form-group">
	                         		<label id="projectinput7" class="file center-block">
	                          	  	<input type="file" id="fileitem" name="fileitem">
	                         		</label>
	                      	</div>	
				 	</c:if>
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
					<button type="submit" class="btn btn-danger btn-lg my-1"><i class="fa fa-paper-plane-o"></i> 수정</button>
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