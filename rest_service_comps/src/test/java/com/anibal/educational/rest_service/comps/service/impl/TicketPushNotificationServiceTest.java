package com.anibal.educational.rest_service.comps.service.impl;

import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anibal.educational.rest_service.comps.service.TicketPushNotificationService;
import com.anibal.educational.rest_service.comps.service.TicketPushNotificationServiceException;
import com.anibal.educational.rest_service.domain.TicketLine;

/** Test del Push */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfigTest.class })
public class TicketPushNotificationServiceTest {

	
	@Autowired
	TicketPushNotificationService service;
	
	@Autowired
	Logger logger;
	
	@Test
	public void testPushNotification(){
		
		logger.debug("testPushNotification: iniciando...");
		
		TicketLine line = new TicketLine();
		line.setLineId(123L);
		line.setUserId(852L);
		
		try {
			service.performNotification(line, "https://fcm.googleapis.com/fcm/send", "key=AAAAwrEMTNA:APA91bGOrajDBa5Dv7yaogIIMxuBxTgBpvIN0it0N5xNOsB5KxMQteINFY6EThUIfEibbK6qRq7bb8Cdljn4qPbCwg0NoJmCPojngCNA7hTrMGUCaBR1xF7o7msrL4zLtqbb64F1Ixps");
		} catch (TicketPushNotificationServiceException e) {
			logger.error("No se pudo enviar la notificación",e);
			fail(e.getMessage());
		}
		
		logger.debug("testPushNotification: finalizando...");
	}
}
