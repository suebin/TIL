<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update success</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
<h1> <%=request.getParameter("id")%> 님, 정보 수정을 성공적으로 완료했습니다!</h1>
<%
MemberDTO return_dto = (MemberDTO)request.getAttribute("return_dto");
%>


</body>
</html>