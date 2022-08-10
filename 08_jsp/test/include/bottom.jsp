<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bottom</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {

	});
</script>
</head>
<body>
<h4> phone : 010-1234-5678</h4>
<h4> location : 대한민국 </h4>

<% if(request.getParameter("id") != null) { %>
<%= request.getParameter("id") %> 회원님 xx에 관심 있으신가요?<br>
<%= request.getParameter("file") %> 에서 포함되었습니다.
<% } %>


</body>
</html>