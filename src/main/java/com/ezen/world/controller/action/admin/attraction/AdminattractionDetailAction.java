package com.ezen.world.controller.action.admin.attraction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.AttractionDao;
import com.ezen.world.dto.AttractionVO;

public class AdminattractionDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int aseq = Integer.parseInt(request.getParameter("aseq"));
		
		AttractionDao adao = AttractionDao.getInstance();
		AttractionVO avo = adao.getAttraction(aseq);
		request.setAttribute("AttractionVO", avo);
		
		String url = "admin/adminattraction/adminattractionDetail.jsp";
		request.getRequestDispatcher(url).forward(request, response);

	}

}
