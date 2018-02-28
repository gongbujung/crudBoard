package com.java.movie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dao.IDao;
import com.java.jsoup.MovieJsoup;

@Controller
public class IndexController {
	
	IDao dao;
	
	@Autowired
	private SqlSession sqlSession;
	
	// �ʱ� ȭ��
	@RequestMapping("/index")
	public String index(Model model) {
		
		MovieJsoup currentMovie = new MovieJsoup();
		model.addAttribute("currentMovieTitle", currentMovie.WebScraping().get(0));
		
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("indexDramaBoard", dao.indexDramaBoard());
		model.addAttribute("indexCurrentReply", dao.indexCurrentReply());
		model.addAttribute("indexPopularView", dao.indexPopularView());
		
		return "Index/index";
	}
	
	// �α��� ȭ��
	@RequestMapping("/login")
	public String login(Model model) {
		return "Login/login";
	}
	
	// �α���
	@RequestMapping("/loginOK")
	public String loginOK(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		if(dao.loginOK(request.getParameter("id"), request.getParameter("password")).isEmpty() == false) {
				HttpSession session = request.getSession();
				session.setAttribute("id", request.getParameter("id"));
				return "redirect:index";
			} else {
				model.addAttribute("loginFail", "���̵�� ��й�ȣ�� �ٽ� �Է����ּ���");
				return "Login/login";
			}
		
	}
	
	// �α׾ƿ�
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:index";
	}
	
	// ȸ������ ȭ��
	@RequestMapping("/join")
	public String join(Model model) {
		return "Login/join";
	}
	
	// ȸ������ ���̵� �ߺ�üũ
	@RequestMapping(value="/joinIdCheck", produces="application/json; charset=utf-8", method= RequestMethod.POST)
	@ResponseBody
	public int joinIdCheck(HttpServletRequest request) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		int result = dao.joinIdCheck(request.getParameter("idCheck"));	
		
		return result;
	}
	
	// ȸ������ �г��� �ߺ�üũ
	@RequestMapping(value="/joinNameCheck", produces="application/json; charset=utf-8", method= RequestMethod.POST)
	@ResponseBody
	public int joinNameCheck(HttpServletRequest request) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		int result = dao.joinNameCheck(request.getParameter("nameCheck"));	
		
		return result;
	}
	
	// ȸ������
	@RequestMapping("/joinOK")
	public String joinOK(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.joinOK(request.getParameter("id"), request.getParameter("password"), request.getParameter("name"), request.getParameter("email"), request.getParameter("favorite"));
		
		return "Login/joinOK";
	}
	
	// ��� ������ ȭ��
	@RequestMapping("/drama")
	public String drama(Model model) {
		
		return "Index/drama";
	}
	
	// ���� ������ ��ȭ ������ ��ũ�Ѹ� �ؼ� ����� ȭ��
	@RequestMapping("/movie")
	public String movie(Model model) {
		
		MovieJsoup currentMovie = new MovieJsoup();
		model.addAttribute("currentMovieTitle", currentMovie.WebScraping().get(0));
		model.addAttribute("currentMovieImage", currentMovie.WebScraping().get(1));
		model.addAttribute("currentMovieInfo", currentMovie.WebScraping().get(2));
		
		return "Index/movie";
	}
}
