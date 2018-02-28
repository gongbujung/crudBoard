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
	<link href="<c:url value="/resources/css/DramaBoard/drama_board_writeView.css?ver=19" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/Index/drama_common.css?ver=2018" />" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<header>
		<c:choose>
			<c:when test="${sessionScope.id eq null}">
				<div id="drama_login">
					<span class="drama_login"> <a href="login">로그인</a> </span>
					<span class=drama_login> <a href="join">회원가입</a> </span>
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
						<form action="drama_board_write" method="post">
							<input type="hidden" name="bName" value="${dramaBoardWriter}">
							<table class="drama_board_writeView_table" border="1">
								<thead>
									<tr>
										<th> 이름 </th>
										<td> ${dramaBoardWriter} </td>
									</tr>
									<tr>
										<th> 제목 </th>
										<td> <input type="text" name="bTitle" size= "50"> </td>
									</tr>
								</thead>
			
								<tbody>
									<tr>
										<th> 내용 </th>
										<td> <textarea name="bContent" cols="55" rows= "20"></textarea> </td>
									</tr>
								</tbody>
								
								<tfoot>
									<tr>
										<td colspan="2"> 
											<button type="submit">입력</button> &nbsp;&nbsp; 
											<button type="button" onclick="location.href='drama_board'">목록보기</button>
										</td>
									</tr>
								</tfoot>
							</table>
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