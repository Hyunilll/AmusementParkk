<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<form name="frm" method="post">
	<input type="hidden" name="lqseq" value="${qnaVO.lqseq}">
	

<section class="fix">
	<div class="qnaimg" style="background-image:url('images/qnaaa.png');"></div>
		<article class="fix01">

		<h2> QnA 게시판 </h2><h3 style="text-align:center; padding-top:20px;padding-bottom:20px;font-color: #e7e7e7;"> 고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>
		 <form class="fix02">
	       <table class="fix03">
			<tr>
				<th>제목</th>
				<td width="500" style="text-align:left;">${qnaVO.title}</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td align="left" style="text-align:left;">
				<fmt:formatDate value="${qnaVO.indate}" type="date"/>
				</td>
			</tr>
			<tr>
				<th>질문내용</th>
				<td align="left" style="text-align:left;font-size:115%;">
				<pre>${qnaVO.content}</pre>
				</td>
			</tr>
			<tr>
				<c:choose>          
					<c:when test='${qnaVO.rep=="N"}'> <!-- 관리자 답변 전 표시 -->		
		    			<th>답변내용</th>
		    			<td colspan="2"><textarea name="reply" rows="2" cols="45"></textarea>
		   					
		   						
		   <!--  				<input type="button" class="btn4" value="저장"
		   					onClick="location.href='world.do?command=adminQnaRepSave&lqseq=${qnaVO.lqseq}'"></td>
				-->
					</c:when>
					
					<c:otherwise>  <!-- 관리자 답변 후 표시 -->
						<th>답변내용</th>
						<td align="left" style="text-align:left;">
						<pre>${qnaVO.reply}</pre>
					</c:otherwise>
				</c:choose>	
			</tr>	
		</table>
		<div class="clearr"></div>
		<div id="buttonss" style="margin:0 0 0 200px;">
			<c:choose>
				<c:when test='${qnaVO.rep=="N" }'>
					<input type="button" class="btn4" value="저장" onClick="go_rep()">
					<input type="button"  value="목록보기" class="submit" onclick="location.href='world.do?command=adminqna'">
				</c:when>
				<c:otherwise>
					<input type="button"  value="목록보기" class="submitt" onclick="location.href='world.do?command=adminqna'">
				</c:otherwise>
			</c:choose>
			
		</div>
		
	</form>
</article>
</section>
</form>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

<%@ include file="../footer.jsp" %>