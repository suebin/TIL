<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저가 보는 페이지</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {

	});
</script>
</head>
<body>
<h1> user.jsp 파일입니다. </h1>
<h3> 유저용 메뉴 </h3>
<%
String [] menu = (String[])request.getAttribute("menu");
for (int i=0; i < menu.length; i++) {
	out.println("<h4>" + menu[i] + "</h4>");
}
%>
</body>
</html>