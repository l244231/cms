define(function(require, exports, module) {

	// 全局
	require('jquery');
	require('jquery-cookie');
	require("bootstrap");
	//require("bootstrap-select");
	// Bootstrap table
	require('bootstrap-table');
	require('bootstrap-table-zh-CN');
	require('sweetalert');
	var commUtil = require('commUtil');
	$.setPageCookie("audiovisualPage",isBack);
	$('#audiovisualTable')
			.bootstrapTable(
					{
						url : basePath + "/market/audiovisual/search",
						// search: true,
						pagination : true,
						// showRefresh: true,
						// showToggle: true,
						sidePagination : "server",
						showColumns : true,
						sortable : true,
						showAddBut : true,
						silentSort:false,//设置为 false 将在点击分页按钮时，自动记住排序项。
						addButEvent : function(e) {
							location.href = basePath
									+ "/market/audiovisual/add";
						},
						showQueryBut : true,
						queryButEvent : function(e) {
							$('#audiovisualTable').bootstrapTable("refresh");
						},
						pageList : [ 5, 10, 20, 50],
						pageNumber : 1, // 初始化加载第一页，默认第一页
						pageSize : 10, // 每页的记录行数（*）
						toolbar : '#audiovisualTableToolbar',
						icons : {
							refresh : 'glyphicon-repeat',
							toggle : 'glyphicon-list-alt',
							columns : 'glyphicon-list'
						},
						queryParams : function(params) {
							params.keyWord = $("#keyWord").val();
							params.type = $("#type").val();
							params.isHome = $("#isHome").val();
							$.cookie("audiovisualPage",JSON.stringify(params));
							return params;
						},
						columns : [
								{
									field : "seq",
									title : "序号",
									width: 50,
									formatter : function(value, row, index,
											that) {
										var seq = index + 1;
										seq = seq
												+ (that.options.pageNumber - 1)
												* that.options.pageSize;
										return seq;
									}
								},
								{
									field : "title",
									title : "标题",
									sortable : true
								},
								{
									field : "sort",
									title : "排序",
									sortable : true,
									width : 80
								},
								{
									field : "fileType",
									title : "类型",
									sortable : true,
									width : 80
								},
								{
									field : "isHome",
									title : "推荐到首页",
									width : 120,
									sortable : true,
									formatter:function(value,row,index){
										var str = ""; 
										if(value =="0"){
											str="推荐到首页"
										}else{
											str="取消推荐";
										}
											
									return "<a href='#' onclick='recommendAudiovisual(\""+row.id+"\",\""+value+"\")'>"+str+"</a>";
									}
								},
								{
									field : "createDate",
									title : "创建时间",
									sortable : true,
									width :100,
									formatter:function(value,row,index){
										return commUtil.dateUtil.timeStampFormat(value);
									}
								},
								{
									field : "status",
									title : "状态",
									sortable : true,
									width : 80,
									formatter: function(value,row,index){
										if(value == "1"){
											return "可用";
										}else{
											return "不可用";
										}
									}
								},
								{
									field : "operation",
									title : "操作",
									width : 150,
									align : "center",
									formatter : function(value, row, index) {
										var arr = [
												"<a data-id='"
														+ row.id
														+ "' class='detailAudiovisual'>查看</a>",
												"<a data-id='"
														+ row.id
														+ "' class='delAudiovisual'>删除</a>" ];
										return arr.join(" ");
									}
								} ],
						onLoadSuccess : function(data) {
							// 激活提示框
							$("#audiovisualTable [data-toggle='tooltip']")
									.tooltip();
							// 激活删除按钮事件
							$(".delAudiovisual").on("click", function() {
								var id = $(this).data("id");
								swal({
									title : "您确定要删除这条信息吗",
									text : "删除后将无法恢复，请谨慎操作！",
									type : "warning",
									showCancelButton : true,
									confirmButtonColor : "#DD6B55",
									confirmButtonText : "删除",
									cancelButtonText : "取消",
									closeOnConfirm : false
								}, function(status) {
									if(status){
										commUtil.ajaxUtil.execute({
											url: basePath + "/market/audiovisual/delete",
											data: {
												id: id
											},
											success: function(data) {
												var flag = data.flag;
												if ("Y" == flag) {
													swal({
														title: data.message,
														type: "success"
													});
													$('#audiovisualTable').bootstrapTable("selectPage",1);
												}else{
													swal("删除失败！", data.message, "error");
												}
											}
										});
									}
								});
							});
							$(".detailAudiovisual")
									.on(
											"click",
											function(e) {
												location.href = basePath
												+ "/market/audiovisual/detail?id="
												+ $(this).data("id");
											});
						}
					});
	$(document).ready(function() {
		// 动态绑定事件
		// $("#audiovisualTable").on("click",".delAudiovisual", function() {})
	});
	



});

function recommendAudiovisual(id,param){
	var title = "";
	var text = "";
	if(param == 0){
		title="您确定要将这条信息推荐到首页吗";
		text = "确定后将会把该信息在首页展示！";
		param = 1;
	}else{
		title="您确定要将这条信息取消推荐到首页吗";
		text = "确定后将会把该信息从首页中移除！";
		param = 0;
	}
	swal({
		title : title,
		text : text,
		type : "warning",
		showCancelButton : true,
		confirmButtonColor : "#DD6B55",
		confirmButtonText : "确定",
		cancelButtonText : "取消",
		closeOnConfirm : false
	}, function(status) {
		if(status){
			$.ajax({
				type : "POST",
				dataType : "json",
				async : false,
				url: basePath + "/market/audiovisual/recommendAudiovisual",
				data: {
					id: id,
					param:param
				},
				success: function(data) {
					var flag = data.flag;
					if ("Y" == flag) {
						swal({
							title: data.message,
							type: "success"
						});
						$('#audiovisualTable').bootstrapTable("refresh");
					}else{
						swal("操作失败！", data.message, "error");
					}
				}
			});
		}
	});
}