<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html lang="zh-CN">
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
			<div class="row">
				<br>
	            <div class="col-md-12">
	                <ol class="breadcrumb">
	                    <li>
	                        <i class="fa fa-group"></i>
	                        <span class="pic-title"><a href="pages/main.jsp">病人信息</a></span>
	                    </li>
	                    <li >
	                    	<a href="">某某病人</a>
	                    </li>
	                    <li>
	                    	<a href="">某某数据</a>
	                    </li>
	                </ol>
	            </div>
	        </div>
			<div class="row">
				<div class="col-md-3">
					<div class="thumbnail"  href="#">
						<img data-src="holder.js/300x300" alt="...">
					 	<div class="caption">
					 		<h3>Thumbnail label</h3>
					 		<p>...</p>
					 		<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
					 	</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="thumbnail"  href="#">
						<img data-src="holder.js/300x300" alt="...">
					 	<div class="caption">
					 		<h3>Thumbnail label</h3>
					 		<p>...</p>
					 		<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
					 	</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="thumbnail"  href="#">
						<img data-src="holder.js/300x300" alt="...">
					 	<div class="caption">
					 		<h3>Thumbnail label</h3>
					 		<p>...</p>
					 		<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
					 	</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="thumbnail"  href="#">
						<img data-src="holder.js/300x300" alt="...">
					 	<div class="caption">
					 		<h3>Thumbnail label</h3>
					 		<p>...</p>
					 		<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
					 	</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="thumbnail"  href="#">
						<img data-src="holder.js/300x300" alt="...">
					 	<div class="caption">
					 		<h3>Thumbnail label</h3>
					 		<p>...</p>
					 		<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
					 	</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="thumbnail"  href="#">
						<img data-src="holder.js/300x300" alt="...">
					 	<div class="caption">
					 		<h3>Thumbnail label</h3>
					 		<p>...</p>
					 		<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
					 	</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="thumbnail"  href="#">
						<img data-src="holder.js/300x300" alt="...">
					 	<div class="caption">
					 		<h3>Thumbnail label</h3>
					 		<p>...</p>
					 		<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
					 	</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="thumbnail"  href="#">
						<img data-src="holder.js/300x300" alt="...">
					 	<div class="caption">
					 		<h3>Thumbnail label</h3>
					 		<p>...</p>
					 		<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
					 	</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="thumbnail"  href="#">
						<img data-src="holder.js/300x300" alt="...">
					 	<div class="caption">
					 		<h3>Thumbnail label</h3>
					 		<p>...</p>
					 		<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
					 	</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="thumbnail"  href="#">
						<img data-src="holder.js/300x300" alt="...">
					 	<div class="caption">
					 		<h3>Thumbnail label</h3>
					 		<p>...</p>
					 		<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
					 	</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="thumbnail"  href="#">
						<img data-src="holder.js/300x300" alt="...">
					 	<div class="caption">
					 		<h3>Thumbnail label</h3>
					 		<p>...</p>
					 		<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
					 	</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="thumbnail"  href="#">
						<img data-src="holder.js/300x300" alt="...">
					 	<div class="caption">
					 		<h3>Thumbnail label</h3>
					 		<p>...</p>
					 		<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
					 	</div>
					</div>
				</div>
			</div>
			<div class="row">
				<ul class="pagination pull-right">
				  <li><a href="#">&laquo;</a></li>
				  <li><a href="#">1</a></li>
				  <li><a href="#">2</a></li>
				  <li><a href="#">3</a></li>
				  <li><a href="#">4</a></li>
				  <li><a href="#">5</a></li>
				  <li><a href="#">&raquo;</a></li>
				</ul>
			</div>
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
		