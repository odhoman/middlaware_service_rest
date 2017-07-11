package com.anibal.educational.rest_service.comps.util;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class RestServiceErrorHandler implements ResponseErrorHandler {

	private Logger logger;

	public RestServiceErrorHandler(Logger logger) {
		super();
		this.logger = logger;
	}

	public boolean hasError(ClientHttpResponse response) throws IOException {
		final HttpStatus status = response.getStatusCode();

		switch (status) {
		case BAD_REQUEST: // 400 *
		case UNAUTHORIZED: // 401
		case FORBIDDEN: // 403
		case NOT_FOUND: // 404 *
		case METHOD_NOT_ALLOWED: // 405 *
		case NOT_ACCEPTABLE: // 406 *
		case REQUEST_TIMEOUT: // 408
		case CONFLICT: // 409
		case UNSUPPORTED_MEDIA_TYPE: // 415 *
		case TOO_MANY_REQUESTS: // 429
		case INTERNAL_SERVER_ERROR: // 500 *
		case NOT_IMPLEMENTED: // 501
		case BAD_GATEWAY: // 502 ?
		case SERVICE_UNAVAILABLE: // 503
			return true;
		default:
			return false;
		}
	}

	public void handleError(ClientHttpResponse response) throws IOException {

		final String message = String.format("The HTTP request failed with: %1$d - %2$s", response.getRawStatusCode(),
				response.getStatusText());
		logger.error(message, null);
	}

}
