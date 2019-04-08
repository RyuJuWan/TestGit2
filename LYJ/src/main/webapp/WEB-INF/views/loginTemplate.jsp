<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="loading" lang="en" data-textdirection="ltr">
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
	    <meta name="description" content="Robust admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template.">
	    <meta name="keywords" content="admin template, robust admin template, dashboard template, flat admin template, responsive admin template, web app, crypto dashboard, bitcoin dashboard">
	    <meta name="author" content="PIXINVENT">
	    <title>Analytics Dashboard - Robust - Responsive Bootstrap 4 Admin Dashboard Template for Web Application</title>
	    <link rel="apple-touch-icon" href="${pageContext.request.contextPath }/app-assets/images/ico/apple-icon-120.png">
	    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath }/app-assets/images/ico/favicon.ico">
	    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i%7CMuli:300,400,500,700" rel="stylesheet">
	    <!-- BEGIN VENDOR CSS-->
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/app-assets/css/vendors.css">
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/app-assets/vendors/css/charts/jquery-jvectormap-2.0.3.css">
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/app-assets/vendors/css/charts/morris.css">
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/app-assets/vendors/css/extensions/unslider.css">
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/app-assets/vendors/css/weather-icons/climacons.min.css">
	    <!-- END VENDOR CSS-->
	    <!-- BEGIN ROBUST CSS-->
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/app-assets/css/app.css">
	    <!-- END ROBUST CSS-->
	    <!-- BEGIN Page Level CSS-->
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/app-assets/css/core/menu/menu-types/vertical-content-menu.css">
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/app-assets/css/core/colors/palette-gradient.css">
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/app-assets/css/plugins/calendars/clndr.css">
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/app-assets/css/core/colors/palette-climacon.css">
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/app-assets/css/pages/users.css">
	    <!-- END Page Level CSS-->
	    <!-- BEGIN Custom CSS-->
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/assets/css/style.css">
	    <!-- END Custom CSS-->
	    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
<%-- 	    <script src="${pageContext.request.contextPath}/app-assets/js/core/libraries/jquery.min.js"></script> --%>
	    <script src='${pageContext.request.contextPath }/js/cookieControl.js'></script>
	    <script src='${pageContext.request.contextPath }/js/validation.js'></script>
	</head>
<body>
	<tiles:insertAttribute name="content"></tiles:insertAttribute>
	
	<!-- BEGIN VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/vendors.min.js"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/ui/jquery.sticky.js"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/charts/jquery.sparkline.min.js"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/ui/headroom.min.js"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/icheck/icheck.min.js"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendors/js/forms/validation/jqBootstrapValidation.js"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN ROBUST JS-->
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app-menu.js"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/core/app.js"></script>
    <!-- END ROBUST JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/ui/breadcrumbs-with-stats.js"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/scripts/forms/form-login-register.js"></script>
    <!-- END PAGE LEVEL JS-->
</body>
</html>