<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<nav class="navbar navbar-static-top navbar-default" role="navigation" style="margin-bottom:0">
<%@include  file="/pages/common/sessionCheck.jsp"%>
<%HttpSession Session = request.getSession();          
String name = (String)Session.getAttribute("username");
String userPerm_ss = ""+Session.getAttribute("userPermission");
String userPerm_name;
if(!userPerm_ss.equals("null")){
	int userPerm_ssi = Integer.parseInt(userPerm_ss);
	if(userPerm_ssi==1)
	{
		userPerm_name = "管理员";
	}
	else if(userPerm_ssi==2)
	{
		userPerm_name="医生";
	}
	else
	{
		userPerm_name="实习生";
	}
}

String uid = (String)Session.getAttribute("userId");
String tel = (String)Session.getAttribute("tel");
String email = (String)Session.getAttribute("email");
String des=(String)Session.getAttribute("des");
String depart = (String)Session.getAttribute("department");
%>

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
<<<<<<< HEAD
</nav>	
</nav>	

   <!-- /.navbar-collapse -->      
=======
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
>>>>>>> origin/master
			
