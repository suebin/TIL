# 자바 코드를 없애는 액션 태그

:milky_way: **책 범위**
- 13장

<br>

## 액션 태그
JSP가 등장하게 된 배경은 디자이너가 자바 코드를 사용하지 않고도 쉽게 화면을 구현할 수 있도록 하기 위함이다. 

따라서 JSP에는 스크립트릿의 자바 코드 대신 디자이너 입장에서 더 쉽고 편리하게 작업할 수 있는 액션 태그가 있다. 

즉, 액션 태그는 자바 코드를 대신한다.

<br>

- **인클루드 액션 태그 (Include Action Tag)**
    - `<jsp:include page="jsp페이지" flush="true 또는 false">`
    - 이미 있는 JSP를 현재 JSP에 포함한다.
- **포워드 액션 태그 (Forward Action Tag)**
    - `<jsp:forward page="포워딩 할 JSP 페이지">`
    - 서블릿에서 RequestDispaatcher 클래스의 포워딩 기능을 대신한다.
- **useBean 액션 태그**
    - `<jsp:useBean id="빈 이름" class="패키지 이름을 포함한 자바 빈 클래스 [scope="접근범위"] />`
    - 객체를 생성하기 위한 new 연산자를 대신한다.
- **setProperty 액션 태그**
    - `<jsp:setProperty name="자바 빈 이름(useBean 액션 태그의 id)" property="속성 이름" value="값" />`
    - setter를 대신한다.
- **getProperty 액션 태그**
    - `<jsp:getProperty name="자바 빈 이름(useBean 액션 태그의 id)" property="속성 이름" />`
    - getter를 대신한다.
    
<br>

:milky_way: **예제**
- [Include Action Tag](./test/include)
- [Forward Action Tag](./test/forward)
- [useBean, setProperty, getProperty Action Tag : 내 정보 수정 (U)](./test/useBean%2C%20setProperty%2C%20getProperty)
---
## 번외 : 기본적인 로직
보통 클라이언트의 요청이 들어오면  `분석 - 처리 - 응답` 의 로직을 따른다. 

- 요청 분석 : servlet
- 요청 처리 : DAO (DAO에서 DTO 호출)
- 요청 응답 : JSP

<br>

1. `servlet`에서 클라이언트의 요청을 받고, 분석한다.
2. `servlet`에서 `DAO`를 호출한다. (비즈니스 로직 처리)
    - `DAO`는 분석을 처리한다.
    - `DAO`에서 필요에 따라 `DTO`를 호출한다.
3. 처리를 마친 `servlet`을 `JSP`로  fowarding 한다.
4. `JSP`에서 화면 기능(웹 브라우저 출력)을 담당한다.