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
			
    <div class="app-content content">
      <div class="sidebar-left sidebar-fixed">
        <div class="sidebar">
        <div class="sidebar-content card d-none d-lg-block">
    <div class="card-body chat-fixed-search">
        <fieldset class="form-group position-relative has-icon-left m-0">
            <input type="text" class="form-control" id="iconLeft4" placeholder="Search user">
            <div class="form-control-position">
                <i class="ft-search"></i>
            </div>
        </fieldset>     
    </div>
    
    <div id="users-list" class="list-group position-relative">
     <div class="content-header-right col-md-4 col-12" style="margin-left: 200px"> 
            <div class="btn-group float-md-right">
              <button class="btn btn-info dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="icon-settings mr-1"></i>Action</button>
              <div class="dropdown-menu arrow"><a class="dropdown-item" href="#"><i class="fa fa-calendar mr-1"></i> 채팅방 등록</a><a class="dropdown-item" href="#"><i class="fa fa-cart-plus mr-1"></i> 채팅방 삭제</a><a class="dropdown-item" href="#"><i class="fa fa-life-ring mr-1"></i> Support</a>
                <div class="dropdown-divider"></div><a class="dropdown-item" href="#"><i class="fa fa-cog mr-1"></i> Settings</a>
              </div>
            </div>
          </div>
          
        <div class="users-list-padding media-list">
            <a href="#" class="media border-0">
                <div class="media-left pr-1">
                    <span class="avatar avatar-md avatar-online"><img class="media-object rounded-circle" src="../../../app-assets/images/portrait/small/avatar-s-3.png" alt="Generic placeholder image">
                    <i></i>
                    </span>
                </div>
                <div class="media-body w-100">
                    <h6 class="list-group-item-heading">Elizabeth Elliott <span class="font-small-3 float-right info">4:14 AM</span></h6>
                    <p class="list-group-item-text text-muted mb-0"><i class="ft-check primary font-small-2"></i> 개발1팀 <span class="float-right primary"><i class="font-medium-1 icon-pin blue-grey lighten-3"></i></span></p>
                </div>
            </a>
            <a href="#" class="media border-0">
                <div class="media-left pr-1">
                    <span class="avatar avatar-md avatar-busy"><img class="media-object rounded-circle" src="../../../app-assets/images/portrait/small/avatar-s-7.png" alt="Generic placeholder image">
                    <i></i>
                    </span>
                </div>
                <div class="media-body w-100">
                    <h6 class="list-group-item-heading">Kristopher Candy <span class="font-small-3 float-right info">9:04 PM</span></h6>
                    <p class="list-group-item-text text-muted mb-0"><i class="ft-check primary font-small-2"></i>  개발2팀  <span class="float-right primary"><span class="badge badge-pill badge-danger">12</span></span></p>
                </div>
            </a>
            <a href="#" class="media border-0">
                <div class="media-left pr-1">
                    <span class="avatar avatar-md avatar-away"><img class="media-object rounded-circle" src="../../../app-assets/images/portrait/small/avatar-s-8.png" alt="Generic placeholder image">
                    <i></i>
                    </span>
                </div>
                <div class="media-body w-100">
                    <h6 class="list-group-item-heading">Sarah Woods <span class="font-small-3 float-right info">2:14 AM</span></h6>
                    <p class="list-group-item-text text-muted mb-0"><i class="ft-check font-small-2"></i>  개발1팀  <span class="float-right primary"><i class="font-medium-1 icon-volume-off blue-grey lighten-3 mr-1"></i> <span class="badge badge-pill badge-danger">3</span></span></p>
                </div>
            </a>
            <a href="#" class="media bg-blue-grey bg-lighten-5 border-right-info border-right-2">
                <div class="media-left pr-1">
                    <span class="avatar avatar-md avatar-online"><img class="media-object rounded-circle" src="../../../app-assets/images/portrait/small/avatar-s-7.png" alt="Generic placeholder image">
                    <i></i>
                    </span>
                </div>
                <div class="media-body w-100">
                    <h6 class="list-group-item-heading">Wayne Burton <span class="font-small-3 float-right info">Today</span></h6>
                    <p class="list-group-item-text text-muted mb-0"><i class="ft-check primary font-small-2"></i>  개발4팀 </p>
                </div>
            </a>
        </div>
    </div>
</div>
        </div>
      </div>
    </div>
    <div id="frame" style="margin-left: 600px; overflow: scroll;  " >
	    <section id="video-grid" class="card">
  <div class="card-content">

    <div class="card-body">

      <div class="card-deck-wrapper">
        <div class="card-deck">
          <div class="card border-grey border-lighten-2">
            <div class="card-img-top embed-responsive embed-responsive-item embed-responsive-16by9">
              <iframe class="gallery-thumbnail" src="https://player.vimeo.com/video/118589137?title=0&byline=0" width="640" height="360"></iframe>
            </div>
            <div class="card-body px-0" style="margin-left: 15px">
             <!--  <h4 class="card-title">김유나 사원</h4> -->
               <a href="#" class="media border-0">
                <div class="media-left pr-1">
                    <span class="avatar avatar-md avatar-online"><img class="media-object rounded-circle" src="../../../app-assets/images/portrait/small/avatar-s-3.png" alt="Generic placeholder image">
                    <i></i>
                    </span>
                </div>
                <div class="media-body w-100">
                    <h6 class="list-group-item-heading">김유나 사원 </h6>
                    <p class="list-group-item-text text-muted mb-0"><i class="ft-check primary font-small-2"></i> <span class="font-small-3 info">개발1팀</span> | 프로젝트명 <span class="float-right primary"><i class="font-medium-1 icon-pin blue-grey lighten-3"></i></span></p>
                </div>
            </a>
              <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
            </div>
          </div>
        </div>
      </div>

      <div class="card-deck-wrapper">
        <div class="card-header">
        <a class="heading-elements-toggle"><i class="fa fa-ellipsis-v font-medium-3"></i></a>
        <div class="heading-elements"  >
              <ul class="list-inline mb-0">
                  <li><a data-action="expand"><i class="ft-maximize"></i></a></li>
                  <li><a data-action="close"><i class="ft-x"></i></a></li>
              </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</div>
</body>
</html>