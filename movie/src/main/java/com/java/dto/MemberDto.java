package com.java.dto;

public class MemberDto {
	
	private String id;						// 회원 아이디
	private String password;				// 회원 비밀번호
	private String name;					// 회원 닉네임
	private String email;					// 회원 이메일
	private String favorite;				// 회원이 가장 좋아하는 작품
	
	public MemberDto() {
		
	}
	
	public MemberDto(String id, String password, String name, String email, String favorite) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.favorite = favorite;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFavorite() {
		return favorite;
	}
	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}
	
}
