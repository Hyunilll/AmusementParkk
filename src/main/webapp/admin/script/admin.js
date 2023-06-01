function adminloginCheck(){  //관리자 로그인시 아이디 비번 입력 확인
	
	if(document.frm.id.value==""){
		   	alert("아이디를 입력하세요.");
		  	return false;
		}else if(document.frm.pwd.value==""){
		  	alert("비밀번호를 입력하세요.");
		   	return false;
		}else{
	document.frm.action = "world.do?command=adminlogin";
	document.frm.submit();
			return true;
		}  
}

function go_manage(comm){
	var url = "world.do?command=" + comm;   // 검색어로 검색한 결과의 1페이지로 이동
	document.frm.action = url;
	document.frm.submit();
}

function go_search(comm){
	 if( document.frm.key.value == "" ){
		alert("검색버튼 사용시에는 검색어 입력이 필수입니다");
	 	return;
	} 
	var url = "world.do?command=" + comm + "&page=1";   // 검색어로 검색한 결과의 1페이지로 이동
	document.frm.action = url;
	document.frm.submit();
	
}


function go_total(comm ){
	document.frm.key.value = "";
	document.frm.action = "world.do?command=" + comm + "&page=1";
	document.frm.submit();
}



//------ 공지사항 ------
function go_insertform(comm){ //공지추가 폼으로 이동
	document.frm.action = "world.do?command="+comm;
	document.frm.submit();
}

function go_insertnt(){ //공지추가 동작액션으로 이동
	if( document.insertnt.title.value==""){ 
		alert('제목을 입력하세요');
		document.insertnt.title.focus();
	}else if (document.insertnt.ncontent.value == "") {
		alert('공지할 사진을 입력하세요.'); 	
		document.insertnt.ncontent.focus();	
	}else{
	document.insertnt.action = "world.do?command=insertnotice";
	document.insertnt.submit();
	}
}



function go_mov(comm){ // 공지사항 목록으로 이동
	document.insertnt.action = "world.do?command="+comm;
	document.insertnt.submit();
}

function go_deletent(nseq){ //공지 삭제
	if(confirm('정말 삭제하시겠습니까?')){
		var url="world.do?command=noticeDelete&nseq="+nseq;
		location.href=url;
	}
}

function go_modnt(nseq){ // 공지 수정폼으로 이동
	var url="world.do?command=adminUpdateNoticeForm&nseq="+nseq;
	location.href=url;
}

function go_mod_savent(){ // 공지 수정 버튼 클릭
	if( document.updatent.title.value==""){  
		alert('제목을 입력하세요');
		document.updatent.title.focus();
	}else{
	if(confirm('수정하시겠습니까?')){
	document.updatent.action = "world.do?command=noticeUpdate";
	document.updatent.submit();
		}
	}
}

// 놀이기구 ----------------------------------------------------------------------------
function go_insertat(){
	if( document.insertnt.atname.value==""){ 
		alert('놀이기구 이름을 입력하세요');
		document.insertnt.atname.focus();
		
	}else if (document.insertnt.acontent.value == "") {
		alert('놀이기구 설명을 입력하세요.'); 	
		document.insertnt.acontent.focus();	
		
	}else if (document.insertnt.act1.value == "") {
		alert('카테고리 1을 입력하세요.'); 	
		document.insertnt.act1.focus();	
		
	}else if (document.insertnt.act2.value == "") {
		alert('카테고리 2를 입력하세요.'); 	
		document.insertnt.act2.focus();	
		
	}else if (document.insertnt.image.value == "") {
		alert('놀이기구 사진을 입력하세요.'); 	
		document.insertnt.image.focus();	
		
	}else if (document.insertnt.acontent.value == "") {
		alert('놀이기구 설명을 입력하세요.'); 	
		document.insertnt.acontent.focus();	
		
	}else if (document.insertnt.pnum.value == "") {
		alert('탑승인원 입력하세요.'); 	
		document.insertnt.pnum.focus();	
		
	}else if (document.insertnt.limitkey.value == "") {
		alert('제한사항 1을 입력하세요'); 	
		document.insertnt.limitkey.focus();	
		
	}else if (document.insertnt.acontent.value == "") {
		alert('제한사항 2를 입력하세요'); 	
		document.insertnt.acontent.focus();	
		
	}else if (document.insertnt.bestat.value == "") {
		alert('놀이기구 베스트 정보를 설정하세요.'); 	
		document.insertnt.bestat.focus();
		
	}else if (document.insertnt.aresult.value == "") {
		alert('놀이기구 운휴 정보를 입력하세요.'); 	
		document.insertnt.aresult.focus();			
	}else{
	document.insertnt.action = "world.do?command=insertattraction";
	document.insertnt.submit();
	}
	
}



// 놀이기구 수정
function go_modat(aseq){ // 놀이기구 수정폼으로 이동
	var url="world.do?command=adminUpdateAttractionForm&aseq="+aseq;
	location.href=url;
}

// 놀이기구 수정버튼 클릭
function go_mod_saveat(){
	if( document.updateat.atname.value==""){ 
		alert('놀이기구 이름을 입력하세요');
		document.updateat.atname.focus();
		
	}else if (document.updateat.acontent.value == "") {
		alert('놀이기구 설명을 입력하세요.'); 	
		document.updateat.acontent.focus();	
		
	}else if (document.updateat.act1.value == "") {
		alert('카테고리 1을 입력하세요.'); 	
		document.updateat.act1.focus();	
		
	}else if (document.updateat.act2.value == "") {
		alert('카테고리 2를 입력하세요.'); 	
		document.updateat.act2.focus();	
		
	}else if (document.updateat.acontent.value == "") {
		alert('놀이기구 설명을 입력하세요.'); 	
		document.updateat.acontent.focus();	
		
	}else if (document.updateat.pnum.value == "") {
		alert('탑승인원 입력하세요.'); 	
		document.updateat.pnum.focus();	
		
	}else if (document.updateat.limitkey.value == "") {
		alert('제한사항 1을 입력하세요'); 	
		document.updateat.limitkey.focus();	
		
	}else if (document.updateat.acontent.value == "") {
		alert('제한사항 2를 입력하세요'); 	
		document.updateat.acontent.focus();		
	}else{
		if(confirm('수정하시겠습니까?')){
		document.updateat.action = "world.do?command=updateAttraction";
		document.updateat.submit();
		}
	}
}

//놀이기구 삭제
function go_deleteat(aseq){
if(confirm('정말 삭제하시겠습니까?')){
	var url="world.do?command=attractionDelete&aseq="+aseq;
	location.href=url;
	}
}

//답글달기
function go_rep(lqseq){
	document.frm.action="world.do?command=adminQnaRepSave";
	document.frm.submit();
}

