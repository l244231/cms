define(function(require, exports, module) {

    // 全局
    require('jquery');
    require("bootstrap");
    // Bootstrap table
    require('bootstrap-table');
    require('bootstrap-table-zh-CN');
    var commUtil = require('commUtil');

    $('#userTable').bootstrapTable({
        //url: basePath + "/commerce/commodity/search",
    	data:[{"用户名":"张三","手机号":"13800000000","是否会员":"是",
    		"小区业主":"是","写字楼工作人员":"是","会员卡号":"1231","剩余积分":"2600"}],
        pagination: true,
        sidePagination: "server",
        showColumns: true,
        sortable: true,
        showQueryBut: true,
        queryButEvent: function(e) {
            $('#userTable').bootstrapTable("refresh");
        },
        pageList: [5, 10, 20, 50],
        pageNumber: 1,
        // 初始化加载第一页，默认第一页
        pageSize: 10,
        toolbar: '#userTableToolbar',
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
            title: "用户名",
            field: "用户名",
            align: "center"
        },
        {
            title: "手机号",
            field: "手机号",
            align: "center"
        },
        {
            title: "是否会员",
            field: "是否会员"
        },
        {
            title: "小区业主",
            field: "小区业主"
        },
        {
            title: "写字楼工作人员",
            field: "写字楼工作人员"
        },
        {
            title: "会员卡号",
            field: "会员卡号"
        },{
            title: "剩余积分",
            field: "剩余积分"
        },
        {
            field: "operation",
            title: "操作",
            width: 150,
            align: "center",
            formatter: function(value, row, index) {
                var arr = [
                	"<a data-id='" + row.id + "' class=''>查看</a>"];
                return arr.join(" ");
            }
        }],
        onLoadSuccess: function(data) {
            
        }
    });
})