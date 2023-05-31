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
<div class="pwd_found">
   <h2>비밀번호 찾기</h2>
   <form method="post" name="formm" action="world.do">
      <input type="hidden" name="command" value="resetPwd" />
      <table id="reset-pwd">
         <tr>
            <th>아이디&nbsp;</th>
            <td><input type="text" name="id" class="input-text" maxlength="20" /></td>
         </tr>
         <tr>
            <th>이름&nbsp;</th>
            <td><input type="text" name="name" class="input-text" maxlength="20" /></td>
         </tr>
         <tr>
            <th>전화번호&nbsp;</th>
            <td><input type="text" name="phone" class="input-text " maxlength="20" /></td>
         </tr>
         <tr>
            <td colspan="2"><input type="button" value="확인" class="submit " onclick="checkInfo();" /></td>
         </tr>
      </table>
   </form>
   <%-- 비밀번호 재설정 폼 --%>
   <div id="reset-pwd-form" style="display: none;">
      <form method="post" name="resetPwdForm" action="world.do">
         <input type="hidden" name="command" value="resetPwdSubmit" />
         <input type="hidden" name="id" value="${id}" />
         <table>
            <tr>
               <th>새 비밀번호&nbsp;</th>
               <td><input type="password" name="pwd" class="input-text input-text-bg-gray input-text-font-normal" maxlength="20" /></td>
            </tr>
            <tr>
               <th>비밀번호 확인&nbsp;</th>
               <td><input type="password" name="pwdCheck" class="input-text input-text-bg-gray input-text-font-normal" maxlength="20" /></td>
            </tr>
            <tr>
               <td colspan="2"><input type="button" value="비밀번호 변경" class="submit submit-blue dup-btn" onclick="resetPwd();" /></td>
            </tr>
         </table>
      </form>
   </div>
   <%-- 결과 메시지 출력 --%>
   <div id="result-message" style="display: none;">
      <c:choose>
         <c:when test="${result eq 1}">
            <h2>아이디와 이름, 전화번호가 일치하지 않습니다.</h2>
         </c:when>
         <c:when test="${result eq 2}">
            <h2>비밀번호 변경에 실패했습니다.</h2>
         </c:when>
         <c:otherwise>
            <h2>비밀번호가 성공적으로 변경되었습니다.</h2>
         </c:otherwise>
      </c:choose>
   </div>
</div>
<script>
function checkInfo() {
   var id = document.getElementsByName("id")[0].value;
   var name = document.getElementsByName("name")[0].value;
   var phone = document.getElementsByName("phone")[0].value;
   
   // 아이디, 이름, 전화번호 유효성 검사 로직 추가 가능
   
   // 유효성 검사를 통과한 경우
   document.getElementById("reset-pwd-form").style.display = "block";
   document.getElementById("result-message").style.display = "none";
   document.resetPwdForm.id.value = id;
}

function resetPwd() {
   var pwd = document.getElementsByName("pwd")[0].value;
   var pwdCheck = document.getElementsByName("pwdCheck")[0].value;
   
   // 새 비밀번호와 비밀번호 확인 유효성 검사 로직 추가 가능
   
   // 유효성 검사를 통과한 경우
   if (pwd === pwdCheck) {
      document.resetPwdForm.submit();
   } else {
      alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
   }
}
</script>
</body>
</html>
