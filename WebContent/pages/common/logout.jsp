<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<body>
<%
HttpSession ss = request.getSession();
ss.invalidate();
String contextPath = request.getContextPath();
response.sendRedirect(contextPath+"/pages/main.jsp");
%>



</body>
</html>