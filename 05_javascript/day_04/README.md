# 함수와 웹 브라우저의 객체


<br>

:milky_way: **지난 시간 예제**
- [이벤트 처리와 DOM 구조를 이용한 예제](./test/boardlist_object.html)

<br>

---

# 함수

- 교재 8장 (255p ~ 264p)

- 모든 함수는 변수처럼 취급이 가능하다. (= 함수를 일급 객체로 취급한다.)


## 함수의 정의

1. 함수 선언문

```jsx
function square(X) {return x*x; }
```

2. 함수 리터럴

```jsx
var square = function(x) {return x*x; };
```

3. Function 생성자

4. 화살표 함수 표현식 (ECMAScript 6)

```jsx
var square = x => x*x;
```

<br>

## 콜백 함수 (Callback Function)

- 교재 315p ~ 316p
- 파라미터(매개변수)로 함수를 전달받아, 함수의 내부에서 실행하는 함수이다.
- 이벤트 처리 시 자주 사용한다.
- jQuery에서도 볼 수 있다.

```jsx
function f1 (a) {}
function f2 () {}
f1(f2);

// 콜백 함수 예제 (타이머)
setInterval(function(){}, 1000);
```
<br>

## 화살표 함수 (Arrow Function Expression)
- 교재 317p ~ 318p
- 전통적인 함수표현의 간편한 대안이다.

<br>

:milky_way: **예제**
- [함수 정의, 중첩함수, 함수의 매개변수, 화살표 함수](./test/function.html)

<br>

---

## 배열의 forEach 메서드
- 교재 321p
- 대표적인 callback function
- 배열의 요소를 순차적으로 검색하여 그 값을 함수의 인수로 넘기기를 반복한다.
```jsx
var a = [5,4,3];
a.forEach(function(val) { console.log(val); });
```
- 이터레이션 (iteration) : 반복 처리, 데이터 안의 요소를 연속적으로 꺼내는 행위이다.
---

## 객체 (Object)

- 교재 4장, 9장, (18장)

- 자바스크립트의 기본 타입(data type)은 객체이다.

- 객체는 이름(name)과 값(value)으로 구성된 프로퍼티(property)의 정렬되지 않은 집합이다. 

- 프로퍼티의 값으로 함수가 올 수도 있는데, 이를 메소드(method)라고 한다.

<br>

:milky_way: **예제**
- [객체를 생성하는 두가지 방법](./test/object_all.html)

<br>

---

# 웹 브라우저의 객체

- 교재 13장 (496p ~ 502p)

### Window 객체

브라우저 안의 모든 요소들이 소속된 객체이고, 어디서든 접근이 가능하므로 ‘전역 객체’라고 부른다.

브라우저 창을 제어하는 다양한 메서드를 제공한다.

### Navigator 객체

브라우저 공급자 및 버전 정보 등을 포함한 브라우저에 대한 다양한 정보를 저장한다.

### Location 객체

창에 표시되는 문서의 URL을 관리한다.  현재 브라우저에 표시된 HTML 문서의 주소를 얻거나 브라우저에 새 문서를 불러올 때 사용할 수 있다.

### History 객체

브라우저의 히스토리 정보를 문서와 문서 상태 목록으로 저장하는 객체이다. 사용자의 개인 정보를 보호하기 위해 이 객체에 접근하는 방법을 일부 제한하고 있다.

<br>

:milky_way: **예제**
- [Window 객체](./test/window)
- [Navigator, History, Location 객체](./test/navigator_history_location.html)
- [Navigator 객체의 프로퍼티인 geolocation을 이용한 위치추적](./test/geolocation.html)
