define(function(require, exports, module) {

    // 全局
    require('jquery');
    require('jquery-cookie');
    require("bootstrap");
    require("bootstrap-select");
    // Bootstrap table
    require('bootstrap-table');
    require('bootstrap-table-zh-CN');
	require('sweetalert');
    var commUtil = require('commUtil');
    $.setPageCookie("commodityPage",isBack);
    //在售商品
    $('#inTheSaleTable').bootstrapTable({
        url: basePath + "/commerce/commodity/search",
        pagination: true,
        sidePagination: "server",
        showColumns: true,
        sortable: true,
        showAddBut: true,
        addButEvent: function(e) {
            location.href = basePath + "/commerce/commodity/toAdd";
        },
        showQueryBut: true,
        queryButEvent: function(e) {
            $('#inTheSaleTable').bootstrapTable("refresh");
        },
        pageList: [5, 10, 20, 50],
        pageNumber: 1,
        // 初始化加载第一页，默认第一页
        pageSize: 10,
        toolbar: '#inTheSaleTableToolbar',
        icons: {
            refresh: 'glyphicon-repeat',
            toggle: 'glyphicon-list-alt',
            columns: 'glyphicon-list'
        },
        queryParams: function(params) {
            params.status = 1;
            params.name = $("#name").val();
            params.storeId = $("#storeId").val();
            params.categoryId = $("#categoryId").val();
            $.cookie("commodityPage",JSON.stringify(params));
            return params;
        },
        columns: [{
            title: "序号",
            field: "num",
            width: 50,
            align: "center",
            formatter: function(value, row, index, that) {
                var seq = index + 1;
                seq = seq + (that.options.pageNumber - 1) * that.options.pageSize;
                return seq;
            }
        },
        {
            title: "商品名",
            field: "name",
            align: "center",
            sortable : true
        },
        {
            title: "排序",
            field: "sortId",
            width: 80,
            align: "center",
            sortable : true
        },
        {
            title: "预览图",
            field: "icon",
            formatter: function(value, row, index) {
               /* var arr = ["<div  class='thumbnail' style='margin-bottom:0px;'>",
                	"<img style='width:50px;height:50px;' src='"+basePath+"/commerce/binaryFile/getFileById?id="+row.listIconId+"'>",
                	"</div>"];
                return arr.join(" ");*/
            	
                return '<img style="width:50px;height:50px;"  src="'+basePath+'/commerce/binaryFile/getFileById?id='+row.listIconId+'">';
            }
        },
        {
            title: "所属店铺",
            field: "storeName",
            align: "center",
            sortable : true
        },
        {
            title: "所属分类",
            field: "categoryName",
            align: "center",
            sortable : true
        },
        {
            title: "原价",
            field: "price",
            width: 80,
            align: "center",
            sortable : true
        },
        {
            title: "现价",
            field: "currentPrice",
            width: 80,
            align: "center",
            sortable : true
        },
        {
            title: "库存",
            field: "stock",
            width: 80,
            align: "center",
            sortable : true
        },
        {
            title: "销量",
            field: "sale",
            width: 80,
            align: "center",
            sortable : true
        },
        {
            title: "人气",
            field: "popularity",
            width: 80,
            align: "center",
            sortable : true
        },
        {
            field: "operation",
            title: "操作",
            width: 150,
            align: "center",
            formatter: function(value, row, index) {
                var arr = ["<a data-id='" + row.id + "' class='offCommodity'>下架</a>",
                	"<a data-id='" + row.id + "' class='editCommodity'>编辑</a>", 
                	"<a data-id='" + row.id + "' class='delCommodity'>删除</a>"];
                return arr.join(" ");
            }
        }],
        onLoadSuccess: function(data) {
            // 激活提示框
            $("#inTheSaleTable [data-toggle='tooltip']").tooltip();
            // 激活删除按钮事件
            $(".offCommodity").on("click",
            function() {
                var id = $(this).data("id");
                swal({
                    title: "您确定要下架该商品吗？",
                    text: "商品下架后将无法在商城中展示，请谨慎操作！",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "下架",
                    cancelButtonText: "取消",
                    closeOnConfirm: false
                },
                function(status) {
                    if (status) {
                    	commUtil.ajaxUtil.execute({
                    		url: basePath + "/commerce/commodity/updateStatus",
                    		data: {
                                id: id,
                                status: 4
                            },success: function(data) {
                            	if ("Y" == data.flag) {
                                    swal({
										title: "下架成功！",
										type: "success"
									});
                                    $('#inTheSaleTable').bootstrapTable("refresh");
                                    $("#haltTheSalesTable").bootstrapTable("refresh");
                                } else {
                                    swal("操作失败！", data.message, "error");
                                }
    						}
    					});
                    }

                });
            });
            $(".editCommodity").on("click",
            function(e) {
                location.href = basePath + "/commerce/commodity/toEdit?id=" + $(this).data("id");
            });
            $(".delCommodity").on('click',
                function(e) {
                	var id = $(this).data("id");
                    swal({
                        title: "您确定要删除该商品吗？",
                        type: "warning",
                        showCancelButton: true,
                        confirmButtonColor: "#DD6B55",
                        confirmButtonText: "删除",
                        cancelButtonText: "取消",
                        closeOnConfirm: false,
                        timer: 5000
                    },
                    function(status) {
                        if (status) {
                        	commUtil.ajaxUtil.execute({
                        		url: basePath + "/commerce/commodity/del",
                        		data: {
                                    id: id
                                },success: function(data) {
                                	if ("Y" == data.flag) {
                                		swal({
    										title: data.message,
    										type: "success"
    									});
                                        $('#inTheSaleTable').bootstrapTable("refresh");
                                        $("#haltTheSalesTable").bootstrapTable("refresh");
                                    } else {
                                    	 swal("操作失败！", data.message, "error");
                                    }
        						}
        					});
                        }
                    });
                });
        }
    });
    
    //停售商品
    $('#haltTheSalesTable').bootstrapTable({
    	url: basePath + "/commerce/commodity/search",
        pagination: true,
        sidePagination: "server",
        showColumns: true,
        sortable: true,
        showAddBut: true,
        addButEvent: function(e) {
            location.href = basePath + "/commerce/commodity/toAdd";
        },
        showQueryBut: true,
        queryButEvent: function(e) {
            $('#haltTheSalesTable').bootstrapTable("refresh");
        },
        pageList: [5, 10, 20, 50],
        pageNumber: 1,
        // 初始化加载第一页，默认第一页
        pageSize: 15,
        toolbar: '#haltTheSalesTableToolbar',
        icons: {
            refresh: 'glyphicon-repeat',
            toggle: 'glyphicon-list-alt',
            columns: 'glyphicon-list'
        },
        queryParams: function(params) {
            params.status = 4;
            params.name = $("#haltTheSalesKeyword").val();
            params.storeId = $("#haltTheSalesStoreId").val();
            params.categoryId = $("#ihaltTheSalesCategoryId").val();
            return params;
        },
        columns: [{
            title: "序号",
            field: "num",
            width: 50,
            align: "center",
            formatter: function(value, row, index, that) {
                var seq = index + 1;
                seq = seq + (that.options.pageNumber - 1) * that.options.pageSize;
                return seq;
            }
        },
        {
            title: "商品名",
            field: "name",
            align: "center",
            sortable : true
        },
        {
            title: "排序",
            field: "sortId",
            width: 80,
            align: "center",
            sortable : true
        },
        {
            title: "预览图",
            field: "icon",
            align: "center",
            formatter: function(value, row, index) {
                var arr = ["<div  class='thumbnail' style='margin-bottom:0px;'>",
                	"<img style='width:50px;height:50px;' src='"+basePath+"/commerce/binaryFile/getFileById?iconId="+row.listIconId+"'>",
                	"</div>"];
                return arr.join(" ");
            }
        },
        {
            title: "所属店铺",
            field: "storeName",
            align: "center",
            sortable : true
        },
        {
            title: "所属分类",
            field: "categoryName",
            align: "center",
            sortable : true
        },
        {
            title: "原价",
            field: "price",
            width: 80,
            align: "center",
            sortable : true
        },
        {
            title: "现价",
            field: "currentPrice",
            width: 80,
            align: "center",
            sortable : true
        },
        {
            title: "库存",
            field: "stock",
            width: 80,
            align: "center",
            sortable : true
        },
        {
            title: "销量",
            field: "sale",
            width: 80,
            align: "center",
            sortable : true
        },
        {
            title: "人气",
            field: "popularity",
            width: 80,
            align: "center",
            sortable : true
        },
        {
            field: "operation",
            title: "操作",
            width: 120,
            align: "center",
            formatter: function(value, row, index) {
                var arr = ["<a data-id='" + row.id + "' class='onCommodity'>上架</a>",
                	"<a data-id='" + row.id + "' class='editCommodity'>编辑</a>", 
                	"<a data-id='" + row.id + "' class='delCommodity'>删除</a>"];
                return arr.join(" ");
            }
        }],
        onLoadSuccess: function(data) {
            // 激活提示框
            $("#haltTheSalesTable [data-toggle='tooltip']").tooltip();
            // 激活删除按钮事件
            $(".onCommodity").on("click",
            function() {
                var id = $(this).data("id");
                swal({
                    title: "您确定要上架该商品吗？",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "上架",
                    cancelButtonText: "取消",
                    closeOnConfirm: false,
                    timer: 5000
                },
                function(status) {
                    if (status) {
                    	commUtil.ajaxUtil.execute({
                    		url: basePath + "/commerce/commodity/updateStatus",
                    		data: {
                                id: id,
                                status: 1
                            },success: function(data) {
                            	if ("Y" == data.flag) {
                            		swal({
										title: "上架成功！",
										type: "success"
									});
                                    $('#inTheSaleTable').bootstrapTable("refresh");
                                    $("#haltTheSalesTable").bootstrapTable("refresh");
                                } else {
                                    swal("操作失败！", data.message, "error");
                                }
    						}
    					});
                    }
                });
            });
            $(".editCommodity").on("click",
            function(e) {
                location.href = basePath + "/commerce/commodity/toEdit?id=" + $(this).data("id");
            });
            $(".delCommodity").on('click',
            function(e) {
            	var id = $(this).data("id");
                swal({
                    title: "您确定要删除该商品吗？",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "删除",
                    cancelButtonText: "取消",
                    closeOnConfirm: false,
                    timer: 5000
                },
                function(status) {
                    if (status) {
                    	commUtil.ajaxUtil.execute({
                    		url: basePath + "/commerce/commodity/del",
                    		data: {
                                id: id
                            },success: function(data) {
                            	if ("Y" == data.flag) {
                            		swal({
										title: data.message,
										type: "success"
									});
                                    $('#inTheSaleTable').bootstrapTable("refresh");
                                    $("#haltTheSalesTable").bootstrapTable("refresh");
                                } else {
                                	swal({
										title: data.message,
										type: "error"
									});
                                }
    						}
    					});
                    }
                });
            });
        }
    });
    $(function(){
    	//下拉树图数据加载
    	commUtil.ajaxUtil.execute({
    		url: basePath + "/commerce/commodity/getCommodityCategory",
    		loading:false,
    		success: function(data) {
    			var parentArr=[];
    			var nodeArr=[];
    			$.each(data,function(index,item){  
    		    	if(item.parentId==0){
    		    		parentArr.push(item);
    		    	}else{
    		    		nodeArr.push(item);
    		    	}
    		    });
    			
    			$.each(parentArr,function(i,p){ 
    				var $optgroupIn=$("<optgroup label='"+p.name+"'></optgroup>");
    				var $optgroupHalt=$("<optgroup label='"+p.name+"'></optgroup>");
    				$.each(nodeArr,function(j,n){  
    			    	if(n.parentId==p.id){
    			    		$optgroupIn.append("<option value='"+n.id+"'>"+n.name+"</option>");
    			    		$optgroupHalt.append("<option value='"+n.id+"'>"+n.name+"</option>");
    			    	}
    			    });
    				$("#inTheSaleCategoryId").append($optgroupIn);
    				$("#haltTheSalesCategoryId").append($optgroupHalt);
    		    });
    			$('#inTheSaleCategoryId').selectpicker('refresh');
    			$('#inTheSaleCategoryId').selectpicker('setStyle', 'w-150', 'add');
    			$('#haltTheSalesCategoryId').selectpicker('refresh');
    			$('#haltTheSalesCategoryId').selectpicker('setStyle', 'w-150', 'add');
    		}
    	});
    })
    
    
    
    
})