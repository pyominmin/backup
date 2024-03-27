-- CRUD
-- crate    [table|view|user|....]
-- select   [*|col1...colx] from [테이블|view]
-- update   테이블명 set col1 = 값, ... colx=값 where 컬럼 = 비교값...
-- delete   from table명 where ...
-- insert into 테이블(컬럼1...컬럼n) values(값1,... 값n);

-- oracle 실습환경 설정
-- 1. hr계정을 unlock
alter user hr account unlock identified by hr;

-- 2. scott계정을 새롭게 생성 -> mysql의 create database 명령과 동일
create user scott identified by tiger;

-- 3. 생성된 scott계정에 권한 부여하기
-- DB접속권한/select, delete, update, insert
grant connect, resource to scott;

-- 4. scott에 실습용 테이블 만들기

CREATE TABLE DEPT
   (DEPTNO NUMBER(2) CONSTRAINT PK_DEPT PRIMARY KEY,
    DNAME VARCHAR2(14) ,
    LOC VARCHAR2(13) ) ;

CREATE TABLE EMP  
   (EMPNO NUMBER(4) CONSTRAINT PK_EMP PRIMARY KEY,  
    ENAME VARCHAR2(10),  
    JOB VARCHAR2(9),  
    MGR NUMBER(4),  
    HIREDATE DATE,  
    SAL NUMBER(7,2),  
    COMM NUMBER(7,2),  
    DEPTNO NUMBER(2) CONSTRAINT FK_DEPTNO REFERENCES DEPT);

INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');   
INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');  
INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');

INSERT INTO EMP VALUES
(7369,'SMITH','CLERK',7902,to_date('17-12-1980','dd-mm-yyyy'),800,NULL,20);
INSERT INTO EMP VALUES
(7499,'ALLEN','SALESMAN',7698,to_date('20-2-1981','dd-mm-yyyy'),1600,300,30);
INSERT INTO EMP VALUES
(7521,'WARD','SALESMAN',7698,to_date('22-2-1981','dd-mm-yyyy'),1250,500,30);
INSERT INTO EMP VALUES
(7566,'JONES','MANAGER',7839,to_date('2-4-1981','dd-mm-yyyy'),2975,NULL,20);
INSERT INTO EMP VALUES
(7654,'MARTIN','SALESMAN',7698,to_date('28-9-1981','dd-mm-yyyy'),1250,1400,30);
INSERT INTO EMP VALUES
(7698,'BLAKE','MANAGER',7839,to_date('1-5-1981','dd-mm-yyyy'),2850,NULL,30);
INSERT INTO EMP VALUES
(7782,'CLARK','MANAGER',7839,to_date('9-6-1981','dd-mm-yyyy'),2450,NULL,10);
INSERT INTO EMP VALUES
(7788,'SCOTT','ANALYST',7566,to_date('13-7-1987','dd-mm-yyyy')-85,3000,NULL,20);
INSERT INTO EMP VALUES
(7839,'KING','PRESIDENT',NULL,to_date('17-11-1981','dd-mm-yyyy'),5000,NULL,10);
INSERT INTO EMP VALUES
(7844,'TURNER','SALESMAN',7698,to_date('8-9-1981','dd-mm-yyyy'),1500,0,30);
INSERT INTO EMP VALUES
(7876,'ADAMS','CLERK',7788,to_date('13-7-1987','dd-mm-yyyy')-51,1100,NULL,20);
INSERT INTO EMP VALUES
(7900,'JAMES','CLERK',7698,to_date('3-12-1981','dd-mm-yyyy'),950,NULL,30);
INSERT INTO EMP VALUES
(7902,'FORD','ANALYST',7566,to_date('3-12-1981','dd-mm-yyyy'),3000,NULL,20);
INSERT INTO EMP VALUES
(7934,'MILLER','CLERK',7782,to_date('23-1-1982','dd-mm-yyyy'),1300,NULL,10);

CREATE TABLE BONUS
    (
    ENAME VARCHAR2(10)  ,
    JOB VARCHAR2(9)  ,
    SAL NUMBER,
    COMM NUMBER
    ) ;
		
CREATE TABLE SALGRADE
      ( GRADE NUMBER,
    LOSAL NUMBER,
    HISAL NUMBER );
	
INSERT INTO SALGRADE VALUES (1,700,1200);
INSERT INTO SALGRADE VALUES (2,1201,1400);
INSERT INTO SALGRADE VALUES (3,1401,2000);
INSERT INTO SALGRADE VALUES (4,2001,3000);
INSERT INTO SALGRADE VALUES (5,3001,9999);