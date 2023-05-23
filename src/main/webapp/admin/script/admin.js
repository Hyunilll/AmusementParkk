function adminloginCheck(){
	
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