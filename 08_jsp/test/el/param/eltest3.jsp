<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>param</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>

<%-- 선언문 --%>

<% if(request.getParameter("id") != null) { %>
<%= request.getParameter("id")%> 회원님
<%= request.getParameter("pw")%> 암호를 입력하셨습니다.
오늘 점심 메뉴는
<%
String[] lunch = request.getParameterValues("lunch"); 
for (int i=0; i<lunch.length; i++) {
	out.println(lunch[i] + ", ");
}
%>
입니다.
<% } %>


<%-- param 내장 객체 --%>

${empty param.id ? "아이디가 없는" : param.id} 회원님
${param.pw} 암호를 입력하셨습니다.
오늘 점심 메뉴는
${paramValues.lunch[0]}
${paramValues.lunch[1]}
${paramValues.lunch[2]}
${paramValues.lunch[3]}
${paramValues.lunch[4]}
입니다.

</body>
</html>