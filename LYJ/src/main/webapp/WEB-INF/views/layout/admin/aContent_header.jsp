<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ////////////////////////////////////////////////////////////////////////////-->
    <div class="app-content content">
      <div class="content-wrapper">
        <div class="content-header row">
        </div>
        <div class="main-menu menu-static menu-light menu-accordion menu-shadow" data-scroll-to-active="true" style="height: 700px">
          <div class="main-menu-content">
            <ul class="navigation navigation-main" id="main-menu-navigation" data-menu="menu-navigation">
              <li class=" nav-item"><a href="${pageContext.request.contextPath}/admin/member/emplList.do"><i class="fa fa-address-book-o"></i><span class="menu-title" data-i18n="nav.templates.main">사원정보 조회</span></a>
               </li>
              <li class=" navigation-header"><span data-i18n="nav.category.layouts">게시판</span><i class="ft-more-horizontal ft-minus" data-toggle="tooltip" data-placement="right" data-original-title="Layouts"></i>
              </li>
              <li class=" nav-item"><a href="${pageContext.request.contextPath}/admin/frb/frbList.do"><i class="fa fa-pencil-square-o"></i><span class="menu-title" data-i18n="nav.page_layouts.main">자유게시판</span></a>
              </li>
              <li class=" nav-item"><a href="${pageContext.request.contextPath}/admin/pblanc/pblancList.do"><i class="fa fa-newspaper-o"></i><span class="menu-title" data-i18n="nav.navbars.main">공고게시판</span><span class="badge badge badge-success float-right mr-2">New</span></a>
              </li>
              <li class=" nav-item"><a href="${pageContext.request.contextPath}/admin/notice/noticeList.do"><i class="icon-directions"></i><span class="menu-title" data-i18n="nav.vertical_nav.main">공지사항</span></a>
              </li>
              <li class=" nav-item"><a href="#"><i class="icon-question"></i><span class="menu-title" data-i18n="nav.horz_nav.main">문의게시판</span></a>
              	<ul class="menu-content">
                      <li><a class="menu-item" href="${pageContext.request.contextPath}/admin/qna/qnaList.do" data-i18n="nav.templates.horz.classic">질문게시판</a>
                      </li>
                      <li><a class="menu-item" href="../horizontal-menu-template" data-i18n="nav.templates.horz.classic">FAQ</a>
                      </li>
                </ul>
              </li>
            </ul>
          </div>
       </div>
</body>
</html>