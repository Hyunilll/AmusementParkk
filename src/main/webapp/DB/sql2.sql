-- 관리자 입력
insert into Lworker values('admin','1234', '관리자', '010-7777-7777');
insert into Lworker values('scott','1234', '홍길동', '010-6400-6080');


-- 회원입력 
insert into Lmember(id, pwd, name, zip_num, address1, address2, phone, email) values
('one', '1234', '김나리', '133-110', '서울시 성동구 성수동1가' , '1번지21호', '017-777-7777','acc@abc.com');
insert into Lmember(id, pwd, name, zip_num, address1, address2, phone, email)values
('two', '1234', '김길동', '130-120', '서울시 송파구 잠실2동' , '리센츠 아파트 201동 505호', '011-123-4567','acc@abc.com');

select*from Lworker;
select*from Lmember;

select*from attraction;

-- 어트렉션 추가
insert into attraction(aseq, pnum, atname, acontent, act1, act2, image, limitkey, limitage ) values
(attraction_aseq.nextval, 1,'범퍼카' ,'화려한 조명과 신나는 음악 속에서 스릴만점의 자동차 경주가 펼쳐진다. 
앞에서 쾅~ 뒤에서 쾅~ 어디서 달려들지 모르는 좌충우돌 범퍼카! 부딪칠수록 즐거움이 더욱 커집니다.','익사이팅','어린이',
'car.jpg','125cm 이상 탑승가능', '65세 이하 탑승 가능');

insert into attraction(aseq, pnum, atname, acontent, act1, act2, image, limitkey, limitage, bestat) values
(attraction_aseq.nextval, 40,'자이로드롭' ,'구름이 맞닿을 듯한 높이까지 올라갔다 한 순간에 떨어지는 스릴만점 어트랙션입니다.','익사이팅','베스트',
'drop.jpg','125cm ~ 190cm 탑승가능', '65세 이하 탑승 가능', 'Y');

insert into attraction(aseq, pnum, atname, acontent, act1, act2, image, limitkey, limitage, bestat) values
(attraction_aseq.nextval, 64,'회전목마' ,'64필의 아름다운 백마를 타고 떠나는 로멘틱한 여행!','익사이팅','베스트',
'horse.jpg','100cm 탑승가능', '100cm 미만은 보호자 동반', 'Y');

insert into attraction(aseq, pnum, atname, acontent, act1, act2, image, limitkey, limitage, aresult, bestat) values
(attraction_aseq.nextval, 4,'드래곤 와일드슈팅' ,'로티왕이 살고있는 로티성에 심술쟁이 여왕드래곤과 익살스런 대왕 드래곤이 쳐들어왔어요! 기사로 멋지게 변신하여 위기에 빠진 로티성을 구해주세요!!','익사이팅','어린이',
'lotty_dragon.jpg','110cm 이상 탑승가능', '6세미만은 보호자 동반', 'Y', 'Y');

insert into attraction(aseq, pnum, atname, acontent, act1, act2, image, limitkey, limitage) values
(attraction_aseq.nextval, 40,'4D슈팅시어터' ,'지하 동굴속에 숨어든 괴물들을 향하여 슈팅건으로 스크린속 괴물들을 명중시켜 점수를 얻어보세요!','익사이팅','어린이',
'4dgun.jpg','120cm 탑승 가능','65세 이하 탑승 가능');


insert into attraction(aseq, pnum, atname, acontent, act1, act2, image, limitkey, limitage) values
(attraction_aseq.nextval, 6,'풍선비행' ,'하늘 꼭대기에서 내려다본 작은 세계, 풍선을 타고 떠나 보세요! 롯데월드 최고의 전망코스~','베스트','어린이',
'lotty_ballon.jpg','6세이상 탑승가능', '6세미만은 보호자 동반');

insert into attraction(aseq, pnum, atname, acontent, act1, act2, image, limitkey, limitage, aresult) values
(attraction_aseq.nextval, 6,'정글탐험보트' ,'보트를 타고  떠나는 어둠 속 정글 급류 탐험!
동굴로 들어서는 순간 무시무시한 정글이 펼쳐지고, 보트는 급류에 휘말리는데… ','익사이팅','어린이',
'lotty_boat.jpg','110cm 이상 탑승가능', '65세 이하 ', 'Y' );

insert into attraction(aseq, pnum, atname, acontent, act1, act2, image, limitkey, limitage, aresult) values
(attraction_aseq.nextval, 24,'점핑피쉬' ,'거대한 조개를 지나 다양한 물고기 친구들과 로티 로리와 함께 떠나는 신나는 해저여행. 무지막지한 상어를 피해 점핑 점핑!!! ','익사이팅','어린이',
'lotty_fish.jpg','110cm ~ 140cm 탑승가능', '65세 이하 탑승 가능', 'Y');

select*from attraction;


------공지사항 리스트!! ---- 
insert into notice(nseq, title, ncontent , id) values
(notice_nseq.nextval, '1. 구)교환권(사용불가) 안내', '01.jpg' , 'scott');

insert into notice(nseq, title, ncontent , id) values
(notice_nseq.nextval, '2. 주차시스템 개선 안내', '02.jpg' , 'scott');

insert into notice(nseq, title, ncontent , id) values
(notice_nseq.nextval, '3. 채팅상담 이용 안내', '03.jpg' , 'scott');

insert into notice(nseq, title, ncontent , id) values
(notice_nseq.nextval, '4. 장애인 탑승예약제 시행 안내', '04.jpg' , 'scott');

insert into notice(nseq, title, ncontent , id) values
(notice_nseq.nextval, '5. 츄러스 받고 내 카드 제휴 할인 조회', '05.jpg' , 'scott');

insert into notice(nseq, title, ncontent , id) values
(notice_nseq.nextval, '6. 패스트패스 프리미엄 예매 변경 안내 ', '06.jpg' , 'scott');

insert into notice(nseq, title, ncontent , id) values
(notice_nseq.nextval, '7. 신규 어트랙션 OPEN 안내', '07.jpg' , 'scott');

select*from notice;

-----qna 리스트!!-----

insert into lqna(lqseq, title, content, id ) values
(Lqna_lqseq.nextval, '결제가 안되네요..', 'ㅜㅜ', 'one');
insert into lqna(lqseq, title, content, id ) values
(Lqna_lqseq.nextval, '티켓 교환은 어떻게 하나요?', '??', 'one');

	
-----베스트 놀이기구
create or replace view best_at_view
as
select * from
(select rownum, aseq, atname, image from attraction  where bestat='Y'  ) 
where  rownum <=4;

drop view best_at_view;
select * from best_at_view;
select * from attraction;

--------운영 운휴
create or replace view rest_at_view
as
select aseq, atname, image from attraction where aresult='Y';
select * from rest_at_view;

