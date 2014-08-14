<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<!-- 包括头上的一些文件用来控制文件相对路径 -->
	<base href="<%=basePath%>">
    
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
	<title>404页面</title>
	<link rel="icon" href="img/favicon.ico">

    <!-- Bootstrap 核心  CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- 该页面 自用 CSS模板 -->
    <link href="css/cover.css" rel="stylesheet">
    <!-- 项目字体全局CSS -->
    <link href="css/custom.css" rel="stylesheet">

</head>
<body>

    <div class="site-wrapper">
      <div class="site-wrapper-inner">
        <div class="cover-container">
          <div class="inner cover">
            <h1 class="cover-heading">404</h1>
            <p class="lead">找不到您所访问的页面</p>
            <p class="lead">
              <a href="<%=basePath%>" class="btn btn-lg btn-default">返回登陆页</a>
            </p>
          </div>
        </div>
      </div>
    </div>
 
</body>
</html>