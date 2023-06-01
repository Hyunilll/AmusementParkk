<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디(ID) 찾기</title>
<script src="member/member.js"></script>
</head>
<body>
<div class="id_found">
   <h2>아이디(ID) 찾기</h2>
   <form method="post" name="formm" action="world.do">
      <input type="hidden" name="command" value="selectId" />
      <table id="find-id">
         <tr>
         <th>이름&nbsp;</th><td><input type="text" name="name" class="input-text" maxlength="20" /></td>
         </tr>
         <tr>
         <th>전화번호&nbsp;</th><td><input type="text" name="phone" class="input-text" maxlength="20" /></td>
         </tr>
      </table>
      <br />
      <input type="button" value="찾기" class="button" onclick="find_Id();" />
   </form>
   <br />
   <c:if test="${not empty Lmember}">
      <h2>회원님의 아이디는 ${Lmember.id} 입니다.</h2>
   </c:if>
</div>
</body>
</html>