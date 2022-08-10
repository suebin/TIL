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
<%
String menu [] = {"회원 관리", "게시판 관리", "쇼핑몰 관리", "챗봇 관리"};

// application 내장 객체에 데이터 바인딩
application.setAttribute("menu", menu);

// session 내장 객체에 데이터 바인딩
session.setAttribute("id", "user");
%>
<h1> 필요한 정보를 저장했습니다.</h1>
</body>
</html>