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

public class DeleteMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVo mvo= (MemberVo)session.getAttribute("loginUser");
		MemberDao mdao = MemberDao.getInstance();
		int result = mdao.deleteMember(mvo.getId());
		 
		 if(result ==1) {
				session.removeAttribute("loginUser");
				request.setAttribute("message", "회원탈퇴완료");
			}
			
			RequestDispatcher dp = request.getRequestDispatcher("member/login.jsp");
			dp.forward(request, response);

	}

}
