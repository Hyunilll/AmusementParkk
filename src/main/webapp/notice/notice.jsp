<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>


<form name="frm" method="post">
<section class="notice">
  <div class="page-title">
        <div class="container">
             <h3 style="font-family: 'NotoSans-Bold', '맑은 고딕', 'Malgun Gothic', sans-serif;font-size: 50px;color: #000;text-align: center; padding-top: 0px;">공지사항</h3>
        </div>
    </div>

    <div class="board-searchh">
        <div class="container">
            <div class="search-window">
          
                      <div class="search-wrap">
                        <label for="search" class="blind"> 공지사항검색</label>
                        <input id="search" type="search" name="key" placeholder="검색어를 입력해주세요." value="${key}">
                        <button type="submit" class="btn btn-dark" value="검색" onClick="go_search('notice')">검색</button>
                 		<button type="submit" class="btn btn-darkkk" value="전체보기" onClick="go_total('notice')">전체보기</button>  
                    </div>
                
            </div>
        </div>
    </div>
   
    <div class="board-list">
        <div class="container">
            <table class="board-table">
                <thead>
                <tr>
                    <th scope="col" class="th-num">번호</th>
                    <th scope="col" class="th-title">제목</th>
                    <th scope="col" class="th-date">등록일</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${noticeList}"  var="noticeVO">
	                <tr>
	                    <td>${noticeVO.nseq}</td>
	                    <th><a href="world.do?command=noticeDetail&nseq=${noticeVO.nseq}">${noticeVO.title}</a></th>
	                    <td><fmt:formatDate value="${noticeVO.indate}" type="date"/></td>
	                </tr>
	          	</c:forEach>
                
                </tbody>
            </table>
        </div>
    </div>

</section>
</form>
<jsp:include page="../paging/page.jsp">
	<jsp:param name="command" value="world.do?command=notice" />
</jsp:include>

<br><br><br><br><br><br><br>
 

<%@ include file="../footer.jsp" %>