# 제네릭

<br>

- [제네릭이란?](#제네릭이란)
- [제네릭과 비제네릭](#제네릭과-비제네릭)
- [멀티 타입 파라미터](#멀티-타입-파라미터-multi-type-parameter)
- [제한된 타입 파라미터](#제한된-타입-파라미터-bounded-type-parameter)

<br>

<br>

---

## 제네릭이란?

제네릭 타입을 이용함으로써 잘못된 타입이 사용될 수 있는 문제를 컴파일 과정에서 제거할 수 있게 되었다. 제네릭은  클래스와 인터페이스, 그리고 메소드를 정의할 때 타입(type)을 파라미터(parameter)로 사용할 수 있도록 한다. 제네릭을 사용하는 코드는 비제네릭 코드에 비해 다음과 같은 이점으르 가지고 있다.

:mushroom: 컴파일 시 강한 타입 체크를 할 수 있다.

:mushroom: 타입 변환(casting)을 제거한다.

<br>

<br>

---

## 제네릭과 비제네릭

#### Q. 아래 문제를 비제네릭 코드와 제네릭 코드로 풀어보자!

> origin 변수를 담고 있는 Apple 클래스가 있고, size 변수를 담고 있는 Paper 클래스가 있다.
>
> Apple 혹은 Paper를 담을 수 있는 Box 클래스가 있다.
>
> Box클래스에 사과가 담겼다면 원산지를 출력하고, 종이가 담겼다면 사이즈를 출력한다. 
>
> 명령행 매개변수를 통해 입력을 받는다. (ex) apple 대구) 

<br>

#### 1. 비제네릭 (non-generic) 

```java
// 사과의 원산지를 표시하는 클래스
class Apple {
	String origin;
	Apple(String origin) {
		this.origin = origin;
	}
}

// 종이의 사이즈를 표시하는 클래스
class Paper {
	String size;
	Paper(String size) {
		this.size = size;
	}
}

// 사과 혹은 종이를 담을 수 있는 클래스
class Box {
	Object contents; // Apple, Paper 를 비롯한 모든 객체
	
	public Object getContents() {
		return contents;
	}

	public void setContents(Object contents) {
		this.contents = contents;
	}
	
}

// 명령행 매개변수
// ex) apple 대구 
// ex) paper A4
public class BoxTest {

	public static void main(String[] args) {
		
		Apple a = null; 
		Paper p = null;
       
        
		// args[0]이 apple이라면 a는 원산지를 의미하는 args[1]
		if(args[0].equalsIgnoreCase("apple")) {
			a = new Apple(args[1]);
		}
        // args[0]이 paper라면 p는 사이즈를 의미하는 args[1]
		else if(args[0].equalsIgnoreCase("paper")) {
			p = new Paper(args[1]);
		}
        
		Box b1 = new Box(); 
      
		if (a!=null) {   //a가 null값이 아니라면 b1의 contains는 대구
			b1.setContents(a);
		}
		else if(p!=null) { //p가 null값이 아니라면 b1의 contains는 A4
			b1.setContents(p);
		}

		Object o = b1.getContents();
		if(o instanceof Apple) { 
			System.out.println(((Apple)o).origin);
		}
		else if (o instanceof Paper) {
			System.out.println(((Paper)o).size);
		}
	}

}
```

<br>

<br>

#### 2. 제네릭 (generic)

```java
class Apple {
	String origin;
	Apple(String origin) {
		this.origin = origin;
	}
}

class Paper {
	String size;
	Paper(String size) {
		this.size = size;
	}
}

// generic class
//<클래스명>
class Box<T> { //type parameter = 클래스 타입 전달
	T contents; // Apple, Paper 를 비롯한 모든 객체
	
	public T getContents() {
		return contents;
	}

	public void setContents(T contents) {
		this.contents = contents;
	}
	
}

public class BoxTest {

	public static void main(String[] args) {
        // 명령행 매개변수 - apple 대구
		// 명령행 매개변수 - paper a4
		Apple a = null;
		Paper p = null;
		
		if(args[0].equalsIgnoreCase("apple")) {
			a = new Apple(args[1]);
			Box <Apple> b1 = new Box<Apple>();
			b1.setContents(a);
			Apple o = b1.getContents();
			System.out.println(o.origin);
		}
		
		else if(args[0].equalsIgnoreCase("paper")) {
			p = new Paper(args[1]);
			Box <Paper> b2 = new Box<Paper>();
			b2.setContents(p);
			Paper o = b2.getContents();
			System.out.println(o.size);
			
		}
    }
}
```

<br>

<br>

---

### 멀티 타입 파라미터 (multi type parameter)

제네릭 타입은 두 개 이상의 멀티 타입 파라미터를 사용할 수 있다.  ex) class<K, V ...>

```java
class Apple {
	String origin;
	Apple(String origin) {
		this.origin = origin;
	}
}

class Paper {
	String size;
	Paper(String size) {
		this.size = size;
	}
}

class Box<T> {
	T contents; 
	
	public T getContents() {
		return contents;
	}

	public void setContents(T contents) {
		this.contents = contents;
	}
	
}


class TwoBox<T1, T2> { // 보통 3개 이하로!
	T1 o1;
	T2 o2;
	
	TwoBox(T1 o1, T2 o2) {
		this.o1 = o1;
		this.o2 = o2;
	}

}

public class BoxTest {

	public static void main(String[] args) {
        // 멀티 타입 파라미터 
		TwoBox<Apple, Paper> twobox = new TwoBox(new Apple("경북영주"), new Paper("B5"));
		
		// 클래스 이름 알려줘
		System.out.println(twobox.o1.getClass().getName()); //패키지명.Apple
		System.out.println(twobox.o2.getClass().getName()); //패키지명.Paper
		
		// String과 Integer 타입으로 지정
		TwoBox<String, Integer> twobox2 = new TwoBox(new Apple("경북영주"), new Paper("100"));
        
    }
}
```

<br>

<br>

---

### 제한된 타입 파라미터 (bounded type parameter)

타입 파라미터에 지정되는 구체적인 타입을 제한할 필요가 종종 있다.

예를 들어 숫자를 연산하는 제네릭 메소드는 매개값으로 

Number 타입 또는 하위 클래스 타입 (Byte, Short, Integer, Long, Double)의 인스턴스만 가져야 한다.

제한된 타입 파라미터를 선언하려면 타입 파라미터 뒤에 extends 키워드를 붙이고 상위 타입을 명시하면 된다.

상위 타입은 클래스뿐만 아니라 인터페이스도 가능하고, 인터페이스라고 해서 implements를 사용하지 않는다.

```java
public <T extends 상위타입> 리턴타입 메소드(매개변수, ...) {...}
```

<br>

```java
class Apple {
	String origin;
	Apple(String origin) {
		this.origin = origin;
	}
}

class Paper {
	String size;
	Paper(String size) {
		this.size = size;
	}
}

// generic class
//<클래스명>
class Box<T> { //type parameter = 클래스 타입 전달
	T contents; // Apple, Paper 를 비롯한 모든 객체
	
	public T getContents() {
		return contents;
	}

	public void setContents(T contents) {
		this.contents = contents;
	}
	
}


class TwoBox<T1, T2> { 
	T1 o1;
	T2 o2;
	
	TwoBox(T1 o1, T2 o2) {
		this.o1 = o1;
		this.o2 = o2;
	}

}

//A 하위 클래스들만 제한
class ThreeBox<T extends Number> { //Integer, Double, Byte 등
	T num;
	ThreeBox(T num) {
		this.num = num;
	}
}

public class BoxTest {

	public static void main(String[] args) {
        //Number의 하위클래스 타입만 파라미터 전달
		ThreeBox<Integer> threebox = new ThreeBox(100);
		ThreeBox<Double> threebox2 = new ThreeBox(567.89);
		System.out.println(threebox.num.getClass().getName()); // java.lang.Integer
		System.out.println(threebox2.num.getClass().getName()); // java.lang.Double
		
		// 오류: Number의 하위클래스가 아니기 때문 
		// ThreeBox<String> threebox3 = new ThreeBox("100");
        
	}
}
```

