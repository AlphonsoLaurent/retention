// JavaScript Document
/*************************************************************************/
/**********************CREA ELEMENTOS DE TIPOS OBJECTOS*******************/
/*************************************************************************/
(function(){
	if (typeof Object.create !== 'function') {
		  Object.create = function (o) {
		    function F() {
		    }
		    F.prototype = o;
		    return new F();
		  };
		}
}()); 
  

/**PETICIONES DE CONSULTA**/
var ObjectRequest = Object.create({ 
	requestByAjaxJSON: function (urlRequest, params, fnResponse, fnError, esperar){
		//ObjectRequest.urlRequest = urlRequest;
		//LoaderGral.show();
		$.ajax({
			contentType: "application/json",
			dataType: 'json',
			cache: false, 
			url: urlRequest,
			data:JSON.stringify(params), // convert array to JSON
			type: 'get',
			async:esperar,
			statusCode: {
				408: function (response) {
//					LoaderGral.hide();
					//window.location.href = contextvu + '/ventanillaUExp.sct';
				}
			},
			timeout: 5000, 
			success: function(data) {
//				LoaderGral.hide();
				fnResponse(data);
				
			},  
			error: function(dataErrors) {
//				ObjectRequest.fnThrowsErrorsGral(dataErrors); 
				fnError(dataErrors); 
			}
		});
	} ,
	fnThrowsErrorsGral: function(dataErrors){
		//window.scrollTo(0,GlobalVar.highError);
//		LoaderGral.hide();
		//console.error("=====it has ocurred an error... "+ObjectRequest.urlRequest+" =====");
		console.error("====================================================================");
		try{
			console.error(dataErrors.status);
			console.error(dataErrors.statusText);
			console.error(dataErrors.responseText);
		}catch (e) {
			console.error("it has ocurred a fatal error... please check your log in the server ...");
		}
		console.error("====================================================================");
	}
});
  
