package com.ezen.world.controller.action.admin.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.AdminDao;
import com.ezen.world.dto.AdminVo;

public class NoticeDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="world.do?command=adminnotice";
		HttpSession session = request.getSession();
		AdminVo avo = (AdminVo)session.getAttribute("loginAdmin");
		int nseq= Integer.parseInt(request.getParameter("nseq"));
		
		if(avo==null) {
			url="shop.do?command=admin";
		}else {
		    AdminDao adao = AdminDao.getInstance();
			adao.DeleteNotice(nseq);
			
		}
		
		request.getRequestDispatcher(url).forward(request, response);


	}

}
