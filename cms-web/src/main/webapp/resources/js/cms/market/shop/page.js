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
    $.setPageCookie("shopPage",isBack);
    $('#brandTable').bootstrapTable({
        url: basePath + "/market/ncpShop/search",
        pagination: true,
        sidePagination: "server",
        showColumns: true,
        sortable: true,
        showAddBut: true,
        addButEvent: function(e) {
            location.href = basePath + "/market/ncpShop/add";
        },
        showQueryBut: true,
        queryButEvent: function(e) {
            $('#brandTable').bootstrapTable("refresh");
        },
        pageList: [5, 10, 20, 50],
        pageNumber: 1,
        // 初始化加载第一页，默认第一页
        pageSize: 10,
        // 每页的记录行数（*）
        toolbar: '#brandTableToolbar',
        icons: {
            refresh: 'glyphicon-repeat',
            toggle: 'glyphicon-list-alt',
            columns: 'glyphicon-list'
        },
        queryParams: function(params) {
            params.keyWord = $("#keyWord").val();
            params.isHome = $("#isHome").val();
            $.cookie("shopPage",JSON.stringify(params));
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
            field: "shopName",
            title: "品牌名称",
            sortable : true
        },
        {
            field: "floorName",
            title: "商铺楼层",
            width: 80,
            sortable : true
        },
        {
            field: "address",
            title: "商铺地址",
            sortable : true
        },
        {
            field: "shopType",
            title: "品牌分类",
            width: 120,
            sortable : true
        },
        {
            field: "tel",
            title: "联系电话",
            width: 150,
            sortable : true
        },
        {
            field: "cpc",
            title: "人均消费",
            width: 80,
            sortable : true
        },
        {
            field: "isHome",
            title: "推荐到首页",
            width: 120,
            formatter: function(value, row, index) {
                if (value == 1) {
                    return "<a data-id='" + row.id + "' data-isHome='0' class='recom'>取消推荐</a>";
                } else {
                    return "<a data-id='" + row.id + "' data-isHome='1' class='recomBrand'>推荐到首页</a>";
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
                var arr = ["<a data-id='" + row.id + "' class='detialBrand'>查看</a>", "<a data-id='" + row.id + "' class='editBrand'>编辑</a>", "<a data-id='" + row.id + "' class='delBrand'>删除</a>"];
                return arr.join(" ");
            }
        }],
        onLoadSuccess: function(data) {
            // 激活提示框
            $("#brandTable [data-toggle='tooltip']").tooltip();
            // 激活删除按钮事件
            $(".delBrand").on("click",
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
                    closeOnConfirm: false
                },
                function(status) {
                    if (status) {
                        commUtil.ajaxUtil.execute({
                            url: basePath + "/market/ncpShop/delete",
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
                                    $('#brandTable').bootstrapTable("selectPage", 1);
                                } else {
                                    swal("删除失败！", data.message, "error");
                                }
                            }
                        });
                    }
                });
            });
            $(".editBrand").on("click",
            function(e) {
                location.href = basePath + "/market/ncpShop/edit?id=" + $(this).data("id");
            });
            $(".recomBrand").on("click",
            function(e) {
            	var id = $(this).data("id");
            	swal({title:"操作提示！", text:"推荐到首页需上传该品牌首页推荐logo，请进入详情添加", type:"info"},function(){
            		location.href = basePath + "/market/ncpShop/edit?id=" + id+"&recom=true";
            	});
            });
            $(".detialBrand").on("click",
            function(e) {
                location.href = basePath + "/market/ncpShop/detail?id=" + $(this).data("id");
            });
            $(".recom").on("click",
            function() {
                var id = $(this).data("id");
                var title, text;
                var isHome = $(this).data("ishome");
                if ($(this).data("ishome") == "0") {
                    title = "您确定要取消推荐到首页吗？";
                    text = "确定后将会取消推荐到首页";
                } else if ($(this).data("ishome") == "1") {

                    title = "您确定要推荐到首页吗？";
                    text = "确定后将会推荐到首页";
                }
                swal({
                    title: title,
                    text: text,
                    type: "info",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    closeOnConfirm: false
                },
                function(status) {
                    if (status) {
                        commUtil.ajaxUtil.execute({
                            url: basePath + "/market/ncpShop/recommendShop",
                            data: {
                                id: id,
                                isHome: isHome
                            },
                            success: function(data) {
                                var flag = data.flag;
                                if ("Y" == flag) {
                                    swal({
                                        title: data.message,
                                        type: "success"
                                    });
                                    $('#brandTable').bootstrapTable("selectPage", 1);
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
        // 动态绑定事件
        // $("#audiovisualTable").on("click",".delAudiovisual", function() {})
    });

});