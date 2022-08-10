<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 파라미터 입력</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {

	});
</script>
</head>
<body>
<%
String id = request.getParameter("id");
String file = "";

String [] menu = null;

if (id != null) {
	if (id.equalsIgnoreCase("admin") || id.equalsIgnoreCase("administrator")) {
		out.println("<h1>관리자로 로그인 하셨습니다.</h1>"); // "포워드"를 하면 출력 문장 보이지 않고, 바로 다른 페이지로 넘어간다.
		file = "admin.jsp";
		menu = new String[2];
		menu[0] = "모든 사용자 정보 조회";
		menu[1] = "상품 관리";
	}
	else {
		out.println("<h1>일반 사용자로 로그인 하셨습니다.</h1>");
		file = "user.jsp";
		menu = new String[3];
		menu[0] = "내 정보 조회";
		menu[1] = "로그아웃";
		menu[2] = "글 쓰러 가기";
	} 
	
	// <jsp:param>은 문자열 1개 혹은 숫자 1개만 전송할 수 있다.
	// request.setAttribute()에는 객체 저장이 가능하다. 
	// menu 배열은 <jsp:param>으로 전송할 수 없고, 포워드이기 때문에 request.setAttribute()를 사용해서 전송한다.
	request.setAttribute("menu", menu);
	
	%>
	
	<jsp:forward page="<%= file %>" />
<%
}
else {
	out.println("<h1>아이디를 입력해주세요.</h1>");
}
%>

<!-- 포워드를 하면 바로 다른 페이지로 넘어가기 때문에 admin.jsp, user.jsp에서 "끝났습니다"는 보여지지 않는다. -->
<h1>끝났습니다.</h1> 
</body>
</html>