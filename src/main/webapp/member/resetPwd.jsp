<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 재설정</title>
<script src="member/member.js"></script>
</head>
<body>
    <h2>비밀번호 재설정</h2>
    <form method="post" name="joinForm" action="world.do">
<input type="hidden" name="command" value="resetPwd" />
<input type="hidden" name="id" value="${Lmember.id}" />
<fieldset>
<div>비밀번호</div><input type="password" name="pwd" class="input" placeholder=" 비밀번호를 입력하세요" maxlength="20" /><br />
<div>비밀번호 재입력</div><input type="password" name="pwdCheck" class="input" placeholder=" 비밀번호를 입력하세요" maxlength="20" /><br>
</fieldset>
<div class="clear"></div>
<br>
<div class="buttons">
<input type="button" value="재설정" class="submit" onclick="checkPwd();" />&nbsp;
<input type="reset" value="취소" class="cancel" />
</div>
<br>
</form>
</body>
</html>