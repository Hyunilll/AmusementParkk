<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

   <div class="event01">
      <div class="event02">
         <span> 공지사항 </span>
         </div>
         <div class="event_arg"></div>
         <div class="event03">
            <div class="event04">
            <p>공지</p>
         
            </div>
            
            <div class="event05">
            <p>${noticeVO.title} </p>
            
            </div>
            <div class="event06">
            <p><fmt:formatDate value="${noticeVO.indate}" type="date"/></p>
            
            </div>
               <div class="event_argg"></div>
            </div>

      <div class="event08">
      	<img src="images/notice_images/${noticeVO.ncontent}" width="1300" height="5000px" >
      </div>

   
   <div class="event09">
      <div class="event10">
         <input type="button" value="목 록"  class="submit" onclick="location.href='world.do?command=notice'">
      
      </div>
   
   </div>
   
</div>


<%@ include file="../footer.jsp" %>