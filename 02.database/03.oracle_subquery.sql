/*
	subquery?
	
	1. Main Query와 반대되는 개념으로 이름을 부여한 것
	2. 메인쿼리를 구성하는 소단위의 쿼리(종속쿼리)
	3. sub query안에 select, insert, delete, update모두 사용이 가능하다.
	4. sub query의 결과값을 메인쿼리가 사용하는 중간값으로 사용할 수 있다.
	5. sub query 자체는 일반 쿼리와 다를 바가 없다.
	
	서브쿼리의 종류
	
	1. 연관성에 따른 분류
	
		 a. 연관성이 있는 쿼리
		 b. 연관성이 없는 쿼리
	
	2. 위치에 따른 분류
	
	   a. inline view : select절이나 from절안에 위치하는 쿼리
		 b. 중첩쿼리    : where절안에 위치한 쿼리
		 
		 
	제약사항
	
	1. where절에 연산자 오른 쪽에 위해해야 하며 반드시 소괄호()로 묶어야 한다.
	2. 특수한 경우를 제외하고는 sub query안에는 order by를 사용할 수 없다.
	3. 비교연산자에 따라서 단일행 sub query(<,>,=...) or 다중행 sub query(in, like...)를
	   사용할 수 있다.
*/
select * from hr.employees;

-- scott에서 hr의 employees에 접근 권한을 부여해야 접근할 수 있다.
-- 1. hr사용자가 scott에 employees, departments 테이블에 접근할 수 있도록 설정
--    1) hr사용자 or sys사용자가 scott에 권한을 부여할 수 있다.
--    2) 권한부여방법
--       grant 접근할 명령 on 접근허용객체 to 권한부여대상자
--    3) 권한해제방법
--       revoke 해제명령 on 해제할객체 to 권한해제대상자
--    4) 접근명령 : select, update, insert, delete...

-- 2. 접근권한부여
-- hr or sys계정으로 실행해야 한다.
grant select on hr.employees to scott;
grant select on hr.departments to scott;

-- 3. 권한부여후 scott계정에서 hr.employees접근
select * from hr.employees;
select * from hr.departments;

-- 4. 권한해제
-- hr or sys계정으로 실행해야 한다.
revoke select on hr.employees from scott;
revoke select on hr.departments from scott;

/* A. 단일행 서브쿼리 */
select * from professor;

-- 1. Sharon Stone과 동일한 직급(instructor)을 가진 교수만 조회하기
select position from professor where name = 'Sharon Stone';
select * from professor where position = 'instructor';

-- 서브쿼리
select * 
  from professor 
 where position = (select position 
                     from professor 
										where name = 'Sharon Stone');

-- 2. hr에서 employees, departments를 join해서
-- 사원이름과 부서id, 부서명 조회하기
-- inline view(queryt)
select * from hr.employees;

-- 1) join 
select first_name || '.' last_name
     , hr.employees.department_id
		 , hr.departments.department_name
  from hr.employees
     , hr.departments
 where hr.employees.department_id = hr.departments.department_id;

-- 2) inline view
select department_name from hr.departments;

select first_name || '.' last_name
     , hr.employees.department_id
		 , (select department_name 
		      from hr.departments
				 where hr.employees.department_id = hr.departments.department_id) as 부서이름
  from hr.employees;
	
-- 실습.
-- hr사원테이블에서 전체사원의 평균급여보다 작은 사원만 조회하기
select avg(salary) from hr.employees;

select first_name || '.' last_name
     , salary
  from hr.employees
 where salary < (select round(avg(salary), 0) 
                   from hr.employees);

/* B. 다중행, 다중열 서브쿼리 */
-- 1. 다중행, 단일열
-- hr.locations, hr.jobs에 접근권한 부여해보세요!!
grant select on hr.locations to scott;
grant select on hr.jobs to scott;

select * from hr.locations;
select * from hr.jobs;

-- 실습1. 부서의 state-province가 null인 부서를 조회
-- locations과 departments를 join해서 부선번호와 부서명을 조회
-- subquery / in 비교연산자 사용
select location_id, state_province from hr.locations where state_province is null;
select * from hr.departments;

select department_id
     , department_name
	from hr.departments dpt
 where dpt.location_id in (select location_id 
                            from hr.locations 
													 where state_province is null);
													 
-- 실습. 급여가 가장 많은 사원의 이름과 직급을 조회
-- subquery
select first_name || '.' last_name
     , job_id
  from hr.employees;	
select * from hr.jobs;	
select max(salary) from hr.employees;		

select first_name || '.' last_name
     , emp.job_id
		 , job.job_title
		 , emp.salary
  from hr.employees emp
	   , hr.jobs      job
 where emp.salary = (select max(salary) from hr.employees)
   and emp.job_id = job.job_id;									 

-- 2. 다중행, 다중열
-- 마감작업 (특정 TR에서 합계를 구해서 새로운 마감테이블을 생성)
-- 월말마감 현재급여를 조회해서 부서별로 사원수,급여,평균급여
drop table month_salary;
create table month_salary(
		magam_date          date not null /* 마감월 */
	, department_id       number        /* 부서번호 */
	, emp_count           number        /* 총사원수 */
	, total_salary        number        /* 총급여액 */
	, average_salary      number        /* 급여평균 */	
);
select * from month_salary;

-- a. 2step
-- 1) 마감테이블 초기화
delete from month_salary;
insert into month_salary
select last_day(sysdate)
     , department_id
		 , 0
		 , 0
		 , 0	
  from hr.employees
 group by department_id;
	 
select * from month_salary;

-- 2) 초기화된 마감테이블에 update(사원수, 급여총액, 평균급여)
select emp.department_id
     , count(*)
		 , sum(emp.salary)
		 , round(avg(emp.salary), 0)
  from hr.employees emp
 group by emp.department_id;
	
	
-- 3) update
update month_salary sal
   set emp_count      = (select count(*) from hr.employees emp where sal.department_id = emp.department_id)
	   , total_salary   = (select sum(emp.salary) from hr.employees emp where sal.department_id = emp.department_id)
		 , average_salary = (select round(avg(emp.salary), 0) from hr.employees emp where sal.department_id = emp.department_id);

select * from month_salary;


-- b. 1step
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

select * from month_salary;



