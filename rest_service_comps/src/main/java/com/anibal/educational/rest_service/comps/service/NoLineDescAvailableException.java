package com.anibal.educational.rest_service.comps.service;

@SuppressWarnings("serial")
public class NoLineDescAvailableException extends TicketLineServiceException{
	
	public NoLineDescAvailableException() {

	}

	public NoLineDescAvailableException(String message) {
		super(message);
	}

	public NoLineDescAvailableException(Throwable cause) {
		super(cause);
	}

	public NoLineDescAvailableException(String message, Throwable cause) {
		super(message, cause);
	}

}
