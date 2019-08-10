/*
 * Author: Alfonso Laureano Tolentino*/
var DialogSWT = Object.create({
	divDialogGral : "#dialogGral",
	classTemp : ["col-sm-12 alert alert-success","col-sm-12 alert alert-warning","col-sm-12 alert alert-danger","col-sm-12 alert alert-info"],
	//iconoUser:"<img style='width: 30px; height: 30px;' src='view/assets/images/1m463n.png' />",
	createDialgo:	function (icono, tituloMsg, mensaje, botones) {
		//
		$.each(DialogSWT.classTemp, function(index, element){			
			$("#div-content-message-gral").removeClass(element);
		});
		if(icono != ""){
			if(icono == "success")
				$("#div-content-message-gral").addClass("col-sm-12 alert alert-success");
			else if(icono == "warning")
				$("#div-content-message-gral").addClass("col-sm-12 alert alert-warning");
			else if(icono == "danger")
				$("#div-content-message-gral").addClass("col-sm-12 alert alert-danger");
			else if(icono == "info")
				$("#div-content-message-gral").addClass("col-sm-12 alert alert-info");
		}else{
			$("#div-content-message-gral").addClass("col-sm-12 alert alert-info");
		}
		$("#msg-title").html((tituloMsg != undefined || tituloMsg != null ? tituloMsg:"Mensaje Informativo"));
		$("#msg-body").html(mensaje);
		$("#bottonsAlerts").html("");
		$.each(botones, function( index, objecto ) {
			if(objecto.display=='Cancelar'){
				$("#bottonsAlerts").append("<button type='button' class='btn btn-default' id='"+objecto.name+"' data-toggle='modal' data-dismiss='modal'>"+objecto.display+"</button>");
			}else{
				$("#bottonsAlerts").append("<button type='button' class='btn btn-primary' id='"+objecto.name+"' data-toggle='modal' data-dismiss='modal'>"+objecto.display+"</button>");	
			}
			
			$("#"+objecto.name).click(function(){
				objecto.funcion();
			});
		});
		try{
			$(DialogSWT.divDialogGral).modal("show");
		}catch(e){
			
		}
	},	 
	msgInformativo:function (icono, tituloMsg,  contenidoMsg){
	  var botones = [{
			  name:"aceptar",
			  funcion: function () { $(DialogSWT.divDialogGral).modal("hide");},
			  display:"Aceptar"
	  		}];
	  DialogSWT.createDialgo(icono, tituloMsg,  contenidoMsg , botones);
	},
	msgInformativoEjecutarEvento:function (icono, tituloMsg,  contenidoMsg, ejecutar){
	  var botones = [{
			  name:"aceptar",
			  funcion: function(){ejecutar();},
			  display:"Aceptar"
	  }];
	  DialogSWT.createDialgo(icono, tituloMsg, contenidoMsg , botones);
	},
	msgPorConfirmar: function (icono, tituloMsg,  contenidoMsg, ejecutar){
	  var botones = [
		  {
		  name:"aceptar",
		  funcion: function () { ejecutar(); },
		  display:"Aceptar"
		},
		{
		  name:"cancelar",
		  funcion: function () { $(DialogSWT.divDialogGral).modal("hide"); },
		  display:"Cancelar"
		} 
	  ];
	  DialogSWT.createDialgo(icono, tituloMsg,  contenidoMsg , botones);
	},
	msgPorConfirmarAceptCancel: function (icono, tituloMsg,  contenidoMsg, fnAcept, fnCancel){
	  var botones =[
		{
		  name:"cancelar",
		  funcion: function () { $(DialogSWT.divDialogGral).modal("hide"); fnCancel(); },
		  display:"Cancelar"
		} ,{
			  name:"aceptar",
			  funcion: function () {  fnAcept(); },
			  display:"Aceptar"
			}
	  ];
	  DialogSWT.createDialgo(icono, tituloMsg, contenidoMsg , botones);
	}
});

//DialogSWT.msgInformativo("icono", "tituloMsg",  "contenidoMsg");
//DialogSWT.msgInformativoEjecutarEvento("icono", "tituloMsg",  "contenidoMsg", function(){});
//DialogSWT.msgPorConfirmar("icono", "tituloMsg",  "contenidoMsg", function(){});
//DialogSWT.msgPorConfirmarAceptCancel("icono", "tituloMsg",  "contenidoMsg", function(){}, function(){});

var LoaderGral = Object.create({
	flagDisplay:false,
	divLoader : "#loadingGral",
	count:0,
	show:function(){
		if(LoaderGral.flagDisplay == false){			
			$(LoaderGral.divLoader).modal("show");
			LoaderGral.count++;
		}
		LoaderGral.flagDisplay = true;
	},
	hide:function(){
		if(LoaderGral.flagDisplay == true){			
			$(LoaderGral.divLoader).modal("hide");
			LoaderGral.flagDisplay = false; 
		}
	},
	restartObject:function(){
	 for (var i = 0; i < LoaderGral.count; i++) {
		 $(LoaderGral.divLoader).modal("hide");
	 }
	}
});

