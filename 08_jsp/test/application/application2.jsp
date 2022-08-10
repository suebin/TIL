<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 내장 객체에 데이터 바인딩</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {

	});
</script>
</head>
<body>
<h1>필요한 정보를 조회합니다.</h1>
전체 파일에서 사용할 메뉴는
<% 
String[] menu = (String[])application.getAttribute("menu"); 
for (int i = 0; i < menu.length; i++) {
	//out.println(menu[i]+" "); : 이렇게 출력해도 되고, 아래처럼 표현식을 이용해 출력해도 된다.
%>
	<%= menu[i]+" "%>
<%
}
%>
입니다.

현재 로그인한 사용자는 <%= session.getAttribute("id") %>입니다.
</body>
</html>