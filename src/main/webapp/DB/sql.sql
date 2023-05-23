

/* Drop Tables */

DROP TABLE address CASCADE CONSTRAINTS; // 절대 하지 마세욤.. 



DROP TABLE Lcart CASCADE CONSTRAINTS;
DROP TABLE Lorders CASCADE CONSTRAINTS;
DROP TABLE fastticket CASCADE CONSTRAINTS;
DROP TABLE attraction CASCADE CONSTRAINTS;
DROP TABLE Lmember CASCADE CONSTRAINTS;
DROP TABLE Lqna CASCADE CONSTRAINTS;
DROP TABLE notice CASCADE CONSTRAINTS;
DROP TABLE Lworker CASCADE CONSTRAINTS;
DROP TABLE passticket CASCADE CONSTRAINTS;


/* Drop Sequences */

DROP SEQUENCE attraction_aseq;
DROP SEQUENCE fastticket_ftseq;
DROP SEQUENCE passticket_ptseq;
DROP SEQUENCE Lcart_lcseq;
DROP SEQUENCE Lorders_loseq;
DROP SEQUENCE Lqna_lqseq;
DROP SEQUENCE notice_nseq;

/* Create Sequences */

CREATE SEQUENCE attraction_aseq INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE fastticket_ftseq INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE passticket_ptseq INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE Lcart_lcseq INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE Lorders_loseq INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE Lqna_lqseq INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE notice_nseq INCREMENT BY 1 START WITH 1;


/* Create Tables */

CREATE TABLE address // 전에 사용 하던 자리면 이미 있습니다 아마도?
(
	zip_num varchar2(7) NOT NULL,
	sido varchar2(30) NOT NULL,
	gugun varchar2(30) NOT NULL,
	zip_code varchar2(30),
	bunji varchar2(1000),
	dong varchar2(1000)
);

select*from address;


select*from attraction;
CREATE TABLE attraction
(
	aseq number(5) NOT NULL,
	atname varchar2(100) NOT NULL,
	acontent varchar2(1000),
	limitkey varchar2(1000),
	limitage varchar2(1000),
	bestat char(1) DEFAULT 'N',
	aresult char(1) DEFAULT 'N',
	act1 varchar2(100),
	act2 varchar2(100),
	image varchar2(255),
	pnum number(10) NOT NULL,
	PRIMARY KEY (aseq)
);

select*from fastticket;
CREATE TABLE fastticket
(
	ftseq number(5) NOT NULL,
	aseq number(5) NOT NULL,
	aprice number(7) DEFAULT 110000 NOT NULL,
	tprice number(7) DEFAULT 90000 NOT NULL,
	cprice number(7) DEFAULT 70000 NOT NULL,
	indate date DEFAULT sysdate,
	visitedate date,
	quantity number(5) DEFAULT 1 NOT NULL,
	PRIMARY KEY (ftseq)
);

select*from Lcart;
CREATE TABLE Lcart
(
	lcseq number(10) NOT NULL,
	id varchar2(20) NOT NULL,
	ftseq number(5) NOT NULL,
	ptseq number(5) NOT NULL,
	PRIMARY KEY (lcseq)
);

select*from Lmember;
CREATE TABLE Lmember
(
	id varchar2(20) NOT NULL,
	pwd varchar2(20) NOT NULL,
	name varchar2(20) NOT NULL,
	phone varchar2(20) NOT NULL,
	email varchar2(40) NOT NULL,
	zip_num varchar2(7),
	address1 varchar2(1000),
	address2 varchar2(1000),
	indate date DEFAULT sysdate,
	PRIMARY KEY (id)
);

select*from Lorders;
CREATE TABLE Lorders
(
	loseq number(5) NOT NULL,
	id varchar2(20) NOT NULL,
	ftseq number(5) NOT NULL,
	ptseq number(5) NOT NULL,
	PRIMARY KEY (loseq)
);


select*from Lqna;
CREATE TABLE Lqna
(
	lqseq number(5) NOT NULL,
	id varchar2(20) NOT NULL,
	title varchar2(100),
	indate date DEFAULT sysdate,
	reply varchar2(1000),
	rep char DEFAULT 'N' NOT NULL,
	content varchar2(1000),
	PRIMARY KEY (lqseq)
);

select*from Lworker;

CREATE TABLE Lworker
(
	id varchar2(20) NOT NULL,
	pwd varchar2(20) NOT NULL,
	name varchar2(20) NOT NULL,
	phone varchar2(20),
	PRIMARY KEY (id)
);

select*from notice;
CREATE TABLE notice
(
	nseq number(10) NOT NULL,
	id varchar2(20) NOT NULL,
	title varchar2(100),
	ncontent varchar2(1000),
	indate date DEFAULT sysdate,
	PRIMARY KEY (nseq)
);

select*from passticket;
CREATE TABLE passticket
(
	ptseq number(5) NOT NULL,
	aprice number(7) DEFAULT 53000 NOT NULL,
	tprice number(7) DEFAULT 45000 NOT NULL,
	cprice number(7) DEFAULT 30000 NOT NULL,
	indate date DEFAULT sysdate,
	visitdate date,
	aquantity number(5) DEFAULT 0,
	tquantity number(5) DEFAULT 0,
	cquantity number(5) DEFAULT 0,
	PRIMARY KEY (ptseq)
);



/* Create Foreign Keys */

ALTER TABLE fastticket
	ADD FOREIGN KEY (aseq)
	REFERENCES attraction (aseq)
;


ALTER TABLE Lcart
	ADD FOREIGN KEY (ftseq)
	REFERENCES fastticket (ftseq)
;


ALTER TABLE Lorders
	ADD FOREIGN KEY (ftseq)
	REFERENCES fastticket (ftseq)
;


ALTER TABLE Lcart
	ADD FOREIGN KEY (id)
	REFERENCES Lmember (id)
;


ALTER TABLE Lorders
	ADD FOREIGN KEY (id)
	REFERENCES Lmember (id)
;


ALTER TABLE notice
	ADD FOREIGN KEY (id)
	REFERENCES Lworker (id)
;


ALTER TABLE Lqna
	ADD FOREIGN KEY (id)
	REFERENCES Lmember (id)
;

ALTER TABLE Lcart
	ADD FOREIGN KEY (ptseq)
	REFERENCES passticket (ptseq)
;


ALTER TABLE Lorders
	ADD FOREIGN KEY (ptseq)
	REFERENCES passticket (ptseq)
;


