
var User = Object.create({
	renglon:0,
	initclass:function(){
		$( ".move" ).draggable({ cursor: "hand"}); 
	},
	loadUsers:function(){
		ObjectRequest.requestByAjaxJSON(Const.getUrl()+"getUser", null, function(response){
			$.each(response.lstResponse, function(idx0, elem){
				$("#usermain").html(elem.nameUser);
				User.fillChildrens(elem.lstCategoryDTO); 
			});
		}, function(dataError){
			console.error(dataError);
		}, true);
	},
	fillChildrens:function(lstCategory){
		var parent = 0;
		var contador = 0;
		var cpintar = 0;
		$("#dinamic").append("<div class='row' style='background-color:#e9ecef; margin-bottom: 10px;' id='reng_"+User.renglon+"' ><div>");
		$.each(lstCategory, function(idx1, element){
			if(parent != element.idParent ){
				cpintar++;
				if(cpintar %3 == 0)cpintar=0;
			} 
			var html ="<div class='rounded-circle move alert "+Const.classtyle[contador]+"' style='cursor:pointer;margin: 10px;' id='"+element.idCategory+" ' onclick='User.loadHild(this)' role='alert' > "
			+element.description.toUpperCase()+"</div>";
			contador++;
			if(contador % 3 == 0 )contador=0;
			
			$("#reng_"+User.renglon).append(html);
			parent = element.idParent;
		});
		User.renglon++;
		User.initclass();
	}, 
	
	loadHild: function(athis){
			ObjectRequest.requestByAjaxJSON(Const.getUrl()+"/getChild?idParent="+athis.id, null, function(response){
				if(response.successful == true && response.lstResponse.length >= 1){
				User.fillChildrens(response.lstResponse);
				}else{
					DialogSWT.msgInformativo("danger", Const.context, "No tiene información");
				}
			}, function(dataError){
				console.error(dataError);
			}, true);
	}
});

$(document).ready(function(){
	User.loadUsers();
	
});