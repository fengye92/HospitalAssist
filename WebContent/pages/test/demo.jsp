<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
<head>
	<base href="<%=basePath%>">
	<%@ include file="../common/headerCss.jsp" %> 
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/plugins/dataTables.bootstrap.css">
</head>
<body>
<div id="wrapper">
	<%@ include file="../common/header.jsp" %>
	<div id="page-wrapper">
		<div class="container-fluid">
		
		<!-- 增加右侧内容 -->
		</div>
	</div>
</div>


<!-- jQuery Version 1.11.0 -->
<script src="js/jquery-1.11.0.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>	 

<script>
	//控制左侧导航哪个被选中
	$('#side-menu>li').children('#patientInfo').addClass('active');
</script>
</body>
</html>
		