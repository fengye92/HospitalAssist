<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String result = (String)request.getAttribute("result");
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
	                    	<i class="fa fa-fw fa-gear"></i>
	                       <span class="pic-title">用户设置</span>
	                    </li>
	                </ol>
	            </div>
	        </div>
			<div class="row">
			<form role="form" onsubmit="return check()" method="post" action="userInfo.action">
	  			<div class="form-group">
	    			<div class="col-md-4 col-md-offset-4">
	    				<label>医生工号</label>
	    				<input disabled="true" class="form-control" placeholder=<%=uid %>></input>
	    				<label>权限</label>
	    				<input disabled="true" class="form-control" placeholder=<%=userPerm_name %>></input>
		    			<label for="">联系电话</label>
		    			<input name="tel" class="form-control" id="" value=<%=tel %>  autofocus="" required>
		    			<label for="">邮箱</label>
		    			<input name="email" class="form-control" id="" value=<%=email %> required>
		    			<label for="">所在科室</label>
		    			<input name="department" class="form-control" id="" value=<%=depart %> required>
		    			<label>个人介绍</label>
		    			<textarea name="des" class="form-control" rows="3" value=<%=des %>></textarea>
		    			<br/>
		    			<button type="submit" class="btn btn-default pull-right">
		    				<i class="fa fa-fw fa-save"></i>提交
		    			</button>
		    			<%if(result!=null&&result.equals("error")){
		    				out.print("<button type='button' class='close' data-dismiss='alert'><span aria-hidden='true'>&times;</span><span class='sr-only'>Close</span></button>修改错误</div>");
		    				}%>
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
	<script type="text/javascript">
	function check()
	{
		String tel = document.getElementByName("tel").value;
		String depart = document.getElementByName("department").value;
		String email =  document.getElementByName("email").value;
		if(tel==""||depart==""||email=="")
			{
			out.print("<div class='alert alert-warning alert-dismissible fade in' role='alert'>不能为空</div>");
			return false;
			}
		
	}	   
</body>
</html>