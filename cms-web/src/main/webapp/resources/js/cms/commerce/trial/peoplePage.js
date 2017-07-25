define(function(require, exports, module) {

    // 全局
    require('jquery');
    require("bootstrap");
    // Bootstrap table
    require('bootstrap-table');
    require('bootstrap-table-zh-CN');
    require('sweetalert');
    var commUtil = require('commUtil');
    $('#trialPeopleListTable').bootstrapTable({
        url: basePath + "/commerce/trial/searchPeople",
        // search: true,
        pagination: true,
        // showRefresh: true,
        // showToggle: true,
        sidePagination: "server",
        checkboxHeader: true,
        checkbox: true,
        showColumns: true,
        sortable: true,
        showQueryBut: true,
        queryButEvent: function(e) {
            $('#trialPeopleListTable').bootstrapTable("refresh");
        },
        pageList: [5, 10, 20, 50],
        pageNumber: 1,
        // 初始化加载第一页，默认第一页
        pageSize: 10,
        // 每页的记录行数（*）
        toolbar: '#trialPeopleListToolbar',
        icons: {
            refresh: 'glyphicon-repeat',
            toggle: 'glyphicon-list-alt',
            columns: 'glyphicon-list'
        },
        queryParams: function(params) {

            params.id = id;
            return params;
        },
        columns: [{
            field: id,
            checkbox: true,
            formatter: function(value, row, index) {
                if (row.isWin == 1) {
                    return {
                        disabled: true
                    };
                }
            }
        },
        {
            field: "num",
            title: "序号",
            width: 50,
            formatter: function(value, row, index, that) {
                var seq = index + 1;
                seq = seq + (that.options.pageNumber - 1) * that.options.pageSize;
                return seq;
            }
        },
        {
            field: "consignee",
            title: "姓名"
        },
        {
            field: "userName",
            title: "用户名",
            width: 120
        },
        {
            field: "orderNo",
            title: "订单号",
            width: 120
        },
        {
            field: "mobile",
            title: "联系方式",
            width: 120
        },
        {
            field: "address",
            title: "地址"
        },
        {
            field: "creationtime",
            title: "下单时间",
            formatter: function(value, row, index) {
                return commUtil.dateUtil.timeStampFormat(value);
            }
        },
        {
            field: "status",
            title: "订单状态",
            width: 80,
            formatter: function(value, rowm, index) {
                switch (value) {
                case 0:
                    return "待支付";
                case 1:
                    return "待发货";
                case 2:
                    return "待收货";
                case 3:
                    return "待评价";
                case 4:
                    return "交易关闭";
                case 5:
                    return "待审核";
                case 6:
                    return "交易成功";
                case 7:
                    return "参团成功";
                }
            }
        },
        {
            field: "operation",
            title: "操作",
            align: "center",
            width: 150,
            formatter: function(value, row, index) {
                if (row.isWin == 1) {
                    return "";
                }
                var arr = ["<a data-id='" + row.id + "' class='adoptApply'>通过</a>", "<a data-id='" + row.id + "' class='delTrial'>拒绝</a>"];
                return arr.join(" ");
            }
        }],
        onLoadSuccess: function(data) {
            // 激活提示框
            $("#trialPeopleListTable [data-toggle='tooltip']").tooltip();
            // 激活删除按钮事件
            $(".adoptApply").on("click",
            function() {
                var id = $(this).data("id");
                swal({
                    title: "您确定要通过该试用申请吗？",
                    text: "通过后将无法恢复为申请状态，请谨慎操作！",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "通过",
                    cancelButtonText: "取消",
                    closeOnConfirm: false,
                    timer: 5000
                },
                function(status) {

                    if (status) {
                        $.ajax({
                            type: "POST",
                            dataType: "json",
                            async: false,
                            url: basePath + "/commerce/trial/adoptApply",
                            data: {
                                id: id
                            },
                            success: function(data) {
                                if ("Y" == data.flag) {
                                    $("#trialPeopleListTable").bootstrapTable("refresh");
                                    swal("操作成功！", "您已经通过该试用申请！", "success");
                                } else {
                                    swal("操作失败！", data.message, "error");
                                }
                            }
                        });
                    }

                });
            });
            // 激活删除按钮事件
            $(".delTrial").on("click",
            function() {
                var id = $(this).data("id");
                swal({
                    title: "您确定要拒绝该试用申请吗？",
                    text: "拒绝后将无法恢复为申请状态，请谨慎操作！",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "拒绝",
                    cancelButtonText: "取消",
                    closeOnConfirm: false,
                    timer: 5000
                },
                function(status) {

                    if (status) {
                        $.ajax({
                            type: "POST",
                            dataType: "json",
                            async: false,
                            url: basePath + "/commerce/trial/deleteApply",
                            data: {
                                id: id
                            },
                            success: function(data) {
                                if ("Y" == data.flag) {
                                    $("#trialPeopleListTable").bootstrapTable("refresh");
                                    swal("操作成功！", "您已经拒绝该试用申请！", "success");
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
    $(document).ready(function() {
        //批量通过
        $("#passAll").click(function() {

            var checkArray = $('#trialPeopleListTable').bootstrapTable('getAllSelections');
            var idArray = new Array();
            $.each(checkArray,
            function(index, value) {
                idArray[index] = value.id;
            });
            if (idArray.length == 0) {
                swal("操作失败！", "请选择试用申请！", "error");
                return;
            }
            swal({
                title: "您确定要通过所选试用申请吗？",
                text: "通过后将无法恢复为申请状态，请谨慎操作！",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "通过",
                cancelButtonText: "取消",
                closeOnConfirm: false
            },
            function(status) {

                if (status) {
                    commUtil.ajaxUtil.execute({
                        url: basePath + "/commerce/trial/batchDealApply",
                        data: {
                            idArray: idArray.join(","),
                            status: 1
                        },
                        success: function(data) {
                            if ("Y" == data.flag) {
                                $("#trialPeopleListTable").bootstrapTable("refresh");
                                swal("操作成功！", "您已经通过所选试用申请！", "success");
                            } else {
                                swal("操作失败！", data.message, "error");
                            }
                        }
                    });
                }
            });

        });
    });

    //批量拒绝
    $("#refuseAll").click(function() {

        var checkArray = $('#trialPeopleListTable').bootstrapTable('getAllSelections');
        var idArray = new Array();
        $.each(checkArray,
        function(index, value) {
            idArray[index] = value.id;
        });
        if (idArray.length == 0) {
            swal("操作失败！", "请选择试用申请！", "error");
            return;
        }
        swal({
            title: "您确定要拒绝所选试用申请吗？",
            text: "拒绝后将无法恢复为申请状态，请谨慎操作！",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "拒绝",
            cancelButtonText: "取消",
            closeOnConfirm: false
        },
        function(status) {

            if (status) {
                commUtil.ajaxUtil.execute({
                    url: basePath + "/commerce/trial/batchDealApply",
                    data: {
                        idArray: idArray.join(","),
                        status: 2
                    },
                    success: function(data) {
                        if ("Y" == data.flag) {
                            $("#trialPeopleListTable").bootstrapTable("refresh");
                            swal("操作成功！", "您已经拒绝所选试用申请！", "success");
                        } else {
                            swal("操作失败！", data.message, "error");
                        }
                    }
                });
            }
        });

    });
});
 