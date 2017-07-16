package com.anibal.educational.rest_service.comps.service;

import com.anibal.educational.rest_service.comps.util.RestServiceException;

@SuppressWarnings("serial")
public class MonedaServiceException extends RestServiceException{

	public MonedaServiceException() {

	}

	public MonedaServiceException(String message) {
		super(message);
	}

	public MonedaServiceException(Throwable cause) {
		super(cause);
	}

	public MonedaServiceException(String message, Throwable cause) {
		super(message, cause);
	} 

}
