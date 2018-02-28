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
	<link href="<c:url value="/resources/css/Index/index.css?ver=119" />" rel="stylesheet">
	<script src="<c:url value="/resources/js/jquery-3.2.1.min.js"/>"></script>
	<script src="<c:url value="/resources/js/index.js?ver=111" />"></script>
<title>영화 &amp; 드라마</title>
</head>
<body>
	<header>
		<c:choose>
			<c:when test="${sessionScope.id eq null}">
				<div id="index_login">
					<span class="index_login"> <a href="login">로그인</a> </span>
					<span class="index_login"> <a href="join">회원가입</a> </span>
				</div>
			</c:when>
			<c:when test="${sessionScope.id ne null}">
				<div id="index_login">
					<span class="index_login"> <a href="#">내 정보</a> </span>
					<span class="index_login"> <a href="logout">로그아웃</a> </span>
				</div>
			</c:when>
		</c:choose>
		
		<div id="index_title"> <a href="index"><img src="<c:url value="/resources/image/index_title.jpg" />"></a> </div>
	</header>
	
	<nav>
		<div id="index_nav">
			<div class="index_nav"> <a href="movie">영화</a> </div>
			<div class="index_nav"> <a href="drama">드라마</a> </div>
			<div class="index_nav"> <a href="#">이벤트</a> </div>
		</div>
	</nav>
	
	<section>
		<div id="index_section">
			<article>
				<div id="index_article">
	
					<div class="index_article">
					
						<div class="movie_article">
							<div class="movie_title"> <a href="movie">현재 개봉작</a> </div>
								<c:forEach var="i" begin="0" end="6">
									<div class="movie_content">&nbsp;${currentMovieTitle[i]}</div>
								</c:forEach>
						</div>
						
						<div class="movie_article">
							<div class="movie_title">영화 소식</div>
						</div>
						
						<div class="movie_article">
							<div class="movie_title">영화 게시판</div>
						</div>
						
					</div>
					
					<div class="index_article">
					
						<div class="drama_article">
							<div class="drama_title">현재 방영작</div>
						</div>
						
						<div class="drama_article">
							<div class="drama_title">드라마 소식</div>
						</div>
						
						<div class="drama_article">
							<div class="drama_title"> <a href="drama_board">드라마 게시판</a> </div>
								<c:forEach var="dramaBoard" items="${indexDramaBoard}">
									<div class="drama_content"> 
										&nbsp;<a href="drama_board_contentView?bNum=${dramaBoard.bNum}">${dramaBoard.bTitle}</a> 
									</div>
								</c:forEach>	
						</div>
						
					</div>
					
				</div>
			</article>
		
			<aside>
				<div id="index_aside">
					<div class="index_aside_title">&nbsp;최신 답글</div>
					<div class="index_aside_content_title">
						<ul id="aside_reply_nav">
							<li data-tab="tab1" class="current">게시판</li>
							<li data-tab="tab2">소식</li>
							<li data-tab="tab3">예고</li>
						</ul>
					</div>
					<div class="index_aside_content">
						<div id="aside_content">
							<div id="tab1" class="aside_reply_content current">
								<c:forEach var="currentReply" items="${indexCurrentReply}">
									<div class="currentReply">
										&nbsp;<a href="drama_board_contentView?bNum=${currentReply.bNum}">${currentReply.bTitle}</a>
									</div>
								</c:forEach>
							</div>
							<div id="tab2" class="aside_reply_content">
								
							</div>
							<div id="tab3" class="aside_reply_content">
								
							</div>
						</div>
					</div>
					<div class="index_aside_title">&nbsp;가장 많이 본 글</div>
					<div class="index_aside_content_title">
						<ul id="aside_comment_nav">
							<li data-tab="tab4" class="current">게시판</li>
							<li data-tab="tab5">소식</li>
							<li data-tab="tab6">예고</li>
						</ul>
					</div>
					<div class="index_aside_content">
						<div id="aside_content">
							<div id="tab4" class="aside_comment_content current">
								<c:forEach var="popularView" items="${indexPopularView}">
									<div class="popularView">
										&nbsp;<a href="drama_board_contentView?bNum=${popularView.bNum}">${popularView.bTitle}</a>
									</div>
								</c:forEach>
							</div>
							<div id="tab5" class="aside_comment_content">
								
							</div>
							<div id="tab6" class="aside_comment_content">
								
							</div>
						</div>
					</div>
				</div>
			</aside>
		</div>
	</section>
	
	<footer>
		<div id="index_footer">
			ⓒ영화 &amp; 드라마
		</div>
	</footer>
	
</body>
</html>