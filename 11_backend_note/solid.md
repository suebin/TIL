# SOLID : 객체 지향 설계

컴퓨터 프로그래밍에서 **SOLID**란 로버트 마틴이 2000년대 초반에 명명한 객체 지향 프로그래밍 및 설계의 다섯 가지 기본 원칙을 마이클 페더스가 두문자어 기억술로 소개한 것이다. 프로그래머가 **시간이 지나도 유지 보수와 확장이 쉬운 시스템**을 만들고자 할 때 이 원칙들을 함께 적용할 수 있다. SOLID 원칙들은 소프트웨어 작업에서 프로그래머가 소스 코드가 읽기 쉽고 확장하기 쉽게 될 때까지 소프트웨어 소스 코드를 리팩터링하여 코드 냄새를 제거하기 위해 적용할 수 있는 지침이다. 이 원칙들은 애자일 소프트웨어 개발과 적응적 소프트웨어 개발의 전반적 전략의 일부이다.

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

## 🌟 Single Responsibility Principle, SRP

- 단일 책임 원칙
- 한 클래스는 하나의 책임만 가져야 한다.
- 책임은 “캡슐화” 한다.
- 응집도 (Cohesion)를 높이고 결합도 (Coupling)를 낮춘다.
- 가독성이 향상되고, 유지보수가 용이해진다.
- 다른 원칙들을 적용하는 기초가 된다.

<br>

### Extract Class

Extract Class는 마틴 파울러의 책 <Refactoring: Improving the Design of Existing Code>2에서 소개된 클래스를 분리하는 **객체지향 리팩토링**의 한 방법이다. 두 개의 클래스가 해야 할 일을 하나의 클래스가 하고 있는 경우, 새로운 클래스를 만들어서 예전 클래스에서 새로운 클래스로 옮긴다. 객체지향 설계에서 클래스는 분명히 추상화되어야 하고, 명확한 책임을 가져야 한다.

- **Move Method**
    - 메소드가 자신이 정의된 클래스보다 다른 클래스의 기능을 더 많이 사용하고 있다면, 이 메소드를 가장 많이 사용하고 있는 클래스에 비슷한 몸체를 가진 새로운 메소드를 만들고, 이전 메소드는 간단한 위임으로 바꾸거나 완전히 삭제한다.
- **Move Field**
    - 필드가 자신이 정의된 클래스보다 다른 클래스에 의해 더 많이 사용되고 있다면, 타겟 클래스에 새로운 필드를 만들고 기존 필드를 사용하는 모든 부분을 변경한다.

<br>

---

## Move Method를 사용한 간단한 Refectoring 예제

아래 BankAccount 클래스는 세 개의 책임을 가지고 있다.

1. 계좌 번호를 생성한다.
2. 계좌에서 돈을 입금하고 출금한다.
3. 계좌 정보를 출력한다.

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

<br>

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

---

### Reference
https://ko.wikipedia.org/wiki/SOLID_(객체_지향_설계)