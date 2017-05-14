package com.anibal.educational.rest_service.comps.dao.file_managing;

import com.anibal.educational.rest_service.comps.util.RestDaoException;

@SuppressWarnings("serial")
public class FileManagingDaoException extends RestDaoException {
	
	public FileManagingDaoException() {

	}

	public FileManagingDaoException(String message) {
		super(message);
	}

	public FileManagingDaoException(Throwable cause) {
		super(cause);
	}

	public FileManagingDaoException(String message, Throwable cause) {
		super(message, cause);
	}

}
