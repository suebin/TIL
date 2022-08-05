# 서블릿 (Servlet)

<br>

:milky_way: **책 범위**
- 교재 5장, 6장 (자바 웹을 다루는 기술)

<br>

---

## 서블릿(Server Side Applet)이란 ?

단순히 고정된 정보를 브라우저에 보여주는 용도는 웹 서버로도 충분하다. 하지만 쇼핑몰 화면에 실시간으로 변하는 상품의 할인 가격을 보여주려면 상품의 할인 가격을 데이터베이스에서 가져오는 기능이나 직접 계산하는 기능이 필요하다. 그런 기능을 서버 쪽에서 서블릿이 처리해주면 상품 할인 가격 표시처럼 웹 페이지에서 동적으로 변하는 정보를 효과적으로 다룰 수 있다.

<br>

- 서버 쪽에서 실행되면서 클라이언트의 요청에 따라 동적으로 서비스를 제공하는 자바 클래스
- 톰캣과 같은 JSP/Servlet 컨테이너에서 실행
- 서버에서 실행되다가 웹 브라우저에서 요청을 하면 해당 기능을 수행한 후 웹 브라우저에 결과를 전송 (결과물 ex) html, css, js …)
- 서버에서 실행되므로 보안과 관련된 기능도 훨씬 안전하게 수행 O
- 스레드 방식으로 실행
- 자바로 만들어져 자바의 특징(객체지향)을 가짐

<br>

:milky_way: **예제**
- [첫번째 서블릿](./test/FirstServlet.java)

---

## 서블릿의 세 가지 기본 기능

1. 클라이언트로부터 요청을 받는다.
2. 데이터베이스 연동과 같은 비즈니스 로직을 처리한다.
3. 처리한 결과를 클라이언트에 돌려준다.

---

## 서블릿 매핑

#### 1. web.xml
- 155~157p

:milky_way: **예제**
- [web.xml로 url 매핑하기](./test/ThirdServlet.java)

<br>

#### 2. WebServlet 어노테이션
- 167~173p

:milky_way: **예제**
- [webServlet 어노테이션으로 url 매핑하기](./test/SecondServlet.java)

---
## 서블릿의 생명주기 메서드
- 144~145p

서블릿의 상속 클래스는 `HttpServlet`이다. 


HttpServlet  메서드 중 `doGet()` 은 보통 기본적으로 사용한다.

```java
//초기화
init()

// 작업 수행
doGet()
doPost()

// 종료
destroy()
```

:milky_way: **예제**
- [서블릿의 생명주기 메서드](./test/LifeCycleServlet.java)

---
## 클라이언트(웹 브라우저)의 요청에 응답하기

#### 서블릿에서 클라이언트의 요청을 얻기 : HttpServletRequest 
- `request.getParameter()` : 하나의 값
- `request.getParameterValues()` : 여러 개의 값
- `request.getParameterNames()`

<br>

#### 서블릿이 클라이언트에게 응답하기 : HttpServletResponse
1. `setContentType()`을 이용해 MIME-TYPE 지정
2. 데이터를 출력할 `PrintWriter 객체` 생성
3. 출력 데이터를 HTML 형식으로 만들기
4. PrintWriter의 `print()`나 `println()`을 이용해 데이터 출력

<br>

:milky_way: **예제**
- [클라이언트의 요청에 응답하기](./test/register)