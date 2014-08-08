<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String tran=(String)request.getAttribute("result");
%>

<script type="text/javascript">
window.onload=function()
{
	alert("aa");
	var test="<%=tran%>";
	if(test!=null&&test=="error")
		{
		alert("原密码密码错误，请重新输入");
		}
}
function checkform()
{
	var psw1= document.getElementById("exampleInputPassword2");
	var psw2= document.getElementById("exampleInputPassword3");
	var psw3= document.getElementById("exampleInputPassword1");
	var v1=psw1.value;
	var v2=psw2.value;
	var v3=psw3.value;
	if(v1===""||v2===""||v3==="")
		{
		alert("密码不能为空");
		document.getElementById("exampleInputPassword2").value="";
		document.getElementById("exampleInputPassword3").value="";
		return false;
		}
	if(v1!==v2)
		{
		alert("两次密码不一致，请重新输入");
		document.getElementById("exampleInputPassword2").value="";
		document.getElementById("exampleInputPassword3").value="";
		return false;
		}
}
</script>
<!DOCTYPE html>
<html lang="en">
<head>
	<base href="<%=basePath%>">
	<%@ include file="header_css.jsp" %> 
</head>

<body>
	<div id="wrapper">
	<%@ include file="header.jsp" %>
	
	<div id="page-wrapper">
		<div class="container-fluid">
			<form role="form" onsubmit="return checkform();" method="post" action="editPwd.action">
  			<div class="form-group">
    			<label for="exampleInputPassword1">输入原密码</label>
    			<input name="exPwd" type="password" class="form-control" id="exampleInputPassword1" placeholder="原密码">
    			<label for="exampleInputPassword2">输入新密码</label>
    			<input name="newPwd" type="password" class="form-control" id="exampleInputPassword2" placeholder="新密码">
    			<label for="exampleInputPassword3">再次输入新密码</label>
    			<input type="password" class="form-control" id="exampleInputPassword3" placeholder="新密码">
    			<button type="submit" class="btn btn-default">提交</button>
  			</div>
  			</form>
		</div>
	</div>
	</div>	
		<!-- jQuery Version 1.11.0 -->
	<script src="js/jquery-1.11.0.js"></script>
	
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>	     
</body>
</html>