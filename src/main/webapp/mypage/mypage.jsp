<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>

<section class="notice">
  <div class="page-title">
        <div class="container">
            <h3 style="font-size: 28px;color: #333333;font-weight: 400;text-align: center;">나의 주문 내역</h3>
        </div>
    </div>


   
    <div class="board-list">
        <div class="container" style="width:800px; ">
            <table class="board-table">
                <thead>
                <tr>
                    <th scope="col" class="th-num">주문일자</th>
                    <th scope="col" class="th-num">주문번호</th>
                    <th scope="col" class="th-num">티켓유형</th>
                    <th scope="col" class="th-date" style="text-align:center;">인원수</th>
                    <th scope="col" class="th-num">어트랙션</th>
                    <th scope="col" class="th-num">방문일자</th>
                    <th scope="col" class="th-num">가격</th>
                    <th scope="col" class="th-num">삭제</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ticketList}"  var="TicketVO">
	                <tr>
	                	<td><fmt:formatDate value="${TicketVO.indate}" type="date"/></td>
	                    <td>${TicketVO.ptseq}</td>
	                    <td>유형</td>
	                    <th>어른 : ${TicketVO.aquantity}<br> 
	                    	청소년 : ${TicketVO.cquantity}
	                    </th>
	                    <td>어트렉션</td> 
	                    <td><fmt:formatDate value="${TicketVO.visitdate}" type="date"/></td>
	                	<td><fmt:formatNumber type="currency" value="${TicketVO.aquantity*TicketVO.apassprice 
	                	+ TicketVO.cquantity*TicketVO.cpassprice}" /></td>
	                	<td><input type="checkbox" name="ptseq" value="${TicketVO.ptseq}"></td>
	                </tr>
	          	</c:forEach>
                
                </tbody>
            </table>
        </div>
    </div>

</section>

<jsp:include page="../paging/page.jsp">
	<jsp:param name="command" value="world.do?command=mypage" />
</jsp:include>

<br><br><br><br><br><br><br>
 
<%@ include file="../footer.jsp" %>