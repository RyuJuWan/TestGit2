<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div class="content-body">
   <div class="app-content content">
        <div class="sidebar"><div class="sidebar-content email-app-sidebar d-flex">
    <div class="email-app-menu col-md-9 card d-none d-lg-block" style="border-right-style:solid;  border-right-color: #e9e9e9; border-right-width: 0.5px;">
        <div class="form-group form-group-compose text-center">
            <button type="button" class="btn btn-danger btn-block my-1"><i class="ft-mail"></i> 피드백 쪽지 보내기</button>
        </div>
        <hr>
        <h6 class="text-muted text-bold-500 mb-1">Messages</h6>
        <div class="list-group list-group-messages">
            <a href="#" class="list-group-item active border-0">
                <i class="ft-inbox mr-1"></i> 받은 쪽지함 <span class="badge badge-secondary badge-pill float-right">8</span>
            </a>
            <a href="#" class="list-group-item list-group-item-action border-0"><i class="fa fa-paper-plane-o mr-1"></i> 보낸 쪽지함</a>
            <a href="#" class="list-group-item list-group-item-action border-0"><i class="ft-file mr-1"></i> Draft</a>
            <a href="#" class="list-group-item list-group-item-action border-0"><i class="ft-star mr-1"></i> Starred<span class="badge badge-danger badge-pill float-right">3</span> </a>
            <a href="#" class="list-group-item list-group-item-action border-0"><i class="ft-trash-2 mr-1"></i> Trash</a>
        </div>
             <hr>
        <h6 class="text-muted text-bold-500 mt-1 mb-1">Project</h6>
        <div class="list-group list-group-messages">
            <a href="#" class="list-group-item list-group-item-action border-0">
                <i class="ft-circle mr-1 warning"></i> Work <span class="badge badge-warning badge-pill float-right">5</span>
            </a>
            <a href="#" class="list-group-item list-group-item-action border-0"><i class="ft-circle mr-1 danger"></i> Family</a>
            <a href="#" class="list-group-item list-group-item-action border-0"><i class="ft-circle mr-1 primary"></i> Friends</a>
            <a href="#" class="list-group-item list-group-item-action border-0"><i class="ft-circle mr-1 success"></i> Private <span class="badge badge-success badge-pill float-right">3</span> </a>
        </div>
             <hr>
    </div>
   <div class=""     ><div class="card email-app-details d-none d-lg-block " style="width: 1300px; ">
	<div class="card-content" style="padding-left: 80px; padding-right: 80px; padding-top: 30px">

		<div class="email-app-title card-body " >
		<div id="headingCollapse2" class="card-header p-0" style="margin-left: 30px">
				<a data-toggle="collapse" href="#collapse2" aria-expanded="false" aria-controls="collapse2" class="email-app-sender media border-0">
					<div class="media-left pr-1">
						<span class="avatar avatar-md"><img class="media-object rounded-circle" src="../../../app-assets/images/portrait/small/avatar-s-7.png" alt="Generic placeholder image"></span>
					</div>
					<div class="media-body w-100">
							<span class="float-right" style="margin-right: 5px">
								<i class="fa fa-reply mr-1"></i>
								<i class="fa fa-arrow-right mr-1"></i><label>보내기</label>
								<i class="fa fa-ellipsis-v"></i>
							</span>
						<h6 class="list-group-item-heading">김유나 사원</h6>
						<p class="list-group-item-text">개발1팀 | <span>15:30</span>
						</p>
					</div>

				</a>
			</div>
			<div class="row" style="margin-left: 10px">
				<label class="" style="margin-top: 7px; margin-left: 20px">제목 : </label>
				<div class="col-lg-11">
					<div class="row">
						<div class="col-md-10">
							<input type="text" class="form-control"  style="margin-bottom: 20px; margin-left: 27px; height: 30px; ">
						</div>
					</div>
				</div>
			</div>
			<div class="row" style="margin-left: 10px"  >
				<label class="" style="margin-top: 7px; margin-left: 20px">받는 사람: </label>
				<div class="col-lg-11">
					<div class="row">
						<div class="col-md-10">
							<input type="text" class="form-control"  style="margin-bottom: 20px;  height: 30px; ">
						</div>
					</div>
				</div>
			</div>
			
			<div id="collapse2" role="tabpanel" aria-labelledby="headingCollapse2" class="card-collapse" aria-expanded="false">
				<div class="card-content">
					<div class="email-app-text card-body">
						<div class="form-group">
							<div class="card-content collapse show">
									<div class="form-group">
										<textarea name="reqre_specf_cn" id="ckeditor" cols="30" rows="15" class="ckeditor">
										</textarea>
									</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="email-app-text-action card-body">

			</div>
		</div>
	</div>
</div>
          </div>
    
</div>
</div>
</div>
</div>
  </body>
</html>