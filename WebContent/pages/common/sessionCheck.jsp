<%
Object userId_ss = session.getAttribute("userId");
if(userId_ss==null){
	String contextPath = request.getContextPath();

	response.sendRedirect(contextPath+"/pages/login.jsp");
}
%>