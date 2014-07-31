<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">

<head>
	
	<base href="<%=basePath%>">
	
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="icon" href="img/favicon.ico">
    <title>医学数据管理系统</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
   	<!-- 中文字体控制 CSS -->
	<link href="css/custom.css" rel="stylesheet">
	
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <a class="navbar-brand" href="index.html">医学数据管理系统</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
            	<!-- 消息传递页面 -->
                <!-- <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    	<i class="fa fa-envelope"><span class="pic-title">2条新消息</span></i> <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu message-dropdown">
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>某某实习生</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> 2014/07/31 10:20</p>
                                        <p>上传某病人病例数据****************************************************</p>
                                    </div>
                                </div>
                              </a>
                           </li>
                           <li class="message-preview">
                              <a href="#">
                                 <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>某某实习生</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> 2014/07/31 10:21</p>
                                        <p>上传某病人病例数据****************************************************</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-footer">
                            <a href="#">阅读全部</a>
                        </li>
                    </ul> -->
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    	<i class="fa fa-user"></i><span class="pic-title">管理员</span><b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-gear"></i><span class="pic-title">用户设置</span></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-wrench"></i><span class="pic-title">修改密码</span></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-plus"></i><span class="pic-title">添加用户</span></a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-power-off"></i><span class="pic-title">退出</span></a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li class="active">
                        <a href="#"><i class="fa fa-fw fa-dashboard"></i><span class="pic-title">控制台</span></a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-fw fa-file"></i><span class="pic-title">病例信息</span></a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-fw fa-table"></i><span class="pic-title">统计表格</span></a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-fw fa-file-image-o"></i><span class="pic-title">医学图像</span></a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-fw fa-file-video-o"></i><span class="pic-title">步态视频</span></a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-fw fa-edit"></i><span class="pic-title">笔记数据</span></a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-fw fa-book"></i> <span class="pic-title">操作记录</span></a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

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
