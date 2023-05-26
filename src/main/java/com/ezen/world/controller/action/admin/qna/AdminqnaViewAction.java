package com.ezen.world.controller.action.admin.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.QnaDao;
import com.ezen.world.dto.AdminVo;
import com.ezen.world.dto.QnaVO;

public class AdminqnaViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/adminQna/adminQnaView.jsp";
		HttpSession session = request.getSession();
		AdminVo avo = (AdminVo)session.getAttribute("loginAdmin");
		if( avo == null) { 
			url = "world.do?command=admin"; 
		} else {
			String lqseq = request.getParameter("lqseq");
			QnaDao qdao = QnaDao.getInstance();   // 이미 생성되어 있는 메서드를 이용
			QnaVO qvo = qdao.getQna (Integer.parseInt(lqseq) ); // 이미 생성되어 있는 메서드를 이용
			request.setAttribute("qnaVO", qvo);
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

	

}
