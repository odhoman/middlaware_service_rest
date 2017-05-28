package com.anibal.educational.rest_service.comps.service;

import com.anibal.educational.rest_service.comps.util.RestServiceException;

@SuppressWarnings("serial")
public class TicketDistributionException extends RestServiceException {
	
	public TicketDistributionException() {

	}

	public TicketDistributionException(String message) {
		super(message);
	}

	public TicketDistributionException(Throwable cause) {
		super(cause);
	}

	public TicketDistributionException(String message, Throwable cause) {
		super(message, cause);
	} 
}
