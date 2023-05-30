package com.ezen.world.controller.action.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
			cvo.setId( mvo.getId() );
			cvo.setKind( Integer.parseInt( request.getParameter("kind")));
			cvo.setP1( Integer.parseInt( request.getParameter("p1")));
			cvo.setP2( Integer.parseInt( request.getParameter("p2")));
			
			Cart2Dao cdao = Cart2Dao.getInstance();
			cdao.insertTicket( cvo );
			url = "world.do?command=cartList";
		}
		
		response.sendRedirect(url);

		RequestDispatcher dp=request.getRequestDispatcher(url);
		dp.forward(request, response); 

	}

}
