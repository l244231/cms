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
    $.setPageCookie("trialPage",isBack);
    $('#trialListTable').bootstrapTable({
        url: basePath + "/commerce/trial/search",
        // search: true,
        pagination: true,
        // showRefresh: true,
        // showToggle: true,
        sidePagination: "server",
        contentType: 'application/json;charset=UTF-8',
        showColumns: true,
        sortable: true,
        showAddBut: true,
        addButEvent: function(e) {
            location.href = basePath + "/commerce/trial/add";
        },
        showQueryBut: true,
        queryButEvent: function(e) {
            $('#trialListTable').bootstrapTable("refresh");
        },
        pageList: [5, 10, 20, 50],
        pageNumber: 1,
        // 初始化加载第一页，默认第一页
        pageSize: 10,
        // 每页的记录行数（*）
        toolbar: '#trialListToolbar',
        icons: {
            refresh: 'glyphicon-repeat',
            toggle: 'glyphicon-list-alt',
            columns: 'glyphicon-list'
        },
        queryParams: function(params) {
            params.keyWord = $("#keyWord").val();
            params.type = $("#type").val();
            params.status = $("#status").val();
			$.cookie("trialPage",JSON.stringify(params));
            return params;
        },
        columns: [{
            field: "num",
            title: "序号",
            width: 50,
            align: "center",
            formatter: function(value, row, index, that) {
                var seq = index + 1;
                seq = seq + (that.options.pageNumber - 1) * that.options.pageSize;
                return seq;
            }
        },
        {
            field: "name",
            title: "商品名",
            sortable : true
        },
        {
            field: "listIconId",
            title: "预览图",
			width : 120,
            formatter: function(value, row, index) {
                var arr = ["<div  class='thumbnail' style='margin-bottom:0px;'>",
                	"<img style='width:50px;height:50px;'  src='"+basePath+"/commerce/binaryFile/getFileById?id="+value+"'>",
                	"</div>"];
                return arr.join(" ");
            }
        },
        {
            field: "stock",
            title: "库存",
            width : 80,
            sortable : true
        },
        {
            field: "type",
            title: "试用类型",
            width : 80,
            formatter: function(value) {
                return value == 1 ? "免费": "付邮";
            },
            sortable : true
        },
        {
            field: "numberPeopleActual",
            title: "申请人数",
            width : 80,
            formatter: function(value, row, index) {
                return "<a style='text-decoration:underline' data-id='" + row.id + "' class='detailPeople'>" + value + "</a>"
            },
            sortable : true
        },
        {
            field: "sortId",
            title: "排序",
            sortable: true,
			width : 80,
            sortable : true
        },
        {
            field: "homeRecommended",
            title: "推荐到首页",
            width : 100,
            formatter: function(value, row, index) {
                if (value == 0) {
                    return "<a data-id='" + row.id + "' class='recommendTrial'>推荐首页</a>";
                } else {
                    return "<a data-id='" + row.id + "' class='unRecommendTrial'>取消推荐</a>";
                }
            },
            sortable : true
        },
        {
            field: "startTime",
            title: "开始时间",
            width:100,
            formatter: function(value, row, index) {
                return commUtil.dateUtil.timeStampFormat(value);
            },
            sortable : true
        },
        {
            field: "expiryTime",
            title: "结束时间",
            width:100,
            formatter: function(value, row, index) {
                return value == null ? "": commUtil.dateUtil.timeStampFormat(value);
            },
            sortable : true
        },
        {
            field: "operation",
            title: "操作",
            width: 120,
            align: "center",
            formatter: function(value, row, index) {
                var arr = ["<a data-id='" + row.id + "' class='detailTrial'>查看</a>",
                           "<a data-id='" + row.id + "' class='editTrial'>编辑</a>",
                           "<a data-id='" + row.id + "' class='delTrial'>删除</a>"];
                return arr.join(" ");
            }
        }],
        onLoadSuccess: function(data) {
            // 激活提示框
            $("#trialListTable [data-toggle='tooltip']").tooltip();
            // 激活删除按钮事件
            $(".delTrial").on("click",
            function() {
                var id = $(this).data("id");
                swal({
                    title: "您确定要删除这条信息吗",
                    text: "删除后将无法恢复，请谨慎操作！",
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
                    		url: basePath + "/commerce/trial/delete",
                    		data: {
                                id: id
                            },
                            success: function(data) {
                                if ("Y" == data.flag) {
                                    $("#trialListTable").bootstrapTable("refresh");
                                    swal("删除成功！", "您已经永久删除了这条信息。", "success");
                                } else {
                                    swal("删除失败！", data.message, "error");
                                }
                            }
   						});
                    }

                });
            });
            $(".detailTrial").on("click",
            function(e) {
                location.href = basePath + "/commerce/trial/detail?id=" + $(this).data("id");
            });
            $(".editTrial").on("click",
            function(e) {
                location.href = basePath + "/commerce/trial/edit?id=" + $(this).data("id");
            });
            
            $(".detailPeople").on('click',
            function(e) {
                location.href = basePath + "/commerce/trial/peoplePage?id=" + $(this).data("id");
            });
            $(".recommendTrial").on("click",
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
                    		 url: basePath + "/commerce/trial/recommendTrial",
                    		 data: {
                                 id: id,
                                 param: 1
                             },
                             success: function(data) {
                                 if ("Y" == data.flag) {
                                 	swal("推荐成功！", "您已成功将该信息推荐到首页。", "success");
                                     $("#trialListTable").bootstrapTable("refresh");
                                 } else {
                                     swal("推荐失败！", data.message, "error");
                                 }
                             }
						});
                    }
                });
            });
            $(".unRecommendTrial").on("click",
                    function(e) {
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
                            		url: basePath + "/commerce/trial/recommendTrial",
                            		data: {
                                        id: id,
                                        param: 0
                                    },
                                    success: function(data) {
                                        if ("Y" == data.flag) {
                                        	swal("取消成功！", "您已成功将该信息从首页中移除。", "success");
                                            $("#trialListTable").bootstrapTable("refresh");
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
    $(document).ready(function() {
        // 动态绑定事件
        // $("#audiovisualTable").on("click",".delAudiovisual", function() {})
    });

});