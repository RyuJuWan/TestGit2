<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
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
<%-- 	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/app-assets/css/plugins/calendars/clndr.css"> --%>
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/app-assets/css/core/colors/palette-climacon.css">
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/app-assets/css/pages/users.css">
	    <!-- END Page Level CSS-->
	    <!-- BEGIN Custom CSS-->
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/assets/css/style.css">
	    <!-- END Custom CSS-->
	    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
	    <script src='${pageContext.request.contextPath }/js/validation.js'></script>
	    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	</head>
<body class="vertical-layout vertical-content-menu 2-columns   menu-expanded fixed-navbar" data-open="click" data-menu="vertical-content-menu" data-col="2-columns">
	<tiles:insertAttribute name="header"></tiles:insertAttribute>
	<div id="wrapper" >
		<tiles:insertAttribute name="content_header"></tiles:insertAttribute>  
		<div id="page-wrapper">
			<div class="page-content">
				<tiles:insertAttribute name="content"></tiles:insertAttribute>
			</div>
			<tiles:insertAttribute name="footer"></tiles:insertAttribute>
		</div>
	</div>
    <!-- BEGIN VENDOR JS-->
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/vendors.min.js"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/forms/spinner/jquery.bootstrap-touchspin.js??v=<%=System.currentTimeMillis() %>"></script>
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/ui/jquery.sticky.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/charts/jquery.sparkline.min.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/ui/headroom.min.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/editors/ckeditor/ckeditor.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/extensions/jquery.knob.min.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/js/scripts/extensions/knob.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/charts/raphael-min.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/charts/morris.min.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/charts/jvector/jquery-jvectormap-2.0.3.min.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/charts/jvector/jquery-jvectormap-world-mill.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/data/jvector/visitor-data.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/charts/chart.min.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/charts/jquery.sparkline.min.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/extensions/unslider-min.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/gallery/masonry/masonry.pkgd.min.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/gallery/photo-swipe/photoswipe.min.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/gallery/photo-swipe/photoswipe-ui-default.min.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/charts/echarts/echarts.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/js/core/libraries/jquery_ui/jquery-ui.min.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/forms/select/select2.min.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/tables/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/tables/datatable/dataTables.responsive.min.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/tables/datatable/dataTables.rowReorder.min.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/forms/icheck/icheck.min.js"></script>
   	<script src="${pageContext.request.contextPath }/app-assets/vendors/js/forms/toggle/bootstrap-checkbox.min.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/forms/toggle/bootstrap-switch.min.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/vendors/js/forms/toggle/switchery.min.js"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN ROBUST JS-->
    <script src="${pageContext.request.contextPath }/app-assets/js/core/app-menu.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/js/core/app.js"></script>
    <!-- END ROBUST JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    
    <script src="${pageContext.request.contextPath }/app-assets/js/scripts/charts/echarts/advance/tornado.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/js/scripts/pages/dashboard-analytics.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/js/scripts/editors/editor-ckeditor.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/js/scripts/gallery/photo-swipe/photoswipe-script.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/js/scripts/charts/echarts/advance/timeline.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/js/scripts/charts/echarts/advance/timeline-options.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/js/scripts/charts/echarts/advance/time-data.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/js/scripts/charts/echarts/advance/candlestick-multi-level-control.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/js/scripts/charts/echarts/advance/dynamic-data.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/js/scripts/charts/echarts/advance/event-river.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/js/scripts/charts/echarts/advance/eventRiver2-data.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/js/scripts/charts/echarts/advance/multiple-series-rainbow.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/js/scripts/charts/echarts/advance/treemap.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/js/scripts/charts/echarts/advance/word-cloud.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/js/scripts/pages/project-bug-list.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/js/scripts/pages/project-summary-bug.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/js/scripts/ui/jquery-ui/date-pickers.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/js/scripts/ui/breadcrumbs-with-stats.js"></script> 
    <script src="${pageContext.request.contextPath }/app-assets/js/scripts/forms/checkbox-radio.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/js/scripts/forms/switch.js"></script>
    <script src="${pageContext.request.contextPath }/app-assets/js/scripts/forms/input-groups.js"></script>
    <!-- END PAGE LEVEL JS-->
    
</body>
</html>