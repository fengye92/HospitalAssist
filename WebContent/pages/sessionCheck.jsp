<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%
Object obj = session.getAttribute("userId");
if(obj==null){
	out.print("你没有登录");
	String contextPath = request.getContextPath();

	response.sendRedirect(contextPath+"/pages/login.jsp");
}else{
	out.print("当前登录为" + (String)obj);
}
%>