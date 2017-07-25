define(function(require, exports, module) {

	//加载jquery包
	require('jquery');
	//加载bootstrap包
	require("bootstrap");
	//加载弹出窗包
	require('sweetalert');
	//加载公共包
	var commUtil = require('commUtil');
	
	
	
	
	//页面加载完事件
	$(function(){
		var id=$("#id").val();
		//禁用按钮点击事件
		$("#disableBtn").click(function(){
			var title,text,type;
			if($("#disableBtn").data("status")=="0"){
				title="您确定要将这条信息禁用吗？";
				text="确定后将会把该信息禁用";
				type="warning";
			}else if($("#disableBtn").data("status")=="1"){
				title="您确定要将这条信息启用吗？";
				text="确定后将会把该信息启用";
				type="info";
			}
			swal({
				title : title,
				text : text,
				type : type,
				showCancelButton : true,
				confirmButtonColor : "#DD6B55",
				confirmButtonText : "确定",
				cancelButtonText : "取消",
				closeOnConfirm : false
			}, function(status) {
				if(status){
					commUtil.ajaxUtil.execute({
						url: basePath + "/market/audiovisual/setStatus",
						data: {
							id:id,
							status:$("#disableBtn").data("status")
						},success: function(data) {
							if(data.flag=="Y"){
								if($("#disableBtn").data("status")=="0"){
									$("#disableBtn").text("启用");
									$("#disableBtn").data("status","1");
									swal("禁用成功", "您已经禁用了这条信息。", "success");
									$("#status").text("禁用");
								}else if($("#disableBtn").data("status")=="1"){
									$("#disableBtn").text("禁用");
									$("#disableBtn").data("status","0");
									swal("启用成功", "您已经启用了这条信息。", "success");
									$("#status").text("启用");
								}
							}else{
		                        swal("失败",data.message, "error");
							}
						}
					});
				}
			});
		})
		
		//推荐主页按钮事件
		$("#recomBtn").click(function(){
			var title,text;
			if($("#recomBtn").data("ishome")=="0"){
				title="您确定要取消推荐到首页吗？";
				text="确定后将会取消推荐到首页";
			}else if($("#recomBtn").data("ishome")=="1"){
				
				title="您确定要推荐到首页吗？";
				text="确定后将会推荐到首页";
			}
			swal({
				title : title,
				text : text,
				type : "info",
				showCancelButton : true,
				confirmButtonColor : "#DD6B55",
				confirmButtonText : "确定",
				cancelButtonText : "取消",
				closeOnConfirm : false
			}, function(status) {
				if(status){
					commUtil.ajaxUtil.execute({
						url: basePath + "/market/audiovisual/recommendAudiovisual",
						data: {
							id:id,
							isHome:$("#recomBtn").data("ishome")
						},success: function(data) {
							if(data.flag=="Y"){
								if($("#recomBtn").data("ishome")=="0"){
									$("#recomBtn").text("推荐到首页");
									$("#recomBtn").data("ishome","1");
									swal("操作成功", "您已经取消推荐到首页。", "success");
								}else if($("#recomBtn").data("ishome")=="1"){
									$("#recomBtn").text("取消推荐到首页");
									$("#recomBtn").data("ishome","0");
									swal("操作成功", "您已经推荐到首页。", "success");
								}
							}else{
		                        swal("失败",data.message, "error");
							}
						}
					});
				}
			});
		})
		
	});
});
