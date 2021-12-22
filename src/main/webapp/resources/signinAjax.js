const signinInputs = document.querySelectorAll('.signin-ips');
const signinBtn = document.querySelector('.signin-btn');
const inputNames = document.querySelectorAll('.ip-names');

function signin() {

	let signinObj = {
		username: signinInputs[0].value,
		password: signinInputs[1].value

	}

	$.ajax({
		type: "post",
		url: "/study/signin/ajax",
		data: JSON.stringify(signinObj), // json형태로 자동변환됌
		contentType: "application/json; charset=utf-8",
		dataType: "text",
		success: function(data) {
			//제이슨 데이터 편환
			let signinRespObj = JSON.parse(data);
			let signinFlag = signinRespObj.signinFlag;
			if (signinFlag == 0) {
				alert('존재하지 않는 아이디입니다.');
			} else if (signinFlag == 1) {
				alert('비밀번호가 틀렸습니다.');
			}else{
				alert('로그인 성공');
				//location.replace('/study/index');
				location.href('/study/index');
			}
		},
		error: function() {
			alert('비동기 처리 오류');
		}
	});
}




function isEmpty(signupInput, inputName) {
	let flag = 0;
	if (signupInput.value.length == 0) {
		flag = 1;
		alert(inputName + '을(를) 입력해 주세요.');
	}
	return flag;
}


signinBtn.onclick = () => {
	//버튼 누르면 먼저 비었는지 안비었는지 확인
	for (let  i = 0; i < signinInputs.length; i++) {
		let emptyCheck = isEmpty(signinInputs[i], inputNames[i].textContent);
		if (emptyCheck != 0) return;
	}
	signin();
}