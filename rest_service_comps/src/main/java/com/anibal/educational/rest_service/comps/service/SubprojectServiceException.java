package com.anibal.educational.rest_service.comps.service;

import com.anibal.educational.rest_service.comps.util.RestServiceException;

@SuppressWarnings("serial")
public class SubprojectServiceException extends RestServiceException{

	public SubprojectServiceException() {

	}

	public SubprojectServiceException(String message) {
		super(message);
	}

	public SubprojectServiceException(Throwable cause) {
		super(cause);
	}

	public SubprojectServiceException(String message, Throwable cause) {
		super(message, cause);
	} 

}
