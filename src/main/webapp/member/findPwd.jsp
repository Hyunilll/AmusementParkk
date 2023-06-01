<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<script src="member/member.js"></script>
</head>
<body>

<div class="id_found">
   <h2>비밀번호 찾기</h2>
   <h5>신원확인 후 재설정이 가능합니다</h5>
   <form method="post" name="formm" action="world.do">
      <input type="hidden" name="command" value="selectPwd" />
      <table id="find-id">
         <tr>
         <th>아이디&nbsp;</th><td><input type="text" name="id" class="input-text" maxlength="20" /></td>
         </tr>
         <tr>
         <th>이름&nbsp;</th><td><input type="text" name="name" class="input-text" maxlength="20" /></td>
         </tr>
         <tr>
         <th>전화번호&nbsp;</th><td><input type="text" name="phone" class="input-text" maxlength="20" /></td>
         </tr>
      </table>
      <br />
      <input type="button" value="찾기" class="button" onclick="find_Pwd();" />
   </form>
   <br />
   <c:if test="${not empty Lmember}">
      <h2>회원님의 비밀번호는 '${Lmember.pwd}' 입니다.</h2>
      <input type="button" value="재설정" class="button" onclick="resetPwd();" />
   </c:if>
</div>

</body>
</html>
