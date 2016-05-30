package com.bright.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bright.bean.User;

@SuppressWarnings("serial")
//@WebFilter(urlPatterns = { "/main.jsp", "/borrow.jsp" })
public class InitFilter extends HttpServlet implements Filter {
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) arg0).getSession();
		User user = (User) session.getAttribute("CurrentUser");
		if (user == null) {
			 ((HttpServletResponse)
			 arg1).sendRedirect("/SSHDesign/login.jsp");
//			((HttpServletRequest) arg0).getRequestDispatcher("/login.jsp")
//					.forward(arg0, arg1);
		}
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
