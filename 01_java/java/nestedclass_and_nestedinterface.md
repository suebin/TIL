# 중첩 클래스와 중첩 인터페이스

## 중첩 클래스란? (Nested Class)

클래스 내부에 선언한 클래스이다. 

```java
class ClassName {
    class NestedClassName { //중첩 클래스
        
    }
}
```



:mushroom: **장점**

- 두 클래스의 멤버들을 서로 쉽게 접근할 수 있다.

- 외부에 불필요한 관계 클래스를 감춤으로써 코드의 복잡성을 줄인다.


<br>
<br>
<br>

중첩 클래스는 **클래스 내부에 선언되는 위치**에 따라 두 가지로 분류
<br>

1.  멤버 클래스 : 클래스 멤버로서 선언되는 중첩 클래스로, 클래스나 객체가 사용 중이라면 언제든지 재사용 ok

   - 인스턴스 멤버 클래스 
   - 정적 멤버 클래스

<br>
<br>   

2.  로컬 클래스 : 메소드 내부에서 선언되는 중첩 클래스로, 메소드 실행 시에만 사용되고 메소드가 실행 종료되면 없어진다.
<br> 
<br>   

---

## 중첩 인터페이스

클래스의 멤버로 선언된 인터페이스를 말한다. 

클래스 내부에 선언하는 이유는 해당 클래스와 긴밀한 관계를 맺는 구현 클래스를 만들기 위해서이다. 

특히 UI 프로그래밍에서 이벤트를 처리할 목적으로 자주 활용된다.

```java
class A {
    interface I {
        void method();
    }
}
```

