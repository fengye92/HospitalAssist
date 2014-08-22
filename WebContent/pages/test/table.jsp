<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/plugins/dataTables.bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script type="text/javascript" language="javascript" src="js/jquery-1.11.0.js"></script>
<script type="text/javascript" language="javascript" src="js/plugins/jquery.dataTables.js"></script>
<script type="text/javascript" language="javascript" src="js/plugins/jquery.dataTables.min.js"></script>
<script src="js/bootstrap.min.js"></script>	 

<script src="js/plugins/jquery.dataTables.min.js"></script>
<script src="js/plugins/dataTables.bootstrap.js"></script>


<title>Insert title here</title>
</head>
<body>
<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example"> 
        <thead> 
            <tr>
                <th> 
                    Rendering engine 
                </th> 
                <th> 
                    Browser 
                </th> 
                <th> 
                    Platform(s) 
                </th> 
                <th>
                    Engine version 
                </th> 
                <th> 
                    CSS grade 
                </th> 
            </tr> 
        </thead> 
        <tbody> 
     		       
</tbody>
</table>
<script>
$(document).ready(function()
		{
		alert("A");
	    $('#example').dataTable({
	    	 "bProcessing": true,
		     "bServerSide": true,
		     "sAjaxSource": "allpatients.action",
		     "bJQueryUI":true
	    });
	    
		});
</script>
</body>

</html>