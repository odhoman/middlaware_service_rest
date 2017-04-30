package com.anibal.educational.rest_service.comps.service;

import com.anibal.educational.rest_service.comps.util.RestServiceException;

@SuppressWarnings("serial")
public class TicketHeaderException extends RestServiceException{

	public TicketHeaderException() {

	}

	public TicketHeaderException(String message) {
		super(message);
	}

	public TicketHeaderException(Throwable cause) {
		super(cause);
	}

	public TicketHeaderException(String message, Throwable cause) {
		super(message, cause);
	}

}
