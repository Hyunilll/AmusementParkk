package com.ezen.world.controller.action.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.CartDao;
import com.ezen.world.dto.CartVO;
import com.ezen.world.dto.MemberVo;

public class CartListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "mypage/cartList.jsp";  // 최종 목적지
		HttpSession session = request.getSession();
		MemberVo mvo = (MemberVo)session.getAttribute("loginUser");
		if(mvo == null) {
			url = "world.do?command=loginForm";
		} else {
			// 로그인 유저의 아이디로 카트 리스트를 검색해서 리턴 받습니다
			CartDao cdao = CartDao.getInstance();
			ArrayList<CartVO> list = cdao.selectCart( mvo.getId() );
			request.setAttribute("cartList", list);
			// 장바구니 물건을 한번에 주문했을때 결제할 총금액 계산
			/*
			int totalPrice = 0;
			for( CartVO cvo : list) 
				totalPrice += ( cvo.getPrice2() * cvo.getQuantity() );
			request.setAttribute("totalPrice", totalPrice);
			 */
		}
		//RequestDispatcher rd = request.getRequestDispatcher(url);
		//rd.forward(request, response);
		request.getRequestDispatcher(url).forward(request, response);
		
	}
}
