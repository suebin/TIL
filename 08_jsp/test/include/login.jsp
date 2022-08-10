<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {

	});
</script>
</head>
<body>
<%
String id = request.getParameter("id");
%>
<h1><%= id %> 회원님 로그인 하셨습니다.</h1>
<h1>정보 조회 가능합니다.</h1>

<jsp:include page="bottom.jsp"> 
	<jsp:param name="file" value="login.jsp" /> <!-- include나 forward 액션 태그의 " 자식 태그 "  -->
</jsp:include>

</body>
</html>