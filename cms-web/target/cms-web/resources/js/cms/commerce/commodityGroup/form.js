define(function(require, exports, module) {

	// 全局
	require('jquery');
	require("jquery-iCheck");
	require("bootstrap");
	require("bootstrap-prettyfile");
	
	// Bootstrap table
	require('bootstrap-table');
	require('bootstrap-table-zh-CN');
	
	require("jquery-validate");
	require("jquery-validate-messages_zh");
	//require("jquery-uploadPreview");
	require("wysiwyg-custom");
	require("laydate");
	var commodity=require("commodityEdit");
	var commUtil = require('commUtil');
	
	$(document).ready(function () {
		$('#inStoreTable').bootstrapTable({
			url : basePath + "/commerce/inStore/search",
			queryParams: function(params) {
				params.id = $("#id").val();
				params.relativeId = $("#id").val();
				params.commodityId = $("#commodityId").val();
				params.type = 4;
				return params;
			}
		})
		
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green'
        });
        
        laydate({
            elem: '#startTime'
        });
        
        laydate({
            elem: '#expiryTime'
        });
    });
	
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#commodityGroupForm").validate({
		rules : {
			title : {
				required : true
			},
			sortId : {
				required : true
			},
			status : {
				required : true
			},
			homeRecommended : {
				required : true
			},
			singleSold : {
				required : true
			},
			numberPeople : {
				required : true
			},
			limits : {
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
	
	//添加库存,后台保存入库记录
	$("#addStock").on("click",function(){
		commUtil.ajaxUtil.execute({
			url: basePath + "/commerce/commodityGroup/inStore",
			data: {
				relativeId : $("#id").val(),
				commodityId : $("#commodityId").val(),
				stock : $("#stock").val()
			},
			success: function(data) {
				if(data.flag=="Y"){
					swal({
						title : data.message,
						type : "success"
					},function(){
						window.location.reload();
					});
				}else{
                    swal("失败",data.message, "error");
				}
			}
		});
	})
	
	//提交
	function submitFrom(){
		if(!$.trim($("#commodityId").val())){
			swal({
				title : "失败",
				text : "请先选择商品",
				type : "error"
			});
			return;
		}
		
		var formData = new FormData($("#commodityGroupForm")[0]);
		commUtil.ajaxUtil.execute({
			url: basePath + "/commerce/commodityGroup/save",
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
						title : data.message,
						type : "success"
					},function(){
						commUtil.redirectUtil(
								basePath+"/commerce/commodityGroup/page",
								$("#id").val()
								);
					});
				}else{
                    swal({
						title : data.message,
						type : "error"
					});
				}
			}
		});
	}
	
})