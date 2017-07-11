package com.anibal.educational.rest_service.comps.service;

import com.anibal.educational.rest_service.comps.util.RestServiceException;

@SuppressWarnings("serial")
public class TicketPushNotificationServiceException extends RestServiceException{

	public TicketPushNotificationServiceException() {

	}

	public TicketPushNotificationServiceException(String message) {
		super(message);
	}

	public TicketPushNotificationServiceException(Throwable cause) {
		super(cause);
	}

	public TicketPushNotificationServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
