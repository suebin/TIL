# 이벤트 처리

<br>

:milky_way: **책 범위**
- 교재 15장

<br>

---

## 이벤트 처리기를 등록하는 방법

1. HTML 요소의 이벤트 처리기 속성에 설정하는 방법

```html
<input type="button" onclick="changeColor();">
```

2. DOM 요소 객체의 이벤트 처리기 프로퍼티에 설정하는 방법

```jsx
var btn = document.getElementById("button");
btn.onclick = changeColor();
```

**위 두 가지 방법은 공통적인 단점이 있다.**

- 같은 태그에 대해 같은 이벤트가 발생하면 처리 함수는 1개만 가능
- 이벤트 처리를 등록했다가 다시 삭제하는 것이 불가능

**이 단점을 해소해주는 방법이 바로  “ 이벤트 리스너 “이다.**

3. addEventListener 메서드를 사용하는 방법

```jsx
var btn = document.getElementById("button");
btn.addEventListener("click", changeColorl, false);
```

---

## 이벤트 리스너의 등록과 삭제

- 같은 요소의 같은 이벤트에 이벤트 리스너를 여러 개 등록 가능
- 이벤트 등록했다가 삭제 가능

```jsx
// 이벤트 리스너 등록하기
(이벤트 리스너를 등록할 DOM 노드).addEventListener(type, listener, useCapture);

// 이벤트 리스너 삭제하기
(이벤트 리스너를 등록할 DOM 노드).removeEventListener(type, listener, useCapture);

// type : 이벤트 유형을 뜻하는 문자열("click", "mouseup" 등)
// listener : 이벤트가 발생했을 때 처리를 담당하는 콜백 함수의 참조
// useCapture : 이벤트 단계 (true(캡처링 단계), false(버블링 단계 : 기본값)) 
```
<br>

:milky_way: **예제**
- [이벤트 리스너의 등록과 삭제](./test/event1)

---

## 이벤트 객체

이벤트를 발생한 요소와 발생한 이벤트에 대한 정보를 제공하는 것을 말한다. DOM과 관련된 이벤트가 발생하면 관련 정보는 모두 event객체에 저장한다. 이벤트가 발생하면, 이벤트 객체는 동적으로 생성되어, 이벤트 핸들러에 인자로 암묵적으로 전달된다.

```jsx
// 보통 event의 약자인 e를 이벤트 객체로 사용
function changeColor(e) { 
...
}
```

아래는 이벤트가 가지고 있는 정보의 예시이다.

- 클릭 좌표 : `e.pageX`, `e.pageY`
- 클릭 태그명 : `e.target.tagName`
- 클릭 타입 : `e.target.속성명`

마우스 이벤트 객체 : `click`, `dbclick`, `mouseover`, `mouseout`

키보드 이벤트 객체 : `keydown`, `keypress`, `keyup`

폼 이벤트 객체 : `submit` 

포커스 이벤트 객체 : `focus`, `blur`

<br>

:milky_way: **예제**
- [키보드 이벤트 객체 keydown](./test/event2.html)

---

## 이벤트 전파 (Event Bubbling)

어떤 요소에서 발생한 이벤트는 부모 혹은 자식에게 전파하는데, 

전파되는 방향에 따라 버블링(bubbling), 캡쳐링(capturing)이라고 부른다.

<br>

- Bubbling
    - 이벤트가 발생한 요소부터 조상들에게 순차적으로 이벤트가 전파되는 방식
- Capturing
    - 이벤트가 발생한 요소부터 자식들에게 순차적으로 이벤트가 전파되는 방식
    
<br>

**이벤트 단계는 다음과 같다.**

1. 캡처링 단계
2. 타깃 단계
3. 버블링 단계

<br>

**자식 요소에서 발생한 이벤트는 부모 요소에도 전파된다.**

**이로 인해 의도하지 않은 동작이 발생하는 것을 방지하기 위해 아래와 같은 메서드를 사용한다.**

1. 이벤트 전파 취소하기

```jsx
e.stopPropagation();
```

2. 이벤트 전파의 일시정지

```jsx
e.stopImmediatePropagation();
```

3. 기본 동작 취소하기

```jsx
e.preventDefault();
```

<br>

:milky_way: **예제**
- [이벤트 전파](./test/event3.html)
- [폼 이벤트 객체 submit과 이벤트 전파](./test/event4.html)