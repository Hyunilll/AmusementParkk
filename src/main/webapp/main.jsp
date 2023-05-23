<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>



<div id="main_view">
    <div id="main_imgs">
   			<img src="images/mainimgs1.jpg" >
        	<img src="images/mainimgs2.jpg" >
        	<img src="images/mainimgs3.jpg">
        	<img src="images/mainimgs4.jpg">
        	<img src="images/mainimgs5.jpg">
        	<img src="images/mainimgs6.jpg">
        	<img src="images/mainimgs7.jpg">
        	<img src="images/mainimgs8.jpg">
    </div>
    <div id ="remote">
        <ul>
            <li>1</li>
            <li>2</li>
            <li>3</li>
            <li>4</li>
            <li>5</li>
            <li>6</li>
            <li>7</li>
            <li>8</li>
        </ul>
        <div class="auto">▶</div>
    </div>
</div>

<div id="mainTodayArea" >
	<a href="world.do?command=guide" target='_blank'>
 	<img src="images/clock.png" width="45" height="45" ><br>오늘의 파크 운영시간   10:00~21:00
	</a>
</div>

					<!--  절취선  -->	

<div class="mainbox">                                         <!-- 제일 큰 상자 -->
	<div class="mainCon mainCon1"><!-- 나에게 꼭 맞는 혜택 -->     <!-- 첫번째 상자  -->
		<p class="mainTit"><span>자신에게 맞는 혜택을</span> 알아볼까요?</p><br>
		<p class="mainTxt">현재 진행 중인 할인혜택을 알아보세요.</p>
		 <!-- 두번째 상자 -->
		<div class="boxArea">                               <!-- 세번째상자 -->
			<div class="box-tr">
				<div class="box-td">
					<a href="">
						<span class="imggg"><img src="images/card.png" width="248" height="198"/></span>
						<span class="price1">월드카드로 최대 10만원 캐시백 혜택 챙겨요! 40000원</span>		
					</a>
				</div>
						
				<div class="box-td">
					<a href="">
						<span class="imggg"><img src="images/point.jpg" width="248" height="198"/></span>
						<span class="price1">월드 최대 30% 할인 + 이용금액 100% 캐시백까지</span>
					</a>
				</div>

				<div class="box-td">
					<a href="">
						<span class="imggg"><img src="images/npay.jpg" width="248" height="198"/></span>
						<span class="price1">가정의달은, 꼭 네이버페이로 39,900원</span>
					</a>
				</div>

				<div class="box-td">
					<a href="">
						<span class="imggg"><img src="images/family.jpg" width="248" height="198"/></span>
						<span class="price1">패밀리 패키지(어른+어린이) 70,000원</span>
					</a>
				</div>
			
			</div>
				
			<div class="box-tr">
				<div class="box-td">
					<a href="">
						<span class="imggg"><img src="images/friend.png" width="248" height="198"/></span>
						<span class="price1">프랜드 패키지(어른+어른) 90,000원</span>
					</a>
				</div>

				<div class="box-td">
					<a href="">
						<span class="imggg"><img src="images/fastfast.jpg" width="248" height="198"/></span>
						<span class="price1">패스트패스 100,000원</span>
					</a>
				</div>

				<div class="box-td">
					<a href="">
				 		<span class="imggg"><img src="images/springspring.jpg" width="248" height="198"/></span>
						<span class="price1">스프링데이 30,000원</span>			
					</a>
				</div>

				<div class="box-td">
					<a href="">
						<span class="imggg"><img src="images/76419_59366_5741.jpg" width="248" height="198"/></span>
						<span class="price1">교복 패키지 50,000원</span>
					</a>
				</div>
			</div>
		</div>
     </div>
</div>
				<!--  절취선  -->

<div id="mainback">
	<div id="maintitle">재미있고 즐거운&nbsp;<span style="font-weight:bold;">다양한 어트랙션!</span></div>
	<div class="tag">
		<ul>
			<li>아이와 함께</li>
			<li>야외에서 신나게</li>
			<li>실내에서 쾌적하게</li>
		</ul>
	</div>
	<h1>Best Attraction</h1>
	<div id="mainimg">
			<c:forEach items="${bestList}" var = "AttractionVO">
				<div class="img">
				<a href="">			
						<img src="images/attraction_images/${AttractionVO.image}"/>
						<h2>${AttractionVO.atname }</h2>
				</a>
				</div>
			</c:forEach>
	</div>

	</div>
	<div class="tag">
		<ul>
			<li><a href='world.do?command=attractionForm'>더 많은 어트렉션 보기</a></li>
			<li><a href='world.do?command=guide'>운휴 정보 보러 가기</a></li>
		</ul>
	</div>
</div>



				<!--  절취선  -->

<h1 style=" text-align: center; font-size: 300%;">-------What's New-------</h1>  
<h3 style=" text-align: center;">꿈과 환상의 나라로 어서오세요</h3>

<div id="main_view_">              
	<div id="parade">
	   <a href="world.do?command=parade">
	        <div class="scale">
	        	<img src="images/parade1.jpg" width="250" height="170" >
	        </div>
	        <div class="title">
	        	<br><h3>카니발 판타지 퍼레이드</h3>
	        </div>
	    </a>
	</div>       
	<div id="parade">
	   <a href="world.do?command=parade">
	        <div class="scale"><img src="images/parade2.jpg" width="250" height="170" ></div>
	        <div class="title"><h3>레니의 대모험~<br>드래곤 성을 찾아서~</h3></div>
	    </a>
	</div>       
	<div id="parade">
	   <a href="world.do?command=parade">
	        <div class="scale"><img src="images/parade3.jpg" width="250" height="170" ></div>
	        <div class="title"><br><h3>문라이트 퍼레이드</h3></div>
	    </a>
	</div>       
	<div id="parade">
	   <a href="world.do?command=parade">
	        <div class="scale"><img src="images/parade4.jpg" width="250" height="170" ></div>
	        <div class="title"><br><h3>타임 오디세이</h3></div>
	    </a>
	</div> 
</div>      

				
				
				<!--  절취선  -->
				
<br><br><br><br><br><br><br>

<%@ include file="footer.jsp" %>