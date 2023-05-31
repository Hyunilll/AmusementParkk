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

public class UpdateAttractionAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="world.do?command=adminattractionDetail";
		HttpSession session = request.getSession();
		AdminVo avo = (AdminVo)session.getAttribute("loginAdmin");
		
		if(avo==null) {
			url="world.do?command=admin";
		}else {
			AttractionVO atvo = new AttractionVO();
			ServletContext context = session.getServletContext();
		    String path = context.getRealPath("images/attraction_images");
		    MultipartRequest multi = new MultipartRequest( 
		    		request,	path,	 5*1024*1024, "UTF-8",	 new DefaultFileRenamePolicy()  );
		   
		    atvo.setAseq(Integer.parseInt( multi.getParameter("aseq")));
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
			
			
		    if(multi.getFilesystemName("image")==null)atvo.setImage(multi.getParameter("oldImage"));
		    else 	atvo.setImage( multi.getFilesystemName("image") );
		    AdminDao adao = AdminDao.getInstance();
			adao.updateAttraction(atvo);
		    url = url + "&aseq=" + atvo.getAseq();
			
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
