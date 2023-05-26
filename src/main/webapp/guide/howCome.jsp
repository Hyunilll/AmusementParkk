<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>

<style>
h2 {font-family: 'NotoSans-Bold', '맑은 고딕', 'Malgun Gothic', sans-serif; font-size: 50px;color: #000; text-align: center;padding-top: 40px;}
.image-box {display: flex;justify-content: center;align-items: flex-start;;height: 100vh;width: 100%;}
.image-box img {display: block;margin: 0 auto;max-width: 100%;max-height: 100%;}
</style>

<h2>오시는 길</h2><br><br>
<div class="image-box">
  <img src="images/map.jpg" alt="지도 이미지">
</div>
<div id="buttons" >
   <input type="button"  value="네이버 지도 보러가기"  class="submit" 
      onClick=""> 
</div>
<%@ include file="../footer.jsp" %>
