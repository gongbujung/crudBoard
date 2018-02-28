package com.java.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Interceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		try { 
			// ���ǿ� ����� ���̵� ���ٸ� �α����������� �̵�
			if(request.getSession().getAttribute("id") == null) {
				response.sendRedirect("login");
				return false;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} 
		return true;
	}
}
