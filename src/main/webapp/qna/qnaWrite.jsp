<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<style>
#buttons{text-align:center;}
</style>  

<article>
<h2 style="font-family: 'NotoSans-Bold', '맑은 고딕', 'Malgun Gothic', sans-serif;font-size: 55px;color: #000;text-align: center; padding-top: 50px;">이용문의</h2><br>
<div style="position: relative; text-align: center;">
  <img src="images/qna_image.jpg" style="opacity: 0.3;width:950px;">
  <div style="position: absolute; top: 50%; left: 42%; transform: translate(-50%, -50%);text-align: left;">
    <h3 style="font-size: 27px;font-family: 'NotoSans-Bold', '맑은 고딕', 'Malgun Gothic', sans-serif;line-height: 36px;margin-bottom: 27px;text-align:left;">롯데월드를 이용하기 전<br>
궁금한 사항에 대한 문의를 남겨주세요.</h3><br><h4 style="font-size: 17px; font-weight:bold;" >
⊙ 답변은 이메일 주소로 발송됩니다<br><br>
⊙ 접수 후 1주 이내 회신을 드리기 위해 노력하고 있습니다. 의견 접수가 많거나,<br>
공휴일에 접수될 경우 답변에 시간이 소요될 수 있으니 양해 부탁드립니다.<br><br>
⊙ 불건전한 내용(개인정보보안, 귀책사유에 대한 개인 음해성 비방의 글 등) 또는<br>
광고성 게시글은 사전 통보없이 삭제될 수 있습니다</h4>
 </div>
 </div>
</article>
<hr>
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