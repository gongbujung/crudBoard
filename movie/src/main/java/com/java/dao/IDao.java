package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.java.dto.DramaBoardDto;
import com.java.dto.MemberDto;

public interface IDao {
	// 게시판 목록 가져오기
	public ArrayList<DramaBoardDto> dramaBoardList(@Param("currentPageNo") final int currentPageNo);
	
	// 게시판 글 작성정보 입력
	public void dramaBoardWrite(@Param("bName") final String bName, @Param("bTitle") final String bTitle, @Param("bContent") final String bContent);
	
	// 게시판 작성자 이름 가져오기
	public String dramaBoardWriter(@Param("session_id") final String session_id);
	
	// 게시판 글 삭제하기
	public void dramaBoardDelete(@Param("strNum") final String strNum);
	
	// 게시판 답글 작성하기
	public void dramaBoardReply(@Param("bNum") final String bNum, @Param("bTitle") final String bTitle, @Param("bName") final String bName,
	
			@Param("bContent") final String bContent, @Param("bGroup") final String bGroup, @Param("bReply") final String bReply, @Param("bIndent") final String bIndent);
	
	// 게시판 글 상세보기
	public DramaBoardDto dramaBoardContentView(@Param("strNum") String strNum);
	
	// 게시판 글 수정하기
	public void dramaBoardModify(@Param("bNum") final String bNum, @Param("bTitle") final String bTitle, @Param("bContent") final String bContent);
	
	// 게시판 글 수정하는 뷰의 정보 가져오기
	public DramaBoardDto dramaBoardModifyView(@Param("strNum") String strNum);
	
	// 게시판 답글 작성하는 뷰의 정보 가져오기
	public DramaBoardDto dramaBoardReplyView(@Param("strNum") String strNum);
	
	// 게시글 조회수 관리
	public void dramaBoardUpHit(@Param("bNum") final String bNum);
	
	// 게시글과 답글의 계층표현
	public void dramaBoardReplyShape(@Param("bGroup") final String bGroup, @Param("bReply") final String bReply);
	
	
	// 로그인시 아이디와 비밀번호 확인
	public ArrayList<MemberDto> loginOK(@Param("id") final String id, @Param("password") final String password);
	
	// 회원가입시 아이디 중복체크
	public int joinIdCheck(@Param("idCheck") final String idCheck);
	
	// 회원가입시 이름 중복체크
	public int joinNameCheck(@Param("nameCheck") final String nameCheck);
	
	// 회원가입 정보 DB에 입력
	public void joinOK(@Param("id") final String id, @Param("password") final String password, @Param("name") final String name, @Param("email") final String email, @Param("favorite") final String favorite);
	
	// index.jsp 페이지에서 드라마 게시판 글 목록 출력
	public ArrayList<String> indexDramaBoard();
	
	// index.jsp 페이지에서 최신답글 목록 출력
	public ArrayList<String> indexCurrentReply();
	
	// index.jsp 페이지에서 가장 많이 본 글 목록 출력
	public ArrayList<String> indexPopularView();
	
	public int numberOfPost();
}
