<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="e.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외 처리가 필요한 JSP 페이지</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {

	});
</script>
</head>
<body>
<%-- num이 숫자가 아닐 때 exception이 발생할 것이다. --%>
<%
int num = Integer.parseInt(request.getParameter("num"));
%>
<h1>결과 = <%= num*num %></h1>
</body>
</html>