<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<title>풀캘린더</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fullcalendar/fullcalendar.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fullcalendar/fullcalendar.print.min.css" media="print">
<link href= "${pageContext.request.contextPath}/resources/fullcalendar/fullcalendar.css' rel='stylesheet"/>
<script type="text/javascript" src='${pageContext.request.contextPath}/resources/fullcalendar/lib/moment.min.js'></script>
<script type="text/javascript" src='${pageContext.request.contextPath}/resources/fullcalendar/lib/jquery.min.js'></script>
<script type="text/javascript" src='${pageContext.request.contextPath}/resources/fullcalendar/fullcalendar.js'></script>
<script   type="text/javascript" src="${pageContext.request.contextPath}/resources/fullcalendar/locale-all.js"></script>
<style>
 body {
    padding: 0; 
   font-size: 14px; 
 } 

   #calendar { 
      background-color:white;
      padding:10px;
      max-width: 1000px; 
      margin: 0 auto; 
   } 
</style>



</head>
<body>
<div class="content-body" style="width: 1300px;  ">
   <div id='calendar'></div>
   <script type="text/javascript">
   var currentDate = dpDate();
   $('#calendar').fullCalendar
   ({
	   header : {
	         left : 'prev,next today',
	  center : 'title',
	  right : null
	     },
	     defaultDate: currentDate,
	     lang: 'ko',
	     buttonIcons: false, // show the prev/next text
	     weekNumbers: true,
	     editable: false,
	     eventLimit: true, // allow "more" link when too many events
	     events: function(start, end, timezone, callback){
			 var obj = [];
	         $.post( "${pageContext.request.contextPath}/empl/dy_schdul/date.do", {'prjct_id' : '${prjct_id}','LoginId' : '${LoginId}'} , function( data ) {
	  		   $.each(data, function(index, value){
	  			   if(value.issue_nm != null){
		  			   obj.push({
		  					id : index, 
		  					title : value.issue_nm,
		  					start : new Date(value.issue_regist_day),
		  					end : new Date(value.issue_compt),
		  					backgroundColor: "#82fa58",
		     				borderColor: "#82fa58"
		             	  });
	  			   }
	  			   if(value.flaw_nm != null){
		  			   obj.push({
		  					id : index, 
		  					title : value.flaw_nm,
		  					start : new Date(value.flaw_regist_day),
		  					end : new Date(value.flaw_compt),
		  					backgroundColor: "#facc2e",
		     				borderColor: "#facc2e"
		             	  });
	  			   }
	  			   if(value.wbs_work_nm != null){
		  			   obj.push({
		  					id : index, 
		  					title : value.wbs_work_nm,
		  					start : new Date(value.wbs_strt),
		  					end : new Date(value.wbs_compt),
		  					backgroundColor: "#5882fa",
		     				borderColor: "#5882fa"
		             	  });
	  			   }
	  		   });
             callback(obj)
	  		});
         }
   });

    function dpDate(){
         var now = new Date(); 
         var years = now.getFullYear(); 
         var month = now.getMonth() + 1; 
         var day = now.getDay(); 
         var date = years + "-" + month + "-" + day;
         return date;
      };
   </script>
</div>
</body>
</html>
