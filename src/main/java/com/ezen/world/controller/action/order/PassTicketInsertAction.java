package com.ezen.world.controller.action.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.CartDao;
import com.ezen.world.dto.MemberVo;

public class PassTicketInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		HttpSession session = request.getSession();
		MemberVo mvo = (MemberVo)session.getAttribute("loginUser");
		String url="";
		if( mvo == null ) {
			url = "world.do?command=loginForm";
		}else {
			TicketVO tvo = new TicketVO();
			tvo.setId( tvo.getId() );
			tvo.setPseq( Integer.parseInt( request.getParameter("ptseq")));
			tvo.setAquantity( Integer.parseInt( request.getParameter("aquantity")));
			tvo.setCquantity( Integer.parseInt( request.getParameter("cquantity")));
			
			CartDao cdao = CartDao.getInstance();
			cdao.insertTicket( tvo );
			url = "world.do?command=cartList";
		}
		
		response.sendRedirect(url);


		RequestDispatcher dp=request.getRequestDispatcher(url);
		dp.forward(request, response); 
*/
	}

}
