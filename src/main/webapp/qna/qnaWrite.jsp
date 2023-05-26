<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<style>
#buttons{text-align:center;}
</style>  

<article>
	<div class="qnaimg" style="background-image:url('images/qnaaa.png');"></div>
</article>

<article class="fix01">

		<h2> 1:1 고객 게시판 </h2><h3 style="text-align:center; padding-top:20px;padding-bottom:20px;font-color: #e7e7e7;"> 고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>
		 <form class="fix02">
	       <table class="fix03">
			<tr>
				<th>제목</th>
				
				<td width="500" style="text-align:left;">
				
				</td>
				
			</tr>
			
			<tr>
				<th>내용</th>
				<td align="left" style="text-align:left;font-size:115%;">
				<input type="text" name="title" size="50">
				<pre></pre>
				</td>
			</tr>
			
		</table>
	<div class="clearr"></div><br><br>
	<div id="buttonss">
		<input type="submit" value="등록"  class="submit" onclick="location.href='world.do?command=qnaList'"> 
		<input type="reset"  value="취소"  class="cancel"  onclick="location.href='world.do?command=qnaList'">
	</div>

</form>
</article>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br>


<%@ include file="../footer.jsp" %>