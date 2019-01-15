$(document).ready(function() {
	initMenu();
});
/**
 * 设置当前选中菜单
 */
function initMenu() {
	var pathName = location.pathname;
	if(pathName == "/admin/article/edit"){
		pathName = "/admin/article/new";
	}
	if(pathName == "/admin/category/edit"){
		pathName = "/admin/category";
	}
	if(pathName == "/admin/tag/edit"){
		pathName = "/admin/tag";
	}
	if(pathName == "/admin/links/edit"){
		pathName = "/admin/links";
	}
	if(pathName == "/admin/menus/edit"){
		pathName = "/admin/menus";
	}
	$(".app-menu").children().each(function() {
		var li = $(this);
		li.find('a').each(function() {
			var href = $(this).attr("href");
			if (pathName == href) {
				li.children().addClass("active").parent().addClass("is-expanded");
				$(this).addClass("active");
			} else {
				$(this).removeClass("active");
			}
		});
	});
}

/**http://view.jqueryfuns.com/%E9%A2%84%E8%A7%88%2D/2016/6/6/4acd3731999352ee27d3e4fb759f5dcc/
 *
 * warning
 * success
 * info
 * error
 * */
function showMsg(text, icon, hideAfter) {
	$.toast({
		text : text,
		heading : '提示',
		icon : icon,
		showHideTransition : 'slide',
		allowToastClose : true,
		hideAfter : hideAfter,
		stack : 5,
		position : 'top-center',
		textAlign : 'left',
		loader : true,
		loaderBg : '#2dadd2',
	});
}
//点击按钮以后设置按钮为不可点击，修改文字
function loadingText(btnId,text){
	 $("#"+btnId+"").attr("disabled","");
	 $("#"+btnId+"").text(text);
}
//回滚原本状态
function loadingBack(btnId,text){
	$("#"+btnId+"").removeAttr("disabled");
	$("#"+btnId+"").text(text);
}
