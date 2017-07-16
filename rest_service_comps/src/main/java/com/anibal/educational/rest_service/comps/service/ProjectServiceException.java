package com.anibal.educational.rest_service.comps.service;

import com.anibal.educational.rest_service.comps.util.RestServiceException;

@SuppressWarnings("serial")
public class ProjectServiceException extends RestServiceException{

	public ProjectServiceException() {

	}

	public ProjectServiceException(String message) {
		super(message);
	}

	public ProjectServiceException(Throwable cause) {
		super(cause);
	}

	public ProjectServiceException(String message, Throwable cause) {
		super(message, cause);
	} 

}
