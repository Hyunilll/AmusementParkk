package com.ezen.world.controller.action.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.PassticketDao;
import com.ezen.world.dto.PassticketVO;

public class MypageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/cartList.jsp";  
		
		PassticketDao ptdao= PassticketDao.getInstance();
		ArrayList<PassticketVO> list =  ptdao.getticket();
		request.setAttribute("ticketList", list);
		
		
		RequestDispatcher dp=request.getRequestDispatcher(url);
		dp.forward(request, response); 

	}

}
