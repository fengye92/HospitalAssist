<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<%@ include file="../common/headerCss.jsp" %> 
</head>
<body>
<div id="wrapper">
	<%@ include file="../common/header.jsp" %>
<div id="page-wrapper">
<div class="container-fluid">
  <table class="table table-hover">
  	<tr>
  		<td>患者编号</td><td>姓名</td><td>年龄</td><td>性别</td><td>身份证号码</td><td>电话号码</td><td>地址</td>
  	</tr>
		<c:forEach var="p" items="${patients }" varStatus="status">
		 <tr>
		 	<td>${p.id }</td>
 			<td>${p.name }</td>
 			<td>${p.age }</td>
 			<td>${p.gender }</td>
 			<td>${p.idNum }</td>
 			<td>${p.telephone }</td>
 			<td>${p.address }</td>
 			</tr>
		</c:forEach>
 </table>
</div>
</div>
</div>
</body>
</html>