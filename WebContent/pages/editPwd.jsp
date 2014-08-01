<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<script type="text/javascript">

</script>
<head>
	<base href="<%=basePath%>">
	<%@ include file="header_css.jsp" %> 
</head>

<body>
	<div id="wrapper">
	<%@ include file="header.jsp" %>
	
	<div id="page-wrapper">
		<div class="container-fluid">
			<form role="form" method="post" action="login.action">
  			<div class="form-group">
    			<label for="exampleInputPassword1">输入原密码</label>
    			<input type="password" class="form-control" id="exampleInputPassword1" placeholder="原密码">
    			<label for="exampleInputPassword2">输入新密码</label>
    			<input type="password" class="form-control" id="exampleInputPassword2" placeholder="新密码">
    			<label for="exampleInputPassword3">再次输入新密码</label>
    			<input type="password" class="form-control" id="exampleInputPassword3" placeholder="新密码">
    			<button type="submit" class="btn btn-default" onclick="check()">Submit</button>
  			</div>
  			</form>
		</div>
	</div>
	</div>		
			
		
                     
                          
                
            
</body>
</html>