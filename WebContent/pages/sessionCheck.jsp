<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%
Object obj = session.getAttribute("userId");
if(obj==null){
	String contextPath = request.getContextPath();

	response.sendRedirect(contextPath+"/pages/login.jsp");
}
%>