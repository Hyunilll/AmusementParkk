package com.ezen.world.controller.action.admin.notice;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.AdminDao;
import com.ezen.world.dto.AdminVo;
import com.ezen.world.dto.NoticeVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class NoticeUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="world.do?command=adminnoticeDetail";
		HttpSession session = request.getSession();
		AdminVo avo = (AdminVo)session.getAttribute("loginAdmin");
		if(avo==null) {
			url="world.do?command=admin";
		}else {
			NoticeVO nvo = new NoticeVO();
			ServletContext context = session.getServletContext();
		    String path = context.getRealPath("images/notice_images");
		    MultipartRequest multi = new MultipartRequest( 
		    		request,	path,	 5*1024*1024, "UTF-8",	 new DefaultFileRenamePolicy()  );
		    nvo.setNseq(Integer.parseInt( multi.getParameter("nseq") ));
			nvo.setTitle(multi.getParameter("title"));
			nvo.setNcontent( multi.getFilesystemName("ncontent") );
			nvo.setId(multi.getParameter("id"));
			
			
		    if(multi.getFilesystemName("ncontent")==null)nvo.setNcontent(multi.getParameter("oldImage"));
		    else 	nvo.setNcontent( multi.getFilesystemName("ncontent") );
		    AdminDao adao = AdminDao.getInstance();
			adao.updateNotice(nvo);
		    url = url + "&nseq=" + nvo.getNseq();
			
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
