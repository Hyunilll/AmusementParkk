<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<link href="order/order.css" rel="stylesheet">  
<script src="order/order.js"></script>

<style>
	.container {position:relative; width:900px;} 
</style>
 
 <form name="formm" method="post">
	
<div id =" wrap" style=" width:100%; height:100%; background: lightgray;">
	<div id = "order_box">
		<div class="order_box_select2">
			<div class="order_box_title" style="margin-top:7px;">
				<h2>티켓 예매</h2>
			</div>
			
			<!--  인원선택 -->
			<div class="order_box_date">
				<div class="order_box_date_text" style="margin-top:10px;">
					<div id="selectedDate" class="selected-date"></div>
				</div>
				<div class="order_box_date_date" style="margin-top:10px;">
					<div class="calendarImage" onclick="showCalendar()">
						<img src="images/ticket_images/calendar.png" style="width:40px; height:40px;">
					</div>
					<div id="calendar"  class="calendar">
						<input type="hidden" id="calendar" name="visitdate">
					</div>	
				</div>
			</div>
			
			<!--  달력 선택 날짜 표기 -->
			<div class="order_selectdate">
				<h2>인원 선택/방문일자</h2>
			</div>
			
			<!-- 수량 표시 -->
			<div class="order_quantity">
				<div class="order_quantity_text">
				<h3>어른</h3>
				<p>만19세이상</p>
				</div>
				<div class="order_quantity_box">
					<input type='button' style="width:30px;" onclick='count("plus")'value='+'/>
					<div id='result' >0
						<input type="hidden" id="result" name="aquantity">
					</div>
					 <!-- $('#result').attr('value','Hello');-->
					<input type='button' style="width:30px;" onclick='count("minus")'value='-'/>
				</div>	 
				<div class="order_quantity_text">
				<h3>청소년</h3>
				<p>만13세~만18세</p>
				</div>
				<div class="order_quantity_box">
					<input type='button' style="width:30px;" onclick='count2("plus")'value='+'/>
					
					<div id='result2' >0
						<input type="hidden" id ="result2" name="cquantity">
					</div>
					<input type='button' style="width:30px;" onclick='count2("minus")'value='-'/>
				 </div>
					
			</div>
			<!-- 
			<h2 style="font-size:120%; text-align:center;">total</h2><br>
			<div class="order_total"></div>
			 -->
			<div id="board-list">
		        <div class="container">
		            <table class="board-table" style="font-size:20px">  
		                <tr>
		                    <th><a href="#!" onclick="toggleAnswer('answer1')">&nbsp;&nbsp;&nbsp;취소/환불</a></th>      
		                </tr>   
		                <tr id="answer1" style="display:none">
		               		 
		                	<th style="font-size:15px; font-weight:normal;background:#F7F7F7;"><br>
								<b>예매취소 안내</b> <br>
								<b>온라인 예매 시 선택한 날짜에만 방문 및 이용이 가능하며, 미사용시에 해당날짜가 지나면 자동 취소 됩니다.</b><br>
								(사용 후에는 취소가 불가능합니다.)<br>
								 - 본인+동반인 티켓 구매 후 동반인 티켓만 사용 시 본인 티켓 취소는 불가합니다. <br>
								 - 본인+동반인 티켓 구매 후 취소하실 경우 동반인 티켓을 먼저 취소하셔야합니다.<br>
								 - 시스템 자동 취소가 될 경우 제휴카드 실적은 은행영업일 기준 2~3일 후에 복구됩니다. <br> 
								 - 별도의 취소 수수료는 없으나 구매 후 환불요청 시 각 카드사에 따라 수수료를 차감합니다. <br>
								 - 예매취소를 원하시는 경우 [마이페이지 > 결제내역]에서 취소하실 수 있습니다. <br>
								 - 예매 후에는 반드시 마이티켓을 통하여 예매내역을 확인해 주시기 바랍니다. <br>
								</th>
		               	</tr>
		               	 <tr>
		                    <th><a href="#!" onclick="toggleAnswer('answer2')">&nbsp;&nbsp;&nbsp;이용안내 </a></th>             
		                </tr>
		                <tr id="answer2" style="display:none">
		               		 
		                	<th style="font-size:15px; font-weight:normal; background:#F7F7F7"><br>
								<b>이용 안내</b><br>
								<b> 1. 어드벤처 예매페이지 및 모바일APP을 통한 티켓예매 </b><br>
								<b> 2. 카카오 알림톡(또는 문자메시지)으로 웹티켓 URL 발송 </b><br>
								<b> 3. 웹티켓을 게이트에 제시 후 빠른 입장 </b><br>
								<br>
								※ 예매 후에는 반드시 마이티켓을 통하여 구매하신 웹티켓을 확인해주시기 바랍니다.<br>
								※ 티켓은 선택한 날짜에만 방문 및 이용 가능합니다.(다른 날짜에는 사용 불가)
							</th>					
					</table>
		       </div>
	       </div>
	       	<div id="reserve_buttons" style = "padding-top:40px;">
	       	<!-- 	<input type="button" value="구매하기" onClick="location.href='world.do?command=cartList'">  -->
	        	<input type="button" value="결제하기" class="submit" onclick="go_cart();"> 
	       	</div>
	                	
		</div>
	</div>
</div>
</form>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    
<%@ include file="../footer.jsp" %>>