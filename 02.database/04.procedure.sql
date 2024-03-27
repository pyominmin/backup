/* procedure 
	1) 익명 procedure
	   
		 declare
		   변수, 상수, return값...등을 선언하는 블럭
		 begin
			 sql문장을 실행하는 블럭
		 exception 
			 예외처리블럭
		 end;
		 
	2) 선언 procedure
		
		 create or replace procedure[function] 프로시저명[펑션명] is[as]
		 
		 begin
		 exception
		 end 프로시저명;
	
*/

-- pro_01 : procedure 개념
create or replace procedure pro_01 is
begin
  -- dbms_output.put_line('Hello World!!');
  --1) 기존자료삭제
	delete from month_salary;

	-- 2) 마감테이블초기화
	insert into month_salary
	select last_day(sysdate)
			 , department_id
			 , 0
			 , 0
			 , 0	
		from hr.employees
	 group by department_id;
	 
	-- 3) 마감작업
	update month_salary sal
		 set (emp_count, total_salary, average_salary)
				 = (select count(*)
								 , sum(emp.salary)
								 , round(avg(emp.salary), 0)
							from hr.employees emp
						 where sal.department_id = emp.department_id); 

end pro_01;

delete from month_salary;
select * from MONTH_SALARY;

call pro_01();

-- pro_02 : 변수선언 및 사용하기
create or replace procedure pro_02 is
	-- 선언부
  v_counter   integer;
begin
	-- 실행부
	v_counter := 10;
	v_counter :=  v_counter + 10;
	dbms_output.put_line(v_counter);
exception when others then
	-- 예외부
	dbms_output.put_line('예외가 발생했습니다!!');
end pro_02;

call pro_02();

-- pro_03 : if
create or replace procedure pro_03 is
	isSuccess boolean;
begin
	isSuccess := true; -- true or false
	
	if isSuccess
	then dbms_output.put_line('업무처리를 성공했습니다!!');
	else dbms_output.put_line('업무처리를 실패했습니다!!');
	end if;
	
end pro_03;

call pro_03();

-- pro_04 : for
-- for i in 1..10 loop ... end loop;
-- while 조건 loop ... end loop;
create or replace procedure pro_04 is
begin
	for i in 1..10 loop
		dbms_output.put_line('i = ' || i);
	end loop;
end pro_04;

call pro_04();

/* 
	pl/sql - 절차적 sql언어
	
	1. pl/sql의 데이터타입
	
	* oracle sql에서 사용되는 데이터타입 integer, boolean, varchar...
	* pl/sql에서 사용되는 데이터타입
	1) %type 
	2) %rowtype
	3) record타입
	4) table타입 
	
	일반sql문에서 사용되는 select문장과 
	pl/sql에서 사용되는 select문장을 다르다.

	일반 : select 컬럼... from table;
	pl/sql : select 컬럼... into 변수...
	           from table;
				 : 컬럼의 갯수와 변수의 갯수는 동수이어야 한다.
*/

-- pro_05 : %type 참조타입
create or replace procedure pro_05 is
	v_empno    number;         -- 일반 sql 데이터타입
	v_ename    emp.ename%type; -- 참조타입 : pl/sql에서 사용되는 데이터 타입 
	v_sal      emp.sal%type; 
begin
	
-- 	v_empno := 10;
-- 	v_ename := '홍길동';
-- 	v_sal   := 1000;
	select empno, ename, sal 
	  into v_empno, v_ename, v_sal 
	  from emp where ename = 'SMITH';
	
	dbms_output.put_line(v_empno || ',' || v_ename  || ',' || v_sal);
end pro_05;

select empno, ename, sal from emp where ename = 'SMITH';
call pro_05();

-- pro_06 : %rowtype 참조타입
create or replace procedure pro_06 is
	v_emp   emp%rowtype; 
begin

	select * 
	  into v_emp
	  from emp where ename = 'SMITH';
	
	dbms_output.put_line(v_emp.empno || ',' || v_emp.ename  || ',' || v_emp.hiredate);
end pro_06;

select * from emp where ename = 'SMITH';
call pro_06();

-- pro_07 : record 참조타입 - 개발자가 정의하는 타입
CREATE OR REPLACE procedure pro_07 is
	 type my_rec is record(
		 v_empno     emp.empno%type        
		, v_ename    emp.ename%type  
		, v_hiredate emp.hiredate%type);
	 
	 v_emp   my_rec;
begin

	select empno, ename, hiredate
	  into v_emp
 	  from emp where ename = 'SMITH';
	
	dbms_output.put_line(v_emp.v_empno || ',' || v_emp.v_ename  || ',' || v_emp.v_hiredate);

end pro_07;

call pro_07();

-- pro_08 : table 참조타입
-- 여러행을 저장할 수 있게 사용자가 정의한 참조타입
-- 1) 여러행, 한개의 열
CREATE OR REPLACE procedure pro_08 is
	type my_table is table of scott.emp.ename%type index by binary_integer; 
	
	v_tbl_ename   my_table;  -- 2차원배열
	idx           binary_integer := 0; -- 변수선언과 초기화
begin
   	 
	 for rec_name in (select ename from emp where deptno = 10 order by ename) loop
			idx := idx + 1;
			v_tbl_ename(idx) := rec_name.ename; -- rec_name은 %rowtype
	 end loop;
	 
	 for i in 1..idx loop
	    dbms_output.put_line('사원이름 = ' || v_tbl_ename(i));	 
	 end loop;
	 
end pro_08;

select ename from emp where deptno = 10;

call pro_08();

-- 2) 여러행, 여러열
CREATE OR REPLACE procedure pro_09 is
	-- table타입을 사원명과 직급을 저장할 2개의 테이블타입
	type my_table_ename is table of scott.emp.ename%type index by binary_integer; 
	type my_table_job is table of scott.emp.job%type index by binary_integer; 
	
	v_name_table  my_table_ename;
	v_job_table   my_table_job;
	idx           binary_integer := 0;
begin
	for rec_name_and_job in (select ename, job from emp where deptno = 10) loop
			idx := idx + 1;
			v_name_table(idx) := rec_name_and_job.ename;
			v_job_table(idx)  := rec_name_and_job.job;
	end loop;
	
	for i in 1..idx loop
		dbms_output.put_line('사원이름 = ' || v_name_table(i) || ', ' ||
			'직급 = ' || v_job_table(i));	 
	end loop;
	
end pro_09;


select ename, job from emp where deptno = 10;

call pro_09();


