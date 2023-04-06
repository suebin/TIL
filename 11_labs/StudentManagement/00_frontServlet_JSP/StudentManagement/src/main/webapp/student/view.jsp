<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE>
<html>
<head>
    <title>학생 조회</title>
    <link rel="stylesheet" href="/style.css"/>
</head>
<body>
<table>
    <tbody>
    <tr>
        <td>아이디</td>
        <td class="value">${student.id}</td>
    </tr>

    <tr>
        <td>이름</td>
        <td class="value">${student.name}</td>
    </tr>

    <tr>
        <td>성별</td>
        <td class="value">${student.gender}</td>
    </tr>

    <tr>
        <td>나이</td>
        <td class="value">${student.age}</td>
    </tr>

    <tr>
        <td>등록일</td>
        <td class="value">${student.createdAt}</td>
        <%--        <td class="value"><fmt:formatDate value="${student.createdAt}" pattern="yyyy-MM-dd HH:mm:ss" /></td>--%>
    </tr>
    </tbody>
</table>

<span><a href="/student/list.do">리스트</a></span>
<span><a href="/student/update.do?id=${student.id}">수정</a></span>
<span>
<form method="POST" action="/student/delete.do">
    <input type="hidden" name="id" value="${student.id}"/>
    <button type="submit">삭제</button>
</form>
</span>
</body>
</html>
