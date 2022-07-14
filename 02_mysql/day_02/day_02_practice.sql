/* emp / emp 접속 - empdb의 테이블들 이용
(EMP_COPY테이블 사용하지 말고 EMPLOYEES  테이블)

--기본--
1. 직원 중에서 연봉이 170000 이상인 직원들의 이름, 연봉을 조회하시오.
  연봉은 급여(salary)에 12를 곱한 값입니다.
단, 이름은 "이름", 연봉은 "월급의 12배"로 출력되도록 조회하시오.
*/
select first_name 이름, salary*12 '월급의 12배'
from employees
WHERE salary*12 >= 170000;



-- 2. 직원 중에서 부서id가 없는 직원의 이름과 급여를 조회하시오.
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NULL;

-- 3. 2004년 이전에 입사한 직원의 이름, 급여, 입사일을 조회하시오.


SELECT FIRST_NAME, SALARY, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE <= '2004-12-31 23:59:59';


-- 4. departments 테이블에서departments 부서코드, 부서명을 조회하시오.
SELECT DEPARTMENT_ID , DEPARTMENT_NAME FROM DEPARTMENTS;

-- 5. jobs 테이블에서 직종코드와 직종명을 조회하시오.
SELECT JOB_ID, JOB_TITLE FROM JOBS;
/*
-- 논리연산자 --
1. 80번 급여 5000 이상이거나 50 번 부서에 속해있으면서 급여가 5000 이상인 직원의 이름, 급여, 부서id
를 조회하시오.
*/
-- 대소비교연산자는 논리연산자 먼저 수행된다
-- AND, OR는 AND 먼저 수행된다
SELECT FIRST_NAME, SALARY, DEPARTMENT_ID FROM EMPLOYEES
WHERE (DEPARTMENT_ID = 80  OR DEPARTMENT_ID = 50) AND SALARY >= 5000;

/*
2. 2005년 이후에 입사하고  급여가 1300 이상 20000 이하인 직원들의 
이름, 급여, 부서id, 입사일을 조회하시오.
*/
SELECT FIRST_NAME, SALARY, DEPARTMENT_ID, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE >= '2005-01-01 00:00:00'
AND SALARY BETWEEN 10000 AND 20000;

-- SQL 비교연산자 --
/*1. 80, 50 번 부서에 속해있으면서 급여가 13000 이상인 직원의 이름, 급여, 부서id
를 조회하시오.
*/
SELECT FIRST_NAME, SALARY, DEPARTMENT_ID FROM EMPLOYEES
WHERE DEPARTMENT_ID IN(80, 50) AND SALARY >= 5000;


-- 3. 2005년도 입사한 직원의 정보(이름, 급여, 부서코드, 입사일)만 출력하시오.
SELECT FIRST_NAME, SALARY, DEPARTMENT_ID, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE LIKE '2005%';

/*4. 직종이 clerk 군인 직원의 이름, 급여, 직종코드를 조회하시오.
(clerk 직종은 job_id에 CLERK을 포함하거나 CLERK으로 끝난다.)
*/
SELECT JOB_ID FROM EMPLOYEES
WHERE JOB_ID LIKE '%CLERK%' ; 	-- 자릿수 무관 아무글자 (0개글자)


/*
5. 12월에 입사한 직원의 이름, 급여, 입사일을 조회하시오.
*/
select first_name, salary, hire_date
from employees
where hire_date like '________12%'; -- 4자리-2-xx


-- 6. 이름에 le 가 들어간 직원의 이름, 급여, 입사일을 조회하시오.
select first_name, salary, hire_date
from employees
where first_name like '%le%';

-- 7. 이름이 m으로 끝나는 직원의 이름, 급여, 입사일을 조회하시오.
select first_name, salary, hire_date
from employees
where first_name like '%m';



-- 8. 이름의 세번째 글자가 e인 이름, 급여, 입사일을 조회하시오.
select first_name, salary, hire_date
from employees
where first_name like '__e%'; -- d 3번째포함

-- 9. 커미션을 받는 직원의 이름, 커미션, 급여를 조회하시오.
SELECT FIRST_NAME, COMMISSION_PCT, SALARY
FROM EMPLOYEES
WHERE COMMISSION_PCT IS NOT NULL;

-- 10. 커미션을 받지 않는 직원의 이름, 커미션, 급여를 조회하시오.
SELECT FIRST_NAME, IFNULL(COMMISSION_PCT, 0), SALARY
FROM EMPLOYEES
WHERE COMMISSION_PCT IS NULL;

/*
11. 30, 50, 80 번 부서에 속해있으면서, 
급여를 5000 이상 17000 이하를 받는 직원을 조회하시오. 
단, 커미션을 받지 않는 직원들은 검색 대상에서 제외시키며, 먼저 입사한 직원이 
먼저 출력되어야 하며 입사일이 같은 경우 급여가 많은 직원이 먼저 출력되록 하시오.
*/
SELECT FIRST_NAME, DEPARTMENT_ID, SALARY, COMMISSION_PCT, HIRE_DATE 
FROM EMPLOYEES
WHERE DEPARTMENT_ID IN (30, 50, 80)
AND SALARY BETWEEN 5000 AND 17000
AND COMMISSION_PCT IS NOT NULL
ORDER BY HIRE_DATE , SALARY DESC;

/*
-- 함수 --
1. employees 테이블에서 각 사원의 이름과 직속상사의 사번을 조회한다.
(직속상사의 사번은 manager_id 컬럼이다). 직속상사가 없으면 BOSS 로 출력한다.
*/

SELECT FIRST_NAME 사원이름 , IFNULL(MANAGER_ID, 'BOSS') 상사사번 
FROM EMPLOYEES;



/*
2. 
모든 사원 출력 형식
100 번 사번의 사원명은 LAST_NAME값 , FIRST_NAME값 이고 입사월은 07월입니다.
*/

SELECT CONCAT(EMPLOYEE_ID, ' 번 사번의 사원명은 ' 
, LAST_NAME, ',' , FIRST_NAME, '이고 입사월은 ',  SUBSTR(HIRE_DATE, 6, 2) , '월입니다') 사원정보
FROM EMPLOYEES;


-- DEAPRTMENTS 테이블의 모든 컬럼의 데이터들을 조회하시오 --

SELECT * FROM DEPARTMENTS; -- 4개

-- LOCATIONS 테이블의 LOCATION_ID, CITY 컬럼의 데이터들을 조회하시오 --
SELECT LOCATION_ID, CITY, COUNTRY_ID FROM LOCATIONS;

-- COUNTRIES 테이블의 COUNTRY_ID, COUNTRY_NAME 컬럼의 데이터들을 조회하시오 --

SELECT COUNTRY_ID, COUNTRY_NAME FROM COUNTRIES;

-- JOBS 테이블의 JOB_ID, JOB_TITLE 컬럼의 데이터들을 조회하시오 --
SELECT JOB_ID, JOB_TITLE FROM JOBS;

/* SELECT  사원명, 부서명, 도시명, 국가명  FROM EMPLOYEES , DEPARTMENTS, LOCATIONS, COUTRIES */