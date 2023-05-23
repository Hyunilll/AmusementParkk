<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{overflow-x:hidden; }
#popup{padding: 0 10px; font-family:Verdana;}
table#zipcode{border-collapse:collapse; border-top:3px solid #6F0C78;   border-bottom:3px solid #6F0C78;
      margin-top:15px; width:100%; font-size:110%;}
table#zipcode th, table#zipcode td{text-align:center; border-bottom: 1px dotted  #6F0C78;;}
table th, td{  padding: 10px;}
table#zipcode  a{display:block; height:20px; text-decoration:none; padding:10px;}
table#zipcode a:hover{font-weight: bold;}

</style>
<script src="member/member.js"></script>
</head>
<body>
<div id="popup">
	<h1>우편번호 검색</h1>
	<form action="world.do" method="post" name="formm">
		<input type="hidden" name="command" value="findZipNum">
			동 이름 : <input name="dong"  type="text">
			<input type="submit" value="찾기"  class="submit">
	</form>

	<!-- 검색된 우편번호와 동이 표시되는 곳 -->
	<table id="zipcode">
		<tr><th width="100">우편번호</th><th>주소</th></tr>
		<c:forEach items="${addressList}" var="add">
			<tr>
				<td><a href="#" 
				onClick="result('${add.zip_num }','${add.sido}', '${add.gugun}', '${add.dong}');">
				${add.zip_num }</a></td>
				<td><a href="#" 
				onClick="result('${add.zip_num }','${add.sido}', '${add.gugun}', '${add.dong}');">
				${add.sido} ${add.gugun} ${add.dong}</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>