package com.ezen.world.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.AdminDao;
import com.ezen.world.dto.AdminVo;
import com.ezen.world.dto.MemberVo;
import com.ezen.world.util.Paging;

public class AdminmemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="admin/adminmember/adminMemberList.jsp";
		HttpSession session = request.getSession();
		AdminVo avo = (AdminVo)session.getAttribute("loginAdmin");
		if(avo==null) {
			url="world.do?command=admin";
		}else {
			if(request.getParameter("changeMenu")!=null) {
				session.removeAttribute("page");
				session.removeAttribute("key");
			}
			//
			Paging paging =new Paging();
			paging.setDisplayPage(10);
			paging.setDisplayRow(10);

			if( request.getParameter("page")!=null) {
			paging.setPage(Integer.parseInt( request.getParameter("page"))) ;
			session.setAttribute("page", Integer.parseInt( request.getParameter("page")));
			}else if(session.getAttribute("page")!=null) {
				paging.setPage((Integer)session.getAttribute("page"));
			}
			else {
				paging.setPage(1);
			}
			String key="";
			if(request.getParameter("key")!=null) {
				key = request.getParameter("key");
				session.setAttribute("key", key);
		}else if( session.getAttribute("key")!=null ) {
			key = (String)session.getAttribute("key");
		}else {
			session.removeAttribute("key");
		}
			AdminDao adao =AdminDao.getInstance();
			int count =adao.getAllcount("Lmember", "name", key);
			paging.setTotalCount(count);
				
			ArrayList<MemberVo> memberList =adao.admiMemberList(paging, key);
			
			request.setAttribute("key", key);
			request.setAttribute("memberList", memberList);
			request.setAttribute("paging",paging);
		
			
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
