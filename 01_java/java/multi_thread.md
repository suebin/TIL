# 멀티 스레드



- [멀티 스레드란?](#멀티-스레드란)
- [메인 스레드](#메인-스레드)
- [작업 스레드 생성과 실행](#작업-스레드-생성과-실행)
- [스레드 이름](#스레드-이름)
- [스레드 우선순위](#스레드-우선순위)
- [스레드 상태 제어](#스레드-상태-제어)
- [동기화 메소드와 동기화 블록](#동기화-메소드와-동기화-블록)

<br>

<br>

---

## 멀티 스레드란?

- **스레드 (thread)** 

  한 가닥의 실이라는 뜻인데, 한 가지 작업을 실행하기 위해 순차적으로 실행할 코드를 실처럼 이어 놓았다고 해서 유래한 이름

- **프로세스 (process)** 

  실행 중인 하나의 애플리케이션

  <br>

  <br>

- **멀티 스레드와 멀티 프로세스**

  > 멀티 프로세스들은 운영체제에서 할당받은 자신의 메모리를 가지고 실행하기 때문에 서로 독립적이다.
  >
  > 따라서 하나의 프로세스에서 오류가 발생해도 다른 프로세스에게 영향을 미치지 않는다. 
  >
  > 하지만 멀티 스레드는 하나의 프로세스 내부에 생성되기 때문에 하나의 스레드가 예외를 발생시키면 
  >
  > 프로세스 자체가 종료될 수 있어 다른 스레드에게 영향을 미치게 된다.

  

  - **멀티 스레드** 

    - 애플리케이션 내부의 멀티 태스킹 
    - 메신저 내의 파일 전송 스레드에서 예외가 발생되면 메신저 프로세스 자체가 종료되기 때문에 채팅 스레드도 같이 종료
    - 예외 처리 중요!

  - **멀티 프로세스** 

    - 애플리케이션 단위의 멀티 태스킹

    - 엑셀, 워드, 크롬 중 하나 엑셀에 오류가 생겨도 크롬 사용 가능

      

      <br>

<br>

---

## 메인 스레드

`main 메소드`도 스레드로 보는 것이다.

모든 자바 프로그램은 메인 스레드가 `main 메소드` 실행하며 시작한다.

`main 메소드`의 첫 코드부터 아래로 순차적으로 실행한다.
<br>
<br>


- 실행 종료 조건
  - 마지막 코드 실행
  - return 문을 만났을 때
  <br>
- main 스레드는 작업 스레드를 만들어 병렬로 코드를 실행
  - 멀티 스레드를 생성해 멀티 테스킹 수행
  <br>
- 프로세스 종료
  - 싱글 스레드: 메인 스레드가 종료하면 프로세스도 종료
  - 멀티 스레드: 실행중인 스레드 하나라도 있다면 프로세스 미종료

<br>

<br>

---

## 작업 스레드 생성과 실행

### 1. java.lang.Thread 클래스 이용

:bulb:  관련 예제 : 
- [ThreadTest](https://github.com/suebin/TIL/blob/master/01_java/example/ThreadTest.java)

- [MyThreadTest](https://github.com/suebin/TIL/blob/master/01_java/example/MyThreadTest.java)



```java
class A extends Thread {
    public void run() { 멀티 스레드 실행 코드; } 
}
main () {
    A ai = new a();
    a1.start(); // 상속 호출, run 실행
    System.out.println("출력")
}
```

1. `Thread 클래스` 상속

2. `run() 메소드` Overriding

3. `Thread 하위클래스 객체` 생성

4. `start()` 호출

   <br>

   <br>

### 2. java.lang.Runnable 인터페이스 이용 (다중상속 메소드 Overriding) 

:bulb:  관련 예제 : [RunnableTest](https://github.com/suebin/TIL/blob/master/01_java/example/RunnavleTest.java)

:bulb:  참고 예제 : [RunnableTest2](https://github.com/suebin/TIL/blob/master/01_java/example/RunnableTest2.java)

```java
//이미 상속받고 있는 경우 추가 상속이 안되니까 인터페이스로!
class extends C implements Runnable {
 	public void run()
    C 상속 (그대로/오버라이딩)
}

main () {
    A a1 = new A(); // Runnable a1 = new A() 와 같다 (형변환 규칙에 의해)
    // a1.start() 스레드 메소드 안에 있는 start() 상속 호출할 수 x
    Thread ta1 = new Threaed(a1); //Runnable 타입 객체
    ta1.start();
}
```

1. `Runnable 인터페이스` 상속
2. `run() 메소드` Overriding
3. `Runnable 하위클래스 객체` 생성
4.  `Thread 객체 생성`
5. 4번 객체의 `start()` 호출

<br>

<br>

---

## 스레드 이름

>  스레드는 자신의 이름을 가지고 있다.
>
> 디버깅을 할 때 어떤 스레드가 어떤 작업을 하는지 조사할 목적으로 가끔 사용된다.
>
> 메인 스레드는 'main' 이라는 이름을 가지고 있고,
>
> 직접 생성한 스레드는 자동적으로 'Thread-n'이라는 이름으로 설정된다. (n은 숫자) 

 <br>

:microphone:  `setName()` : 다른 이름으로 설정하고 싶을 때

:microphone:  `getName()` : 스레드 이름을 알고 싶을 때

:microphone:  `private name` 

<br>
<br>

---

## 스레드 우선순위

- 멀티 스레드는 동시성(Concurrency) 또는 병렬성(Parallelism)으로 실행된다.

![동시성과 병렬성](/01_java/image/concurrency_and_parallelism.png)

<br>

### :date: 스레드 스케줄링 

스레드의 개수가 코어의 수보다 많은 경우, 스레드를 어떤 순서에 의해 동시성으로 실행할 것인가를 결정한다.

스레드 스케줄링에 의해 스레드들은 아주 짧은 시간에 번갈아가며 그들의 `run() 메소드`를 조금씩 실행한다.

<br>

#### :one: 우선순위(Priority) 방식

- 우선순위가 높은 스레드가 실행 상태를 더 많이 가지도록 한다.

- 1에서부터 10까지 부여한다.

- 1이 가장 우선순위가 낮고, 10이 가장 높다.

- `thread.setPriority(우선순위)` : 우선순위 변경

  ```java
  thread.setPriority(Thread.MAX_PRIORITY); // 10 
  setPriority(Thread.MIN_PRIORITY); // 1
  setPriority(Thread.NORM_PRIORITY); // 5 (기본값)
  ```

  :bulb:  관련 예제 : [ThreadPriorityTest](https://github.com/suebin/TIL/blob/master/01_java/example/ThreadPriorityTest.java)

  <br>

#### :two: 순환 할당 (Round-Robin) 방식

- 시간 할당량(Time Slice)을 정해서 하나의 스레드를 정해진 시간만큼 실행하고 다시 다른 스레드를 실행한다.
- 자바 가상 기계에 의해 정해지기 때문에 코드로 제어할 수 없다.

<br>
<br>

---

## 스레드 상태 제어

### Thread 메소드

- `sleep()`

  - `static`  
  - 예외 처리
  - 스레드 실행을 잠시 멈추고 지정시간 경과 후 다시 실행

- `join()`

  - `non-static` 

  - 예외 처리

  - 스레드 실행을 잠시 멈추고 다른 스레드를 먼저 실행 완료하면 그 때 실행

    :bulb:  관련 예제 : [JoinTest](https://github.com/suebin/TIL/blob/master/01_java/example/JoinTest.java)

<br>

<br>

---

## 동기화 메소드와 동기화 블록

멀티 스레드 프로그램에서는 스레드들이 객체를 공유해서 작업하는 경우가 있다. 스레드가 사용 중인 객체를 다른 스레드가 변경할 수 없도록 하려면 스레드 작업이 끝날 때까지 객체에 잠금을 걸어서 다른 스레드가 사용할 수 없도록 해야 한다.

<br>

- 임계 영역 (critical section) : 멀티 스레드 프로그램에서 단 하나의 스레드만 실행할 수 있는 코드 영역

- `synchronized 메소드` 와 `동기화 블록` : 임계 영역을 지정하기 위해 사용!

:bulb:  관련 예제 : [SynchronizedTest](https://github.com/suebin/TIL/blob/master/01_java/example/SynchronizedTest.java)

