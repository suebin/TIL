# JSP 스크립트 요소 기능

:milky_way: **책 범위**
- 12장

<br>

:milky_way: **종합 예제**
- [JSP로 로그인/회원가입 기능 구현하기](./test/login_logout)
- [JSP로 구구단 구현하기](./test/times_table)

---

## JSP 스크립트 요소 (Scripting Element)

JSP 페이지에서 여러 가지 동적인 처리를 제공하는 기능이다.

- **선언문 (declaration tag)**
    - `<%! 멤버 변수 or 멤버 메서드 %>`
    - JSP에서 변수나 메서드를 선언할 때 사용한다.
- **스크립트릿 (scriptlet)**
    - `<% 자바 코드 %>`
    - JSP에서 자바 코드를 작성할 때 사용한다.
- **표현식 (expression tag)**
    - `<%= 값 or 자바 변수 or 자바 식 %>`
    - JSP에서 변수의 값을 출력할 때 사용한다.

---

## JSP의 주석문

- 자바 주석
- HTML 주석
- JSP 주석 : `<%-- --%>`

---

## JSP 내장 객체(내장 변수)

JSP가 서블릿으로 변환될 때 컨테이너가 자동으로 생성시키는 서블릿 멤버 변수이다.

_jspService() 메서드의 지역 변수라고 할 수도 있다.

- `request` : 클라이언트의 요청 정보를 저장
- `response` : 응답 정보를 저장
- `out` : JSP 페이지에서 결과 출력
- `session` : 세션 정보를 저장
- `application` : 컨텍스트 정보를 저장
- `pageContext` : JSP 페이지에 대한 정보를 저장
- `page` : JSP 페이지의 서블릿 인스턴스를 저장
- `config` : JSP 페이지에 대한 설정 정보를 저장
- `exception` : 예외 발생 시 예외를 처리

---
## session 내장 객체에 데이터 바인딩 

- 스코프 : 같은 브라우저에서 공유
    - **실행 브라우저 종료 시까지** 같은 서버의 같은 컨텍스트 내 파일들
<br>

:milky_way: **예제**
- [session 내장 객체에 데이터 바인딩](./test/session)

<br>

## application 내장 객체에 데이터 바인딩 

- 스코프 : 같은 애플리케이션에서 공유
    - **tomcat server 종료 시까지** 같은 서버의 같은 컨텍스트 내 파일들
    - 브라우저 종료 이후에도 실행 가능
    - 브라우저 종류 달라도 공유 가능
<br>

:milky_way: **예제**
- [application 내장 객체에 데이터 바인딩](./test/application)

<br>

## request 내장 객체에 데이터 바인딩 

- 스코프 : 한 번의 요청에 대해 같은 요청을 공유하는 JSP 페이지를 공유
    - `RequestDispatcher`를 이용해 **포워드를 할 때만** 공유

<br>

## out 내장 객체 이용해 데이터 출력

:milky_way: **예제**
- [out 내장 객체에 데이터 바인딩](./test/out)

---

## JSP 페이지 예외 처리

- **JSP 페이지 예외 처리** (Exception : 자바 오류)
    1. `예외 처리 담당 JSP`를 만들기
    
    ```java
    <%@ page isErrorPage='true' %>
    ```
    
    2. 일반 JSP 페이지에서 예외 발생 시 `예외 처리 담당 JSP`를 지정
    
    ```java
    <%@ page errorPage='a.jsp' %>
    ```
    
- **에러 코드에 따른 예외 페이지 지정** (HTTP 프로토콜 오류)
    1. `web.xml`에서 각각의 에러 코드에 대한 예외 처리 페이지를 지정
    
    ```xml
    <web-app>	
    	<error-page>
      	<error-code>404</error-code>
      	<location>/error/e404.jsp</location>
      </error-page>
    </web-app>
    ```
    2. `e404.jsp` 만들기
    
<br>

:milky_way: **예제**
- [JSP 예외 처리](./test/error)

---

- web.xml 만들기
    
    `해당 프로젝트 우클릭` - `Java EE Tools` - `Generate Deployment  Descriptor Stub`
    
---

## JSP welcome 파일 지정하기

웹 애플리케이션 첫 화면에 해당하는 홈페이지를 web.xml에 등록해 두면 브라우저에서는 컨텍스트 이름 만으로 요청하여 간단하게 표시할 수 있다. 여러 개를 등록한다면 첫 번째로 지정한 welcome 파일부터 차례로 찾아 보여준다. 만약 지정한 welcome 파일을 모두 찾을 수 없다면 404 오류를 발생 시킬 것이다.

```xml
<web-app>
	<welcome-file-list>
		<welcome-file>jsp 또는 html 파일 이름 1</welcome-file>
		<welcome-file>jsp 또는 html 파일 이름 2</welcome-file>
	</welcome-file-list>
</web-app>
```