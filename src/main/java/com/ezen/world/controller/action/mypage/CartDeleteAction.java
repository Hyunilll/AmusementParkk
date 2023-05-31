package com.ezen.world.controller.action.mypage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.Cart2Dao;


public class CartDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] cseqArr =request.getParameterValues("cseq");
		
		Cart2Dao cdao = Cart2Dao.getInstance();
		
		for( String cseq : cseqArr)
			cdao.deleteCart(Integer.parseInt(cseq));
		
		response.sendRedirect("world.do?command=cartList");

	}

}
