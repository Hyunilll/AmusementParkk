<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>
<%@ include file="../sub_image_menu.jsp" %>


	<div class="operation_box">
		<div class="operation_box_title">
			<h2 style="text-align:center;">운영/운휴</h2>
		</div>
		<div class="operation_date_box">
				<c:set var="now" value="<%=new java.util.Date() %>"></c:set>
				<h2 style="text-align:center;">
					<fmt:formatDate value="${now }"></fmt:formatDate>
				</h2>
		</div>
		
		
		<div class="operation_time_box">
			<div class="time_box_title">운영 시간</div>
			<div class="time_box_time"> 10:00 ~ 22:00 </div>
		</div>
		
		<br><br>
		<h2 style="font-size:30px; text-align:center;">오늘의 운휴시설</h2> 
		
		<div id="rest_box">
			<c:forEach items="${restList}" var = "AttractionVO">
				<div class="rest_img">
				<a href="world.do?command=attractionDetail&aseq=${AttractionVO.aseq}">		
						<img src="images/attraction_images/${AttractionVO.image}"/>
						<h2>${AttractionVO.atname }</h2>
				</a>
				</div>
			</c:forEach>
		</div>
	
		<div class="operation_box_footer">
			<div class="operation_box_footer_images"><img src="images/operate_imgs1.jfif" width="100" height="100"></div>
			<div class="operation_box_footer_text">
				<ul><br><br>
					<li>기상상태에 따라 (0℃ 이하 또는 30℃ 이상, 7~14㎧ 이상의 풍속, 0.2㎜ 이상의 비가 내리는 경우)
						매직아일랜드 일부 어트랙션 운행이 중단될 수 있습니다.</li>
						</br></br>
					<li>기상상태와 별개로 현장 상황에 따라 예고 없이 운휴하거나 중간 점검을 할 수 있습니다</li>
				</ul>
			</div>
		</div>
	</div>


<%@ include file="../footer.jsp" %>