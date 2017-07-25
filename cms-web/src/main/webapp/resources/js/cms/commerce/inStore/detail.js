define(function(require, exports, module) {

    // 全局
    require('jquery');
    require("bootstrap");
    // Bootstrap table
    require('bootstrap-table');
    require('bootstrap-table-zh-CN');
	require('sweetalert');
    var commUtil = require('commUtil');

    $('#inTheSaleTable').bootstrapTable({
        url: basePath + "/commerce/inStore/search",
        pagination: true,
        sidePagination: "server",
        showColumns: true,
        sortable: true,
        pageList: [5, 10, 20, 50],
        pageNumber: 1,
        // 初始化加载第一页，默认第一页
        pageSize: 10,
        checkbox:true,
        icons: {
            refresh: 'glyphicon-repeat',
            toggle: 'glyphicon-list-alt',
            columns: 'glyphicon-list'
        },
        queryParams: function(params) {
            return params;
        },
        columns: [ {
            title: "序号",
            field: "num",
            radio: true,
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
            align: "center"
        },
        {
            title: "入库数量",
            field: "inStoreAmount",
            width: 80,
            align: "center"
        },
        {
            title: "库存总量",
            field: "storeAmount",
            align: "center"
        },
        {
            title: "入库时间",
            field: "inStoreTime",
            align: "center",
            formatter:function(value,row,index){
            	return commUtil.dateUtil.timeStampFormat(value);
            }
        },
        {
            title: "入库批次",
            field: "batchNumber",
            align: "center"
        },{
        	title: "id",
            field: "id",
            visible : false
        }],
        onLoadSuccess: function(data) {
            // 激活提示框
            $("#inTheSaleTable [data-toggle='tooltip']").tooltip(); 
        }
    }); 
})