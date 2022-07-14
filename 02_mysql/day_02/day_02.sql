select user();
select database();
-- mysql schemas = database

-- locations 테이블 조회 
select * from locations;

-- GROUP BY절
-- 집계 함수 (결과가 1개)
-- 107명 
select * from employees;

-- employees 테이블에서 모든 사원의 급여 총합/평균 조회 
select sum(salary) 급여총합 from employees; -- 1개
select avg(salary) from employees; -- 1개

-- count(salary) : 사원의 수
-- max(salary) : 연봉의 최대값
-- min(salary) : 연봉의 최소값
select sum(salary), avg(salary), count(salary), max(salary), min(salary) from employees;

-- 입사일(날짜)를 더하라고 한다면? : 의미가 없다. 따라서 sum(), avg()는 숫자에만 유효하다.
select sum(hire_date) from employees;
-- 문자열의 합계도 구할 수 없어 0으로 리턴
select sum(first_name) from employees; 

-- max(), min(), count() : 어떤 타입이든 모두 적용 가능하다.
-- 문자는 사전 순서 앞부터 뒤까지의 순서
select max(first_name), min(first_name), count(first_name) from employees;
-- 날짜는 입사일이 가장 빠른 사람이 max, 가장 늦게 입사한 사람이 min
select max(hire_date), min(hire_date), count(hire_date) from employees;

-- count() : not null인 컬럼의 개수만 세어온다.
select count(hire_date), count(department_id), count(commission_pct), count(*) from employees; 
-- null값이 있는지 확인
select first_name, department_id from employees
where department_id is null;

-- 보너스 못 받는 사원 조회 
select first_name, commission_pct from employees
where commission_pct is null;
-- 보너스 받는 사원 조회
select first_name, commission_pct from employees
where commission_pct is not null;

-- 만약 급여 전체(107개)와 급여의 총합(1개)을 같이 조회한다면? : 의미 없다.
-- 집계함수 결과 1개, select절 다른 컬럼과 같이 조회 x (예외 : group by)
select salary, sum(salary) from employees;


select first_name, department_id, salary from employees;
-- 모든 부서의 사원 급여 총합
select sum(salary) from employees;
-- 90번 부서에 있는 사람들만의 급여 총합 조회
select sum(salary) from employees where department_id=90;
-- 모든 부서에 대해 각 부서별 급여 총합 조회 : group by
-- group by 뒤 나오는 컬럼은 같이 조회해도 o
select department_id, sum(salary) from employees
group by department_id -- 부서번호 별로
order by department_id desc -- 내림차순 
limit 3; -- 가장 많이 급여를 받는 상위 1,2,3위

-- 모든 부서에 대해 각 부서별 급여 총합 조회하되 급여 총합이 10000 이상인 결과만 조회
select department_id, sum(salary) from employees
where sum(salary) >= 100000
group by department_id;
-- 위 명령은 error
-- from - where - group by - having - select - order by 순으로 실행
-- 아직 그룹으로 나누지도(group by), 조회를 마치지도(select) 않았다.
-- where 절에는 집계함수 조건 불가능(group by 이전 where 먼저 실행)
-- 집계합수의 조건식 = having 절 o
select department_id, sum(salary) from employees
group by department_id
having sum(salary) >= 100000;

-- 직종코드(job_id : 문자)
-- 직종별로 사원의 급여 평균을 구하되 it_prog 직종은 제외하고 조회 -- group by, where(집계함수가 업으니 가능)
-- 조회 컬럼은 직종코드, 부서평균급여 조회 - select
-- 부셔평균급여가 많은 직종부터 보여주도록 조회 - order by
select job_id 직종코드, avg(salary) '부서 평균 급여' from employees
where job_id != 'it_prog'
group by job_id
order by avg(salary) desc; 
-- order by 2 desc; 
-- order '부서 평균 급여' 2 desc;

-- 2006년 이후 입사 사원에 대해서 부서별 보너스 평균 상황
-- 보너스 = salary + (salary * commssion_pct)
-- 보너스를 받지 못하는 사원 제외, 소속 부서가 없는 사원 제외
select department_id '부서 번호', avg(salary+salary*commission_pct) '보너스 평균' from employees
where hire_date >= '2006-01-01 00:00:00'
and commission_pct is not null
and department_id is not null
group by department_id;

/*
지금까지는 DQL - SELECT (조회)에 대해 알아보았다.
이제는 DML에 대해 알아본다.
DML - INSERT DELETE UPDATE 레코드 저장, 삭제 수정
*/

-- DML(insert, delete, update) 실습을 위한 새로운 테이블 emp_copy 생성
-- 테이블 정의 + 데이터 저장 (107개)
create table emp_copy 
(select employee_id, first_name, last_name, salary, hire_date from employees);

select * from emp_copy;

-- copy한 employees와 emp_copy의 데이터 수가 같은지 확인
select count(*) from emp_copy;
select count(*) from employees;

-- 컬럼의 필드 이름과 타입 등을 보여준다.
describe emp_copy;
describe employees;

-- 이제부터 emp_copy를 이용한다. 먼저, INSERT문!

-- 1, 이사원, 15000, '2000-12-10 00:00:00' 데이터를 추가
insert into emp_copy values(1, '사원', '이', 15000, '2000-12-10 00:00:00');
-- 날짜 시,분,초가 없지만 잘 추가된다.
insert into emp_copy values(2, '길동', '홍', 25000, '2022-12-10');
-- 현재 날짜와 시간을 표현하는 함수 : now(), current_date()
insert into emp_copy values(3, '대리', '홍', 26000, now()); -- 시,분,초까지 표현
insert into emp_copy values(4, '신입', '홍', 10000, current_date()); -- 날짜까지 표현

-- null 값 넣을 때 2가지 방법이 있다.
-- 1. 선택한 컬럼에만 데이터를 추가할 때, 나열되지 않은 컬럼은 자동 null
insert into emp_copy(employee_id, hire_date, last_name) values(5, now(), '김');
-- 2. null이라고 지정 
insert into emp_copy values(6, null, '박', null, now());

-- 테이블 정의 동시에 데이터 복사 (107개)
create table emp_copy 
(select employee_id, first_name, last_name, salary, hire_date from employees);
-- 테이블은 정의되어있고 데이터만 복사
-- insert into emp_copy 
-- select * from employees 
-- where 

-- 10이하인 사원번호만 조회
select * from emp_copy where employee_id <=10;


-- UPDATE 문 (where : 조건을 주는 것이 좋다.)
update emp_copy
set salary = 15000, first_name='수정'
where employee_id = 6;

select*from emp_copy where employee_id <=10;

-- DELETE문 (where : 조건을 주는 것이 좋다.)
-- delete from emp_copy; emp_copy 모든 레코드 삭제 (테이블 구조는 남아있다.)
delete from emp_copy where employee_id =6; -- 사원번호 6번 삭제

-- update/delete는 실수를 방지해서 꼭 백업이 필수이다. 복사본으로 진행하기. 
-- 보통은 시간이 경과함에 따라 데이터가 쌓여간다. 회사는 일정한 주기를 두고 update/delete를 진행한다.
-- 백업(data export) / 복원(data import =restore)

-- 형식에 맞지 않아 insert 안되지만 강제로 insert 하기 : ignore
insert ignore into emp_copy values(6, '부장', '심', 50000, '2020'); -- 날짜는 0000-00-00 00:00:00 으로 입력된다.

-- 6번 심부장 날짜 형식이 올바르지 않기 때문에 날짜를 변경하기
insert into emp_copy values(6, '부장', '심', 50000, now()) -- 이 코드는 잘못되었다. 추가가 아닌 변경을 해야한다. 그런데 어떻게 사원번호가 2명?
on duplicate key update hire_date = now(); -- 중복되었다면 update
-- 위의 코드를 작성하는 것이 올바르다. 하지만 지금은 실행 x 왜?
-- employee_id 컬럼 정의 시(create table) unique : 5는 한 번만!
-- employee_id int(5) unique 

select * from emp_copy where employee_id <= 10;

-- 이전에 SELECT문 배울 때 아래와 같은 order by, limit를 배웠다.
select * from emp_copy
order by salary desc
limit 10; -- 가장 급여를 많이 받는 상위 10명
-- 이번에는 update/delete에 적용해보자

-- firstname이 부장인 사람만 조회
select * from emp_copy 
where first_Name = '부장'
order by 1 desc;

-- firstname이 부장인 사람의 salary를 수정
update emp_copy
set salary = salary+salary*0.2
where first_Name = '부장'
limit 1; -- 업데이트를 할 개수를 설정

-- firstname이 부장인 사람 다시 조회
select * from emp_copy where first_Name = '부장';