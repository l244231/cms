/* http://github.com/mindmup/bootstrap-wysiwyg */
/*global jQuery, $, FileReader*/
/*jslint browser:true*/

define(function(require,exports,module){
	require('jquery');
	require('jquery-hotkeys');
	var commUtil = require('commUtil');
	
	
	(function ($) {
		'use strict';
		var readFileIntoDataUrl = function (fileInfo) {
			var loader = $.Deferred(),
				fReader = new FileReader();
			fReader.onload = function (e) {
				loader.resolve(e.target.result);
			};
			fReader.onerror = loader.reject;
			fReader.onprogress = loader.notify;
			fReader.readAsDataURL(fileInfo);
			return loader.promise();
		};
		$.fn.cleanHtml = function () {
			var html = $(this).html();
			return html && html.replace(/(<br>|\s|<div><br><\/div>|&nbsp;)*$/, '');
		};
		$.fn.wysiwyg = function (userOptions) {
			var editor = this,
				selectedRange,
				options,
				methods={
					getEditor:function(){
						return "<div style='font-size: 24px;'>"+$(editor).html()+"</div>";
					}	
				},
				toolbarBtnSelector,
				updateToolbar = function () {
					if (options.activeToolbarClass) {
						$(options.toolbarSelector).find(toolbarBtnSelector).each(function () {
							var command = $(this).data(options.commandRole);
							if (document.queryCommandState(command)) {
								$(this).addClass(options.activeToolbarClass);
							} else {
								$(this).removeClass(options.activeToolbarClass);
							}
						});
					}
				},
				execCommand = function (commandWithArgs, valueArg,$editor) {
					var commandArr = commandWithArgs.split(' '),
						command = commandArr.shift(),
						args = commandArr.join(' ') + (valueArg || '');
					
					document.execCommand(command, 0, args);
					if(command=="insertimage"){
						$editor.find("img").load(function(){
							if($editor.width()<this.width){
								$(this).css("width","100%");
							}
						});
					}
					updateToolbar();
				},
				bindHotkeys = function (hotKeys) {
					$.each(hotKeys, function (hotkey, command) {
						editor.keydown(hotkey, function (e) {
							if (editor.attr('contenteditable') && editor.is(':visible')) {
								e.preventDefault();
								e.stopPropagation();
								execCommand(command);
							}
						}).keyup(hotkey, function (e) {
							if (editor.attr('contenteditable') && editor.is(':visible')) {
								e.preventDefault();
								e.stopPropagation();
							}
						});
					});
				},
				getCurrentRange = function () {
					var sel = window.getSelection();
					if (sel.getRangeAt && sel.rangeCount) {
						return sel.getRangeAt(0);
					}
				},
				saveSelection = function () {
					selectedRange = getCurrentRange();
				},
				restoreSelection = function () {
					var selection = window.getSelection();
					if (selectedRange) {
						try {
							selection.removeAllRanges();
						} catch (ex) {
							document.body.createTextRange().select();
							document.selection.empty();
						}
	
						selection.addRange(selectedRange);
					}
				},
				insertFiles = function (files,$editor) {
					editor.focus();
					$.each(files, function (idx, fileInfo) {
						if (/^image\//.test(fileInfo.type)) {
							
							//图片文本流展示
							
							/*$.when(readFileIntoDataUrl(fileInfo)).done(function (dataUrl) {
								execCommand('insertimage', dataUrl,$editor);
							}).fail(function (e) {
								options.fileUploadError("file-reader", e);
							});*/
							
							//图片上传形式展示
							var formData = new FormData();
							
							formData.append("imgFile",fileInfo);
							
							commUtil.ajaxUtil.execute({
								url: basePath + "/market/ncpImageInfo/uploadImageFile",
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
										execCommand('insertimage', baseHost+basePath+"/market/ncpImageInfo/getFileById?id="+data.message,$editor);
									}else{
										options.fileUploadError("file-reader", e);
									}
								}
							});
						} else {
							options.fileUploadError("unsupported-file-type", fileInfo.type);
						}
					});
				},
				markSelection = function (input, color) {
					restoreSelection();
					if (document.queryCommandSupported('hiliteColor')) {
						document.execCommand('hiliteColor', 0, color || 'transparent');
					}
					saveSelection();
					input.data(options.selectionMarker, color);
				},
				bindToolbar = function (toolbar, options,$this) {
					toolbar.find(toolbarBtnSelector).click(function () {
						restoreSelection();
						editor.focus();
						execCommand($(this).data(options.commandRole));
						saveSelection();
					});
					toolbar.find('[data-toggle=dropdown]').click(restoreSelection);
					toolbar.find('[data-type="color"]').click(function(){
						toolbar.find('input[type=color][data-' + options.commandRole + ']').click();
					});
					
					toolbar.find('input[type=text][data-' + options.commandRole + ']').on('webkitspeechchange change', function () {
						var newValue = this.value; /* ugly but prevents fake double-calls due to selection restoration */
						this.value = '';
						restoreSelection();
						if (newValue) {
							editor.focus();
							execCommand($(this).data(options.commandRole), newValue);
						}
						saveSelection();
					}).on('focus', function () {
						var input = $(this);
						if (!input.data(options.selectionMarker)) {
							markSelection(input, options.selectionColor);
							input.focus();
						}
					}).on('blur', function () {
						var input = $(this);
						if (input.data(options.selectionMarker)) {
							markSelection(input, false);
						}
					});
					
					//颜色选择器
					toolbar.find('input[type=color][data-' + options.commandRole + ']').on('webkitspeechchange change', function () {
						var newValue = this.value;  //ugly but prevents fake double-calls due to selection restoration 
						//restoreSelection();
						//if (newValue) {
							editor.focus();
							execCommand($(this).data(options.commandRole), newValue);
						//}
						$(this).parent().find("a i").css("color",newValue);
						saveSelection();
					});
					
					toolbar.find('input[type=file][data-' + options.commandRole + ']').change(function () {
						restoreSelection();
						if (this.type === 'file' && this.files && this.files.length > 0) {
							var $editor=$(this).parents(".editorContainer").find(".editor");
							insertFiles(this.files,$editor);
						}
						saveSelection();
						this.value = '';
					});
				},
				initFileDrops = function () {
					//文件拖拽功能：禁用（拖拽多个文件影响文件上传功能）
					/*editor.on('dragenter dragover', false)
						.on('drop', function (e) {
							var dataTransfer = e.originalEvent.dataTransfer;
							e.stopPropagation();
							e.preventDefault();
							if (dataTransfer && dataTransfer.files && dataTransfer.files.length > 0) {
								insertFiles(dataTransfer.files);
							}
						});*/
				};
			
			if ( typeof userOptions ==='string') { // 如果传入的 method 是 function， 方法在这里执行
				return methods[userOptions].apply( this, Array.prototype.slice.call( arguments, 1 ));
			}else if ( typeof userOptions === 'object' || ! userOptions ) { //如果传入的 userOptions 是 对象， 初始化数据在这里执行
				if(userOptions){
					if(!userOptions.toolbarSelector){
						userOptions.toolbarSelector="#"+$(editor).attr("id")+"_toolbar"
					}
				}else{
					userOptions={
						toolbarSelector:"#"+$(editor).attr("id")+"_toolbar"
					}
				}
				options = $.extend({}, $.fn.wysiwyg.defaults, userOptions);
			}else {
				 $.error( 'Method ' +  userOptions + ' does not exist on wysiwyg' );  
				return false;
			}
			toolbarBtnSelector = 'a[data-' + options.commandRole + '],button[data-' + options.commandRole + '],input[type=button][data-' + options.commandRole + ']';
			bindHotkeys(options.hotKeys);
			if (options.dragAndDropImages) {
				initFileDrops();
			}
			bindToolbar($(options.toolbarSelector), options,$(this));
			editor.attr('contenteditable', true)
				.on('mouseup keyup mouseout', function () {
					saveSelection();
					updateToolbar();
				});
			$(window).bind('touchend', function (e) {
				var isInside = (editor.is(e.target) || editor.has(e.target).length > 0),
					currentRange = getCurrentRange(),
					clear = currentRange && (currentRange.startContainer === currentRange.endContainer && currentRange.startOffset === currentRange.endOffset);
				if (!clear || isInside) {
					saveSelection();
					updateToolbar();
				}
			});
			return this;
		};
		$.fn.wysiwyg.defaults = {
			hotKeys: {
				'ctrl+b meta+b': 'bold',
				'ctrl+i meta+i': 'italic',
				'ctrl+u meta+u': 'underline',
				'ctrl+z meta+z': 'undo',
				'ctrl+y meta+y meta+shift+z': 'redo',
				'ctrl+l meta+l': 'justifyleft',
				'ctrl+r meta+r': 'justifyright',
				'ctrl+e meta+e': 'justifycenter',
				'ctrl+j meta+j': 'justifyfull',
				'shift+tab': 'outdent',
				'tab': 'indent'
			},
			toolbarSelector: '[data-role=editor-toolbar]',
			commandRole: 'edit',
			activeToolbarClass: 'btn-info',
			selectionMarker: 'edit-focus-marker',
			selectionColor: 'darkgrey',
			dragAndDropImages: true,
			fileUploadError: function (reason, detail) { console.log("File upload error", reason, detail); }
		};
	}(window.jQuery));

});