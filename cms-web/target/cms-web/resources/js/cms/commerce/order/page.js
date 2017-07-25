define(function(require, exports, module) {

    // 全局
    require('jquery');
    require('jquery-cookie');
    require("bootstrap");
    require("jquery-validate");
    require("jquery-validate-messages_zh");
    // Bootstrap table
    require('bootstrap-table');
    require('bootstrap-table-zh-CN');
    require('sweetalert');
    require("laydate");
    var commUtil = require('commUtil');

    $(document).ready(function() {
        laydate({
            elem: '#date_All'
        });
        laydate({
            elem: '#date_Issue'
        });
        laydate({
            elem: '#date_Pay'
        });
        laydate({
            elem: '#date_Comment'
        });
        laydate({
            elem: '#date_All_end'
        });
        laydate({
            elem: '#date_Issue_end'
        });
        laydate({
            elem: '#date_Pay_end'
        });
        laydate({
            elem: '#date_Comment_end'
        });
        //全部订单All
        $('#orderAllTable').bootstrapTable({
            url: basePath + "/commerce/order/search",
            pagination: true,
            sidePagination: "server",
            showColumns: true,
            sortable: true,
            showQueryBut: true,
            queryButEvent: function(e) {
                $('#orderAllTable').bootstrapTable("refresh");
            },
            pageList: [5, 10, 20, 50],
            pageNumber: 1,
            // 初始化加载第一页，默认第一页
            pageSize: 10,
            // 每页的记录行数（*）
            toolbar: '#orderAllTableToolbar',
            icons: {
                refresh: 'glyphicon-repeat',
                toggle: 'glyphicon-list-alt',
                columns: 'glyphicon-list'
            },
            queryParams: function(params) {
                params.keyWord = $("#keyWord_All").val();
                params.creationTime = $("#date_All").val();
                params.endTime = $("#date_All_end").val();
            	$.cookie("hotPage",JSON.stringify(params));
                return params;
            },
            columns: [{
                field: "seq",
                title: "序号",
                width: 50,
                formatter: function(value, row, index, that) {
                    var seq = index + 1;
                    seq = seq + (that.options.pageNumber - 1) * that.options.pageSize;
                    return seq;
                }
            },
            {
                field: "orderNo",
                title: "订单",
                width: 150,
                sortable : true
            },
            {
                field: "storeName",
                title: "商铺",
                width: 150,
                sortable : true
            },
            {
                field: "consignee",
                title: "收货人",
                sortable : true
            },
            {
                field: "mobile",
                title: "联系方式",
                sortable : true
            },
            {
                field: "creationTime",
                title: "下单时间",
                width:100,
                formatter: function(value, row, index) {
                    return commUtil.dateUtil.timeStampFormat(value);
                },
                sortable : true
            },
            {
                field: "amount",
                title: "总金额",
                sortable : true
            },
            {
                field: "amountActual",
                title: "实际金额",
                sortable : true
            },
            {
                field: "payType",
                title: "支付方式",
                formatter: function(value, row, index) {
                    switch (value) {
                    case 1:
                        return '支付宝';
                    case 2:
                        return '微信';
                    case 3:
                        return '星云卡'
                    case 4:
                        return '开联宝';
                    default:
                        return "";
                    }
                },
                sortable : true
            },
            {
                field: "status",
                title: "订单状态",
                formatter: function(value, row, index) {
                    switch (value) {
                    case 0:
                        return '待支付';
                    case 1:
                        return '待发货';
                    case 2:
                        return '待收货';
                    case 3:
                        return '待评价';
                    case 4:
                        return '交易关闭';
                    case 5:
                        return '待审核（免费试用）';
                    case 6:
                        return '交易成功';
                    case 7:
                        return '参团成功';
                    default:
                        return "";
                    }
                },
                sortable : true
            },
            {
                field: "operation",
                title: "操作",
                width: 150,
                align: "center",
                formatter: function(value, row, index) {
                    var arr
                    if (row.status == 1) {
                        arr = ["<a data-id='" + row.orderNo + "' class='IssueOrderAll' data-toggle='modal' data-target='#IssueModal'>发货</a>", "<a data-id='" + row.orderNo + "' class='detailOrderAll'>查看</a>"];
                    } else {
                        arr = ["<a data-id='" + row.orderNo + "' class='detailOrderAll'>查看</a>"];
                    }

                    return arr.join(" ");
                }
            }],
            onLoadSuccess: function(data) {
                // 激活提示框
                $("#brandTable [data-toggle='tooltip']").tooltip();
                // 激活删除按钮事件
                $(".IssueOrderAll").on("click",
                function() {
                    //订单ID
                    var orderNo = $(this).data("id");
                    $("#orderNo").val(orderNo);

                });
                $(".detailOrderAll").on("click",
                function(e) {
                    location.href = basePath + "/commerce/order/detail?orderNo=" + $(this).data("id");
                });
            }
        });

        //待发货Issue
        $('#orderIssueTable').bootstrapTable({
            url: basePath + "/commerce/order/search?status=1",
            pagination: true,
            sidePagination: "server",
            showColumns: true,
            sortable: true,
            showQueryBut: true,
            queryButEvent: function(e) {
                $('#orderIssueTable').bootstrapTable("refresh");
            },
            pageList: [5, 10, 20, 50],
            pageNumber: 1,
            // 初始化加载第一页，默认第一页
            pageSize: 10,
            // 每页的记录行数（*）
            toolbar: '#orderIssueTableToolbar',
            icons: {
                refresh: 'glyphicon-repeat',
                toggle: 'glyphicon-list-alt',
                columns: 'glyphicon-list'
            },
            queryParams: function(params) {
                params.keyWord = $("#keyWord_Issue").val();
                params.creationTime = $("#date_Issue").val();
                params.endTime = $("#date_Issue_end").val();
                return params;
            },
            columns: [{
                field: "seq",
                title: "序号",
                width: 50,
                formatter: function(value, row, index, that) {
                    var seq = index + 1;
                    seq = seq + (that.options.pageNumber - 1) * that.options.pageSize;
                    return seq;
                }
            },
            {
                field: "orderNo",
                title: "订单",
                width: 150,
                sortable : true
            },
            {
                field: "storeName",
                title: "商铺",
                width: 150,
                sortable : true
            },
            {
                field: "consignee",
                title: "收货人",
                sortable : true
            },
            {
                field: "mobile",
                title: "联系方式",
                sortable : true
            },
            {
                field: "creationTime",
                title: "下单时间",
                width:100,
                formatter: function(value, row, index) {
                    return commUtil.dateUtil.timeStampFormat(value);
                },
                sortable : true
            },
            {
                field: "amount",
                title: "总金额",
                sortable : true
            },
            {
                field: "amountActual",
                title: "实际金额",
                sortable : true
            },
            {
                field: "payType",
                title: "支付方式",
                formatter: function(value, row, index) {
                    switch (value) {
                    case 1:
                        return '支付宝';
                    case 2:
                        return '微信';
                    case 3:
                        return '星云卡'
                    case 4:
                        return '开联宝';
                    default:
                        return "";
                    }
                },
                sortable : true
            },
            {
                field: "status",
                title: "订单状态",
                formatter: function(value, row, index) {
                    switch (value) {
                    case 0:
                        return '待支付';
                    case 1:
                        return '待发货';
                    case 2:
                        return '待收货';
                    case 3:
                        return '待评价';
                    case 4:
                        return '交易关闭';
                    case 5:
                        return '待审核（免费试用）';
                    case 6:
                        return '交易成功';
                    case 7:
                        return '参团成功';
                    default:
                        return "";
                    }
                },
                sortable : true
            },
            {
                field: "operation",
                title: "操作",
                width: 150,
                align: "center",
                formatter: function(value, row, index) {
                    var arr;
                    if (row.status == 1) {
                        arr = ["<a data-id='" + row.orderNo + "' class='IssueOrder' data-toggle='modal' data-target='#IssueModal'>发货</a>", "<a data-id='" + row.orderNo + "' class='detailOrder'>查看</a>"];
                    } else {
                        arr = ["<a data-id='" + row.orderNo + "' class='detailOrder'>查看</a>"];
                    }

                    return arr.join(" ");
                }
            }],
            onLoadSuccess: function(data) {
                // 激活提示框
                $("#brandTable [data-toggle='tooltip']").tooltip();
                // 激活删除按钮事件
                $(".IssueOrder").on("click",
                function() {
                    //订单ID
                    var orderNo = $(this).data("id");
                    $("#orderNo").val(orderNo);
                });
                $(".detailOrder").on("click",
                function(e) {
                    location.href = basePath + "/commerce/order/detail?orderNo=" + $(this).data("id");
                });
            }
        });

        //待支付Pay
        $('#orderPayTable').bootstrapTable({
            url: basePath + "/commerce/order/search?status=0",
            pagination: true,
            sidePagination: "server",
            showColumns: true,
            sortable: true,
            showQueryBut: true,
            queryButEvent: function(e) {
                $('#orderPayTable').bootstrapTable("refresh");
            },
            pageList: [5, 10, 20, 50],
            pageNumber: 1,
            // 初始化加载第一页，默认第一页
            pageSize: 10,
            // 每页的记录行数（*）
            toolbar: '#orderPayTableToolbar',
            icons: {
                refresh: 'glyphicon-repeat',
                toggle: 'glyphicon-list-alt',
                columns: 'glyphicon-list'
            },
            queryParams: function(params) {
                params.keyWord = $("#keyWord_Pay").val();
                params.creationTime = $("#date_Pay").val();
                params.endTime = $("#date_Pay_end").val();
                return params;
            },
            columns: [{
                field: "seq",
                title: "序号",
                width: 50,
                formatter: function(value, row, index, that) {
                    var seq = index + 1;
                    seq = seq + (that.options.pageNumber - 1) * that.options.pageSize;
                    return seq;
                }
            },
            {
                field: "orderNo",
                title: "订单",
                width: 150,
                sortable : true
            },
            {
                field: "storeName",
                title: "商铺",
                width: 150,
                sortable : true
            },
            {
                field: "consignee",
                title: "收货人",
                sortable : true
            },
            {
                field: "mobile",
                title: "联系方式",
                sortable : true
            },
            {
                field: "creationTime",
                title: "下单时间",
                width:100,
                formatter: function(value, row, index) {
                    return commUtil.dateUtil.timeStampFormat(value);
                },
                sortable : true
            },
            {
                field: "amount",
                title: "总金额",
                sortable : true
            },
            {
                field: "amountActual",
                title: "实际金额",
                sortable : true
            },
            {
                field: "payType",
                title: "支付方式",
                formatter: function(value, row, index) {
                    switch (value) {
                    case 1:
                        return '支付宝';
                    case 2:
                        return '微信';
                    case 3:
                        return '星云卡'
                    case 4:
                        return '开联宝';
                    default:
                        return "";
                    }
                },
                sortable : true
            },
            {
                field: "status",
                title: "订单状态",
                formatter: function(value, row, index) {
                    switch (value) {
                    case 0:
                        return '待支付';
                    case 1:
                        return '待发货';
                    case 2:
                        return '待收货';
                    case 3:
                        return '待评价';
                    case 4:
                        return '交易关闭';
                    case 5:
                        return '待审核（免费试用）';
                    case 6:
                        return '交易成功';
                    case 7:
                        return '参团成功';
                    default:
                        return "";
                    }
                },
                sortable : true
            },
            {
                field: "operation",
                title: "操作",
                width: 150,
                align: "center",
                formatter: function(value, row, index) {
                    var arr = ["<a data-id='" + row.orderNo + "' class='detailOrderPay'>查看</a>"];

                    return arr.join(" ");
                }
            }],
            onLoadSuccess: function(data) {
                // 激活提示框
                $("#brandTable [data-toggle='tooltip']").tooltip();
                // 激活按钮事件
                $(".detailOrderPay").on("click",
                function(e) {
                    location.href = basePath + "/commerce/order/detail?orderNo=" + $(this).data("id");
                });
            }
        });

        //待评论Comment
        $('#orderCommentTable').bootstrapTable({
            url: basePath + "/commerce/order/search?status=3",
            pagination: true,
            sidePagination: "server",
            showColumns: true,
            sortable: true,
            showQueryBut: true,
            queryButEvent: function(e) {
                $('#orderCommentTable').bootstrapTable("refresh");
            },
            pageList: [5, 10, 20, 50],
            pageNumber: 1,
            // 初始化加载第一页，默认第一页
            pageSize: 10,
            // 每页的记录行数（*）
            toolbar: '#orderCommentTableToolbar',
            icons: {
                refresh: 'glyphicon-repeat',
                toggle: 'glyphicon-list-alt',
                columns: 'glyphicon-list'
            },
            queryParams: function(params) {
                params.keyWord = $("#keyWord_Comment").val();
                params.creationTime = $("#date_Comment").val();
                params.endTime = $("#date_Comment_end").val();
                return params;
            },
            columns: [{
                field: "seq",
                title: "序号",
                width: 50,
                formatter: function(value, row, index, that) {
                    var seq = index + 1;
                    seq = seq + (that.options.pageNumber - 1) * that.options.pageSize;
                    return seq;
                }
            },
            {
                field: "orderNo",
                title: "订单",
                width: 150,
                sortable : true
            },
            {
                field: "storeName",
                title: "商铺",
                width: 150,
                sortable : true
            },
            {
                field: "consignee",
                title: "收货人",
                sortable : true
            },
            {
                field: "mobile",
                title: "联系方式",
                sortable : true
            },
            {
                field: "creationTime",
                title: "下单时间",
                width:100,
                formatter: function(value, row, index) {
                    return commUtil.dateUtil.timeStampFormat(value);
                },
                sortable : true
            },
            {
                field: "amount",
                title: "总金额",
                sortable : true
            },
            {
                field: "amountActual",
                title: "实际金额",
                sortable : true
            },
            {
                field: "payType",
                title: "支付方式",
                formatter: function(value, row, index) {
                    switch (value) {
                    case 1:
                        return '支付宝';
                    case 2:
                        return '微信';
                    case 3:
                        return '星云卡'
                    case 4:
                        return '开联宝';
                    default:
                        return "";
                    }
                },
                sortable : true
            },
            {
                field: "status",
                title: "订单状态",
                formatter: function(value, row, index) {
                    switch (value) {
                    case 0:
                        return '待支付';
                    case 1:
                        return '待发货';
                    case 2:
                        return '待收货';
                    case 3:
                        return '待评价';
                    case 4:
                        return '交易关闭';
                    case 5:
                        return '待审核（免费试用）';
                    case 6:
                        return '交易成功';
                    case 7:
                        return '参团成功';
                    default:
                        return "";
                    }
                },
                sortable : true
            },
            {
                field: "operation",
                title: "操作",
                width: 150,
                align: "center",
                formatter: function(value, row, index) {
                    var arr = ["<a data-id='" + row.orderNo + "' class='detailOrderComment'>查看</a>"];

                    return arr.join(" ");
                }
            }],
            onLoadSuccess: function(data) {
                // 激活提示框
                $("#brandTable [data-toggle='tooltip']").tooltip();
                // 激活按钮事件
                $(".detailOrderComment").on("click",
                function(e) {
                    location.href = basePath + "/commerce/order/detail?orderNo=" + $(this).data("id");
                });
            }
        });

        //发货表单验证事件
        $("#IssueForm").validate({
            rules: {
            	expressNo: {
                    required: true
                }
            },
            submitHandler: function(form) {
                submitIssueForm();
            }
        });
    });
    //确认发货
    function submitIssueForm() {
        swal({
            title: "发货确认",
            text: "您确定输入的快递单号无误，并确定发货？",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确认",
            cancelButtonText: "取消",
            closeOnConfirm: false,
            timer: 5000
        },
        function(status) {
            if (status) {
                //关闭窗口
                $('#IssueModal').modal('hide');
                commUtil.ajaxUtil.execute({
                    url: basePath + "/commerce/order/send",
                    data: {
                        orderNo: $("#orderNo").val(),
                        deliveryCompany: $("#express").find("option:selected").text(),
                        deliveryNub: $("#expressNo").val()
                    },
                    success: function(data) {
                        if ("Y" == data.flag) {
                        	$('#cancelOrderModal').modal('hide');
                        	
							swal({
								title : "成功",
								text : "操作成功",
								type : "success"
							},function(){
								//location.href = basePath+ "/commerce/order/page";
								//只有全部订单和待发货订单有【发货按钮】，发完货刷新table即可，无需刷新整个页面
								$('#orderAllTable').bootstrapTable("refresh");
	                        	$('#orderIssueTable').bootstrapTable("refresh");
							});
                        } else {
                            swal("操作失败！", data.message, "error");
                        }
                    }
                });
            }
        });
    }
});