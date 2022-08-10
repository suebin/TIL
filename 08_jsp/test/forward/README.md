## 포워드 액션 태그
- `start.jsp`에서 아이디 파라미터를 입력 받는다.
- 아이디가 admin이거나 administrator이면 관리자 페이지 `admin.jsp`로 이동하고, 그렇지 않으면 유저 페이지 `user.jsp`로 이동한다.

<br>

#### 유의사항
- `<jsp:param>`은 문자열이나 숫자 1개만 전송한다.
- 포워드 시 배열과 같은 객체를 전달하고 싶을 때에는 `request.setAttribute()`와 `request.getAttribute()`를 사용할 수 있다!
