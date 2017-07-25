define(function(require,exports,module){
	
	//全局
	require('jquery');
	require("bootstrap");
	//Bootstrap table
	require('bootstrap-table');
	require('bootstrap-table-zh-CN');
	
	$(function(){
		
	})
	$('#audiovisualTable').bootstrapTable({
		//url: basePath+"/resources/js/demo/bootstrap_table_test.json",
		data:[{id:1},{id:2},{id:3}],
		//search: true,
		pagination: true,
		showRefresh: true,
		showToggle: true,
		showColumns: true,
		pageSize:5,
		pageList:[5,10,15,'ALL'],
		toolbar: '#audiovisualTableToolbar',
		icons: {
			refresh: 'glyphicon-repeat',
			toggle: 'glyphicon-list-alt',
			columns: 'glyphicon-list'
		},
		columns:[
		        {field:"id",title:"序号",width:50,align:"center"},
		        {field:"title",title:"标题",width:120},
		        {field:"seq",title:"排序"},
		        {field:"type",title:"类型"},
		        {field:"isindex",title:"推荐到首页"},
		        {field:"remarks",title:"介绍",width:150},
		        {field:"status",title:"状态"},
		        {field:"operation",title:"操作",width:100,align:"center",formatter:function(value,row,index){
		        	var arr=["<a>编辑</a>","<a>删除</a>"];
		    		return arr.join(" ");
		        }}
		]
	});
	
	$(".addBut").on("click",function(event){
		location.href=basePath+"/audiovisual/add";
		//window.open(basePath+"/from")
	});
})