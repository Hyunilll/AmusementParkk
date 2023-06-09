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

public class loginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		String pwd= request.getParameter("pwd");
		
		MemberDao mdao =MemberDao.getInstance();
		MemberVo mvo = mdao.getMember(id);
		
		String url ="member/login.jsp";
		
		if(mvo==null)
			request.setAttribute("message", "없는 아이디입니다");	
		else if(mvo.getPwd()==null)
			request.setAttribute("message", "DB오류");
		else if(!mvo.getPwd().equals(pwd))
			request.setAttribute("message", "비밀번호 틀림");
		else if(mvo.getPwd().equals(pwd)) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mvo);
		url="world.do?command=index";
		}else
		request.setAttribute("message", "로그인 실패 관리자에게 문의 하세요");
		
	RequestDispatcher dp = request.getRequestDispatcher(url);
	dp.forward(request, response);


	}

}
