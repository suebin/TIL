# Inversion of Control(IoC) 이란 ?


#### = 제어의 역전

#### = Spring IoC Container가 필요에 따라 개발자 대신 Bean들을 관리(제어)해주는 행위

<br>

- DL(Dependency Lookup) : 의존성 검색
- DI(Dependency Injection) : 의존성 주입

![IoC](./image/IoC.png)


- **객체 관리의 주체**는 개발자가 아니라 **컨테이너**
- IoC Container는 객체 생성을 책임지고, 의존성을 관리
- POJO(Plain Old Java Object)의 생성, 초기화, 서비스, 소멸에 대한 권한 O
- 코드의 재사용성 가능 및 편리한 유지보수


---
# Dependency Injection(DI) 이란?

#### = 의존성 주입

- 각 객체간의 의존성을 **스프링 컨테이너(Spring Container)**가 자동으로 연결
- 개발자가 객체를 직접 생성하는 방식이 아니라 외부에서 생성하여 주입시켜주는 방식

<br>

#### 의존성 주입을 통해 얻는 장점
**IoC(Inversion of Control)** 의 하위 개념으로 객체 간의 결합을 약하게 해주고, 유지보수가 좋은 코드를 만든다.
개발자들이 객체를 생성하는 번거로움과 다양한 케이스를 고려하는 경우를 줄이고, 변수 사용과 개발에 더욱 집중할 수 있게 해준다.

<br>

- Dependency Reduction : 객체 상호 간 의존성 관계를 줄여준다.
- Reusable Structure : 코드의 재사용과 조합이 용이하다.
- Readability : 코드들이 분리되다보니 가독성이 좋아진다.
- Loose Coupling & Easy to change : 구조는 변화에 민감하지 않을 수 있다.
- Loosely Coupled : 각 클래스들의 변경이 자유롭다. (약한 결합)
- 테스트가 용이하고 다양한 패턴을 적용하는 것에 유연하다.

---

> 의존성 주입(DI)의 두 가지 방법을 공부할 것이다.
> 
> 바로 **setter**를 이용한 DI 기능과 **생성자(Constructor)**를 이용한 DI 기능이다.
>
> 의존성 주입(DI)은 `xml` 또는 `annotation`을 이용한다.
>
> 먼저 `Spring Bean Configuration File`인 xml 파일로 DI를 해보자.

<br>

## 1. Setter Injectioin (setter를 이용한 DI 기능)

```xml
<bean id="" class="" />
    <property name="" value="" or ref=""/>
</bean>
```

<br>

## 2. Constructor Injection (생성자를 이용한 DI 기능)

```xml
<bean id="" class="" />
    <constructor-arg name="" value="" or ref=""/>
</bean>
```

---

## <bean> 태그에 사용되는 여러 가지 속성들
- `id` : bean 객체의 고유 이름으로, bean id를 이용해 bean에 접근한다.
- `name` : 객체의 별칭이다.
- `class` : 생성할 클래스이다. 패키지 이름까지 입력해야 한다.
- `constructor-arg` : 생성자를 이용해 값을 주입할 때 사용한다.
- `property` : setter를 이용해 값을 주입할 때 사용한다.

