package com.ezen.world.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.MemberDao;
import com.ezen.world.dto.MemberVo;

public class SelectIdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String name = request.getParameter("name");
	      String phone = request.getParameter("phone");

	      if (name != null && !name.isEmpty() && phone != null && !phone.isEmpty()) {
	          MemberDao mdao = MemberDao.getInstance();
	          MemberVo member = mdao.selectId(name, phone);
	          request.setAttribute("Lmember", member);
	      }
	      
	      RequestDispatcher dp = request.getRequestDispatcher("member/findId.jsp");
	      dp.forward(request, response); 

	   }
	}