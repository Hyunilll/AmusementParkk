package com.ezen.world.controller.action.guide;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.AttractionDao;
import com.ezen.world.dto.AttractionVO;

public class GuideAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AttractionDao adao= AttractionDao.getInstance();
		ArrayList<AttractionVO> aseqList =  adao.getrestattraction();
		request.setAttribute("aseqList", aseqList);
		
		
		String url = "guide/operation.jsp";  
		RequestDispatcher dp=request.getRequestDispatcher(url);
		dp.forward(request, response);

	}

}
