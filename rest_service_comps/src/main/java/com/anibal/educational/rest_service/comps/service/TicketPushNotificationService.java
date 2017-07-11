package com.anibal.educational.rest_service.comps.service;

import com.anibal.educational.rest_service.domain.TicketLine;

public interface TicketPushNotificationService {
	
	public void performNotification(TicketLine line) throws TicketPushNotificationServiceException;
	
	public void performNotification(TicketLine line,String url, String autorization) throws TicketPushNotificationServiceException;

}
