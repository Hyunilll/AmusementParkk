<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../header.jsp" %>
<script src="admin/script/admin.js"></script>
<style>
.ar{position: absolute; left:300px; color:blue;}
</style>

<div id=logina>

   <div id="login">
   <h1>관리자 로그인</h1>
   <hr>
   </div>
   <h2>관리자 아이디와 비밀번호로 로그인 하세요.</h2>
   <br><br>
   <form method="post" name="frm">
   <!-- <input type="hidden" name="command" value="login">  action="world.do"-->
   <div id=input>
      <input name="id" placeholder="아이디" size="40" type="text"><br>
   </div>
   <div id=input>
      <input name="pwd" placeholder="비밀번호" size="40" type="password"><br>
   </div>
   <div class="ar">&nbsp;&nbsp;&nbsp;${param.message}</div>
   <div class="ar">&nbsp;&nbsp;&nbsp;${message}</div>
   <div class="menu1">
      <ul>
          <li><a href="#">아이디 찾기 | </a></li>
             <li><a href="#">비밀번호 찾기</a></li>
      </ul>
   </div>
   <div id="buttons">
      <input type="submit" value="로그인" class="submit" onclick="return adminloginCheck()">
   </div><br><br>
   <div id=content> 문의사항이 있으시면 고객만족센터에 연락하세요.<br>
   고객만족센터 : 1899-8900</div>
   
   
   </form>
</div>

<%@ include file="../footer.jsp" %>