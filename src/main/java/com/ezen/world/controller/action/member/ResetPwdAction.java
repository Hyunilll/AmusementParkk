package com.ezen.world.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.MemberDao;
import com.ezen.world.dto.MemberVo;

public class ResetPwdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String id = request.getParameter("id");
	    String pwd = request.getParameter("pwd");
	    
	    MemberDao mdao = MemberDao.getInstance();
	  
	    mdao.resetNewPwd(id, pwd);
	    
	    request.setAttribute("result", 3);
	    
	    String message = "비밀번호 변경이 완료되었습니다.";
        String script = "<script>";
        script += "alert('" + message + "');";
        script += "window.close();";
        script += "</script>";
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println(script);
	}
}


