define(function(require, exports, module) {

	// 全局
	require('jquery');
	require("jquery-iCheck");
	require("bootstrap");
	require("bootstrap-prettyfile");
	require("jquery-validate");
	require("jquery-validate-messages_zh");
	//require("jquery-uploadPreview");
	require("wysiwyg-custom");
	require("laydate");
	var commodity=require("commodityEdit");
	var commUtil = require('commUtil');
	$('#description').wysiwyg();	//商品说明
	$('#purchaseNotes').wysiwyg();	//购买须知
	$('#distribution').wysiwyg();	//配送说明
	
	
	
	$(document).ready(function () {
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green'
        });
        
    });
})