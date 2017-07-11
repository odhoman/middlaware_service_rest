package com.anibal.educational.rest_service.comps.service.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.anibal.educational.rest_service.comps.service.TicketPushNotificationService;
import com.anibal.educational.rest_service.comps.service.TicketPushNotificationServiceException;
import com.anibal.educational.rest_service.comps.util.RestServiceConstant;
import com.anibal.educational.rest_service.domain.TicketLine;
import com.anibal.educational.rest_service.domain.ocr.push.request.Data;
import com.anibal.educational.rest_service.domain.ocr.push.request.PushOCRNotificationRequest;
import com.anibal.educational.rest_service.domain.ocr.push.response.PushOCRNotificationResponse;
import com.odhoman.api.utilities.config.AbstractConfig;

public class TicketPushNotificationServiceImpl extends AbstractService implements TicketPushNotificationService {

	public TicketPushNotificationServiceImpl() {
		super();
	}

	public TicketPushNotificationServiceImpl(AbstractConfig config) {
		super(config);
	}

	public void performNotification(TicketLine line) throws TicketPushNotificationServiceException {

		performNotification(line, config.getProperty(RestServiceConstant.APP_OCR_PUSH_NOTIFICATION_URL),
							config.getProperty(RestServiceConstant.APP_OCR_PUSH_NOTIFICATION_AUTORIZATION));

	}

	protected PushOCRNotificationRequest getPushOCRNotificationRequest(TicketLine line) {

		PushOCRNotificationRequest request = new PushOCRNotificationRequest();
		request.setTo(config.getProperty(RestServiceConstant.APP_OCR_PUSH_NOTIFICATION_TO) + line.getUserId());
		Data data = new Data();
		data.setTitle(config.getProperty(RestServiceConstant.APP_OCR_PUSH_NOTIFICATION_TITLE));
		data.setBody(config.getProperty(RestServiceConstant.APP_OCR_PUSH_NOTIFICATION_BODY));
		data.setLineId("" + line.getLineId());
		request.setData(data);

		return request;
	}

	public void performNotification(TicketLine line, String url, String autorization)
			throws TicketPushNotificationServiceException {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.set(config.getProperty(RestServiceConstant.APP_OCR_PUSH_NOTIFICATION_AUTORIZATION_KEY),
				autorization);

		HttpEntity<PushOCRNotificationRequest> request1 = new HttpEntity<PushOCRNotificationRequest>(
				getPushOCRNotificationRequest(line), requestHeaders);
		try {
			restTemplate.postForObject(url, request1, PushOCRNotificationResponse.class);
		} catch (Exception e) {
			throw new TicketPushNotificationServiceException(e);
		}
	}

}
