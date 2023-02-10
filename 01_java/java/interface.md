# 인터페이스(Interface) 

<br>

1.  **추상 메소드**만 포함한다. 구현부가 없는 `public abstract`로 자동으로 정의해준다.

2.   `implements` : 클래스 다중 상속을 흉내 

3.  인터페이스를 포함한 추상 메소드는 반드시 **overriding**!

4.  인터페이스 타입  **객체 생성은 불가능**하다. abstract 클래스는 객체 생성이 불가하기 때문이다.

   - 따라서 상속은 의무이다. 

   - `인터페이스 변수`는 객체 생성하지 않고 사용 가능 (`public static final` 변수 자동 정의)

   - 생성자가 없다. (자동 정의되는 기본 생성자도 없다.)

     <br>

```java
interface 학생 {
    //자동이라서 눈에 안 보임
    (public static final자동) 변수;
    (public abstract 자동) void 공부하다();
}

interface 교직원 {
    일하다();
}

class 조교 extends 사람(클래스) implements 학생 교직원(인터페이스) { //클래스는 하나만 상속, 인터페이스는 여러개 가능 //만약 상속받지 않는다면 슈퍼클래스는 object 클래스임
    공부하다() {반드시 오버라이딩};
    점심먹다() {반드시 오버라이딩};
    일하다() {반드시 오버라이딩};
}
```

<br>

<br>

<참고>

jdk 1.8 이상, 추가된 인터페이스 문법

```java
interface I1 {
    void ma(); // 필수로 오버라이딩!
    default void mb() {
        System.out.println("I1 상속받은 모든 하위클래스들은 공통으로 구현해! 근데 선택해서 재정의해도 돼!")
    }
   static void mc() {
       System.out.println("I1 상속받은 모든 하위클래스들은 공통으로 구현해!")
   }
}

```

