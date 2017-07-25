/**
 * 跳转工具类
 */
define(function(require,exports,module){
	require('jquery');
	var redirectUtil={
		defaults:{
			
		},
		redirect:function(url,id){
			if($.trim(id)&& id!="0"){
				window.location.reload();
			}else{
				window.location.href=url;
			}
		}
	};
	
	module.exports=function(url,id){
		/*
		if($.trim(id)&& id!="0"){
			window.location.reload();
		}else{
			window.location.href=url;
		}
		*/
		window.location.href=url;
	};
})