<%
Object userId_ss = session.getAttribute("userId");
if(userId_ss==null){
	String contextPath = request.getContextPath();

	//out.println("<script language='javascript'>");
	//out.println("window.location.href='pages/login.jsp'");
	//out.println("</script>");
	//response.setHeader("Cache-Control","no-store"); 
	//response.setDateHeader("Expires", 0); 
	//response.setHeader("Pragma","no-cache");
	response.sendRedirect(contextPath+"/pages/login.jsp");
}
%>