# 웹 브라우저의 객체 (BOM)

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
## 웹 브라우저의 객체 (Browser Object Model)

- 교재 13장

### Window 객체

브라우저 안의 모든 요소들이 소속된 객체이고, 어디서든 접근이 가능하므로 ‘전역 객체’라고 부른다.

브라우저 창을 제어하는 다양한 메서드를 제공한다.

### Navigator 객체

브라우저 공급자 및 버전 정보 등을 포함한 브라우저에 대한 다양한 정보를 저장한다.

### Location 객체

창에 표시되는 문서의 URL을 관리한다.  현재 브라우저에 표시된 HTML 문서의 주소를 얻거나 브라우저에 새 문서를 불러올 때 사용할 수 있다.

### History 객체

브라우저의 히스토리 정보를 문서와 문서 상태 목록으로 저장하는 객체이다. 

사용자의 개인 정보를 보호하기 위해 이 객체에 접근하는 방법을 일부 제한하고 있다.

<br>

:milky_way: **예제**
- [Window 객체](./test/window)
- [Navigator, History, Location 객체](./test/navigator_history_location.html)
- [Navigator 객체의 프로퍼티인 geolocation을 이용한 위치추적](./test/geolocation.html)
