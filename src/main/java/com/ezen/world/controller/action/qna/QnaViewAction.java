package com.ezen.world.controller.action.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.QnaDao;
import com.ezen.world.dto.QnaVO;

public class QnaViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		int lqseq = Integer.parseInt(request.getParameter("lqseq"));
		
		QnaDao qdao = QnaDao.getInstance();
		QnaVO qvo = qdao.getQna(lqseq);
		request.setAttribute("qnaVO", qvo);
		
		String url = "qna/qnaView.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	
	}
}
