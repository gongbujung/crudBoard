package com.java.movie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.dao.IDao;
import com.java.paging.Paging;

@Controller
public class DramaBoardController {
	
	IDao dao;
	
	@Autowired
	private SqlSession sqlSession;

	// 게시판 목록 화면
	@RequestMapping("/drama_board")
	public String drama_board(Model model, HttpServletRequest request) {
		
		IDao dao = sqlSession.getMapper(IDao.class);		
		
		if(request.getParameter("currentPageNo") == null) {
			Paging paging = new Paging(0, 10, dao.numberOfPost());
			paging.makePaging();
			model.addAttribute("paging", paging);
			model.addAttribute("dramaBoardList", dao.dramaBoardList(0));
		} else {
			Paging paging = new Paging(Integer.parseInt(request.getParameter("currentPageNo")), 10, dao.numberOfPost());
			paging.makePaging();
			model.addAttribute("paging", paging);
			model.addAttribute("dramaBoardList", dao.dramaBoardList(Integer.parseInt(request.getParameter("currentPageNo")) - 1));
		}
		
		return "DramaBoard/drama_board";
	}
	
	// 게시판 글 작성하는 화면
	@RequestMapping("/drama_board_writeView")
	public String drama_board_writeView_writer(Model model, HttpSession session) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("dramaBoardWriter", dao.dramaBoardWriter(session.getAttribute("id").toString()));
		
		return "DramaBoard/drama_board_writeView";
	}
	
	// 게시판 글 작성
	@RequestMapping("/drama_board_write")
	public String drama_board_write(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.dramaBoardWrite(request.getParameter("bName"), request.getParameter("bTitle"), request.getParameter("bContent"));
		
		return "redirect:drama_board";
	}
	
	// 게시판 상세보기 화면
	@RequestMapping("/drama_board_contentView")
	public String drama_board_contentView(HttpServletRequest request, Model model, HttpSession session) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.dramaBoardUpHit(request.getParameter("bNum"));
		model.addAttribute("dramaBoardContentView", dao.dramaBoardContentView(request.getParameter("bNum")));
		model.addAttribute("dramaBoardWriter", dao.dramaBoardWriter(session.getAttribute("id").toString()));
		
		return "DramaBoard/drama_board_contentView";
	}
	
	// 게시판 글 수정화면
	@RequestMapping("/drama_board_modifyView")
	public String drama_board_modifyView(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("dramaBoardModifyView", dao.dramaBoardModifyView(request.getParameter("bNum")));
		
		return "DramaBoard/drama_board_modifyView";
	}
	
	// 게시판 글 수정
	@RequestMapping(method=RequestMethod.POST, value="/drama_board_modify")
	public String drama_board_modify(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.dramaBoardModify(request.getParameter("bNum"), request.getParameter("bTitle"), request.getParameter("bContent"));
		
		return "redirect:drama_board";
	}
	
	// 게시판 글 삭제
	@RequestMapping("/drama_board_delete")
	public String drama_board_delete(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.dramaBoardDelete(request.getParameter("bNum"));
		
		return "redirect:drama_board";
	}
	
	// 게시판 답글달기
	@RequestMapping("/drama_board_reply")
	public String drama_board_reply(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.dramaBoardReplyShape(request.getParameter("bGroup"), request.getParameter("bReply"));
		dao.dramaBoardReply(request.getParameter("bNum"), request.getParameter("bTitle"), request.getParameter("bName"), request.getParameter("bContent"), 
							  request.getParameter("bGroup"), request.getParameter("bReply"), request.getParameter("bIndent"));
		
		return "redirect:drama_board";
	}
	
	// 게시판 답글달기 화면
	@RequestMapping("/drama_board_replyView")
	public String drama_board_replyView(HttpServletRequest request, Model model, HttpSession session) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("dramaBoardReplyView", dao.dramaBoardReplyView(request.getParameter("bNum")));
		model.addAttribute("dramaBoardWriter", dao.dramaBoardWriter(session.getAttribute("id").toString()));
		
		return "DramaBoard/drama_board_replyView";
	}
	
	
}
