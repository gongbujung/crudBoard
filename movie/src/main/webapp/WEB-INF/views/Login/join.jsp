<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link href="<c:url value="/resources/css/Login/join.css?ver=11" />" rel="stylesheet">
	<script src="<c:url value="/resources/js/jquery-3.2.1.min.js"/>"></script>
	<script src="<c:url value="/resources/js/join.js?ver=1" />" ></script>
</head>
<body>
	<div id="join_page">
	
		<div id="join_title">
			<a href="index">영화 &amp; 드라마</a>
		</div>
		
		<div id="join_info"> &emsp; * 표시는 필수작성입니다 </div>
		
		<form action="joinOK" method="post">
			<div id="join_form">
				<div class="join_item">아이디*</div>
				<div class="join_content">
					<input type="text" name="id" size="25" maxlength="10">
				</div>
				<div id="join_idCheck" class="join_check"></div>
				
				<div class="join_item">비밀번호*</div>
				<div class="join_content">
					<input type="password" name="password" size="25">
				</div>
				<div id="join_passwordCheck" class="join_check"></div>
				
				<div class="join_item">비밀번호 확인*</div>
				<div class="join_content">
					<input type="password" name="password_check" size="25">
				</div>
				<div id="join_RepasswordCheck" class="join_check"></div>
				
				<div class="join_item">닉네임*</div>
				<div class="join_content">
					<input type="text" name="name" size="25">
				</div>
				<div id="join_nameCheck" class="join_check"></div>
				
				<div class="join_item">이메일</div>
				<div class="join_content">
					<input type="text" name="email" size="25">
				</div>
				<div id="join_emailCheck" class="join_check"></div>
				
				<div class="join_item">가장 좋아하는 작품</div>
				<div class="join_content">
					<input type="text" name="favorite" size="25">
				</div>
				<div id="join_favoriteCheck" class="join_check"></div>
			
				<div class="join_submit">
					<button type="submit" disabled="disabled">가입하기</button> &nbsp; &nbsp;
				</div>
				
			</div>
		</form>
	</div>
</body>
</html>