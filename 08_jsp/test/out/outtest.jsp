<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>out 내장 객체 이용해 데이터 출력하기</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {

	});
</script>
</head>
<body>
<h1>총 버퍼 크기 = <%= out.getBufferSize() %></h1> 
<h1>남은 버퍼 크기 = <%= out.getRemaining() %></h1>

<% 
String name =request.getParameter("name"); 
out.println(name);
out.flush(); // 이전에 모아둔 출력 내용을 클라이언트한테 전송하고, 버퍼를 비운다.
%>

<h1>남은 버퍼 크기 = <%= out.getRemaining() %></h1>

</body>
</html>