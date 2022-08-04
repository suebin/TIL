# 자바스크립트와 jQuery 라이브러리 응용

<br>

:milky_way: **책 범위**
- chapter 12 (HTML5 웹 프로그래밍 입문)

---

## 프레임 애니메이션

#### 타이머 함수

```jsx
// 특정한 시간마다 함수 실행
setInterval(함수, 시간)

// 특정한 시간 후에 함수 실행
setTimeout(함수, 시간)

// setInterval() 함수로 설정한 타이머 제거
clearInterval(식별번호)

// setTimeout() 함수로 설정한 타이머 제거
clearTimeout(식별번호)
```

<br>

:milky_way: **예제**
- [프레임 애니메이션 (달리기)](./test/frame_animation)

---

## 문서 객체 생성과 추가

#### 기타 jQuery 문서 객체 추가 메서드

```jsx
// 객체를 대상의 뒷부분에 추가
$(객체).append(대상)

// 객체를 대상의 앞부분에 추가
$(객체).prepend(대상)

// 객체를 대상의 앞쪽에 추가
$(객체).before(대상)

// 객체를 대상의 뒤쪽에 추가
$(객체).after(대상)
```

<br>

:milky_way: **예제**
- [문서 객체 생성과 추가 (+삭제)](./test/event4.html)


---

## 무한 스크롤
:milky_way: **예제**
- [무한 스크롤](./test/infinityScroll.html)