<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login form</title>
<script src="resources/js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
	$("h3").css("color", "orange");
});
</script>
</head>
<body>
<h3>로그인</h3>

<!-- 
html 태그 속성 url : "/" 시작하면 http://localhost:8080 생략
jsp나 servlet, xml 파일들 url : "/" 시작하면 http://localhost:8080/컨텍스트명 생략

post방식을 사용하려고 한다면
서블릿, jsp, springmvc는 한글 인코딩이 필요하다. 
따라서 web.xml에서 설정한다.
-->

<!-- <form action="loginresult" method="post"> -->
	<form action="login" method="post">
	아이디 : <input type="text" name="id" ><br>
	비밀번호 : <input type="password" name="password"><br> 
	<input type="submit" value="로그인">
</form>
</body>
</html>