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
	<link href="<c:url value="/resources/css/Index/movie_common.css?ver=2018" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/Index/movie.css?ver=2018" />" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<header>
		<c:choose>
			<c:when test="${sessionScope.id eq null}">
				<div id="movie_login">
					<span class="movie_login"> <a href="login">로그인</a> </span>
					<span class="movie_login"> <a href="join">회원가입</a> </span>
				</div>
			</c:when>
			<c:otherwise>
				<div id="movie_login">
					<span class="movie_login"> <a href="#">내 정보</a> </span>
					<span class="movie_login"> <a href="logout">로그아웃</a> </span>
				</div>
			</c:otherwise>
		</c:choose>
		
		<div id="movie_title"> <a href="index"><img src="<c:url value="/resources/image/movie_title.jpg" />" ></a> </div>
	</header>
	
	<nav>
		<div id="movie_nav">
			<div class="movie_nav"> <a href="movie">영화</a> </div>
			<div class="movie_nav"> <a href="drama">드라마</a> </div>
			<div class="movie_nav"> <a href="#">이벤트</a> </div>
		</div>
	</nav>
	
	<section>
		<div id="movie_section">
			<article>
				<ul id="article_nav">
					<li class="article_nav current"> <a href="movie">현재 개봉작</a> </li>
				</ul>
				
				<div id="article_content">
					<div class="article_content current">
						<table class="currentMovieTable">
							<tr>
								<c:forEach var="i" begin="0" end="2">
									<td> <img src="${currentMovieImage[i]}"> </td>
									<td> 
										${currentMovieTitle[i]} <br /><br />
										${currentMovieInfo[i]} 
									</td>
								</c:forEach>
							</tr>
							<tr>
								<c:forEach var="i" begin="3" end="5">
									<td> <img src="${currentMovieImage[i]}"> </td>
									<td> 
										${currentMovieTitle[i]} <br /><br />
										${currentMovieInfo[i]} 
									</td>
								</c:forEach>
							</tr>
							<tr>
								<td> <img src="${currentMovieImage[6]}"> </td>
								<td> 
									${currentMovieTitle[6]} <br /><br />
									${currentMovieInfo[6]}
								</td>
								<td colspan="4"> 출처 : CGV </td>
							</tr>
						</table>
					</div>
				</div>
			</article>
				
			<aside>
				<div id="movie_aside">

				</div>
			</aside>
		</div>
	</section>
	
	<footer>
		<div id="movie_footer">
			영화 &amp; 드라마
		</div>
	</footer>
	
</body>
</html>