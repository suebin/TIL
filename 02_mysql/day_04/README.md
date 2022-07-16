# DAY 04

<br>

:milky_way: **목차**

- [조인](#조인)
  - [JOIN](#join)
  - [UNION, UNION ALL / NOT IN, IN](#union-union-all--not-in-in)

- [테이블](#테이블)
  - [테이블 만들기](#테이블-만들기)
    - [MySQL Workbench에서 테이블 생성](#1-mysql-workbench에서-테이블-생성)
    - [SQL로 테이블 생성](#2-sql로-테이블-생성)
  - [제약조건](#제약조건-constraint)

<br>

<br>



:milky_way: **예제**

-  [조인](./day_04_1.sql)
-  [테이블](./day_04_2.sql)

<br>

<br>



:milky_way: **책 범위**

- chap 07. SQL 고급 (조인)  : 281~294P

- chap 08. 테이블과 뷰 (테이블) : 313~ 338p

<br>

<br>

---
# 조인
## JOIN 

<br>

1. **`INNER JOIN`** (내부 조인)

2. **`OUTER JOIN`** (외부 조인)
   - 조인의 조건에 만족되지 않는 행까지도 포함시킨다. 

   - **`LEFT OUTER JOIN`** 
     - 왼쪽 테이블의 것은 모두 출력되어야 한다.

   - **`RIGHT OUTER JOIN`** 
     - 오른쪽 테이블의 것은 모두 출력되어야 한다.

3. **`CROSS JOIN`** (상호 조인)
   - 한쪽 테이블의 모든 행들과 다른 쪽 테이블의 모든 행을 조인시키는 기능을 한다.

   - 올바른 조인이 아니다.

   - 대용량 데이터를 만들기 위한 것이다.

4. **`SELF JOIN`** (자체 조인)
   - 자기 자신과 자기 자신이 조인한다.



## UNION, UNION ALL / NOT IN, IN

- `UNION` : 두 쿼리의 결과를 행으로 합치는 것이다.
  - `UNION`  : 중복된 열은 제거되고 데이터가 정렬되어 나온다.
  - `UNION ALL` : 중복된 열까지 모두 출력된다.

- `NOT IN` : 첫 번째 쿼리 결과 중, 두 번째 쿼리에 해당하는 것을 제외한다.
- `IN` : NOT IN과 반대로 첫 번째 쿼리의 결과 중, 두 번째 쿼리에 해당되는 것만 조회한다.

<br>

<br>



---

# 테이블

## 테이블 만들기 

### 1. MySQL Workbench에서 테이블 생성 

1. user 'emp2' 만들기 
   - `root`로 접속 - `administration` - `users and privileges` - `add account`

2. memberdb 만들기
   - `schemas`  - `create schema` - `name`은 memberdb로  - `apply` 
   - memberdb 더블클릭하면 memberdb로 변경 (=use memberdb)

3. 새로운 커넥션 `emp2 connection` 만들기

   - `setup new connection` 

4. member 테이블 만들기

   - `emp2 connection` - `schemas` - `memberdb` 더블클릭 - `tables` 마우스 오른쪽 클릭 - `create table`  - table name, column name, datatype을 입력해서 원하는만큼 테이블 내 column을 만든다 -  `apply`



### 2. SQL로 테이블 생성

- 책 320~324p 와 위의 테이블 예제 참조 

- TABLE에 관련된 DDL
  - CREATE TABLE : 테이블 구조 (테이블명, 컬럼명, 타입(길이))
  - DROP TABLE 테이블명; : 테이블 삭제 (복구 불가능)
  - ALTER TABLE 테이블명; : 컬럼 1개 추가, 수정, 삭제 

<br>

<br>

## 제약조건 (Constraint)

- 데이터의 무결성을 지키기 위한 제한된 조건을 의미한다.
- 특정 데이터 입력 시 무조건적으로 입력되는 것이 아닌, 어떤 조건을 만족했을 때 입력되도록 제한한다.

- 책 325~338p 참조



1. `not null` (=nn) : null 허용 x 

2. `unique key` (=uk) : 중복값 허용 x
3. `primary key` (=pk) : not  null + unique
4. `check` : 사용자 정의 (ex) `check (email like '%@%')`, `check (length(password)<=4)`
5. `foreign key` : 다른 테이블의 다른 컬럼에 존재하는 값만 저장 가능

