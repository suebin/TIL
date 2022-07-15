# DAY 03
<br>

:milky_way: **목차**
- [자주 쓰는 MySQL 데이터 형식](#자주-쓰는-mysql-데이터-형식)
- [MySQL 내장 함수](#mysql-내장-함수)
- [INNER JOIN](#조인)
<br>
<br>

:milky_way: **예제**
- [MySQL 내장 함수 및 INNER JOIN](./day_03.sql)
<br>
<br>

:milky_way: **책 범위**
- chap 07. SQL 고급 : 237~280P
<br>
<br>

---
## 자주 쓰는 MySQL 데이터 형식 

괄호 안 숫자는 Byte를 나타낸다.

<br>

#### 1. 숫자 데이터 형식 

##### 1-1. 정수

- `TINYINT` : (1)
- `SMALLINT` : (2)
- **`INT` / `INTEGER` : (4)** 
- `BIGINT` : (8)

##### 1-2. 실수

- `FLOAT` (4)
- `DOUBLE` (8)
- **`DECIMAL(전체 자릿수, 소수점 이하 자릿수)` (5~17)**

<br>

#### 2. 문자 데이터 형식

- `CHAR(n)` (1~255) : 고정길이 문자형

- `VARCHAR(n)` (1~65535) : 가변길이 문자형

  - CHAR, VARCHAR의 내부 크기

    <br>
 :bulb: 

  영문 1글자, 한글 1글자는 서로 실제 Byte 수가 다르다. 

  하지만 사용자 입장에서 `CHAR(100)`은 영문과 한글 구분없이 100글자를 입력하는 것으로 알고 있으면 되고, 

  내부적은 할당 크기는 신경 쓸 필요가 없다.

<br>

#### 3. 날짜/시간 데이터  형식

- `DATE` : YYYY-MM-DD
- `TIME` : HH:MM:SS
- `DATETIME` : YYYY-MM-DD HH:MM:SS

<br>

#### 4. 기타

- `LONGTEXT`
- `LONGBLOB`
<br>
<br>

---

## MySQL 내장 함수

#### 1. 형 변환 함수 (데이터 형식 변환)

- ` CAST`

- `CONVERT`

- `FORMAT`

  <br>

  :bulb: 

  함수를 쓰지 않아도 자동 형 변환이 되는 경우가 있다. 암시적 형 변환이라고도 한다. 

  예를 들어 문자열 안에 숫자를 넣고 더하면 숫자로 인식한다.

  <br>

#### 2. 조건 함수 (제어 흐름 함수)

- `IFNULL`

- `NULLIF`

- `IF`

- `CASE` 

  - CASE ~ WHEN ~ ELSE ~ END

  - 내장 함수는 아니고 연산자이다.

​		<br>

#### 3. 문자열 함수

- `ASCII`, `CHAR` 
- `BIT_LENGTH`, `CHAR_LENGTH`, `LENGTH`
- `CONCAT`, `CONCAT_WS`
- `ELT`, `SUBSTRING`, `FIELD`, `FIELD_IN_SET`, `INSTR`, `LOCATE` 
- `FORMAT`
- `BIN`, `HEX`, `OCT` 
- `INSERT`
- `REPEAT`
- `REPLACE`
- `LEFT`, `RIGHT`
- `UPPER`, `LOWER`
- `LPAD`, `RPAD`, `LTRIM`, `RTRIM`, `TRIM`

<br>

#### 4. 수학 함수

- `ROUND`
- `TRUNCATE`
- `MOD`

<br>

#### 5. 날짜 및 시간 함수

- `NOW`, `SYSDATE`, `CURDATE`, `CURTIME` 

- `YEAR()`, `MONTH()`, `DAY()`, `HOUR`, `MINUTE`, `SECOND`

- `ADDDATE`, `SUBDATE`

- `ADDTIME`, `SUBTIME`

- `DATEDIFF`, `TIMEDIFF`

- `PERIOD_DIFF`

- `DAYOFWEEK`, `WEEKDAY`

- `DATE_FORMAT`, `FORMAT`

 <br>

#### 6. 시스템 정보 함수

- `DATABASE`
- `USER`
- `CURRENT_USER`
- `VERSION`
<br>
<br>

---

## 조인
- 조인(join) : 두 개 이상의 테이블을 서로 묶어서 하나의 결과 집합으로 만들어내는 것
<br>
:bulb: 
<br><br>

현재는 이미 생성된 테이블만 사용하고 있지만, 추후 테이블을 정의해서 직접 생성한다고 생각해보자. 

컬럼, 타입, 길이에 대해 생각해야 하고, 특정 컬럼의 동일값이 반복된다면 

값을 일일이 저장하는 것이 불필요하고, 값을 일일이 변경하기도 쉽지 않다. 

즉, 데이터 관리가 어렵다. 따라서 1개의 테이블로 구성한다는 생각을 버리고, 

2개 이상의 테이블을 나누어 효율적으로 데이터를 관리하는 것이 좋다.

중복과 공간 낭비를 피하고 데이터의 무결성을 위한 것이다.

<br>



### INNER JOIN (내부 조인) 

- 가장 많이 사용하는 조인


  - `select`
  - `from` 테이블1 `inner join` 테이블2, ...
  - `on` 조인 조건
  - `where` 검색 조건
  -  `gruop by`
  - `having`
  - `order by`