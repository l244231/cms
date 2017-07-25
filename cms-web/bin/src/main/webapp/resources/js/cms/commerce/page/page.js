define(function(require,exports,module){
	
	//全局
	require('jquery');
	require("bootstrap");
	//自定义js
	require('content');
	//Bootstrap table
	require('bootstrap-table');
	require('bootstrap-table-zh-CN');
	
	
	$('#exampleTableEvents').bootstrapTable({
		url: basePath+"/resources/js/demo/bootstrap_table_test.json",
		search: true,
		pagination: true,
		showRefresh: true,
		showToggle: true,
		showColumns: true,
		pageSize:5,
		pageList:[5,10,'ALL'],
		toolbar: '#exampleTableEventsToolbar',
		icons: {
			refresh: 'glyphicon-repeat',
			toggle: 'glyphicon-list-alt',
			columns: 'glyphicon-list'
		},
		columns:[
		        {field:"state",checkbox:true},
		        {field:"id",title:"ID",width:50,align:"center"},
		        {field:"img",title:"图片",width:120,align:"center",formatter:function(value,row,index){
		        	return "<img  src='"+basePath+"/resources/img/a9.jpg' width='100' height='100'></img>";
		        }},
		        {field:"name",title:"名称"},
		        {field:"price",title:"价钱"},
		        {field:"operation",title:"操作",width:100,align:"center",formatter:function(value,row,index){
		        	var arr=["<a>编辑</a>","<a>删除</a>"];
		    		return arr.join(" ");
		        }}
		]
	});
	$('#exampleTableEvents2').bootstrapTable({
		url: basePath+"/resources/js/demo/bootstrap_table_test3.json",
		search: true,
		pagination: true,
		showRefresh: true,
		showToggle: true,
		showColumns: true,
		pageSize:5,
		pageList:[5,10,'ALL'],
		toolbar: '#exampleTableEventsToolbar2',
		icons: {
			refresh: 'glyphicon-repeat',
			toggle: 'glyphicon-list-alt',
			columns: 'glyphicon-list'
		},
		columns:[
		        {field:"state",checkbox:true},
		        {field:"id",title:"ID",width:50,align:"center"},
		        {field:"img",title:"图片",width:120,align:"center",formatter:function(value,row,index){
		        	return "<img  src='"+basePath+"/resources/img/a9.jpg' width='100' height='100'></img>";
		        }},
		        {field:"name",title:"名称"},
		        {field:"price",title:"价钱"},
		        {field:"operation",title:"操作",width:100,align:"center",formatter:function(value,row,index){
		        	var arr=["<a>编辑</a>","<a>删除</a>"];
		    		return arr.join(" ");
		        }}
		]
	});
})