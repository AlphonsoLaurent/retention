package mx.edu.desam.retention.util;

import java.util.List;

public class ResponseDTO {
	private boolean successful;
	private String msgSuccess;
	private List<Object> lstResponse;
	
	public ResponseDTO(boolean successful) {
		super();
		this.successful = successful;
	}
	
	

	public ResponseDTO(boolean successful, String msgSuccess, List<Object> lstResponse) {
		super();
		this.successful = successful;
		this.msgSuccess = msgSuccess;
		this.lstResponse = lstResponse;
	}



	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	public String getMsgSuccess() {
		return msgSuccess;
	}
	public void setMsgSuccess(String msgSuccess) {
		this.msgSuccess = msgSuccess;
	}
	public List<Object> getLstResponse() {
		return lstResponse;
	}
	public void setLstResponse(List<Object> lstResponse) {
		this.lstResponse = lstResponse;
	}

	@Override
	public String toString() {
		return "ResponseDTO [successful=" + successful + ", msgSuccess=" + msgSuccess + ", lstResponse=" + lstResponse
				+ "]";
	}
	 
}
