<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%   
	response.setHeader("Cache-Control","no-store");   
	response.setHeader("Pragma","no-cache");   
	response.setDateHeader("Expires",0);
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="<c:url value="/resources/css/DramaBoard/drama_board_contentView.css?ver=8" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/Index/drama_common.css?ver=2019" />" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<header>
		<c:choose>
			<c:when test="${sessionScope.id eq null}">
				<div id="drama_login">
					<span class="drama_login"> <a href="login">로그인</a> </span>
					<span class="drama_login"> <a href="join">회원가입</a> </span>
				</div>
			</c:when>
			<c:otherwise>
				<div id="drama_login">
					<span class="drama_login"> <a href="#">내 정보</a> </span>
					<span class="drama_login"> <a href="logout">로그아웃</a> </span>
				</div>
			</c:otherwise>
		</c:choose>
		
		<div id="drama_title"> <a href="index"><img src="<c:url value="/resources/image/drama_title.jpg" />" ></a> </div>
	</header>
	
	<nav>
		<div id="drama_nav">
			<div class="drama_nav"> <a href="movie">영화</a> </div>
			<div class="drama_nav"> <a href="drama">드라마</a> </div>
			<div class="drama_nav"> <a href="#">이벤트</a> </div>
		</div>
	</nav>
	
	<section>
		<div id="drama_section">
			<article>
				<ul id="article_nav">
					<li class="article_nav"> <a href="drama">현재 방영작</a> </li>
					<li class="article_nav current"> <a href="drama_board">드라마 게시판</a> </li>
				</ul>
				
				<div id="article_content">
					<div class="article_content current">
					<form action="drama_board_modifyView" method="post">
						<input type="hidden" name ="bNum" value="${dramaBoardContentView.bNum}">
							<table class="drama_board_contentView_table" border="1">
								<thead>
									<tr>
										<th> 글번호 </th>
										<td> ${dramaBoardContentView.bNum} </td>
										<td colspan="3"> ${dramaBoardContentView.bTitle} </td>
									</tr>
									<tr>
										<th> 조회수 </th>
										<td> ${dramaBoardContentView.bHit} </td>
										<th> 작성자 </th>
										<td> ${dramaBoardContentView.bName} </td>
										<td></td>
									</tr>
								</thead>
									
								<tbody>
									<tr>
										<td colspan="5"> <pre>${dramaBoardContentView.bContent}</pre> </td>
									</tr>
								</tbody>
							</table>
							<div class="tfoot">
								<c:if test="${dramaBoardWriter eq dramaBoardContentView.bName}">
									<button type="submit">수정하기</button> &nbsp;&nbsp;
									<button type="button" onclick="location.href='drama_board_delete?bNum=${dramaBoardContentView.bNum}'">삭제</button> &nbsp;&nbsp;
								</c:if>
								<button type="button" onclick="location.href='drama_board'">목록보기</button> &nbsp;&nbsp; 
								<button type="button" onclick="location.href='drama_board_replyView?bNum=${dramaBoardContentView.bNum}'">답변</button>
							</div>
						</form>
					</div>
				</div>
			</article>
				
			<aside>
				<div id="drama_aside">
					
				</div>
			</aside>
		</div>
	</section>
	
	<footer>
		<div id="drama_footer">
			영화 &amp; 드라마
		</div>
	</footer>
	
</body>
</html>