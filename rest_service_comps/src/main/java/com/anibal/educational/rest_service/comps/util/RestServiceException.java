package com.anibal.educational.rest_service.comps.util;

public class RestServiceException extends Exception {
	
	
	private static final long serialVersionUID = -1026517607053506842L;
	
	protected String uuid = null;
	protected String messageId = null;
	
	public RestServiceException() {		
	}

	public RestServiceException(String message) {
		super(message);		
	}

	public RestServiceException(Throwable cause) {
		super(cause);
	}

	public RestServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public RestServiceException(Throwable cause, String uuid) {
		super(cause);
		
		this.uuid = uuid;			//TODO revisar uso
	}
	
	/** Posibilidad de especificar un id para el mensaje que podra ser utilizado para obtener la descripcion del mensaje */
	
	public RestServiceException(String messageId, String message) {
		
		super(message);
		
		this.messageId = messageId;
	}
	
	public RestServiceException(String messageId, String message, Throwable cause) {
			
		super(message, cause);
		
		this.messageId = messageId;
	}
	
	public String getMessageId() {
		return messageId;
	}
}
