<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../../header.jsp" %>
<script src="admin/script/admin.js"></script>
<div id=logina>

   <div id="login">
   <h2>관리자 로그인</h2>
   <hr>
   </div>
   <h2 style="color:gray">관리자 아이디와 비밀번호로 로그인 하세요.</h2>
   <br><br>
   <form method="post" name="frm">
   <!-- <input type="hidden" name="command" value="login">  action="world.do"-->
   <div id=input>
      <input name="id" placeholder="&nbsp;아이디" size="40" type="text" style="width:550px ;background:white;"><br>
   </div>
   <div id=input>
      <input name="pwd" placeholder="&nbsp;비밀번호" size="40" type="password" style="width:550px"><br>
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