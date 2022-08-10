<%@page import="dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모든 사용자 정보 조회</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {

	});
</script>
</head>
<body>
<%
MemberDAO dao = new MemberDAO();
ArrayList<MemberDTO> memberlist = dao.selectAllMember();
%>

<table border="2">
	<tr>
		<td>아이디</td>
		<td>이름</td>
		<td>폰</td>
		<td>이메일</td>
		<td>가입날짜</td>

<%
for (int i = 0; i < memberlist.size(); i++) {
	MemberDTO dto = memberlist.get(i);
%>		
	<tr>
		<td><%=dto.getId()%></td>
		<td><%=dto.getName()%></td>
		<td><%=dto.getPhone()%></td>
		<td><%=dto.getEmail()%></td>
		<td><%=dto.getRegdate()%></td>
	</tr>
<%
}
%>
</table>
</body>
</html>