<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>File Upload </h1>
	<form action="fileupload.action" method="post" enctype="multipart/form-data">
		<div align="left">
			<pre>选择上传的文件:<input type="file" name ="uploadfile" size="40" name="upl-file"> 
			<input type="submit"  value="submit"> <input type="reset" value="reset"></pre>
		</div>
	</form>
</body>
</html>