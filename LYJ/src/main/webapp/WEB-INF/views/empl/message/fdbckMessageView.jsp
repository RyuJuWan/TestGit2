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
        <h6 class="text-muted text-bold-500 mb-1">Feedback Messages</h6>
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
        <h6 class="text-muted text-bold-500 mt-1 mb-1">일감</h6>
        <div class="list-group list-group-messages">
            <a href="#" class="list-group-item list-group-item-action border-0">
                <i class="ft-circle mr-1 warning"></i> Work <span class="badge badge-warning badge-pill float-right">5</span>
            </a>
            <!--<a href="#" class="list-group-item list-group-item-action border-0"><i class="ft-circle mr-1 danger"></i> Family</a>-->
            <!--<a href="#" class="list-group-item list-group-item-action border-0"><i class="ft-circle mr-1 primary"></i> Friends</a>-->
            <a href="#" class="list-group-item list-group-item-action border-0"><i class="ft-circle mr-1 success"></i> Private <span class="badge badge-success badge-pill float-right">3</span> </a>
        </div>
             <hr>
    </div>
    <div class="email-app-list-wraper col-md-12 card p-0" style="border-right-style:solid;  border-right-color: #e9e9e9; border-right-width: 0.5px;">
        <div class="email-app-list">
            <div class="card-body chat-fixed-search">
                <fieldset class="form-group position-relative has-icon-left m-0 pb-1">
                    <input type="text" class="form-control" id="iconLeft4" placeholder="Search email">
                    <div class="form-control-position">
                        <i class="ft-search"></i>
                    </div>
                 <hr>
                </fieldset>     
            </div>
            <div id="users-list" class="list-group">
                <div class="users-list-padding media-list">
                    <a href="#" class="media border-0">
                        <div class="media-left pr-1">
                            <span class="avatar avatar-md">
                                <span class="media-object rounded-circle text-circle bg-info">T</span>
                            </span>
                        </div>
                        <div class="media-body w-100">
                            <h6 class="list-group-item-heading text-bold-500">Tonny Deep
                                <span class="float-right"><span class="font-small-2 primary">4:14 AM</span></span>
                            </h6>
                            <p class="list-group-item-text text-truncate text-bold-600 mb-0">PixInvent, I fount you...</p>
                            <p class="list-group-item-text mb-0">I would be good.<span class="float-right primary"><span class="badge badge-danger mr-1">Family</span> <i class="font-medium-1 ft-star blue-grey lighten-3"></i></span></p>
                        </div>
                    </a>
                    <a href="#" class="media border-0">
                        <div class="media-left pr-1">
                            <span class="avatar avatar-md">
                                <span class="media-object rounded-circle text-circle bg-danger">L</span>
                            </span>
                        </div>
                        <div class="media-body w-100">
                            <h6 class="list-group-item-heading text-bold-500">Louis Welch <span class="float-right"><i class="fa-paperclip fa"></i> <span class="font-small-2 primary">2:15 AM</span></span></h6>
                            <p class="list-group-item-text text-truncate text-bold-600 mb-0">Thanks, Let's do it.</p>
                            <p class="list-group-item-text mb-0">Can we connect today...<span class="float-right primary"><i class="font-medium-1 ft-star blue-grey lighten-3"></i></span></p>
                        </div>
                    </a>
                    <a href="#" class="media border-0">
                        <div class="media-left pr-1">
                            <span class="avatar avatar-md">
                                <span class="media-object rounded-circle text-circle bg-warning">E</span>
                            </span>
                        </div>
                        <div class="media-body w-100">
                            <h6 class="list-group-item-heading text-bold-500">Envato Market<span class="float-right"><span class="font-small-2 primary">11:18 PM</span></span></h6>
                            <p class="list-group-item-text text-truncate text-bold-600 mb-0">You have new comment...</p>
                            <p class="list-group-item-text mb-0">Hi Pixinvent...<span class="float-right primary"><span class="badge badge-warning mr-1">Work</span> <i class="font-medium-1 ft-star blue-grey lighten-3"></i></span></p>
                        </div>
                    </a>
                    <a href="#" class="media bg-blue-grey bg-lighten-5 border-right-primary border-right-2">
                        <div class="media-left pr-1">
                            <span class="avatar avatar-md"><img class="media-object rounded-circle" src="../../../app-assets/images/portrait/small/avatar-s-7.png" alt="Generic placeholder image">
                            </span>
                        </div>
                        <div class="media-body w-100">
                            <h6 class="list-group-item-heading">Wayne Burton <span class="font-small-2 float-right">Today</span></h6>
                            <p class="list-group-item-text text-truncate mb-0">Project ABC Status...</p>
                            <p class="list-group-item-text mb-0">Andy, Lte's...<span class="float-right primary"><span class="badge badge-success mr-1">Private</span> <i class="font-medium-1 ft-star warning"></i></span></p>
                        </div>
                    </a>
                    <a href="#" class="media border-0">
                        <div class="media-left pr-1">
                            <span class="avatar avatar-md"><img class="media-object rounded-circle" src="../../../app-assets/images/portrait/small/avatar-s-5.png" alt="Generic placeholder image"></span>
                        </div>
                        <div class="media-body w-100">
                            <h6 class="list-group-item-heading">Sarah Montgomery <span class="font-small-2 float-right">Yesterday</span></h6>
                            <p class="list-group-item-text text-truncate mb-0">Your New UI.</p>
                            <p class="list-group-item-text text-truncate mb-0">Everything looks good.</p>
                        </div>
                    </a>
                    <a href="#" class="media border-0">
                        <div class="media-left pr-1">
                            <span class="avatar avatar-md">
                                <span class="media-object rounded-circle text-circle bg-success">H</span>
                            </span>
                        </div>
                        <div class="media-body w-100">
                            <h6 class="list-group-item-heading">Heather Howell <span class="float-right"><i class="fa-paperclip fa"></i> <span class="font-small-2">15 July</span></span></h6>
                            <p class="list-group-item-text text-truncate mb-0">Thanks, Let's do it.</p>
                            <p class="list-group-item-text mb-0">Can we connect today...<span class="float-right primary"><i class="font-medium-1 ft-star blue-grey lighten-3"></i></span></p>
                        </div>
                    </a>
                    <a href="#" class="media border-0">
                        <div class="media-left pr-1">
                            <span class="avatar avatar-md"><img class="media-object rounded-circle" src="../../../app-assets/images/portrait/small/avatar-s-8.png" alt="Generic placeholder image">
                            <i></i>
                            </span>
                        </div>
                        <div class="media-body w-100">
                            <h6 class="list-group-item-heading">Kelly Reyes <span class="font-small-2 float-right">12 July</span></h6>
                            <p class="list-group-item-text text-truncate mb-0">I paid it, Thanks.</p>
                            <p class="list-group-item-text mb-0">Check once...<span class="float-right primary"><span class="badge badge-warning mr-1">Work</span> <i class="font-medium-1 ft-star blue-grey lighten-3"></i></span></p>
                        </div>
                    </a>
                    <a href="#" class="media border-0">
                        <div class="media-left pr-1">
                            <span class="avatar avatar-md">
                                <span class="media-object rounded-circle text-circle bg-warning">V</span>
                            </span>
                        </div>
                        <div class="media-body w-100">
                            <h6 class="list-group-item-heading">Vincent Nelson <span class="font-small-2 float-right">11 July</span></h6>
                            <p class="list-group-item-text text-truncate mb-0"><i class="ft-check primary font-small-2"></i> Where are you John?</p>
                            <p class="list-group-item-text mb-0">Party tonight ?<span class="float-right primary"><span class="badge badge-primary mr-1">Friends</span> <i class="font-medium-1 ft-star blue-grey lighten-3"></i></span></p>
                        </div>
                    </a>
                    <a href="#" class="media border-0">
                        <div class="media-left pr-1">
                            <span class="avatar avatar-md">
                                <span class="media-object rounded-circle text-circle bg-info">E</span>
                            </span>
                        </div>
                        <div class="media-body w-100">
                            <h6 class="list-group-item-heading">Elizabeth Elliott <span class="font-small-2 float-right">8 July</span></h6>
                            <p class="list-group-item-text text-truncate mb-0">Okay, I will call you.</p>
                            <p class="list-group-item-text mb-0">Here they are work.<span class="float-right primary"><i class="font-medium-1 ft-star blue-grey lighten-3"></i></span></p>
                        </div>
                    </a>
                    <a href="#" class="media border-0">
                        <div class="media-left pr-1">
                            <span class="avatar avatar-md"><img class="media-object rounded-circle" src="../../../app-assets/images/portrait/small/avatar-s-6.png" alt="Generic placeholder image"></span>
                        </div>
                        <div class="media-body w-100">
                            <h6 class="list-group-item-heading">Sarah Montgomery <span class="font-small-2 float-right">Yesterday</span></h6>
                            <p class="list-group-item-text text-truncate mb-0">Your New UI.</p>
                            <p class="list-group-item-text text-truncate mb-0">Everything looks good.</p>
                        </div>
                    </a>
                    <a href="#" class="media border-0">
                        <div class="media-left pr-1">
                            <span class="avatar avatar-md">
                                <span class="media-object rounded-circle text-circle bg-success">H</span>
                            </span>
                        </div>
                        <div class="media-body w-100">
                            <h6 class="list-group-item-heading">Heather Howell <span class="float-right"><i class="fa-paperclip fa"></i> <span class="font-small-2">15 July</span></span></h6>
                            <p class="list-group-item-text text-truncate mb-0">Thanks, Let's do it.</p>
                            <p class="list-group-item-text mb-0">Can we connect today...<span class="float-right primary"><i class="font-medium-1 ft-star blue-grey lighten-3"></i></span></p>
                        </div>
                    </a>
                    <a href="#" class="media border-0">
                        <div class="media-left pr-1">
                            <span class="avatar avatar-md"><img class="media-object rounded-circle" src="../../../app-assets/images/portrait/small/avatar-s-10.png" alt="Generic placeholder image">
                            <i></i>
                            </span>
                        </div>
                        <div class="media-body w-100">
                            <h6 class="list-group-item-heading">Kelly Reyes <span class="font-small-2 float-right">12 July</span></h6>
                            <p class="list-group-item-text text-truncate mb-0">I paid it, Thanks.</p>
                            <p class="list-group-item-text mb-0">Check once...<span class="float-right primary"><span class="badge badge-warning mr-1">Work</span> <i class="font-medium-1 ft-star blue-grey lighten-3"></i></span></p>
                        </div>
                    </a>
                    <a href="#" class="media border-0">
                        <div class="media-left pr-1">
                            <span class="avatar avatar-md">
                                <span class="media-object rounded-circle text-circle bg-warning">V</span>
                            </span>
                        </div>
                        <div class="media-body w-100">
                            <h6 class="list-group-item-heading">Vincent Nelson <span class="font-small-2 float-right">11 July</span></h6>
                            <p class="list-group-item-text text-truncate mb-0"><i class="ft-check primary font-small-2"></i> Where are you John?</p>
                            <p class="list-group-item-text mb-0">Party tonight ?<span class="float-right primary"><span class="badge badge-primary mr-1">Friends</span> <i class="font-medium-1 ft-star blue-grey lighten-3"></i></span></p>
                        </div>
                    </a>
                    <a href="#" class="media border-0">
                        <div class="media-left pr-1">
                            <span class="avatar avatar-md">
                                <span class="media-object rounded-circle text-circle bg-info">E</span>
                            </span>
                        </div>
                        <div class="media-body w-100">
                            <h6 class="list-group-item-heading">Elizabeth Elliott <span class="font-small-2 float-right">8 July</span></h6>
                            <p class="list-group-item-text text-truncate mb-0">Okay, I will call you.</p>
                            <p class="list-group-item-text mb-0">Here they are work.<span class="float-right primary"><i class="font-medium-1 ft-star blue-grey lighten-3"></i></span></p>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </div>
   <div class=" "    ><div class="card email-app-details d-none d-lg-block " style="width: 1050px">
	<div class="card-content">
		<div class="email-app-options card-body">
			<div class="row">
				<div class="col-md-6 col-12">
					<div class="btn-group" role="group" aria-label="Basic example">
						<button type="button" class="btn btn-sm btn-outline-secondary" data-toggle="tooltip" data-placement="top" data-original-title="Replay"><i class="fa fa-reply"></i></button>
						<button type="button" class="btn btn-sm btn-outline-secondary" data-toggle="tooltip" data-placement="top" data-original-title="Replay All"><i class="fa fa-reply-all"></i></button>
						<button type="button" class="btn btn-sm btn-outline-secondary" data-toggle="tooltip" data-placement="top" data-original-title="Report SPAM"><i class="ft-alert-octagon"></i></button>
						<button type="button" class="btn btn-sm btn-outline-secondary" data-toggle="tooltip" data-placement="top" data-original-title="Delete"><i class="ft-trash-2"></i></button>
					</div>                    
				</div>
				     
				<div class="col-md-6 col-12 text-right">
					<div class="btn-group" role="group" aria-label="Basic example">
						<button type="button" class="btn btn-sm btn-outline-secondary" data-toggle="tooltip" data-placement="top" data-original-title="Previous"><i class="fa fa-angle-left"></i></button>
						<button type="button" class="btn btn-sm btn-outline-secondary" data-toggle="tooltip" data-placement="top" data-original-title="Next"><i class="fa fa-angle-right"></i></button>
					</div>   
					<div class="btn-group ml-1">
						<button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">More</button>
                        <div class="dropdown-menu">
							<a class="dropdown-item" href="#">안읽은 메세지로 표시</a>
							<a class="dropdown-item" href="#">Mark as unimportant</a>
							<a class="dropdown-item" href="#">Add star</a>
							<a class="dropdown-item" href="#">Add to task</a>                            
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Filter mail</a>
						</div>
					</div>
				</div>
			</div>
					<hr>
		</div>

		<div class="email-app-title card-body">
			<div id="headingCollapse2" class="card-header p-0">
				<a data-toggle="collapse" href="#collapse2" aria-expanded="false" aria-controls="collapse2" class="email-app-sender media border-0">
					<div class="media-left pr-1">
						<span class="avatar avatar-md"><img class="media-object rounded-circle" src="../../../app-assets/images/portrait/small/avatar-s-7.png" alt="Generic placeholder image"></span>
					</div>
					<div class="media-body w-100">
						<h6 class="list-group-item-heading">김유나 사원</h6>
						<p class="list-group-item-text">개발1팀 | <span>16:30</span>
					<hr>
							<span class="float-right" >
								<i class="fa fa-reply mr-1" ></i>
								<i class="fa fa-arrow-right mr-1"></i><label>답장</label>
								<i class="fa fa-ellipsis-v"></i>
							</span>
						</p>
					</div>

				</a>
			</div>
			<h3 class="list-group-item-heading">Project ABC Status Report</h3>
			<p class="list-group-item-text"><span class="primary"><span class="badge badge-primary">관련일감 (일감을입력해주세요)</span> <i class="float-right font-medium-3 ft-star warning"></i></span></p>
		</div>
		
		
			<div id="collapse2" role="tabpanel" aria-labelledby="headingCollapse2" class="card-collapse" aria-expanded="false">
				<div class="card-content">
					<div class="email-app-text card-body">
						<div class="email-app-message">
							<p>Hi John,</p>
							<p>Thanks for your feedback ! Here's a new layout for a new Robust Admin theme.</p>
							<p>We will start the new application development soon once this will be completed, I will provide you more details after this Saturday. Hope that will be fine for you.</p>
							<p>Hope your like it, or feel free to comment, feedback or rebound !</p>
							<p>Cheers~</p>
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