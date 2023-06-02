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
    <form method="post" name="joinForm">
        <input type="hidden" name="command" value="resetPwd">
        <div class="basic_box">
            <div class="basic_box_text">
                <label>아이디</label><br>
                <input type="text" name="id" class="dup" value="${param.id}" readonly><br>
                <label>비밀번호</label><br>
                <input type="password" name="pwd" class="dup"><br> 
                <label>비밀번호 확인</label><br>
                <input type="password" name="pwdCheck" class="dup"><br>
            </div>
        </div>
        <div class="join_buttons">
            <div class="join_buttons_text">
                <input type="submit" value="재설정" class="join_submit" onclick="checkPwd();"> 
                <input type="reset" value="취소" class="join_cancel">
            </div>
        </div>
    </form>
</body>
</html>
