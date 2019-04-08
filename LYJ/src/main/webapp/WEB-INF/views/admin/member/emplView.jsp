<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$('#empl_nm').val('${emplInfo.empl_nm}');
	if('${emplInfo.empl_sexdstn}' == 'm') $('#male').prop('checked', true);
	else $('#female').prop('checked', true);
	$('#empl_hp').val('${emplInfo.empl_hp}');
	$('#empl_mail').val('${emplInfo.empl_mail}');
	$('#empl_zip').val('${emplInfo.empl_zip}');
	$('#empl_add1').val('${emplInfo.empl_add1}');
	$('#empl_add2').val('${emplInfo.empl_add2}');
	$('#empl_dept').val('${emplInfo.empl_dept}');
	$('#empl_ofcps').val('${emplInfo.empl_ofcps}');
	$('#empl_level').val('${emplInfo.empl_level}');
	$('#empl_bir').val('${emplInfo.empl_bir}');
	$('#empl_ecny').val('${emplInfo.empl_ecny}');
	
	$('#prjct_hist_nm1').show();
	$('#prjct_hist_nm2').hide();
	
	$('#btnFindZip').click(function(){
		new daum.Postcode({
			oncomplete: function(data) {
				var fullAddr = '';
				var extraAddr = '';
				
				if (data.userSelectedType === 'R') {
					fullAddr = data.roadAddress;
				} else {
					fullAddr = data.jibunAddress;
				}
				
				if(data.userSelectedType === 'R'){
	                if(data.bname !== ''){
	                    extraAddr += data.bname;
	                }
	                if(data.buildingName !== ''){
	                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
	                fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
	            }
				
				$('#empl_zip').val(data.zonecode);
				$('#empl_add1').val(fullAddr);
				$('#empl_add2').focus();
			}
		}).open();
	});
	
	$('#btnUpdateEmpl').click(function(){
		if($('input[name=empl_sexdstn_radio]:checked').val() == 'male'){
			$('#frmEmplView').append('<input type="hidden" name="empl_sexdstn" value="m">');
		} else if($('input[name=empl_sexdstn_radio]:checked').val() == 'female'){
			$('#frmEmplView').append('<input type="hidden" name="empl_sexdstn" value="f">');
		}
		
		$('#frmEmplView').append('<input type="hidden" name="empl_id" value="${emplInfo.empl_id}">');
		
		$('#frmEmplView').attr('action', '${pageContext.request.contextPath}/admin/member/updateEmpl.do');
		$('#frmEmplView').submit();
	});
	
	$('input[name=companyRadio]').change(function(){
		$('#prjct_hist_nm1').val('');
		$('#prjct_hist_nm2').val('');
		
		if($('input[name=companyRadio]:checked').val() == 'ourCompany') {
			$('#prjct_hist_nm1').show();
			$('#prjct_hist_nm2').hide();
		} else if($('input[name=companyRadio]:checked').val() == 'otherCompany') {
			$('#prjct_hist_nm1').hide();
			$('#prjct_hist_nm2').show();
		}
	});
	
	$('#btnInsertPrjctHist').click(function(){
		var prjct_hist_inpt = $('#prjct_hist_inpt').val();
		var prjct_hist_clos = $('#prjct_hist_clos').val();
		var prjct_hist_role = $('#prjct_hist_role').val();
		var prjct_hist_pblanc = $('#prjct_hist_pblanc').val();
		var prjct_hist_dmand = $('#prjct_hist_dmand').val();
		
		$frmPrjctHist = $('<form action="${pageContext.request.contextPath}/admin/member/insertPrjctHist.do" method="post"/>');
		
		if($('input[name="companyRadio"]:checked').val() == 'ourCompany'){
			var prjct_hist_arr = $('#prjct_hist_nm1').val().split("+");
			var prjct_hist_prjct = prjct_hist_arr[0];
			var prjct_hist_nm = prjct_hist_arr[1];
			
			$frmPrjctHist.append('<input type="hidden" name="prjct_hist_prjct" value="' + prjct_hist_prjct +'">');
			$frmPrjctHist.append('<input type="hidden" name="prjct_hist_nm" value="' + prjct_hist_nm +'">');
		} else if($('input[name="companyRadio"]:checked').val() == 'otherCompany') {
			var prjct_hist_nm = $('#prjct_hist_nm2').val();
			
			$frmPrjctHist.append('<input type="hidden" name="prjct_hist_nm" value="' + prjct_hist_nm +'">');
		}
		
		$frmPrjctHist.append('<input type="hidden" name="prjct_hist_empl" value="${emplInfo.empl_id}">');
		$frmPrjctHist.append('<input type="hidden" name="prjct_hist_inpt" value="' + prjct_hist_inpt +'">');
		$frmPrjctHist.append('<input type="hidden" name="prjct_hist_clos" value="' + prjct_hist_clos +'">');
		$frmPrjctHist.append('<input type="hidden" name="prjct_hist_role" value="' + prjct_hist_role +'">');
		$frmPrjctHist.append('<input type="hidden" name="prjct_hist_pblanc" value="' + prjct_hist_pblanc +'">');
		$frmPrjctHist.append('<input type="hidden" name="prjct_hist_dmand" value="' + prjct_hist_dmand +'">');
		
		$(document.body).append($frmPrjctHist);
		$frmPrjctHist.submit();
	});
	
	$('#iconForm1').on('hidden.bs.modal', function(){
		$('#prjct_hist_nm1').val('');
		$('#prjct_hist_nm2').val('');
		$('#companyRadio1').prop('checked', true);
		$('#prjct_hist_nm1').show();
		$('#prjct_hist_nm2').hide();
		$('#prjct_hist_inpt').val('');
		$('#prjct_hist_clos').val('');
		$('#prjct_hist_role').val('');
		$('#prjct_hist_pblanc').val('');
		$('#prjct_hist_dmand').val('');
	});
	
	$('#tblPrjctHist tr:gt(0)').click(function(){
		$.ajax({
			type : 'POST',
			dataType : 'JSON',
			data : {prjct_hist_id : $(this).find('td:eq(0) input').val()},
			url : '${pageContext.request.contextPath}/admin/member/prjctHistView.do',
			error : function(result){
				alert('프로젝트이력조회 실패');
			},
			success : function(result){
				$('#iconForm3').modal("show");
				$('#prjct_hist_id3').val(result.prjctHistInfo.prjct_hist_id);
				$('#prjct_hist_nm3').val(result.prjctHistInfo.prjct_hist_nm);
				$('#prjct_hist_inpt3').val(result.prjctHistInfo.prjct_hist_inpt);
				$('#prjct_hist_clos3').val(result.prjctHistInfo.prjct_hist_clos);
				$('#prjct_hist_role3').val(result.prjctHistInfo.prjct_hist_role);
				$('#prjct_hist_pblanc3').val(result.prjctHistInfo.prjct_hist_pblanc);
				$('#prjct_hist_dmand3').val(result.prjctHistInfo.prjct_hist_dmand);
			}
		});
	});
	
	$('#btnDeletePrjctHist').click(function(){
		var prjct_hist_id = $('#prjct_hist_id3').val();
		location.href = "${pageContext.request.contextPath}/admin/member/deletePrjctHist.do?prjct_hist_id=" + prjct_hist_id + "&empl_id=${emplInfo.empl_id}";
	});
	
	$('#btnInsertCrqfcHold').click(function(){
		var crqfc_hold_crqfc = $('#crqfc_nm').val();
		location.href = "${pageContext.request.contextPath}/admin/member/insertCrqfcHold.do?crqfc_hold_crqfc=" + crqfc_hold_crqfc + "&empl_id=${emplInfo.empl_id}";
	});
	
	$('#iconForm2').on('hidden.bs.modal', function(){
		$('#crqfc_nm').val('');
	});

	$('#tblCrqfcHold tr:gt(0)').click(function(){
		var crqfc_hold_empl = $(this).find('td:eq(0) input').val().split('/')[0];
		var crqfc_hold_crqfc = $(this).find('td:eq(0) input').val().split('/')[1];
		var crqfc_nm = $(this).find('td:eq(1) input').val();
		$('#iconForm4').modal('show');
		$('#crqfc_hold_empl2').val(crqfc_hold_empl);
		$('#crqfc_hold_crqfc2').val(crqfc_hold_crqfc);
		$('#crqfc_nm2').val(crqfc_nm);		
	});
	
	$('#btnDeleteCrqfcHold').click(function(){
		var crqfc_hold_empl = $('#crqfc_hold_empl2').val();
		var crqfc_hold_crqfc = $('#crqfc_hold_crqfc2').val();
		location.href = "${pageContext.request.contextPath}/admin/member/deleteCrqfcHold.do?crqfc_hold_empl=" + crqfc_hold_empl + "&crqfc_hold_crqfc=" + crqfc_hold_crqfc;
	});
});
</script>
</head>
<body>

<div class="content-body">
	<div id="user-profile">
	 <div class="row">
	        <div class="col-12">
	            <div class="card profile-with-cover">
	                <div class="card-img-top img-fluid bg-cover height-300" style="background: url('../../../app-assets/images/carousel/22.jpg') 50%;"></div>
	                <div class="media profil-cover-details w-100">
	                    <div class="media-left pl-2 pt-2">
	                        <a href="#" class="profile-image">
	                            <img src="../../../app-assets/images/portrait/small/avatar-s-8.png" class="rounded-circle img-border height-100" alt="Card image">
	                        </a>
	                    </div>
	                    <div class="media-body pt-3 px-2">
	                        <div class="row">
	                            <div class="col">
	                              <h3 class="card-title">Jose Diaz</h3>
	                            </div>
	                            <div class="col text-right">
	                              <button type="button" class="btn btn-primary d-"><i class="fa fa-plus"></i> Follow</button>
	                                <div class="btn-group d-none d-md-block float-right ml-2" role="group" aria-label="Basic example">
	                                    <button type="button" class="btn btn-success"><i class="fa fa-dashcube"></i> Message</button>
	                                    <button type="button" class="btn btn-success"><i class="fa fa-cog"></i></button>
	                                </div>
	                            </div>
	                          </div>
	                    </div>
	                </div>
	                <nav class="navbar navbar-light navbar-profile align-self-end">
	                    <button class="navbar-toggler d-sm-none" type="button" data-toggle="collapse" aria-expanded="false" aria-label="Toggle navigation"></button>
	                    <nav class="navbar navbar-expand-lg">
	                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
	                            <ul class="navbar-nav mr-auto">
	                                <li class="nav-item active">
	                                    <a class="nav-link" href="#"><i class="fa fa-line-chart"></i> Timeline <span class="sr-only">(current)</span></a>
	                                </li>
	                                <li class="nav-item">
	                                    <a class="nav-link" href="#"><i class="fa fa-user"></i> Profile</a>
	                                </li>
	                                <li class="nav-item">
	                                    <a class="nav-link" href="#"><i class="fa fa-briefcase"></i> Projects</a>
	                                </li>
	                                <li class="nav-item">
	                                    <a class="nav-link" href="#"><i class="fa fa-heart-o"></i> Favourites</a>
	                                </li>
	                                <li class="nav-item">
	                                    <a class="nav-link" href="#"><i class="fa fa-bell-o"></i> Notifications</a>
	                                </li>
	                            </ul>
	                        </div>
	                    </nav>
	                </nav>
	            </div>
	        </div>
	      </div>
      </div>
    <form id="frmEmplView" class="form-horizontal" method="post">
		<div  style="width: 3150px" align="left"><!-- Basic CKEditor start -->
			<section id="horizontal-form-layouts">
				 <div class="col-md-6" >
							<div class="card">
								<div class="card-header">
									<h4 class="card-title" id="basic-layout-colored-form-control">User Profile</h4>
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
												<h4 class="form-section"><i class="fa fa-eye"></i> About User</h4>
												<div class="row">
													<div class="col-md-6" >
															<div class="form-group">
															<label for="empl_nm">이름</label>
															<input class="form-control  " type="text" id="empl_nm" name="empl_nm">
														</div>
													</div>
													<div class="col-md-6"  >
														<div class="form-group" >
															<label>성별</label>
															<div class="input-group"  >
																<div class="d-inline-block custom-control custom-radio mr-1" >
				                                                    <input type="radio" name="empl_sexdstn_radio" class="custom-control-input" id="male" value="male">
				                                                    <label class="custom-control-label" for="male">남자</label>
				                                                </div>
				                                                <div class="d-inline-block custom-control custom-radio">
				                                                    <input type="radio" name="empl_sexdstn_radio" class="custom-control-input" id="female" value="female">
				                                                    <label class="custom-control-label" for="female">여자</label>
				                                                </div>
															</div>
														</div>
													</div>
													<div class="col-md-6" >
															<div class="form-group">
															<label for="empl_pass">비밀번호</label>
															<input class="form-control  " type="password" id="empl_pass" name="empl_pass">
														</div>
													</div>
													<div class="col-md-6" >
															<div class="form-group">
															<label for="empl_pass_chk">비밀번호 확인</label>
															<input class="form-control  " type="password" id="empl_pass_chk" name="empl_pass_chk">
														</div>
													</div>
													<div class="col-md-6" >
															<div class="form-group">
															<label for="empl_hp">전화번호</label>
															<input class="form-control  " type="text" id="empl_hp" name="empl_hp">
														</div>
													</div>
													<div class="col-md-6" >
															<div class="form-group">
															<label for="empl_mail">이메일</label>
															<input class="form-control  " type="text" id="empl_mail" name="empl_mail">
														</div>
													</div>
												</div>	
												<div class="row">	
													<div class="col-md-6" >
														<div class="form-group">
															<label for="empl_zip">우편번호</label>
															<input class="form-control  " type="text" id="empl_zip" name="empl_zip" >
															<button type="button" id="btnFindZip" class="btn btn-danger btn-min-width mr-1 mb-1" value="우편번호찾기" style="  margin-top: 12px; width: 100px;height: 40px " >우편번호 찾기</button>
														</div>
													</div>
												</div>
												<div class="row">	
													<div class="col-md-6" >
															<div class="form-group">
															<label for="empl_add1">주소</label>
															<input class="form-control  " type="text" id="empl_add1" name="empl_add1">
														</div>
													</div>
													<div class="col-md-6" >
															<div class="form-group">
															<label for="empl_add2">상세주소</label>
															<input class="form-control  " type="text" id="empl_add2" name="empl_add2">
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group">
															<label for="empl_dept">부서</label>
															<select id="empl_dept" name="empl_dept" class="form-control">
																<c:forEach var="dept" items="${deptList}">
																	<option value="${dept.dept_id}">
																		<c:out value="${dept.dept_nm}"></c:out>
																	</option>
																</c:forEach>
															</select>
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group">
															<label for="empl_ofcps">직위</label>
															<select id="empl_ofcps" name="empl_ofcps" class="form-control">
																<c:forEach var="ofcps" items="${ofcpsList}">
																	<option value="${ofcps.ofcps_id}">
																		<c:out value="${ofcps.ofcps_nm}"></c:out>
																	</option>
																</c:forEach>
															</select>
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group">
															<label for="empl_level">기술등급</label>
															<select id="empl_level" name="empl_level" class="form-control">
																<c:forEach var="techClass" items="${techClassList}">
																	<option value="${techClass.tech_class_id}">
																		<c:out value="${techClass.tech_class_nm}"></c:out>
																	</option>
																</c:forEach>
															</select>
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group">
															<label for="empl_bir">생년월일</label>
															<input type="date" id="empl_bir" class="form-control  " name="empl_bir">
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group">
															<label for="empl_ecny">입사일</label>
															<input type="date" id="empl_ecny" class="form-control " name="empl_ecny">
														</div>
													</div>
													
												</div>
												<div class="form-actions right" >
														<button type="button" class="btn btn-primary" id="btnUpdateEmpl">
															<i class="fa fa-check-square-o"></i> 수정
														</button>
													</div>
				
												<h4 class="form-section"><i class="ft-mail"></i> Contact Info & Bio</h4>
												<div class="form-group">
												<label for="tblPrjctHist">프로젝트 이력</label>
												<table class="table table-striped table-bordered zero-configuration" id="tblPrjctHist" style="margin: 5px 30px 10px 0px" >
							                            <thead>
							                                <tr>
							                                	<th>번호</th>
							                                    <th>프로젝트명</th>
							                                    <th>투입일</th>
							                                    <th>마감일</th>
							                                    <th>역할</th>
							                                </tr>
							                            </thead>
							                            <tbody>
							                                <c:forEach items="${prjctHistPageList}" var="prjctHistPageInfo">
							                                	<tr>
							                                		<td>
							                                			<input type="hidden" value="${prjctHistPageInfo.prjct_hist_id}"/>${prjctHistPageInfo.rnum}
							                                		</td>
							                                		<td>
							                                			<c:set var="flag" value="false"></c:set>
							                                			<c:forEach items="${prjctList}" var="prjctInfo">
							                                				<c:if test="${prjctInfo.prjct_id eq prjctHistPageInfo.prjct_hist_prjct}">
							                                					${prjctInfo.prjct_nm}
							                                					<c:set var="flag" value="true"></c:set>
							                                				</c:if>
							                                			</c:forEach>
							                                			<c:if test="${not flag}">
							                                				${prjctHistPageInfo.prjct_hist_nm}
							                                			</c:if>
							                                		</td>
							                                		<td>
							                                			${prjctHistPageInfo.prjct_hist_inpt}
							                                		</td>
							                                		<td>
							                                			${prjctHistPageInfo.prjct_hist_clos}
							                                		</td>
							                                		<td>
							                                			<c:forEach items="${roleList}" var="roleInfo">
							                                				<c:if test="${roleInfo.role_id eq prjctHistPageInfo.prjct_hist_role}">
							                                					${roleInfo.role_nm}
							                                				</c:if>
							                                			</c:forEach>
							                                		</td>
							                                	</tr>
							                                </c:forEach>
							                            </tbody>
							                        </table>
							                        ${prjctHistPagingUtil}
							                        
							                        <div class="form-actions right">
								                        <button type="button" class="btn btn-warning mr-1" data-toggle="modal" href="#iconForm1">
															<i class="fa fa-check-square-o"></i> 등록
														</button>
													</div>
							                        
							                        <div class="form-group">
													<label for="tblCrqfcHold">보유 자격증</label>
													<table class="table table-striped table-bordered zero-configuration" id="tblCrqfcHold" style="margin: 5px 30px 10px 0px" >
							                            <thead>
							                                <tr>
							                                	<th>번호</th>
							                                    <th>자격증명</th>
							                                </tr>
							                            </thead>
							                            <tbody id="hello">
							                            	<c:forEach items="${crqfcHoldPageList}" var="crqfcHoldPageInfo">
							                            		<tr>
							                            			<td>
							                            				<input type="hidden" value="${crqfcHoldPageInfo.crqfc_hold_empl}/${crqfcHoldPageInfo.crqfc_hold_crqfc}"/>${crqfcHoldPageInfo.rnum}
							                            			</td>
							                            			<td>
							                            				<c:forEach items="${crqfcList}" var="crqfcInfo">
							                            					<c:if test="${crqfcInfo.crqfc_id eq crqfcHoldPageInfo.crqfc_hold_crqfc}">
							                            						<input type="hidden" value="${crqfcInfo.crqfc_nm}"/>${crqfcInfo.crqfc_nm} 
							                            					</c:if>
							                            				</c:forEach>
							                            			</td>
							                            		</tr>
							                            	</c:forEach>
							                            </tbody>
							                        </table>
							                        ${crqfcPagingUtil}
								
							                        <div class="form-actions right">
								                        <button type="button" class="btn btn-warning mr-1" data-toggle="modal" href="#iconForm2">
															<i class="fa fa-check-square-o"></i> 등록
														</button>
													</div>
													
							                        </div>
							                        </div>
							                        </form>
							                        </div>
							                        </div>
							                        </div>
							                        </div>
							                        </section>
							                        </div>
							                        
							                        
													<div class="form-group">
														<div class="modal fade text-left " id="iconForm1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel34" aria-hidden="true">
														  <div class="modal-dialog " role="document">
															<div class="modal-content ">
															  <div class="modal-header bg-blue-grey bg-lighten-3 ">
																<h3 class="modal-title " id="myModalLabel34">프로젝트 이력 등록</h3>
																<button type="button" class="close" data-dismiss="modal" aria-label="Close">
																  <span aria-hidden="true">&times;</span>
																</button>
															  </div>
															  <form id="frmPrjctHist" method="post">
																<div class="modal-body">
																	<div align="center">
													                    <fieldset >
															              <div class="custom-control custom-radio">
															                <input type="radio" class="custom-control-input" name="companyRadio" id="companyRadio1" value="ourCompany" checked>
															                <label class="custom-control-label" for="companyRadio1">자 회사</label>
															              </div>
															            </fieldset>
															            <fieldset>
															              <div class="custom-control custom-radio">
															                <input type="radio" class="custom-control-input" name="companyRadio" id="companyRadio2" value="otherCompany">
															                <label class="custom-control-label" for="companyRadio2">타 회사</label>
															              </div>
															            </fieldset>
														            </div>
																	<div class="form-group position-relative has-icon-left" id="div">
																		<label for="prjct_hist_nm1">프로젝트명</label>
																		<select id="prjct_hist_nm1" name="prjct_hist_nm1" class="form-control">
																			<c:forEach var="prjctInfo" items="${prjctList}">
																				<c:set var="flag" value="false"></c:set>
																				<c:forEach var="prjctHistInfo" items="${prjctHistList}">
																					<c:if test="${not flag}">
																						<c:if test="${prjctInfo.prjct_id eq prjctHistInfo.prjct_hist_prjct}">
																							<c:set var="flag" value="true"></c:set>
																						</c:if>
																					</c:if>
																				</c:forEach>
																				<c:if test="${not flag}">
																					<option value="${prjctInfo.prjct_id}+${prjctInfo.prjct_nm}">
																						<c:out value="${prjctInfo.prjct_nm}"></c:out>
																					</option>
																				</c:if>
																			</c:forEach>
																		</select>
																		
																		<input type="text" placeholder="Project Name" class="form-control" id="prjct_hist_nm2" name="prjct_hist_nm2">
																	</div>
																	<div class="form-group position-relative has-icon-left">
																		<label for="prjct_hist_inpt">프로젝트 투입일</label>
																		<input type="date" id="prjct_hist_inpt" class="form-control  " name="prjct_hist_inpt">
																	</div>
																	<div class="form-group position-relative has-icon-left">
																		<label for="prjct_hist_inpt">프로젝트 마감일</label>
																		<input type="date" id="prjct_hist_clos" class="form-control  " name="prjct_hist_clos">
																	</div>
																	<div class="form-group position-relative has-icon-left">
																		<label for="prjct_hist_role">역할</label>
																		<select id="prjct_hist_role" name="prjct_hist_role" class="form-control">
																			<c:forEach var="roleInfo" items="${roleList}">
																				<option value="${roleInfo.role_id}">
																					<c:out value="${roleInfo.role_nm}"></c:out>
																				</option>
																			</c:forEach>
																		</select>
																	</div>
																	<div class="form-group position-relative has-icon-left">
																		<label for="prjct_hist_pblanc">공고기관</label>
																		<input type="text" placeholder="Public Institution" class="form-control" id="prjct_hist_pblanc" name="prjct_hist_pblanc">
																		<div class="form-control-position">
																			<i class="fa fa-envelope font-medium-5 line-height-1 text-muted icon-align"></i>
																		</div>
																	</div>
																	<div class="form-group position-relative has-icon-left">
																		<label for="prjct_hist_dmand">수요기관</label>
																		<input type="text" placeholder="Demand Institution" class="form-control" id="prjct_hist_dmand" name="prjct_hist_dmand">
																		<div class="form-control-position">
																			<i class="fa fa-envelope font-medium-5 line-height-1 text-muted icon-align"></i>
																		</div>
																	</div>
																</div>
																<div class="modal-footer">
																	<input type="reset" class="btn btn-outline-secondary btn-lg" data-dismiss="modal" value="닫기">
																	<input type="button" class="btn btn-outline-primary btn-lg" id="btnInsertPrjctHist" value="등록">
																</div>
															  </form>
															</div>
														  </div>
														</div>
													</div>
													
													
													<div class="form-group">
														<div class="modal fade text-left " id="iconForm3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel34" aria-hidden="true">
														  <div class="modal-dialog " role="document">
															<div class="modal-content ">
															  <div class="modal-header bg-blue-grey bg-lighten-3 ">
																<h3 class="modal-title " id="myModalLabel34">프로젝트 이력 조회</h3>
																<button type="button" class="close" data-dismiss="modal" aria-label="Close">
																  <span aria-hidden="true">&times;</span>
																</button>
															  </div>
															  <form id="frmPrjctHist" method="post">
																<div class="modal-body">
																	<input type="hidden" id="prjct_hist_id3" name="prjct_hist_id3"/>
																	<input type="text" class="form-control" id="prjct_hist_nm3" name="prjct_hist_nm3">
																	<div class="form-group position-relative has-icon-left">
																		<label for="prjct_hist_inpt3">프로젝트 투입일</label>
																		<input type="date" id="prjct_hist_inpt3" class="form-control  " name="prjct_hist_inpt3">
																	</div>
																	<div class="form-group position-relative has-icon-left">
																		<label for="prjct_hist_inpt3">프로젝트 마감일</label>
																		<input type="date" id="prjct_hist_clos3" class="form-control  " name="prjct_hist_clos3">
																	</div>
																	<div class="form-group position-relative has-icon-left">
																		<label for="prjct_hist_role3">역할</label>
																		<select id="prjct_hist_role3" name="prjct_hist_role3" class="form-control">
																			<c:forEach var="roleInfo" items="${roleList}">
																				<option value="${roleInfo.role_id}">
																					<c:out value="${roleInfo.role_nm}"></c:out>
																				</option>
																			</c:forEach>
																		</select>
																	</div>
																	<div class="form-group position-relative has-icon-left">
																		<label for="prjct_hist_pblanc3">공고기관</label>
																		<input type="text" class="form-control" id="prjct_hist_pblanc3" name="prjct_hist_pblanc3">
																		<div class="form-control-position">
																			<i class="fa fa-envelope font-medium-5 line-height-1 text-muted icon-align"></i>
																		</div>
																	</div>
																	<div class="form-group position-relative has-icon-left">
																		<label for="prjct_hist_dmand3">수요기관</label>
																		<input type="text" class="form-control" id="prjct_hist_dmand3" name="prjct_hist_dmand3">
																		<div class="form-control-position">
																			<i class="fa fa-envelope font-medium-5 line-height-1 text-muted icon-align"></i>
																		</div>
																	</div>
																</div>
																<div class="modal-footer">
																	<input type="reset" class="btn btn-outline-secondary btn-lg" data-dismiss="modal" value="닫기">
																	<input type="button" class="btn btn-outline-primary btn-lg" id="btnDeletePrjctHist" value="삭제">
																</div>
															  	</form>
																</div>
														  </div>
														</div>
													</div>
																
												
													 <div class="form-group">
														<div class="modal fade text-left " id="iconForm2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel34" aria-hidden="true">
														  <div class="modal-dialog " role="document">
															<div class="modal-content ">
															  <div class="modal-header bg-blue-grey bg-lighten-3 ">
																<h3 class="modal-title " id="myModalLabel34">자격증 등록</h3>
																<button type="button" class="close" data-dismiss="modal" aria-label="Close">
																  <span aria-hidden="true">&times;</span>
																</button>
															  </div>
															  <form id="frmCrqfcHold" method="post">
																<div class="modal-body">
																	<label for="crqfc_nm">자격증명</label>
																	<select id="crqfc_nm" name="crqfc_nm" class="form-control">
																		<c:forEach var="crqfcInfo" items="${crqfcList}">
																			<c:set var="flag" value="false"></c:set>
																			<c:forEach var="crqfcHoldInfo" items="${crqfcHoldList}">
																				<c:if test="${not flag}">
																					<c:if test="${crqfcInfo.crqfc_id eq crqfcHoldInfo.crqfc_hold_crqfc}">
																						<c:set var="flag" value="true"></c:set>
																					</c:if>
																				</c:if>
																			</c:forEach>
																			<c:if test="${not flag}">
																				<option value="${crqfcInfo.crqfc_id}">
																					<c:out value="${crqfcInfo.crqfc_nm}"></c:out>
																				</option>
																			</c:if>
																		</c:forEach>
																	</select>
																</div>
																<div class="modal-footer">
																	<input type="reset" class="btn btn-outline-secondary btn-lg" data-dismiss="modal" value="닫기">
																	<input type="button" class="btn btn-outline-primary btn-lg" id="btnInsertCrqfcHold" value="등록">
																</div>
															  </form>
															</div>
														  </div>
														</div>
													</div>
													<div class="form-group">
														<div class="modal fade text-left " id="iconForm4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel34" aria-hidden="true">
														  <div class="modal-dialog " role="document">
															<div class="modal-content ">
															  <div class="modal-header bg-blue-grey bg-lighten-3 ">
																<h3 class="modal-title " id="myModalLabel34">자격증 조회</h3>
																<button type="button" class="close" data-dismiss="modal" aria-label="Close">
																  <span aria-hidden="true">&times;</span>
																</button>
															  </div>
															  <form id="frmCrqfcHold" method="post">
																<div class="modal-body">
																	<label for="crqfc_nm2">자격증명</label>
																	<input type="text" class="form-control" id="crqfc_nm2" name="crqfc_nm2" disabled="disabled">
																	<input type="hidden" id="crqfc_hold_empl2" name="crqfc_hold_empl2"/>
																	<input type="hidden" id="crqfc_hold_crqfc2" name="crqfc_hold_crqfc2"/>
																</div>
																<div class="modal-footer">
																	<input type="reset" class="btn btn-outline-secondary btn-lg" data-dismiss="modal" value="닫기">
																	<input type="button" class="btn btn-outline-primary btn-lg" id="btnDeleteCrqfcHold" value="삭제">
																</div>
															  </form>
															</div>
														  </div>
														</div>
													</div>
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