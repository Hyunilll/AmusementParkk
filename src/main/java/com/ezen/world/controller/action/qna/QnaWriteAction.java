package com.ezen.world.controller.action.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.QnaDao;
import com.ezen.world.dto.MemberVo;
import com.ezen.world.dto.QnaVO;

public class QnaWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "world.do?command=qnaList"; 
		HttpSession session = request.getSession();
	    MemberVo mvo = (MemberVo) session.getAttribute("loginUser");    
	    if (mvo == null) {
	    	url = "world.do?command=loginForm";
	    }else{
	    	QnaVO qvo = new QnaVO();
	    	qvo.setTitle(request.getParameter("title"));
	    	qvo.setContent(request.getParameter("content"));
	    	qvo.setId(request.getParameter("id"));
	    	QnaDao qdao = QnaDao.getInstance();
	    	qdao.insertQna(qvo);
	    }
	    response.sendRedirect(url);

	}
}
