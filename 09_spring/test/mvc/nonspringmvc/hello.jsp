<%@page import="nonspringmvc.HelloDTO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello</title>
</head>
<body>

<% HelloDTO dto = (HelloDTO)request.getAttribute("model");  %>
<h1>Controller로부터 전달받은 model 데이터</h1>
<h3><%= dto.getMessage() %></h3>
</body>
</html>