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
	$.setPageCookie("benefitPage",isBack);
	
	$(document).ready(function() {
		$('#benefitTable').bootstrapTable({
			url : basePath + "/commerce/benefit/search",
			pagination : true,
			sidePagination : "server",
			showColumns : true,
			sortable : true,
			showAddBut : true,
			addButEvent : function(e) {
				location.href = basePath
						+ "/commerce/benefit/add";
			},
			showQueryBut : true,
			contentType : 'application/json;charset=UTF-8',
			queryButEvent : function(e) {
				$('#benefitTable').bootstrapTable("refresh");
			},
			pageList : [ 5, 10, 20, 50],
			pageNumber : 1, // 初始化加载第一页，默认第一页
			pageSize : 10, // 每页的记录行数（*）
			toolbar : '#benefitTableToolbar',
			icons : {
				refresh : 'glyphicon-repeat',
				toggle : 'glyphicon-list-alt',
				columns : 'glyphicon-list'
			},
			queryParams : function(params) { 
				params.keyWord = $("#keyWord").val();
				params.isHome = $("#isHome").val();
				params.type = $("#type").val();
				$.cookie("benefitPage",JSON.stringify(params));
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
						field : "commodityName",
						title : "商品名",
			            sortable : true
					},
					{
						field : "imageId",
						title : "预览图",
						width : 120,
			            formatter: function(value, row, index) {
			                var arr = ["<div  class='thumbnail' style='margin-bottom:0px;'>",
			                	"<img style='width:50px;height:50px;'  src='"+basePath+"/commerce/binaryFile/getFileById?id="+value+"'>",
			                	"</div>"];
			                return arr.join(" ");
			            }
					},
					{
						field : "price",
						title : "优惠价",
						width: 60,
			            sortable : true
					},
					{
						field : "amount",
						title : "原价",
						width: 60,
			            sortable : true
					},
					{
						field : "stock",
						title : "库存",
						width: 60,
			            sortable : true
					},
					{
						field : "sale",
						title : "销量",
						width: 60,
			            sortable : true
					},
					{
						field : "sortId",
						title : "排序",
						width: 60,
			            sortable : true
					},
					{
						field : "homeRecommended",
						title : "推荐到首页",
						width: 100,
			            formatter: function(value, row, index) {
			                if (value == 0) {
			                    return "<a data-id='" + row.id + "' class='recommend'>推荐首页</a>";
			                } else {
			                    return "<a data-id='" + row.id + "' class='unRecommend'>取消首页</a>";
			                }
			            },
			            sortable : true
					},
					{
						field : "startTime",
						title : "开始时间",
						width: 100,
						formatter: function(value, row, index) {
							return commUtil.dateUtil.timeStampFormat(value);
						},
			            sortable : true
					},
					{
						field : "expiryTime",
						title : "结束时间",
						width: 100,
						formatter: function(value, row, index) {
							return commUtil.dateUtil.timeStampFormat(value);
						},
			            sortable : true
					},
					{
						field : "operation",
						title : "操作",
						width : 120,
						align : "center",
						formatter : function(value, row, index) {
							var arr = [
								"<a data-id='"
								+ row.id
								+ "' class='detailBenefit'>查看</a>",
									"<a data-id='"
											+ row.id
											+ "' class='editBenefit'>编辑</a>",
									"<a data-id='"
											+ row.id
											+ "' class='delBenefit'>删除</a>" ];
							return arr.join(" ");
						}
					} ],
			onLoadSuccess : function(data) {
				// 激活提示框
				$("#benefitTable [data-toggle='tooltip']").tooltip();
				// 激活删除按钮事件
				$(".delBenefit").on("click", function() {
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
							commUtil.ajaxUtil.execute({
								url : basePath + "/commerce/benefit/delete",
								data: {
									id: id
								},
								success: function(data) {
									if ("Y" == data.flag) {
										$("#benefitTable").bootstrapTable("refresh");
										swal("删除成功！", "您已经永久删除了这条信息。", "success");
									}else{
										swal("删除失败！", data.message, "error");
									}
								}
							});
						}
					});
				});
				$(".detailBenefit").on("click", function() {
					location.href = basePath
					+ "/commerce/benefit/detail?id="
					+ $(this).data("id");
				});
				$(".editBenefit").on("click",function(e) {
					location.href = basePath
					+ "/commerce/benefit/edit?id="
					+ $(this).data("id");
				});
				$(".recommend").on("click",
			            function(e) {
			                var id = $(this).data("id");
			                swal({
			                    title: "您确定要推荐这条信息吗",
			                    text: "确定后，该信息将会在首页中展示！",
			                    type: "warning",
			                    showCancelButton: true,
			                    confirmButtonColor: "#DD6B55",
			                    confirmButtonText: "确定",
			                    cancelButtonText: "取消",
			                    closeOnConfirm: false,
			                    timer: 5000
			                },
			                function(status) {
			                    if (status) {
			                    	commUtil.ajaxUtil.execute({
				                		url: basePath + "/commerce/benefit/recommend",
				                		data: {
			                                id: id,
			                                isHome: 1
			                            },
										success: function(data) {
											if ("Y" == data.flag) {
			                                	swal("推荐成功！", "您已成功将该信息推荐到首页。", "success");
			                                    $("#benefitTable").bootstrapTable("refresh");
			                                } else {
			                                    swal("推荐失败！", data.message, "error");
			                                }
										}
									});
			                    }
			                });
			            });
	            $(".unRecommend").on("click",function(e) {
                    var id = $(this).data("id");
                    swal({
                        title: "您确定要取消推荐这条信息吗",
                        text: "确定后，该信息将不会在首页中展示！",
                        type: "warning",
                        showCancelButton: true,
                        confirmButtonColor: "#DD6B55",
                        confirmButtonText: "确定",
                        cancelButtonText: "取消",
                        closeOnConfirm: false,
                        timer: 5000
                    },
                    function(status) {
                        if (status) {
                        	commUtil.ajaxUtil.execute({
                        		url: basePath + "/commerce/benefit/recommend",
		                		data: {
                                    id: id,
                                    isHome: 0
                                },
								success: function(data) {
									if ("Y" == data.flag) {
                                    	swal("取消成功！", "您已成功将该信息从首页中移除。", "success");
                                        $("#benefitTable").bootstrapTable("refresh");
                                    } else {
                                        swal("取消失败！", data.message, "error");
                                    }
								}
							});
                        }
                    });
	            });
			}
		});
	});
});
