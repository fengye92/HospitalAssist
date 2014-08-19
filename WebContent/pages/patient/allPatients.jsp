<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String message=(String)request.getAttribute("message");
%>

<!DOCTYPE>
<html>
<head>
	<base href="<%=basePath%>">
	<%@ include file="../common/headerCss.jsp" %> 
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/plugins/dataTables.bootstrap.css">
</head>
<body>
<div id="wrapper">
	<%@ include file="../common/header.jsp" %>
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row page-header">
				<div class="col-md-8">
					<h2 >全部病人</h2>
				</div>
				<div class="col-md-4">
					<button type="button" data-toggle="modal" data-target="#addPatient" class="btn btn-danger pull-right" style="margin-top:25px">添加病人</button>
				</div>
			</div>
			<div class="row">
			<%if(message!=null&&message.equals("error")){
	    	  out.print("<div class='alert alert-warning alert-dismissible fade in' role='alert'><button type='button' class='close' data-dismiss='alert'><span aria-hidden='true'>&times;</span><span class='sr-only'>Close</span></button>插入失败</div>");
			}%>
  
			</div>
				<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="patientsInfo">
					<thead>
						<tr>
							<th>患者编号</th>
							<th>姓名</th>
							<th>年龄</th>
							<th>性别</th>
							<th>身份证号</th>
							<th>电话号码</th>
							<th>地址</th>
						</tr>
					</thead>
					<tbody>
	
					</tbody>
				</table>
		</div>
	</div>
</div>

<form class="form-horizontal" role="form" method="post" action="addPatient.action">
<!-- 增加病人弹出对话框-->
<div class="modal fade" id="addPatient" data-target="#myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">添加病人</h4>
      </div>
      <div class="modal-body">
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label"  >病人编号</label>
		    <div class="col-sm-10">
		      <input class="form-control" id="inputEmail3" name="patient.id" placeholder="EX****" autofocus required>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-2 control-label" >病人姓名</label>
		    <div class="col-sm-10">
		      <input class="form-control" id="inputPassword3" placeholder="某某" name="patient.name" required>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-2 control-label"  >身份证号</label>
		    <div class="col-sm-10">
		      <input class="form-control" id="inputPassword3" name="patient.idNum" placeholder="110101************" required>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-2 control-label"  required>性别</label>
		    <div class="col-sm-10">
		         <select class="form-control" name="patient.gender">
    				<option value='1'>男</option>
    				<option value='0'>女</option>
     			</select>
		    </div>
		  </div>
		 <div class="form-group">
                <label for="dtp_input2" class="col-sm-2 control-label" >年龄</label>
                <div class="col-sm-10">
                	<input class="form-control" id="inputPassword3" name="patient.age">
		    	</div>
          </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-2 control-label" >电话号码</label>
		    <div class="col-sm-10">
		      <input class="form-control"  placeholder="" name="patient.telephone" required>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-2 control-label" >家庭住址</label>
		    <div class="col-sm-10">
		      <input class="form-control"  placeholder="" name="patient.address" required>
		    </div>
		  </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="submit" class="btn btn-primary" >保存信息</button>
      </div>
    </div>
  </div>
</div>
</form>


<!-- jQuery Version 1.11.0 -->
<script src="js/jquery-1.11.0.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>	 

<script src="js/plugins/jquery.dataTables.min.js"></script>
<script src="js/plugins/dataTables.bootstrap.js"></script>
<script>
$(document).ready(function() {
	 $('#patientsInfo').dataTable( {
		 "oLanguage": {
			 "sLengthMenu": "每页显示 _MENU_ 条记录",
			 "sZeroRecords": "抱歉， 没有找到",
			 "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
			 "sInfoEmpty": "没有数据",
			 "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
			 "sSearch": "患者编号:		",
			 "oPaginate": {
			 	"sFirst": "首页",
			 	"sPrevious": "前一页",
			 	"sNext": "后一页",
			 	"sLast": "尾页"
			 },
			 "sZeroRecords": "没有检索到数据",
			 "sProcessing": false
		 },
		 "bAutoWidth": false,                    //不自动计算列宽度   
        "aoColumns": [                          //设定各列宽度   
               {"sWidth": "15px"},   
               {"sWidth": "100px"},   
               {"sWidth": "160px"},   
               {"sWidth": "80px"},   
               {"sWidth": "120px"},   
               {"sWidth": "100px"},   
               {"sWidth": "180px"}  
                       ],  
		 "bProcessing": true,
	     "bServerSide": true,
	     "sAjaxSource": "allpatients.action",
	     "bJQueryUI":true
	 } );
} );
</script>
</body>
</html>