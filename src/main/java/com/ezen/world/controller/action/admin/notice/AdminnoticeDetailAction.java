package com.ezen.world.controller.action.admin.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.NoticeDao;
import com.ezen.world.dto.AdminVo;
import com.ezen.world.dto.NoticeVO;

public class AdminnoticeDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/adminNotice/adminnoticeDetail.jsp";
		int nseq = Integer.parseInt( request.getParameter("nseq") );
		
		HttpSession session = request.getSession();
	    AdminVo avo = (AdminVo) session.getAttribute("loginAdmin");
	    if (avo == null) {
	        url = "world.do?command=admin";
	    } else {	
	    	NoticeDao ndao = NoticeDao.getInstance();
	    	NoticeVO nvo = ndao.getnotice( nseq );
	    	request.setAttribute("noticeVO", nvo);
	    }
		request.getRequestDispatcher(url).forward(request, response);

	}


}

