function toggleAnswer(answerId) {
    var answer = document.getElementById(answerId);
    if (answer.style.display === "none") {
        answer.style.display = "table-row";
    } else {
        answer.style.display = "none";
    }
}

function count(type)  {
	  // 결과를 표시할 element
	  const resultElement = document.getElementById('result');
	  
	  // 현재 화면에 표시된 값
	  let number = resultElement.innerText;
	  
	  // 더하기/빼기
	  if(type === 'plus') {
	    number = parseInt(number) + 1;
	  }else if(type === 'minus')  {
	    number = parseInt(number) - 1;
	    	if(number==-1) return;
	  }
	  
	  // 결과 출력
	  resultElement.innerText = number;
	}
	
function count2(type)  {
	  // 결과를 표시할 element
	  const resultElement = document.getElementById('result2');
	  
	  // 현재 화면에 표시된 값
	  let number = resultElement.innerText;
	  
	  // 더하기/빼기
	  if(type === 'plus') {
	    number = parseInt(number) + 1;
	  }else if(type === 'minus')  {
	    number = parseInt(number) - 1;
	    	if(number==-1) return;
	  }
	  
	  // 결과 출력
	  resultElement.innerText = number;
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
				selectedDate = year + "-" + month + "-" + i;
			}

			day.addEventListener("click", function() {
				var selectedDay = document.querySelector(".day.selected");
				if (selectedDay) {
					selectedDay.classList.remove("selected");
				}
				this.classList.add("selected");
				selectedDate = year + "-" + month + "-" + this.textContent;
				
				var selectedDateElement = document.getElementById("selectedDate");
				selectedDateElement.textContent =   selectedDate;
				calendar.classList.remove("active");
				
			});
				daysElement.appendChild(day);
			}
			calendar.classList.toggle("active");
			
		}
