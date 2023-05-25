<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<article>
<div class="join3">
	<div class="join_title">회원정보 수정</div>
	<form method="post" name="joinForm" >
		<input type="hidden" name="command" value="edit">
		<div class="basic_box">
			<div class="basic_box_text">
				<label>아이디</label><br>
				<input type="text" name="id" value="${loginUser.id}" class="dup" readonly><input type="hidden" name="reid">
			    <label>비밀번호</label><br><input type="password" name="pwd" class="dup"><br> 
			    <label>비밀번호 확인</label><br><input type="password" name="pwdCheck" class="dup"><br>
			    <label>이름</label><br><input type="text" name="name" class="dup" value="${loginUser.name}"><br>
			    <label id=last>휴대폰 번호</label><input type="text" name="phone" class="dup" value="${loginUser.phone}"><br>
			    <label>우편번호</label><br><input type="text" name="zip_num" class="dup" style="width:430px;" value="${loginUser.zip_num}">      
			    <input type="button" value="주소 찾기" style="width:100px; float:right;" onclick="post_zip()"><br>
				<label>주소</label><br><input type="text" name="address1" class="dup" value="${loginUser.address1}"><br>
				<label>상세주소</label><br><input type="text" name="address2" class="dup" value="${loginUser.address2}"> <br>
				<label>이메일</label><br><input type="text" name="email" class="dup" value="${loginUser.email}"><br>
			</div>
		</div>
		<div class="join_buttons">
			<div class="join_buttons_text">
			    <input type="button" value="정보수정" class="join_submit" onclick="go_update();"> 
			    <input type="reset" value="취소" class="join_cancel">
			</div>
		</div>
	</form>
</div>
</article>

<%@ include file="../footer.jsp" %>