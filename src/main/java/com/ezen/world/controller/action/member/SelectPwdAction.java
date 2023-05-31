package com.ezen.world.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.MemberDao;

public class SelectPwdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		String id = request.getParameter("id");
	    String name = request.getParameter("name");
	    String phone = request.getParameter("phone");
	    MemberDao mdao = MemberDao.getInstance();
	    int result = mdao.findMember(id, name, phone);
	    request.setAttribute("result", result);
	    request.setAttribute("id", id);
	    request.getRequestDispatcher("member/findPwd.jsp").forward(request, response);
	   }

	}
