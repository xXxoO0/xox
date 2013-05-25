var defaultsetting = {
	 	'auto': false,
	   	'method':'post',//默认是post 
	   	'debug': true,//默认是false 开发阶段用true
	    'swf' :'/js/upload/uploadify.swf',//flash文件位置，注意路径
	   // 'uploader' :,//后台处理的请求
	   // 'formData' : {},//传递参数id=123  注意 中文参数用post然后后台重新转化编码
	    'fileTypeDesc' : '图片类型',//限制上传文件类型描述
	    'fileTypeExts' : '*.gif; *.jpg; *.png;*.jpeg;*.bmp',//限制上传文件类型图片类型
	   	'buttonText' : '请选择图片',//按钮名字
	   	'queueSizeLimit' : 10,//限制最多几个文件可选中
	   // 'removeTimeout' : 3,//上传完成后文件行消失的时间延迟 默认3秒
	    'width' : 80,//按钮宽度
	    'height' : 20,//按钮高度
	    'fileSizeLimit' : '5MB'//单位可以是B KB MB GB
	    /*
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
	   */
}
/**
 * 
 * @param req  request.contextPath 
 * @param url  上传action
 * @param width 按钮宽度
 * @param height 按钮长度
 */
function uploadinit(req,url,width,height){
	var wit;
	var hit;
	if(width){
		wit = width;
	}
	if(height){
		hit = height;
	}
var settings ={
		 'uploader' :url,
		 'swf' :req+'/js/upload/uploadify.swf',
		 'width' : wit,//按钮宽度
		 'height' : hit,//按钮高度
		 'onUploadComplete':showImages
};
var finalsetting = $.extend(defaultsetting,settings);
$("#upload_file").uploadify(finalsetting);
//对按钮栏进行初始化
$("#btnbar").css({
	display:'inline',
});
} 
/**
 * 上传完成显示照片
 */
function showImages(){
	
}