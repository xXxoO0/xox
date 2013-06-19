//简单弹出框 插件
"use strict";//启用严格模式 ie6-9不支持
(function($) {
	//定义一个弹出框类
	var myDiv = {
		//初始化方法
		init : function($div,settings){
			$div.css({
				'width':settings.width,
				'background-color': settings.bgcolor,
				'z-index':900,
				'position':'fixed'
			});
			$(".op-title").css({
				'width':settings.width+6
			});
			$(".oppanel").css({
				'height':settings.oppanel_height
			});
			var $top = ($(window).height() - $div.outerHeight()) / 2; 
			var $left = ($(window).width() - $div.outerWidth()) / 2; 
			var cssStr = {
					top : $top,
					left : $left
			}; 
			$div.css(cssStr);	
		},
	};
	//打开弹出框
	$.fn.openMyDiv = function(s){
		//默认值
		var defaults ={
			width         :  500,
			oppanel_height :300,//内部内容大小
			scrolling     :  true,
		    container     :  window,//弹出框所在的容器
		    minX          :  20,//靠左边最小位置
		    minY          :  20,//靠上边最小位置
			bgcolor       :  '#fff'//背景颜色
		};
		var settings = $.extend({},defaults,s);
		var $div = this;
		var init = function(){
			myDiv.init($div,settings);
		}
		var openDiv = function(){
			//显示遮罩层
			showBg(settings);
			init();
			$div.show();
		}
		var showBg = function(settings){
			if($("#laying").length>0){
				$("#laying").show();
			}else{
				$("body").append("<div id='laying'></div>");
				var cssStr = {
						'height' :$(document).height(),
						'width' : $(document).width(),
						'top':'0px',
						'left':'0px',
						'position':'fixed',
						'filter':'alpha(opacity=40)',
						'background':'#33393C',
						'z-index':899,
						'opacity' :'0.40'
						//'display':'none'
				};
				$("#laying").css(cssStr);
			}
		}
		openDiv();
	};
	//关闭弹出框
	$.fn.closeMyDiv = function(){
		var $div = this;
		var closeDiv = function(){
			$div.hide();
			$("#laying").hide();
		}
		closeDiv();
	};
})(jQuery);

/*
//使用方法
<button type="button" id="btn">弹出</button>
<div id="open_login_div"  style="display:none;">
		//公共部分
		<div class="corner">
			<span class="tl"></span>
			<span class="tr"></span>
			<span class="br"></span>
			<span class="bl"></span>
		</div>
		<div class="oppanel">
			<div class="op-title"><h2>登录(自定义)</h2>
			<em class="close" id="close"></em>
			</div>
			//公共部分end
			//自定义内容beigin
			<dl class="formset">
			<dt>用户名或邮箱:</dt>
			<dd><input type="text" value="" name="username"></dd>
			<dt>密码:</dt>
			<dd><input type="password" value="" name="password"></dd>
			<dd class="button"><input class="main" type="submit" value="登录"></dd></dl>
		</div>
		//内容end
</div>
</div>
$(document).ready(function($){
	$('#btn').live('click',function(){
		$('#open_login_div').openMyDiv();
	});
	$('#close').live('click',function(){
		$('#open_login_div').closeMyDiv();
	});
});
 */
