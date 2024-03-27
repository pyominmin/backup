/*
	A. SQL문의 종류
	
	1. DML(Data Manipulatin Language, 데이터조작어)
	
		 1) select : 자료를 조회
		 2) insert : 자료를 추가
		 3) delete : 자료를 삭제
		 4) update : 자료를 수정
		 5) commit : CUD의 작업을 최종적으로 확정하는 명령
		 6) rollback: CUD 작업을 취소하는 명령
		 
		 * CRUD : Create(insert), Read(Select), Update, Delete
		 * Transction : 일련의 데이터처리작업(commit, rollback)
		 
	2. DDL(Data Definition Language, 데이터정의어)
		 - oracle에서 객체와 관련된 명령
		 - 객체(object)의 종류 : user, role, table, view, index, sequence, trigger...
		 
	   1) create : 오라클 DB의 객체를 생성
		 2) drop   : 오라클 DB의 객체를 삭제(완전삭제)
		 3) alter  : 오라클 DB의 객체를 수정
		 4) truncate: 오라클 DB의 객체를 삭제(데이터만 삭제)
	
	
	3. DCL(Data Control Language, 데이터관리어)
	
		 1) grant  : 사용자에게 권한(or Role)을 부여(connect, resource, ...)
		 2) revoke : 사용자의 권한(or Role)을 해제
	
	B. select 문법 
	
	   select [distint] [* | col [as] 별칭 ....]
			 from [스키마].테이블명[view명, [select ...]] 별칭
			where 조건절 [and, or, like, between...]
		 [order by col(or 표현식) [asc/desc]. ...]	
		 
		 1. distinct : 중복을 제거하고 한 개의 행만 조회
		               컬럼명 맨 앞에 위치해야 한다. 아니면 에러
     2. * : 객체의 모든 커럼(열)을 선택
		        *가 정의가 되면 다른 열을 정의할 수 없다.
		 3. alias(별칭) : 객체명 or 컬럼명을 다른 이름으로 정의
		 4. where : 조건에 맞는 자료만 조회
		 5. 조건절 : 컬럼, 표현식, 상수 및 비교연산(>, <, =, <=, >, like....)
		 6. order by : 질의(query)결과를 정렬(asc 오름차순(기본값), desc 내림차순) 
*/
select * from emp;
select * from scott.emp;
select * from hr.employees;

-- select *, empno from emp; 에러
select empno, deptno from  emp;
select distinct deptno from  emp;
-- select deptno distinct  from  emp; -- 에러 distinct는 컬럼앞에 위치

-- 컬럼별칭
select deptno as 부서번호 from emp;
select deptno 부서번호 from emp;
select deptno "부서 번호" from emp;

-- 테이블별칭
select deptno as 부서번호 from emp t1;
-- select emp.deptno as 부서번호 from emp t1; -- 테이블에 별칭을 주었을 때
select t1.deptno as 부서번호 from emp t1;


-- 1. 특정테이블의 자료조회하기
select * from tabs; -- 오라클전용 테이블, 현재 소유자가 소유한 테이블 목록

-- 2. 표현식 : literal, 상수, 문자열, 표현식은 작은 따옴표로 선언
-- select "사원이름 = ", ename from emp;
select '사원이름 = ' as 사원이름, ename from emp;

-- 3. 중복제거
select distinct deptno, mgr from emp;

-- 4. 정렬
select deptno, mgr from emp order by deptno;
select deptno, mgr from emp order by deptno asc;
select deptno, mgr from emp order by deptno desc;
select * from emp order by 1 desc, 2 asc, hiredate desc;


/*
	A. where 조건절
	
	1. 비교연산자 :  =, !=, <>, >, >=, <. <=
	2. 기타연산자
		 a and b : 논리곱연산자
		 a or b  : 논리합연산자
		 not a   : 부정연산자
		 in(a,b,...) : a,b,...의 값을 가지고 있는 자료를 검샋
		 between a and b : a와 b사이의 데이터를 검색, 주의할 점 a는 b보다 항상 작은 값
		 like(%, _와 같이 사용) : 특정 패턴을 가지고 있는 데이터를 검색
		   -> '%A' : A로 끝나는 자료, 'A%': A로 시작되는 자료, '%A%': A를 포함하는 자료
	   is null / not is null : null값 여부의 자료를 검색
*/
/* A. 비교연산자 */
-- 1. 급여(sal) 5000인 사원조회하기
select * from emp;
select * from emp where sal = 5000;

-- 2. 일자비교는 문자로 비교가능
select * from emp where hiredate = '1980-12-17';
select * from emp where hiredate = '1980.12.17';
select * from emp where hiredate = '1980/12/17';

-- 3. like
select ename from emp where ename like 'A%';
select ename from emp where ename like '%A%';
select ename from emp where ename like '%N';

-- 4. between A and B
select ename from emp where ename between 'JAMES' and 'MARTIN';

-- 5. in / not in
select ename from emp where ename in ('JAMES');
select ename from emp where ename not in ('JAMES');

-- 6. is null / in not null
select * from emp where comm is null;
select * from emp where comm is not null;

/* 
	A. 집합연산자
	
	1. union     : 두 집합의 결과를 합쳐서 출력, 단 중복이 있을 경우 중복자료 제외, 정렬(O)
	2. union all : 두 집합의 결과를 합쳐서 출력, 단 중복이 있을 경우 중복자료 포함, 정렬(X)
	3. intersect : 두 집합의 교집합을 출력, 정렬(O) 
	4. minus     : 두 집합의 차집합을 출력, 정렬(O), 선후가 중요 
	
	[집합연산자의 조건]
	1. 두 집합의 select절의 컬럼갯수가 동일해야 한다.
	2. 두 집합의 select절의 같은 위치의 컬럼은 자료형이 동일해야 한다.
	3. 두 집합의 열명이 달라도 상관없다. 단, 먼저 정의된 컬럼명으로 정해진다.
*/
select * from scott.professor;
select * from scott.student;

select profno from scott.professor;
select studno from scott.student;

-- 1. union 
select profno from scott.professor
union
select studno from scott.student;

-- 2. union all
select profno from scott.professor
union all
select studno from scott.student;

-- 3. 에러 - 자료형이 다를 경우
select name from scott.professor
union all
select studno from scott.student;

-- 4. 에러 - 컬럼갯수가 다를 경우
select profno, name from scott.professor
union all
select studno from scott.student;