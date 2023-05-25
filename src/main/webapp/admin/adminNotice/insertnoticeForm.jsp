<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/admin/header.jsp"%>

<style>
#join3{position: relative; width:1200px; height:500px; margin: 0 auto; 
  display: grid; min-height: 10vh; font-size: 30px;}
fieldset {text-align:left; }
#join3 form {   margin: 30px 0 0 200px;   width: 700px;}
#join3 form fieldset {text-align:left;  padding: 10px 0 20px 5px; border: none;}
#join3 form fieldset legend { font-size: 40px; border-bottom: 1px dotted #666;width: 750px;  padding: 5px 0; }
#join3 form label {  width: 160px; float: left; margin: 5px 0 0 5px ;}
#join3 form input { margin: 5px 30px; border: 1px solid #999; background-color: #FCFDEA; font-size: 20px;}
#join3 form  .btn, #join3 form .btn2 {   height: 30px;   width: 150px;  border: 1px solid #666; 
      border-radius: 10px; box-shadow: 3px 3px 2px #ccc; font-size: 20px;  margin: 0 0 0 20px;
      background-color: #6317ed; color:white;  }
#join3 form .btn2 {background : #81d4fa;} 
</style>

<div id="join3">
	<form method="post" name="insertnt" enctype="multipart/form-data" >
		<fieldset><legend>공지사항 추가</legend>
			<label>title</label><input type="text" name="title" size="13"><br><br> 
		    <label>ncontent</label><input type="file" name="ncontent"><br> <br> 
		    <label>id</label><input type="text"  value="${loginAdmin.id}" name="id"><br><br>
		</fieldset>
	
	<div id="buttons">
		<input class="btn" type="button" value="공지등록" onclick="go_insertnt()">
		<input class="btn" type="button" value="목록으로" onclick="go_mov('adminnotice')">
	</div> <!-- go_save에서 액션과 벨리데이션 함께 진행 -->
</form>		
</div>


<%@ include file ="/admin/footer.jsp"%>