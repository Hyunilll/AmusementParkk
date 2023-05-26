<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/admin/header.jsp"%>
<style>
#join3{position: relative; width:1200px; height:900px; margin: 0 auto; 
  display: grid; min-height: 10vh; font-size: 20px;}
fieldset {text-align:left; }
#join3 form {   margin: 30px 0 0 200px;   width: 700px;}
#join3 form fieldset {text-align:left;  padding: 5px 0 20px 5px; border: none;}
#join3 form fieldset legend { font-size: 30px; border-bottom: 1px dotted #666;width: 750px;  padding: 5px 0; }
#join3 form label {  width: 160px; float: left; margin: 5px 0 0 5px ;}
#join3 form input { margin: 5px 10px; border: 1px solid #999; background-color: #FCFDEA; font-size: 20px;}
#join3 form  .btn, #join3 form .btn2 {   height: 30px;   width: 200px;  border: 1px solid #666; 
      border-radius: 10px; box-shadow: 3px 3px 2px #ccc; font-size: 20px;  margin: 0 0 0 20px;
      background-color: #6317ed; color:white;  }
#join3 form .btn2 {background : #81d4fa;} 
</style>

<div id="join3">
	<form method="post" name="insertnt" enctype="multipart/form-data" >
		<input type="hidden" name="aseq" value="${AttractionVO.aseq}">
  		<input type="hidden" name="oldImage" value="${AttractionVO.image}">
		<fieldset><legend>놀이기구 수정</legend>
			<label>놀이기구 이름</label><input type="text" name="atname" size="13"><br><br>
			<label>놀이기구 설명</label><input type="text" name="acontent" size="100"><br><br>
			<label>카테고리1</label><input type="text" name="act1" size="13"><br><br> 
			<label>카테고리2</label><input type="text" name="act2" size="13"><br><br>
			<label>기구 사진</label><input type="file" name="image"><br> <br> 
			<label>탑승인원</label><input type="text" name="pnum" size="13"><br><br>
			<label>제한 사항1 (키)</label><input type="text" name="limitkey" size="50"><br><br><br> 
			<label>제한 사항2 (나이)</label><input type="text" name="limitage" size="50"><br><br><br>
			<label>베스트 놀이기구(Y/N)</label><input type="text" name="bestat" size="10"><br><br><br> 
			<label>운휴 정보(Y/N)</label><input type="text" name="aresult" size="10"><br><br>
		</fieldset>
	<div id="buttons">
		<input class="btn" type="button" value="놀이기구 수정" onclick="go_mod_saveat()">
		<input class="btn" type="button" value="목록으로" onclick="go_mov('adminattractionForm')">
	</div> 
</form>		
</div>
<%@ include file ="/admin/footer.jsp"%>