define(function(require,exports,module){
	require('jquery');
	require('jquery-hotkeys');
	require('bootstrap-wysiwyg');
	
	$(function(){
		$('[data-role=magic-overlay]').each(function () { 
			var overlay = $(this), target = $(overlay.data('target')); 
			overlay.css('opacity', 0).css('position', 'absolute').offset(target.offset()).width(target.outerWidth()).height(target.outerHeight());
		});
		$('a[title],input[title],button[title]').tooltip({container:'body'});
		//$('#editor').wysiwyg({} );
	});
});