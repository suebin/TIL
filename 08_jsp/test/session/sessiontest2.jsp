<!-- session="true"는 기본값이어서 안 써도 true ! -->

<%@page import="dto.MemberDTO"%>
<%@ page contentType="text/html; charset=UTF-8" session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session 내장 객체에 데이터 바인딩</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {

	});
</script>
</head>
<body>
	<% 
	MemberDTO member = null;
	if (session.getAttribute("member") != null) {
		member = (MemberDTO)session.getAttribute("member");
	}
	%>

<% if (member != null) { %>	
	<h1><%= "세션 정보를 조회합니다." %></h1>
	<table border=3>
	<tr>
		<td>아이디</td>
		<td><%= member.getId() %></td>
	</tr>
	
	<tr>
		<td>이름</td>
		<td><%= member.getName() %></td>
	</tr>
	
	<tr>
		<td>폰</td>
		<td><%= member.getPhone() %></td>
	</tr>
	
	<tr>
		<td>이메일</td>
		<td><%= member.getEmail() %></td>
	</tr>
	
	<tr>
		<td>가입일</td>
		<td><%= member.getRegdate() %></td>
	</tr>
	</table>
<% } else { %>
	<h1><%= "조회할 정보가 없습니다." %></h1>
<% } %>	
</body>
</html>