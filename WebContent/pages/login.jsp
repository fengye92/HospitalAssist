<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
Object obj = session.getAttribute("userId");
String contextPath = request.getContextPath();

if(obj==null){
}else{
	response.sendRedirect(contextPath+"/pages/main.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
	
	<base href="<%=basePath%>">
	
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>登陆</title>
	<link rel="icon" href="img/favicon.ico">
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/signin.css" rel="stylesheet">
	<link href="css/custom.css" rel="stylesheet">
	
</head>
<body>
	<div class="container">

      <form class="form-signin" role="form" method="post" action="login.action">
        <h2 class="form-signin-heading">医学数据管理系统</h2>
        <input name="user.userId" type="userName" class="form-control" placeholder="用户名" required="" autofocus="">
        <input name="user.userPasswd" type="password" class="form-control" placeholder="密码" required="">
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
      </form>

    </div>
</body>
</html>