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
	$.setPageCookie("groupPage",isBack);
	$('#commodityGroupTable')
		.bootstrapTable({
			url: basePath + "/commerce/commodityGroup/search",
			// search: true,
			pagination: true,
			// showRefresh: true,
			// showToggle: true,
			sidePagination: "server",
			showColumns: true,
			sortable: true,
			showAddBut: true,
			addButEvent: function(e) {
				location.href = basePath + "/commerce/commodityGroup/add";
			},
			showQueryBut: true,
			queryButEvent: function(e) {
				$('#commodityGroupTable').bootstrapTable("refresh");
			},
			pageList: [5, 10, 20, 50],
			pageNumber: 1, // 初始化加载第一页，默认第一页
			pageSize: 10, // 每页的记录行数（*）
			toolbar: '#commodityGroupTableToolbar',
			icons: {
				refresh: 'glyphicon-repeat',
				toggle: 'glyphicon-list-alt',
				columns: 'glyphicon-list'
			},
			queryParams: function(params) {
				params.para_status = $("#para_status").val();
				params.para_home_recommended = $("#para_home_recommended").val();
				params.para_keyword = $("#para_keyword").val();
				$.cookie("groupPage",JSON.stringify(params));
				return params;
			},
			columns: [{
				field: "seq",
				title: "序号",
				width: 50,
				align: "center",
				formatter: function(value, row, index,
					that) {
					var seq = index + 1;
					seq = seq + (that.options.pageNumber - 1) * that.options.pageSize;
					return seq;
				}
			}, {
				field: "title",
				title: "商品名",
				align: "center",
	            sortable : true
			}, {
				title: "预览图",
	            field: "icon",
	            align: "center",
				width : 120,
	            formatter: function(value, row, index) {
	                var arr = ["<div  class='thumbnail' style='margin-bottom:0px;'>",
	                	"<img style='width:50px;height:50px;'  src='"+basePath+"/commerce/binaryFile/getFileById?id="+row.list_icon_id+"'>",
	                	"</div>"];
	                return arr.join(" ");
	            }
			}, {
				field: "sort_id",
				title: "排序",
				align: "center",
				width: 80,
	            sortable : true
			}, {
				field: "number_people",
				title: "成团人数",
				align: "center",
				width: 80,
	            sortable : true	
			}, {
				field: "price",
				title: "团购价格",
				align: "center",
				width: 80,
	            sortable : true
			}, {
				field: "number_people_actual",
				title: "参团人数",
				align: "center",
				width: 80,
				formatter : function(value, row, index) {
					return "<a href='javascript:void(0)' data-id='" + row.id + "' class='toCommodityGroupUserPage'>"+value+"</a>";
				},
	            sortable : true
			}, {
				field: "home_recommended",
				title: "推荐到首页",
				width : 100,
				align: "center",
				formatter: function(value, row, index) {
					  if (value == 0) {
		                    return "<a data-id='" + row.id + "' data-value='1' class='commodityGroupRecommended'>推荐首页</a>";
		                } else {
		                    return "<a data-id='" + row.id + "' data-value='0' class='commodityGroupRecommended'>取消推荐</a>";
		                }
				},
	            sortable : true
			}, {
				field: "start_time",
				title: "开始时间",
				align: "center",
				width:100,
				formatter: function(value, row, index) {
					return commUtil.dateUtil.timeStampFormat(value);
				},
	            sortable : true
			}, {
				field: "expiry_time",
				title: "结束时间",
				align: "center",
				width:100,
				formatter: function(value, row, index) {
					return commUtil.dateUtil.timeStampFormat(value);
				},
	            sortable : true
			}, {
				field: "operation",
				title: "操作",
				width: 120,
				align: "center",
				formatter: function(value, row, index) {
					var arr = [
						"<a data-id='" + row.id + "' class='detailcommodityGroup'>查看</a>",
						"<a data-id='" + row.id + "' class='editcommodityGroup'>编辑</a>",
						"<a data-id='" + row.id + "' class='delcommodityGroup'>删除</a>"
					];
					return arr.join(" ");
				}
			}],
			onLoadSuccess: function(data) {
				// 激活提示框
				$("#commodityGroupTable [data-toggle='tooltip']").tooltip();
				// 删除
				$(".delcommodityGroup").on("click", function() {
					var id = $(this).data("id");
					swal({
						title: "您确定要删除这条信息吗",
						text: "删除后将无法恢复，请谨慎操作！",
						type: "warning",
						showCancelButton: true,
						confirmButtonColor: "#DD6B55",
						confirmButtonText: "删除",
						cancelButtonText: "取消",
						closeOnConfirm: false
					}, function(status) {
						if (status) {
							commUtil.ajaxUtil.execute({
								url: basePath + "/commerce/commodityGroup/del",
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
										$('#commodityGroupTable').bootstrapTable("refresh");
									}
								}
							});
						}
					});
				});
				
				//查看
				$(".detailcommodityGroup").on("click",function(e) {
					location.href = basePath + "/commerce/commodityGroup/detail?id="+$(this).data("id");
				});
				//编辑
				$(".editcommodityGroup").on("click",function(e) {
					location.href = basePath + "/commerce/commodityGroup/toEdit?id="+$(this).data("id");
				});
				//参团人列表
				$(".toCommodityGroupUserPage").on("click",function(e) {		
					location.href = basePath + "/commerce/commodityGroup/toCommodityGroupUserPage?commodityGroupId="+$(this).data("id");
				});
				
				//推荐
				$(".commodityGroupRecommended").on("click",function(e) {	
					var id = $(this).data("id");
					var isHome = $(this).data("value");
					swal({
						title: "您确定要推荐吗",
						type: "info",
						showCancelButton: true,
						confirmButtonColor: "#DD6B55",
						confirmButtonText: "确定",
						cancelButtonText: "取消",
						closeOnConfirm: false
					}, function(status) {
						if (status) {
							commUtil.ajaxUtil.execute({
								url: basePath + "/commerce/commodityGroup/homeRecommended",
								data: {
									id: id,
									isHome : isHome
								},
								success: function(data) {
									var flag = data.flag;
									if ("Y" == flag) {
										$('#commodityGroupTable').bootstrapTable("refresh");
										swal.close();
									}
								}
							});
						}
					});
				});
			}
		});
	
	// 参团人列表
	$('#commodityGroupUserTable')
	.bootstrapTable({
		url: basePath + "/commerce/commodityGroup/commodityGroupUserPage",
		// search: true,
		pagination: true,
		sidePagination: "server",
		showColumns: true,
		sortable: true,
		showQueryBut: true,
		queryButEvent: function(e) {
			$('#commodityGroupUserTable').bootstrapTable("refresh");
		},
		pageList: [10, 20, 30, 'ALL'],
		pageNumber: 1, // 初始化加载第一页，默认第一页
		pageSize: 10, // 每页的记录行数（*）
		toolbar: '#commodityGroupUserTableToolbar',
		icons: {
			refresh: 'glyphicon-repeat',
			toggle: 'glyphicon-list-alt',
			columns: 'glyphicon-list'
		},
		queryParams: function(params) {
			params.commodityGroupId = $("#commodityGroupId").val();
			return params;
		},
		columns: [{
			field: "seq",
			title: "序号",
			width: 120,
			align: "center",
			formatter: function(value, row, index,
				that) {
				var seq = index + 1;
				seq = seq + (that.options.pageNumber - 1) * that.options.pageSize;
				return seq;
			}
		}, {
			field: "consignee",
			title: "姓名",
			width: 120,
			align: "center"
		}, {
            field: "orderNo",
            title: "订单号",
            width: 120
        },{
			field: "mobile",
			title: "联系方式",
			align: "center"
		}, {
			field: "address",
			title: "地址",
			align: "center"
		}, {
			field: "zip_code",
			title: "邮编",
			align: "center"
		}, {
			field: "creation_time",
			title: "下单时间",
			align: "center",
			formatter: function(value, row, index) {
				return commUtil.dateUtil.timeStampFormat(value);
			}
		}, {
			field: "status",
			title: "订单状态",
			align: "center",
			formatter: function(value, row, index) {
				
				if(value == 0){
					value = "待支付"; 
				}else if(value == 1){
					value = "待发货";
				}else if(value == 2){
					value = "待收货";
				}else if(value == 3){
					value = "待评价";
				}else if(value == 4){
					value = "交易关闭";
				}else if(value == 5){
					value = "待审核";
				}else if(value == 6){
					value = "交易成功";
				}else if(value == 7){
					value = "参团成功";
				}
				
				return value;
			}
		}, {
			field: "operation",
			title: "操作",
			width: 150,
			align: "center",
			formatter: function(value, row, index) {
				var arr = [
					"<a data-id='" + row.orderNo + "' class='detailcommodityGroupUser'>查看</a>"
				];
				return arr.join(" ");
			}
		}],
		onLoadSuccess: function(data) {
			$(".detailcommodityGroupUser").on("click",function(e) {
//				location.href = basePath + "/commerce/commodityGroup/commodityGroupUserDetail?commodityGroupId=" + $(this).data("id");
				location.href = basePath + "/commerce/order/detail?orderNo=" + $(this).data("id") + "&bizType=commodityGroup";
			});
		}
	});
	
	$(document).ready(function() {
		// 动态绑定事件
		// $("#commodityGroupTable").on("click",".delcommodityGroup", function()
		// {})
	})
})