var GlobalVar= Object.create({
	highError: 300
});

var FnsCommons = Object.create({
	/***
	 * Esta funciona limpia todos los objectos atraves de su ID's
	 * Ejemplo de como usarlos:
	 * FnsCommons.fnCleanFields(['idCampo1','idCampo2','idCampo3']);
	 * Con esto se limpiaran todos los campos.
	 */
	fnCleanFields:function(objects){
		$.each(objects, function(index, item) {
			$("#"+item).val("");
		});
	},
	
	/***
	 * Esta funcion valida si el caracter introducido es es numerico.
	 * <input type="text" id="number-operacion" onkeyup="FnsCommons.isNumberKey(this);" >
	 */
	isNumberKey : function (evt){
		//
       var charCode = (evt.which) ? evt.which : event.keyCode
       if (charCode > 31 && (charCode < 48 || charCode > 57))
          return false;
       return true;
    }, 
    /***
     * Esta funcion oculta o muestra elementos segun sea la necesidad.
     * Ejemplo de uso:
     * FnsCommons.fnShowOrHiddenElements(true, ['idCampo1','idCampo2','idCampo3']); en caso de que se desea mostrar
     * FnsCommons.fnShowOrHiddenElements(false, ['idCampo1','idCampo2','idCampo3']); en caso de que se desea ocultar
     */
    fnShowOrHiddenElements:function(flag, objects){
    	$.each(objects, function(index, item) {
    		if(flag == true)
    			$("#"+item).show();
    		else
    			$("#"+item).hide();
		});
    } 
});


var FnsCommonsValidate = Object.create({
	flagIsValid: true,
	/***
	 * Esta funcion valida que no esten vacio los campos o null y retorna falso en caso de que haya campos 
	 * pendientes por llenar, adicional muestra los mensajes que los campos son requeridos
	 * Ejemplo de uso:
	 * js
	 * FnsCommonsValidate.validFields(['fecha-presentacion'...'n'], ['errorFecha'...'n']);
	 * html
	 * <input id="fecha-presentacion" type="text" class="valid-field form-control" value="16/05/2016" placeholder="dd/mm/aaaa" />
        <span class="glyphicon glyphicon-calendar" aria-hidden="true"> </span>
        <small  id="errorFecha"  hidden="true" class="form-text form-text-error">
        	<spring:message code="sol.tram.validar.e5cinco.campo.requerido" />
        </small>
	 */
	validFields: function(fieldsValid, fieldsError){
		FnsCommonsValidate.flagIsValid= true;
		$.each(fieldsValid, function(index, item) {
			if($("#"+item).val() == undefined || $("#"+item).val() == null || $("#"+item).val() == ""){
				$("#"+fieldsError[index]).show();
				FnsCommonsValidate.flagIsValid= false;
			} else{
				$("#"+fieldsError[index]).hide(); 
			} 
		});
		return FnsCommonsValidate.flagIsValid;
	}
});


var FnsCommonsDate = Object.create({
	formatDate: function (date) {
	    var d = new Date(date),
	        month = '' + (d.getMonth() + 1),
	        day = '' + d.getDate(),
	        year = d.getFullYear();
	    if (month.length < 2) month = '0' + month;
	    if (day.length < 2) day = '0' + day;
	    return [day, month, year].join('/');
	}
});

var FnsCommonsThrowsError = Object.create({
	pantallaError: function (dataError){
		$("#idHomeSctBody").show();
		$("#idHomeTramite").hide();
		$("#idbuscaPersona").hide();
		$("#idMuestraPersona").hide();
		$('#idHomeSctBody').load('../home/error.jsp');
		$('#imgIdHeader').focus(); 
		window.scrollTo(0,GlobalVar.highError);
	},
	formattBreadCrumbs: function(arrayIds, arrayColors, arrayBackground){
		$.each(arrayIds, function(index, item){
			$('#',item).css({'color' : arrayColors[index],'background-color':arrayBackground[index]});
		});
	}
}); 





