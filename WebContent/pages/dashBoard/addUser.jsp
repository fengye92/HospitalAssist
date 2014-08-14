<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
		<div class="container">
			<div class="row">
			<form role="form" method="post" action="addUser.action">
  			<div class="form-group">
  				<div class="col-md-4 col-md-offset-3">
    			<label for="newUserId">新用户ID</label>
    			<input name="user.userId" type="text" class="form-control" id="newUserId" placeholder="用户ID">
    			<label for="newUserName">新用户姓名</label>
    			<input name="user.userName" type="text" class="form-control" id="newUserName" placeholder="用户姓名">
    			<label for="newUserPwd">新用户密码（初始为000）</label>
    			<input type="text" class="form-control" id="newUserPwd" disabled="true"  placeholder="000">
    			<label for="newUserPermission">新用户权限</label>
    			<select class="form-control" name="user.permission">
    				<option value="3">管理员</option>
    				<option value="2">医生</option>
    				<option value="1">实习生</option>
    			</select>
    			<br/>
    			</div>
    			<div class="col-md-3 col-md-offset-6">
	    			<button type="submit" class="btn btn-default" onClick="check()">
	    				<i class="fa fa-fw fa-save"></i>提交
	    			</button>
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
	$('#newUserId').focus();
	
	//这段代码能用?
	/*function check(){
	
		HttpServletRequest request1 = ServletActionContext.getRequest();
		String test=request1.getAttribute("message");
		alert(test);
	
	}*/
	</script>    
</body>
</html>