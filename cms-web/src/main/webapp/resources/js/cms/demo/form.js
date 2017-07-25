define(function(require, exports, module) {

	// 全局
	require('jquery');
	require("jquery-iCheck");
	require("bootstrap");
	require("bootstrap-prettyfile");
	require("jquery-validate");
	require("jquery-validate-messages_zh");
	//require("jquery-uploadPreview");
	require("laydate");
	require("wysiwyg-custom");
	require("bootstrap-imgsPreview");
	var commUtil = require('commUtil');
	
	
	$('#description').wysiwyg();
	$('#purchaseNotes').wysiwyg();
	$('#distribution').wysiwyg();
	
	$('#imgFile').prettyFile({
		format:[ "gif", "jpeg", "jpg", "bmp", "png" ],
		showImg:true,
		imgData:{
			imgObjId: "imgPr",
			width:200,
			height:200
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
	
	$(document).ready(function () {
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
    });
	/*var icon = "<i class='fa fa-times-circle'></i> ";
	$("#brandForm").validate({
		rules : {
			title : {
				required : true,
				minlength : 2
			},
			seq : {
				required : true
			},
			type : {
				required : true
			},
			file_videoFile : {
				required : true
			},
			ccomment : {
				required : true
			}
		},
		messages : {
			title : {
				required : icon + "请输入标题",
				minlength : icon + "至少2位"
			},
			seq : icon + "请输入排序",
			type : {
				required : icon + "请选择类型"
			},
			file_videoFile : {
				required : icon + "请选择文件"
			},
			ccomment : {
				required : icon + "请输入介绍"
			}
		}
	});*/
})