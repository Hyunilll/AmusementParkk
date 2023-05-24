<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.calendar {display: none;position: absolute;background: #fff;border: 1px solid #ccc;padding: 10px;}
.calendar.active {display: block;}
.calendar .month {text-align: center;font-weight: bold;margin-bottom: 10px;}
.calendar .days {display: grid;grid-template-columns: repeat(7, 1fr);}
.calendar .days .day {text-align: center;padding: 5px;border: 1px solid #ccc;cursor: pointer;}
.calendar .days .day:hover {background-color: #f2f2f2;}.calendar .days .day.selected {background-color: #ffcc00;}
.calendar .days .day.selected {background-color: #ffcc00;}
.selected-date {margin-top: 10px;text-align: center;}
.order_box_date{position:relative; width:100%; height:60px;  border-bottom: 2px solid #e1e1e1;}
.order_box_date_text{position: relative; float:left; padding: 0 0 0 100px;}
#selectedDate {text-align:center; font-size:40px; font-weight:bold;}
img {margin-left:30px;}
</style>
<script>
var selectedDate;

function showCalendar() {
	var calendar = document.getElementById("calendar");
	calendar.innerHTML = "";

	var today = new Date();
	var year = today.getFullYear();
	var month = today.getMonth() + 1;

	// 날짜 형식 변환 함수
	function formatDate(year, month, day) {
		month = month.toString().padStart(2, "0");
		day = day.toString().padStart(2, "0");
		return year + "-" + month + "-" + day;
	}

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
			selectedDate = formatDate(year, month, i);
		}

		day.addEventListener("click", function () {
			var selectedDay = document.querySelector(".day.selected");
			if (selectedDay) {
				selectedDay.classList.remove("selected");
			}
			this.classList.add("selected");
			selectedDate = formatDate(year, month, this.textContent);

			var selectedDateElement = document.getElementById("selectedDate");
			selectedDateElement.textContent =  selectedDate;
			
			calendar.classList.remove("active");
		});

		daysElement.appendChild(day);
	}

	calendar.classList.toggle("active");
}

</script>

</head>
<body>
	<div class="order_box_date">
		<div class="order_box_date_text">
			<h2>방문일자/인원 선택</h2>
		</div>
		<div id="calendarImage" onclick="showCalendar()"><img src="images/calendar.png" alt="Calendar"></div>
		<div id="calendar" class="calendar"></div>
		<div id="selectedDate" class="selected-date"></div>
	</div>
	

</body>
</html>


