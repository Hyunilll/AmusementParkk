package com.ezen.world.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.MemberDao;
import com.ezen.world.dto.MemberVo;

public class ResetPwdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberVo mvo = new MemberVo();
		mvo.setPwd(request.getParameter("id"));
		mvo.setPwd(request.getParameter("pwd"));
		      
		MemberDao mdao = MemberDao.getInstance();
		mdao.resetNewPwd(mvo);
		HttpSession session=request.getSession(); 
		session.setAttribute("loginUser", mvo);
		RequestDispatcher dp=request.getRequestDispatcher("world.do?command=");
		dp.forward(request, response);
		   }

}


