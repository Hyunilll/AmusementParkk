<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
<style type="text/css">
#tabs{position:relative; margin: 100px auto; width:1080px; height:40px; text-align:center; margin-bottom:0px;}
ul{list-style:none; padding:0; margin:0; display:inline-block;}
ul li{width:178px; height:40px; float:left; border-radius: 5px 5px 0 0; line-height:40px; text-align: center; font-size: 120%; cursor:default; /*border:1px dashed black;*/}

#content{position:relative; margin:0 auto; width:1080px; height:440px;}
.contents{position:absolute; width:1080px; height:440px; left:0px; top:0px;  text-align:center; font-size:120%;}

#content1{background:#ebaa55;display:none;}
#content2{background:#55ebd1; display:none;}
#content3{background:#4fbde3; display:none;}
#content4{background:#6ebe6d; display:none;}
#content5{background:#95a096; display:none;}
#content6{background:#ed8d2a; display:none;}

</style>
<script src="script/jquery-3.6.4.js"></script>
<script type="text/javascript">
    // 제이쿼리 명령을 이용하여 ul li 들을 각 배경색을 해당 샊으로 맞춰주세요
    // 텝메뉴(ul li) 중 하나를 클릭하면 해당 content를 보이게 (show())하고 나머지를 감춰주세요(hide())
    $(function(){
        $('li:eq(0)').css('background','#ebaa55');
        $('li:eq(1)').css('background','#55ebd1');
        $('li:eq(2)').css('background','#4fbde3');
        $('li:eq(3)').css('background','#6ebe6d');
        $('li:eq(4)').css('background','#95a096');
        $('li:eq(5)').css('background','#ed8d2a');

        $('li').click(function(){
            var idx = $(this).index();
            var seletContent = '#content' + (idx+1);
            $('.contents').hide();
            $(seletContent).show();
        });
         
    });


</script>
</head>
<body>
    <div id="tabs">
        <ul>
            <li>즐길거리</li>
            <li>Menu B</li>
            <li>Menu C</li>
            <li>Menu D</li>
            <li>Menu E</li>
            <li>Menu F</li>
        </ul>
    </div>
    <div id="content">
        <div class="contents" id="content1"><a href="" >어트렉션</a><br><br>퍼레이드</div>
        <div class="contents" id="content2">Content B</div>
        <div class="contents" id="content3">Content C</div>
        <div class="contents" id="content4">Content D</div>
        <div class="contents" id="content5">Content E</div>
        <div class="contents" id="content6">Content F</div>
    </div>
</body>
</html>