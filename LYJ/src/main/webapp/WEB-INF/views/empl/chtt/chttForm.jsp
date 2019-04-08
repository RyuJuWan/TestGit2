<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.2/css/font-awesome.min.css'>
<style class="cp-pen-styles">
#frame {
  width: 95%;
  min-width: 360px;
  max-width: 1250px;
  height: 92vh;
  min-height: 300px;
  max-height: 850px;
  background: white;
}
</style>
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
                    <p class="list-group-item-text text-muted mb-0"><i class="ft-check primary font-small-2"></i> Okay <span class="float-right primary"><i class="font-medium-1 icon-pin blue-grey lighten-3"></i></span></p>
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
                    <p class="list-group-item-text text-muted mb-0"><i class="ft-check primary font-small-2"></i> Thank you <span class="float-right primary"><span class="badge badge-pill badge-danger">12</span></span></p>
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
                    <p class="list-group-item-text text-muted mb-0"><i class="ft-check font-small-2"></i> Hello krish! <span class="float-right primary"><i class="font-medium-1 icon-volume-off blue-grey lighten-3 mr-1"></i> <span class="badge badge-pill badge-danger">3</span></span></p>
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
                    <p class="list-group-item-text text-muted mb-0"><i class="ft-check primary font-small-2"></i> Can we connect?</p>
                </div>
            </a>
        </div>
    </div>
</div>
        </div>
      </div>
    </div>
    <div id="frame" style="margin-left: 600px; overflow: scroll;  " >
	<div class="content" style="width: 1100px;  margin-right: 50px; ">
		<div class="card-content" style="padding-left: 120px; padding-right: 80px; ">

		<div class="email-app-title card-body " >
		<div class="heading-elements" style="margin-left: 900px;  " >
	    		<button class="btn btn-primary btn-md" style=" "><i class="ft-plus white"></i> 방 만들기</button>
	     </div>
      	<hr>  
		<div id="headingCollapse2" class="card-header p-0" style="margin-left: 30px">
				<a data-toggle="collapse" href="#collapse2" aria-expanded="false" aria-controls="collapse2" class="email-app-sender media border-0">
					<div class="media-left pr-1">
						<span class="avatar avatar-md"><img class="media-object rounded-circle" src="../../../app-assets/images/portrait/small/avatar-s-7.png" alt="Generic placeholder image"></span>
					</div>
					<div class="media-body w-100">
						<h6 class="list-group-item-heading">김유나 사원</h6>
						<p class="list-group-item-text">개발1팀 | <span>프로젝트명</span>
						</p>
					</div>

				</a>
			</div>
			<div class="row" style="margin-left: 10px">
				<label class="" style="margin-top: 3px; margin-left: 20px">제목 : </label>
				<div class="col-lg-11">
					<div class="row">
						<div class="col-md-10">
							<input type="text" class="form-control"  style="margin-bottom: 20px; margin-left: 27px; height: 30px; ">
						</div>
					</div>
				</div>
			</div>
			
			<div role="tabpanel" aria-labelledby="headingCollapse2" class="card-collapse" aria-expanded="false" >
					<div class=" d-inline-block "  >
					 <div class="card-body" >
				           <p class="lead">부서</p>
				           <ul class="list-group">
				            <li class="list-group-item">
				                <span class="badge badge-primary badge-pill float-right">  	1   </span> 
				                <a href="">전체</a>
				            </li>
				                <li class="list-group-item">
				                    <span class="badge badge-primary badge-pill float-right">
				                    	1
				                    </span> 
				                    <a href="${pageContext.request.contextPath}/empl/member/emplList.do?deptFilter=de00${dept_num}"> 
				                    	개발1팀
				                    </a>
				                </li>
				           </ul>
				   				</div>
					</div>
				        <div class=" d-inline-block " style="vertical-align: middle;">
		                <div class="table-responsive ">
			                <table id="tblEmpl" class="table table-white-space table-bordered row-grouping display no-wrap icheck table-middle" >
						        <thead>
						            <tr>
						                <th>번호</th>
						                <th>사번</th>
						                <th>이름</th>
						                <th>부서</th>
						                <th>직위</th>
						                <th>이메일</th>
						            </tr>
						        </thead>
						        <tbody>
						        		<tr>
						        			<td>1</td>
						        			<td>2</td>
						        			<td>3</td>
						        			<td>4</td>
						        			<td>5</td>
						        			<td>이메일을 입력해주세요</td>
						        		</tr>
						        </tbody>
						    </table>
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
</body>
</html>