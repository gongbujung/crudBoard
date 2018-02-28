package com.java.dto;

public class MemberDto {
	
	private String id;						// ȸ�� ���̵�
	private String password;				// ȸ�� ��й�ȣ
	private String name;					// ȸ�� �г���
	private String email;					// ȸ�� �̸���
	private String favorite;				// ȸ���� ���� �����ϴ� ��ǰ
	
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
