<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<style>
.selected-date {
  margin-top: 10px;
  text-align: center;
}

.calendar-popup {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 9999;
  background-color: #fff;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
  padding: 20px;
  display: none;
  width: 300px;
  max-height: 326px; /* 최대 높이 설정 */
}

.calendar-container {
  position: relative;
  display: inline-block;
}

.calendar-popup .month {
  text-align: center;
  font-weight: bold;
  margin-bottom: 10px;
}

.calendar-popup .navigator {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 10px;
}

.calendar-popup .navigator button {
  background-color: transparent;
  border: none;
  outline: none;
  cursor: pointer;
  font-weight: bold;
}

.calendar-popup .navigator .prev-btn::before {
  content: "\25C0";
}

.calendar-popup .navigator .next-btn::before {
  content: "\25B6";
}

.calendar-popup .days {
  display: grid;
  grid-template-columns: repeat(7, 1fr);
  grid-gap: 5px;
}

.calendar-popup .day {
  text-align: center;
  padding: 10px;
  cursor: pointer;
}

.calendar-popup .day:hover {
  background-color: #f2f2f2;
}

.calendar-popup .day.selected {
  background-color: #ccc;
}

.calendar-popup .hidden {
  display: none;
}
</style>
<script>

  var selectedDate;

  function showCalendar() {
    var calendarPopup = document.getElementById("calendarPopup");
    calendarPopup.innerHTML = "";

    var today = new Date();
    var year = today.getFullYear();
    var month = today.getMonth() + 1;

    // 날짜 형식 변환 함수
    function formatDate(year, month, day) {
      month = month.toString().padStart(2, "0");
      day = day.toString().padStart(2, "0");
      return year + "-" + month + "-" + day;
    }

    function displayCalendar(year, month) {
      var monthElement = document.createElement("div");
      monthElement.classList.add("month");
      monthElement.textContent = year + "년 " + month + "월";
      calendarPopup.appendChild(monthElement);

      var navigatorElement = document.createElement("div");
      navigatorElement.classList.add("navigator");

      var prevButton = document.createElement("button");
      prevButton.classList.add("prev-btn");
      prevButton.addEventListener("click", function() {
        displayCalendar(month === 1 ? year - 1 : year, month === 1 ? 12 : month - 1);
      });
      navigatorElement.appendChild(prevButton);

      var nextButton = document.createElement("button");
      nextButton.classList.add("next-btn");
      nextButton.addEventListener("click", function() {
        displayCalendar(month === 12 ? year + 1 : year, month === 12 ? 1 : month + 1);
      });
      navigatorElement.appendChild(nextButton);

      calendarPopup.appendChild(navigatorElement);

      var daysElement = document.createElement("div");
      daysElement.classList.add("days");
      calendarPopup.appendChild(daysElement);

      var firstDay = new Date(year, month - 1, 1);
      var lastDay = new Date(year, month, 0);
      var firstDayOfWeek = firstDay.getDay();
      var totalDays = lastDay.getDate();

      for (var i = 0; i < firstDayOfWeek; i++) {
        var emptyDay = document.createElement("div");
        emptyDay.classList.add("day", "hidden");
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

        day.addEventListener("click", function() {
          var selectedDay = document.querySelector(".day.selected");
          if (selectedDay) {
            selectedDay.classList.remove("selected");
          }
          this.classList.add("selected");
          selectedDate = formatDate(year, month, this.textContent);

          var selectedDateElement = document.getElementById("selectedDate");
          selectedDateElement.textContent =  selectedDate;

          calendarPopup.style.display = "none"; // 달력 닫기
        });

        daysElement.appendChild(day);
      }

      calendarPopup.style.display = "block";
    }

    displayCalendar(year, month);
  }
  var currentCalendar; // 현재 표시된 달력 요소를 저장하는 변수

  function displayCalendar(year, month) {
    // 현재 표시된 달력 요소가 있으면 숨기기
    if (currentCalendar) {
      currentCalendar.style.display = "none";
    }

    var calendarContainer = document.getElementById("calendarPopup");
    calendarContainer.innerHTML = "";

    var monthElement = document.createElement("div");
    monthElement.classList.add("month");
    monthElement.textContent = year + "년 " + month + "월";
    calendarContainer.appendChild(monthElement);

    // 이하 생략...
    
    calendarContainer.style.display = "block";
    currentCalendar = calendarContainer; // 현재 달력 요소를 저장
  }
</script>
</head>
<body>
  <div class="calendar-container">
    <div id="calendarImage" onclick="showCalendar()">
      <img src="images/calendar.png" alt="Calendar">
    </div>
    <div id="calendarPopup" class="calendar-popup"></div>
  </div>
  <div id="selectedDate" class="selected-date"></div>
</body>
</html>
