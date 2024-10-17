<%@ page language="java" 
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>${title}</title>
<style>
	* {
	    margin: 0;
	    padding: 0;
	    box-sizing: border-box;
	  }
	  #container {
         background-color: #8ee9bb;
         background-size: cover;
         position: absolute;
         top: 0;
         left: 0;
         right: 0;
         bottom: 0;
       }
   form {
		width: 350px;
		border-radius: 10px;
        background: rgba(0, 0, 0, 0.7);
        margin-left: auto;
        margin-right: auto;
        margin-top: 50px;
        padding: 30px;
    }
	form h2 {
	    color: #fff;
    	text-align: center;
	}
	form input {
		display: black;
		width: 100%;
	}
	form label{
		color: #fff;
	}
	form input {
	    background-color: transparent;
	    border: 0;
	    border-bottom: 2px solid #fff;
	    padding: 10px 5px;
	    margin-top: 10px;
	    margin-bottom: 10px;
  	}
	form button {
	    display: block;
	    width: 100%;
	    background-color: blueviolet;
	    color: #fff;
	    border-radius: 20px;
	    padding: 10px;
	    border: 0;
	    margin-bottom: 10px;
  	}	
	#userID
	, #password
	, #password2
	, #username
	, #email 
	, #phone {
		color: #fff;
	}
		  
			   	  
</style>
</head>
<body>
	
	<form id="infoForm" method="post" action="/member/updateInfo">
		<h2 class="">회원정보 수정</h2>
		<input type="hidden" id="idx" name="idx" value='<c:out value="${userInfo.getIdx()}" />' readonly />
		<div>
			<label for="userID">아이디<label>
			<input type="text" id="userID" name="userID" value='<c:out value="${userInfo.getUserID()}" />' readonly />
		</div>
		<div>
			<label for="password">비밀번호<label>
			<input type="password" id="password" name="password" value='' />
		</div>
		<div>
			<label for="password2">비밀번호 확인<label>
			<input type="password" id="password2" name="password2" value='' />
		</div>
		<div>
			<label for="username">이름<label>
			<input type="text" id="username" name="username" value='' />
		</div>
		<div>
			<label for="phone">휴대폰 번호<label>
			<input type="text" id="phone" name="phone" value='' />
		</div>
		<div>
			<label for="email">이메일<label>
			<input type="text" id="email" name="email" value='' />
			<button type="button">중복확인</button>
		</div>
		<button type="button" id="btnConfirm">확인</button>
		<button type="button" id="btnConfirm">회원 탈퇴</button>
	</form>

	<script>
	// 폼 제출 시 사고를 방지하는 차원에서 비밀번호를 입력 받는다.
	// 만약 비밀번호도 변경해야하면 비밀번호 필드 2개 다 입력 받는다.
	// 비밀번호를 2개 입력 받은 경우 비교 처리 필요
	// 비동기 통신으로 처리해도 상관 없으나 실습을 위해서 post로 제출 처리한다.
	document.querySelector('#btnConfirm').addEventListener('click', function(e){
		e.preventDefault();
		
		const userID = document.querySelector('#userID').value?.trim();
		const email = document.querySelector('#email').value?.trim();
		const username = document.querySelector('#username').value?.trim();
		const password = document.querySelector('#password').value?.trim();
		const password2 = document.querySelector('#password2').value?.trim();
		
		const email_regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;
		if(!email_regex.test(email)){ 
			alert('이메일 형식을 확인하세요.');
			return false; 
		}
		if (userID === '') {
			alert('아이디가 없습니다.');
			window.location.href = '/';
			return false;
		}
		if (username.length < 2) {
			alert('이름은 2글자 이상 입력하세요.');
			return false;
		}
		if (password === '' && password2 !== '') {
			alert('비밀번호 변경을 원할 경우 비밀번호와 비밀번호 확인을 모두 입력하세요.');
			return false;
		}
		if (password !== '' && password2 !== '' && password !== password2) {
			alert('비밀번호와 비밀번호 확인 란이 다릅니다.');
			return false;
		}
		
		document.querySelector('#infoForm').submit();
	});
</script>	
</body>
</html>









