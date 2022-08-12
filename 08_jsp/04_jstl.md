# JSTL
:milky_way: **책 범위**
- 14장

<br>

## 커스텀 태그
JSP 페이지에서 자주 사용하는 자바 코드를 대체하기 위해 만든 태그이다.

<br>

#### JSTL(JSP Standard Tag Library) 
- JSP 페이지에서 가장 많이 사용하는 기능을 태그로 제공한다.
- JSTL 라이브러리를 따로 설치해서 사용한다.

#### 개발자가 만든 커스텀 태그 
- 스트러츠나 스프링 프레임워크에서 미리 만들어서 제공한다.


---

## JSP 표준 태그 라이브러리 (JSTL)
JSTL(JSP Standard Tag Library)이란 커스텀 태그 중 가장 많이 사용되는 태그를 표준화하여 라이브러리로 제공한다.

<br>

#### 사용 방법

1. 라이브러리 다운받기 (https://repo1.maven.org/maven2/jstl/jstl/1.2/)
2. 프로젝트의 lib 폴더에 붙여 넣기
3. JSP 페이지 상단에 `<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>` 추가하기

---

## Core 태그 라이브러리

- **변수 지원**
    - `<c:set>` : JSP 페이지에서 변수를 지정한다.
    - `<c:remove>` : 지정된 변수를 제거한다.

- **흐름 제어**
    - 조건문 : `<c:if>` 
    - switch문 : `<c:choose>`  
        - `<c:when>`
        - `<c:otherwise>`
    - 반복문 : `<c:forEach>`  

- **URL 처리**
    - `<c:url>` : 요청 매개변수로부터 URL을 생성한다.
    - `<c:import>` : URL을 이용해 다른 자원을 JSP 페이지에 추가한다. (jstl2.jsp)

<br>

:milky_way: **예제**
- [Core 태그 라이브러리](./test/jstl)




