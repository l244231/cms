seajs.config({
	base: basePath+"/resources/js",
	alias: {
	//jquery
		"jquery": "jquery.min",
		//jquery验证
		"jquery-validate":"plugins/validate/jquery.validate.min.js",
		"jquery-validate-messages_zh":"plugins/validate/messages_zh.min.js",
		//jquery在线预览图片
		"jquery-uploadPreview":"plugins/uploadPreview/jquery.uploadPreview",
	//bootstrap
		"bootstrap":"bootstrap.define",
		"bootstrap-table":"plugins/bootstrap-table/bootstrap-table",
		"bootstrap-table-zh-CN":"plugins/bootstrap-table/locale/bootstrap-table-zh-CN",
		"bootstrap-prettyfile":"plugins/prettyfile/bootstrap-prettyfile",
	//自定义
		"content":"content"
	}
});