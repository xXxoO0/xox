<%@ page language="java" contentType="text/html;charset=UTF-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script  src="/js/jquery-1.7.2.min.js"></script>
<script  src="/js/ajax_xox.js"></script>
<script>
function ajaxtest1(){
	/*
	doAjaxGet("/test/ajax/test1",true,function(){
		if(xmlhttp.readyState==4 && xmlhttp.status==200){
			alert(xmlhttp.responseText);
		}
	});
	doAjaxPost("/test/ajax/test2",true,function(){
		if(xmlhttp.readyState==4 && xmlhttp.status==200){
			alert(xmlhttp.responseText);
		}
	});
	doAjaxPost("/test/ajax/test2",true,function(){
		if(xmlhttp.readyState==4 && xmlhttp.status==200){
			alert(xmlhttp.responseText);
		}
	},"name=哈啊哈");
	
	doAjaxPost("/test/ajax/test3",true,function(){
		if(xmlhttp.readyState==4 && xmlhttp.status==200){
			alert(xmlhttp.responseText);
		}
	},"userName=哈啊哈&password=zw");
	//如果用了jquery可以这样
	var params = $("#form1").serialize();
	doAjaxPost("/test/ajax/test3",true,function(){
		if(xmlhttp.readyState==4 && xmlhttp.status==200){
			alert(xmlhttp.responseText);
		}
	},params);*/
}
//jquery ajax例子
function ajaxtest2(){
	ajaxForm("/test/ajax/test3","form1",function(data, textStatus){
		alert(data);
	});
}
//远程获取下拉框例子
function ajaxtest3(){
	/*
	ajaxSelect("/test/ajax/test4",function(data){
		var sel = $("#test");
		var val = $("#test").val();
		sel.empty();
		$.each(data,function(i,s){
			if(s.userName==val){
				sel.append("<option value="+s.userName+" selected>"+s.password+"</option>")
			}else{
				sel.append("<option value="+s.userName+">"+s.password+"</option>")
			}
		});
	});
	*/
}
	
	
</script>
</head>
<body>
测试普通ajax返回string类型
<button onclick="ajaxtest1()">点我测试</button>
<button onclick="ajaxtest2()">点我测试ajax整合jquery表单提交</button>
<form id="form1" action="/test/ajax/test3" method="post">
<input type="text"  name="userName"  value=""/>
<input type="password"  name="password"  value=""/>
<input type="submit" value="提交" />
</form>
<button onclick="ajaxtest3()">点我测试json下拉框</button>
<select id="test"></select>
</body>
</html>