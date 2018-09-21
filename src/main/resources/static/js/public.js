/**http://view.jqueryfuns.com/%E9%A2%84%E8%A7%88%2D/2016/6/6/4acd3731999352ee27d3e4fb759f5dcc/
 *
 * warning
 * success
 * info
 * error
 * */
function showMsg(text,icon,hideAfter){
	$.toast({
	    text: text, 
	    heading: '提示', 
	    icon: icon, 
	    showHideTransition: 'slide', 
	    allowToastClose: true, 
	    hideAfter: hideAfter, 
	    stack: 5,
	    position: 'top-center', 
	    textAlign: 'left', 
	    loader: true,  
	    loaderBg: '#2dadd2',  
	});
}
