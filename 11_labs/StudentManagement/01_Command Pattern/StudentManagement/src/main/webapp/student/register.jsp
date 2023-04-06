<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html>
<head>
    <title>학생 등록</title>
    <link rel="stylesheet" href="/style.css"/>
</head>
<body>
<h1>학생 등록</h1>

<form method="POST" action="/student/register.do">
    <table>
        <tr>
            <td>ID</td>
            <td class="value"><input type="text" name="id" required/></td>
        </tr>
        <tr>
            <td>이름</td>
            <td class="value"><input type="text" name="name" required/></td>
        </tr>
        <tr>
            <td>성별</td>
            <td class="value">
                <input type="radio" name="gender" value="male" id="male"/><label for="male">남</label>
                <input type="radio" name="gender" value="female" id="female"/><label for="female">여</label>
            </td>
        </tr>
        <tr>
            <td>나이</td>
            <td class="value"><input type="text" name="age" required/></td>
        </tr>
    </table>
    <p>
        <button type="submit">등록</button>
    </p>
</form>
</body>
</html>
