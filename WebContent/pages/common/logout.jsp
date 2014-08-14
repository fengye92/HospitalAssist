<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE >
<%
	HttpSession ss = request.getSession();
	ss.invalidate();
	String contextPath = request.getContextPath();
	response.sendRedirect(contextPath+"/pages/login.jsp");
%>