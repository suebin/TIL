show databases;

-- MYSQL 사용
USE MYSQL;

select host, user from user;



CREATE TABLE EMPLOYEES
(EMPLOYEE_ID int(10),      /* 컬럼 : 사번 정수 10자리 */
employee_name varchar(20), /* 컬럼 : 이름 문자열 20바이트 */
salary decimal(10, 2),     /* 컬럼 : 급여 실수 (전체 10자리 중 소수점 2자리) */
hire_date date,            /* 컬럼 : 날짜 (년도 월 일 요일) */
department_id int(5)       /* 컬럼 : 부서번호 정수 5자리 */
);

select * from employees;

insert into employees values(100, '이사원', 45000.99, now(), 10);
insert into employees values(101, '김사원', 45000.99, now(), 10);
insert into employees values(102, '최사원', 45000.99, now(), 10);
insert into employees values(200, '박대리', 55000.99, '2020-12-12', 10);
insert into employees values(201, '홍대리', 55000.99, '2020-07-12', 10);
insert into employees values(203, '최대리', 55000.99, '2021-07-12', 10);
insert into employees values(300, '김과장', 65000.99, '2010-12-12', 10);
insert into employees values(301, '이과장', 65000.99, '2010-06-12', 10);
insert into employees values(302, '최부장', 75000.99, '2009-06-12', 10);
insert into employees values(303, '박이사', 85000.99, '2008-12-12', 10);

select * from employees;



-- 사번과 이름만 조회
select employee_id, employee_name from employees;

-- employees 테이블의 사원들이 속한 부서번호의 '종류'만 나열 (중복 x)
select distinct department_id from employees;

-- 이름과 연봉 조회, 단 연봉은 급여의 12배로 출력
select employee_name, salary*12 from employees;



-- where 절

-- 이름과 급여 조회하되 급여가 50000 이상인 사원만 조회
select employee_name, salary from employees
where salary >= 50000;

-- 이름이 이사원이고 급여가 40000 인 사원만 조회
select employee_name, salary from employees
where employee_name='이사원' and salary=40000; 

-- 입사일이 2008-12-12 이거나 급여가 100000 이상인 사원의 입사일, 급여, 이름 조회
select hire_date, salary, employee_name from employees
where hire_date='2008-12-12' or salary >= 100000;

-- 이름이 최씨인 사원의 이름과 보너스 조회, 보너스는 급여의 5% 계산
-- like : 유사한 문자열 패턴 
-- % : 값의 자릿수 무관, 모든 문자 가능 / _ : 값의 자릿수 1자리
select employee_name, salary*0.05 from employees
where employee_name like '최__';

-- 입사일이 2020년인 사원의 이름과 입사일 조회
select employee_name, hire_date from employees
where hire_date like '2020%';

-- 급여가 50000 이상이고, 70000 이하의 사원 이름과 급여 조회 
select employee_name, salary from employees
where salary between 50000 and 70000;
-- where 50000<=salary and salary<=70000;

-- 사번이 100, 300, 250, 204인 사원의 사번과 이름 조회 
select * from employees
where employee_id in (100, 300, 250, 204);

/*
where employee_id = 100
or employee_id = 300
or employee_id = 250
or employee_id = 204;
*/

-- employees 테이블 데이터 5개 추가
insert into employees values(400, '최신입', 40000.0, null, null);
insert into employees values(401, '김신입', 40000.0, now(), 20);
insert into employees values(402, '오신입', 40000.0, now(), 30);
insert into employees values(403, '강신입', 40000.0, now(), 40);
insert into employees values(404, '최신입', 40000.0, null, null);

select * from employees;

-- 입사일이 없는 사원 조회
select * from employees
where hire_date is null;

-- 부서 배정받은 사원 조회
select * from employees
where department_id is not null;

-- 조회 시 컬럼 별명 = alias (공백을 하나 주고 입력, as 생략 가능, 띄어쓰기 하고 싶으면 ''사용)
-- 월급이 null 이면 연봉도 null : null은 연산 x
insert into employees values(405, '김경력', null, now(), 30);
-- ifnull(salary, 1000) : salary의 값이 null이라면 1000을 대입해서 연산해!
select employee_name as 사원명, salary 월급, ifnull(salary, 1000)*12 '사원의 연봉' from employees;

-- concat : 조회 시 두 개 이상의 컬럼 연결 
-- xxxx 사원은 xxx의 월급을 받습니다. 
select concat(employee_name,' 사원은 ',salary,' 의 월급을 받습니다.') '급여 정보'
from employees;

-- order by
-- 사번 낮은 -> 높은 순으로
select * from employees
order by employee_id asc;

-- 사번 높은 -> 낮은 순으로
select * from employees
order by employee_id desc;

-- 급여 많은 사원부터 조회, 동일 급여 사원은 사번이 큰 사원부터
select * from employees
order by salary desc, employee_id desc;

-- 2 = 2번째 컬럼(salary), 1 = 1번째 컬럼(employee_id)
select employee_id, salary from employees
order by 2 desc, 1 desc;

-- alias
select employee_id 사번, salary from employees
order by 2 desc, 사번 desc;

-- 급여 포함 (null 데이터는 asc-처음, desc-마지막에 위치)
select employee_id, salary from employees
order by salary desc;

-- 급여 많은 사원부터 정렬하되 상위 1,2,3번째 조회
select employee_name, salary from employees
order by salary desc
limit 0,3; -- 0번 인덱스부터 3개 (= limit 3)

-- 급여 많은 사원부터 정렬하되 상위 4,5,6,7번째 조회 
select employee_name, salary from employees
order by salary desc
limit 3, 4; -- 3번 인덱스부터 4개
-- 게시판 1페이지 선택 - 10개(1-10개) 2페이지 선택 - 10개(11-20개) 보여주는 페이징 처리할 때 쓰인다. 

select * from employees;

-- show 보여달라!
select * from employees;
select database();
show tables;

-- 테이블 복사 (subquery)
create table emp_copy(select employee_name, salary, hire_date from employees);
show tables;
select * from emp_copy;