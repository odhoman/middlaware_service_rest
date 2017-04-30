package com.anibal.educational.rest_service.comps.service;

import com.anibal.educational.rest_service.comps.util.RestServiceException;

@SuppressWarnings("serial")
public class TicketLineServiceException extends RestServiceException{

	public TicketLineServiceException() {

	}

	public TicketLineServiceException(String message) {
		super(message);
	}

	public TicketLineServiceException(Throwable cause) {
		super(cause);
	}

	public TicketLineServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
