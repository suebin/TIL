## application 내장 객체에 데이터 바인딩

#### session과 application의 스코프 차이
- 같은 브라우저에서 application2.jsp를 실행
![application2](./image/application2.PNG)

- 브라우저 종료 후, 혹은 다른 브라우저에서 application2.jsp를 실행
![application2](./image/application2-2.PNG)
- 아이디와 같이 나만 봐야 하는 정보는 session 내장 객체를 사용
- 메뉴와 같이 누구나 봐도 되는 정보는 application 내장 객체를 사용
