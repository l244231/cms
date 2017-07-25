/**************************
*Desc:提交操作时遮罩
*Argument:type=0 全屏遮 1局部遮
*Author:Zery-Zhang
*Date:2014-09-18
*Version:1.0.0
**************************/

define(function(require, exports, module) {
	//加载jquery包
	require('jquery');
	; (function ($) { 
	    $.fn.jqLoading =function(option) {
	        var defaultVal = {
	            backgroudColor: "#ECECEC",//背景色
	            backgroundImage: basePath+"/resources/img/loading-1.gif",//背景图片
	            text: "加载中....",//文字 
	            width: 150,//宽度
	            height: 60,//高度
	            type:0 //0全部遮，1 局部遮
	            
	        };
	        var opt = $.extend({}, defaultVal, option);
	        var $this=this;
	      //销毁对象
	        if (option === "destroy") {
	            closeLayer();
	           
	            return;
	        }
	        if (opt.type == 0) {
	            //全屏遮
	            openLayer();
	        } else {
	            //局部遮(当前对象应为需要被遮挡的对象)
	            openPartialLayer(this);
	        }
	        
	        
	        
	        //设置背景层高
	        function height () {
	            var scrollHeight, offsetHeight;
	            // handle IE 6
	            if ($.browser.msie && $.browser.version < 7) {
	                scrollHeight = Math.max($this.documentElement.scrollHeight, document.body.scrollHeight);
	                offsetHeight = Math.max($this.documentElement.offsetHeight, document.body.offsetHeight);
	                if (scrollHeight < offsetHeight) {
	                    return $(window).height();
	                } else {
	                    return scrollHeight;
	                }
	                // handle "good" browsers
	            }
	            else if ($.browser.msie && $.browser.version == 8) {
	                return $($this).height() - 4;
	            }
	            else {
	                return $($this).height();
	            }
	        };
	        
	        //设置背景层宽
	        function width() {
	            var scrollWidth, offsetWidth;
	            // handle IE
	            if ($.browser.msie) {
	                scrollWidth = Math.max($this.documentElement.scrollWidth, document.body.scrollWidth);
	                offsetWidth = Math.max($this.documentElement.offsetWidth, document.body.offsetWidth);
	                if (scrollWidth < offsetWidth) {
	                    return $(window).width();
	                } else {
	                    return scrollWidth;
	                }
	                // handle "good" browsers
	            }
	            else {
	                return $($this).width();
	            }
	        };
	        
	        /*==========全部遮罩=========*/
	        function openLayer() {
	            //背景遮罩层
	            var layer = $($this).find("#loadLayer");
	            layer.css({
	                zIndex:99999,
	                position: "absolute",
	                height: height() + "px",
	                width: width() + "px",
	                background: "black",
	                top: 0,
	                left: 0,
	                filter: "alpha(opacity=30)",
	                opacity: 0.3
	              
	            });
	           
	           //图片及文字层
	            var content = $($this).find("#loadContent");
	            content.css({
	                textAlign: "left",
	                position:"absolute",
	                zIndex: 99999,
	                height: opt.height + "px",
	                width: opt.width + "px",
	                verticalAlign: "middle",
	                background: opt.backgroudColor,
	                borderRadius:"8px",
	                fontSize:"13px"
	            });
	            var img =content.find("img");
	            img.css({
	            	"margin":(opt.height/4)+"px",
	            	"vertical-align":"middle",
	            	"margin-right":"5px"
	            })
	            var loadtext=$($this).find("#loadText");
	            loadtext.text(opt.text);
	            //var top = content.css("top").replace('px','');
	            //var left = content.css("left").replace('px','');
	            //content.css("top",(parseFloat(top)-opt.height/2)).css("left",(parseFloat(left)-opt.width/2));
	            
	            $($this).find("#loadMain").show();
	            
	            return this;
	        }
	
	        //销毁对象
	        function closeLayer() {
	            $($this).find("#loadMain").hide();
	            return this;
	        }
	        
	        /*==========局部遮罩=========*/
	        function openPartialLayer(obj) {
	         
	            var eheight = $(obj).css("height");//元素带px的高宽度
	            var ewidth = $(obj).css("width");
	            var top = $(obj).offset().top; // 元素在文档中位置 滚动条不影响
	            var left = $(obj).offset().left;
	
	            var layer = $("<div id='partialLayer'></div>");
	            layer.css({
	                style: 'z-index:99999',
	                position: "absolute",
	                height: eheight,
	                width: ewidth,
	                background: "black",
	                top: top,
	                left: left,
	                filter: "alpha(opacity=60)",
	                opacity: 0.6,
	                borderRadius:"3px",
	                dispaly: "block"
	            });
	            $("body").append(layer);
	
	            return this;
	        }
	    };
	    
	})(jQuery)
});