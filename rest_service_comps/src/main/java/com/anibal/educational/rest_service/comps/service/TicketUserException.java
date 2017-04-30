package com.anibal.educational.rest_service.comps.service;

import com.anibal.educational.rest_service.comps.util.RestServiceException;

@SuppressWarnings("serial")
public class TicketUserException extends RestServiceException{


	public TicketUserException() {

	}

	public TicketUserException(String message) {
		super(message);
	}

	public TicketUserException(Throwable cause) {
		super(cause);
	}

	public TicketUserException(String message, Throwable cause) {
		super(message, cause);
	}
}
