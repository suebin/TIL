<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
	$('form').on('submit', function(){
		if($("input:text").val() == 'adm' ||
		$("input:text").val() == 'administration' ||
		$("input:text").val() == 'administrator'){
			$('input:hidden').val('admin');
		}
		else{
			$('input:hidden').val('user');
		}
		
		this.action ="logindbprocess.jsp";
		//this.method = "post";
		
	});//submit 
	//id 입력하면 administrator administration adm 입력하면
	// role=admin 

});
</script>
</head>
<body>
<% 
String id = request.getParameter("id"); 
if(id == null){ id=""; }

%>
<form >
아이디입력 <input type=text name="id" value="<%=id%>">
암호입력 <input type=password name="pw">
<input type=hidden name="role" >
<input type=submit value="로그인">
</form>
</body>
</html>