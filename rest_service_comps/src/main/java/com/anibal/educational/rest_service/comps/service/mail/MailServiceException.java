package com.anibal.educational.rest_service.comps.service.mail;

import com.anibal.educational.rest_service.comps.util.RestServiceException;

@SuppressWarnings("serial")
public class MailServiceException  extends RestServiceException{

	public MailServiceException() {

	}

	public MailServiceException(String message) {
		super(message);
	}

	public MailServiceException(Throwable cause) {
		super(cause);
	}

	public MailServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
