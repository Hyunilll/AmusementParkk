<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

      
<style>
table#qnaList {border-collapse: collapse;		border-bottom: 1px solid #333; 
		width: 100%; margin-bottom: 20px; }
table#qnaList th, td {	border-bottom: 1px dotted #333;	text-align: center; font-size:20px;}	
#buttons{text-align:center;}
.submit{position:relative; font-size: 20px;padding-bottom:10px; width:200px; height:55px;color: #fff; background:rgb(111, 35, 249);;font-weight:bold;border-radius: 28px;border:1px solid #6317ed;}
.cancel{position:relative; font-size: 20px;padding-bottom:10px; width:200px; height:55px;color:#6317ed; background:white;font-weight:bold;border-radius: 28px;border:1px solid #6317ed;}
</style>      
      
<article>
<br><br><br><br><br><br><br>
<h2 style="text-align:center; font-size:40px;color:black">QnA 게시판 </h2><br><br><br>
	<form name="formm" method="post">
	<table id="qnaList">
		<tr>	
			<th>번호</th><th>제목</th><th>등록일</th><th>답변 여부</th></tr>
		<c:forEach items="${qnaList}"  var="qnaVO">
			<tr ><td> ${qnaVO.lqseq}</td>    
	    		<td><a href="world.do?command=qnaView&lqseq=${qnaVO.lqseq}">${qnaVO.title}</a></td>      
	       		<td><fmt:formatDate value="${qnaVO.indate}" type="date"/></td>
	       		<td><c:choose>
					<c:when test="${qnaVO.rep=='N'}"> no </c:when>
					<c:when test="${qnaVO.rep=='Y'}"> yes </c:when>
				</c:choose></td>    
	   		</tr>
	  	</c:forEach>
	</table>
	
	<jsp:include page="../paging/page.jsp">
		<jsp:param name="command" value="world.do?command=notice" />
	</jsp:include>

<div  class="clear"></div><br>


<div id="buttons">
	<input type="button"  value="등록하기"  class="submit" 
		onClick="location.href='world.do?command=qnaWriteForm'"> 
	<input type="button"   value="취소"  class="cancel" 	
		onclick="location.href='world.do?command=index'">  
</div>
<div  class="clear"></div><br>
</form>


</article>    


<%@ include file="../footer.jsp" %>