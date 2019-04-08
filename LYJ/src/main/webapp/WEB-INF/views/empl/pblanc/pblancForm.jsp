<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$('#btnList').click(function(){
		location.href = '${pageContext.request.contextPath}/user/frb/frbList.do';
	});
});
</script>
</head>
<body>

<form action="" class="form-horizontal">
<div class="content-body"><!-- Basic CKEditor start -->
<section id="horizontal-form-layouts">
	<div class="row">
	    <div class="col-md-12">
	        <div class="card">
	            <div class="card-header">
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
	            <div class="card-content collpase show">
	                <div class="card-body">
						<div class="card-text">
						</div>
	                    <form class="form form-horizontal">
	                    		<h4 class="form-section"><i class="ft-clipboard"></i>게시글 등록</h4>
	                    	<div class="form-body" style="margin-right: 300px">
			                    <div class="form-group row">
	                            	<label class="col-md-3 label-control" for="projectinput1">제목</label>
		                            <div class="col-md-9">
		                            	<input type="text" id="projectinput1" class="form-control" placeholder="First Name" name="fname" style="width: 900px">
		                            </div>
		                        </div>

		                        <div class="form-group row">
									<label class="col-md-3 label-control" for="projectinput5">작성자</label>
									<div class="col-md-9">
		                            	<input type="text" id="projectinput5" class="form-control" placeholder="Company Name" name="company" style="width: 600px">
		                            </div>
		                        </div>

								<div class="form-group row">
									<label class="col-md-3 label-control">Select File</label>
									<div class="col-md-9">
										<label id="projectinput8" class="file center-block">
											<input type="file" id="file">
											<span class="file-custom"></span>
										</label>
									</div>
								</div>
								<div class="form-group" style="margin-left: 300px">
									<div class="card-content collapse show">
									<div class="card-body">
										<div class="form-group">
											<textarea name="ckeditor" id="ckeditor" cols="30" rows="15" class="ckeditor">
												<h1><img alt="Saturn V carrying Apollo 11" class="right" src="../../../app-assets/images/elements/01.png" height="250" /> Apollo 11</h1>
												<p><strong>Apollo 11</strong> was the spaceflight that landed the first humans, Americans <a href="http://en.wikipedia.org/wiki/Neil_Armstrong">Neil Armstrong</a> and <a href="http://en.wikipedia.org/wiki/Buzz_Aldrin">Buzz Aldrin</a>, on the Moon on July 20, 1969, at 20:18 UTC. Armstrong became the first to step onto the lunar surface 6 hours later on July 21 at 02:56 UTC.</p>
												<p>Armstrong spent about <s>three and a half</s> two and a half hours outside the spacecraft, Aldrin slightly less; and together they collected 47.5 pounds (21.5&nbsp;kg) of lunar material for return to Earth. A third member of the mission, <a href="http://en.wikipedia.org/wiki/Michael_Collins_(astronaut)">Michael Collins</a>, piloted the <a href="http://en.wikipedia.org/wiki/Apollo_Command/Service_Module">command</a> spacecraft alone in lunar orbit until Armstrong and Aldrin returned to it for the trip back to Earth.</p>
												<h2>Broadcasting and <em>quotes</em> <a id="quotes" name="quotes"></a></h2>
												<p>Broadcast on live TV to a world-wide audience, Armstrong stepped onto the lunar surface and described the event as:</p>
												<blockquote>
												<p>One small step for [a] man, one giant leap for mankind.</p>
												</blockquote>
				
												<p>Apollo 11 effectively ended the <a href="http://en.wikipedia.org/wiki/Space_Race">Space Race</a> and fulfilled a national goal proposed in 1961 by the late U.S. President <a href="http://en.wikipedia.org/wiki/John_F._Kennedy">John F. Kennedy</a> in a speech before the United States Congress:</p>
				
												<blockquote>
												<p>[...] before this decade is out, of landing a man on the Moon and returning him safely to the Earth.</p>
												</blockquote>
				
												<h2>Technical details <a id="tech-details" name="tech-details"></a></h2>
				
												<table align="right" border="1" bordercolor="#ccc" cellpadding="5" cellspacing="0" style="border-collapse:collapse">
													<caption><strong>Mission crew</strong></caption>
													<thead>
														<tr>
															<th scope="col">Position</th>
															<th scope="col">Astronaut</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td>Commander</td>
															<td>Neil A. Armstrong</td>
														</tr>
														<tr>
															<td>Command Module Pilot</td>
															<td>Michael Collins</td>
														</tr>
														<tr>
															<td>Lunar Module Pilot</td>
															<td>Edwin &quot;Buzz&quot; E. Aldrin, Jr.</td>
														</tr>
													</tbody>
												</table>
				
												<p>Launched by a <strong>Saturn V</strong> rocket from <a href="http://en.wikipedia.org/wiki/Kennedy_Space_Center">Kennedy Space Center</a> in Merritt Island, Florida on July 16, Apollo 11 was the fifth manned mission of <a href="http://en.wikipedia.org/wiki/NASA">NASA</a>&#39;s Apollo program. The Apollo spacecraft had three parts:</p>
				
												<ol>
													<li><strong>Command Module</strong> with a cabin for the three astronauts which was the only part which landed back on Earth</li>
													<li><strong>Service Module</strong> which supported the Command Module with propulsion, electrical power, oxygen and water</li>
													<li><strong>Lunar Module</strong> for landing on the Moon.</li>
												</ol>
				
												<p>After being sent to the Moon by the Saturn V&#39;s upper stage, the astronauts separated the spacecraft from it and travelled for three days until they entered into lunar orbit. Armstrong and Aldrin then moved into the Lunar Module and landed in the <a href="http://en.wikipedia.org/wiki/Mare_Tranquillitatis">Sea of Tranquility</a>. They stayed a total of about 21 and a half hours on the lunar surface. After lifting off in the upper part of the Lunar Module and rejoining Collins in the Command Module, they returned to Earth and landed in the <a href="http://en.wikipedia.org/wiki/Pacific_Ocean">Pacific Ocean</a> on July 24.</p>
				
												<hr />
												<p><small>Source: <a href="http://en.wikipedia.org/wiki/Apollo_11">Wikipedia.org</a></small></p>
				
											</textarea>
										</div>
									</div>
								</div>
								</div>
							</div>

	                        
	                        <div class="form-actions">
								<button type="button" class="btn btn-warning mr-1"><i class="ft-x"></i> 취소</button>
								<button type="submit" class="btn btn-primary"><i class="fa fa-check-square-o"></i> 등록</button>
								<button type="button" id="btnList" class="btn btn-danger btn-min-width mr-1 mb-1" style="float: left" value="목록"><i class="fa fa-eye">목록</i></button>
							</div>
	                    </form>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
</section>


  </body>
</html>