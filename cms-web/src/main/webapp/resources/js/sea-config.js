seajs.config({
	base: basePath+"/resources/js",
	alias: {
	//jquery
		"jquery": "jquery.min",
		"jquery-cookie": "jquery.cookie",
		//jquery验证
		"jquery-validate":"plugins/validate/jquery.validate",
		"jquery-validate-messages_zh":"plugins/validate/messages_zh.min.js",
		//jquery在线预览图片
		"jquery-uploadPreview":"plugins/uploadPreview/jquery.uploadPreview",
		//jquery checkbox复选框
		"jquery-iCheck":"plugins/iCheck/icheck.min",
		//jquery.键盘监控
		"jquery-hotkeys":"plugins/bootstrap-wysiwyg/external/jquery.hotkeys",
		"jquery-metisMenu":"plugins/metisMenu/jquery.metisMenu",
		"jquery-slimscroll":"plugins/slimscroll/jquery.slimscroll.min",
		"jquery-loading":"plugins/loading/jquery.loading",
	//bootstrap
		"bootstrap":"bootstrap.define",
		"bootstrap-table":"plugins/bootstrap-table/bootstrap-table",
		"bootstrap-table-zh-CN":"plugins/bootstrap-table/locale/bootstrap-table-zh-CN",
		//图片上传控件+图片在线预览，（上面的在线预览已经整合再一起）
		"bootstrap-prettyfile":"plugins/prettyfile/bootstrap-prettyfile",
		//图片上传控件+图片在线预览 (多)
		"bootstrap-imgsPreview":"plugins/imgsPreview/bootstrap-imgsPreview",
		//富文本框
		"bootstrap-wysiwyg":"plugins/bootstrap-wysiwyg/bootstrap-wysiwyg",
		//下拉菜单框
		"bootstrap-select":"plugins/bootstrap-select/bootstrap-select",
		//时分选择器
		"bootstrap-clockpicker":"plugins/bootstrap-clockpicker/bootstrap-clockpicker",
	//日期插件
		"laydate":"plugins/layer/laydate/laydate",
	//弹出框插件
		"sweetalert":"plugins/sweetalert/sweetalert.min",
	//libs
		"commUtil":"libs/commUtil",
		"ajaxUtil":"libs/util/ajaxUtil",
		"dateUtil":"libs/util/dateUtil",
		"inputUtil":"libs/util/inputUtil",
		"redirectUtil":"libs/util/redirectUtil",
		"validateUtil":"libs/util/validateUtil",
	//js插件
		//弹出层插件
		"layer":"plugins/layer/layer",
		"pace":"plugins/pace/pace.min",
	//自定义
		"content":"content",
		//侧边菜单栏
		"menus":"libs/cms/menus",
		"commodityEdit":"libs/cms/commodityEdit",
		//富文本框整合包
		"wysiwyg-custom":"plugins/bootstrap-wysiwyg/wysiwyg-custom"
	}
});