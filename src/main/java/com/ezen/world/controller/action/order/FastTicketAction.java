package com.ezen.world.controller.action.order;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.AttractionDao;
import com.ezen.world.dto.AttractionVO;
import com.ezen.world.dto.MemberVo;

public class FastTicketAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "order/fastTicket.jsp";  // 최종 목적지
		HttpSession session = request.getSession();
		MemberVo mvo = (MemberVo)session.getAttribute("loginUser");
		
		if( mvo == null ) {
			url = "world.do?command=loginForm";
		}else {
			AttractionDao adao= AttractionDao.getInstance();
	         ArrayList<AttractionVO> list =  adao.getattraction();
	         request.setAttribute("aseqList", list);
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
