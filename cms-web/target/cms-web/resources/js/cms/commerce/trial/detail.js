define(function(require, exports, module) {

	// 全局
	require('jquery');
	require("bootstrap");
	require("jquery-iCheck");
	require("wysiwyg-custom");
	var commUtil = require('commUtil');
	
	$(document).ready(function () {
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });
	
	$("#inStoreDetail").on("click",function(e){
	});
	
//	commUtil.ajaxUtil.execute({
//		url: basePath + "/commerce/commodityGroup/getImgByid",
//		data: {
//			id: 215
//		},
//		success: function(data) {
//			$("#ImgPr").attr("src",data);
//		}
//	});

})