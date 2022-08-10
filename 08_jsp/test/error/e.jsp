<%-- isErrorPage="true"여야만 exception 내장 객체를 사용할 수 있다. --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외 처리 담당 JSP</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {

	});
</script>
</head>
<body>
<% 
// 다른 파일(a.jsp, b.jsp) 오류가 발생했을 때 " 자동 " 으로 e.jsp로 이동해서 실행한다.

%>


<!-- 예외 정보를 알려준다. -->
<H1>오류 처리 파일명</H1>
<%= request.getRequestURI() %>

<H1>toString 내용</H1>
<%= exception.toString() %>

<H1>getMessage 내용</H1>
<%= exception.getMessage() %>

<H1>printStackTrace (서버 콘솔)</H1>
<% exception.printStackTrace(); %>
</body>
</html>