<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Core tag : forEach (eltest5.jsp를 반복문으로!)</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>

<%-- array --%>

<% String array[] = {"red", "black", "white", "green", "blue"}; %>

<c:set var="colors" value="<%= array %>" />

<c:forEach items="${colors}" var="onecolor" varStatus="vs">
	<h1>${vs.count} 번째 색상 = ${onecolor}</h1> <%-- vs.index : index 번호를 보여준다. --%>
</c:forEach>


<c:forEach items="${colors}" var="onecolor" varStatus="vs">
	<c:if test="${vs.first}"> <%-- vs.first : 첫번째 값이면 true, 아니면 false를 반환 --%>
		<h1>첫번째 색상 = ${onecolor}</h1>
	</c:if>
</c:forEach>


<c:forEach items="${colors}" var="onecolor" varStatus="vs">
	<c:if test="${vs.last}"> <%-- vs.last : 마지막 값이면 true, 아니면 false를 반환 --%>
		<h1>마지막 색상 = ${onecolor}</h1>
	</c:if>
</c:forEach>


<c:forEach items="${colors}" varStatus="vs"> 
	<h1>${vs.count} 번째 색상 = ${vs.current}</h1> <%-- vs.current : 현재 반복중인 데이터 값 --%>
</c:forEach>


<c:forEach begin="1" end="10" step="1" var="num"> 
	<h1>${num*num}</h1>
</c:forEach>


<hr>

<%-- ArrayList --%>

<jsp:useBean id="memberlist" class="java.util.ArrayList" />
<jsp:useBean id="dto6" class="dto.MemberDTO" />
<jsp:setProperty property="id" name="dto6" value="MEM6"/>

<%
memberlist.add(new MemberDTO ("MEM1", 1, "회원1", "폰1", "이메일1", "2022-08-12"));
memberlist.add(new MemberDTO("MEM2", 2, "회원2", "폰2", "이메일2", "2022-08-12"));
memberlist.add(new MemberDTO("MEM3", 3, "회원3", "폰3", "이메일3", "2022-08-12"));
memberlist.add(new MemberDTO("MEM4", 4, "회원4", "폰4", "이메일4", "2022-08-12"));
memberlist.add(new MemberDTO("MEM5", 5, "회원5", "폰5", "이메일5", "2022-08-12"));
memberlist.add(dto6);
%>

<table border=3>
<c:forEach items="${memberlist}" var="dto" varStatus="vs">
	<tr><td> ${dto.id} 회원님 </td><td> 이름은 ${dto.name}입니다. </td></tr>
</c:forEach>
</table>

<hr>

<%-- HashMap --%>
 
<%
HashMap<String, String> map = new HashMap();
map.put("빨강", "red");
map.put("주황", "orange");
map.put("노랑", "yellow");
map.put("초록", "green");
map.put("파랑", "blue");
map.put("남색", "navy");
map.put("빨강", "purple"); // 수정
map.put("colors", "black");
pageContext.setAttribute("colormap", map);
%>

<c:forEach items="${colormap}" var="onecolor" varStatus="s">
	<h1> ${s.count} 번 한국어 색상명 ${s.current.key} 의 영문 색상명은 ${onecolor.value} 입니다.</h1> <%-- 맵은 순서가 랜덤하게 나온다. / ${onecolor}는 key,value 모두 나온다. --%>
</c:forEach>



<%
HashMap<String, MemberDTO> dtoMap = new HashMap<String, MemberDTO>();
dtoMap.put("mem1", new MemberDTO ("MEM1", 1, "회원1", "폰1", "이메일1", "2022-08-12"));
dtoMap.put("mem2", new MemberDTO("MEM2", 2, "회원2", "폰2", "이메일2", "2022-08-12"));
dtoMap.put("mem3", new MemberDTO("MEM3", 3, "회원3", "폰3", "이메일3", "2022-08-12"));
dtoMap.put("mem4", new MemberDTO("MEM4", 4, "회원4", "폰4", "이메일4", "2022-08-12"));
dtoMap.put("mem5", new MemberDTO("MEM5", 5, "회원5", "폰5", "이메일5", "2022-08-12"));
%>

<c:set var="dtoMap" value="<%= dtoMap %>" />
<c:forEach items="${dtoMap}" varStatus="st">
	<h1>${st.current.key} - ${st.current.value.name}</h1>
</c:forEach>


-----------------------------------------------------------------------------------------------

<c:url var="mypage" value="http://localhost:8080/jsp/jstl/loginage.jsp" />

<%-- <jsp:include> 와 유사 --%>
<c:import url="${mypage}">
	<c:param name="name" value="수빈" />
	<c:param name="age" value="20" />
</c:import>

<%-- <jsp:forward> 와 유사 --%>
<c:redirect url="${mypage}">
	<c:param name="name" value="수빈" />
	<c:param name="age" value="20" />
</c:redirect>

</body>
</html>