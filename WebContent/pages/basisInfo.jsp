<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.* ,java.io.*"%>
<%@ page import="org.apache.poi.poifs.filesystem.*,org.apache.poi.hssf.usermodel.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<%@ include file="header_css.jsp" %> 
</head>
<body>
<div id="wrapper">
	<%@ include file="header.jsp" %>
<div id="page-wrapper">
<div class="container-fluid">
<table class="table table-hover">
<%
  FileInputStream finput = new FileInputStream("d://aa.xls");
  //设定FileINputStream读取Excel档 
  POIFSFileSystem fs = new POIFSFileSystem( finput );
  HSSFWorkbook wb = new HSSFWorkbook(fs);
  HSSFSheet sheet = wb.getSheetAt(0);
  //读取第一个工作表，宣告其为sheet 
  finput.close();
  HSSFRow row=null;
  //宣告一列 
  HSSFCell cell=null;
  //宣告一个储存格 
  short i=0;
  short y=0;
  //以巢状迴圈读取所有储存格资料 
  for (i=0;i<=sheet.getLastRowNum();i++)
  {
    out.println("<tr>");
    row=sheet.getRow(i);
    for (y=0;y<row.getLastCellNum();y++)
    {
       cell=row.getCell(y);
       out.print("<td>");
       
       //判断储存格的格式 
       switch ( cell.getCellType() )
       {
           case HSSFCell.CELL_TYPE_NUMERIC:
               out.print(cell.getNumericCellValue());
               //getNumericCellValue()会回传double值，若不希望出现小数点，请自行转型为int 
               break;
           case HSSFCell.CELL_TYPE_STRING:
               out.print( cell.getStringCellValue());
               break;
           case HSSFCell.CELL_TYPE_FORMULA:
               out.print(cell.getNumericCellValue());
               //读出公式储存格计算後的值
               //若要读出公式内容，可用cell.getCellFormula() 
               break;
           default:
               out.print( "不明的格式");
               break;
       }
       out.println("</td>");
    }
    out.println("</tr>");
  }
%>
</table>
</div>
</div>
</div>
</body>
</html>