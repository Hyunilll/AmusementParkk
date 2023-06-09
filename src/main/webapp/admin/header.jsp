<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>World admin</title>
<script src="admin/script/admin.js"></script>
<script src="script/jquery-3.6.4.js"></script>
<script src="script/script.js"></script>
<link href="admin/css/admincss.css" rel="stylesheet"> 
</head>

<body>
<div id="wrap">
	<header>
		<nav id ="top_menu">
			<ul>
				<li><a href="world.do?command=logout">logout</a></li>
				<li>${loginAdmin.name}(${loginAdmin.id})</li>
			</ul>
		</nav>
		
		<div id="sub_menu">
			<div class="logo">
				<a href="world.do?command=adminMain">
					<img src="images/mainlogo.jpg"/>
				</a>
			</div>
			
			<div class="category">
				<ul class="category_top_menu">	
					<li><a href="world.do?command=adminattractionForm&changMenu=1">어트렉션 관리</a></li>
					<li><a href="world.do?command=adminnotice&changMenu=1">공지사항 관리</a></li>
					<li><a href="world.do?command=adminmember&changMenu=1">회원 관리</a></li>
					<li><a href="world.do?command=adminqna&changMenu=1">Q & A 관리</a></li>
				</ul>		
			</div>
		</div>
</header>

		
			

