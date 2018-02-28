package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.java.dto.DramaBoardDto;
import com.java.dto.MemberDto;

public interface IDao {
	// �Խ��� ��� ��������
	public ArrayList<DramaBoardDto> dramaBoardList(@Param("currentPageNo") final int currentPageNo);
	
	// �Խ��� �� �ۼ����� �Է�
	public void dramaBoardWrite(@Param("bName") final String bName, @Param("bTitle") final String bTitle, @Param("bContent") final String bContent);
	
	// �Խ��� �ۼ��� �̸� ��������
	public String dramaBoardWriter(@Param("session_id") final String session_id);
	
	// �Խ��� �� �����ϱ�
	public void dramaBoardDelete(@Param("strNum") final String strNum);
	
	// �Խ��� ��� �ۼ��ϱ�
	public void dramaBoardReply(@Param("bNum") final String bNum, @Param("bTitle") final String bTitle, @Param("bName") final String bName,
	
			@Param("bContent") final String bContent, @Param("bGroup") final String bGroup, @Param("bReply") final String bReply, @Param("bIndent") final String bIndent);
	
	// �Խ��� �� �󼼺���
	public DramaBoardDto dramaBoardContentView(@Param("strNum") String strNum);
	
	// �Խ��� �� �����ϱ�
	public void dramaBoardModify(@Param("bNum") final String bNum, @Param("bTitle") final String bTitle, @Param("bContent") final String bContent);
	
	// �Խ��� �� �����ϴ� ���� ���� ��������
	public DramaBoardDto dramaBoardModifyView(@Param("strNum") String strNum);
	
	// �Խ��� ��� �ۼ��ϴ� ���� ���� ��������
	public DramaBoardDto dramaBoardReplyView(@Param("strNum") String strNum);
	
	// �Խñ� ��ȸ�� ����
	public void dramaBoardUpHit(@Param("bNum") final String bNum);
	
	// �Խñ۰� ����� ����ǥ��
	public void dramaBoardReplyShape(@Param("bGroup") final String bGroup, @Param("bReply") final String bReply);
	
	
	// �α��ν� ���̵�� ��й�ȣ Ȯ��
	public ArrayList<MemberDto> loginOK(@Param("id") final String id, @Param("password") final String password);
	
	// ȸ�����Խ� ���̵� �ߺ�üũ
	public int joinIdCheck(@Param("idCheck") final String idCheck);
	
	// ȸ�����Խ� �̸� �ߺ�üũ
	public int joinNameCheck(@Param("nameCheck") final String nameCheck);
	
	// ȸ������ ���� DB�� �Է�
	public void joinOK(@Param("id") final String id, @Param("password") final String password, @Param("name") final String name, @Param("email") final String email, @Param("favorite") final String favorite);
	
	// index.jsp ���������� ��� �Խ��� �� ��� ���
	public ArrayList<String> indexDramaBoard();
	
	// index.jsp ���������� �ֽŴ�� ��� ���
	public ArrayList<String> indexCurrentReply();
	
	// index.jsp ���������� ���� ���� �� �� ��� ���
	public ArrayList<String> indexPopularView();
	
	public int numberOfPost();
}
