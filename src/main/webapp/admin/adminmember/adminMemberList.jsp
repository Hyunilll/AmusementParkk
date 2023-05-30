<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/admin/header.jsp"%>

<link href="css/admincss.css" rel="stylesheet">
<style>
   #buttons{text-align:center;}
.submit{position:relative; font-size: 20px;padding-bottom:10px; width:200px; height:55px;color: #fff; background:rgb(111, 35, 249);;font-weight:bold;border-radius: 28px;border:1px solid #6317ed;}
.cancel{position:relative; font-size: 20px;padding-bottom:10px; width:200px; height:55px;color:#6317ed; background:white;font-weight:bold;border-radius: 28px;border:1px solid #6317ed;}
</style>
<form name="frm" method="post">
<section class="notice">
  <div class="page-titlee">
        <div class="containerr">
            <h3 style=" margin-right:70px; font-size: 60px;color: #333333;font-weight: 400;text-align: center;"> 회원 리스트 </h3>
        </div>
    </div>

    <div class="board-searchh">
        <div class="containerr">
            <div class="search-window">
                
                    <div class="search-wrap">
                        <label for="search" class="blind"> 회원 이름 검색 </label>
                        <input id="search" type="search" name="key" placeholder="회원 이름을 입력해주세요." value="${key }">
                        <button type="submit" class="btn btn-dark" value="검색" onClick="go_search('adminmember');">검색</button>
                        <button type="submit" class="btn btn-darkk" value="전체보기" onClick="go_total('adminmember');">전체보기</button>
                          
                    </div>
               
            </div>
        </div>
    </div>
   
    <div class="board-listt">
        <div class="containerr">
            <table class="board-tablee">
                <thead>
                <tr>
                    <th scope="col" class="th-num">아이디</th>
                    <th scope="col" class="th-title">이름</th>
                    <th scope="col" class="th-date">이메일</th>
                    <th scope="col" class="th-answer">우편번호</th>
                    <th scope="col" class="th-address">주소</th>
                    <th scope="col" class="th-phone">전화</th>
                    <th scope="col" class="th-day">가입일</th>
                </tr>
                
                </thead>
     		<c:forEach items="${memberList}" var="memberVO">
			<tr><td>${ memberVO.id}</td>
		    	<td>${memberVO.name}</td><td>${memberVO.email}</td>
		    	<td>${memberVO.zip_num}</td><td>${memberVO.address1}</td>
		    	<td>${memberVO.phone}</td><td>
		    	<fmt:formatDate value="${memberVO.indate}"/></td></tr>
	  </c:forEach>

            </table>
        </div>
        <br> <br> <br>
        <jsp:include page="../../paging/page.jsp">
		<jsp:param name="command" value="world.do?command=adminmember" />
		</jsp:include>
    </div>
<br><br><br><br><br><br><br><br>
</section>
</form>
    

	






<%@ include file ="/admin/footer.jsp"%>