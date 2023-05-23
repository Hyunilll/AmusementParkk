package com.ezen.world.controller.action.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.world.controller.action.Action;

public class AdminAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "admin/adminLogin/adminLoginForm.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);

	}

}
