<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/admin/header.jsp"%>
<article>
<div class="update">
	<form method="post" name="updateat" enctype="multipart/form-data" >
		<input type="hidden" name="aseq" value="${AttractionVO.aseq}">
  		<input type="hidden" name="oldImage" value="${AttractionVO.image}">
		<div class="update_title">어트랙션 수정</div>
		<div class="update_main">
			<div><p>어트랙션 이름</p><input type="text" name="atname"><br></div>
			<div><p>어트랙션 설명</p><input type="text" name="acontent"><br></div>
			<div><p>태그1</p><input type="text" name="act1"><br></div>
			<div><p>태그2</p><input type="text" name="act2"><br></div>
			<div><p>어트랙션 사진</p><input type="file" name="image"><br></div>
			<div><p>탑승인원(숫자)</p><input type="text" name="pnum"><br></div>
			<div><p>제한사항1(키)</p><input type="text" name="limitkey"><br></div>
			<div><p>제한사항2(나이)</p><input type="text" name="limitage"><br></div>
			<div><p>베스트 어트랙션(Y/N)</p><input type="text" name="bestat"><br></div>
			<div><p>운휴 정보(Y/N)</p><input type="text" name="aresult"><br></div>
		</div>
		<div class="update_buttons">
			<input class="btn" type="button" value="수정" onclick="go_mod_saveat()">
			<input class="btn" type="reset" value="취소"
				onClick="location.href='world.do?command=adminAttractionDetail&aseq=${AttractionVO.aseq}'" >
		</div>
</form>		
</div>
</article>
<%@ include file ="/admin/footer.jsp"%>