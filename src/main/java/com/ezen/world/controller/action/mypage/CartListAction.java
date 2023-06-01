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
import com.ezen.world.util.Paging;

public class CartListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/cartList.jsp";  
		HttpSession session = request.getSession();
		MemberVo mvo = (MemberVo)session.getAttribute("loginUser");
		if(mvo == null) {
			url = "world.do?command=loginForm";
		} else {

			if( request.getParameter("changMenu")!=null) {
				session.removeAttribute("page");
				
			}
			Paging paging = new Paging();
			paging.setDisplayPage(10);
			paging.setDisplayRow(10);
			if( request.getParameter("page")!=null) {
				paging.setPage( Integer.parseInt( request.getParameter("page") ) );
				session.setAttribute("page", Integer.parseInt( request.getParameter("page")  ) );
			} else if( session.getAttribute("page") != null ) {
				paging.setPage( (Integer)session.getAttribute("page") );
			} else {
				paging.setPage(1);
			}
			
			Cart2Dao cdao = Cart2Dao.getInstance();
	       
			if(request.getParameterValues("cseq")!=null) {
	            
	            String[] cseqArr =request.getParameterValues("cseq");
	            for( String cseq : cseqArr)
	               cdao.cartOrder(Integer.parseInt(cseq));
	            
	            }
			
			int count = cdao.getAllCountCart2();
			paging.setTotalCount(count);
			
			ArrayList<Cart2VO> cartList = cdao.selectCart(mvo.getId());
			request.setAttribute("cartList", cartList);
			request.setAttribute("paging" , paging);
			
			
	
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}

