 
define(function(require, exports, module) {
	require('jquery');
	
	$(function(){
		$("#addSpec").on("click",function(){
			var $addSpecDiv=$("#addSpecDiv");
			var $row=$("<div class='row m-b-md' ></div>");
			var $nodeCol=$("<div class='col-md-5'></div>");
			var $node=$("<input type='text' placeholder='请输入子规格'  class='form-control nodeInput' >");
			$nodeCol.append($node);
			var $numCol=$("<div class='col-md-5'></div>");
			var $num=$("<input type='text' placeholder='请输入价格增加值' class='form-control numInput' >");
			$numCol.append($num);
			var $delCol=$("<div class='col-md-2'></div>");
			var $del=$("<a class='delSpec' href='javascript:void(0);'></a>")
			$del.append("<i style='font-size:30px;color:red;' class='fa fa-close'></i>");
			
			$delCol.append($del);
			
			$row.append($nodeCol).append($numCol).append($delCol);
			$addSpecDiv.append($row);
		});
		
		$("#addColor").on("click",function(){
			var $addColorDiv=$("#addColorDiv");
			var $row=$("<div class='row m-b-md' ></div>");
			var $nodeCol=$("<div class='col-md-5'></div>");
			var $node=$("<input type='text' placeholder='请输入分类名称' class='form-control nodeInput' >");
			$nodeCol.append($node);
			var $numCol=$("<div class='col-md-5'></div>");
			var $num=$("<input type='text' placeholder='请输入价格增加值' class='form-control numInput' >");
			
			var $delCol=$("<div class='col-md-2'></div>");
			var $del=$("<a class='delSpec' href='javascript:void(0);'></a>")
			$del.append("<i style='font-size:30px;color:red;' class='fa fa-close'></i>");
			
			$delCol.append($del);
			
			$numCol.append($num);
			$row.append($nodeCol).append($numCol).append($delCol);
			$addColorDiv.append($row);
		});
		$("#addSpecDiv").on("click",".delSpec",function(e){
			debugger;
			var $this=$(this);
			$this.parent().parent("div:eq(0)").remove();
		})
		$("#addColorDiv").on("click",".delSpec",function(e){
			var $this=$(this);
			$this.parent().parent("div:eq(0)").remove();
		})
		
	})
	
	module.exports = {
		getSpecs:function(){
			
			//default
			var rows=[];
			
			//add
			var $addSpecDiv=$("#addSpecDiv");
			$addSpecDiv.find(".row").each(function(i,e){
				rows.push({
					specName:$(e).find(".nodeInput").val(),
					priceFluctuation:$(e).find(".numInput").val()
				});
			})
			return JSON.stringify(rows);
		},
		getColors:function(){
			//default
			var rows=[];
			
			//add
			var $addColorDiv=$("#addColorDiv");
			$addColorDiv.find(".row").each(function(i,e){
				rows.push({
					colorName:$(e).find(".nodeInput").val(),
					priceFluctuation:$(e).find(".numInput").val()
				});
			})
			return JSON.stringify(rows);
		}
	};
	
});