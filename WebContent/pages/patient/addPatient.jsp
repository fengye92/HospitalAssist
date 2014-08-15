<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">
$('#birthday').datepicker({
	  format: 'yyyy.mm.dd',
	        weekStart: 1,
	        autoclose: true,
	        todayBtn: 'linked',
	        language: 'zh-CN'
	 }).on('changeDate',function(ev){
	  var birth = ev.date.valueOf();
	  alert(birth);
});
</script>
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
			<form role="form" method="post" action="addUser.action">
  			<div class="form-group">
    			<label for="newPatientId">病人编号</label>
    			<input name="patient.id" type="text" class="form-control" id="newPatientId" placeholder="病人编号">
    			<label for="newPatientName">病人姓名</label>
    			<input name="patient.name" type="text" class="form-control" id="newPatientName" placeholder="病人姓名">
    			<label for="newPatientGender">病人性别</label>
				<select class="form-control" name="patient.gender">
    				<option value="1">男</option>
    				<option value="0">女</option>
    			</select>    			
    			<label for="newPatientBirth">出生日期</label>
					<div class="date form_datetime controls" data-date="2013.05.10"  id="birthday">
						<input type="text" class="span9" value="" id="newPatientBirth"> 
        				<span class="add-on">
         					<i class="icon-calendar"></i> 
        				</span>
      				</div>
    			
    			<button type="submit" class="btn btn-default" onClick="check()">提交</button>
    			
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