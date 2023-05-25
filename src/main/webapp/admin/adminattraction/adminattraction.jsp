<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ include file="../header.jsp" %>  
<div style="clear: both;"></div>
<article>
	<div class="att_title_img">
      	<img src="images/attraction_images/att_title_img.jpg" width="100%" height="485px" style="filter:brightness(70%)">
    	<h1 id="att_title_text">어트랙션 관리</h1>
    	<h1 id="att_title_exp"> 어트랙션 관리하는 페이지 입니다.</h1>
	</div>
	<div id="att_search">
	<a href="world.do?command=insertAttractionForm">놀이기구 추가</a>
	</div>
	<div id="at_arg_A"></div>
	<div id="att_back">
		<c:forEach var="AttractionVO" items="${aseqList}">
			<div id="att_list">
				<a href="world.do?command=adminattractionDetail&aseq=${AttractionVO.aseq}">
					<img src="images/attraction_images/${AttractionVO.image}"/>
					<h3>${AttractionVO.atname}</h3>
				</a>
			</div>
		</c:forEach>
		<div id="at_arg"></div>
	</div>
</article>

<%@ include file="../footer.jsp" %>