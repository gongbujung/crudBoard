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
	<link href="<c:url value="/resources/css/DramaBoard/drama_board.css?ver=201802061350" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/Index/drama_common.css?ver=2018" />" rel="stylesheet">
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
		
		<div id="drama_title"> <a href="index"> <img src="<c:url value="/resources/image/drama_title.jpg" />" ></a> </div>
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
						<div class="drama_board_table_title"> <span>드라마 게시판</span> &emsp; <span>드라마 관련 자유 게시판입니다</span> </div>
						<table class="drama_board_table" border="1">
							<thead>
								<tr>
									<th>번호</th>
									<th>이름</th>
									<th>제목</th>
									<th>날짜</th>
									<th>조회수</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${dramaBoardList}" var="dto">
									<tr>
										<td>${dto.bNum}</td>
										<td>${dto.bName}</td>
										<td>
											<c:forEach begin="1" end="${dto.bIndent}">&emsp;</c:forEach>
											&nbsp;<c:if test="${dto.bReply gt 0}">(답글)</c:if>
											<a href="drama_board_contentView?bNum=${dto.bNum}">${dto.bTitle}</a>
										</td>
										<td>${dto.bDate}</td>
										<td>${dto.bHit}</td>
								</c:forEach>
							</tbody>
						</table>
						<div class="tfoot">
							<button type="button" onclick="location.href='drama_board_writeView'">글쓰기</button>
						</div>
						
						<div class="pagination">
							<a href="drama_board?currentPageNo=${paging.firstPageNo}" class="first">처음으로</a>
							<a href="drama_board?currentPageNo=${paging.prevPageNo}" class="prev">이전 페이지</a>
							<span>
								<c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
									<c:choose>
										<c:when test="${i eq paging.currentPageNo}"><a href="drama_board?currentPageNo=${i}" id="choice" class="page_number">${i}</a></c:when>
										<c:otherwise><a href="drama_board?currentPageNo=${i}" class="page_number">${i}</a></c:otherwise>
									</c:choose>
								</c:forEach>
    						</span>
							<a href="drama_board?currentPageNo=${paging.nextPageNo}" class="next">다음 페이지</a>
							<a href="drama_board?currentPageNo=${paging.finalPageNo}" class="last">마지막으로</a>
						</div>
						
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