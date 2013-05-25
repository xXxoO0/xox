<!DOCTYPE html> 
<html> 
<head>
<meta charset="utf-8">
<script src="${request.contextPath}/js/jquery-1.7.2.min.js"></script>
<script src="${request.contextPath}/js/upload/jquery.uploadify.min.js" type="text/javascript"></script>
<script src="${request.contextPath}/js/upload/upload.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${request.contextPath}/js/upload/uploadify.css">
<script>
$(document).ready( function() {
    uploadinit("${request.contextPath}","${request.contextPath}/test/upload");
    $("#up").click(function(){
    	 $('#upload_file').uploadify('upload');
    });
    $("#allup").click(function(){
    	 $('#upload_file').uploadify('upload','*');
    });
    $("#cancel").click(function(){
    	$('#upload_file').uploadify('cancel');
    });
    $("#allcancel").click(function(){
    	$('#upload_file').uploadify('cancel', '*');
    });
    $("#stop").click(function(){
    	$('#upload_file').uploadify('stop');
    });
    $("#change").click(function(){
    	$('#upload_file').uploadify('destroy');
    });
  
});
</script>
</head>
<body> 
<div style="height:500px;width:800px;border:1px solid;">
<h1>Uploadify Demo</h1>
		<div id="fileQueue"></div><div id="btnbar"><button type="button" id="up">上传</button>
		   <button type="button" id="allup">上传全部</button>
		   <button type="button" id="cancel">取消</button>
		   <button type="button" id="allcancel">取消全部</button>
		   <button type="button" id="stop">停止</button>
		   <button type="button" id="change">变回原来</button>
		   <a href="http://www.uploadify.com/documentation/">参考地址</a></div>
		<input type="file" name="upload_file" id="upload_file" />
		 
</div>
</body>
</html>