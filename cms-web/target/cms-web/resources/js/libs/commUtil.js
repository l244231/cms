/**
 * 
 */
define(function(require,exports,module){
	
	
	var ajaxUtil=require('ajaxUtil');
	var dateUtil=require('dateUtil');
	var redirectUtil=require('redirectUtil');
	var validateUtil=require('validateUtil');
	require('inputUtil');
	module.exports = {
		ajaxUtil:ajaxUtil,
		dateUtil:dateUtil,
		redirectUtil:redirectUtil,
		validateUtil:validateUtil
	};
})
