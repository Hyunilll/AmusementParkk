


/* Drop Tables */

DROP TABLE address CASCADE CONSTRAINTS;
DROP TABLE attraction CASCADE CONSTRAINTS;
DROP TABLE cart2 CASCADE CONSTRAINTS;
DROP TABLE Lqna CASCADE CONSTRAINTS;
DROP TABLE Lmember CASCADE CONSTRAINTS;
DROP TABLE notice CASCADE CONSTRAINTS;
DROP TABLE Lworker CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE attraction_aseq;
DROP SEQUENCE cart2_cseq;
DROP SEQUENCE Lqna_lqseq;
DROP SEQUENCE notice_nseq;



/* Create Sequences */

CREATE SEQUENCE attraction_aseq INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE cart2_cseq INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE Lqna_lqseq INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE notice_nseq INCREMENT BY 1 START WITH 1;

/* Create Tables */

CREATE TABLE address
(
	zip_num varchar2(7) NOT NULL,
	sido varchar2(30) NOT NULL,
	gugun varchar2(30) NOT NULL,
	zip_code varchar2(30),
	bunji varchar2(1000),
	dong varchar2(1000)
);


CREATE TABLE attraction
(
	aseq number(5,0) NOT NULL,
	atname varchar2(100) NOT NULL,
	acontent varchar2(1000),
	limitkey varchar2(1000),
	limitage varchar2(1000),
	bestat char(1) DEFAULT 'N',
	aresult char(1) DEFAULT 'N',
	act1 varchar2(100),
	act2 varchar2(100),
	image varchar2(255),
	pnum number(10,0) NOT NULL,
	PRIMARY KEY (aseq)
);

select*from cart2

CREATE TABLE cart2
(
	cseq number(10,0) NOT NULL,
	id varchar2(20) NOT NULL,
	p1 number(10,0),
	p2 number(10,0),
	kind number(10,0),
	tatname1 varchar2(100),
	tatname2 varchar2(100),
	tatname3 varchar2(100),
	price1 number(10,0) NOT NULL,
	price2 number(10,0),
	result number(10,0) DEFAULT 0,
	indate date DEFAULT sysdate,
	visitdate date DEFAULT sysdate,
	PRIMARY KEY (cseq)
);


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

select*from Lqna

CREATE TABLE Lqna
(
	lqseq number(5,0) NOT NULL,
	id varchar2(20) NOT NULL,
	title varchar2(100),
	indate date DEFAULT sysdate,
	reply varchar2(1000),
	rep char DEFAULT 'N' NOT NULL,
	content varchar2(1000),
	PRIMARY KEY (lqseq)
);



CREATE TABLE Lworker
(
	id varchar2(20) NOT NULL,
	pwd varchar2(20) NOT NULL,
	name varchar2(20) NOT NULL,
	phone varchar2(20),
	PRIMARY KEY (id)
);


CREATE TABLE notice
(
	nseq number(10,0) NOT NULL,
	id varchar2(20) NOT NULL,
	title varchar2(100),
	ncontent varchar2(1000),
	indate date DEFAULT sysdate,
	PRIMARY KEY (nseq)
);



/* Create Foreign Keys */

ALTER TABLE cart2
	ADD FOREIGN KEY (id)
	REFERENCES Lmember (id)
;


ALTER TABLE Lqna
	ADD FOREIGN KEY (id)
	REFERENCES Lmember (id)
;


ALTER TABLE notice
	ADD FOREIGN KEY (id)
	REFERENCES Lworker (id)
;



