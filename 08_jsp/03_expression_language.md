# 표현 언어
:milky_way: **책 범위**
- 13장

<br>

#### JSP의 발전 과정
- HTML 태그를 중심으로 자바를 이용해 화면을 구현
- 자바 코드를 대체하는 액션 태그
- JSP 2.0 : 복잡한 자바 코드를 제거하는 방향
- **현재 : 스크립트 요소보다는 “ 표현언어 “ 와 “ JSTL “을 사용해서 구현**

---
    
## 표현 언어 (EL, Expression Language)

자바 코드가 들어가는 표현식을 좀 더 편리하게 사용하기 위해 

 JSP 2.0부터 도입된 데이터 출력 기능이다.

즉, 자바 코드로 출력하는 표현식을 대체할 수 있다.

<br>

- **표현 언어의 특징**
    - 기존 표현식보다 편리하게 값을 출력한다.
    - 변수와 여러 가지 연산자를 포함할 수 있다.
    - JSP의 내장 객체에 저장된 속성 및 자바의 빈 속성도 표현 언어에서 출력할 수 있다.
    - 표현 언어 자체 내장 객체가 있다.
    - `isELIgnored=false` (=  2.3ver 기본 설정)
    
- **표현 언어의 형식**
    - `${ 표현식 or 값 }`

<br>

:milky_way: **예제**
- [표현 언어의 자료형과 연산자](./test/el/eltest1.jsp)

---

## 표현 언어 내장 객체

`${ }` 안에서만 사용할 수 있다.


#### 1. JSP 내용

- **pageContext** : 같은 JSP 파일 내부 EL 값 공유
    - `pageContext.setAttribute();`  (EL →표현식)
    - `pageContext.getAttribute();`  (표현식 → EL)
    
:milky_way: **예제**
- [pageContext](./test/el/pageContext)

<br>

#### 2. 요청 매개변수

- **param** : 한 개의 값을 전달하는 요청 매개변수를 처리
    - = `request.getParameter()` 와 같은 의미
- **paramValues** : 여러 개의 값을 전달하는 요청 매개변수를 처리
    - = `request.getParameterValues()` 와 같은 의미
    
:milky_way: **예제**
- [param](./test/el/param)
    
<br>

#### 3. 스코프

- **pageScope**
- **requestScope**
- **sessionScope**
- **applicationScope**

:milky_way: **예제**
- [scope](./test/el/scope)

<br>

#### 4. 빈 사용
:milky_way: **예제**
- [빈 사용](./test/el/eltest4.jsp)