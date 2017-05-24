package com.anibal.educational.rest_service.comps.service;

@SuppressWarnings("serial")
public class TicketUserAuteticationException extends  TicketUserException{

	public TicketUserAuteticationException() {

	}

	public TicketUserAuteticationException(String message) {
		super(message);
	}

	public TicketUserAuteticationException(Throwable cause) {
		super(cause);
	}

	public TicketUserAuteticationException(String message, Throwable cause) {
		super(message, cause);
	}

}
