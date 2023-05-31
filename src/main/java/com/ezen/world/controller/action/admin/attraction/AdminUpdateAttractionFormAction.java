package com.ezen.world.controller.action.admin.attraction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.AttractionDao;
import com.ezen.world.dto.AdminVo;
import com.ezen.world.dto.AttractionVO;


public class AdminUpdateAttractionFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="admin/adminattraction/AttractionUpdate.jsp";
		HttpSession session = request.getSession();
		AdminVo avo = (AdminVo)session.getAttribute("loginAdmin");
		if(avo==null) {
			url="world.do?command=admin";
		}else {
			//전달된 놀이기구번호로 놀이기구를 조회하고 리퀘스트에 저장
			int aseq = Integer.parseInt(request.getParameter("aseq"));
			AttractionDao adao = AttractionDao.getInstance();
			AttractionVO atvo = adao.getAttraction(aseq);
			request.setAttribute("AttractionVO", atvo);
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
