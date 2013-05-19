var xmlhttp;
/**
 * ajax get方式 
 * @param url 路径
 * @param async 是否同步 true（异步）或 false（同步）
 * @param func 回调函数
 */
function doAjaxGet(url,async,func){
	if(window.XMLHttpRequest){
		xmlhttp = new XMLHttpRequest();
	}else{
		//支持低版本浏览器 ie5.6
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = func;
	xmlhttp.open("get",url,async);
	xmlhttp.send();
}
/**
 * ajax post方式  此方法是为了隐藏参数某些值 并不是真正的表单提交
 * @param url 路径
 * @param async true（异步）或 false（同步）
 * @param func 回调函数
 * @param param 
 */
function doAjaxPost(url,async,func,param){
	if(window.XMLHttpRequest){
		xmlhttp = new XMLHttpRequest();
	}else{
		//支持低版本浏览器 ie5.6
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = func;
	xmlhttp.open("post",url,async);
	if(param){
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send(param);
	}else{
		xmlhttp.send();
	}
}
/**
 * 设置ajax默认参数
 * 所有参数调用者都可以覆盖
 */
var ajaxdefault = {
	    //url:"",//请求路径需调用者提供
		type:"post",//默认是post
		timeout:30000,//设置请求超时时间（毫秒）为单位 默认30秒
		async:true,//默认异步 
		//beforeSend:function//发送请求前可修改 XMLHttpRequest 对象的函数 
		/**
		 * (默认: true) 设置为 false 将不会从浏览器缓存中加载请求信息。
		 * 开发时需要调试 因此设置成false 
		 * 正式发布环境默认应设置成true减小服务器压力
		 * （某些需要实时取最新数据function可以通过写入参数cache：false来覆盖测出设置）
		 * */
		cache:false,
		complete:ajaxComplete,//请求完成后回调函数 (请求成功或失败时均调用)。参数： XMLHttpRequest 对象，成功信息字符串
		contentType:"application/x-www-form-urlencoded", //默认当做表单处理
		//data:“”//请求数据需调用者提供
		/**
		 * 预期服务器返回的数据类型。
		 * 如果不指定，jQuery 将自动根据 HTTP 包 MIME 信息返回 responseXML 或 responseText，并作为回调函数参数传递，可用值:
         *"xml": 返回 XML 文档，可用 jQuery 处理。
         *"html": 返回纯文本 HTML 信息；包含 script 元素。
         *"script": 返回纯文本 JavaScript 代码。不会自动缓存结果。
         *"json": 返回 JSON 数据 。
		 *"jsonp": JSONP 格式。使用 JSONP 形式调用函数时，如 "myurl?callback=?" jQuery 将自动替换 ? 为正确的函数名，以执行回调函数。
		 */
		 //dataType:json,
		/**
		 * (默认: 自动判断 (xml 或 html)) 请求失败时将调用此方法。
		 * 这个方法有三个参数：XMLHttpRequest 对象，错误信息，（可能）捕获的错误对象
		 */
		error:ajaxError,
		/**
		 * (默认: true) 是否触发全局 AJAX 事件。
		 * 设置为 false 将不会触发全局 AJAX 事件，
		 * 如 ajaxStart 或 ajaxStop 。可用于控制不同的Ajax事件
		 */
		global: true,
		/**
		 * (默认: false) 仅在服务器数据改变时获取新数据。
		 * 使用 HTTP 包 Last-Modified 头信息判断。
		 */
		ifModified: false,
		/**
		 * (默认: true) 默认情况下，发送的数据将被转换为对象(技术上讲并非字符串) 
		 * 以配合默认内容类型 "application/x-www-form-urlencoded"。
		 * 如果要发送 DOM 树信息或其它不希望转换的信息，请设置为 false。
		 */
		processData:true, 
		/**
		 * 请求成功后回调函数。这个方法有两个参数：服务器返回数据，返回状态
		 * function (data, textStatus)...
		 */
		//success: funciton//调用者自己传入
}
function ajaxComplete(xmlhttp, textStatus){
	if("success"!=textStatus){
		//如果不成功需要操作这里写入
	}
}
function ajaxError(xmlhttp, textStatus, errorThrown){
	alert(textStatus+" : "+errorThrown);
}
//与jquery整合的ajax
/**
 * 表单提交
 * formId 表单的id
 * sucFunc 成功的回调函数
 */
function xoxForm(url,formId,sucFunc){
	var datas = $("#"+formId).serialize();
	var xoxsettings = {
			url:url,
			data:datas,
			success:sucFunc,
			async:false,//表单提交一般用同步
	}
	ajaxSumbit(xoxsettings);
}


/**
 * 最终调用的方法
 * @param settings
 */
function ajaxSumbit(settings){
	//合并得到最后的参数设置
	var lastsettings = $.extend(ajaxdefault,settings);
	$.ajax(lastsettings);
}

