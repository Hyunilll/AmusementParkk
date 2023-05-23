package com.ezen.world.controller;


import com.ezen.world.controller.action.Action;
import com.ezen.world.controller.action.IndexAction;
import com.ezen.world.controller.action.admin.AdminAction;
import com.ezen.world.controller.action.admin.AdminMainAction;
import com.ezen.world.controller.action.admin.AdminattractionFormAction;
import com.ezen.world.controller.action.admin.AdminloginAction;
import com.ezen.world.controller.action.admin.AdminmemberAction;
import com.ezen.world.controller.action.admin.AdminnoticeAction;
import com.ezen.world.controller.action.attraction.AttractionDetailFormAction;
import com.ezen.world.controller.action.attraction.AttractionFormAction;
import com.ezen.world.controller.action.guide.GuideAction;
import com.ezen.world.controller.action.member.ContractAction;
import com.ezen.world.controller.action.member.EditAction;
import com.ezen.world.controller.action.member.EditFormAction;
import com.ezen.world.controller.action.member.FindZipNumAction;
import com.ezen.world.controller.action.member.IdCheckFormAction;
import com.ezen.world.controller.action.member.JoinAction;
import com.ezen.world.controller.action.member.JoinFormAction;
import com.ezen.world.controller.action.member.LoginFormAction;
import com.ezen.world.controller.action.member.LogoutAction;
import com.ezen.world.controller.action.member.loginAction;
import com.ezen.world.controller.action.notice.NoticeAction;
import com.ezen.world.controller.action.notice.NoticeDetailAction;
import com.ezen.world.controller.action.order.PassTicketAction;
import com.ezen.world.controller.action.order.ReserveAction;
import com.ezen.world.controller.action.parade.ParadeAction;
import com.ezen.world.controller.action.qna.QnaAction;
import com.ezen.world.controller.action.qna.QnaListAction;
import com.ezen.world.controller.action.qna.QnaViewAction;
import com.ezen.world.controller.action.qna.QnaWriteAction;
import com.ezen.world.controller.action.qna.QnaWriteFormAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() {return itc;}

	
	public Action getAction(String command) {
		Action ac = null;
		if( command.equals("index") ) ac = new IndexAction();
		
		// 멤버
		else if( command.equals("loginForm") ) ac = new LoginFormAction();
		else if( command.equals("login") ) ac = new loginAction();
		else if( command.equals("logout") ) ac = new LogoutAction();
		else if( command.equals("contract") ) ac = new ContractAction();
		else if( command.equals("joinForm") ) ac = new JoinFormAction();
		else if( command.equals("idCheckForm") ) ac = new IdCheckFormAction();
		else if( command.equals("findZipNum") ) ac = new FindZipNumAction();
		else if( command.equals("join") ) ac = new JoinAction();
		
		// 정보 수정 
		else if( command.equals("editForm") ) ac = new EditFormAction(); // 수정창 이동
		else if( command.equals("edit") ) ac = new EditAction(); // 수정
		
		
		// 어트랙션
		else if( command.equals("attractionForm") ) ac= new AttractionFormAction(); // 어트렉션 이동
		else if( command.equals("attractionDetailForm") ) ac = new AttractionDetailFormAction();
		
		
		//퍼레이드창
		else if( command.equals("parade") ) ac= new ParadeAction(); // 페러이드창 이동

		//예매창
		else if( command.equals("reserve") ) ac= new ReserveAction(); // 예매창 이동
		else if( command.equals("passTicket") ) ac= new PassTicketAction(); // 예매창 이동

		
		//이용가이드
		else if( command.equals("guide") ) ac= new GuideAction(); // 이용가이드 이동 
		 		
		//공지사항
		else if( command.equals("notice") ) ac= new NoticeAction(); // 공지사항 이동
		else if( command.equals("noticeDetail") ) ac= new NoticeDetailAction(); // 공지디테일 이동 
		
		//qna
		else if( command.equals("qna") ) ac = new QnaAction();
		else if( command.equals("qnaList") ) ac = new QnaListAction();
		else if( command.equals("qnaView") ) ac = new QnaViewAction();
		else if( command.equals("qnaWriteForm") ) ac = new QnaWriteFormAction();
		else if( command.equals("qnaWrite") ) ac = new QnaWriteAction();
		
		//admin 
		else if( command.equals("admin") ) ac= new AdminAction();//관리자 로그인 페이지
		else if( command.equals("adminlogin") ) ac= new AdminloginAction();//관리자 로그인 동작
		else if( command.equals("adminMain") ) ac= new AdminMainAction();// 관리자로 로그인한 메인페이지
		else if( command.equals("adminattractionForm") ) ac= new AdminattractionFormAction();//어트렉션 관리페이지 이동
		else if( command.equals("adminmember") ) ac= new AdminmemberAction();// 맴버 관리로 이동
		else if( command.equals("adminnotice") ) ac= new AdminnoticeAction();
		
		
		
		
		
		
		return ac;
	}
	
	
}
