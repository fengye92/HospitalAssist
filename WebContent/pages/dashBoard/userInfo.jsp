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
			<form role="form" onsubmit="" method="post" action="">
	  			<div class="form-group">
	    			<div class="col-md-4 col-md-offset-4">
	    				<label>医生工号</label>
	    				<input disabled="true" class="form-control"></input>
	    				<label>权限</label>
	    				<input disabled="true" class="form-control" placeholder="实习生"></input>
		    			<label for="">联系电话</label>
		    			<input class="form-control" id="" value="13*********"  autofocus="">
		    			<label for="">邮箱</label>
		    			<input class="form-control" id="" value="****@***.com">
		    			<label for="">所在科室</label>
		    			<input class="form-control" id="" value="科室名称">
		    			<label>个人介绍</label>
		    			<textarea class="form-control" rows="3"></textarea>
		    			<br/>
	    			</div>
	    			<div class="col-md-4 col-md-offset-7">
		    			<button type="submit" class="btn btn-default">
		    				<i class="fa fa-fw fa-save"></i>提交
		    			</button>
	    			</div>
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