define(function(require, exports, module) {

	// 全局
	require('jquery');
	require("bootstrap");
	// Bootstrap table
	require('bootstrap-table');
	require('bootstrap-table-zh-CN');
	require('sweetalert');
	var commUtil = require('commUtil');

	$('#brandTable').bootstrapTable({
						url : basePath + "/market/brand/search",
						pagination : true,
						sidePagination : "server",
						showColumns : true,
						sortable : true,
						showAddBut : true,
						addButEvent : function(e) {
							location.href = basePath
									+ "/market/brand/add";
						},
						showQueryBut : true,
						queryButEvent : function(e) {
							$('#brandTable').bootstrapTable("refresh");
						},
						pageList : [ 5, 10, 15, 'ALL' ],
						pageNumber : 1, // 初始化加载第一页，默认第一页
						pageSize : 5, // 每页的记录行数（*）
						toolbar : '#brandTableToolbar',
						icons : {
							refresh : 'glyphicon-repeat',
							toggle : 'glyphicon-list-alt',
							columns : 'glyphicon-list'
						},
						queryParams : function(params) { 
							return params;
						},
						columns : [
								{
									field : "seq",
									title : "序号",
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
									field : "brandname",
									title : "品牌名称",
									width : 150
								},
								{
									field : "floor",
									title : "商铺楼层",
									width : 80
								},
								{
									field : "address",
									title : "商铺地址"
								},
								{
									field : "brandtype",
									title : "品牌分类",
									align : "center"
								},
								{
									field : "phone",
									title : "联系电话",
									align : "center"
								},
								{
									field : "consume",
									title : "人均消费",
									align : "center"
								},
								{
									field : "ismain",
									title : "推荐到首页",
									align : "center"
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
														+ "' class='editBrand'>编辑</a>",
												"<a data-id='"
														+ row.id
														+ "' class='delBrand'>删除</a>" ];
										return arr.join(" ");
									}
								} ],
						onLoadSuccess : function(data) {
							// 激活提示框
							$("#brandTable [data-toggle='tooltip']")
									.tooltip();
							// 激活删除按钮事件
							$(".delBrand").on("click", function() {
								
							});
							$(".editBrand").on("click",function(e) {
									
							});
						}
					});
	$(document).ready(function() {
		// 动态绑定事件
		// $("#audiovisualTable").on("click",".delAudiovisual", function() {})
	});
	



});
