package com.ezen.world.controller.action.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.world.controller.action.Action;

public class AdminMainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "admin/adminLogin/adminMain.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);


	}

}
