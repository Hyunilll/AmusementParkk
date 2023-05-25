<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.category {width: 1300px;margin: 0 auto; }
.category .category_top_menu li { display: block;font-family: '맑은 고딕'; font-size: 140%; margin: 20px 0; font-weight: bold;cursor: pointer;}
.category .subcategory { display: none; position: absolute; left: 0; top: 100%;} /* 추가된 속성 */
.category .subcategory.active {display: block; }
.category { position:relative; width: 1300px; height:85px; margin:0 auto; }
.category_top_menu li{  display:block;  height:10px;float:left; font-family: '맑은 고딕';
    font-size:140%; margin: 20px 0 10px 80px; font-weight:bold;}
.category_top_menu li:hover { color: blue; font-weight: bold;} 
</style>

<script>
    function toggleSubcategory(index) {
        var subcategories = document.getElementsByClassName('subcategory');
        var activeSubcategory = document.getElementsByClassName('active')[0];
        if (activeSubcategory) {
            activeSubcategory.classList.remove('active');
        }
        subcategories[index].classList.add('active');
    }
    
    function showSubcategory(index) {
        var subcategories = document.getElementsByClassName('subcategory');
        var activeSubcategory = document.getElementsByClassName('active')[0];
        if (activeSubcategory) {
            activeSubcategory.classList.remove('active');
        }
        subcategories[index].classList.add('active');
    }
    
    function hideSubcategory() {
        var subcategories = document.getElementsByClassName('subcategory');
        var activeSubcategory = document.getElementsByClassName('active')[0];
        if (activeSubcategory) {
            activeSubcategory.classList.remove('active');
        }
    }
</script>
</head>
<body>

<div class="category">
    <ul class="category_top_menu">
        <li onmouseover="showSubcategory(0);" onmouseout="hideSubcategory();">즐길거리&nbsp;&nbsp;</li>
        <li onmouseover="showSubcategory(1);" onmouseout="hideSubcategory();">예매하기&nbsp;&nbsp;</li>
        <li onmouseover="showSubcategory(2);" onmouseout="hideSubcategory();">이용가이드&nbsp;&nbsp;</li>
        <li onmouseover="showSubcategory(3);" onmouseout="hideSubcategory();">소통서비스&nbsp;&nbsp;</li>
    </ul>
    <div class="subcategory">
        <ul>
            <li>어트렉션</li>
            <li>페스티벌</li>
        </ul>
    </div>
    <div class="subcategory">
        <ul>
            <li>이달의 혜택</li>
        </ul>
    </div>
    <div class="subcategory">
        <ul>
            <li>운영/운휴</li>
            <li>오시는 길</li>
        </ul>
    </div>
    <div class="subcategory">
        <ul>
            <li>공지사항 </li>
            <li>QnA</li>
        </ul>
    </div>
 

</div>

</body>
</html>
