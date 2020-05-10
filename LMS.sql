use master
go
drop database LMS
go
create database LMS
go
use LMS
go
go
DROP TABLE BOOK
DROP TABLE CLERK
DROP TABLE LIBRARIAN
DROP TABLE BORROWED_BOOK
DROP TABLE LOAN
DROP TABLE ON_HOLD_BOOK
go
DROP TABLE BORROWER
go
DROP TABLE STAFF
go
DROP TABLE PERSON


go
---------------------------------------------------------------------------------
go

CREATE TABLE PERSON
(
	ID INTEGER not null PRIMARY KEY,
	PNAME VARCHAR(40) not null,
	[PASSWORD] VARCHAR(30) not null,
	[ADDRESS] VARCHAR(60) not null,
	PHONE_NO VARCHAR(30) not null
);
go
CREATE TABLE BOOK
(
	ID INTEGER not null PRIMARY KEY,
	TITLE VARCHAR(50) not null,
	AUTHOR VARCHAR(60) not null,
	[SUBJECT] VARCHAR(40) not null,
	IS_ISSUED BIT not null 

);
go

CREATE TABLE STAFF
(
    S_ID INTEGER not null PRIMARY KEY,
    [TYPE] VARCHAR(10) not null,
    SALARY FLOAT
);
go

CREATE TABLE CLERK
(
	C_ID INTEGER not null PRIMARY KEY,
	DESK_NO INTEGER not null
);
go

CREATE TABLE LIBRARIAN
(
	L_ID INTEGER not null PRIMARY KEY,
	OFFICE_NO INTEGER not null
);
go


CREATE TABLE BORROWER
(
	B_ID INTEGER not null PRIMARY KEY

);
go

CREATE TABLE BORROWED_BOOK
(
	BOOK INTEGER not null PRIMARY KEY,
	BORROWER INTEGER not null
);
go

CREATE TABLE LOAN
(
	L_ID INTEGER not null PRIMARY KEY,
	BORROWER INTEGER not null,
	BOOK 	INTEGER not null,
	ISSUER INTEGER not null,
	ISS_DATE DATE not null,
	RECEIVER INTEGER ,
	RET_DATE DATE ,
	FINE_PAID BIT	
);
go

CREATE TABLE ON_HOLD_BOOK
(
	REQ_ID INTEGER not null PRIMARY KEY,
	BOOK INTEGER not null,
	BORROWER INTEGER not null,
	REQ_DATE DATE not null
);
go
----------------------------------------FOREIGN KEY CONSTRAINTS----------------------------

ALTER TABLE BORROWED_BOOK
ADD
FOREIGN KEY (BORROWER)REFERENCES BORROWER(B_ID);
go

ALTER TABLE LOAN
ADD
FOREIGN KEY (BORROWER)REFERENCES BORROWER(B_ID);
go

ALTER TABLE LOAN
ADD
FOREIGN KEY (ISSUER)REFERENCES STAFF(S_ID);
go

ALTER TABLE LOAN
ADD
FOREIGN KEY (RECEIVER)REFERENCES STAFF(S_ID);
go


ALTER TABLE ON_HOLD_BOOK
ADD
FOREIGN KEY (BORROWER)REFERENCES BORROWER(B_ID);
go

ALTER TABLE LIBRARIAN
ADD
FOREIGN KEY (L_ID)REFERENCES STAFF(S_ID);
go

ALTER TABLE CLERK
ADD
FOREIGN KEY (C_ID)REFERENCES STAFF(S_ID);
go

ALTER TABLE STAFF
ADD
FOREIGN KEY (S_ID)REFERENCES PERSON(ID);
go

ALTER TABLE BORROWER
ADD
FOREIGN KEY (B_ID)REFERENCES PERSON(ID);
go
-------------------------------------------------------------

INSERT INTO PERSON(ID, PNAME, [PASSWORD], [ADDRESS], PHONE_NO) VALUES(100, 'Paul', 'paul', 'Illinois', '223')
go
INSERT INTO BORROWER(B_ID) VALUES(100)

go
INSERT INTO BOOK(ID, TITLE, AUTHOR, [SUBJECT], IS_ISSUED) VALUES(200, 'Thesaurus', 'Neil', 'Misc', 'true');
go
INSERT INTO BOOK(ID, TITLE, AUTHOR, [SUBJECT], IS_ISSUED) VALUES(201, 'Dictionary', 'Mike', 'Misc', 'false');
go
INSERT INTO BOOK(ID, TITLE, AUTHOR, [SUBJECT], IS_ISSUED) VALUES(202, 'Novel', 'Paulo', 'Fiction', 'false');
go

INSERT INTO PERSON VALUES(1, 'John', '123', 'StreetABC', '0123');
go
INSERT INTO STAFF VALUES(1, 'Permanent', 100000);
go
INSERT INTO LIBRARIAN VALUES(1, 1);
go

INSERT INTO BORROWED_BOOK VALUES(200, 100);
INSERT INTO LOAN VALUES(10, 100, 200, 1, '2020-05-03', NULL, NULL, 0);


SELECT * FROM PERSON
SELECT * FROM BOOK
SELECT * FROM STAFF
SELECT * FROM CLERK
SELECT * FROM LIBRARIAN
SELECT * FROM BORROWER
SELECT * FROM BORROWED_BOOK
SELECT * FROM LOAN
SELECT * FROM ON_HOLD_BOOK

