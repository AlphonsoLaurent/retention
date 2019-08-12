

var Category =Object.create({
	getCategories:function(){
		ObjectRequest.requestByAjaxJSON(Const.getUrl()+"/getCategories", null, function(response){
			debugger;
			$.each(response.lstResponse, function(idx0, elem){
				$("#idCategoria").append("<option value='"+elem.idCategory+"'>"+elem.description+"</option>");
			});
		
		}, function(dataError){
			console.error(dataError);
		}, true);
	},
	getLstAnswers:function(){
		ObjectRequest.requestByAjaxJSON(Const.getUrl()+"/findAllAnswer", null, function(response){
			$.each(response.lstResponse, function(idx0, elem){
				$("#idAnswer").append("<option value='"+elem.idAnswer+"'>"+elem.description+"</option>");
			});
		}, function(dataError){
			console.error(dataError);
		}, true);
	},
	saveCategory: function(){
		var category = {
				"idParent": $("#idCategoria option:selected").val(),
				"description": $("#description").val(),
				"idAnswer":$("#idAnswer option:selected").val()
		};
		var params = {"category":category};
		ObjectRequest.requestByAjaxJSON(Const.getUrl()+"/saveCategory", category, function(response){
			DialogSWT.msgInformativoEjecutarEvento("info", Const.context,response.msgSuccess, function(){ });
		}, function(dataError){
			console.error(dataError);
		}, true);
		
	},
	deleteCategory:function(){
		console.log("This is a deleteCategory");
	},
	modifyCategory:function(){
		console.log("This is a modifyCategory");
	}
});
 
 
$(document).ready(function(){
	Category.getLstAnswers();
	Category.getCategories();
});