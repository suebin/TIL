<%@page import="dto.MemberDTO"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update process</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>

<jsp:useBean id="member" class="dto.MemberDTO" scope="request"/>

<jsp:setProperty property="id" name="member" />
<jsp:setProperty property="password" name="member" />
<jsp:setProperty property="name" name="member" />
<jsp:setProperty property="phone" name="member" param="phonenumber" />
<jsp:setProperty property="email" name="member"  />
<jsp:setProperty property="regdate" name="member" />

<jsp:useBean id="dao" class="dao.MemberDAO" />

<%
MemberDTO return_dto = dao.updateMember(member);
request.setAttribute("return_dto", return_dto);
%>

<jsp:forward page="updatesuccess.jsp"  />

</body>
</html>