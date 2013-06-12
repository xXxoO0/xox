//简单图片轮转插件
"use strict";//启用严格模式 ie6-9不支持
(function($) {
	$.fn.switchImage = function(initsettings){
		var defaultsetting = {
				'width':600,
		        'height':300,
		        'changeTime' : 5,
		        'bgheight':30,
		        'bgwidth':582
		};
		var settings = $.extend({},defaultsetting,initsettings);
		var $container = this;
		var $indexShow = $container.find("#index_show");
		var $imgBottom = $container.find("#imgBottom");
		var $indexShowOl = $indexShow.find("ol");
		var $indexShowLi = $indexShowOl.find("li");
		var $indexShowLi = $indexShowLi.find("a");
		//用于计算index的参数
		var num=1;
		var init = function(){
			css_init();
			img_init();
		};
		var css_init = function(){
			$container.addClass("img-box");
			$container.css({
				'height':settings.height,
				'width':settings.width
			});
			$indexShow.addClass("img-show");
			$indexShow.css({
				'height':settings.height-10,
				'width':settings.width-10
			});
			$indexShowOl.addClass("img-show-ol");
			$indexShowOl.css({
				'height':settings.height-18,
				'width':settings.width-18
			});
			//处理每个
			$indexShowOl.find("li").each(function(){
				$(this).addClass("img-show-li");
				$(this).css({
					'height':settings.height-18,
					'width':settings.width-18
				});
				var showA = $(this).find("a");
				showA.addClass("img-show-a");
				var showImg = showA.find("img");
				showImg.addClass("img-show-img");
				showImg.css({
					'height':settings.height-18,
					'width':settings.width-18
				});
			});
			$imgBottom.addClass("img-show-bt");
			$imgBottom.css({
				'top':settings.height-settings.bgheight-9,
				'height':settings.bgheight,
				'width':settings.bgwidth
			});
			$(".img_bt_ul").css({
				'top':settings.height-37,
				'width':settings.width-18,
				'height':25
			});
		};
		var changeP = function(){
			num = this.id.split("_")[1];
			changeImg(num);
		}
		var img_init = function(){
			//底部右侧小圆点变化添加时间
			$(".img_bt_li_right").find("p").each(function(i){
				$(this).attr("id","p_"+(i+1));
				$(this).bind("mouseover",changeP);
			});
			//开始轮播
			window.setInterval(function(){
				changeImg(num);
				num++;
				if(num>$indexShowOl.find("li").length){
					num=1;
				}
            },settings.changeTime*1000);

		};
		var changeImg = function(num){
			//图片变化
			$indexShowOl.find("li").each(function(i){
				$(this).removeClass("img-li-normal");
				$(this).removeClass("img-li-current");
				if(i+1==num){
					$(this).addClass("img-li-current");
				}else{
					$(this).addClass("img-li-normal");
				}
			});
			//底部左侧文字变化
			$(".img_bt_li_left").find("span").each(function(i){
				$(this).removeClass("img_span_current");
				$(this).removeClass("img_span_normal");
				if(i+1==num){
					$(this).addClass("img_span_current");
				}else{
					$(this).addClass("img_span_normal");
				}
			});
			//底部右侧小圆点变化
			$(".img_bt_li_right").find("p").each(function(i){
				$(this).removeClass("img_p_off");
				$(this).removeClass("img_p_on");
				if(i+1==num){
					$(this).addClass("img_p_on");
				}else{
					$(this).addClass("img_p_off");
				}
			});
		}
		init();
	};
})(jQuery);