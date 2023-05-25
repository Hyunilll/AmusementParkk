function go_cart(){
	if (document.formm.result.value == "" && document.formm.result2.value == "") {
	    alert("수량을 입력하여 주세요.");
	    document.formm.result.focus();
	    document.formm.result2.focus();
	    
	}else if(document.formm.selectedDate.value==""){
		alert("방문날짜를 선택해 주세요.");
		document.formm.selectedDate.focus();
	}else{
		document.formm.action ="world.do?command=passTicketInsert";
		document.formm.submit();
	}
}
