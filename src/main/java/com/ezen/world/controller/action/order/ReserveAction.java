package com.ezen.world.controller.action.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ezen.world.controller.action.Action;


public class ReserveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 /*
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");    
		String url = "";
		if (loginUser == null) {
		  	url = "world.do?command=loginForm";
		}else {
			url = "order/reserve.jsp"; 
		}
*/
		String url = "order/reserve.jsp";
		RequestDispatcher dp=request.getRequestDispatcher(url);
		dp.forward(request, response); 

	}

}
