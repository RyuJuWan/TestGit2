<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	if(eval('${!empty param.message}')) {
		if(eval('${!empty param.admin_id}')) Delete_Cookie('saveAdminID');
		else if(eval('${!empty param.empl_id}')) Delete_Cookie('saveEmplID');
		
		alert('${param.message}');
	}
	
	if(Get_Cookie('saveEmplID')){
		$('#mem_id').val(Get_Cookie('saveEmplID'));
		$('input[name=customCheck]').prop('checked', true);
	}
	
	$('input[name=customRadio]').change(function(){
		$('#mem_id').val('');
		$('#mem_pass').val('');
		$('input[name=customCheck]').prop('checked', false);
		
		if($('input[name="customRadio"]:checked').val() == 'admin'){
			$('#aFindPass').hide();
			
			if(Get_Cookie('saveAdminID')){
				$('#mem_id').val(Get_Cookie('saveAdminID'));
				$('input[name=customCheck]').prop('checked', true);
			}
		} else if($('input[name="customRadio"]:checked').val() == 'empl'){
			$('#aFindPass').show();
			
			if(Get_Cookie('saveEmplID')){
				$('#mem_id').val(Get_Cookie('saveEmplID'));
				$('input[name=customCheck]').prop('checked', true);
			}
		}
	});
	
	$('#btnLogin').click(function(){
		var mem_id = $('#mem_id').val();
		var mem_pass = $('#mem_pass').val();
		
		if(!loginValidCheck(mem_id, mem_pass)) return false;
				
		if($('input[name=customRadio]:checked').val() == 'admin'){
			$('#frmLogin').attr('action', '${pageContext.request.contextPath}/admin/join/loginCheck.do');
			
			if($('input[name=customCheck]').is(':checked')){
				Set_Cookie('saveAdminID', mem_id, 1, '/');
			} else {
				Delete_Cookie('saveAdminID', '/');
			}
		} else {
			$('#frmLogin').attr('action', '${pageContext.request.contextPath}/empl/join/loginCheck.do');
			
			if($('input[name=customCheck]').is(':checked')){
				Set_Cookie('saveEmplID', mem_id, 1, '/');
			} else {
				Delete_Cookie('saveEmplID', '/');
			}
		}
		
		$('#frmLogin').submit();
	});
	
	$('#btnFindPass').click(function(){
		var empl_nm = $('#empl_nm').val();
		var empl_id = $('#empl_id').val();
		var empl_mail = $('#empl_mail').val();
		
		if(!findPassValidCheck(empl_nm, empl_id, empl_mail)) return false;
		
		location.href = '${pageContext.request.contextPath}/empl/join/findPass.do?empl_nm=' + empl_nm + '&empl_id=' + empl_id + '&empl_mail=' + empl_mail;
	});
	
	$('#iconForm').on('hidden.bs.modal', function(){
		$('#empl_id').val('');
		$('#empl_nm').val('');
		$('#empl_mail').val('');
	});
	
	function loginValidCheck(mem_id, mem_pass){
		if(mem_id == ''){
			alert('아이디 공란');
			return false;
		} else if(!mem_id.validID()){
			alert('아이디 형식 오류');
			return false;
		}
		
		if(mem_pass == ''){
			alert('비밀번호 공란');
			return false;
		} else if(!mem_pass.validPass()){
			alert('비밀번호 형식 오류');
			return false;
		}
		
		return true;
	}
	
	function findPassValidCheck(empl_nm, empl_id, empl_mail){
		if(empl_nm == ''){
			alert('이름 공란');
			return false;
		} else if(!empl_nm.validNM()){
			alert('이름 형식 오류');
			return false;
		}
		
		if(empl_id == ''){
			alert('아이디 공란');
			return false;
		} else if(!empl_id.validID()){
			alert('아이디 형식 오류');
			return false;
		}
		
		if(empl_mail == ''){
			alert('메일 공란');
			return false;
		} else if(!empl_mail.validMail()){
			alert('메일 형식 오류');
			return false;
		}
		
		return true;
	}
});
</script>
<style type="text/css">
#backgroundselect{
   height : 100%;
   background-image: url( "${pageContext.request.contextPath}/app-assets/images/simon-abrams-286276-unsplash.jpg" );
   background-size: cover;
}
</style>
</head>
<body>
   <div class="app-content content" id="backgroundselect">
      <div class="content-wrapper">
        <div class="content-header row">
        </div>
        <div class="content-body"><section class="flexbox-container">
    <div class="col-12 d-flex align-items-center justify-content-center" style="margin-top: 200px"  >
        <div class="col-md-4 col-10 box-shadow-2 p-0" >
            <div class="card border-grey border-lighten-3 m-0" >
                <div class="card-header border-0">
                    <div class="card-title text-center">
                        <div class="p-1"><p style="font-weight: bold; font-size: x-large;"><img class="brand-logo" alt="robust admin logo" src="../../../app-assets/images/logo/logo-dark-sm.png"> Remind</p></div>
                    </div>
                    <h6 class="card-subtitle line-on-side text-muted text-center font-small-3 pt-2"><span>Login with Remind</span></h6>
                    <div align="center">
                    <fieldset >
		              <div class="custom-control custom-radio">
		                <input type="radio" class="custom-control-input" name="customRadio" id="customRadio1" value="admin">
		                <label class="custom-control-label" for="customRadio1">관리자 로그인</label>
		              </div>
		            </fieldset>
		            <fieldset>
		              <div class="custom-control custom-radio">
		                <input type="radio" class="custom-control-input" name="customRadio" id="customRadio2" value="empl" checked>
		                <label class="custom-control-label" for="customRadio2">사원 로그인</label>
		              </div>
		            </fieldset>
		            </div>
                </div>
                <div class="card-content">
                    <div class="card-body">
                        <form class="form-horizontal form-simple" id="frmLogin" method="post" novalidate>
                            <fieldset class="form-group position-relative has-icon-left mb-0">
                                <input type="text" class="form-control form-control-lg input-lg" id="mem_id" name="mem_id" placeholder="ID" required>
                                <div class="form-control-position">
                                    <i class="ft-user font-medium-5 line-height-1 text-muted icon-align"></i>
                                </div>
                            </fieldset>
                            <fieldset class="form-group position-relative has-icon-left">
                                <input type="password" class="form-control form-control-lg input-lg" id="mem_pass" name="mem_pass" placeholder="Password" required>
                                <div class="form-control-position">
                                    <i class="fa fa-key font-medium-5 line-height-1 text-muted icon-align "></i>
                                </div>
                            </fieldset>
                            <div class="form-group row">
                                <div class="col-md-6 col-12 text-center text-md-left">
                                    <fieldset>
                                         <fieldset>
							                  <div class="custom-control custom-checkbox">
							                    <input type="checkbox" class="custom-control-input" name="customCheck" id="customCheck1">
							                    <label class="custom-control-label" for="customCheck1"> 아이디 저장</label>
							                  </div>
							              </fieldset>
                                    </fieldset>
                                </div>
                                
                                <div class="col-md-6 col-12 text-center text-md-right">
                                <a  data-toggle="modal" href="#iconForm" class="card-link" id="aFindPass">비밀번호 찾기</a>
                                	<div class="col-lg-4 col-md-6 col-sm-12">
                                	
								<div class="form-group">
									<!-- Button trigger modal -->

									<!-- Modal -->
									<div class="modal fade text-left " id="iconForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel34" aria-hidden="true">
									  <div class="modal-dialog " role="document">
										<div class="modal-content ">
										  <div class="modal-header bg-blue-grey bg-lighten-3 ">
											<h3 class="modal-title " id="myModalLabel34">비밀번호 찾기</h3>
											<button type="button" class="close" data-dismiss="modal" aria-label="Close">
											  <span aria-hidden="true">&times;</span>
											</button>
										  </div>
										  <form id="frmFindPass" method="post">
											<div class="modal-body">
												<label>이름 : </label>
												<div class="form-group position-relative has-icon-left">
													<input type="text" placeholder="Name" class="form-control" id="empl_nm" name="empl_nm">
													<div class="form-control-position">
														<i class="ft-users font-large-1 line-height-1 text-muted icon-align"></i>
													</div>
												</div>
												<label>사번 : </label>
												<div class="form-group position-relative has-icon-left">
													<input type="text" placeholder="Empl ID" class="form-control" id="empl_id" name="empl_id">
													<div class="form-control-position">
														<i class="fa fa-lock font-large-1 line-height-1 text-muted icon-align"></i>
													</div>
												</div>
												
												<label>이메일 주소: </label>
												<div class="form-group position-relative has-icon-left">
													<input type="text" placeholder="Email Address" class="form-control" id="empl_mail" name="empl_mail">
													<div class="form-control-position">
														<i class="fa fa-envelope font-medium-5 line-height-1 text-muted icon-align"></i>
													</div>
												</div>
											</div>
											<div class="modal-footer">
												<input type="reset" class="btn btn-outline-secondary btn-lg" data-dismiss="modal" value="close">
												<input type="button" class="btn btn-outline-primary btn-lg" id="btnFindPass" value="발급">
											</div>
										  </form>
										</div>
									  </div>
									</div>
								</div>
							</div>
							
							
                                </div>
                            </div>
                            <button type="button" id="btnLogin" class="btn btn-info btn-lg btn-block"><i class="ft-unlock"></i> 로그인</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

        </div>
      </div>
    </div>
    
</body>
</html>