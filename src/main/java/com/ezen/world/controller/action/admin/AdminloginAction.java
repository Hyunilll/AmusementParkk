package com.ezen.world.controller.action.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.AdminDao;
import com.ezen.world.dto.AdminVo;

public class AdminloginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		String pwd= request.getParameter("pwd");
		
		AdminDao adao =AdminDao.getInstance();
		AdminVo avo = adao.getAdminMember(id);
		
		String url ="world.do?command=admin";
		
		if(avo==null)
			request.setAttribute("message", "없는 아이디입니다");	
		else if(avo.getPwd()==null)
			request.setAttribute("message", "DB오류");
		else if(!avo.getPwd().equals(pwd))
			request.setAttribute("message", "비밀번호 틀림");
		else if(avo.getPwd().equals(pwd)) {
			HttpSession session = request.getSession();
			session.setAttribute("loginAdmin", avo);
		url="world.do?command=adminMain";
		}else
		request.setAttribute("message", "로그인 실패 관리자에게 문의 하세요");
		
	RequestDispatcher dp = request.getRequestDispatcher(url);
	dp.forward(request, response);


	}

}

