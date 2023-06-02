package com.ezen.world.controller.action.order;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.Cart2Dao;
import com.ezen.world.dto.Cart2VO;
import com.ezen.world.dto.MemberVo;

public class PassTicketInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberVo mvo = (MemberVo)session.getAttribute("loginUser");
		String url="";
		if( mvo == null ) {
			url = "world.do?command=loginForm";
		}else {
			Cart2VO cvo = new Cart2VO();
			Cart2Dao cdao = Cart2Dao.getInstance();
			
			cvo.setId( mvo.getId() );
			cvo.setKind( Integer.parseInt( request.getParameter("kind")));
			cvo.setP1( Integer.parseInt( request.getParameter("p1")));
			cvo.setP2( Integer.parseInt( request.getParameter("p2")));
			
			//cvo.setVisitdate(request.getParameter("visitdate"));
		
			
			String dateStr = request.getParameter("visitdate"); // request 객체에서 날짜 정보를 받아옴
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 날짜 형식 지정
			
				 
			try {
				cvo.setVisitdate(dateFormat.parse(dateStr));
				System.out.println("날짜 파싱 성공");
			} catch (ParseException e) {
				e.printStackTrace();
				System.out.println("날짜 파싱 오류: " + e.getMessage());
			}
		
			
			
			int kind =  Integer.parseInt( request.getParameter("kind"));
			if(kind==0) {
				cvo.setPrice1(Integer.parseInt( request.getParameter("p1"))*53000);
				cvo.setPrice2(Integer.parseInt( request.getParameter("p2"))*30000);
			}
			if(kind==1) {
				cvo.setPrice1(Integer.parseInt( request.getParameter("p1"))*110000);
				cvo.setPrice2(Integer.parseInt( request.getParameter("p2"))*70000);
				String[] attrr =request.getParameterValues("attraction");
				
				cvo.setTatname1(attrr[0]);
				cvo.setTatname2(attrr[1]);
				cvo.setTatname3(attrr[2]);
				
			}
			
			
			cdao.insertTicket( cvo );
			url = "world.do?command=cartList";
		}
		

		response.sendRedirect(url);

	}

}
