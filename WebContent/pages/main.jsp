<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<base href="<%=basePath%>">
<script language="javascript">
    window.location = "pages/patient/allPatients.jsp";
</script>
</html>