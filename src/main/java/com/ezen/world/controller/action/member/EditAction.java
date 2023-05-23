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

public class EditAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVo mvo = new MemberVo();
		mvo.setId(request.getParameter("id"));
		mvo.setPwd(request.getParameter("pwd"));
		mvo.setName(request.getParameter("name"));
		mvo.setEmail(request.getParameter("email"));
		mvo.setZip_num(request.getParameter("zip_num"));
		mvo.setAddress1(request.getParameter("address1"));
		mvo.setAddress2(request.getParameter("address2"));
		mvo.setPhone(request.getParameter("phone"));
		
		MemberDao mdao = MemberDao.getInstance();
		mdao.updateMember(mvo);
		
		HttpSession session=request.getSession(); 
		session.setAttribute("loginUser", mvo);
		RequestDispatcher dp=request.getRequestDispatcher("world.do?command=index");
		dp.forward(request, response);



	}

}
