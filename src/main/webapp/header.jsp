<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>World</title>

<script src="script/jquery-3.6.4.js"></script>
<script src="script/script.js"></script>
<script src="notice/event02.js"></script>  
<script src="member/member.js"></script>
<link href="css/world.css" rel="stylesheet">

<style>
.dropdown {position: relative; display: inline-block; margin: 0 auto;}
.dropbtn {border: 1px solid white; border-radius: 4px; background-color: white; font-weight: bold; color: rgb(37, 37, 37); padding: 12px; width: 200px; text-align: center; cursor: pointer; font-size: 140%;}
.dropbtn:hover {color: blue; font-weight: bold;}
.dropdown-content {display: none; position: absolute; z-index: 2; font-weight: 400; background:#f7f7f7; min-width: 200px;}
.dropdown-content a {display: block; text-decoration: none; color: rgb(37, 37, 37); font-size: 100%; padding: 12px 20px; }
.dropdown-content a:hover {color: purple; font-weight: bold;}
.dropdown:hover .dropdown-content {display: block;}
</style>

</head>
<body>
<div id="wrap">
	<header>
		<div id ="top_menu">
			<ul>
				<c:choose>
					<c:when test ="${empty loginUser}">
						<li><a href="world.do?command=loginForm">login</a></li>
						<li><a href="world.do?command=contract">회원가입</a></li>
						<li><a href="world.do?command=admin">관리자</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="world.do?command=mypage">마이페이지</a></li>
						<li><a href="world.do?command=logout">logout</a></li>
						<li><a href="world.do?command=editForm">정보수정</a></li>
						<li>${loginUser.name}(${loginUser.id})</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		<div id="sub_menu">
			<div class="logo">
				<a href="world.do?command=index">
					<img src="images/mainlogo.png"/>
				</a>
			</div>

			<div class="dropdown">
      <button class="dropbtn"> 
        <span style="">즐길거리</span>
      </button>
      <div class="dropdown-content">
        <a href="world.do?command=attractionForm">어트렉션</a>
        <a href="world.do?command=parade">퍼레이드</a>
      </div>
    </div>
    <div class="dropdown">
      <button class="dropbtn"> 
        <span >예매하기</span>
      </button>
      <div class="dropdown-content">
        <a href="world.do?command=reserve">예매</a>
        <a href="world.do?command=event01">이달의 혜택</a>
      </div>
    </div>
    <div class="dropdown">
      <button class="dropbtn"> 
        <span >이용가이드</span>
      </button>
      <div class="dropdown-content">
        <a href="world.do?command=guide">운영/운휴</a>
        <a href="world.do?command=howCome">오시는 길</a>
      </div>
    </div>
    <div class="dropdown">
      <button class="dropbtn"> 
        <span >소통서비스</span>
      </button>
      <div class="dropdown-content">
        <a href="world.do?command=notice">공지사항</a>
        <a href="world.do?command=qna">Q&amp;A</a>
      </div>
			

		</div>
	</header>

		
			

