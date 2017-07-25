define(function(require, exports, module) {

	// 全局
	require('jquery');
	require("bootstrap");
	require("bootstrap-prettyfile");
	require("jquery-validate");
	require("jquery-validate-messages_zh");
	require('sweetalert');
	
	var commUtil = require('commUtil');
	
	$(function(){
		$('#imgFile').prettyFile({
			format:[ "gif", "jpeg", "jpg", "bmp", "png" ],
			showImg:true,
			imgData:{
				imgObjId: "ImgPr",
				width:300,
				height:300
			}
		});
		$('#videoFile').prettyFile({
			format:[ "mp3", "mp4"]
		});
		
		
		//表单验证
		var icon = "<i class='fa fa-times-circle'></i> ";
		$("#audiovisualForm").validate({
			rules : {
				/*file_imgFile:{
					required : true
				},*/
				title : {
					required : true
				},
				sort : {
					required : true
				},
				content:{
					required : true
				}
				/*file_videoFile : {
					required : true
				},*/ 
			},
			messages : {
				
			},submitHandler:function(form){
				submitFrom();
	        }
		});
		
		/*//表单提交
		$("#saveBut").click(function(){
			$("#audiovisualForm").validate({
		        submitHandler:function(form){
		            alert("提交事件!");   
		            //form.submit();
		        }    
		    });
		})*/
	});
	
	function submitFrom(){
		var formData = new FormData($("#audiovisualForm")[0]);
		if($("#imgFile")[0].files.length<=0){
			formData.delete("imgFile");
		}
		if($("#videoFile")[0].files.length<=0){
			formData.delete("videoFile");
		}
		commUtil.ajaxUtil.execute({
			async : true,
			url: basePath + "/market/audiovisual/save",
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
            loadingOption:{text:"上传中..."},
			success: function(data) {
				if(data.flag=="Y"){
					swal({
						title : "成功",
						text : "保存成功",
						type : "success"
					},function(){
						commUtil.redirectUtil(
								basePath+"/market/audiovisual/page",
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