# SOLID (객체 지향 설계)

컴퓨터 프로그래밍에서 **SOLID**란 로버트 마틴 (Robert C. Martin)이 2000년대 초반에 명명한 객체 지향 프로그래밍 및 설계의 다섯 가지 기본 원칙을 마이클 페더스 (Michael C. Feathers)가 두문자어 기억술로 소개한 것이다. 프로그래머가 **시간이 지나도 유지 보수와 확장이 쉬운 시스템**을 만들고자 할 때 이 원칙들을 함께 적용할 수 있다. SOLID 원칙들은 소프트웨어 작업에서 프로그래머가 소스 코드가 읽기 쉽고 확장하기 쉽게 될 때까지 소프트웨어 소스 코드를 리팩터링하여 코드 냄새를 제거하기 위해 적용할 수 있는 지침이다. 이 원칙들은 애자일 소프트웨어 개발과 적응적 소프트웨어 개발의 전반적 전략의 일부이다.

- **단일 책임 원칙 (Single responsibility principle, SRP)**
    - 한 클래스는 하나의 책임만 가져야 한다.
- **개방-폐쇄 원칙 (Open/closed principle)**
    - 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다.
- **리스코프 치환 원칙 (Liskov substitution principle, LSP)**
    - 프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다. 계약에 의한 설계를 참고하라.
- **인터페이스 분리 원칙 (Interface segregation principle, ISP)**
    - 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다.
    - 인터페이스를 구체적이고 작은 단위로 분리하여 꼭 필요한 인터페이스만 상속해야 한다.
- **의존관계 역전 원칙 (Dependency inversion principle, DIP)**
    - 프로그래머는 추상화에 의존해야지, 구체화에 의존하면 안된다. 의존성 주입은 이 원칙을 따르는 방법 중 하나이다.
    - 상위 모듈은 하위 모듈에 의존하면 안된다.

<br>

---

# Single Responsibility Principle, SRP

- **단일 책임 원칙**
- “There should never be more than one reason for a class to change.”
- 한 클래스는 **하나의 책임** (axis of change)만 가져야 한다.
    - 어떤 변화에 의해 클래스를 변경해야 하는 이유는 오직 하나 뿐 이어야 한다.
- 책임은 **“캡슐화”** 한다.
- 응집도 (Cohesion)를 높이고 결합도 (Coupling)를 낮춘다.
- 가독성이 향상되고, 유지보수가 용이해진다.
- 다른 원칙들을 적용하는 기초가 된다.

### Extract Class

Extract Class는 마틴 파울러의 책 <Refactoring: Improving the Design of Existing Code>2에서 소개된 클래스를 분리하는 **객체지향 리팩토링**의 한 방법이다. 이 책에서 소개하는 대부분의 위험상황에 대한 해결방법은 직/간접적으로 SRP 원리와 관련이 있다. 항상 코드를 최상으로 유지한다는 리팩토링의 근본정신도 항상 객체들의 책임을 최상의 상태로 분배한다는 것에서 비롯되기 때문이다. Extract Class는 두 개의 클래스가 해야 할 일을 하나의 클래스가 하고 있는 경우, 새로운 클래스를 만들어서 예전 클래스에서 새로운 클래스로 옮기는 것을 의미한다. 객체지향 설계에서 클래스는 분명히 추상화되어야 하고, 명확한 책임을 가져야 한다.

- **Move Method**
    - 메소드가 자신이 정의된 클래스보다 다른 클래스의 기능을 더 많이 사용하고 있다면, 이 메소드를 가장 많이 사용하고 있는 클래스에 비슷한 몸체를 가진 새로운 메소드를 만들고, 이전 메소드는 간단한 위임으로 바꾸거나 완전히 삭제한다.
- **Move Field**
    - 필드가 자신이 정의된 클래스보다 다른 클래스에 의해 더 많이 사용되고 있다면, 타겟 클래스에 새로운 필드를 만들고 기존 필드를 사용하는 모든 부분을 변경한다.

<br>

---

## Move Method를 사용한 리팩토링 예제

아래 BankAccount 클래스는 세 개의 책임을 가지고 있다.

1. 계좌 번호를 생성한다.
2. 계좌에서 돈을 입금하고 출금한다.
3. 계좌 정보를 출력한다.

<br>

- BankAccount.java

```java
import java.math.BigDecimal;

public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private BigDecimal balance;

    private static String nextAccountNumber = "0";

    public BankAccount(String ownerName, BigDecimal balance) {
        this.accountNumber = createAccountNumber();
        this.ownerName = ownerName;
        this.balance = balance;
    }

    private static String createAccountNumber() {
        int accountNumber = Integer.parseInt(nextAccountNumber);
        nextAccountNumber = Integer.toString(++accountNumber);
        return nextAccountNumber;
    }

    public BigDecimal deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
        return this.balance;
    }

    public boolean withDraw(BigDecimal amount) {
        if (amount.compareTo(this.balance) == 1 || amount.compareTo(this.balance) == 0) {
            return false;
        } else {
            balance = balance.subtract(amount);
            return true;
        }
    }

    public void printAccount() {
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Owner Name: " + this.ownerName);
        System.out.println("Balance: " + this.balance.toString());
    }
}
```

이제 BankAccount 클래스에 SRP 원칙을 적용해 리팩토링을 해본다.

1번 책임은 CreateAccount 클래스로, 3번 책임은 PrintAccount 클래스로 분리한다.

<br>

- CreateAccount.java

```java
public class CreateAccount {
    private static String nextAccountNumber = "0";

    public static String createAccountNumber() {
        int accountNumber = Integer.parseInt(nextAccountNumber);
        nextAccountNumber = Integer.toString(++accountNumber);
        return "0000-" + nextAccountNumber;
    }
}
```

- PrintAccount.java

```java
public class PrintAccount {
    public static void printAccount(BankAccount account) {
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Owner Name: " + account.getOwnerName());
        System.out.println("Balance: " + account.getBalance().toString());
    }
}
```

- BankAccount.java

```java
import java.math.BigDecimal;

public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private BigDecimal balance;

    public BankAccount(String ownerName, BigDecimal balance) {
        this.accountNumber = CreateAccount.createAccountNumber();
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public BigDecimal deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
        return this.balance;
    }

    public boolean withDraw(BigDecimal amount) {
        if (amount.compareTo(this.balance) == 1 || amount.compareTo(this.balance) == 0) {
            return false;
        } else {
            balance = balance.subtract(amount);
            return true;
        }
    }
}
```

<br>

해당 예제는 완벽한 리팩토링을 구현한 것은 아니고, SRP에 대한 이해를 돕기 위한 간단한 예제이다.

<br>

---

# Open Closed Principle, OCP

- **개방 폐쇄의 원칙**
- “You should be able to extend a classes behavior, without modifying it.”
- 소프트웨어는 확장에는 열려 있어야 하고, 변경에는 닫혀 있어야 한다.
    - 요구사항의 변경이나 추가사항이 발생하더라도 기존 구성요소에는 수정이 일어나지 않아야 한다.
    - 쉽게 확장이 가능하여 재사용이 가능하도록 구성되어야 한다.
    - **변하는 것은 숨기고 변하지 않는 것에 의존**한다.
    - 변하는 것과 변하지 않는 것을 엄격히 구분한다.
- 관리와 재사용이 가능한 코드를 만드는 기반이 된다.
- **“추상화”**는 OCP 의 핵심요소이다.

개방 폐쇄의 원칙은 버틀란트 메이어 (Bertrand Meyer)가 1998년 책 <Object-Oriented Software Construction>3에서 정의한 개념이다. 소프트웨어 구성요소 (컴포넌트, 클래스, 모듈, 함수)는 확장에는 열려있고, 변경에는 닫혀있어야 한다는 원리이다. 즉, 변경을 위한 비용은 가능한 줄이고, 확장을 위한 비용은 가능한 극대화 해야 한다는 것이다. 버틀란트 메이어는 이 원칙을 적용하기 위해 상속을 사용해야 한다고 했다. 하지만 상속은 서브 클래스가 구현에 의존하는 경우 슈퍼 클래스의 세부 정보와 긴밀히 결합한다. 따라서, SOLID 원칙을 정리한 로버트 마틴 (Robert C. Martin)은 개방 폐쇄의 원칙을 **인터페이스**를 사용하여 행위 (behavior)를 정의하고, 정의된 코드를 쉽게 대체할 수 있는 다양한 구현을 허용하도록 하였다. 또한, OCP의 주요한 메커니즘은 추상화와 다형성이라고 하였다.

<br>
<br>

##### 💡 그래드 부치 (Grady Booch)가 말하는 추상화란 ?
- 다른 모든 종류의 객체로부터 식별될 수 있는 객체의 본질적인 특징이다.


<br>

---

# Liskov Substitution Principle, LSP

- 리스코프 치환 원칙
- “Functions that use pointers or references to base classes must be able to use objects of derived objects of derived classes without knowing it.”
- 서브 타입은 언제나 수퍼 타입을 대체할 수 있어야 한다.
- 계약에 의한 설계 (Design by Contract)와 유사성을 지닌다.
- OCP를 위반하지 않도록 하는 기반 원칙
- 행동적 하위형 (Behavioral Subtype)
    - 객체에 대한 대체 가능성 (Notion of substitutability for object)을 정의
- LSP를 위반하는 전형적인 예 : Circle-ellipse Problem

<br>

### Signature 요구사항

- 서브 타입에서 메소드 파라미터 타입은 반공변성 (Contravariance)
- 서브 타입에서 메소드 return 타입의 공변성 (Covariance)
- 서브 타입에서 메소드는 상위 클래스의 메소드에서 throw한 하위형을 제외하고 새로운 예외를 던질 수는 없다.

### Sub Type의 행동 조건

- 서브 타입에서 선행 조건 (pre-condition)은 강화될 수 없다.
- 서브 타입에서 후행 조건 (Post-condition)은 약화될 수 없다.
- 서브 타입에서 수퍼 타입의 불변형은 반드시 유지되어야 한다.
- 이력 제약 조건 (History constraint - History rule)
    - 객체는 그 자신의 메소드를 통해서만 수정 (캡슐화) 될 수 있는 것으로 간주된다. 따라서 변경 가능 지점 (mutable point)을 변경 불가 지점 (immutable point)의 서브 타입으로 만드는 방법이 있다.

<br>
<br>

##### 💡 공변성 (Covariance)과 반공변성 (Contravariance)
- 공변성 : 한 변수가 변하면 다른 변수도 변하는 성질
- 반공변성 : 그 반대의 성질


<br>

---

# Interface Segregation Principle, ISP

- 인터페이스 분리 원칙
- “Clients should not be foreced to depend upon interfaces that they do not use”
- 범용 인터페이스보다 특정 클라이언트를 위한 인터페이스 여러 개를 선언한다.
- 시스템 내부 의존성을 약화시켜 리팩토링, 수정, 재배포를 쉽게 할 수 있도록 한다.

<br>

인터페이스 분리 원칙은 자신이 사용하지 않는 인터페이스는 구현하지 말아야 한다는 원칙이다. 즉, 하나의 큰 인터페이스를 상속받기 보다는 인터페이스를 구체적이고 작은 단위들로 분리시켜 꼭 필요한 인터페이스만 상속하자는 의미이다. SRP는 클래스의 단일 책임을 강조한다면 ISP는 인터페이스의 단일 책임을 강조한다.

<br>

---

# Dependency Inversion Principle, DIP

- 의존 관계 역전 원칙
- “High level modules should not depend upon low level modules. Both should depend upon abstractions.”
- “Abstractions should not depend upon details. Details should depend upon abstractions.”
- 추상화에 의존해야 하고, 구체화에 의존하면 안된다.
    - 상위 모듈은 하위 모듈에 의존해서는 안된다.
- “상위와 하위 객체 모두 동일한 추상화에 의존해야 한다”는 객체지향 설계의 대원칙을 제공한다.

<br>

의존 관계 역전 원칙은 추상화에 의존하고, 세부 사항에 의존해서는 안된다는 원칙이다. 클래스 사이에 의존 관계는 당연히 존재하지만, 최대한 추상화된 클래스에 의존하라는 것이다. Java의 인터페이스와 같은 타입에 기반한 응용 프로그램을 작성하라는 의미이기도 하다. DIP의 키워드는 ‘IOS’, ‘훅 메소드’, ‘확장성’이다.

<br>

---

### Reference
https://ko.wikipedia.org/wiki/SOLID_(객체_지향_설계)
https://www.nextree.co.kr/p6960/