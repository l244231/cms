define(function(require, exports, module) {

    // 全局
    require('jquery');
    require("jquery-validate");
    require("jquery-validate-messages_zh");
    require("bootstrap");
    require('sweetalert');
    var commUtil = require('commUtil');
    $(function() {
        /*
		 * //确认发货 $("#doIssue").on("click",function(){
		 * $('#IssueModal').modal('hide'); }); //取消订单
		 * $("#doCancelOrder").on("click",function(){
		 * $('#cancelOrderModal').modal('hide'); });
		 */
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

        $("#cancelOrderForm").validate({
            rules: {
                cancelReason: {
                    required: true
                }
            },
            submitHandler: function(form) {
                submitCancelOrderForm();
            }
        });
    })

    // 确认发货
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
                commUtil.ajaxUtil.execute({
                    url: basePath + "/commerce/order/send",
                    data: {
                        orderNo: $("#orderNo").text(),
                        deliveryCompany: $("#express").find("option:selected").text(),
                        deliveryNub: $("#expressNo").val()
                    },
                    success: function(data) {
                        if ("Y" == data.flag) {
                            $('#IssueModal').modal('hide');
                            swal({
                                title: "成功",
                                text: "操作成功",
                                type: "success"
                            },
                            function() {
                                location.href = basePath + "/commerce/order/detail?orderNo=" + $("#orderNo").text();
                            });
                        } else {
                            swal("操作失败！", data.message, "error");
                        }
                    }
                });
            }
        });
    }

    // 取消订单
    function submitCancelOrderForm() {

        commUtil.ajaxUtil.execute({
            url: basePath + "/commerce/order/cancel",
            data: {
                orderNo: $("#orderNo").text(),
                cancelReason: $("#cancelReason").val()
            },
            success: function(data) {
                if ("Y" == data.flag) {
                    $('#cancelOrderModal').modal('hide');
                    swal({
                        title: "成功",
                        text: "操作成功",
                        type: "success"
                    },
                    function() {
                        location.href = basePath + "/commerce/order/detail?orderNo=" + $("#orderNo").text();
                    });
                } else {
                    swal("操作失败！", data.message, "error");
                }
            }
        });
    }

})