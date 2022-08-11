<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scope</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>

<%

pageContext.setAttribute("a", "pagecontext 공유"); // 현재 JSP 파일
request.setAttribute("a", "request 공유"); // 다른
session.setAttribute("a", "session 공유"); // 다른
application.setAttribute("a", "application 공유"); // 다른

%>

<jsp:forward page="scopetest2.jsp" />

</body>
</html>