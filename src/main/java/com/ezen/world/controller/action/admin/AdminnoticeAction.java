package com.ezen.world.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.NoticeDao;
import com.ezen.world.dto.NoticeVO;
import com.ezen.world.util.Paging;

public class AdminnoticeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/adminNotice/adminnotice.jsp";  
    	NoticeDao ndao = NoticeDao.getInstance();
    	
    	
    	int page = 1;
    	if( request.getParameter("page") != null )
    		page = Integer.parseInt( request.getParameter("page") );
    	
    	Paging paging = new Paging();
    	paging.setPage(page);
    	
    	int count = ndao.getAllCount();
    	paging.setTotalCount(count);
    	
    	ArrayList<NoticeVO> list = ndao.selectNotice( paging );
    	
    	request.setAttribute("noticeList", list);
    	request.setAttribute("paging", paging);
    
    request.getRequestDispatcher(url).forward(request, response);
    

	}

}
