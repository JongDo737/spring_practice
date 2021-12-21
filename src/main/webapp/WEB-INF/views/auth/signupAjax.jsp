<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	회원가입페이지
	
	<form action="/study/signup" method="post">
		<label class="ip-names">아이디</label>
		<input type="text" class="signup-ip" name="username" required="required">
		
		<button type="button" id="id-check">중복확인</button></br>
		
		<label class="ip-names">비밀번호</label> 
		<input type="password" class="signup-ip" name="password" required="required"></br>
		<label class="ip-names">이름</label> 
		<input type="text" class="signup-ip" name="name" required="required"></br>
		<label class="ip-names">이메일</label> 
		<input type="email" class="signup-ip" name="email" required="required"></br>
		<button type="button" id="signup-btn">가입하기</button>
		<button type="reset">재작성</button>
	</form>
	
	<div class="test-text">안녕하세요</div>
	
	<button type="button" onclick="location.href='/study/signin'">로그인</button>
	<script src="/study/resources/signupAjax.js"></script>
</body>
</html>