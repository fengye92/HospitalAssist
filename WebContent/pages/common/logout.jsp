<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<body>
<%
session.invalidate();

out.println("<script language='javascript'>");
//response.setHeader("Cache-Control","no-store"); 
//response.setDateHeader("Expires", 0); 
//response.setHeader("Pragma","no-cache");
out.println("window.location.href='../main.jsp'");
out.println("</script>");
%> 


</body>
</html>