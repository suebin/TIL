<%@page import="java.util.HashMap"%>
<%@page import="dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>collection</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>

<%-- array --%>

<% String array[] = {"red", "black", "white", "green", "blue"}; 
pageContext.setAttribute("colors", array);
%>

${pageScope.colors[0]} = ${colors[0].toUpperCase()} <br>
${pageScope.colors[1]} = ${colors[1]} <br>
${pageScope.colors[2]} = ${colors[2]} <br>
${pageScope.colors[3]} = ${colors[3]} <br>
${pageScope.colors[4]} = ${colors[4]} <br>

${Integer.parseInt("100")}

<hr>

<%-- ArrayList --%>

<jsp:useBean id="memberlist" class="java.util.ArrayList" />


<%--  
// 위의 useBean 태그를 쓴 첫 문장은 아래 두 줄과 의미가 같다.

<% ArrayList memberlist = new ArrayList(); 
pageContext.setAttribute("memberlist", memberlist);
%>

또한. useBean에서는 MemberDTO의 기본생성자만 호출한다.
사용자가 정의한 생성자를 호출할 수 없다.

따라서 memberlist라는 ArrayList에 MemberDTO 객체를 생성해 데이터를 넣어준다.
물론 useBean 태그를 활용해 setProperty로 값을 하나씩 설정할 수도 있다.

 --%>
 
<jsp:useBean id="dto6" class="dto.MemberDTO" />
<jsp:setProperty property="id" name="dto6" value="mem6"/>

<%
memberlist.add(new MemberDTO("MEM1", 1, "회원1", "폰1", "이메일1", "2022-08-12"));
memberlist.add(new MemberDTO("MEM2", 2, "회원2", "폰2", "이메일2", "2022-08-12"));
memberlist.add(new MemberDTO("MEM3", 3, "회원3", "폰3", "이메일3", "2022-08-12"));
memberlist.add(new MemberDTO("MEM4", 4, "회원4", "폰4", "이메일4", "2022-08-12"));
memberlist.add(new MemberDTO("MEM5", 5, "회원5", "폰5", "이메일5", "2022-08-12"));
memberlist.add(dto6);
%>

${memberlist[0]} = ${memberlist.get(0)} <br>
${memberlist[1]} = ${memberlist.get(1)} <br>
${memberlist[2]} = ${memberlist.get(2)} <br>
${memberlist[3]} = ${memberlist.get(3)} <br>
${memberlist[4]} = ${memberlist.get(4)} <br>
${memberlist[5].id} = ${memberlist[5].name} <br>

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

${colormap["빨강"]} <br>
${empty colormap["빨강색"]?"해당 색 없음":colormap["빨강색"]} <br>
${colormap.colors} <br> <%-- key가 영문일때만 가능 --%>

</body>
</html>