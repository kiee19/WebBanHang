package com.PS11390_NguyenTungNhatLinh_ASM.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class CheckOutInterceptor implements HandlerInterceptor{
	
	@Autowired
	HttpSession session;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(session.getAttribute("currentUser") != null) {
				return true;
		}
		String uri = request.getRequestURI();
		session.setAttribute("redirect-uri", uri);
		response.sendRedirect("/login");
		return false;
	}

}
