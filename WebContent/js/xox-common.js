(function($) {
	$(document).ready(function($) {
		$("#switch-ul").find("li").on("mouseover",function(){
			$("#switch-ul").find("li").each(function(){
				$(this).removeClass("current");
			});
			$(this).addClass("current");
		});
	});
})(jQuery);