<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/admin/header.jsp"%>
<section class="notice">
  <div class="page-title">
        <div class="container">
            <h3 style="font-size: 28px;color: #333333;font-weight: 400;text-align: center;">공지사항</h3>
        </div>
    </div>

    <div id="board-search">
        <div class="container">
            <div class="search-window">
                <form action="">
                    <div class="search-wrap">
                        <label for="search" class="blind">공지사항 내용 검색</label>
                        <input id="search" type="search" name="" placeholder="검색어를 입력해주세요." value="">
                        <button type="submit" class="btn btn-dark">검색</button>
                    </div>
                    <div>
                    	<button type="submit" class="btn btn-dark">수정</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
   
    <div id="board-list">
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

<jsp:include page="../../paging/page.jsp">
	<jsp:param name="command" value="world.do?command=notice" />
</jsp:include>
<br><br><br>
<%@ include file ="/admin/footer.jsp"%>