define(function(require, exports, module) {

	// 全局
	require('jquery');
	require('jquery-cookie');
	require("bootstrap");
	// Bootstrap table
	require('bootstrap-table');
	require('bootstrap-table-zh-CN');
	require('sweetalert');
	var commUtil = require('commUtil');
	$.setPageCookie("hotPage",isBack);
	$('#hotListTable').bootstrapTable(
			{
				url : basePath + "/commerce/hot/search",
				// search: true,
				pagination : true,
				// showRefresh: true,
				// showToggle: true,
				sidePagination : "server",
				showColumns : true,
				sortable : true,
				showAddBut : true,
				addButEvent : function(e) {
					location.href = basePath + "/commerce/hot/add";
				},
				showQueryBut : true,
				queryButEvent : function(e) {
					$('#hotListTable').bootstrapTable("refresh");
				},
				pageList : [ 5, 10, 20, 50],
				pageNumber : 1, // 初始化加载第一页，默认第一页
				pageSize : 10, // 每页的记录行数（*）
				toolbar : '#hotListToolbar', 
				icons : {
					refresh : 'glyphicon-repeat',
					toggle : 'glyphicon-list-alt',
					columns : 'glyphicon-list'
				},
				queryParams : function(params) {
					params.keyWord = $("#keyWord").val();
					$.cookie("hotPage",JSON.stringify(params));
					return params; 
				},
				onSort:function(name, order){
					/*if(name=="sortId"){
						this.sortName="sort_id";
					}else if(name=="popularity"){
						this.sortName="popularity";
					}else if(name=="sale"){
						this.sortName="sale";
					}else if(name=="creationTime"){
						this.sortName="creation_time";
					}*/
				},
				columns : [
						{
							field : "num",
							title : "序号",
							width : 50,
							align : "center",
							formatter : function(value, row, index,that) {
								var seq = index + 1;
								seq = seq
										+ (that.options.pageNumber - 1)
										* that.options.pageSize;
								return seq;
							}
						},
						{
							field : "name",
							title : "商品名称",
				            sortable : true
						},{
							field : "listIconId",
							title : "预览图",
							width : 120,
							formatter : function(value,row,index){
								 var arr = ["<div  class='thumbnail' style='margin-bottom:0px;'>",
					                    	"<img style='width:50px;height:50px;'  src='"+basePath+"/commerce/binaryFile/getFileById?id="+value+"'>",
					                    	"</div>"];
					                    return arr.join(" ");
							}
						},
						{
							field : "popularity",
							title : "人气值",
							sortable : true,
							width: 80
						},
						{
							field : "sale",
							title : "销量",
							sortable : true,
							width: 80
						},
						{
							field : "sortId",
							title : "排序",
							sortable : true,
							width: 80
						},
						{
							field : "startTime",
							title : "开始时间",
							sortable : true,
							formatter : function(value, row, index) {
								return commUtil.dateUtil.timeStampFormat(value,"yyyy-MM-dd");
							}
						},
						{
							field : "expiryTime",
							title : "结束时间",
							sortable : true,
							formatter : function(value, row, index) {
								return commUtil.dateUtil.timeStampFormat(value,"yyyy-MM-dd");
							}
						},
						{
							field : "operation",
							title : "操作",
							width : 150,
							align : "center",
							formatter : function(value, row, index) {
								var arr = [
										"<a data-id='" + row.id
												+ "' class='detailHot'>查看</a>",
										"<a data-id='" + row.id
												+ "' class='editHot'>编辑</a>",
										"<a data-id='" + row.id
												+ "' class='delHot'>删除</a>" ];
								return arr.join(" ");
							}
						},{
							field : "id",
							title : "id",
							visible:false
						} ],
				onLoadSuccess : function(data) {
					// 激活提示框
					$("#hotListTable [data-toggle='tooltip']").tooltip();
					// 激活删除按钮事件
					$(".delHot").on("click", function() {
						var id = $(this).data("id");
						swal({
							title : "您确定要删除这条信息吗",
							text : "删除后将无法恢复，请谨慎操作！",
							type : "warning",
							showCancelButton : true,
							confirmButtonColor : "#DD6B55",
							confirmButtonText : "删除",
							cancelButtonText : "取消",
							closeOnConfirm : false,
							timer:5000
						}, function(status) {

							if (status) {
								$.ajax({
									type : "POST",
									dataType : "json",
									async : false,
									url : basePath + "/commerce/hot/delete",
									data : {
										id : id
									},
									success : function(data) {
										if ("Y" == data.flag) {
											$("#hotListTable").bootstrapTable("refresh");
											swal("删除成功！", "您已经永久删除了这条信息。", "success");
										}else{
											swal("删除失败！", data.message, "error");
										}
									}
								});
							}

						});
					});
					$(".detailHot").on(
							"click",
							function(e) {
								location.href = basePath
										+ "/commerce/hot/detail?id="
										+ $(this).data("id");
							});
					$(".editHot").on(
							"click",
							function(e) {
								location.href = basePath
										+ "/commerce/hot/edit?id="
										+ $(this).data("id");
							});
				}
			});
	$(document).ready(function() {
		// 动态绑定事件
		// $("#audiovisualTable").on("click",".delAudiovisual", function() {})
	})

})