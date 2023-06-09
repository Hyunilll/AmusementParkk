package com.ezen.world.controller.action.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dto.MemberVo;

public class QnaAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "qna/qna.jsp";  
		
		RequestDispatcher dp=request.getRequestDispatcher(url);
		dp.forward(request, response);

		
	}

}
