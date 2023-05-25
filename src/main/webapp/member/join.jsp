<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<article>
<div class="join3">
	<div class="join_title">회원가입</div>
	<form method="post" name="joinForm" >
		<input type="hidden" name="command" value="join">
		<div class="basic_box">
			<div class="basic_box_text">
				<label>아이디</label><br>
				<input type="text" name="id" class="dup" style="width:430px;"><input type="hidden" name="reid">
			    <input type="button" value="중복 체크" onclick="idcheck()" style="width:100px; float:right;"><br>
			    <label>비밀번호</label><br><input type="password" name="pwd" class="dup"><br>
			    <label>비밀번호 확인</label><br><input type="password" name="pwdCheck" class="dup"><br>
			    <label>이름</label><br><input type="text" name="name" class="dup"><br>
			    <label id=last>휴대폰 번호</label><br><input type="text" name="phone" class="dup"><br>
			    <label>우편번호</label><br><input type="text" name="zip_num" class="dup" style="width:430px;">      
			    <input type="button" value="주소 찾기" onclick="post_zip()" style="width:100px; float:right;"><br>
				<label>주소</label><br><input type="text" name="address1" class="dup"><br>
				<label>상세주소</label><br><input type="text" name="address2" class="dup"><br>
				<label>이메일</label><br><input type="text" name="email" class="dup"><br>
			</div>
		</div>
		<div class="join_buttons">
			<div class="join_buttons_text">
		    	<input type="button" value="회원가입" class="join_submit" onclick="go_save()"> 
		    	<input type="reset" value="취소" class="join_cancel">
		    </div>
		</div> <!-- go_save에서 액션과 벨리데이션 함께 진행 -->
	</form>
</div>
</article>

<%@ include file="../footer.jsp" %>
