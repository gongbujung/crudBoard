package com.java.dto;

import java.sql.Timestamp;

public class DramaBoardDto {
	
	private int bNum;							// 게시글 번호
	private String bName;						// 게시글 작성자
	private String bTitle;						// 게시글 제목
	private String bContent;					// 게시글 내용
	private Timestamp bDate;					// 게시글 날짜
	private int bHit;							// 게시글 조회수
	private int bGroup;							// 게시글과 그에따른 답글 그룹화
	private int bReply;							// 답글 순서정렬을 위한 번호
	private int bIndent;						// 답글 계층정렬을 위한 들여쓰기
	
	public DramaBoardDto() {
		// TODO Auto-generated constructor stub
	}
	
	public DramaBoardDto(int bNum, String bName, String bTitle, String bContent, Timestamp bDate, int bHit, int bGroup, int bReply, int bIndent) {
		this.bNum = bNum;
		this.bName = bName;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bDate = bDate;
		this.bHit = bHit;
		this.bGroup = bGroup;
		this.bReply = bReply;
		this.bIndent = bIndent;
	}

	public int getbNum() {
		return bNum;
	}

	public void setbNum(int bNum) {
		this.bNum = bNum;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public Timestamp getbDate() {
		return bDate;
	}

	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}

	public int getbHit() {
		return bHit;
	}

	public void setbHit(int bHit) {
		this.bHit = bHit;
	}

	public int getbGroup() {
		return bGroup;
	}

	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}

	public int getbReply() {
		return bReply;
	}

	public void setbReply(int bReply) {
		this.bReply = bReply;
	}

	public int getbIndent() {
		return bIndent;
	}

	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}
	
	
	
}
