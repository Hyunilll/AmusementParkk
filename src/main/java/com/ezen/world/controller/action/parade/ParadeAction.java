package com.ezen.world.controller.action.parade;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.world.controller.action.Action;

public class ParadeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "parade/parade.jsp"; 
		
		RequestDispatcher dp=request.getRequestDispatcher(url);
		dp.forward(request, response);

	}

}
