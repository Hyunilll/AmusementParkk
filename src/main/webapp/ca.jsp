<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title</title>

<style type="text/css">
	td{ font-weight:bold; font-size:110%; }
	a{text-decoration:none; }
</style>
</head>
<body>
<%
	java.util.Calendar sDay = java.util.Calendar.getInstance();  
	Calendar eDay = Calendar.getInstance();   
	
	int sYear = sDay.get(Calendar.YEAR);
	int sMonth = sDay.get(Calendar.MONTH);
	
	if( request.getParameter("sYear") != null ){
		sYear = Integer.parseInt( request.getParameter("sYear") );
	}
	if (  request.getParameter("sMonth") != null ){
		sMonth = Integer.parseInt( request.getParameter("sMonth") );
		if(sMonth==12) {  	sMonth = 0;			sYear++;		}
		if(sMonth==-1){ 		sMonth=11;			sYear--;		}
	}
	
	sDay.set( sYear, sMonth, 1 );
	int lastDay = sDay.getActualMaximum(Calendar.DATE) ;
	eDay.set( sYear, sMonth, lastDay);
	int START_WEEK = sDay.get( Calendar.DAY_OF_WEEK );	
%>

	
	<table width="560" align="left" cellspacing="1" bgcolor="black">
		<tr bgcolor="white" height="50">
			<td colspan="7" align="center">
				<h2>
				<a href="ca.jsp?sYear=<%=sYear%>&sMonth=<%=sMonth-1%>">◀</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<%=sYear%>년 <%=(sMonth+1)%>월
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="ca.jsp?sYear=<%=sYear%>&sMonth=<%=sMonth+1%>">▶</a></h2>
			</td>
		</tr>
		<tr bgcolor="white" height="50"><!-- 맨윗줄 요일이 표시되는 tr -->
			<td align="center" width="80">일</td><td align="center" width="80">월</td>
			<td align="center" width="80">화</td><td align="center" width="80">수</td>
			<td align="center" width="80">목</td><td align="center" width="80">금</td>
			<td align="center" width="80">토</td>
		</tr>
		<tr bgcolor="white" height="50"><!-- 날짜가 표시되는 tr -->
			<%
				int i;
				for(i=1; i<START_WEEK; i++) {  
					out.print("<td>&nbsp;</td>");
				}
				
				for(int d=1; d<=lastDay; d++){ 
					out.print("<td>" + d + "</td>");
					if( i++ % 7 == 0){ 
						out.print("</tr><tr bgcolor=\"white\" height=\"50\">");
					}
				}
				
				if(i%7!=0){
					for(int k=1; k<= (8-(i%7)); k++ ){ 
						out.print("<td>&nbsp;</td>");
					}  
				}else{
					out.print("<td>&nbsp;</td>");
				}
			%>
		</tr>
	</table>
</body>
</html>




