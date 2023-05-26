function go_cart(){
	if (document.formm.aquantity.value == "" && document.formm.cquantity.value == "") {
	    alert("수량을 입력하여 주세요.");
	    document.formm.aquantity.focus();
	    document.formm.cquantity.focus();
	    
	}else if(document.formm.visitdate.value==""){
		alert("방문날짜를 선택해 주세요.");
		document.formm.visitdate.focus();
	}else{
		document.formm.action ="world.do?command=passTicketInsert";
		document.formm.submit();
	}
}
