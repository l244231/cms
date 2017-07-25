define(function(require,exports,module){
	
	//全局
	require('jquery');
	require("bootstrap");
	require("bootstrap-prettyfile");
	require("jquery-validate");
	require("jquery-validate-messages_zh");
	require("jquery-uploadPreview");
	
	$( '#audiovisualForm input[type="file"]' ).prettyFile();
	
	$("#myfile").uploadPreview({ 
		Img: "ImgPr",
		Width: 300,
		Height: 300,
		ImgType: ["gif", "jpeg", "jpg", "bmp", "png"], 
		Callback: function () {
			
	}});
	var icon = "<i class='fa fa-times-circle'></i> ";
    $("#audiovisualForm").validate({
        rules: {
            title: {
                required: true,
                minlength: 2
            },
            seq: {
                required: true
            },
            type: {
                required: true
            },
            file_uploadFile: {
                required: true
            },
            ccomment: {
                required: true
            }
        },
        messages: {
        	title: {
                required: icon + "请输入标题",
                minlength: icon + "至少2位"
            },
        	seq: icon + "请输入排序",
        	type: {
                required: icon + "请选择类型"
            },
            file_uploadFile: {
                required: icon + "请选择文件"
            },
            ccomment: {
                required: icon + "请输入介绍"
            }
        }
    });
})