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


var Const = Object.create({
	prod:true,
	context:"Retention",
	urlDev:"http://192.168.100.3:8383/retention/",
	urlProd:"https://retent.herokuapp.com/retention/", 
	classtyle:["alert-success","alert-danger","alert-warning","alert-info","alert-primary","alert-secondary"],
	getUrl:function(){
		var urlExecution = "";
		if(Const.prod) 
			urlExecution =Const.urlProd;
		else 
			urlExecution =Const.urlDev;
		return urlExecution;
	}
});



/**PETICIONES DE CONSULTA**/
var ObjectRequest = Object.create({ 
	requestByAjaxJSON: function (urlRequest, params, fnResponse, fnError, esperar){
		//ObjectRequest.urlRequest = urlRequest;
		//LoaderGral.show();
		$.ajax({
			contentType: "application/json",
			dataType: 'JSON',
			cache: false, 
			url: urlRequest,
			data:params, // convert array to JSON
			type: 'GET',
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
  
 