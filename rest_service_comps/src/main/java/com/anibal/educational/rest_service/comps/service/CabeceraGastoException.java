package com.anibal.educational.rest_service.comps.service;

import com.anibal.educational.rest_service.comps.util.RestServiceException;

public class CabeceraGastoException extends RestServiceException{

	private static final long serialVersionUID = 4050894454931810894L;

	public CabeceraGastoException() {

	}

	public CabeceraGastoException(String message) {
		super(message);
	}

	public CabeceraGastoException(Throwable cause) {
		super(cause);
	}

	public CabeceraGastoException(String message, Throwable cause) {
		super(message, cause);
	}

}
