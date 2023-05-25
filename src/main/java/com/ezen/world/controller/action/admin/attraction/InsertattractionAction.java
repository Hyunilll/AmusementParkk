package com.ezen.world.controller.action.admin.attraction;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.AdminDao;
import com.ezen.world.dto.AdminVo;
import com.ezen.world.dto.AttractionVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class InsertattractionAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="world.do?command=adminattractionForm";
		HttpSession session = request.getSession();
		AdminVo avo = (AdminVo)session.getAttribute("loginAdmin");

		if(avo==null) {
			url="world.do?command=admin";
		}else {
			//MultipartRequest 를 이용해서 레코드를 추가하고 목적지로 돌아가는 코드
			ServletContext context =session.getServletContext();
			String path =context.getRealPath("images/attraction_images");
			
			AttractionVO atvo=new AttractionVO();
			MultipartRequest multi =new MultipartRequest(
					request, path, 5*1024*1024,"UTF-8", new DefaultFileRenamePolicy()
			);
			atvo.setAtname(multi.getParameter("atname"));
			atvo.setAcontent(multi.getParameter("acontent"));
			atvo.setAct1(multi.getParameter("act1"));
			atvo.setAct2(multi.getParameter("act2"));
			atvo.setImage( multi.getFilesystemName("image"));
			atvo.setPnum(Integer.parseInt(multi.getParameter("pnum")));
			atvo.setLimitkey(multi.getParameter("limitkey"));
			atvo.setLimitage(multi.getParameter("limitage"));
			atvo.setBestat(multi.getParameter("bestat"));
			atvo.setAresult(multi.getParameter("aresult"));
			AdminDao adao = AdminDao.getInstance();
			adao.insertAttraction(atvo);
		}
		response.sendRedirect(url);

	}

}
