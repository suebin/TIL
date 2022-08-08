## 회원 CRUD 기능 구현 

서블릿, DAO와 DTO를 사용해 로그인을 하고, 회원가입을 하고, 회원 탈퇴를 하는 등의 CRUD 기능을 구현해본다.

<br>

위 예제의 MemberDAO 클래스 파일에서는 이전에 배웠던 기본 DB 연결 방법도 사용하고, 오늘 배운 DataSource(커넥션풀) 방법도 사용한다. 따라서 아래의 설정이 기본적으로 되어있어야 한다. 

- WEB-INF/lib 폴더에 jdbc 연결된 상태 (mysql connectorJ)
- Servers의 context.xml 내부에 JNDI 설정


---

## 진행 과정
1. 클라이언트가 Servlet에 요청한다.
2. Servlet은 MemberDAO 객체를 생성해 DB의 데이터에 접근한다. 필요에 따라 MemberDTO 객체를 통해 데이터를 중간에 저장하고, MemberDAO에 넘겨준다.
3. MemberDAO는 DB에 접속하여 CRUD 작업을 실행한다.
4. Servlet에서 실행 결과를 클라이언트에게 응답한다.

---
## 최초 실행 파일
- [logindb.html](./member_CRUD/html/logindb.html)