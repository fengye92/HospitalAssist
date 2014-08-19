<%@ page language="java"  pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		
		<title>DataTables Bootstrap 2 example</title>

		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/plugins/dataTables.bootstrap.css">

		<script src="js/jquery-1.11.0.js"></script>
		<script src="js/plugins/jquery.dataTables.min.js"></script>
		<script src="js/plugins/dataTables.bootstrap.js"></script>
		<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				 $('#example').dataTable( {
					 "bProcessing": true,
				     "bServerSide": true,
				     "sAjaxSource": "allpatients.action",
				     "sPaginationType":"full_numbers",
				     "bJQueryUI":true
				     //"fnServerData":retrieveData
				 } );
			} );
		</script>
	</head>
	<body>
		<div class="container">
			
<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
	<thead>
		<tr>
			<th>Rendering engine</th>
			<th>Browser</th>
			<th>Platform(s)</th>
			<th>Engine version</th>
			<th>CSS grade</th>
			<th>CSS grade1</th>
			<th>CSS grade2</th>
		</tr>
	</thead>
	<tbody>
	
	</tbody>
</table>
			
		</div>
	</body>
</html>