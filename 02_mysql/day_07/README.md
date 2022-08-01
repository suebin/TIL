# DTO와 DAO

<br>

:milky_way: **예제**
- [콘솔창에서 CRUD 기능을 하는 회원 관리 프로그램](./jdbc)

<br>

---

## DTO (Data Transfer Object)

- 계층 간 데이터 교환을 위한 자바빈즈
- DTO에서 데이터를 중간에 저장하고, DAO에 넘겨줌
- 일반적인 DTO는 로직을 가지고 있지 않은 순수한 데이터 객체로 getter, setter 메소드만 가진 클래스 (생성자, toString()도 o)

## DAO (Data Access Object)

- Database의 Data에 접근을 위한 객체
- DB에 접속하여 CRUD 작업을 시행
- 데이터를 조회하거나 조작하는 기능을 전담
- 코드의 간결화, 모듈화, 유지보수를 위해 사용

## JavaBeans

- 일반적으로 DTO는 로직을 가지고 있지 않은 순수한 데이터의 객체로, 자바로 작성된 소프트웨어 컴포넌트(Bean)을 지칭
- 객체의 속성과 그 속성의 접근을 위한 getter 및 setter 메소드만을 가지고 있음
- 자바 관련 소프트웨어 개발에 있어 재사용이 가능한 표준 컴포넌트 모델