define(function(require, exports, module) {

	// 全局
	require('jquery');
	require("jquery-iCheck");
	require("bootstrap");
	require("bootstrap-prettyfile");
	require("jquery-validate");
	require("jquery-validate-messages_zh");
	//require("jquery-uploadPreview");
	
	// Bootstrap table
	require('bootstrap-table');
	require('bootstrap-table-zh-CN');
	require("laydate");
	require("wysiwyg-custom");
	require("bootstrap-imgsPreview");
	
	var commodity=require("commodityEdit");
	var commUtil = require('commUtil');
	
	
	$(function(){
		laydate({
            elem: '#startTime'
        });
		laydate({
            elem: '#expiryTime'
        });
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green'
        }); 
        
		var icon = "<i class='fa fa-times-circle'></i> ";
		$("#hotForm").validate({
			rules : {
				sortId : {
    				required : true
    			},
    			homeRecommended : {
    				required : true
    			}
			},
			messages : {
				
			},submitHandler:function(form){
				submitFrom();
	        }
		});
		  
        
    });
	
	function submitFrom(){
		
		if(!$.trim($("#commodityId").val())){
			swal({
				title : "失败",
				text : "请先选择商品",
				type : "error"
			});
			return;
		}
		var formData = new FormData($("#hotForm")[0]);
		commUtil.ajaxUtil.execute({
			url: basePath + "/commerce/hot/save",
			data: formData,
			/**   
             * 必须false才会避开jQuery对 formdata 的默认处理   
             * XMLHttpRequest会对 formdata 进行正确的处理   
             */  
            processData : false,  
            /**   
             *必须false才会自动加上正确的Content-Type   
             */  
            contentType : false,
			success: function(data) {
				if(data.flag=="Y"){
					swal({
						title : "成功",
						text : "保存成功",
						type : "success"
					},function(){
						commUtil.redirectUtil(
								basePath+"/commerce/hot/page",
								$("#id").val()
								);
					});
				}else{
                    swal("失败",data.message, "error");
				}
			}
		});
	}
})