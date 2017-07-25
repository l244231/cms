/*
 * jQuery and Bootsrap3 Plugin prettyFile
 *
 * version 2.0, Jan 20th, 2014
 * by episage, sujin2f
 * Git repository : https://github.com/episage/bootstrap-3-pretty-file-upload
 */
define(function(require,exports,module){
	require('jquery');
	require('sweetalert');
	
	
	( function( $ ) {
		$.fn.extend({
			imgsPreview: function( options ) {
				var defaults = {
					format : [ "gif", "jpeg", "jpg", "bmp", "png" ],
					col:4,
					width:100,
					height:100
				};
	
				var options =  $.extend(defaults, options);
				var plugin = this;
				var methods={
					setSelector:function($this){
						var $container=$("<div class='col-md-"+options.col+"'></div>");
						var $thumbnail=$("<a class='thumbnail'></a>");
						var $img=$("<img style='width:"+options.width+"px;height:"+options.height+"px;' data-src=''src='"+basePath+"/resources/img/webuploader.png' data-holder-rendered='true'>");
						$container.append($thumbnail.append($img));
						$thumbnail.click(function(){
							/*var $file=$("<input type='file' multiple='multiple'>");
							$file.hide();
							$file.on("change",{$this:$this},function(event){
								var $this=event.data.$this;
								methods.onChange(event,$this);
							});*/
							
						})
						$this.after($container);
					},
					onChange:function(event,$this){
						var copyfiles = event.target.files;
						var prototypefiles =$this[0].files;
						debugger;
						if(prototypefiles.length<=0){
							$this[0].value=event.target.value;
						}else{
							
						}
						
					}
				}
				
				return plugin.each( function() {
					$this = $( this );
					//隐藏选择器
					$this.hide();
					//重新设定选择按钮
					
					methods.setSelector($this);
					
					//文件选择事件
					
				});
			}
		});
	}( jQuery ));
})
