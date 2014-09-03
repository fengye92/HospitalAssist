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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="fileupload.action" method="post" enctype="multipart/form-data">
		<div>
                <input type="file" id="uploadfile" multiple>
                <div id="box"> </div>
            </div>

	</form>
</body>
<script src="js/plugins/spark-md5.js"></script>
<script type="text/javascript">

document.getElementById("uploadfile").addEventListener("change", function() {
  var leng= document.getElementById("uploadfile").files.length;
  var i = 0;
  for(i;i<leng;i++){
	loadFile(i);	  
  }

});

function loadFile(s){
	  var fileReader = new FileReader(), box = document.getElementById('box');

	 blobSlice = File.prototype.mozSlice || File.prototype.webkitSlice || File.prototype.slice, 
	  file = document.getElementById("uploadfile").files[s], 

	  //文件每块分割2M，计算分割详情
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
	              console.info("计算的Hash", box.innerText);
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
	              console.info("计算的Hash", box.innerText);
	    	  }
	      }
	      
	  };

	   //处理单片文件的上传
	   function loadNext(ss) {
	       console.log("读取文件", ss + 1, "/", chunks, file.name);

	       var start = ss * chunkSize, end = start + chunkSize >= file.size ? file.size : start + chunkSize;
		   
	       fileReader.readAsBinaryString(blobSlice.call(file, start, end));
	   }
		
	    loadNext(0);
}
</script>


</html>