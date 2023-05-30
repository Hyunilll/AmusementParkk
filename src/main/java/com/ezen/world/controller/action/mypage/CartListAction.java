package com.ezen.world.controller.action.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.Cart2Dao;
import com.ezen.world.dto.Cart2VO;
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
			Cart2Dao cdao = Cart2Dao.getInstance();
			ArrayList<Cart2VO> cartList = cdao.selectCart(mvo.getId());
			request.setAttribute("cartList", cartList);
			// 장바구니 물건을 한번에 주문했을때 결제할 총금액 계산
			
			Cart2VO cvo =new Cart2VO();
			int kind= cvo.getKind();
			int price1 = 0; //일반 어른 가격
			int price2 = 0;//일반 어린이 가격
			int price3 = 0;//패스 어른 가격
			int price4 = 0;//패스 어린이 가격
			int totalPrice = 0; //합계
			if(kind == 0) {
				price1= cvo.getP1() * 53000;
				price2= cvo.getP2() * 30000;
			}
			if(kind == 1) {
				price3= cvo.getP1() * 110000;
				price4= cvo.getP2() * 70000;
			}
			totalPrice =price1+price2+price3+price4;
			request.setAttribute("price1", price1);
			request.setAttribute("price2", price2);
			request.setAttribute("price3", price3);
			request.setAttribute("price4", price4);
			request.setAttribute("totalPrice", totalPrice);
			 
		}
		//RequestDispatcher rd = request.getRequestDispatcher(url);
		//rd.forward(request, response);
		request.getRequestDispatcher(url).forward(request, response);
		
	}
}
