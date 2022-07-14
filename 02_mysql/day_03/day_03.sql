-- 임시 변수 선언 (Connection 종료) : 242~243P
SET @VAR1 = '문자열'; 
SET @VAR2= 100;
SET @VAR3 = 10/3;
SET @VAR4 = '2003-06-17 00:00:00';

SELECT @VAR1, @VAR2, @VAR3, @VAR4;

SELECT HIRE_DATE, FIRST_NAME
FROM EMPLOYEES
WHERE HIRE_DATE = @VAR4;


-- 함수 (사용자 정의, 내장 함수)

-- 1. 형 변환 함수 CAST, CONVERT, FORMAT : 244~246P 
-- 세 함수는 거의 동일한 기능을 한다.
-- 1-1. 정수를 실수로 변환 / 10(정수) -> 10.00000(실수) : 출력포맷을 맞출 때 주로 사용 
SELECT 10, CAST(10 AS DECIMAL(10, 5)), CONVERT(10, DECIMAL(10,5)), FORMAT(10, 5); 

-- 1-2. 실수를 정수로 변환
SELECT AVG(SALARY), CAST(AVG(SALARY) AS SIGNED INTEGER),
CONVERT(AVG(SALARY), SIGNED INTEGER),
FORMAT(AVG(SALARY), 0)
FROM EMPLOYEES;

-- 1-3. 문자를 날짜/시간으로 변환 
SELECT CAST('2022$07$14' AS DATE); -- 2022-07-14
SELECT CAST('2022$07$14' AS TIME); -- 00:20:22 ($이하는 읽지 못한다.)
SELECT CAST('2022:09:11 12:23:45' AS TIME); -- 12:23:45 (날짜 구분자 형식에 맞지 않아도, 자릿수만 맞으면 해석을 한다.)
SELECT CAST('20221212' AS DATE); -- 2022-12-12
-- 오류 : SELECT CAST(HIRE_DATE AS YEAR) FROM EMPLOYEES; : 년도는 함수이다.


-- 1-4. 자동 형 변환 (암시적 형 변환) : 246~247P
-- 문자열 '숫자 구성' -> 숫자로 해석
SELECT '8818.5678' + 1; -- 8819.5678 (문자열 형식이지만 자동으로 더하기가 가능하다.)
SELECT '100'+'200'; -- 300
SELECT '100가나다'+'가나다200'; -- 100 (100까지 숫자로 변환했지만 가를 읽어서 무시, 두 번째 문자열 시작은 가로 시작해서 무시하고 100+0으로 계산)
SELECT 0=0; -- 1 (같으면 1, 다르면 0)
SELECT 0='MYSQL0'; -- 1
SELECT CONCAT('100', '200'); -- 100200 (CONCAT() : 문자열을 합치는 함수)


-- 2. 조건 함수(제어 흐름 함수) IFNULL, NULLIF, IF, CASE : 247~249P
-- 2-1. IFNULL(데이터, 변환값) : NULL이면 반환값, NOT NULL이면 원래의 데이터값
SELECT COMMISSION_PCT, IFNULL(COMMISSION_PCT, '보너스없음') FROM EMPLOYEES;

-- 2-2. NULLIF(데이터1, 데이터2) : 데이터1과 데이터2가 동일하면 NULL 리턴, 다르면 데이터1 리턴
SELECT NULLIF(100, 100), NULLIF(100, 200); -- NULL / 100

-- 2-3. IF(조건, 참 결과, 거짓 결과) 
SELECT IF(10>0, '크다', '작거나 같다'); -- 크다
SELECT FIRST_NAME 사원명 , IF(COMMISSION_PCT IS NOT NULL, '받는다', '못 받는다') '보너스 지급 유무' FROM EMPLOYEES;
SELECT FIRST_NAME 사원명, SALARY 급여, 
IF(SALARY>=15000, '임원', 
IF(SALARY>=10000, '부장', 
IF(SALARY>=5000, '과장', '대리나 사원'))) 직급 -- 급여대로 직급을 분류
FROM EMPLOYEES
ORDER BY 급여 DESC; 

-- 2-4. CASE 문법 문장 (CASE ~ WHEN ~ ELSE ~ END)
SET @CASEVAR = 200;
SELECT CASE @CASEVAR
WHEN 1 THEN '1이다' -- CASE 뒤의 값이 1이면 '1이다'
WHEN 10 THEN '10이다' -- CASE 뒤의 값이 10이면 '10이다'
WHEN 100 THEN '100이다' -- CASE 뒤의 값이 100이면 '100이다'
ELSE '모른다' -- 그 외에는 '모른다'
END '결과';  

SELECT FIRST_NAME 사원명, SALARY 급여,
CASE 
WHEN SALARY>=15000 THEN '임원'
WHEN SALARY>=10000 THEN '부장'
WHEN SALARY>=5000 THEN '과장'
ELSE '대리나 사원' -- 급여대로 직급을 분류
END 직급
FROM EMPLOYEES 
ORDER BY SALARY DESC; 


-- 3. 문자열 함수 : 249~253P
-- 3-1. ASCII(아스키코드), CHAR(숫자)
SELECT ASCII('a'), CHAR(65); -- 문자의 아스키 코드값을 돌려주거나 숫자의 아스키 코드값에 해당하는 문자를 돌려준다.

-- 3-2. BIT_LENGTH(문자열), CHAR_LENGTH(문자열), LENGTH(문자열)
SET @CHARVAR1 = 'JAVA';
SET @CHARVAR2 = '자바'; -- JAVA 한글 : 2바이트 / DB 한글 : 3바이트
SELECT BIT_LENGTH(@CHARVAR1),LENGTH(@CHARVAR1), CHAR_LENGTH(@CHARVAR1),
BIT_LENGTH(@CHARVAR2), -- 길이를 BIT로 나타낸다.
LENGTH(@CHARVAR2), -- 길이를 BYTE로 나타낸다.
CHAR_LENGTH(@CHARVAR2); -- 글자의 개수를 나타낸다.
SELECT FIRST_NAME FROM EMPLOYEES 
WHERE CHAR_LENGTH(FIRST_NAME) = 3; -- 이름이 3글자로 이루어진 사원의 이름만 출력

-- 3-3. CONCAT(문자열1, 문자열2, ...), CONCAT_WS(구분자, 문자열1, 문자열2, ...) 
SELECT CONCAT('A','B','CC'), CONCAT_WS(',','B','CC'); -- 문자열을 이어준다. CONCAT_WS()는 구분자와 함께 문자열을 이어준다.

-- 문자열 검색
-- 3-4. ELT, SUBSTRING, FIELD, FIELD_IN_SET, INSTR, LOCATE
SELECT ELT(2, '일', '둘', '3'); -- 둘 : 2번째 문자열을 찾는다.
SELECT SUBSTRING('일이삼사', 1, 2); -- 일이 : 인덱스 1부터 2개의 문자열을 찾는다.
SELECT FIELD('둘', '일', '둘', '3'); -- 2: '둘'이라는 문자열의 인덱스를 찾는다. (인덱스는 1부터 시작한다.)
SELECT FIND_IN_SET('이', '일,이,삼,사'); -- 2 : '이'라는 문자열의 위치를 찾는다.
SELECT INSTR('일이삼사', '이'); -- 2 : , 구분이 안되어 있어도 '이'로 시작하는 문자열의 인덱스를 찾는다. 
SELECT LOCATE('삼사', '일이삼사'); -- 3 : '삼사'로 시작하는 문자열의 인덱스를 찾는다.

-- 3-5. FORMAT : 숫자를 소수점 아래 자릿수까지 표현한다. 또한 1000 단위마다 콤마(,)를 표시한다.
SELECT 123456.7890, FORMAT(123456.7890, 0); -- 123,457
SELECT FORMAT(AVG(SALARY), 0) FROM EMPLOYEES; -- 반올림하는데 주로 사용한다.

-- 3-6. BIN, HEX, OCT : 2, 16, 8진수 변환 (잘 사용하지 않아서 넘어간다.)

-- 3-7. INSERT(기준 문자열, 위치, 길이, 삽입할 문자열) : 기준 문자열의 위치부터 길이만큼을 지우고 삽입할 문자열을 끼워 넣는다.
SELECT 'ABCDEF', INSERT('ABCDEF', 3, 2, '-'); -- AB-EF : 3번째부터 2개 삭제하고, '-' 추가

-- 3-8. REPEAT(문자열, 횟수) : 문자열을 횟수만큼 반복
SELECT REPEAT('*', 10); -- ********** 

# <INSERT, REPEAT를 사용한 예제> 
-- 데이터베이스에는 암호를 저장하는 컬럼이 존재한다. 
-- 여기에서는 이름 첫 글자만 남기고, 나머지 글자는 *로 표시하도록 한다.
SELECT INSERT(FIRST_NAME, 2, CHAR_LENGTH(FIRST_NAME)-1, REPEAT('*', CHAR_LENGTH(FIRST_NAME)-1)) 이름
FROM EMPLOYEES; 

-- 3-9. REPLACE
SELECT REPLACE('ABCDEF', 'CD',  '*'); -- AB*EF : 'CD'를 '*'로 바꾼다.
-- 위와 동일한 결과 : SELECT INSERT('ABCDEF', 3, 2, '*'); -- AB*EF

-- 3-10. LEFT, RIGHT
SELECT LEFT('MYSQL', 3), RIGHT('MYSQL', 3); -- MYS, SQL : 왼쪽에서부터 3글자, 오른쪽에서부터 3글자 

-- 3-11. UPPER : 대문자로 , LOWER : 소문자로 
SELECT 'kEllY', UPPER('kEllY'), LOWER('kEllY'); -- kEllY, KELLY, kelly

-- 3-12. LPAD, RPAD, LTRIM, RTRIM. TRIM : 잘 사용하지 않아서 패스


-- 4. 수학 함수 : 254~256P
-- 4-1. ROUND : 반올림을 한다.
SELECT ROUND(1234.5678, 3); -- 1234.568 : 소수점 넷째자리에서 반올림해서 셋째자리까지 표시
SELECT ROUND(1234.5678, -3); -- 1000
SELECT ROUND(1234.5678, 0); -- 1235

-- 4-2. TRUNCATE : 소수점을 기준으로 정수 위치까지 구하고 나머지는 버린다.
SELECT TRUNCATE(1234.5678, 3); -- 1234.567 : 소수점 셋째자리까지 표시
SELECT TRUNCATE(1234.5678, -3); -- 1000
SELECT TRUNCATE(1234.5678, 0);  -- 1234

-- 4-3. MOD : 나머지를 구해준다. (자바에서처럼 % 연산자를  사용할 수 없다.)
SELECT MOD(100, 2); -- 0
SELECT MOD(100, 3); -- 1

SELECT EMPLOYEE_ID 사번,
IF(MOD(EMPLOYEE_ID, 2)=0, '짝수사번', '홀수사번') '사번의 성격'
FROM EMPLOYEES
ORDER BY 2; -- 사번 컬럼 값이 짝수이면 짝수사번 출력, 홀수이면 홀수사번 출력 


-- 5. 날짜 및 시간 함수 : 256~259P
-- 5-1. NOW, SYSDATE, CURDATE, CURTIME : 현재 날짜와 시간
SELECT NOW(), -- 현재 날짜와 시간
SYSDATE(),  -- 현재 날짜와 시간
CURDATE(), -- 현재 날짜만 = DATE(NOW())
CURTIME(); -- 현재 시간만 = TIME(NOW())

-- 5-2. 년, 월, 일, 시, 분, 초
SELECT YEAR(NOW()), MONTH(NOW()), DAY(NOW()), HOUR(NOW()), MINUTE(NOW()), SECOND(NOW());

-- 5-3. ADDDATE, SUBDATE : 날짜 더하기, 빼기
SELECT CURDATE() '오늘 날짜', 
SUBDATE(CURDATE(), INTERVAL 1 DAY) '어제 날짜', 
ADDDATE(CURDATE(), INTERVAL 1 DAY) '내일 날짜',
ADDDATE(CURDATE(), INTERVAL 1 MONTH) '한달 후 날짜',  
ADDDATE(CURDATE(), INTERVAL 1 YEAR) '일년 후 날짜' ;

-- 5-4. ADDTIME, SUBTIME (날짜 시간, 시간 둘 다 가능)
SELECT ADDTIME('19:00:00', '2:00:00'); -- 21:00:00 : 19시에서 2시간 더해준다.  
SELECT ADDTIME('2002-12-12 19:00:00', '2:00:00'); -- 2002-12-12 21:00:00

-- 5-5. DATEDIFF(날짜), TIMEDIFF(시간)
SELECT DATEDIFF('2022-07-14', '2022-06-30'); -- 14 : 날짜의 차이를 일 단위로 보여준다.
SELECT TIMEDIFF('18:00:00', '16:00:00'); -- 02:00:00 : 시간의 차이를 보여준다. 

-- 5-6. PERIOD_DIFF('년도월')
SELECT PERIOD_DIFF('202307', '202207'); -- 12 : 개월의 차이를 보여준다.

-- 5-7. DAYOFWEEK, WEEKDAY : 요일 (기본 형식에 요일이 빠져있을 뿐, NOW()에도 요일 정보를 가지고 있다.)
SELECT NOW(), 
DAYOFWEEK(NOW()), -- 1: 일요일
WEEKDAY(NOW()); -- 0 : 월요일

SELECT NOW(),
CASE WEEKDAY(NOW())
WHEN 0 THEN '월요일'
WHEN 1 THEN '화요일'
WHEN 2 THEN '수요일'
WHEN 3 THEN '목요일'
WHEN 4 THEN '금요일'
WHEN 5 THEN '토요일'
WHEN 6 THEN '일요일'
END '현재 요일' ; -- 현재 요일을 숫자가 아닌 한글로 보여준다.

-- 5-8. DATE_FORMAT, FORMAT (구분자 형식을 바꿀 때 사용한다.)
-- DATE_FORMAT만 잘 사용하면 YEAR과 같은 앞의 함수들을 굳이 사용하지 않아도 원하는 것을 할 수 있다.
SELECT DATE_FORMAT(NOW(), '%Y/%m/%d %W %H-%i-%S'); -- 2022/07/14 Thursday 16-35-15
/*
%Y : 4자리 연도,  %y : 2자리 연도
%m : 2자리 월, %c : 1자리 또는 2자리 월, %M : 영문 월 이름
%d : 2자리 일, %e : 1자리 또는 2자리 일
%W : 영문 요일 (ex) Thursday), %a : 영문 요일 (ex) Thu)
%H : 시간(24시간), %I : 시간(12시간)
%i : 2자리 분
%S : 2자리 초
*/

SELECT FIRST_NAME 이름, HIRE_DATE 입사일, 
TRUNCATE(DATEDIFF(NOW(), HIRE_DATE)/365,0) '입사 경과 년 수', 
PERIOD_DIFF(DATE_FORMAT(NOW(), '%Y%m'), DATE_FORMAT(HIRE_DATE, '%Y%m')) '입사 경과 개월 수', -- 월마다 일 수가 다르기 때문에 PERIOD_DIFF 함수를 사용해야한다.
TRUNCATE(DATEDIFF(NOW(), HIRE_DATE)/7,0) '입사 경과 주 수', 
DATEDIFF(NOW(), HIRE_DATE) '입사 경과 일 수' 
FROM EMPLOYEES; -- 입사한 이후로부터 현재까지 경과한 년, 개월, 주, 일 수를 보여준다.


# <번외>  
-- EMPLOYEES 테이블에서 2006년 입사자 찾는 5가지 방법
SELECT HIRE_DATE FROM EMPLOYEES WHERE HIRE_DATE LIKE '2006%';
SELECT HIRE_DATE FROM EMPLOYEES WHERE '2006-01-01'<= HIRE_DATE AND HIRE_DATE <= '2006-12-31';
SELECT HIRE_DATE FROM EMPLOYEES WHERE INSTR(HIRE_DATE, '2006')=1;
SELECT HIRE_DATE FROM EMPLOYEES WHERE LOCATE('2006', HIRE_DATE)=1;
SELECT HIRE_DATE FROM EMPLOYEES WHERE SUBSTR(HIRE_DATE, 1, 4)='2006';
SELECT HIRE_DATE FROM EMPLOYEES WHERE LEFT(HIRE_DATE, 4) = '2006';
SELECT HIRE_DATE FROM EMPLOYEES WHERE YEAR(HIRE_DATE) = '2006';
SELECT HIRE_DATE FROM EMPLOYEES WHERE DATE_FORMAT(HIRE_DATE, '%Y')='2006';

-- EMPLOYEES 테이블에서 6월 입사자 찾는 4가지 방법 (대소비교로는 찾을 수 없다.)
SELECT HIRE_DATE FROM EMPLOYEES WHERE HIRE_DATE LIKE '_____06%';
SELECT HIRE_DATE FROM EMPLOYEES WHERE INSTR(HIRE_DATE, '-06')=5;
SELECT HIRE_DATE FROM EMPLOYEES WHERE LOCATE('06', HIRE_DATE)=6;
SELECT HIRE_DATE FROM EMPLOYEES WHERE SUBSTR(HIRE_DATE, 6, 2)='06';
SELECT HIRE_DATE FROM EMPLOYEES WHERE MONTH(HIRE_DATE)='6';
SELECT HIRE_DATE FROM EMPLOYEES WHERE DATE_FORMAT(HIRE_DATE, '%c')='6';

-- 6. 시스템 정보 함수 : 259~261P
SELECT DATABASE(), USER(), CURRENT_USER(), VERSION();
-- DATABASE() : 접속하고 있는 데이터베이스 정보 
-- USER() : 현재 유저 정보
-- CURRENT_USER() : 어떤 컴퓨터에서도 모두 접속할 수 있도록 하는 유저 정보
-- VERSION() :사용하는 MySQL 버전 정보 

-- JOIN : 273P 

SELECT FIRST_NAME 사원명, DEPARTMENT_ID 부서코드
FROM EMPLOYEES
ORDER BY 1; -- EMPLOYEES 테이블에만 있는 사원명

SELECT DEPARTMENT_ID 부서코드, DEPARTMENT_NAME 부서명
FROM DEPARTMENTS
ORDER BY 1; -- DEPARTMENTS 테이블에만 있는 부서명

SELECT FIRST_NAME 사원명, EMPLOYEES.DEPARTMENT_ID 부서코드, DEPARTMENT_NAME 부서명 -- 부서코드는 두 테이블에 모두 존재하기 때문에 어느 테이블의 부서코드인지 명시해주어야 한다.
FROM EMPLOYEES, DEPARTMENTS
WHERE EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID -- JOIN
ORDER BY 1; -- 서로 다른 테이블에 있는 사원명과 부서명을 조회

-- 위의 문장을 보면 테이블명이 긴데 일일이 써주어야 한다면 복잡하다.
-- 따라서 alias 처럼 간단히 표현할 수 있다.
-- 밑의 문장은 위와 같다.
SELECT FIRST_NAME 사원명, E.DEPARTMENT_ID 부서코드, DEPARTMENT_NAME 부서명 
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID 
ORDER BY 1;

-- 지금까지는 모든 사원에 대해 조회했지만, 지금은 이름에 'le'가 포함된 사원들만 부서명을 조회하기 위해 조건을 추가해보자.
SELECT FIRST_NAME 사원명, E.DEPARTMENT_ID 부서코드, DEPARTMENT_NAME 부서명 
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID 
AND INSTR(FIRST_NAME, 'le') >= 1 
ORDER BY 1;
-- SQL문을 읽는 사람 입장에서는 조건이 여러개이면 JOIN조건인지 어떤 조건인지 알기가 어렵다. 
-- 따라서 위처럼 작성해도 동작은 잘 되지만, 결론적으로 밑의 문장처럼 쓰는 것이 바람직하다.

SELECT FIRST_NAME 사원명, E.DEPARTMENT_ID 부서코드, DEPARTMENT_NAME 부서명 
FROM EMPLOYEES E INNER JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID -- JOIN
WHERE INSTR(FIRST_NAME, 'le') >= 1 
ORDER BY 1;
