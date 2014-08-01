package com.iel.hos.beans;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LoginFilter extends HttpServlet implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest sRequest, ServletResponse sResponse,FilterChain filterChain) throws IOException, ServletException{
	        
		HttpServletRequest request = (HttpServletRequest) sRequest;      
		HttpServletResponse response = (HttpServletResponse) sResponse;      
		HttpSession session = request.getSession();      
		String url = request.getServletPath();  
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		System.out.println(url);
		if(url.equals("")) url+="/";  
		if((url.startsWith("/")&&!url.startsWith("/pages/login"))){//若访问后台资源 过滤到login  
			String user=(String)session.getAttribute("userId"); 
			System.out.println(user);
			if(user==null){//转入管理员登陆页面  
				response.sendRedirect(contextPath+"/pages/login.jsp"); 
				return;  
			}  
		}  
		filterChain.doFilter(sRequest, sResponse);    
	}  

	public void init(FilterConfig arg0) throws ServletException {
	
	}
}