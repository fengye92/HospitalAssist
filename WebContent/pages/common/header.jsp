﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<nav class="navbar navbar-static-top navbar-default" role="navigation" style="margin-bottom:0">
<%HttpSession Session = request.getSession();          
String name = (String)Session.getAttribute("username");
int userPerm_ss = (Integer)Session.getAttribute("userPermission");
%>
<%@include  file="/pages/common/sessionCheck.jsp"%>

	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<a class="navbar-brand" href="pages/main.jsp">医学数据管理系统</a>
	</div>
		
	<!-- Top Menu Items -->
	<ul class="nav navbar-right navbar-top-links" >
		
	<li class="dropdown">
		<a href="#" class="dropdown-toggle" data-toggle="dropdown">
			<i class="fa fa-user"></i><span class="pic-title">您好，<%=name %></span><b class="caret"></b>
		</a>
		<ul class="dropdown-menu" id="dropDownMenu">
			<li >
				<a href="pages/dashBoard/userInfo.jsp"><i class="fa fa-fw fa-gear"></i><span class="pic-title">用户设置</span></a>
			</li>
            <li>
                <a href="pages/dashBoard/editPwd.jsp"><i class="fa fa-fw fa-wrench"></i><span class="pic-title">修改密码</span></a>

            </li>
            <li>
                <a href="pages/dashBoard/addUser.jsp"><i class="fa fa-fw fa-plus"></i><span class="pic-title">添加用户</span></a>

            </li>
            
            <li class="divider"></li>
            <li>
                <a href="pages/common/logout.jsp" ><i class="fa fa-fw fa-power-off"></i><span class="pic-title">退出</span></a>
            </li>
        </ul>
    </li>
	</ul>

	
	<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
	
	<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav" id="side-menu">
			<li>
				<a class="active" href="pages/main.jsp"><i class="fa fa-fw fa-dashboard"></i><span class="pic-title">控制台</span></a>
			</li>
			<li>
            	<a href="pages/patient/allPatients.jsp"><i class="fa fa-fw fa-group"></i><span class="pic-title">管理病人</span></a>
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
   </div>
</nav>	
<script>
	window.onload=function(){
		alert("asafd");
		var userPer="<%=userPerm_ss%>";
		if(userPer==3 ||userPer==2){
			$("<li><a href="pages/dashBoard/addUser.jsp"><i class="fa fa-fw fa-plus"></i><span class="pic-title">添加用户</span></a></li>").appendTo("#dropDownMenu");
			//jQuery("<li><a href="pages/dashBoard/addUser.jsp"><i class="fa fa-fw fa-plus"></i><span class="pic-title">添加用户</span></a></li>").appendTo("#dropDownMenu");
		}
	}
   </script>
   <!-- /.navbar-collapse -->      
			