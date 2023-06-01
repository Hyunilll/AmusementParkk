<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>비밀번호 재설정</title>
</head>
<body>
    <h2>비밀번호 재설정</h2>
    <form method="post" action="resetPwd.jsp">
        <input type="hidden" name="id" value="${Lmember.id}" /> 
        <div>
            <label for="newPwd">새로운 비밀번호:</label>
            <input type="password" id="newPwd" name="newPwd" required />
        </div>
        <div>
            <label for="confirmPwd">비밀번호 확인:</label>
            <input type="password" id="confirmPwd" name="confirmPwd" required />
        </div>
        <div>
            <input type="submit" value="비밀번호 재설정"  onclick="checkPwd()"/>
        </div>
    </form>
</body>
</html>