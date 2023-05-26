<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/admin/header.jsp"%>
<article>
<div class="update">
	<form method="post" name="insertnt" enctype="multipart/form-data" >
		<div class="update_title">공지사항 추가</div>
		<div class="update_main">
			<div>
				<p>제목</p><input type="text" name="title"><br>
			</div>
			<div>
		    	<p>내용</p><input type="file" name="ncontent"><br>
		    </div>
		    <div>
		    	<p>관리자 아이디</p><input type="text" value="${loginAdmin.id}" name="id">
		    </div>
		</div>
		<div class="update_buttons">
			<input class="btn" type="button" value="공지등록" onclick="go_insertnt()">
			<input class="btn" type="reset" value="목록으로" onClick="go_mov('adminnotice')" >
		</div>
	</form>		
</div>
</article>
<%@ include file ="/admin/footer.jsp"%>