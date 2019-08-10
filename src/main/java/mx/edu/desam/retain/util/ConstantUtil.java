package mx.edu.desam.retain.util;

public class ConstantUtil {
	private static ConstantUtil constantUtil;
	boolean ACTIVE = false;
	boolean WS_INGRESO = true; 
	
	public static ConstantUtil getSingletonInstance() {
        if (constantUtil == null){
        	constantUtil = new ConstantUtil();
        } 
        return constantUtil;
    }
	
	public ConstantUtil() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean isACTIVE() {
		return ACTIVE;
	}

	public void setACTIVE(boolean aCTIVE) {
		ACTIVE = aCTIVE;
	} 
	public boolean isWS_INGRESO() {
		return WS_INGRESO;
	}

	public void setWS_INGRESO(boolean wS_INGRESO) {
		WS_INGRESO = wS_INGRESO;
	}
 

//	public String getConfigE5Url() {
//		if(this.isACTIVE() == true) {
//			configE5Url = "http://aplicaciones.sct.gob.mx"; 
//		}else {
//			configE5Url =  "http://aplicaciones.sct.gob.mx";
//		}
//		return configE5Url;
//	}
	
	

}
