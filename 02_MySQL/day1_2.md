# SQL의 분류

### 1. DDL (Data Definition Language)

- 데이터 정의 언어

- 트랜잭션을 발생시키지 X 

- 데이터베이스, 테이블, 뷰, 인덱스 등의 데이터베이스 개체를 생성, 삭제, 변경

  - `CREATE` : 생성
  - `DROP` : 삭제
  - `ALTER` : 변경

  <br>

  <br>

### 2. DML (Data Manipulation Language)

- 데이터 조작 언어

- 데이터를 추가, 삭제, 수정하는 등의 역할

  - `INSERT` : 추가

  - `DELETE` : 삭제

  - `UPDATE` : 수정

  - `SELECT`  (DQL로 구분하기도 한다.)

  - 트랜잭션이 발생하는 SQL

    - **트랜잭션(Transaction)이란?** 

      테이블의 데이터를 변경(ex) 삭제, 수정)할 때 실제 테이블에 완전히 적용하지 않고, 

      임시로 적용시키는 것 (실수해도 취소 o) 

  <br>

  <br>

### 3. DQL (Data Query Language)

-  데이터 질의 언어 

- 일부에서는 DML에서 `SELECT`만을 따로 분리해서 DQL이나 간단히 QUERY로 표현하기도 한다.
  - `SELECT` : 선택 / 조회

<br>

<br>

### 4. DCL (Data Control Language)

- 데이터 제어 언어

- 데이터의 보안, 무결성, 회복, 병행 수행제어 등을 정의하는데 사용한다.

- 관리자(root 계정)만 사용 가능

  - `GRANT` : 사용자에게 권한 부여
  - `REVOKE` : 사용자 권한 회수
  - `COMMIT` (TCL로 구분하기도 한다.)
  - `ROLLBACK` (TCL로 구분하기도 한다.)

  <br>

  <br>

### 5. TCL (Transaction Control Language)

- 일부에서는 DCL에서 트랜잭션을 제어하는 명령어인 `COMMIT`과 `ROLLBACK`만을 따로 분리해서 TCL이라고 표현하기도 한다.
  - `COMMIT` : 트랜잭션의 작업 결과를 반영
  - `ROLLBACK` : 트랜잭션의 작업 취소 및 원래대로 복구 

