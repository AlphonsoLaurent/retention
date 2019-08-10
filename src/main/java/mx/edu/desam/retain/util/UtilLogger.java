package mx.edu.desam.retain.util;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class UtilLogger {
	static String CADENA_IMPRESION="============================================================================"; 
	static ConstantUtil constant = ConstantUtil.getSingletonInstance();
	public static void logToPrint(Logger LOGVU ,String stringToPrint) {
		if(!constant.isACTIVE()) {
			LOGVU = LoggerFactory.getLogger(Object.class);
			LOGVU.debug(stringToPrint);
		}
	}
	
	
	
	public static void logToPrintRequest(Logger LOGVU ,String stringToPrint) {
		stringToPrint = "REQUEST::"+stringToPrint+"::";
		int cont =stringToPrint.length();
		int contTotal = CADENA_IMPRESION.length();
		int resultado = (contTotal - cont)/2;
		String cadenaComp =  cadComplemento(resultado,'=');
		String cadenaBlanco =  cadComplemento(cont,' ');
		if(!constant.isACTIVE()) {
			LOGVU.debug("\n\n\n\n"); 
			LOGVU.debug(CADENA_IMPRESION);
			LOGVU.debug(CADENA_IMPRESION); 
			LOGVU.debug(cadenaComp+cadenaBlanco+cadenaComp);
			LOGVU.debug(cadenaComp+cadenaBlanco+cadenaComp);
			LOGVU.debug(cadenaComp+stringToPrint+cadenaComp);
			LOGVU.debug(cadenaComp+cadenaBlanco+cadenaComp);
			LOGVU.debug(cadenaComp+cadenaBlanco+cadenaComp);
			LOGVU.debug(CADENA_IMPRESION);
			LOGVU.debug(CADENA_IMPRESION+"\n"); 
		}
	}
	public static void logToPrintRequest(String stringToPrint) {
		stringToPrint = "REQUEST::"+stringToPrint+"::";
		int cont =stringToPrint.length();
		int contTotal = CADENA_IMPRESION.length();
		int resultado = (contTotal - cont)/2;
		String cadenaComp =  cadComplemento(resultado,'=');
		String cadenaBlanco =  cadComplemento(cont,' ');
		if(!constant.isACTIVE()) {
			System.out.println("\n\n\n\n"); 
			System.out.println(CADENA_IMPRESION);
			System.out.println(CADENA_IMPRESION); 
			System.out.println(cadenaComp+cadenaBlanco+cadenaComp);
			System.out.println(cadenaComp+cadenaBlanco+cadenaComp);
			System.out.println(cadenaComp+stringToPrint+cadenaComp);
			System.out.println(cadenaComp+cadenaBlanco+cadenaComp);
			System.out.println(cadenaComp+cadenaBlanco+cadenaComp);
			System.out.println(CADENA_IMPRESION);
			System.out.println(CADENA_IMPRESION+"\n"); 
		}
	} 
	private static String cadComplemento(int x, char caracter) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < x; i++) {
			sb.append(caracter);
		}
		return sb.toString();
	}
	
	 
	
	
	
	

}
