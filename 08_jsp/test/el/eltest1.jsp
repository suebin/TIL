<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현 언어의 자료형과 연산자</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>


<%-- 표현 언어의 자료형 --%>

<%-- 1. 불 : true, false --%>
${true} <br> 

<%-- 2. 정수 : 0~9, 음수는 마이너스(-)가 붙는다. --%> 
${100} <br>

<%-- 3. 실수 : 소수점(.) 사용 가능, 1.4e5와 같이 지수형 표현 가능 --%>
${100.99} <br>

<%-- 4. 문자열 : 따옴표('', "") --%>
${'백백백'} <br>
${"백백백" } <br>

<%-- 5. null : 브라우저에서 공백으로 출력, null은 산술 연산 시 결과 = 0 --%>
${null}


<%-- 표현 언어의 연산자 -->

<%-- 1. 산술 연산자 (+,-,*,/,%), 10/3의 결과는 정수가 아닌 실수로 나온다. --%>
${100 + 100} <br> 
${'100' + 100} <br>
${10/3} <br> 
${10%3} <br>

<%-- 1-2. 문자열 결합 연산자 (+=) --%>
${'백'+= 1}<br> 

<%-- 2. 비교 연산자 (==, !=, <, >, <=, >=) --%>

<%-- 3. 논리 연산자 (&&, ||, !(not))--%>

<%-- 4. empty 연산자 : empty 뒤의 값이 null이거나 빈 문자열이면 true를 반환한다. --%>
\${empty 1}의 결과는 = ${empty 1} <br>

<%-- 5. 조건 연산자 (수식?값1:값2) --%>
${empty null?"널입니다":"널 아닙니다"} <br>

</body>
</html>