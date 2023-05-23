<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<article>
	<div id="join3">
		<form method="post" name="joinForm" >
			<input type="hidden" name="command"  value="edit">
				<fieldset><legend>Basic Info</legend>
					<label>User ID</label>
					<input type="text" name="id" value="${loginUser.id}" readonly>
					<input type="hidden" name="reid"><br>
				    <label>Password</label><input type="password" name="pwd"><br> 
				    <label>Retype Password</label><input type="password" name="pwdCheck"><br> <br>
				    <label>Name</label><input type="text"  name="name" value="${loginUser.name}"><br><br>
				    <label id=last>Phone Number</label><input type="text" name="phone"
				    	value="${loginUser.phone}"><br>
				</fieldset>
				
				<fieldset><legend>Optional</legend>
				    <label>Zip Code</label><input type="text" name="zip_num" size="10" value="${loginUser.zip_num}" >      
				    <input type="button" value="주소 찾기" class="dup" onclick="post_zip()"><br>
					<label>Address</label><input type="text" name="address1" size="50" value="${loginUser.address1}"><br>
					<label>Address Detail</label><input type="text" name="address2" size="25"  value="${loginUser.address2}"> <br>
					<label>E-Mail</label><input type="text"  name="email" value="${loginUser.email}"><br>
				</fieldset>
			
			<div id="buttons">
				    <input type="button" value="정보수정" class="submit" onclick="go_update();"> 
				    <input type="reset" value="취소" class="cancel">
			</div>
		</form>
	</div>
</article>



<%@ include file="../footer.jsp" %>