

#  새로 배운 기본 API 클래스

<br>

- [Pattern 클래스](정규-표현식과-pattern-클래스)
- [Wrapper 클래스](wrapper-클래스)

<br>

<br>

---

## 정규 표현식과 Pattern 클래스

### 정규 표현식

특정한 규칙을 가진 문자열의 집합을 표현하는데 사용되는 언어로, 컴퓨터 과학의 정규 언어로부터 유래하였다. 

이메일, 전화번호를 사용자가 제대로 입력했는지 검증해야 할 때 정규표현식과 비교한다.

<br>

#### 자주 쓰는 정규표현식

| **정규 표현식**                            | **설명**     |
| ------------------------------------------ | ------------ |
| ^[0-9]*$                                   | 숫자         |
| ^[a-zA-Z]*$                                | 영문자       |
| ^[가-힣]*$                                 | 한글         |
| \\w+@\\w+\\.\\w+(\\.\\w+)?                 | E-Mail       |
| ^\d{2,3}-\d{3,4}-\d{4}$                    | 전화번호     |
| ^01(?:0\|1\|[6-9])-(?:\d{3}\|\d{4})-\d{4}$ | 휴대전화번호 |
| \d{6} \- [1-4]\d{6}                        | 주민등록번호 |
| ^\d{3}-\d{2}$                              | 우           |

<br>

참고할 블로그 : [정규표현식 사용법 및 예제 - Pattern, Matcher](https://hbase.tistory.com/160)

<br>

관련 예제 : [https://github.com/suebin/TIL/blob/master/java/example/RegularExpressionTest.java]

<br>

<br>

---

## Wrapper 클래스

자바는 기본 타입의 값을 갖는 객체를 생성할 수 있다. 이런 객체를 포장(Wrapper) 객체라고 하는데, 

그 이유는 기본 타입의 값을 내부에 두고 포장하기 때문이다.

| 기본 타입 | wrapper 클래스 = 참조형 변수 |
| --------- | :--------------------------- |
| byte      | Byte                         |
| char      | Character                    |
| short     | Short                        |
| int       | Integer                      |
| long      | Long                         |
| float     | Float                        |
| double    | Double                       |
| boolean   | Boolean                      |

