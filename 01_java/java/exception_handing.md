# 예외 처리 (Exception Handing)

<br>

<br>

- [예외와 예외 클래스](#예외와-예외-클래스)
  - [일반 예외](#일반-예외-exception)
  - [실행 예외](#실행-예외-runtime-exception)

- [예외 처리 코드](#예외-처리-코드)

  - [try-catch-finally](#try-catch-finally)
  - [try-with-resources](#try-with-resources)

- [예외 떠넘기기](#예외-떠넘기기)

- [사용자 정의 예외](#사용자-정의-예외)

  <br>

  <br>
---

## 예외와 예외 클래스

자바는 예외를 **클래스**로 관리한다.

 JVM은 프로그램 실행 도중 예외가 발생하면 해당 예외 클래스로 객체를 생성한다. 

모든 예외 클래스들은 **java.lang.Exception** 클래스를 상속받는다.

![ExceptionHanding](/01_java/image/exception_handing.png)

:mushroom: **일반 예외와 실행 예외 클래스를 구별하는 방법**

**일반 예외** : `Exception`을 상속 받지만 `RuntimeException`을 상속받지 않는 클래스

**실행 예외** : `RuntimeException`을 상속받는 클래스

> JVM은 `RuntimeException`을 상속했는지 여부를 보고 실행 예외를 판단!

<br>

<br>

---

### 일반 예외 (Exception)

컴파일러 체크 예외라고도 한다.

자바 소스를 컴파일하는 과정에서 예외 처리 코드가 필요한지 검사하는데, 

만약 **예외 처리 코드**가 없다면 컴파일 오류가 발생한다.

<br>

<br>

---
### 실행 예외 (Runtime Exception)

컴파일하는 과정에서 예외 처리 코드를 검사하지 않는 예외를 말한다.

실행 예외는 자바 컴파일러가 체크를 하지 않기 때문에 개발자의 경험에 의해 **예외 처리 코드**를 삽입해야 한다.

<br>

:mushroom: **자주 발생하는 실행 예외**

`NullPointerException` : 객체 참조가 없는 상태

`ArrayIndexOutOfBoundsException` 배열에서 인덱스 범위를 초과하여 사용할 경우

`NumverFormatException` : ex) Integer.parseInt(String s)

`ClassCastException` : 억지로 형변환을 시도할 경우

<br>

<br>

---

## 예외 처리 코드

예외 처리 코드는 try-catch-finally 블록이 대표적이다. 경우에 따라서  try-with-resources를 사용할 수도 있다.

예외 처리 코드 작성 시 만약 어떤 이유로 예외가 발생하는지 모를 때에는 `e.printStackTrace();`를 사용하자!

<br>

### try-catch-finally 

```java
try {
    예외 발생 가능 코드;
}
catch (예외클래스 e) {
    예외 처리
}
catch (예외클래스 e) {
    예외 처리
}
finally {
    항상 실행;
}
```

:mushroom: **try 블록의 코드가 예외 발생 없이 정상 실행된다면 ?**

`catch 블록`의 코드는 실행되지 않고 `finally 블록`의 코드를 실행한다.

<br>

:mushroom: **try 블록의 코드에서 예외가 발생한다면  ?**

즉시 실행을 멈추고 `catch 블록`으로 이동하여 예외 처리 코드를 실행한다. 그리고  `finally 블록`의 코드를 실행한다. 

<br>

:mushroom: **finally 블록은 ?**

`finally 블록`은 옵션이다. 

예외 발생 여부와 상관없이 항상 실행할 내용이 있을 경우에만 `finally 블록`을 작성해주면 된다.

<br>

:sparkler: **예외별로 예외 처리 코드를 다르게 하고 싶다면 `다중 catch 블록`을 작성하자!**

>  `다중 catch 블록`을 작성할 때는 **상위 클래스가 하위 예외 클래스보다 아래쪽에 위치해야 한다.**

<br>

:sparkler: **하나의 catch 블록에서 여러 개의 예외를 처리하고 싶다면 `멀티 catch 블록`을 작성하자!**

>  `멀티 catch 블록`을 작성할 때는 **catch 괄호() 안에 동일하게 처리하고 싶은 예외를 |로 연결한다.**

<br>

<br>

### try-with-resources

예외 발생 여부와 상관없이 사용했던 리소스 객체의 close() 메소드를 호출해서 안전하게 리소스를 닫아준다.

리소스 객체는 java.lang.AutpCloseeable 인터페이스를 구현하고 있어야 한다.

ex) FileInputStream의 fis.close()

<br>

<br>

---

## 예외 떠넘기기 

try-catch 블록으로 예외를 처리하는 것이 일반적이지만, 경우에 따라서는 throws를 통해 메소드를 호출한 곳으로 예외를 떠넘길 수도 있다. 

`throws Exception` 으로 간단히 모든 예외를 떠넘길 수도 있지만 좋지 못한 예외 처리 방법이다. 프로그램 사용자는 프로그램이 알 수 없는 예외 내용을 출력하고 종료되는 것을 좋아하지 않는다. 

따라서 결국 `try-catch 블록`으로 예외를 최종 처리하는 것이 바람직하다.

```java
리턴타입 메소드명(매개변수, ...) throws 예외클래스1, 예외클래스2, ... {
    
}
```

- `throws ArithmeiticException` 는 `e.printStackTrace()`와 동일한 기능을 한다! 

<br>

<br>

---

## 사용자 정의 예외

<br>

사용자 정의 예외 클래스는 일반 예외로 선언할 경우 `Exception`을 상속하면 되고, 실행 예외로 선언할 경우에는 `RuntimeException`을 상속하면 된다.

```java
throw new XXXException(); // 기본 생성자
throw new XXXException("메시지"); // 예외 메시지를 갖는 생성자
```

위의 코드는 예외를 발생시키는 코드이다.
사용자 정의 예외 클래스 이름은 Exception으로 끝나는 것이 좋다.

<br>

```java
Class A {
    void m1(int i) {
        if(i == -1) {
            throw new ArithmeticException("음수 나누기 불가");
        }
        else {
            System.out.println(100/1);
        }
    }
}

public class ThrowTest {
    public static void main(String[] args) {
        A a1 = new A();
        try {
            a1.m1(-1);
        }
        catch (ArithmeticException e) { //오류 메시지를 호출하려고 할 때
            System.out.println(e.getMessage());
        }
    }
}
```
<br>
<br>

---
#### 관련 예제
[CellPhoneTest](https://github.com/suebin/TIL/blob/master/01_java/example/CellPhoneTest.java)
