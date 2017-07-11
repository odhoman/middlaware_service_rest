package com.anibal.educational.rest_service.comps.service;

@SuppressWarnings("serial")
public class NotLineToProcessServiceException extends TicketLineServiceException{
	
	public NotLineToProcessServiceException() {

	}

	public NotLineToProcessServiceException(String message) {
		super(message);
	}

	public NotLineToProcessServiceException(Throwable cause) {
		super(cause);
	}

	public NotLineToProcessServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
