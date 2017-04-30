package com.anibal.educational.rest_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anibal.educational.rest_service.comps.service.TicketUserException;
import com.anibal.educational.rest_service.comps.service.TicketUserService;
import com.anibal.educational.rest_service.domain.Message;
import com.anibal.educational.rest_service.domain.TicketUser;

@RestController
@ContextConfiguration(classes = RestServiceContextConfigurator.class, loader = AnnotationConfigContextLoader.class)
public class TicketUserController extends AbstractRestService {

	@Autowired
	private TicketUserService ticketUserService;
	
	
	@RequestMapping("/getUser/{userId}")
	public ResponseEntity<?> getTicketusers(@PathVariable("userId") long userId) {

		TicketUser user = null;
		
		logger.debug("TicketUserController - getTicketusers: Iniciando...");

		try {
			user = ticketUserService.getUser(userId);
		} catch (TicketUserException e) {
			logger.error("TicketUserController - getTicketusers: No se pudo obtener ningun ticket user con userId "+userId, e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo obtener ningun ticket user con userId "+userId),
					HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			logger.error("TicketUserController - getTicketusers: No se pudo obtener ningun ticket user con userId "+userId, e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo obtener ningun ticket user con userId "+userId),
					HttpStatus.BAD_REQUEST);
		}

		logger.debug("TicketUserController - getTicketusers: Finalizando...");

		return new ResponseEntity<TicketUser>(user, HttpStatus.OK);
	}

	
}
