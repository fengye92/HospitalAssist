<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">

<head>
	<base href="<%=basePath%>">
	<%@ include file="header_css.jsp" %> 
</head>

<body>		
    <div id="wrapper">
    	<%@ include file="header.jsp" %> 
    	
    	<!-- 不同的页面内容在此处体现，header等其他信息一样 -->
    	<div id="page-wrapper">
            <div class="container-fluid">
				<div class="row">
					<h1 class="page-header">统计信息</h1>
					<h2 class="page-header">统计信息</h2>
					<h3 class="page-header">统计信息</h3>
					<h4 class="page-header">统计信息</h4>
					<h5 class="page-header">统计信息</h5>
					<p class="page-header">统计信息</p>
					<p class="page-header">统计信息</p>
					<p class="page-header">统计信息</p>
					<p class="page-header">统计信息</p>
				</div>
            </div>
            <!-- /.container-fluid -->
        </div>
    	<!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->

    <!-- jQuery Version 1.11.0 -->
    <script src="js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
</body>

</html>
