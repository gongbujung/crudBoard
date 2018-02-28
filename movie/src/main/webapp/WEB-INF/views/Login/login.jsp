<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link href="<c:url value="/resources/css/Login/login.css?ver=9" />" rel="stylesheet">
</head>
<body>	
	<div id="login_page">
		<div id="login_title">
			<a href="index">영화 &amp; 드라마</a>
		</div>
		<div id="login_form">
			<form action="loginOK" method="post">
				<div id="login_input">
					<div class="login_input">	
						<input type="text" name="id" value="아이디" size="50"> <br />
						<input type="password" name="password" value="비밀번호" size="50"> <br />
					</div>
					<input type="submit" value="로그인">
				</div>
			</form>
			<div id="loginMessage">
				${loginFail}
			</div>
			<div class="login_option">
				<input type="checkbox" name="login_keep" value="login_keep">로그인 유지 &nbsp;
				<a href="#">아이디/비밀번호 찾기</a> &nbsp;
				<a href="join">회원가입</a>
			</div>
		</div>
	</div>
</body>
</html>