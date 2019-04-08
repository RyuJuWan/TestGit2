<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<body>
    <div class="app-content content" style="height: 900px;overflow: scroll; "      >
      <div class="content-wrapper"  style="height: 100%" >
        <div class="content-header row">
        </div>
        
        <div class="main-menu menu-static menu-light menu-accordion menu-shadow" data-scroll-to-active="true" >
          <div class="main-menu-content">
            <ul class="navigation navigation-main" id="main-menu-navigation" data-menu="menu-navigation">
            	 
              <li class=" navigation-header"><span data-i18n="nav.category.layouts">프로젝트</span><i class="ft-more-horizontal ft-minus" data-toggle="tooltip" data-placement="right" data-original-title="Layouts"></i>
              </li>
             <li class=" nav-item"><a href="#"><i class="fa fa-file-text-o"></i><span class="menu-title" data-i18n="nav.horz_nav.main">프로젝트 계획</span></a>
              	<ul class="menu-content">
                      <li><a class="menu-item" href="${pageContext.request.contextPath}/empl/prpsl/prpslList.do" data-i18n="nav.templates.horz.classic">제안서</a></li>
                      <li><a class="menu-item" href="${pageContext.request.contextPath}/empl/rqpps/rqppsList.do"data-i18n="nav.templates.horz.classic">제안요청서</a></li>
                      <li><a class="menu-item"  href="${pageContext.request.contextPath}/empl/hnfInpt/hnfInptList.do"  data-i18n="nav.templates.horz.classic">인원투입계획서</a></li>
                </ul>
              </li>
              <c:if test="${LOGIN_EMPLINFO.empl_ofcps ne 'of001' and LOGIN_EMPLINFO.empl_ofcps ne 'of002'}">
	              <li class=" nav-item"><a href="${pageContext.request.contextPath}/empl/project/projectForm.do"><i class="fa fa-address-book-o"></i><span class="menu-title" data-i18n="nav.templates.main">프로젝트 생성</span></a>
	              </li>
              </c:if>
              <li class=" nav-item"><a href="#"><i class="fa fa-sitemap"></i><span class="menu-title" data-i18n="nav.templates.main">프로젝트</span></a>
                <ul class="menu-content">
                  <c:forEach items="${currentPrjctList}" var="currentPrjctInfo">
                  	<c:forEach items="${prjctHistList}" var="prjctHistInfo">
                  		<c:if test="${currentPrjctInfo.prjct_id eq prjctHistInfo.prjct_hist_prjct}">
                  			<li><a class="menu-item text-bold-600" href="#" data-i18n="nav.templates.horz.main">${currentPrjctInfo.prjct_nm}</a>
			                    <ul class="menu-content">
			                      <c:if test="${LOGIN_EMPLINFO.empl_ofcps ne 'of001' and LOGIN_EMPLINFO.empl_ofcps ne 'of002'}">
			                      	<li><a class="menu-item" href="${pageContext.request.contextPath}/empl/project/projectView.do?prjct_id=${currentPrjctInfo.prjct_id}" data-i18n="nav.templates.vert.main">프로젝트 수정</a></li>
			                      </c:if>
			                       <li><a class="menu-item" href="${pageContext.request.contextPath}/empl/project/emplManage.do?prjct_id=${currentPrjctInfo.prjct_id}" data-i18n="nav.templates.vert.main">팀원 관리</a></li>
				                   <li><a class="menu-item" href="${pageContext.request.contextPath}/empl/dy_dashboard/dashboardView.do?prjct_id=${currentPrjctInfo.prjct_id}" data-i18n="nav.templates.vert.main">대시보드</a></li>
								  
			                      	<li><a class="menu-item" href="${pageContext.request.contextPath}/empl/dy_reqre_specf/check.do?prjct_id=${currentPrjctInfo.prjct_id}" data-i18n="nav.templates.vert.main">요구사항정의서</a></li>
				                  
				                  <li><a class="menu-item" href="${pageContext.request.contextPath}/empl/dy_wbs/dy_wbsList.do?prjct_id=${currentPrjctInfo.prjct_id}" data-i18n="nav.templates.vert.main">업무관리게시판</a>
				                  </li>
				                  <li><a class="menu-item" href="#" data-i18n="nav.templates.horz.main">보고서</a>
				                    <ul class="menu-content">
				                      <li><a class="menu-item" href="${pageContext.request.contextPath}/empl/dy_reprt/dy_weekReprtList.do?prjct_id=${currentPrjctInfo.prjct_id}" data-i18n="nav.templates.horz.classic">주간보고서</a>
				                      </li>
				                      <li><a class="menu-item" href="${pageContext.request.contextPath}/empl/dy_reprt/dy_mnthngReprtList.do?prjct_id=${currentPrjctInfo.prjct_id}" data-i18n="nav.templates.horz.top_icon">월간보고서</a>
				                      </li>
				                    </ul>
				                  </li>
				                  <li><a class="menu-item" href="${pageContext.request.contextPath}/empl/dy_mtg/dy_mtgList.do?prjct_id=${currentPrjctInfo.prjct_id}" data-i18n="nav.templates.vert.main">회의록</a>
				                  </li>
				                  <li><a class="menu-item" href="${pageContext.request.contextPath}/empl/dy_issue/dy_issueList.do?prjct_id=${currentPrjctInfo.prjct_id}" data-i18n="nav.templates.vert.main">이슈</a>
				                  </li>
				                  <li><a class="menu-item" href="${pageContext.request.contextPath}/empl/dy_risk/dy_riskList.do?prjct_id=${currentPrjctInfo.prjct_id}" data-i18n="nav.templates.vert.main">리스크</a>
				                  </li>
				                  <li><a class="menu-item" href="${pageContext.request.contextPath}/empl/dy_flaw/dy_flawList.do?prjct_id=${currentPrjctInfo.prjct_id}" data-i18n="nav.templates.vert.main">결함</a>
				                  </li>
				                  <li><a class="menu-item" href="${pageContext.request.contextPath}/empl/dy_expndtr_anact/dy_expndtr_anactList.do?prjct_id=${currentPrjctInfo.prjct_id}" data-i18n="nav.templates.vert.main">지출결의</a>
				                  </li>
				                  <li><a class="menu-item" href="${pageContext.request.contextPath}/empl/dy_notice/dy_noticeList.do?prjct_id=${currentPrjctInfo.prjct_id}" data-i18n="nav.templates.vert.main">공지사항</a>
				                  </li>
				                  <li><a class="menu-item" href="${pageContext.request.contextPath}/empl/dy_frb/dy_frbList.do?prjct_id=${currentPrjctInfo.prjct_id}" data-i18n="nav.templates.vert.main">자유게시판</a>
				                  </li>
				                  <li><a class="menu-item" href="${pageContext.request.contextPath}/empl/dy_recsroom/dy_recsroomList.do?prjct_id=${currentPrjctInfo.prjct_id}" data-i18n="nav.templates.vert.main">자료실</a>
				                  </li>
				                  <li><a class="menu-item" href="${pageContext.request.contextPath}/empl/dy_schdul/dy_schdulView.do?prjct_id=${currentPrjctInfo.prjct_id}&LoginId=${sessionScope.LOGIN_EMPLINFO.empl_id}" data-i18n="nav.templates.vert.main">일정</a>
				                  </li>
				                </ul>
				             </li>
                  		</c:if>
                  	</c:forEach>
                  </c:forEach>
                </ul>
              </li>
               <li class=" nav-item"><a href="${pageContext.request.contextPath}/empl/member/emplList.do"><i class="fa fa-address-book-o"></i><span class="menu-title" data-i18n="nav.templates.main">사원정보 조회</span></a>
               </li>
              <li class=" navigation-header"><span data-i18n="nav.category.layouts">게시판</span><i class="ft-more-horizontal ft-minus" data-toggle="tooltip" data-placement="right" data-original-title="Layouts"></i>
              </li>
              <li class=" nav-item"><a href="${pageContext.request.contextPath}/empl/frb/frbList.do"><i class="fa fa-pencil-square-o"></i><span class="menu-title" data-i18n="nav.page_layouts.main">자유게시판</span></a>
              </li>
              <li class=" nav-item"><a href="${pageContext.request.contextPath}/empl/pblanc/pblancList.do"><i class="fa fa-newspaper-o"></i><span class="menu-title" data-i18n="nav.navbars.main">공고게시판</span><span class="badge badge badge-success float-right mr-2">New</span></a>
              </li>
              <li class=" nav-item"><a href="${pageContext.request.contextPath}/empl/notice/noticeList.do"><i class="icon-directions"></i><span class="menu-title" data-i18n="nav.vertical_nav.main">공지사항</span></a>
              </li>
              <li class=" nav-item"><a href="#"><i class="icon-question"></i><span class="menu-title" data-i18n="nav.horz_nav.main">문의게시판</span></a>
              	<ul class="menu-content">
                      <li><a class="menu-item" href="${pageContext.request.contextPath}/empl/qna/qnaList.do" data-i18n="nav.templates.horz.classic">질문게시판</a>
                      </li>
                      <li><a class="menu-item" href="${pageContext.request.contextPath}/empl/chatbot/chatbotList.do" data-i18n="nav.templates.horz.classic">FAQ</a>
                      </li>
                </ul>
              </li>
              <li class=" navigation-header"><span data-i18n="nav.category.general">커뮤니티</span><i class="ft-more-horizontal ft-minus" data-toggle="tooltip" data-placement="right" data-original-title="General"></i>
              </li>
              <li class=" nav-item"><a href="#"><i class="fa fa-comments-o"></i><span class="menu-title" data-i18n="nav.footers.main">메신저</span></a>
 				<ul class="menu-content">
                      <li><a class="menu-item" href="${pageContext.request.contextPath}/empl/chtt/chttList.do" data-i18n="nav.templates.horz.classic">채팅</a>
                      </li>
                </ul>
              </li>
            </ul>
          </div>
       </div>
</body>
</html>