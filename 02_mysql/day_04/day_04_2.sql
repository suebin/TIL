-- chap 08. 테이블과 뷰

select user();
select database();

-- TABLE에 관련된 DDL
-- CREATE TABLE : 테이블 구조 (테이블명, 컬럼명, 타입(길이))
-- DROP TABLE 테이블명; : 테이블 삭제 (복구 불가능)
-- ALTER TABLE 테이블명; : 컬럼 1개 추가, 수정, 삭제 

-- 1. SQL로 테이블 생성 : 320~324p

create table member
(
id varchar(30),
password int(4),
name varchar(30),
phone char(13),
email varchar(30),
regdate datetime
);

insert into member values('id1', 1111, '홍길동', '010-1234-5678', 'hong@google.com', '2022-07-15 15:16:16');
insert into member values('id2', 2222, '박길동', '010-5678-1234', 'park@google.com', now()); -- now() : 날짜와 시간
insert into member values('id3', 333333, '박길동', '010-5678-1234', 'park@google.com', now()); 
insert into member values('id4', 4444, '김한국', '010-5678-1235', 'kim@google.com', curdate()); -- curdate() : 날짜만

select * from member;
 
 -- 폰번호 국번(중간번호) 1234인 회원id, phone, password 조회 (단 password는 "-"로 표시)
 select id, phone, insert(password, 1, length(password), repeat('-', length(password))) 비밀번호
 from member
 where phone like '____1234%';
 
 -- 회원정보가 중복되면 안되고, 자릿수도 지키도록 해야한다. 
 -- 저장된 데이터양식을 제한 = 제약조건 
 -- 이제 새로운 테이블 하나 더 만든다.
 
 
-- 2. 제약조건 (constraint) : 325~337p
 -- 제약조건을 가지고 있는 테이블 c_member를 만든다.
 create table c_member(
id varchar(30) primary key,
password integer(4) not null,
name varchar(30),
phone char(13) unique,
email varchar(30) check (email like '%@%'),
regdate datetime
 );
 
 insert into c_member values('id1', 1111, '홍길동', '010-1234-5678', 'hong@google.com', '2022-07-15 15:16:16');
-- 에러 (아이디 중복) : insert into c_member values('id1', 2222, '박길동', '010-5678-1234', 'park@google.com', now()); 
-- 에러 (비밀번호 null) : insert into c_member values('id2', null, '박길동', '010-5678-1234', 'park@google.com', now()); 
-- 에러 (폰 중복) : insert into c_member values('id2', 2222, '박길동', '010-1234-5678', 'park@google.com', now()); 
-- 에러 (체크 제약 조건 x : 이메일 형식) insert into c_member values('id2', 2222, '박길동', '010-5678-1234', 'park/google.com', now()); 
insert into c_member values('id2', 2222, '박길동', '010-5678-1234', 'park@google.com', now()); 
insert into member values('id4', 4444, '김한국', '010-5678-1235', 'kim@google.com', curdate());

-- 외래 키 제약 조건 (foreign key) : 330~333p
-- 메모테이블 정의 (번호, 제목, 내용, 글쓴시각, 작성자)
create table c_memo
(memo_id int primary key auto_increment, -- 자동으로 숫자 증가!
title varchar(50) not null,
contents varchar(4000),
time datetime default now(), -- now()를 기본으로!
writer varchar(30)
-- constraint foreign key(writer) references c_member(id) : 글 작성자는 회원가입 한 사람만! 이 제약조건은 밑에서 추가하는걸로 한다.
); -- 글을 쓸 수 있는 사람은 회원가입한 사람만!

-- create table 후, 제약 조건 추가/삭제/수정 가능 
-- 중간에 이미 테이블 데이터 저장되어 있다면 내가 추가한 제약 조건을 지키지 않는 데이터가 있을 수 있기 때문에 상당히 까다롭다.
-- 따라서 처음에 테이블을 만들 때부터 제약 조건을 추가/삭제/수정하는 것이 좋다.
-- 혹여나 하려고 한다면 무조건 백업을 하자. : create table backup(select * from c_memo);
-- alter table 테이블명 add constraint 컬럼명 제약 조건
alter table c_memo add constraint foreign key(writer) references c_member(id);

-- c_memo 데이터 삭제
delete from c_memo; 


select * from c_member;
select * from c_memo;

insert into c_member values('ID2', 2222, '박대한', '010-1111-2222', 'ID2@google.com', now());
insert into c_memo values(1, '1번글제목', '1번글내용', default, 'ID2'); -- default = now()
insert into c_memo(title, contents, time, writer) values('2번글제목', '2번글내용', default, 'id1'); -- memo_id 생략해도 자동으로 숫자가 증가! (auto_increment)

-- 에러 (title은 not null이기 때문) : insert into c_memo(contents, time, writer) values('2번글내용', default, 'id1');
-- 에러 (id3은 없기 때문에) : insert into c_memo(title, contents, time, writer) values('3번글제목', '3번글내용', default, 'id3');
-- 따라서 id3을 가진 멤버 하나 생성 후에 다시 실행하면 o
insert into c_member values('id3', 3333, '이자바', '010-9999-0000', 'lee@google.com', now());
insert into c_memo(title, contents, time, writer) values('3번글제목', '3번글내용', default, 'id3');

insert into c_memo(title, contents, time, writer) values('id3제목', null, default, 'id3'); -- 내용이 없을 때
insert into c_memo(title, contents, time, writer) values('id1제목', 'id1글내용', default, 'id1');


-- join을 통해 회원명, 글제목, 글내용 조회
select name 회원명, title 글제목 , contents 글내용
from c_member m1 join c_memo m2 
on m1.id = m2.writer;

-- 제약조건 : 장점 = 데이터 안전 보관, 단점 = 실습할 때 뭐만 하면 안돼 ㄴㅁㄱ

-- foreign key : 다른 테이블 다른 컬럼 참조
-- c_memo.writer(자식) <--- c_member.id(부모)
-- 부모에 존재하지 않는 데이터는 자식도 사용 불가
-- 부모 데이터 삭제 시 자식 데이터 처리 설정하지 않으면 삭제가 불가능하다.
delete from c_member where name='이자바'; 

-- < 부모 데이터 삭제 시 자식 데이터 같이 삭제 설정 >
-- 1) foreign key 기존 키 삭제
alter table c_memo drop foreign key c_memo_ibfk_1; -- (1= 마지막 숫자는 내장된 fk, 상황예 따라 변경될 수 o)
-- 2-1)새로운 foreign key + 부모 데이터 삭제 시 자식 데이터 같이 삭제 (주로 사용)
alter table c_memo add constraint foreign key(writer) references c_member(id)
on delete cascade on update cascade;
-- 2-2)새로운 foreign key + 부모 데이터 삭제 시 자식 데이터 연결 끊고 아무 액션 x (쓸 일 거의 x)
alter table c_memo add constraint foreign key(writer) references c_member(id)
on delete no action on update cascade;
-- 3) 이자바 삭제
delete from c_member where name='이자바'; 

-- 이자바 사라지고, 이자바 쓴 글도 사라졌는지 조회!
select * from c_member;
select * from c_memo;

-- 어려우면 workbench 가 도와줌 : table data import wizard