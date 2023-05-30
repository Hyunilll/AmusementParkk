<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>


<style>
#buttons{text-align:center;}
.submit{position:relative; font-size: 20px;padding-bottom:10px; width:200px; height:55px;color: #fff; background:rgb(111, 35, 249);;font-weight:bold;border-radius: 28px;border:1px solid #6317ed;}
.cancel{position:relative; font-size: 20px;padding-bottom:10px; width:200px; height:55px;color:#6317ed; background:white;font-weight:bold;border-radius: 28px;border:1px solid #6317ed;}
</style>
<section class="notice">
  <div class="page-title">
        <div class="container">
            <h3 style="margin-top:30px;margin-right:70px; font-size: 60px;color: #333333;font-weight: 400;text-align: center;">Q&amp;A</h3>
        </div>
    </div>
    
    <div id="board-search">
        <div class="container">
            <div class="search-window">
              
                    <div class="search-wrap">
                        <label for="search" class="blind">공지사항 내용 검색</label>
                        <input id="search" type="search" name="" placeholder="검색어를 입력해주세요." value="">             
                        <button type="button" class="btn btn-dark">검색</button>             
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
                    <th scope="col" class="th-answer">답변여부</th>
                </tr>
                
                </thead>
               

		<c:forEach items="${qnaList}"  var="qnaVO">
			<tr ><td> ${qnaVO.lqseq}</td>    
	    		<td><a href="world.do?command=adminqnaView&lqseq=${qnaVO.lqseq}">${qnaVO.title}</a></td>      
	       		<td><fmt:formatDate value="${qnaVO.indate}" type="date"/></td>
	       		<td><c:choose>
					<c:when test="${qnaVO.rep=='N'}"> no </c:when>
					<c:when test="${qnaVO.rep=='Y'}"> yes </c:when>
				</c:choose></td>    
	   		</tr>
	  	</c:forEach>

            </table>
        </div>
    </div>

</section>


<jsp:include page="../../paging/page.jsp">
	<jsp:param name="command" value="world.do?command=adminqna" />
</jsp:include>

<div  class="clear"></div><br>





<%@ include file="../footer.jsp" %>