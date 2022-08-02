# 함수 (Function)


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
- 대표적인 callback function이다.
- 배열의 요소를 순차적으로 검색하여 그 값을 함수의 인수로 넘기기를 반복한다.
```jsx
var a = [5,4,3];
a.forEach(function(val) { console.log(val); });
```
- 이터레이션 (iteration) : 반복 처리, 데이터 안의 요소를 연속적으로 꺼내는 행위이다.


