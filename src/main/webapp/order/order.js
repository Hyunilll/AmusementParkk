function go_cart(num){

	if(document.formm.visitdate.value==""){
		alert("방문 일자를 선택해주세요")
		return;
	}
	if(document.formm.p1.value==0&&document.formm.p2.value==0){
		alert("인원을 선택해주세요")
		return;
  	}
  
  	if( num == 1){
	  	var chkBox = document.getElementsByName("attraction") //name값 불러옴
		var chkCnt = 0; // chkCnt 초기값 0 설정
		
		for ( var i = 0; i < chkBox.length; i++){
			if (chkBox[i].checked){ // chkBox가 체크 됐을 경우
				chkCnt++; // 1증가
			}	
		}
		if (chkCnt < 3){ // 3개 
			alert("3개를 선택해주세요.") // 경고문
			return;
		}
  	}

	document.formm.action ="world.do?command=passTicketInsert&kind="+num;
	document.formm.submit();
	
}


function count_check(obj) {
	
	var chkBox = document.getElementsByName("attraction") //name값 불러옴
	var chkCnt = 0; // chkCnt 초기값 0 설정
	
	for ( var i = 0; i < chkBox.length; i++){
		if (chkBox[i].checked){ // chkBox가 체크 됐을 경우
			chkCnt++; // 1증가
		}	
	}
	if (chkCnt > 3){ // 3개 
		alert("3개까지만 선택 가능합니다.") // 경고문
		obj.checked = false; // 경고 후 체크 되지 않게 설정.
		return false;
	}

     
}




function toggleAnswer(answerId) {
    var answer = document.getElementById(answerId);
    if (answer.style.display === "none") {
        answer.style.display = "table-row";
    } else {
        answer.style.display = "none";
    }
}

 function increaseNumber(event, result) { // 증가
	event.preventDefault(); // 폼 제출 기본 동작 중지
    var resultInput = document.getElementById(result);
    var currentValue = parseInt(resultInput.value);
    var newValue = currentValue + 1;
    resultInput.value = newValue;
  }

 function decreaseNumber(event, result) {//  감소
	 event.preventDefault();
    var resultInput = document.getElementById(result);
    var currentValue = parseInt(resultInput.value);
    
    if (currentValue > 0) {
      var newValue = currentValue - 1;
      resultInput.value = newValue;
    }
  }
  
function increase(event, result) {
  event.preventDefault();
  var resultInput = document.getElementById(result);
  var currentValue = parseInt(resultInput.value);

  if (currentValue === 1) {
	  alert("패스 티켓은 1인당 1개만 구매 가능합니다.")
    return false; // Return false if the current value is already 1
  }
  
  var otherResult = result === 'result' ? 'result2' : 'result';
  var otherResultInput = document.getElementById(otherResult);
  otherResultInput.value = 0; // Set the other result input value to 0

  var newValue = currentValue + 1;
  resultInput.value = newValue;
}

function decrease(event, result) {
  event.preventDefault();
  var resultInput = document.getElementById(result);
  var currentValue = parseInt(resultInput.value);

  if (currentValue === 0) {
    return false; // Return false if the current value is already 0
  }

  var otherResult = result === 'result' ? 'result2' : 'result';
  var otherResultInput = document.getElementById(otherResult);
  otherResultInput.value = 0; // Set the other result input value to 0

  var newValue = currentValue - 1;
  resultInput.value = newValue;
}
	
	

	// 달력 
	
	var selectedDate;

function showCalendar() {
  var calendar = document.getElementById("calendar");
  calendar.innerHTML = ""; // 기존 내용 초기화

  var today = new Date();
  var year = today.getFullYear();
  var month = today.getMonth() + 1;

  var monthElement = document.createElement("div");

  monthElement.classList.add("month");
  monthElement.textContent = year + "년 " + month + "월";
  calendar.appendChild(monthElement);

  var daysElement = document.createElement("div");

  daysElement.classList.add("days");
  calendar.appendChild(daysElement);

  var firstDay = new Date(year, month - 1, 1);
  var lastDay = new Date(year, month, 0);
  var firstDayOfWeek = firstDay.getDay();
  var totalDays = lastDay.getDate();

  for (var i = 0; i < firstDayOfWeek; i++) {
    var emptyDay = document.createElement("div");
    emptyDay.classList.add("day");
    daysElement.appendChild(emptyDay);
  }

  for (var i = 1; i <= totalDays; i++) {
    var day = document.createElement("div");
    day.classList.add("day");
    day.textContent = i;
    if (
      i === today.getDate() &&
      month === today.getMonth() + 1 &&
      year === today.getFullYear()
    ) {
      day.classList.add("selected");
      selectedDate = year + "-" + addLeadingZero(month) + "-" + addLeadingZero(i);
    }

    day.addEventListener("click", function () {
      var selectedDay = document.querySelector(".day.selected");
      if (selectedDay) {
        selectedDay.classList.remove("selected");
      }
      this.classList.add("selected");
      selectedDate = year + "-" + addLeadingZero(month) + "-" + addLeadingZero(this.textContent);

      var selectedDateElement = document.getElementById("selectedDate");
      selectedDateElement.textContent = selectedDate;
      document.getElementById('selectedDate').value = selectedDate;
      calendar.classList.remove("active");
    });
    daysElement.appendChild(day);
  }
  calendar.classList.toggle("active");
}


function addLeadingZero(value) {
  return value < 10 ? "0" + value : value;
}
