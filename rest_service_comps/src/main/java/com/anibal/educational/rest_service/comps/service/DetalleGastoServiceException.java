package com.anibal.educational.rest_service.comps.service;

import com.anibal.educational.rest_service.comps.util.RestServiceException;

public class DetalleGastoServiceException  extends RestServiceException{

	private static final long serialVersionUID = -7832572914537778398L;

	public DetalleGastoServiceException() {

	}

	public DetalleGastoServiceException(String message) {
		super(message);
	}

	public DetalleGastoServiceException(Throwable cause) {
		super(cause);
	}

	public DetalleGastoServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
