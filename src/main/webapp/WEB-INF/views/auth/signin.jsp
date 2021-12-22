<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
로그인페이지


<form action="/study/signin" method="post">
	아이디: <input type="text" class="signin-ips" name="username"  value="${signinRespDto.username }" required="required"></br>
	비밀번호: <input type="password" class="signin-ips" name="password" value="${signinRespDto.password }"  required="required"></br>
	<button type="button" class="signin-btn">로그인</button>
</form>
<button type="button" onclick="location.href='/study/signup'">회원가입</button>
<input type="text" value="${principal.name }">
<script src="/study/resources/signinAjax.js">

</script>

</body>
</html>