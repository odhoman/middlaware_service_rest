package com.anibal.educational.rest_service.comps.util;

public class RestDaoException  extends Exception {
	
	
	private static final long serialVersionUID = -1026517607053506842L;
	
	protected String uuid = null;
	protected String messageId = null;
	
	public RestDaoException() {		
	}

	public RestDaoException(String message) {
		super(message);		
	}

	public RestDaoException(Throwable cause) {
		super(cause);
	}

	public RestDaoException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public RestDaoException(Throwable cause, String uuid) {
		super(cause);
		
		this.uuid = uuid;			//TODO revisar uso
	}
	
	/** Posibilidad de especificar un id para el mensaje que podra ser utilizado para obtener la descripcion del mensaje */
	
	public RestDaoException(String messageId, String message) {
		
		super(message);
		
		this.messageId = messageId;
	}
	
	public RestDaoException(String messageId, String message, Throwable cause) {
			
		super(message, cause);
		
		this.messageId = messageId;
	}
	
	public String getMessageId() {
		return messageId;
	}
}
