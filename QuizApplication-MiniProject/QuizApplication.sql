
CREATE TABLE STUDENT (STUD_ID NUMBER NOT NULL 
, FIRSTNAME VARCHAR2(20) 
, LASTNAME VARCHAR2(20) 
, USERNAME VARCHAR2(20) 
, S_PASSWORD VARCHAR2(20) 
, CITY VARCHAR2(20) 
, EMAIL VARCHAR2(20) 
, MOBILENUMBER VARCHAR2(20) 
, CONSTRAINT STUDENT_PK PRIMARY KEY (STUD_ID));

CREATE SEQUENCE STUDID_SEQ START WITH 1 INCREMENT BY 1;

SELECT * FROM student;

ALTER TABLE STUDENT MODIFY EMAIL VARCHAR2(50);

SELECT USERNAME, S_PASSWORD FROM STUDENT WHERE UserName = 'om_surve' AND s_password = '12345';

------------------------------------------------------------------------------------------------

CREATE TABLE questionanswerdb (q_id NUMBER NOT NULL 
, que_list VARCHAR2(70) 
, opt1 VARCHAR2(50) 
, opt2 VARCHAR2(50) 
, opt3 VARCHAR2(50) 
, opt4 VARCHAR2(50) 
, ans VARCHAR2(50) 
, CONSTRAINT queans_PK PRIMARY KEY (q_id));

SELECT * FROM questionanswerdb;

SELECT * From student;

DELETE FROM questionanswerdb WHERE q_id in(15);

Insert into questionanswerdb(que_list,opt1,opt2,opt3,opt4,ans)
VALUES ('Which of the following is a superclass of every class in Java?',
'a) ArrayList','b) Abstract class','c) Object class','d) String','c) Object class');

Insert into questionanswerdb(que_list,opt1,opt2,opt3,opt4,ans)
VALUES ('What is the return type of the hashCode() method in the Object class?',
'a) Object','b) int','c) long','d) void','b) int');

Insert into questionanswerdb(que_list,opt1,opt2,opt3,opt4,ans)
VALUES ('In java, jar stands for_____',
'a) Java Archive Runner','b) Java Application Resource',
'c) Java Application Runner','d) None of the above','d) None of the above');

Insert into questionanswerdb(que_list,opt1,opt2,opt3,opt4,ans)
VALUES ('Which package contains the Random class?',
'a) java.util package','b) java.lang package',
'c) java.awt package','d) java.io package','a) java.util package');

Insert into questionanswerdb(que_list,opt1,opt2,opt3,opt4,ans)
VALUES ('In which memory a String is stored, when we create a string using new operator?',
'a) Stack','b) String memory',
'c) Heap memory','d) Random storage space','c) Heap memory');

Insert into questionanswerdb(que_list,opt1,opt2,opt3,opt4,ans)
VALUES ('Which of the given methods are of Object class?',
'a) notifyAll()','b) interrupt()',
'c) synchronized()','d) sleep(long msecs)','a) notifyAll');

Insert into questionanswerdb(que_list,opt1,opt2,opt3,opt4,ans)
VALUES ('Which of the following is a mutable class in java?',
'a) java.lang.String','b) java.lang.Byte',
'c) java.lang.Short','d) java.lang.StringBuilder','d) java.lang.StringBuilder');

Insert into questionanswerdb(que_list,opt1,opt2,opt3,opt4,ans)
VALUES ('Which of the following is not an OOPS concept in Java?',
'a) Polymorphism','b) Inheritance',
'c) Compilation','d) Encapsulation','c) Compilation ');

Insert into questionanswerdb(que_list,opt1,opt2,opt3,opt4,ans)
VALUES ('Which exception is thrown when java is out of memory?',
'a) MemoryError','b) OutOfMemoryError',
'c) MemoryOutOfBoundsException','d) MemoryFullException','b) OutOfMemoryError');

Insert into questionanswerdb(que_list,opt1,opt2,opt3,opt4,ans)
VALUES ('Which of these is not a feature of Java?',
'a) Object-oriented','b) Platform-independent',
'c) Compiled','d) Interpreted language','c) Compiled');

---------------------------------------------------------------------------------

CREATE TABLE ResultDB (r_id NUMBER NOT NULL 
,  totalscore NUMBER
,  grade VARCHAR2(30)
,  fk_studid NUMBER
, CONSTRAINT result_pk PRIMARY KEY (r_id)
, CONSTRAINT fk_student foreign key(fk_studid) references STUDENT(STUD_ID));

CREATE SEQUENCE res_seq START WITH 1 INCREMENT BY 1;

Select * from resultDB;

ALTER TABLE ResultDB MODIFY grade VARCHAR2(50);

DELETE FROM ResultDB WHERE r_id = 3;

--------------------------------------------------------------------------------------------------

Select Student.username, student.s_password ,ResultDB.totalscore, ResultDB.grade from Student INNER JOIN ResultDB on student.stud_id  = ResultDB.fk_studid
WHERE username = 'vishalkashid' AND s_password = '45678';

Select Student.firstname, Student.lastname, ResultDB.totalscore from Student 
INNER JOIN ResultDB on student.stud_id  = ResultDB.fk_studid
Order by ResultDB.totalscore ASC;

Select ResultDB.totalscore from Student 
INNER JOIN ResultDB on student.stud_id  = ResultDB.fk_studid
Where stud_id = 8;

--------------------------------------------------------------------------------------------------