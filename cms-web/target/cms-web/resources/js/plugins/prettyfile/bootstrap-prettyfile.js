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
			prettyFile: function( options ) {
				var defaults = {
					text : "选择文件",
					format : "all",
					showImg:false,
					display:false,
					buttonId:"",
					imgData:{
						imgObjId: null,
						width:300,
						height:300
					}
				};
	
				var options =  $.extend(defaults, options);
				var plugin = this;
				
				function show_img(obj){
					var _self = obj;
					_self.getObjectURL = function (file) {
			            var url = null;
			            if (window.createObjectURL != undefined) {
			                url = window.createObjectURL(file)
			            } else if (window.URL != undefined) {
			                url = window.URL.createObjectURL(file)
			            } else if (window.webkitURL != undefined) {
			                url = window.webkitURL.createObjectURL(file)
			            }
			            return url
			        };
					if ($.browser.msie) {
	                    try {
	                        $("#" + options.imgData.imgObjId).attr('src', _self.getObjectURL(_self.files[0]))
	                    } catch (e) {
	                        var src = "";
	                        var obj = $("#" + options.imgData.imgObjId);
	                        var div = obj.parent("div")[0];
	                        _self.select();
	                        if (top != self) {
	                            window.parent.document.body.focus()
	                        } else {
	                            _self.blur()
	                        }
	                        src = document.selection.createRange().text;
	                        document.selection.empty();
	                        obj.hide();
	                        obj.parent("div").css({
	                            'filter': 'progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)',
	                            'width': options.imgData.width + 'px',
	                            'height': options.imgData.height + 'px'
	                        });
	                        div.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = src
	                    }
	                } else {
	                	var obj = $("#" + options.imgData.imgObjId);
	                	obj.attr('src', _self.getObjectURL(_self.files[0]));
	                	obj.css({
                            'width': options.imgData.width + 'px',
                            'height': options.imgData.height + 'px'
                        });
	                }
				}
				
				function show_many_img(obj){
					var _self = obj;
					_self.getObjectURL = function (file) {
			            var url = null;
			            if (window.createObjectURL != undefined) {
			                url = window.createObjectURL(file)
			            } else if (window.URL != undefined) {
			                url = window.URL.createObjectURL(file)
			            } else if (window.webkitURL != undefined) {
			                url = window.webkitURL.createObjectURL(file)
			            }
			            return url
			        };
			        var obj = $("#" + options.imgData.imgObjId);
					if ($.browser.msie) {
						
	                    try {
	                    	$.each(_self.files,function(i,file){
	                    		obj.append(thumbnail(_self.getObjectURL(file)));
	                    		
	                    	})
	                    } catch (e) {
	                        /*var src = "";
	                        var obj = $("#" + options.imgData.imgObjId);
	                        var div = obj.parent("div")[0];
	                        _self.select();
	                        if (top != self) {
	                            window.parent.document.body.focus()
	                        } else {
	                            _self.blur()
	                        }
	                        src = document.selection.createRange().text;
	                        document.selection.empty();
	                        obj.hide();
	                        obj.parent("div").css({
	                            'filter': 'progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)',
	                            'width': options.imgData.width + 'px',
	                            'height': options.imgData.height + 'px'
	                        });
	                        div.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = src*/
	                    	obj.text("浏览器不支持在线预览");
	                    	
	                    }
	                } else {
	                	
	                	$.each(_self.files,function(i,file){
                    		obj.append(thumbnail(_self.getObjectURL(file)));
                    	})
	                	
	                	/*var obj = $("#" + options.imgData.imgObjId);
	                	obj.attr('src', _self.getObjectURL(_self.files[0]));
	                	obj.css({
                            'width': options.imgData.width + 'px',
                            'height': options.imgData.height + 'px'
                        });*/
	                }
				}
				
				function thumbnail(src){
					var $div=$("<div class='col-sm-4'></div>");
					var $thumbnail=$("<div class='thumbnail'></div>");
					var $img=$("<img onerror=\"this.src='"+basePath+"/resources/img/webuploader.png'\"/>");
					$img.attr("src",src);
					$img.css({
                        'width': options.imgData.width + 'px',
                        'height': options.imgData.height + 'px'
                    });
					$thumbnail.append($img)
					$div.append($thumbnail);
					return $div;
				}
				
				
				function check_format(format,$this){
					//验证文件格式
					if(options.format=="all"){
						return true;
					}else{
						if(options.format.indexOf(format)>=0){
							return true;
						}else{
							$this.after($this.clone().val(""));
							$this.remove();
							swal({
		    	                title: "错误",
		    	                text: "选择的格式必须是" + options.format.join(","),
		    	                type: "error"
		    	            });
							return false;
						}
					}
				}
				
				function check_many_format($this,files){
					
					var result=true;
					$.each(files,function(i,file){
						var format=file.name;
						format=format.substring(format.lastIndexOf(".")+1,format.lenght);
						if(options.format=="all"){
							
						}else{
							if(options.format.indexOf(format)>=0){
								
							}else{
								
								result = false;
							}
						}
					});
					if(!result){
						$this.after($this.clone().val(""));
						$this.remove();
						swal({
	    	                title: "错误",
	    	                text: "选择的格式必须是" + options.format.join(","),
	    	                type: "error"
	    	            });
					}
					//验证文件格式
					return result;
				}
				
				
				function make_form( $el, text ) {
					$el.wrap('<div></div>');
					var elID=$el.attr("id");
					$el.hide();
					$el.after( '\
					<div class="input-append input-group" ">\
							<span class="input-group-btn">\
							<button class="btn btn-white" type="button">' + text + '</button>\
						</span>\
						<input id="file_'+elID+'" name="file_'+elID+'" class="input-large form-control" style="margin-top:0px!important;" type="text">\
					</div>\
					' );
					return $el.parent();
				};
				
				function bind_change( $wrap, multiple ,options) {
					$wrap.on("change",'input[type="file"]',function(){
						// When original file input changes, get its value, show it in the fake input
						var files = $( this )[0].files,
						info = '';
						if ( files.length == 0 )
							return false;
	
						if ( !multiple ) {
							
							var path = $( this ).val().split('\\');
							info = path[path.length - 1];
							//文件格式
							var format=info.substring(info.lastIndexOf(".")+1,info.lenght);
							
							if(check_format(format,$(this))){
								if(options.showImg){
									show_img(this);
								}
							}else{
								$wrap.find('.input-append input').val( "" );
								if(options.showImg){
									$("#" + options.imgData.imgObjId).attr('src',"");
								}
								return false;
							}
						} else if (multiple ) {
							var obj = $("#" + options.imgData.imgObjId);
							obj.empty();
							info = "已选择了" + files.length + ' 个文件';
							if(check_many_format($(this),files)){
								if(options.showImg){
									show_many_img(this);
								}
							}else{
								$wrap.find('.input-append input').val( "" );
								if(options.showImg){
									//$("#" + options.imgData.imgObjId).attr('src',"");
								}
								return false;
							}
						}
						$wrap.find('.input-append input').val( info );
					});
				};
	
				function bind_button( $wrap, multiple ) {
					//禁止点击文本框进行选择
					$wrap.find( '.input-append input' ).attr("readonly","readonly");
					/*$wrap.find( '.input-append input' ).on("focusout",function( e ){
						$wrap.find( '.input-append input' ).css("margin-top","0px!")
					})*/
					if($.trim(options.buttonId)){
						$("#"+options.buttonId).click(function(e){
							e.preventDefault();
							$wrap.find( 'input[type="file"]' ).click();
						})
					}
					$wrap.find( '.input-append' ).click( function( e ) {
						e.preventDefault();
						$wrap.find( 'input[type="file"]' ).click();
					});
				};
	
				return plugin.each( function() {
					$this = $( this );
	
					if ( $this ) {
						var multiple = $this.attr( 'multiple' );
	
						$wrap = make_form( $this, options.text );
						bind_change( $wrap, multiple,options);
						bind_button( $wrap );
						
					}
					/*if(options.display){
						$wrap.hide();
					}*/
				});
			}
		});
	}( jQuery ));
})
