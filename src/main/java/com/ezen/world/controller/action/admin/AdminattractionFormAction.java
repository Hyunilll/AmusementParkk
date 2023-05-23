package com.ezen.world.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.AttractionDao;
import com.ezen.world.dto.AttractionVO;

public class AdminattractionFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		AttractionDao adao= AttractionDao.getInstance();
		ArrayList<AttractionVO> list =  adao.getattraction();
		request.setAttribute("aseqList", list);
		
		String url = "admin/adminattraction/adminattraction.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}

}
