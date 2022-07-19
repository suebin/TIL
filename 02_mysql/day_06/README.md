# PreparedStatement
<br>

:milky_way: **예제**
- [test 모음](./test/) 

<br>

---

```java
// 명령어 생성
preparedStatement pt = con.PreparedStatement("실행할 SQL 전달");

// set 메서드 호출 
pt.setInt(1, 100);
pt.setInt(1, 200);
   
// 명령어 실행 (결과셋 리턴: select문인 경우)
ResultSet rs = pt.executeQuery();

...
```

## Statement와 PreparedStatement

- SQL문을 실행할 수 있는 객체
- 가장 큰 차이점은 캐시 사용 여부

### :tulip: Statement

- 쿼리문을 수행할 때마다 SQL 실행단계 1~3단계를 거침
    - SQL 문법 구문 분석 (parsing)
    - 컴파일
    - 실행
- SQL문을 수행하는 과정에서 매번 컴파일을 하기 때문에 성능상 이슈 발생
- 실행되는 SQL문을 확인 가능

### :tulip: PreparedStatement

- 컴파일이 미리 되어있기 때문에 Statement에 비해 좋은 성능
- 여러번 수행할 때 실행속도가 빠르고, 효율적
    - SQL 문법 구문 분석 (parsing)
    - 컴파일
    - 임시저장
    - 실행(100)
    - 실행(200)
- 특수문자를 자동으로 파싱해주기 때문에 SQL injection 같은 공격을 막을 수 있음
- “?” 부분에만 변화를 주어 쿼리문을 수행하므로 실행되는 SQL문을 파악하기 어려움

## PreparedStatement 사용하는 경우

1. 사용자 입력값으로 쿼리문을 실행하는 경우
2. 쿼리 반복 수행 작업일 경우