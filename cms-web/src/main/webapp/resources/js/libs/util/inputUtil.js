define(function(require,exports,module){
	require('jquery');
	$(function(){
		$("select").each(function(i,e){
			var $this=$(e);
			$this.find("option[value='"+$this.data("value")+"']").attr("selected", "selected");
		});
	})
	$(document).ready(function(){
	    $('img').each(function(){
	        var error = false;
	        if (!this.complete) {
	            error = true;
	        }
	        if (typeof this.naturalWidth != "undefined" && this.naturalWidth == 0) {
	            error = true;
	        }

	        if(error){
	        	this.src = default_Picture;
	            $(this).on('error.replaceSrc',function(){
	                $(this).unbind('error.replaceSrc');
	            }).trigger('load');
	        }
	    });
	});
})