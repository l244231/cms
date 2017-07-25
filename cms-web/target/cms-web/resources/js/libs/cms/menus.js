 
define(function(require, exports, module) {
	require('jquery');
	
	var menus=[
	 	{
	 		tid:"1",
	 		tname:"KiNG88管理",
	 		menu:[{
					url:"/market/audiovisual/page",
					name:"每日视听管理",
					active:false,
					icon:"menu-st"
				},{
					url:"/market/ncpShop/page",
					name:"品牌管理",
					active:false,
					icon:"menu-pp"
				},{
					url:"/market/user/page",
					name:"用户管理",
					active:false,
					icon:"menu-user"
				}/*,{
					url:"",
					name:"测试",
					active:false,
					icon:"fa-shopping-cart",
					children:[
						{
							url:"http://www.baidu.com",
							name:"菜单1"
						},
						{
							url:"",
							name:"菜单2"
						},
						{
							url:"",
							name:"菜单3"
						}
					]
				}*/
			]
	 	},{
	 		tid:"2",
	 		tname:"线上商城",
	 		menu:[
	 		      {
					url:"/commerce/commodity/page",
					name:"商品管理",
					active:false,
					icon:"menu-sp"
	 			},{
					url:"/commerce/commodityGroup/page",
					name:"团购爆款",
					active:false,
					icon:"menu-tg"
				},{
					url:"/commerce/trial/page",
					name:"热门试用",
					active:false,
					icon:"menu-shiy"
				},{
					url:"/commerce/benefit/page",
					name:"限时优惠",
					active:false,
					icon:"menu-yh"
				},{
					url:"/commerce/hot/page",
					name:"爆款榜单",
					active:false,
					icon:"menu-bk"
				}/*,{
					url:"/commerce/commodity/page",
					name:"商品列表",
					active:false,
					icon:"fa-shopping-cart"
				}*/,{
					url:"/commerce/order/page",
					name:"订单管理",
					active:false,
					icon:"menu-dd"
				},{
					url:"/commerce/comment/page",
					name:"评论管理",
					active:false,
					icon:"menu-pl"
				}
			]
	 	}
	]
	
	$.each(menus,function(i,e){
		//先判断模块名称是否为空  添加分类标签
		var tname=e.tname;
		var menu=e.menu;
		if($.trim(tname)){
			var $ng_scope="<li class='hidden-folded padder m-t m-b-sm text-muted text-xs'>" +
								"<span class='ng-scope'>"+tname+"</span>" +
						  "</li>";
			$("#side-menu").append($ng_scope);
		}
		
		$.each(menu,function(j,m){
			var url=m.url;
			var icon=m.icon;
			var children=m.children;
			
			//检查url是否合法
			if(!checkeURL(url)){
				if(!$.trim(url)){
					url="#";
				}else{
					url=basePath+url;
				}
			}
			var $li=$("<li></li>");
			
			if($.trim(m.active) && m.active==true){
				$li.addClass("active");
			}
			if(!$.trim(m.active)){
				icon="fa-link";
			}
			var $J_menuItem=$("<a class='J_menuItem' href='"+url+"'></a>");
			$J_menuItem.append("<i class='menuIcon "+icon+"'></i>");
			$J_menuItem.append("<span class='nav-label'>"+m.name+"</span>");
			
			if($.trim(children)){
				var $nav_second_level=$("<ul class='nav nav-second-level'></ul>");
				$.each(children,function(o,c){
					var curl=c.url;
					if(!checkeURL(curl)){
						if(!$.trim(curl)){
							curl="#";
						}else{
							curl=basePath+curl;
						}
					}
					var $cli=$("<li></li>");
					$cli.append("<a class='J_menuItem' href='"+curl+"'>"+c.name+"</a>");
					$nav_second_level.append($cli);
				})
				$J_menuItem.append("<span class='fa arrow'></span>");
				$li.append($J_menuItem);
				$li.append($nav_second_level);
			}else{
				$li.append($J_menuItem);
				$J_menuItem.click(function(){
					$("#side-menu").find(".active").removeClass("active");
					$(this).parent().addClass("active");
				})
			}
			
			$("#side-menu").append($li);
		})
		
		
	});
	function checkeURL(str){ 
        
        //在JavaScript中，正则表达式只能使用"/"开头和结束，不能使用双引号
        var Expression=/http(s)?:////([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/;
        var objExp=new RegExp(Expression); 
        if(str.indexOf("localhost")){ 
            str = str.replace("localhost","127.0.0.1"); 
        } 
        if(objExp.test(str)==true){ 
            return true; 
        }else{ 
            return false; 
        } 
    }
	
	
});