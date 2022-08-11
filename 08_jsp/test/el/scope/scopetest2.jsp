<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scope</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>

<%-- 선언문 --%>

<%= pageContext.getAttribute("a") %> <br>
<%= request.getAttribute("a") %> <br>
<%= session.getAttribute("a") %> <br>
<%= application.getAttribute("a") %> 

<hr>


<%-- scope 내장 객체 (pageScope > requestScope > sessionScope > applicationScope 순으로 찾는다.) --%>

현재 페이지에서 전달 = ${a} <br>
이동 전의 페이지에서 전달 = ${requestScope.a} <br>
session에서 전달 = ${sessionScope.a} <br>
application에서 전달 = ${applicationScope.a} <br>

</body>
</html>