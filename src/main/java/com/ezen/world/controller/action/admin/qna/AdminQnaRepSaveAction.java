package com.ezen.world.controller.action.admin.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.AdminDao;
import com.ezen.world.dto.AdminVo;
import com.ezen.world.dto.QnaVO;

public class AdminQnaRepSaveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "world.do?command=adminqnaView";
		HttpSession session = request.getSession();
		AdminVo avo = (AdminVo)session.getAttribute("loginAdmin");
		if( avo == null) url="world.do?command=admin";
		else {
			AdminDao adao = AdminDao.getInstance();
			QnaVO qvo = new QnaVO();
			qvo.setLqseq( Integer.parseInt( request.getParameter("lqseq") ) );
			qvo.setReply( request.getParameter("reply") );
			adao.updateQna( qvo );
			url = url + "&lqseq=" + qvo.getLqseq();
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
