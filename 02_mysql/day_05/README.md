# MySQL과 Eclipse 연동
## java program jdbc 순서

1. DB 연결 (종류, ip, port 계정, 암호)
2. SQL 정의 - 전송
3. SQL 결과 (select 결과테이블 insert, delete, update 변화행의 수)
4. DB 연결해제

## Connector J 연결
1. Eclips Java Project 생성 - Build Path - Libraries - Add External JARs 
2. 자바 프로젝트 폴더 내부 Referenced Libraries - MySQL Connector java 8.0.29.jar 확인