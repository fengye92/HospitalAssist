<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
<base href="<%=basePath%>">
<head>  
<meta http-equiv="Content-Type"  content="text/html; charset=utf-8">  
<script src="js/plugins/spark-md5.js"></script>
<script type="text/javascript">  

function searchFiles(){  
    var fso = new ActiveXObject("Scripting.FileSystemObject");  
    var f = fso.GetFolder(document.all.fixfolder.value);  
    
    var fileReader = new FileReader();

	  blobSlice = File.prototype.mozSlice || File.prototype.webkitSlice || File.prototype.slice, 
	  file = f[0];
	
	  chunkSize = 2097152,                
	  chunks = Math.ceil(file.size / chunkSize), 
	  currentChunk = 0, 
	  isMid = 0,
	  isEnd = 0,
	  
	  //创建md5对象（基于SparkMD5）
	  spark = new SparkMD5();

	  //每块文件读取完毕之后的处理
	  fileReader.onload = function(e) {
	      
	      //每块交由sparkMD5进行计算
	      spark.appendBinary(e.target.result);
	      
	      if(chunks<=3){
	    	  currentChunk++;
	          
	          if (currentChunk < chunks) {
	              loadNext(currentChunk);
	          } else {
	              console.log("finished loading");
	              box.innerText = 'MD5 hash:' + spark.end();
	              console.info("计算的Hash", spark.end());
	          }
	      }else{

	    	  if(isMid===0){
	    		  isMid = 1;
	        	  loadNext(Math.ceil(chunks / 2));
	    	  }else if(isEnd===0){
	    		  isEnd = 1;
	    		  loadNext(chunks-1);
	    	  }else{
	    		  console.log("finished loading");
	              box.innerText = 'MD5 hash:' + spark.end();
	              console.info("计算的Hash", spark.end());
	    	  }
	      }
	      
	  };

	   //处理单片文件的上传
	   function loadNext(ss) {
	       console.log("读取文件", ss + 1, "/", chunks);

	       var start = ss * chunkSize, end = start + chunkSize >= file.size ? file.size : start + chunkSize;
		   
	       fileReader.readAsBinaryString(blobSlice.call(file, start, end));
	   }
		
	    loadNext(0);
    
    /*var fc = new Enumerator(f.files);  
    var s = "";  
    for (; !fc.atEnd(); fc.moveNext())  
    {  
        s += fc.item();  
        s += "<br/>";  
    }  
    fk = new Enumerator(f.SubFolders);  
    for (; !fk.atEnd(); fk.moveNext())  
    {  
        s += fk.item();  
        s += "<br/>";  
    }  
  
        textarea.innerHTML = s; */ 
}  
</script>  
</head>  
<body bgcolor="#FFFFFF">  
指定一个非空文件夹路径：<br/>  
<input type="text" name="fixfolder"  value ="G:\迅雷下载\17260000">  
<input type="button" value ="查找" onclick="searchFiles()">  
<table >  
<tr>  
<td  id = "textarea">  
  
</td>  
</tr>  
</table>  
  
</body>  
</html>