/**
 * 表单验证辅助类
 */
define(function(require,exports,module){
	require('jquery');
	var validateUtil={
			defaults:{
				
			},
			file:function(){
				var result=false;
				if($.trim($("#id").val())){
					
				}else{
					$(".form-horizontal:input[type='file']").each(function(i,e){
						
						
					})
				}
				return result;
			}
		};
	module.exports=validateUtil;
})