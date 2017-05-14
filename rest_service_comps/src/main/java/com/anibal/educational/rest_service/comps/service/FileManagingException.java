package com.anibal.educational.rest_service.comps.service;

import com.anibal.educational.rest_service.comps.util.RestServiceException;

@SuppressWarnings("serial")
public class FileManagingException  extends RestServiceException{

	public FileManagingException() {

	}

	public FileManagingException(String message) {
		super(message);
	}

	public FileManagingException(Throwable cause) {
		super(cause);
	}

	public FileManagingException(String message, Throwable cause) {
		super(message, cause);
	}

}
