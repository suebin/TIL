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
<%-- index가 4 이상이면 exception이 발생할 것이다. --%>
<%
String [] menu = {"회원 관리", "게시판 관리", "쇼핑몰 관리", "챗봇 관리"};
int index = Integer.parseInt(request.getParameter("index"));
%>
<h1>메뉴 이름 = <%= menu[index] %></h1>
</body>
</html>