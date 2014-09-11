<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
		
		<!-- 增加右侧内容 -->
			<div class="row page-header">
				<div class="col-md-9">
					<h2 >病人姓名：某某某</h2>
				</div>
				<div class="col-md-3 " style="margin-top:25px">
					<div class="btn-group pull-right">
					<button type="button"  class="btn btn-danger">添加数据</button>
					<button type="button"  class="btn btn-danger">添加病例</button>
					</div>
				</div>
			</div>
			
			<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
			  <div class="panel panel-default">
			    <div class="panel-heading">
			      <h4 class="panel-title">
			        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
			          	病人信息
			        </a>
			      </h4>
			    </div>
			    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel"> 
			      <div class="panel-body">
			      	<div class="row">
			      		<div class="col-md-4">
							<label  class="control-label col-xs-4" style="margin-top:5px">出生日期：</label>
							<div class="col-xs-8">
			                	<input class="form-control"  placeholder="1960-01-01">
					    	</div>
						</div>
						<div class="col-md-4">
			      			<label  class="control-label col-xs-3" style="margin-top:5px">年龄：</label>
			      			<label  class="control-label col-xs-3" style="margin-top:5px">63</label>
			      		</div>
						<div class="col-md-4">
			      			<label  class="control-label col-xs-3" style="margin-top:5px">性别：</label>
			      			<div class="col-xs-4">
					         <select class="form-control ">
			    				<option value='1'>男</option>
			    				<option value='0'>女</option>
			     			</select>
			     			</div>
			      		</div>
			      	</div>
			      	<br>
			      	<div class="row">
						<div class="col-md-4">
							<label  class="control-label col-xs-4" >身份证<br/>号码：</label>
							<div class="col-xs-8">
			                	<input class="form-control"  placeholder="110***************">
					    	</div>
						</div>
						<div class="col-md-4">	
							<label  class="control-label col-xs-4" style="margin-top:5px">联系电话：</label>
							<div class="col-xs-8">
			                	<input class="form-control"  placeholder="13*********">
					    	</div>
						</div>
			      	</div>
			      	<br>
			      	<div class="row">
						<div class="col-md-4">
							<label  class="control-label col-xs-4" >备用<br/>联系人：</label>
							<div class="col-xs-8">
			                	<input class="form-control"  placeholder="某某">
					    	</div>
						</div>
						<div class="col-md-4">	
							<label  class="control-label col-xs-4" style="margin-top:5px">备用电话：</label>
							<div class="col-xs-8">
			                	<input class="form-control"  placeholder="13*********">
					    	</div>
						</div>
			      	</div>
			      	<br>
			      	<div class="row">
			      		<div class="col-md-2 col-md-offset-10">
			      		<button  type="button" class="btn btn-primary">
			      			<i class="fa fa-fw fa-save"></i><span class="pic-title">保存</span>
			      		</button>
			      		</div>
			      	</div>
			      </div>
			    </div>
			  </div>
			  <div class="panel panel-default">
			    <div class="panel-heading">
			      <h4 class="panel-title">
			        <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
			         	病人病历
			        </a>
			      </h4>
			    </div>
			    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel">
			     <table class="table table-hover ">
			       <thead>
			         <tr>
			           <th>序号</th>
			           <th>病例名称</th>
			           <th>添加时间</th>
			           <th>最后修改时间</th>
			           <th>操作</th>
			         </tr>
			       </thead>
			       <tbody>
			         <tr>
			           <td>1</td>
			           <td>心脑血管病及危险因素调查表2013年</td>
			           <td>2013-01-01</td>
			           <td>2014-01-01</td>
			           <td>
			           		<a href="#"><i class="fa fa-fw fa-folder-open" ></i></a>
			           		<a href="#"><i class="fa fa-fw fa-pencil" ></i></a>
			           </td>
			         </tr>
			       </tbody>
			     </table>
			    </div>
			  </div>
			  <div class="panel panel-default">
			    <div class="panel-heading">
			      <h4 class="panel-title">
			        <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
			          	医疗数据
			        </a>
			      </h4>
			    </div>
			    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel">
			      <table class="table table-hover ">
			       <thead>
			         <tr>
			           <th>序号</th>
			           <th>数据名称</th>
			           <th>所属疾病</th>
			           <th>添加时间</th>
			           <th>最后修改时间</th>
			           <th>操作</th>
			         </tr>
			       </thead>
			       <tbody>
			         <tr>
			           <td>1</td>
			           <td>头颅核磁数据</td>
			           <td>某某疾病</td>
			           <td>2013-01-01</td>
			           <td>2014-01-01</td>
			           <td>
			           		<a href="#"><i class="fa fa-fw fa-folder-open" ></i></a>
			           </td>
			         </tr>
			       </tbody>
			     </table>
			    </div>
			  </div>
			</div>
		</div>
	</div>
</div>


<!-- jQuery Version 1.11.0 -->
<script src="js/jquery-1.11.0.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>	 

<script>
	//控制左侧导航哪个被选中
	$('#side-menu>li').children('#patientInfo').addClass('active');
</script>
</body>
</html>
		