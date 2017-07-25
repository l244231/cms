define(function(require, exports, module) {

	// 全局
	require('jquery');
	require("jquery-iCheck");
	require("bootstrap");
	require("bootstrap-select");
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
		$('#description').wysiwyg();	//商品说明
		$('#purchaseNotes').wysiwyg();	//购买须知
		$('#distribution').wysiwyg();	//配送说明
		
		$("#description").focus(function(){
			if($("#description").html().trim()=="请输入商品说明"){
				$("#description").html("");
			}
		})
		$("#description").blur(function(){
			if($("#description").html().trim()==""){
				$("#description").html("请输入商品说明");
			}
		})
		$("#purchaseNotes").focus(function(){
			if($("#purchaseNotes").html().trim()=="请输入购买须知"){
				$("#purchaseNotes").html("");
			}
		})
		$("#purchaseNotes .initializeFont").blur(function(){
			if($("#purchaseNotes").html().trim()==""){
				$("#purchaseNotes").html("请输入购买须知");
			}
		})
		
		$('#imgFile').prettyFile({
			format:[ "gif", "jpeg", "jpg", "bmp", "png" ],
			showImg:true,
			imgData:{
				imgObjId: "ImgPr",
				width:300,
				height:300
			}
		});
		
		$('#imgMultipleFile').prettyFile({
			format:[ "gif", "jpeg", "jpg", "bmp", "png" ],
			showImg:true,
			text:"选择图片(多选)",
			buttonId:"addCommodity",
			imgData:{
				imgObjId: "showImgDiv",
				width:100,
				height:100
			}
		});
		//图片删除按钮事件
		$(".thumbnailClose").click(function(){
			var thumbnailClose = $(this);
			var fileId = thumbnailClose.data("imgid");
			 swal({
                 title: "您确定删除该图片？",
                 type: "warning",
                 showCancelButton: true,
                 confirmButtonColor: "#DD6B55",
                 confirmButtonText: "删除",
                 cancelButtonText: "取消",
                 closeOnConfirm: false,
                 timer: 5000
             },
             function(status) {
            	 if(status){
            		 commUtil.ajaxUtil.execute({
          				url: basePath + "/commerce/binaryFile/del",
          				data: {id : fileId},
          				success: function(data) {
          					if(data.flag=="Y"){
          						thumbnailClose.parent().parent("div:eq(0)").remove();
          					}
          					swal.close();
          				}
          			});
            	 }
             });
		})
		
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green'
        });
        var icon = "<i class='fa fa-times-circle'></i> ";
    	var commodityForm=$("#commodityForm").validate({
    		rules : {
    			name : {
    				required : true
    			},
    			sortId : {
    				required : true
    			},
    			shortName : {
    				required : true
    			},
    			status : {
    				required : true
    			},
    			storeId: {
    				required : true
    			},
    			categoryId : {
    				required : true
    			},
    			currentPrice : {
    				required : true
    			},
    			price : {
    				required : true
    			},
    			specName : {
    				required : true
    			},
    			stock : {
    				required : true
    			}
    		},
    		messages : {

    		},submitHandler:function(form){
    			if(validateFile()){
    				submitFrom();
    			}
            }
    	});
    	function validateFile(){
    		if($("#isEdit").val()=="false"){
    			if($("#imgFile")[0].files.length<=0){
    				swal({
    					title : "警告",
    					text : "商品图片不能为空",
    					type : "warning"
    				})
    				return false;
    			}
    			
    			if($("#imgMultipleFile")[0].files.length<=0){
    				swal({
    					title : "警告",
    					text : "商品列表图不能为空",
    					type : "warning"
    				})
    				return false;
    			}
    			
    		}
    		return true;
    	}
    	//下拉树图数据加载
    	commUtil.ajaxUtil.execute({
			url: basePath + "/commerce/commodity/getCommodityCategory",
			loading:false,
			success: function(data) {
				var parentArr=[];
				var nodeArr=[];
				$.each(data,function(index,item){  
			    	if(item.parentId==0){
			    		parentArr.push(item);
			    	}else{
			    		nodeArr.push(item);
			    	}
			    });
				
				$.each(parentArr,function(i,p){ 
					var $optgroup=$("<optgroup label='"+p.name+"'></optgroup>");
					//p.nodes=[];
					$.each(nodeArr,function(j,n){  
				    	if(n.parentId==p.id){
				    		//p.nodes.push(n);
				    		$optgroup.append("<option value='"+n.id+"'>"+n.name+"</option>");
				    	}
				    });
					$("#categoryId").append($optgroup);
			    });
				/*$.each(parentArr,function(i,p){
					var $optgroup=$("<optgroup label='"+p.name+"'></optgroup>");
					$.each(p.nodes,function(j,n){
						
					})
					$("#categoryId").append();
				})*/
				$('#categoryId').selectpicker('refresh');
				$('#categoryId').selectpicker('val', $('#categoryId').data("value"));
				//下拉树图点击事件，激活下拉框的验证
				$('#categoryId').on('changed.bs.select', function (e) {
					 setTimeout(function(){
						 $("#categoryId").valid();
					 },300);
				});
			}
		});
    	//添加库存
    	$("#addStock").on("click",function(){
			commUtil.ajaxUtil.execute({
				url: basePath + "/commerce/commodity/inStore",
				data: {
					relativeId : $("#id").val(),
					commodityId : $("#id").val(),
					stock : $("#stock").val()
				},
				success: function(data) {
					if(data.flag=="Y"){
						swal({
							title : "成功",
							text : "操作成功",
							type : "success"
						},function(){
							location.href=basePath+"/commerce/commodity/toEdit?id="+$("#id").val();
						});
					}else{
	                    swal("失败",data.message, "error");
					}
				}
			});
		});
    	//库存列表查询
    	$('#inStoreTable').bootstrapTable({
			url : basePath + "/commerce/inStore/search",
			queryParams: function(params) {
				params.id = $("#id").val();
				//params.relativeId = $("#id").val();
				params.commodityId = $("#id").val();
				params.type = 1;
				return params;
			}
		}) ;
    	//添加人气
    	$("#addPopular").on("click",function(){
			commUtil.ajaxUtil.execute({
				url: basePath + "/commerce/commodity/updateSaleAndPopularity",
				data: {
					id : $("#id").val(),
					popularity : $("#popularity").val()
				},
				success: function(data) {
					if(data.flag=="Y"){
						swal({
							title : "成功",
							text : "操作成功",
							type : "success"
						},function(){
							location.href=basePath+"/commerce/commodity/toEdit?id="+$("#id").val();
						});
					}else{
	                    swal("失败",data.message, "error");
					}
				}
			});
		});
    	//添加销量
    	$("#addSales").on("click",function(){
			commUtil.ajaxUtil.execute({
				url: basePath + "/commerce/commodity/updateSaleAndPopularity",
				data: {
					id : $("#id").val(),
					sale : $("#sale").val()
				},
				success: function(data) {
					if(data.flag=="Y"){
						swal({
							title : "成功",
							text : "操作成功",
							type : "success"
						},function(){
							location.href=basePath+"/commerce/commodity/toEdit?id="+$("#id").val();
						});
					}else{
	                    swal("失败",data.message, "error");
					}
				}
			});
		});
    	
    });
	
	function submitFrom(){
		//debugger;
		$("input[name='description']").val($('#description').wysiwyg("getEditor"));
		$("input[name='purchaseNotes']").val($('#purchaseNotes').wysiwyg("getEditor"));
		$("input[name='distribution']").val($('#distributionText').val());
		var specData = commodity.getSpecs();
		var colorData = commodity.getColors();
		var formData = new FormData($("#commodityForm")[0]);
		if($("#imgMultipleFile")[0].files.length<=0){
			formData.delete("imgMultipleFile");
		}
		if($("#imgFile")[0].files.length<=0){
			formData.delete("imgFile");
		}
		
		formData.append("specData",specData);
		formData.append("colorData",colorData);
		
		commUtil.ajaxUtil.execute({
			url: basePath + "/commerce/commodity/save",
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
								basePath+"/commerce/commodity/page",
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