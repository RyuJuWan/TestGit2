<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type='text/javascript'>
$(function(){
    $('table tr:gt(0)').click(function(){//view
//        var rnum = $(this).find('td:eq(0)').text();
        var prpsl_id = $(this).find('td:eq(0) input').val();
      
       $(location).attr('href',
          '${pageContext.request.contextPath}/empl/prpsl/prpslView.do?prpsl_id='
                + prpsl_id);
       });

    $('#btnInsert').click(function(){//insert
//     	if(eval('${ empty LOGIN_MEMBERINFO.mem_id}')){
// 	  		 BootstrapDialog.show({
// 	  			    title: '로그인',
// 	  			    message: '로그인'
// 	  		}); 
// 	  		 return false;
// 	  	 }
//     	$(location).attr('href', '${pageContext.request.contextPath}/user/freeboard/freeboardForm.do');
        location.href = '${pageContext.request.contextPath}/empl/prpsl/prpslForm.do';
        return true;
     })
   });
</script>


</head>
<body>

 <div class="content-body"><!-- Zero configuration table -->
<section id="configuration">
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title">프로젝트 제안서</h4>
                    <a class="heading-elements-toggle"><i class="fa fa-ellipsis-v font-medium-3"></i></a>
                    <div class="heading-elements">
                        <ul class="list-inline mb-0">
                            <li><a data-action="collapse"><i class="ft-minus"></i></a></li>
                            <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                            <li><a data-action="expand"><i class="ft-maximize"></i></a></li>
                            <li><a data-action="close"><i class="ft-x"></i></a></li>
                        </ul>
                        
                    </div>
                </div>
                <div class="card-content collapse show">
                    <div class="card-body card-dashboard">
                       	<form action="${pageContext.request.contextPath }/empl/prpsl/prpslList.do" method="post" class="form-inline pull-right" >
								<select class="form-control" name="search_keycode" style="margin: 3px; height: 40px" >
									<option>검색조건</option>
									<option value="TOTAL">전체</option>
									<option value="TITLE">제목</option>
									<option value="CONTENT">내용</option>
									<option value="WRITER">작성자</option>
								</select>
								<input id="search_keyword" name="search_keyword" type="text" placeholder="검색어 입력..." class="form-control" />
							    <button type="submit" class="btn btn-warning btn-min-width mr-1 mb-1" style="margin-left:3px; height: 40px; margin-top: 12px">검색</button>
							    <button type="button" id="btnInsert" class="btn btn-danger btn-min-width mr-1 mb-1" value="계획서등록" style="  margin-top: 12px; width: 100px;height: 40px ">게시글 등록</button>
						</form>
		                
                        <table class="table table-striped table-bordered zero-configuration"  >
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>제안서명</th>
                                    <th>사번</th>
                                    <th>작성일자</th>
                                    <th>프로젝트시작일</th>
                                    <th>프로젝트마감일</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${prpslList }" var="prpsl">
										<tr>
											<td><input type="hidden" name="prpsl_id" value="${prpsl.prpsl_id}"/>${prpsl.rnum}</td>
<%-- 											<td>${prpsl.prpsl_id}</td> --%>
											<td>${prpsl.prpsl_nm}</td>
											<td>${prpsl.prpsl_empl}</td>
											<td>${prpsl.prpsl_wrting_date}</td>
											<td>${prpsl.prpsl_prjct_start}</td>
											<td>${prpsl.prpsl_prjct_clos}</td>
										</tr>
									</c:forEach>
                            </tbody>
                        </table>
                         ${paging}
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
    </div>
</body>
</html>