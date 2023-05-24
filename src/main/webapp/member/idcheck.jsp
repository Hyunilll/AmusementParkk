<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idcheck.jsp</title>
<style type="text/css">
body{overflow-x:hidden; }
#popup{padding: 0 10px; font-family:Verdana;}
form input { margin: 5px 0;    border: 1px solid #999;    background-color: #FCFDEA; }
form  .submit, form  .cancel {   height: 30px;   width: 150px;  border: 1px solid #666; 
      border-radius: 10px; box-shadow: 3px 3px 2px #ccc; font-size: 14px;  margin: 0 0 0 20px;
      background-color: #6317ed; color:white;  }
form .cancel {background : #81d4fa;} 
</style>
<script src="member/member.js"></script>
</head>
<body>
	<h1>ID 중복 확인 </h1>
	<form method="post" name="idCheckForm" action="world.do">
		<input type="hidden" name="command" value="idCheckForm" />
		User ID :  <input type="text" name="id" value="${id}" >
		<input type="submit" value="검색" class="submit"><br><br><br>
		<div>
			<c:if test ="${result==1 }">
				<script type ="text/javascript">opener.document.joinForm.id.value="";</script>
				${id}는 이미 사용중입니다
			</c:if>
			<c:if test="${result == -1}">
				${id}는 사용 가능한 ID입니다.    
				<input type="button" value="사용" class="cancel" onclick="idok('${id}');">
			</c:if>	
		</div>
	</form>
</body>
</html>