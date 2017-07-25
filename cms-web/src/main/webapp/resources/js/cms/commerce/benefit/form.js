define(function(require, exports, module) {

	// 全局
	require('jquery');
	require("jquery-iCheck");
	require("bootstrap");
	require("bootstrap-prettyfile");
	//require("bootstrap-select");
	require("jquery-validate");
	require("jquery-validate-messages_zh");
	
	// Bootstrap table
	require('bootstrap-table');
	require('bootstrap-table-zh-CN');
	//require("jquery-uploadPreview");
	require("laydate");
	require("wysiwyg-custom");
	require("bootstrap-imgsPreview");
	
	var commodity=require("commodityEdit");
	var commUtil = require('commUtil');
	
	
	$(function(){
		$('#inStoreTable').bootstrapTable({
			url : basePath + "/commerce/inStore/search",
			queryParams: function(params) {
				params.id = $("#id").val();
				params.relativeId = $("#id").val();
				params.commodityId = $("#commodityId").val();
				params.type = 5;
				return params;
			}
		})
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
        
       //编辑时添加库存按钮事件
       $("#addStock").click(function(){
    	   
       })
        
		var icon = "<i class='fa fa-times-circle'></i> ";
		$("#benefitForm").validate({
			rules : {
				status : {
    				required : true
    			},
    			sortId : {
    				required : true
    			},
    			singleSold : {
    				required : true
    			},
    			homeRecommended : {
    				required : true
    			},
    			startTime : {
    				required : true
    			},
    			expiryTime : {
    				required : true
    			},
    			price : {
    				required : true
    			},
    			stock : {
    				required : true
    			}
			},
			messages : {
				
			},submitHandler:function(form){
				submitFrom();
	        }
		});
		
		$("#addStock").on("click",function(){
			commUtil.ajaxUtil.execute({
				url: basePath + "/commerce/benefit/inStore",
				data: {
					relativeId : $("#id").val(),
					commodityId : $("#commodityId").val(),
					stock : $("#stock").val()
				},
				success: function(data) {
					if(data.flag=="Y"){
						swal({
							title : "成功",
							text : "操作成功",
							type : "success"
						},function(){
							window.location.reload();
						});
					}else{
	                    swal("失败",data.message, "error");
					}
				}
			});
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
		
		var formData = new FormData($("#benefitForm")[0]);
		commUtil.ajaxUtil.execute({
			url: basePath + "/commerce/benefit/save",
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
								basePath+"/commerce/benefit/page",
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