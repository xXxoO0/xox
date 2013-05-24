<!DOCTYPE html PUBliC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<body>
<#include "head.ftl">
   ${message!}
   
   
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>UploadiFive Test</title>
<script src="${request.contextPath}/common/js/jquery-1.7.2.min.js"></script>
<script src="${request.contextPath}/common/js/upload/jquery.uploadify.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${request.contextPath}/common/js/upload/uploadify.css">
<script>
$(document).ready( function() {
   $("#upload_file").uploadify( {//初始化函数
   	'auto': false,
   	'method':'post',//默认是post 
   	'debug': true,//默认是false 开发阶段用true
    'swf' :'${request.contextPath}/common/js/upload/uploadify.swf',//flash文件位置，注意路径
    'uploader' :'${request.contextPath}/test/test-fileupload.action',//后台处理的请求
    'formData' : {'id' : '啊啊'},//传递参数id=123  注意 中文参数用post然后后台重新转化编码
    'fileTypeDesc' : '任意文件',//限制上传文件类型描述
    'fileTypeExts' : '*.*',//限制上传文件类型（'*.gif; *.jpg; *.png'）图片类型
   	'buttonText' : '请选择文件',//按钮名字
   	'queueSizeLimit' : 3,//限制最多几个文件可选中
    'removeTimeout' : 1,//上传完成后文件行消失的时间延迟 默认3秒
    'fileSizeLimit' : '1MB'//单位可以是B KB MB GB
    <#--
    'overrideEvents' : ['onUploadProgress'],//重写覆盖原来的那些事件这里的例子是重写了更新进度条事件
    'preventCaching' : false,//默认是true 是否阻止缓存 默认阻止
    'requeueErrors' : true,//默认false 如果设置为true，返回上传队列尝试上传多次的错误。
   	'removeCompleted' : false,//上传完成后是否去掉成功的那行   默认是true 
    'successTimeout' : 5,//上传成功后的延迟
    'multi' : false//默认自true 多线程 
    'progressData' : 'speed',//进度条 加上上传速度 默认是percentage百分比
    'queueSizeLimit' : 1,//限制最多几个文件可选中
    'buttonImage' : '/uploadify/browse-btn.png'//可以替换成自己想要的图片 
    'checkExisting' : '/uploadify/check-exists.php',//验证重复性 可替换成对应action
    'fileObjName' : 'the_files',
    'width' : 300,//宽度
    'height' : 50,//高度
    'uploadLimit' : 1, //限制上传文件数量 默认999
  	'itemTemplate' : '<div id="d" class="uploadify-queue-item">\
					<div class="cancel">\
						<a href="javascript:$(\'#upload_file\').uploadify(\'cancel\', \'d\')">X</a>\
					</div>\
					<span class="fileName">d (123)</span><span class="data"></span>\
				</div>'//由于$跟freemarker冲突暂时无法解决
    -->
   });
   
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
//http://hi.baidu.com/hilsl88/item/f8714914a52f6840e75e06ba
</script>
</head>

<body>

	<h1>Uploadify Demo</h1>
		<div id="fileQueue"></div>
		   <input type="file" name="upload_file" id="upload_file" />
		   <button type="button" id="up">上传</button>
		   <button type="button" id="allup">上传全部</button>
		   <button type="button" id="cancel">取消</button>
		   <button type="button" id="allcancel">取消全部</button>
		   <button type="button" id="stop">停止</button>
		   <button type="button" id="change">变回原来</button><br>
		   <a href="http://www.uploadify.com/documentation/">参考地址</a>
</body>
</html>
</body>
</html>