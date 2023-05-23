package com.ezen.world.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.world.dao.AttractionDao;
import com.ezen.world.dto.AttractionVO;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AttractionDao adao= AttractionDao.getInstance();
		
		
		ArrayList<AttractionVO> bestList = adao.getBestattraction();
		request.setAttribute("bestList", bestList);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		dispatcher.forward(request, response);
	}

}
