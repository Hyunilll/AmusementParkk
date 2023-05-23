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
	    MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
	    if (mvo == null) {
	    	url = "world.do?command=LoginForm";
	    } else {
	    	
	    	QnaDao qdao = QnaDao.getInstance();
	    	
	    	int page = 1;
	    	if( request.getParameter("page") != null )
	    		page = Integer.parseInt( request.getParameter("page") );
	    	
	    	Paging paging = new Paging();
	    	paging.setPage(page);
	    	
	    	int count = qdao.getAllCount();
	    	paging.setTotalCount(count);
	    	
	    	ArrayList<QnaVO> list = qdao.selectQna( paging );
	    	
	    	request.setAttribute("qnaList", list);
	    	request.setAttribute("paging", paging);
	    }
	    request.getRequestDispatcher(url).forward(request, response);
	}


	}
