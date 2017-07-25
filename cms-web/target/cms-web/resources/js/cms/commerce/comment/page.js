define(function(require, exports, module) {

    // 全局
    require('jquery');
    require("bootstrap");
    // Bootstrap table
    require('bootstrap-table');
    require('bootstrap-table-zh-CN');
    var commUtil = require('commUtil');

    $('#examineTable').bootstrapTable({
        //url: basePath + "/commerce/commodity/search",
    	data:[{"评论内容":"评论内容","评论人":"评论人","评论图":"评论图",
    		"评论星级":"评论星级","商品名称":"商品名称","订单号":"订单号","评论时间":"评论时间"}],
        pagination: true,
        sidePagination: "server",
        showColumns: true,
        sortable: true,
        showQueryBut: true,
        queryButEvent: function(e) {
            $('#examineTable').bootstrapTable("refresh");
        },
        pageList: [5, 10, 20, 50],
        pageNumber: 1,
        // 初始化加载第一页，默认第一页
        pageSize: 10,
        toolbar: '#examineTableToolbar',
        icons: {
            refresh: 'glyphicon-repeat',
            toggle: 'glyphicon-list-alt',
            columns: 'glyphicon-list'
        },
        queryParams: function(params) {
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
            title: "评论内容",
            field: "评论内容",
            align: "center"
        },
        {
            title: "评论人",
            field: "评论人",
            align: "center"
        },
        {
            title: "评论图",
            field: "评论图",
            formatter: function(value, row, index) {
                var arr = ["<div  class='thumbnail' style='margin-bottom:0px;'>",
                	"<img style='width:50px;height:50px;' src='"+basePath+"/commerce/binaryFile/getFileById?iconId="+row.listIconId+"'>",
                	"</div>"];
                return arr.join(" ");
            }
        },
        {
            title: "评论星级",
            field: "评论星级"
        },
        {
            title: "商品名称",
            field: "商品名称"
        },
        {
            title: "订单号",
            field: "订单号"
        },
        {
            title: "评论时间",
            field: "评论时间"
        },
        {
            field: "operation",
            title: "操作",
            width: 150,
            align: "center",
            formatter: function(value, row, index) {
                var arr = [
                	"<a data-id='" + row.id + "' class=''>通过</a>", 
                	"<a data-id='" + row.id + "' class=''>删除</a>"];
                return arr.join(" ");
            }
        }],
        onLoadSuccess: function(data) {
            
        }
    });
    
    $('#releaseTable').bootstrapTable({
        //url: basePath + "/commerce/commodity/search",
    	data:[{"评论内容":"评论内容","评论人":"评论人","评论图":"评论图",
    		"评论星级":"评论星级","商品名称":"商品名称","订单号":"订单号","评论时间":"评论时间"}],
        pagination: true,
        sidePagination: "server",
        showColumns: true,
        sortable: true,
        showQueryBut: true,
        queryButEvent: function(e) {
            $('#releaseTable').bootstrapTable("refresh");
        },
        pageList: [5, 10, 20, 50],
        pageNumber: 1,
        // 初始化加载第一页，默认第一页
        pageSize: 10,
        toolbar: '#releaseTableToolbar',
        icons: {
            refresh: 'glyphicon-repeat',
            toggle: 'glyphicon-list-alt',
            columns: 'glyphicon-list'
        },
        queryParams: function(params) {
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
            title: "评论内容",
            field: "评论内容",
            align: "center"
        },
        {
            title: "评论内容",
            field: "评论人",
            align: "center"
        },
        {
            title: "评论图",
            field: "评论图",
            formatter: function(value, row, index) {
                var arr = ["<div  class='thumbnail' style='margin-bottom:0px;'>",
                	"<img style='width:50px;height:50px;' src='"+basePath+"/commerce/binaryFile/getFileById?iconId="+row.listIconId+"'>",
                	"</div>"];
                return arr.join(" ");
            }
        },
        {
            title: "评论星级",
            field: "评论星级"
        },
        {
            title: "商品名称",
            field: "商品名称"
        },
        {
            title: "订单号",
            field: "订单号"
        },
        {
            title: "评论时间",
            field: "评论时间"
        },
        {
            field: "operation",
            title: "操作",
            width: 150,
            align: "center",
            formatter: function(value, row, index) {
                var arr = [
                	"<a data-id='" + row.id + "' class=''>删除</a>"];
                return arr.join(" ");
            }
        }],
        onLoadSuccess: function(data) {
            
        }
    });
    
})