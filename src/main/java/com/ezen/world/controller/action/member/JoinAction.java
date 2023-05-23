package com.ezen.world.controller.action.member;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.world.controller.action.Action;
import com.ezen.world.dao.MemberDao;
import com.ezen.world.dto.MemberVo;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao mdao = MemberDao.getInstance();
		MemberVo mvo = new MemberVo();
		
		mvo.setId(request.getParameter("id"));
		mvo.setPwd(request.getParameter("pwd"));
		mvo.setName(request.getParameter("name"));
		mvo.setEmail(request.getParameter("email"));
		mvo.setZip_num(request.getParameter("zip_num"));
		mvo.setAddress1(request.getParameter("address1"));
		mvo.setAddress2(request.getParameter("address2"));
		mvo.setPhone(request.getParameter("phone"));

		int result = mdao.insertMember(mvo);
		String message="";
		
		
		if(result==1)  message ="회원가입 완료~! 로그인하세요!";
		else message= "회원가입 실패~! 다음에 다시 시도하세요! 계속실패하면 관리자에게 문의하세요";

		//포워딩을 사용하면 새로고침시 오류 발생 가능
		response.sendRedirect("world.do?command=loginForm&message=" 
		+ URLEncoder.encode( message,"UTF-8"));

	}

}
