<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String message=(String)request.getAttribute("message");
int userPer_ss = (Integer)session.getAttribute("userPermission");
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<base href="<%=basePath%>">
	<%@ include file="../common/headerCss.jsp" %> 
</head>

<body>
	<div id="wrapper">
	<%@ include file="../common/header.jsp" %>
	
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row">
				<br/>
	            <div class="col-lg-12">
	                <ol class="breadcrumb">
	                    <li>
	                        <i class="fa fa-dashboard"></i>
	                        <span class="pic-title"><a href="pages/main.jsp">控制台</a></span>
	                    </li>
	                    <li class="active">
	                    	<i class="fa fa-fw fa-plus"></i>
	                       <span class="pic-title">添加用户</span>
	                    </li>
	                </ol>
	            </div>
	        </div>
			<div class="row">
			<form role="form" method="post" action="addUser.action" onsubmit="return check();">
  			<div class="form-group">
  				<div class="col-md-4 col-md-offset-4">
  				
    			<label for="newUserId" id="userIdLabel">新用户ID</label>
    			<input name="user.userId" type="text" class="form-control" id="newUserId" placeholder="用户ID" autofocus="">
    			<span id="tip"></span>
    			<label for="newUserName" id="userNameLabel">新用户姓名</label>
    			<input name="user.userName" type="text" class="form-control" id="newUserName" placeholder="用户姓名">
    			<label for="newUserPwd">新用户密码（初始为000）</label>
    			<input type="text" class="form-control" id="newUserPwd" disabled="true"  placeholder="000">
    			<label for="newUserPermission">新用户权限</label>
    			<select class="form-control" name="user.permission" id="newUserPermission">
    				<option value='1'>实习生</option>
     			</select>
    			<br/>
    			<button type="submit" class="btn btn-default pull-right" onClick="check()">
    				<i class="fa fa-fw fa-save"></i>提交
    			</button>
    			<br/>
    			<br/>
    			<% if(message!=null&&message.equals("existingId"))
      	    	{
      				out.print("<div class='alert alert-warning alert-dismissible fade in' role='alert'><button type='button' class='close' data-dismiss='alert'><span aria-hidden='true'>&times;</span><span class='sr-only'>Close</span></button>用户ID已存在！</div>");
      	    	}else if(message!=null&&message.equals("success")){
      				out.print("<div class='alert alert-warning alert-dismissible fade in' role='alert'><button type='button' class='close' data-dismiss='alert'><span aria-hidden='true'>&times;</span><span class='sr-only'>Close</span></button>添加用户成功！</div>");
      	    	}
      			%>
    			</div>
  			</div>
  			</form>
  		</div>
		</div>
	</div>
	</div>	
		<!-- jQuery Version 1.11.0 -->
	<script src="js/jquery-1.11.0.js"></script>
	
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>	 
	
	<script>
	
	function check(){
		var id= document.getElementById("newUserId");
		var name= document.getElementById("newUserName");
		var permission= document.getElementById("newUserPermission");
		var v1=id.value;
		var v2=name.value;
		var v3=permission.value;
		
		if(v1===""){
			document.getElementById("userIdLabel").innerHTML="新用户ID（不能为空）";
			return false;
		}else if(v2===""){
			document.getElementById("userNameLabel").innerHTML="新用户姓名（不能为空）";
			
			return false;
		}
	}
	
	window.onload=function(){		
		var userPer="<%=userPer_ss%>";
		if(userPer==3){
			jQuery("<option value='2'>医生</option>").appendTo("#newUserPermission");
			jQuery("<option value='3'>管理员</option>").appendTo("#newUserPermission");
		}
	}
	</script>    
</body>
</html>