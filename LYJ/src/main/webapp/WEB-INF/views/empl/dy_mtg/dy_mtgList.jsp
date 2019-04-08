<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
    text:hover {
        stroke: black;
    }
</style>
<script src="http://d3js.org/d3.v3.min.js"></script>
<script src="${pageContext.request.contextPath}/js/d3.layout.cloud.js"></script>
<script type="text/javascript">
$(function(){
   $('#btnMtgForm').click(function(){
	   location.href = '${pageContext.request.contextPath}/empl/dy_mtg/dy_mtgForm.do?prjct_id=${prjct_id}';
   });
   
   $('button[name="btnView"]').click(function(){
	   location.href = "${pageContext.request.contextPath}/empl/dy_mtg/dy_mtgView.do?prjct_id=${prjct_id}&mtg_id=" + $(this).val();
   });
});
</script>
</head>
<body>
<div class="content-body"><!-- Zero configuration table -->
<section id="image-grid" class="card">
  <div class="card-header">
      <h4 class="card-title">회의록</h4>
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
     <form action="/empl/dy_mtg/dy_mtgList.do?prjct_id=${prjct_id}" method="post" class="form-inline pull-right" style="margin-left: 30px" >
          <select class="form-control" name="search_keycode" style="margin: 3px; height: 40px" >
          	 <option>검색조건</option>
             <option value="TOTAL">전체</option>
             <option value="TITLE">제목</option>
             <option value="CONTENT">내용</option>
          </select>
          <input id="search_keyword" name="search_keyword" type="text" placeholder="검색어 입력..." class="form-control" style="height: 40px"/>
          <button type="submit" class="btn btn-warning btn-min-width mr-1 mb-1" style="margin-left:3px; height: 40px; margin-top: 12px">검색</button>
          <button type="button" id="btnMtgForm" class="btn btn-danger btn-min-width mr-1 mb-1" value="회의록등록" style="  margin-top: 12px; width: 100px;height: 40px " >회의록 작성</button>
    </form>
  <div class="card-content">
    <div class="card-body  my-gallery" itemscope itemtype="http://schema.org/ImageGallery">
    
      <div class="card-deck-wrapper">
      		<c:set var="word_num" value="1"></c:set>
	        <c:forEach items="${mtgPageList}" var="mtgPageInfo">
		        <div class="card-deck">
		          <figure class="card card-img-top border-grey border-lighten-2" itemprop="associatedMedia" itemscope itemtype="http://schema.org/ImageObject">
		            <div id="cloud${word_num}"></div>
		            <script type="text/javascript">
		            	var weight = 30, width = 1500, height = 600;
		            	var fill = d3.scale.category20();
		            	d3.csv("/empl/file/${mtgPageInfo.mtg_id}.csv", function(d){
		            		return {
		            			text : d.noun,
		            			size : d.frequency*weight*0.5
		            		}
		            	},
		            	function(data) {
		            		d3.layout.cloud().size([width, height]).words(data)
		            		  .rotate(0)
		            		  .font("Impact")
		            		  .fontSize(function(d) { return d.size; })
		            		  .on("end", draw)
		            		  .start();
		            		
		            		function draw(words) {
		            			d3.select('#cloud${word_num}').append("svg")
		            			  .attr("width", width)
		            			  .attr("height", height)
		            			  .append("g")
		            			    .attr("transform", "translate(" + width/2 + "," + height/2 + ")")
		            	          .selectAll("text")
		            	              .data(words)
		            	          .enter().append("text")
		            	              .style("font-size", function(d) { return d.size + "px"; })
		            	              .style("font-family", "Impact")
		            	              .style("fill", function(d, i) { return fill(i); })
		            	              .attr("text-anchor", "middle")
		            	              .attr("transform", function(d) {
		            	                return "translate(" + [d.x, d.y] + ")rotate(" + d.rotate + ")";
		            	              })
		            	          .text(function(d) { return d.text; });
		            		}
		            	});
		            </script>
		            <div class="card-body px-0 text-center" style="  border-top: 1px solid lightgrey;">
		                    <h4 class="card-title">${mtgPageInfo.rnum}. &nbsp; ${mtgPageInfo.mtg_nm}</h4>
		                    <h6 class="card-subtitle text-muted">회의일자 : ${mtgPageInfo.mtg_dt}</h6>
		                <div class="card-body">
		                     <button type="button" name="btnView" class="btn btn-lg btn-block btn-danger" value="${mtgPageInfo.mtg_id}"><i class="ft-user"></i>보기</button>
		                </div>
		            </div>
		          </figure>
		        </div>
      			<c:set var="word_num" value="${word_num + 1}"></c:set>
	        </c:forEach>
      </div>
	${pagingUtil}
    </div>

  </div>
</section>
</div>
</body>
</html>