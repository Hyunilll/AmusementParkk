package com.ezen.world.controller.action.qna;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.QnaDao;
import com.ezen.world.dto.MemberVo;
import com.ezen.world.dto.QnaVO;
import com.ezen.world.util.Paging;

public class QnaListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "qna/qnaList.jsp";
		
		HttpSession session = request.getSession();
		MemberVo mvo = (MemberVo)session.getAttribute("loginUser");
		
		if( mvo == null ) {
			url = "world.do?command=loginForm";
		}else {
	    	
	    	QnaDao qdao = QnaDao.getInstance();
	    	
	    	if( request.getParameter("changMenu")!=null) {
				session.removeAttribute("page");
				session.removeAttribute("key");
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
			
			String key="";
			if( request.getParameter("key") != null ) {
				key = request.getParameter("key");
				session.setAttribute("key", key);
			} else if( session.getAttribute("key") != null ) {
				key = (String)session.getAttribute("key");
			} else {
				key="";
				session.removeAttribute("key");
			}
	    	int count = qdao.getAllCount(key);
	    	paging.setTotalCount(count);
	    	
	    	ArrayList<QnaVO> list = qdao.selectQna( paging,key );
	    	
	    	request.setAttribute("qnaList", list);
	    	request.setAttribute("paging", paging);
	    	request.setAttribute("key", key);
	    }
	    request.getRequestDispatcher(url).forward(request, response);
	}


	}
