# DataSource 이용해 데이터베이스 연동하기
- 교재 7장

<br>

## 커넥션풀 (ConnectionPool)

웹 컨테이너(WAS)가 실행되면서 DB와 미리 connection(연결)을 해놓은 객체들을 pool에 저장해두었다가, 

클라이언트 요청이 오면 connection을 빌려주고, 

처리가 끝나면 다시 connection을 반납을 받아 pool에 저장하는 방식이다.

커넥션풀은 기존 DB 연결 방식의 문제점을 해결해준다.


### 기존 DB 연결 방법의 문제점
DB 연결에 시간이 많이 걸린다. 웹 서버 1개는 여러 클라이언트의 요청을 받아 멀티 스레드로 동작한다. DB 마다 최대 외부 접속 허용 개수는 한정되어 있다. 많은 사람들이 접속하면 웹 서버가 느려지거나 문제가 생길 수 있다.

### connection pooling

웹 애플리케이션에서 ConnectionPool 객체를 구현할 때는 tomcat container가 자체적으로 제공하는 API 라이브러리로 사용한다.

- `javax.sql.DataSource`

---

## JNDI (Java Naming and Directory Interface)

웹 애플리케이션 실행 시 톰캣이 만들어 놓은 ConnectionPool 객체에 접근할 때 JNDI를 이용한다.

필요한 자원을 키/값(key/value) 쌍으로 저장한 후 필요할 때 키를 이용해 값을 얻는 방법이다.

- `javax.naming.Context`

---

## 톰캣의 DataSource 설정 및 사용방법

- 242~247p

1. JDBC 드라이버를 `/WEB-INF/lib 폴더`에 설치 (mysql connectorJ)

2. context.xml에 Connection 객체 생성 시 연결할 데이터베이스 정보를 JNDI로 설정
    
    ![JNDI](./image/JNDI.PNG)
    
3. DAO 클래스에서 데이터베이스와 연동 시 미리 설정한 JNDI라는 이름으로 데이터베이스와 연결하여 작업

<br>

:milky_way: **예제**
- [DataSource : 커넥션풀](./test/ConnectionServlet.java)

---

# 서블릿을 이용한 회원 CRUD 기능 구현 

:milky_way: **예제**
- [회원 CRUD 기능 구현하기](./test/member_CRUD)


---

# 포워드 : dispatch

- 교재 8장

<br>

## 포워드 (Forward)

하나의 서블릿에서 다른 서블릿이나 JSP로 요청을 전달하는 역할을 한다. 

- 요청에 대한 추가 작업을 다른 서블릿에게 수행하게 한다.
- 요청에 포함된 정보를 다른 서블릿이나 JSP와 공유할 수 있다.
- 요청에 정보를 포함시켜 다른 서블릿에 전달할 수 있다.
- 모델2 개발 시 서블릿에서 JSP로 데이터를 전달하는 데 사용된다.

---

## dispatch

서블릿의 포워드 방법 중 하나이다.

클라이언트의 웹 브라우저를 거치지 않고 바로 서버에서 포워딩이 진행된다. 

웹 브라우저 주소창의 URL이 변경되지 않기 때문에 클라이언트 측에서는 포워드가 진행되었는지 알 수 없다.

```java
Requestdispatcher  ds = request.getRequestDispatcher("포워드할 서블릿 또는 JSP");
ds.forward(request, response);
```

<br>

### redirect vs dispatch

`redirect`와 같은 다른 포워드 방법은 다른 서버로 이동 가능하다.

코드 한 줄로 다른 사이트 이동이 가능해 이상한 사이트로 이동하게 만들 수 있다.

즉, 보안성이 약해 위험하다.

<br>

`dispatch`는 " **현재 서버의 현재 컨텍스트 내부 파일로만 이동** " 가능하다.

즉, 보안성이 우수하고 안전하다.

---

## dispatch를 이용한 포워딩 수행 과정

![dispatch.png](./image/dispatch.png)

1. 클라이언트의 웹 브라우저에서 첫 번째 서블릿에 요청
2. 첫 번째 서블릿은 `RequestDispatcher`를 이용해 두 번째 서블릿으로 포워드

:milky_way: **예제**
- [포워드(dispatch)](./test/forward)

---
 
 