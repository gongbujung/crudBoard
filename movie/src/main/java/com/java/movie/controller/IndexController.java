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
	
	// 초기 화면
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
	
	// 로그인 화면
	@RequestMapping("/login")
	public String login(Model model) {
		return "Login/login";
	}
	
	// 로그인
	@RequestMapping("/loginOK")
	public String loginOK(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		if(dao.loginOK(request.getParameter("id"), request.getParameter("password")).isEmpty() == false) {
				HttpSession session = request.getSession();
				session.setAttribute("id", request.getParameter("id"));
				return "redirect:index";
			} else {
				model.addAttribute("loginFail", "아이디와 비밀번호를 다시 입력해주세요");
				return "Login/login";
			}
		
	}
	
	// 로그아웃
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:index";
	}
	
	// 회원가입 화면
	@RequestMapping("/join")
	public String join(Model model) {
		return "Login/join";
	}
	
	// 회원가입 아이디 중복체크
	@RequestMapping(value="/joinIdCheck", produces="application/json; charset=utf-8", method= RequestMethod.POST)
	@ResponseBody
	public int joinIdCheck(HttpServletRequest request) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		int result = dao.joinIdCheck(request.getParameter("idCheck"));	
		
		return result;
	}
	
	// 회원가입 닉네임 중복체크
	@RequestMapping(value="/joinNameCheck", produces="application/json; charset=utf-8", method= RequestMethod.POST)
	@ResponseBody
	public int joinNameCheck(HttpServletRequest request) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		int result = dao.joinNameCheck(request.getParameter("nameCheck"));	
		
		return result;
	}
	
	// 회원가입
	@RequestMapping("/joinOK")
	public String joinOK(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.joinOK(request.getParameter("id"), request.getParameter("password"), request.getParameter("name"), request.getParameter("email"), request.getParameter("favorite"));
		
		return "Login/joinOK";
	}
	
	// 드라마 페이지 화면
	@RequestMapping("/drama")
	public String drama(Model model) {
		
		return "Index/drama";
	}
	
	// 현재 상여중인 영화 정보를 웹크롤링 해서 출력한 화면
	@RequestMapping("/movie")
	public String movie(Model model) {
		
		MovieJsoup currentMovie = new MovieJsoup();
		model.addAttribute("currentMovieTitle", currentMovie.WebScraping().get(0));
		model.addAttribute("currentMovieImage", currentMovie.WebScraping().get(1));
		model.addAttribute("currentMovieInfo", currentMovie.WebScraping().get(2));
		
		return "Index/movie";
	}
}
