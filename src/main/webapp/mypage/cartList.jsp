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
                    <th scope="col" class="th-date" style="text-align:center;">인원수</th>
                    <th scope="col" class="th-date" style="text-align:center;">가격</th>
                    <th scope="col" class="th-num">방문일자</th>
                    <th scope="col" class="th-num">가격</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cartList}"  var="cart2VO">
	                <tr>
	                	<td><fmt:formatDate value="${cart2VO.indate}" type="date"/></td>
	                    <td>${cart2VO.cseq}</td>
	                    <th>어른 : ${cart2VO.p1}<br> 
	                    	청소년 : ${cart2VO.p2}
	                    </th>
	                    <th> <fmt:formatNumber type="currency" value="${cart2VO.p1 * 53000}" /><br> 
	                 		 <fmt:formatNumber type="currency" value="${cart2VO.price2}" />
	                    </th>
	                    <td><fmt:formatDate value="${cart2VO.visitdate}" type="date"/></td>
	                    
	                	<td><fmt:formatNumber type="currency" value="${cart2VO.price1+cart2VO.price2}" /></td>
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