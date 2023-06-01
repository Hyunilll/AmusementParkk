
package com.ezen.world.controller;


import com.ezen.world.controller.action.Action;
import com.ezen.world.controller.action.IndexAction;
import com.ezen.world.controller.action.admin.AdminAction;
import com.ezen.world.controller.action.admin.AdminMainAction;
import com.ezen.world.controller.action.admin.AdminattractionFormAction;
import com.ezen.world.controller.action.admin.AdminloginAction;
import com.ezen.world.controller.action.admin.AdminmemberAction;
import com.ezen.world.controller.action.admin.AdminnoticeAction;
import com.ezen.world.controller.action.admin.AdminqnaAction;
import com.ezen.world.controller.action.admin.attraction.AdminUpdateAttractionFormAction;
import com.ezen.world.controller.action.admin.attraction.AdminattractionDetailAction;
import com.ezen.world.controller.action.admin.attraction.AttractionDeleteAction;
import com.ezen.world.controller.action.admin.attraction.InsertAttractionFormAction;
import com.ezen.world.controller.action.admin.attraction.InsertattractionAction;
import com.ezen.world.controller.action.admin.attraction.UpdateAttractionAction;
import com.ezen.world.controller.action.admin.notice.AdminUpdateNoticeFormAction;
import com.ezen.world.controller.action.admin.notice.AdminnoticeDetailAction;
import com.ezen.world.controller.action.admin.notice.InsertnoticeFormAction;
import com.ezen.world.controller.action.admin.notice.NoticeDeleteAction;
import com.ezen.world.controller.action.admin.notice.NoticeUpdateAction;
import com.ezen.world.controller.action.admin.notice.insertnoticeAction;
import com.ezen.world.controller.action.admin.qna.AdminQnaRepSaveAction;
import com.ezen.world.controller.action.admin.qna.AdminqnaViewAction;
import com.ezen.world.controller.action.attraction.AttractionDetailFormAction;
import com.ezen.world.controller.action.attraction.AttractionFormAction;
import com.ezen.world.controller.action.event.Event01Action;
import com.ezen.world.controller.action.guide.GuideAction;
import com.ezen.world.controller.action.guide.HowComeAction;
import com.ezen.world.controller.action.member.ContractAction;
import com.ezen.world.controller.action.member.EditAction;
import com.ezen.world.controller.action.member.EditFormAction;
import com.ezen.world.controller.action.member.FindZipNumAction;
import com.ezen.world.controller.action.member.IdCheckFormAction;
import com.ezen.world.controller.action.member.JoinAction;
import com.ezen.world.controller.action.member.JoinFormAction;
import com.ezen.world.controller.action.member.LoginFormAction;
import com.ezen.world.controller.action.member.LogoutAction;
import com.ezen.world.controller.action.member.ResetPwdAction;
import com.ezen.world.controller.action.member.SelectIdAction;
import com.ezen.world.controller.action.member.SelectPwdAction;
import com.ezen.world.controller.action.member.loginAction;
import com.ezen.world.controller.action.mypage.CartDeleteAction;
import com.ezen.world.controller.action.mypage.CartListAction;
import com.ezen.world.controller.action.notice.NoticeAction;
import com.ezen.world.controller.action.notice.NoticeDetailAction;
import com.ezen.world.controller.action.order.FastTicketAction;
import com.ezen.world.controller.action.order.PassTicketAction;
import com.ezen.world.controller.action.order.PassTicketInsertAction;
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
		else if( command.equals("passTicket") ) ac= new PassTicketAction(); // 자유이용권 예매창 이동
		else if( command.equals("fastTicket") ) ac= new FastTicketAction(); // 패스트패스 예매창 이동
		else if( command.equals("passTicketInsert") ) ac= new PassTicketInsertAction(); // 자유이용권 장바구니에 정보 저장
		
		// 장바구니  
		else if( command.equals("cartList") ) ac= new CartListAction(); // 자유이용권 장바구니에 정보 저장
		else if( command.equals("cartDelete") ) ac= new CartDeleteAction();
	
		
		//이용가이드
		else if( command.equals("guide") ) ac= new GuideAction(); // 이용가이드 이동 
		else if( command.equals("howCome") ) ac= new HowComeAction(); // 오시는 길 이동
		
		 		
		//공지사항
		else if( command.equals("notice") ) ac= new NoticeAction(); // 공지사항 이동
		else if( command.equals("noticeDetail") ) ac= new NoticeDetailAction(); // 공지디테일 이동 
		
		//qna
		else if( command.equals("qna") ) ac = new QnaAction();
		else if( command.equals("qnaList") ) ac = new QnaListAction();
		else if( command.equals("qnaView") ) ac = new QnaViewAction();
		else if( command.equals("qnaWriteForm") ) ac = new QnaWriteFormAction();
		else if( command.equals("qnaWrite") ) ac = new QnaWriteAction();
		
		//admin 카테고리
		else if( command.equals("admin") ) ac= new AdminAction();//관리자 로그인 페이지
		else if( command.equals("adminlogin") ) ac= new AdminloginAction();//관리자 로그인 동작
		else if( command.equals("adminMain") ) ac= new AdminMainAction();// 관리자로 로그인한 메인페이지
		else if( command.equals("adminattractionForm") ) ac= new AdminattractionFormAction();//어트렉션 관리페이지 이동
		else if( command.equals("adminmember") ) ac= new AdminmemberAction();// 맴버 관리로 이동
		else if( command.equals("adminnotice") ) ac= new AdminnoticeAction();//공지사항 관리로 이동
		else if( command.equals("adminqna") ) ac= new AdminqnaAction();
				
		//admin notice 
		else if( command.equals("adminnoticeDetail") ) ac= new AdminnoticeDetailAction();
		else if( command.equals("insertnoticeForm") ) ac= new InsertnoticeFormAction();
		else if( command.equals("insertnotice") ) ac= new insertnoticeAction();
		else if( command.equals("adminUpdateNoticeForm") ) ac= new AdminUpdateNoticeFormAction();
		else if( command.equals("noticeUpdate") ) ac= new NoticeUpdateAction();
		else if( command.equals("noticeDelete") ) ac= new NoticeDeleteAction();
				
		//admin attraction  insertattraction
		else if( command.equals("insertAttractionForm") ) ac= new InsertAttractionFormAction();
		else if( command.equals("insertattraction") ) ac= new InsertattractionAction();
		else if( command.equals("adminattractionDetail") ) ac= new AdminattractionDetailAction();
		else if( command.equals("adminUpdateAttractionForm") ) ac= new AdminUpdateAttractionFormAction();
	     else if( command.equals("updateAttraction") ) ac= new UpdateAttractionAction();
	     else if( command.equals("attractionDelete") ) ac= new AttractionDeleteAction();
		
		
		// admin qna 
		else if( command.equals("adminqnaView") ) ac= new AdminqnaViewAction(); // 디테일 이동
		else if( command.equals("adminQnaRepSave") ) ac= new AdminQnaRepSaveAction(); // 댓글 추가
		
		//이달의 혜택
		else if( command.equals("event01") ) ac= new Event01Action();
		
		// 아이디 비번 찾기
		else if( command.equals("selectId") ) ac= new SelectIdAction();
		else if( command.equals("selectPwd") ) ac= new SelectPwdAction();
		else if( command.equals("resetPwd") ) ac= new ResetPwdAction();

		
		return ac;
	}
	
	
}
