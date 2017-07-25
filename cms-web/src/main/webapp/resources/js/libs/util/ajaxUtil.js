/**
 * ajax工具类
 */
define(function(require,exports,module){
	require('jquery');
	require('jquery-loading');
	//require("bootstrap");
	var ajaxUtil={
		execute:function(opt){
			var defaults = {
				type : "POST",
				dataType : "json",
				async : true,
				processData:true,
				contentType : "application/x-www-form-urlencoded;charset=UTF-8",
				url:"",
				data:{},
				success:undefined,
				error:undefined,
				loading:true,
				loadingOption:{text:"加载中"}
			};
		
			var options =  $.extend(defaults, opt);
			if(options.loading){
				$(window.top.document).find("body").jqLoading(options.loadingOption);
			}
			
			//$('#loadingModal').modal('show');
			setTimeout(function(){
				$.ajax({
					type : options.type,
					dataType : options.dataType,
					async : options.async,
					url : options.url,
					data : options.data,
					processData:options.processData,
					contentType:options.contentType,
					success : function(result) {
						if(typeof options.success === 'function'){
							options.success(result);
						}
					},
					error:function (XMLHttpRequest, textStatus, errorThrown){ 
						if(typeof options.error === 'function'){
							options.error(XMLHttpRequest, textStatus, errorThrown);
						}
					},beforeSend: function(){
						
				    },
				    complete: function(){
				    	/**/
				    	if(options.loading){
				    		$(window.top.document).find("body").jqLoading("destroy");
						}
				    	//$('#loadingModal').modal('hide');
				    }
				});
	    	},0);
			
		}
	}
		
	module.exports=ajaxUtil;
})
