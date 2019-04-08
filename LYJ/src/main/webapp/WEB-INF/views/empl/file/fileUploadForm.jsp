<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
$(function(){
	$('form:eq(1)').submit(function(){
		var flag = true;
		return flag;
	});
});
</script>
</head>
<body>
<!-- 
   브라우저의 보안정책 : 브라우저는 클라이언트 시스템의 파일 시스템 내 존재하는 파일을 대상으로 추가, 삭제, 수정이 불가능
   파일업로드 규칙 : 파일 업로드 가능한 자원 - <form> or $.ajax()
                 <form method="POST" enctype="multipart/form-data">
                 
 -->
<form action="${pageContext.request.contextPath}/file/fileUpload.do" 
   enctype="multipart/form-data"
   method="POST">
   <table>
      <tr>
         <td>아이디</td>
         <td><input type="text" name="mem_id" /></td>
      </tr>
      <tr>
         <td>성명</td>
         <td><input type="text" name="mem_name" /></td>
      </tr>
      <tr>
         <td>파일</td>
         <td><input type="file" name="file" /></td>
      </tr>
      <tr>
         <td colspan="2">
            <input type="submit" value="파일전송" />
         </td>
      </tr>
   </table>
</form>
<img src="/files/${param.fileName}" alt="" width="200" height="150" 
	onclick="javascript:location.href='${pageContext.request.contextPath}/file/fileDownload.do?fileName=${param.fileName}';" />
</body>
</html>