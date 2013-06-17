(function($) {
	$(document).ready(function($) {
		$("#switch-ul").find("li").on("mouseover",function(){
			$("#switch-ul").find("li").each(function(){
				$(this).removeClass("current");
			});
			$(this).addClass("current");
		});
		//右侧返回顶部按钮
		$("#xox-slide").find("a").on("mouseover",function(){
			$(this).css({
				'background': 'url(../image/bg/xox-slider.png) 0 0 no-repeat'
			});
		});
		$("#xox-slide").find("a").on("mouseout",function(){
			$(this).css({
				'background': 'url(../image/bg/xox-slider.png) -40px 0 no-repeat'
			});
		});
		$("#side-a").on("click",function(){
			scroll(0,0);
		});
	});
})(jQuery);