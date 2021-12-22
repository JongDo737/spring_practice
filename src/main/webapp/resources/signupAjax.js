
const inputNames = document.querySelectorAll('.ip-names');
const signupInputs = document.querySelectorAll('.signup-ip');
const idCheck = document.querySelector('#id-check');
const signupForm = document.querySelector('form');
const signupBtn = document.querySelector('#signup-btn');

var idCheckFlag = false;

function usernameCheck(){
	let signupObj = {// 값들을 객체화 시킴 이형태를 가지고 있어야지만 값을 받을 수 있음
		username: signupInputs[0].value,
		password: signupInputs[1].value,
		name: signupInputs[2].value,
		email: signupInputs[3].value
	}
	
	$.ajax({
		type: "get",
		url: "/study/signup/username-check",
		data: signupObj,//dto형태 자동으로 변환
		dataType: "text",//응답을 받을때 타입
		success: function(data){ //리스폰스때 응답받을 데이터 위의 data와 다름
			alert(data); // <-- signupRespDto 를 전달받음
			let signupRespObj = JSON.parse(data) // 제이슨 데이터를 파싱해서 오브젝트 형태로
			
			idCheckFlag = signupRespObj.idCheckFlag;
			
			if(idCheckFlag==true){
				alert('가입 가능한 아이디입니다.');
			}
			else{
				alert('이미 존재하는 아이디입니다.')
			}
		},
		error: function(){
			alert('비동기 처리 오류.');
		}
		
	});
}

idCheck.onclick = () => {
	let checkFlag = isEmpty(signupInputs[0], inputNames[0].textContent);
	if(checkFlag != 0) return;
	usernameCheck();
}

function isEmpty(signupInput, inputName){
	let flag = 0;
	if(signupInput.value.length == 0){
		flag = 1;
		alert(inputName + '을(를) 입력해 주세요.');
	}
	return flag;
}

signupBtn.onclick = () => {
	let checkFlag = 0;
	
	for(let i = 0; i < signupInputs.length; i++){
		checkFlag = isEmpty(signupInputs[i], inputNames[i].textContent);
		if(checkFlag != 0) return;
	}
	
	if(idCheckFlag != true) {
		alert('아이디 중복확인을 해주세요.');
		return;
	}
	
	signupForm.submit();
}

/*
signupValues[0].onblur = () => {
	const testText = document.querySelector('.test-text');
	testText.style.color = 'red';
	//testText.innerHTML = '<a href="#">테스트</a>';
	const aTag = document.createElement('a');
	const href = document.createAttribute('href');
	aTag.setAttributeNode(href);
	aTag.href = '#';
	
	const text = document.createTextNode('테스트');
	aTag.appendChild(text);
	testText.appendChild(aTag);
	
}
*/