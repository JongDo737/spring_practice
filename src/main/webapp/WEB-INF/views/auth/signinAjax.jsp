<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
로그인페이지

<form action="/study/signin" method="post">
	<label class="ip-names">아이디</label>
	 <input type="text" name="username"  required="required"></br>
	<label class="ip-names">비밀번호</label>
	<input type="password" name="password" required="required"></br>
	<button type="button" class="signin-btn">로그인</button>
</form>
<button type="button" onclick="location.href='/study/signup'">회원가입</button>
<input type="text" value="${principal.name }"><!-- 
<script type="text/javascript">
	const signinFlag = document.querySelector('#signin-flag');
	if(signinFlag.value == 0){
		alert('존재하지 않는 아이디입니다.');
	}else if(signinFlag.value == 1){
		alert('비밀번호가 틀렸습니다.');
	
	}else{
	
	}
</script> -->

</body>
</html>