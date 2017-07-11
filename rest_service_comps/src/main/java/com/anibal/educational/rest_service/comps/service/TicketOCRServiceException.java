package com.anibal.educational.rest_service.comps.service;

import com.anibal.educational.rest_service.comps.util.RestServiceException;

@SuppressWarnings("serial")
public class TicketOCRServiceException  extends RestServiceException{

	public TicketOCRServiceException() {

	}

	public TicketOCRServiceException(String message) {
		super(message);
	}

	public TicketOCRServiceException(Throwable cause) {
		super(cause);
	}

	public TicketOCRServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
