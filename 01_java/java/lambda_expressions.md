# 람다식

> 최근 들어 함수적 프로그래밍이 다시 부각되고 있는데, 병렬 처리와 이벤트 지향 프로그래밍에 적합하기 때문이다. 그래서 객체 지향 프로그래밍과 함수적 프로그래밍을 혼합함으로써 더욱 효율적인 프로그래밍이 될 수 있도록 프로그램 개발 언어가 변하고 있다. 람다식은 익명 함수(anonymous function)를 생성하기 위한 식으로 객체 지향 언어보다는 함수 지향 언어에 가깝다. 

<br>

:mushroom: **람다식을 수용한 이유**

- 자바 코드가 매우 간결해진다.

- 컬렉션의 요소를 필터링하거나 매핑해서 원하는 결과를 쉽게 집계할 수 있다.

  <br>

:mushroom: **람다식의 형태**

- 람다식의 형태는 매개 변수를 가진 코드 블록이지만, 런타임 시 익명 구현 객체를 생성

<br>

아래는 Runnable 인터페이스의 익명 구현 객체를 생성하는 전형적인 코드이다.

```java
Runnable runnable = new Runnable() { // 익명 구현 객체 생성
    public void run() {...}
}
```

위 코드에서 익명 구현 객체를 람다식으로 표현한 코드이다.

```java
Runnable runnable = ()->{...};
```

<br>

<br>

---

### 람다식 예제

아래의 예제에서는 3가지 경우를 볼 수 있다.

- 매개변수와 리턴값이 없는 람다식

- 매개변수가 있는 람다식
- 리턴 타입이 있는 람다식

```java
public class LambdaTest {
	@FunctionalInterface // 함수적 인터페이스 : 1개의 추상 메소드만 가지고 있으라는 annotation
	interface I1 {
		/* public abstract */ void m1();
	}

	interface I2 {
		void m1(int x); // 메소드 이름은 중요하지 않다. 람다식에 사용하지도 않는다.
	}

	interface I3 {
		void m1(int x, int y);
	}

	interface I4 {
		int m1(int i, int j);
	}

	public static void main(String[] args) {
		// 람다식 호출 : [인터페이스명][변수명] = [람다식];
		I1 i1 = () -> {
			System.out.println("람다테스트");
		}; // 람다식 정의
		i1.m1(); // 람다테스트

		// 매개변수 타입 생략 가능 (int X -> X)
		// 매개변수가 1개일 때 괄호도 생략 가능
		// {} 내부 1문장일 때 {} 생략 가능
		I2 i2 = x -> System.out.println(x);
		i2.m1(119); // 119

		I3 i3 = (x, y) -> {
			System.out.println(x + y);
			System.out.println(x * y);
		};
		i3.m1(9, 8); // 17, 72

		// I4 i4 =(i, j)->{return i+j;};
		// 리턴타입 있는 메소드는 {... return ...;}과 같은 return 문장 1개 구현 
        // {}, return 생략 가능
		I4 i4 = (i, j) -> i + j;
		int result = i4.m1(10, 10);
		System.out.println(result); // 20

	}
}

```

