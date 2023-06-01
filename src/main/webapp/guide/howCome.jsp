<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>

<style>
h2 {font-family: 'NotoSans-Bold', '맑은 고딕', 'Malgun Gothic', sans-serif; font-size: 50px;color: #000; text-align: center;padding-top: 40px;}
.image-box {text-align:center;}
.image-box img {}
.button-box {display: flex; justify-content: center;align-items: center;}
.submit{position:relative; font-size: 20px;padding-bottom:10px; width:220px; height:56px;color: rgb(111, 35, 249); background:white;font-weight:bold;border-radius: 28px;border:2px solid #6317ed; text-align:center;}  
.location {display: flex;align-items: center;font-size: 20px;}
.location img {margin-right: 10px;}
</style>
<script>
  function goToNaverMap() {
	 window.open("http://naver.me/xItoPO6v", "_blank");
  }
</script><br><br>
<h2>오시는 길</h2><br><br>
<div class="image-box">
  <img src="images/map.jpg" alt="지도 이미지">
 </div><br>
  <div class="button-box">
    <input type="button" value="네이버 지도 보러가기" class="submit" onClick="goToNaverMap()">
  </div><br>
        <div class="container">
            <table class="board-table" style="font-size:20px"> 
				<tr>
        			<td>
          				<div class="location">
            				<img src="images/loca.png">
            					<h4>롯데월드 어드벤처 (서울 송파구 올림픽로 240)</h4><br><br>
          				</div>
        			</td>
      			</tr>	
      		</table>
      	</div>

<br><br><br>
  

<%@ include file="../footer.jsp" %>
