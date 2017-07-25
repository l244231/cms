define(function(require, exports, module) {

	// 全局
	require('jquery');
	require("bootstrap");
	require("bootstrap-prettyfile");
	require("bootstrap-clockpicker");
	require("jquery-validate");
	require("jquery-validate-messages_zh");
	 require('bootstrap-table');
	    require('bootstrap-table-zh-CN');
	//require("jquery-uploadPreview");
	/*require("laydate");*/
	//require("wysiwyg-custom");
	
	var commUtil = require('commUtil');
	
	
	$(document).ready(function () {
		
		$('#PoiListTable').bootstrapTable({
            url: basePath + "/market/ncpShop/searchPoiData",
            pagination: true,
            sidePagination: "server",
            showColumns: true,
            sortable: true,
            showQueryBut: true,
            toolbar : '#PoiListToolbar', 
            queryButEvent: function(e) {
                $('#PoiListTable').bootstrapTable("refresh");
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
                params.keyWord = $("#keyWord").val();
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
            	title: "POI名称",
            	field: "name",
            	align: "center"
            }, 
            {
                title: "楼层名称",
                field: "floorName",
                align: "center"
            },
            {
            	title : "楼层ID",
            	field: "floorId",
            	vaisble:false
            },
            {
            	title: "id",
                field: "poiId",
                visible : false
            }],
            onLoadSuccess: function(data) {
                // 激活提示框
                $("#inTheSaleTable [data-toggle='tooltip']").tooltip(); 
            }
        });
		
		//POI选择确认
		$("#doPoi").click(function(){
			var check =  $('#PoiListTable').bootstrapTable('getSelections');
			$("#poiId").val(check[0].poiId);
			$("#PoiModal").modal("hide");
			$("#floorId").val(check[0].floorId);
		});

		$('.clockpicker').clockpicker();
		//图片删除按钮事件
		$(".thumbnailClose").click(function(){
			$(this).parent().parent("div:eq(0)").remove();
		})
		$('#imgList').prettyFile({
			format:[ "gif", "jpeg", "jpg", "bmp", "png" ],
			showImg:true,
			text:"选择图片(多选)",
			buttonId:"addCommodity",
			imgData:{
				imgObjId: "showImgDiv",
				width:100,
				height:100
			}
		});
		$('#logoImg').prettyFile({
			format:[ "gif", "jpeg", "jpg", "bmp", "png" ],
			showImg:true,
			imgData:{
				imgObjId: "logoPr",
				width:200,
				height:200
			}
		});
		$('#bigImg').prettyFile({
			format:[ "gif", "jpeg", "jpg", "bmp", "png" ],
			showImg:true,
			imgData:{
				imgObjId: "bigimgPr",
				width:375,
				height:105
			}
		});
		$('#homeImg').prettyFile({
			format:[ "gif", "jpeg", "jpg", "bmp", "png" ],
			showImg:true,
			imgData:{
				imgObjId: "homeimgPr",
				width:375,
				height:105
			}
		});
		$("#isHome").change(function(){
			var $this=$(this);
			if($this.val()=="1"){
				$("#homeImgDiv").show();
			}else if($this.val()=="0"){
				$("#homeImgDiv").hide();
			}
		})
    });
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#brandForm").validate({
		rules : {
			title : {
				required : true
			},
			sort: {
				required : true
			},
			poiId : {
				required : true
			},
			add : {
				required : true
			},
			floorId : {
				required : true
			},
			isVirtual : {
				required : true
			},
			isHome : {
				required : true
			},
			shopType : {
				required : true
			}
		},
		messages : {
			
		},submitHandler:function(form){
			if(validateFile()){
				submitFrom();
			}
        }
	});
	
	function validateFile(){
		if(!$.trim($("#id").val())){
			if($("#logoImg")[0].files.length<=0){
				swal({
					title : "警告",
					text : "品牌logo图片不能为空",
					type : "warning"
				})
				return false;
			}
			
			if($("#bigImg")[0].files.length<=0){
				swal({
					title : "警告",
					text : "大图片不能为空",
					type : "warning"
				})
				return false;
			}
			
			if($("#imgList")[0].files.length<=0){
				swal({
					title : "警告",
					text : "商品展示图不能为空",
					type : "warning"
				})
				return false;
			}
			
		}
		
		if($("#haveHomeImg").val()=="N"){
			if($("#isHome").val()=="1"){
				if($("#homeImg")[0].files.length<=0){
					swal({
						title : "警告",
						text : "推荐首页图片不能为空",
						type : "warning"
					},function(){
						$("html,body").animate({scrollTop:$("#file_homeImg").offset().top},200);
					});
					return false;
				}
			}
		}else{
			
		}
		return true;
	}

	function submitFrom(){
		var formData = new FormData($("#brandForm")[0]);
		if($("#imgList")[0].files.length<=0){
			formData.delete("imgList");
		}
		if($("#bigImg")[0].files.length<=0){
			formData.delete("bigImg");
		}
		if($("#logoImg")[0].files.length<=0){
			formData.delete("logoImg");
		}
		if($("#homeImg")[0].files.length<=0){
			formData.delete("homeImg");
		}
		//formData.append("shopInfo",$('#ppjs').wysiwyg("getEditor"));
		formData.append("floorName", $("#floorId").find("option:selected").text());
		commUtil.ajaxUtil.execute({
			url: basePath + "/market/ncpShop/save",
			data: formData,
			/**   
             * 必须false才会避开jQuery对 formdata 的默认处理   
             * XMLHttpRequest会对 formdata 进行正确的处理   
             */  
            processData : false,  
            /**   
             *必须false才会自动加上正确的Content-Type   
             */  
            contentType : false,
			success: function(data) {
				if(data.flag=="Y"){
					swal({
						title : "成功",
						text : "保存成功",
						type : "success"
					},function(){
						commUtil.redirectUtil(
								basePath+"/market/ncpShop/page"
								
								);
					});
				}else{
                    swal("失败",data.message, "error");
				}
			}
		});
	}
})