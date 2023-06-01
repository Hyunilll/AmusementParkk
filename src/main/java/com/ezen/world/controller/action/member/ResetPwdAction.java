package com.ezen.world.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.MemberDao;

public class ResetPwdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		      String id = request.getParameter("id");
		      String pwd = request.getParameter("pwd");
		      MemberDao mdao = MemberDao.getInstance();
		      mdao.resetNewPwd(id, pwd);
		      request.setAttribute("result", 3);
		      request.getRequestDispatcher("member/resetPwd.jsp").forward(request, response);
		   }

}
