# MySQL과 Eclipse 연동
## Database Programing 일반적 순서
1. DBMS 연결 (종류, ip, port 계정, 암호)
2. SQL 명령어 실행 (정의, 전송)
3. SQL 결과 리턴 (select 결과테이블 insert, delete, update 변화행의 수)
4. 연결 종료


## JDBC (Java DataBase Connectivity)
- 자바와 데이터베이스의 연동 작업을 지원하는 기술
- 자바에서는 interface만 제공하고, DBMS 제조사에서 class 구현
- JDBC 드라이버 : DBMS에 대한 세부 작업을 담당하는 라이브러리, jar 파일로 제공 (ex) MySQL Connector J)

## MySQL Connector J 연결
1. `Eclipse Java Project 생성 - Build Path - Libraries - Add External JARs`
2. `자바 프로젝트 폴더 내부 Referenced Libraries - MySQL Connector java 8.0.29.jar 확인`

## JDBC를 이용한 데이터베이스 프로그래밍
- JDBC 드라이버 로드 (DriverManager)
- 데이터베이스에 접속 (Connection)
- SQL 명령어 실행 (PreparedStatement)
- select 명령어의 경우 결과셋 리턴(ResultSet)
- 데이터베이스 연결 종료