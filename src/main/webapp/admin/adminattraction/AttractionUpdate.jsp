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
			<div><p>어트랙션 이름</p><input type="text" name="atname" value="${AttractionVO.atname }"><br></div>
			<div><p>어트랙션 설명</p><input type="text" name="acontent" value="${AttractionVO.acontent }"><br></div>
			<div><p>태그1</p><input type="text" name="act1"value="${AttractionVO.act1 }"><br></div>
			<div><p>태그2</p><input type="text" name="act2"value="${AttractionVO.act2 }"><br></div>
			<div><p>어트랙션 사진</p><input type="file" name="image" value=""><br></div>
			<!-- 
					<td colspan="5">
					<img src="images/attraction_images/${AttractionVO.image}" width="200"><br>
		      		<input type="file" name="image"><br></div>
		      		</td>
			 -->
			<div><p>탑승인원(숫자)</p><input type="text" name="pnum" value="${AttractionVO.pnum }"><br></div>
			<div><p>제한사항1(키)</p><input type="text" name="limitkey" value="${AttractionVO.limitkey }"><br></div>
			<div><p>제한사항2(나이)</p><input type="text" name="limitage" value="${AttractionVO.limitage }"><br></div>
			<div><p>베스트(Y/N)</p><input type="text" name="bestat" value="${AttractionVO.bestat }"><br></div>
			<div><p>운휴정보(Y/N)</p><input type="text" name="aresult" value="${AttractionVO.aresult }"><br></div>
			
			<!-- 
			<div><p>베스트 어트랙션(Y/N)</p>
						<c:choose>
				  			<c:when test='${AttractionVO.bestat=="Y"}'>
				  				<input type="radio" name="bestat" value="Y" checked="checked">사용
				  				<input type="radio" name="bestat" value="N">미사용
				  			</c:when>
							<c:otherwise>
								<input type="radio" name="bestat" value="Y">사용
								<input type="radio" name="bestat" value="N" checked="checked">미사용
							</c:otherwise>
						</c:choose>
			</div>
			<div><p>운휴 정보(Y/N)</p>
				
						<c:choose>
				  			<c:when test='${AttractionVO.aresult=="Y"}'>
				  				<input type="radio" name="aresult" value="Y" checked="checked">사용
				  				<input type="radio" name="aresult" value="N">미사용
				  			</c:when>
							<c:otherwise>
								<input type="radio" name="aresult" value="Y">사용
								<input type="radio" name="aresult" value="N" checked="checked">미사용
							</c:otherwise>
						</c:choose>
				
		</div>
		 -->
		 </div>
		<div class="update_buttons">
			<input class="btn" type="button" value="수정" onclick="go_mod_saveat()">
			<input class="btn" type="reset" value="취소"
				onclick= 'location.href="world.do?command=adminattractionDetail&aseq=${AttractionVO.aseq}"'> 
		</div>
</form>		
</div>
</article>
<%@ include file ="/admin/footer.jsp"%>