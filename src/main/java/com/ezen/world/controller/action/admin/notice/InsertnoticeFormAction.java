package com.ezen.world.controller.action.admin.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dto.AdminVo;

public class InsertnoticeFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		AdminVo avo = (AdminVo)session.getAttribute("loginAdmin");
		
		String url = "admin/adminNotice/insertnoticeForm.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);

	}

}
