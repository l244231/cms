define(function(require, exports, module) {

    // 全局
    require('jquery');
    require("bootstrap");
    require("bootstrap-select");
    // Bootstrap table
    require('bootstrap-table');
    require('bootstrap-table-zh-CN');
	require('sweetalert');
    var commUtil = require('commUtil');

    $(function(){
    	
    	$('#inTheSaleTable').bootstrapTable({
            url: basePath + "/commerce/commodity/search",
            pagination: true,
            sidePagination: "server",
            showColumns: true,
            sortable: true,
            showAddBut: false,
            checkboxHeader:true,
            toolbar : '#commodityGroupTableToolbar', 
            showQueryBut: true,
            queryButEvent: function(e) {
                $('#inTheSaleTable').bootstrapTable("refresh");
            },
            pageList: [5, 10, 20, 50],
            pageNumber: 1,
            // 初始化加载第一页，默认第一页
            pageSize: 20,
            checkbox:true,
            singleSelect:true,
            icons: {
                refresh: 'glyphicon-repeat',
                toggle: 'glyphicon-list-alt',
                columns: 'glyphicon-list'
            },
            queryParams: function(params) {
                params.categoryId = $("#categoryId").val();
                params.storeId = $("#storeId").val();
                params.name = $("#keyword").val();
                return params;
            },
            columns: [ {
                title: "序号",
                field: "num",
                checkbox: true,
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
                title: "排序",
                field: "sortId",
                width: 80,
                align: "center"
            },
            {
                title: "预览图",
                field: "icon",
                align: "center",
                formatter: function(value, row, index) {
                    /*var arr = ["<div  class='thumbnail' style='margin-bottom:0px;'>",
                    	"<img style='width:50px;height:50px;' src='"+basePath+"/commerce/binaryFile/getFileById?iconId="+row.listIconId+"'>",
                    	"</div>"];
                    return arr.join(" ");*/
                    return '<img style="width:50px;height:50px;"  src="'+basePath+'/commerce/binaryFile/getFileById?id='+row.listIconId+'">';
                }
            },
            {
                title: "所属店铺",
                field: "storeName",
                align: "center"
            },
            {
                title: "所属分类",
                field: "categoryName",
                align: "center"
            },
            {
                title: "原价",
                field: "price",
                width: 80,
                align: "center"
            },
            {
                title: "现价",
                field: "currentPrice",
                width: 80,
                align: "center"
            },
            {
                title: "库存",
                field: "stock",
                width: 80,
                align: "center"
            },
            {
                title: "销量",
                field: "sale",
                width: 80,
                align: "center"
            },
            {
                title: "人气",
                field: "popularity",
                width: 80,
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
    	
    	//选择商品-->确定
    	$("#confirmBut").click(function(){
    		var array = $('#inTheSaleTable').bootstrapTable('getSelections');
        	var idArr = new Array();
        	if(array.length<=0){
        		swal({
					title : "请选择商品",
					type : "warning"
				});
        	}else{
        		for(var i=0;i<array.length;i++){
            		idArr[i] = array[i].id
            	}
            	location.href=basePath+"/commerce/"+$("#commodityTypeForUrl").val()+"/"+$("#method").val()+"?commodityId="+idArr.join(",");
        	}
        	
    	})
    	
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
    				var $optgroup=$("<optgroup label='"+p.name+"'></optgroup>");
    				$.each(nodeArr,function(j,n){  
    			    	if(n.parentId==p.id){
    			    		$optgroup.append("<option value='"+n.id+"'>"+n.name+"</option>");
    			    	}
    			    });
    				$("#categoryId").append($optgroup);
    		    });
    			$('#categoryId').selectpicker('refresh');
    			$('#categoryId').selectpicker('setStyle', 'w-150', 'add');
    		}
    	});
    	
    })
})