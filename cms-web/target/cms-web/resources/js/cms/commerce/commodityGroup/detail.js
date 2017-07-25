define(function(require, exports, module) {

	// 全局
	require('jquery');
	require("bootstrap");
	require("jquery-iCheck");
	require("wysiwyg-custom");
	require("laydate");
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
	
	$("#toCommodityGroupUser").click(function(){
		location.href = basePath + "/commerce/commodityGroup/toCommodityGroupUserPage?commodityGroupId="+$(this).data("id");
	})
	
	$("#toEdit").click(function(){
		location.href = basePath + "/commerce/commodityGroup/toEdit?id="+$(this).data("id");
	})

})