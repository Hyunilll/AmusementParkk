<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/admin/header.jsp"%>

<style>
article { min-height: 400px; } 
table#orderList { border-collapse: collapse;  border-top: 2px solid #333;
 border-bottom: 1px solid #333; width: 85%; margin-left: 100px; margin-bottom: 20px; }
 th { background-color: #E4E4E4; }
th, td{  padding: 8px 5px; }
</style>
<article>
<h1>회원 리스트</h1>
<form name="frm" method="post">
	<table style="float: right;">
		<tr>
			<td>회원 이름<input type="text" name="key" value="${key}">
				<input class="btn" type="button" value="검색" onClick="go_search('adminMemberList');">
				<input class="btn" type="button" value="전체보기" onClick="go_total('adminMemberList');">
			</td>
		</tr>		
	</table>
<table id="orderList">
		<tr><th>아이디</th><th>이름</th><th>이메일</th><th>우편번호</th><th>주소</th>
		<th>전화</th><th>가입일</th></tr>
		<c:forEach items="${memberList}" var="memberVO">
		<tr><td>${ memberVO.id}</td>
		    	<td>${memberVO.name}</td><td>${memberVO.email}</td>
		    	<td>${memberVO.zip_num}</td><td>${memberVO.address1}</td>
		    	<td>${memberVO.phone}</td><td>
		    	<fmt:formatDate value="${memberVO.indate}"/></td></tr>
	  </c:forEach>
	</table>
	
<jsp:include page="../../paging/page.jsp">
	<jsp:param name="command" value="world.do?command=notice" />
</jsp:include>
	</form>
</article>
<%@ include file ="/admin/footer.jsp"%>