package com.anibal.educational.rest_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anibal.educational.rest_service.comps.service.TicketHeaderException;
import com.anibal.educational.rest_service.comps.service.TicketHeaderService;
import com.anibal.educational.rest_service.domain.Message;
import com.anibal.educational.rest_service.domain.TicketHeader;

@RestController
@ContextConfiguration(classes = RestServiceContextConfigurator.class, loader = AnnotationConfigContextLoader.class)
public class TicketHeaderController extends AbstractRestService {
	
	@Autowired
	private TicketHeaderService ticketHeaderService;
	
	@RequestMapping("/getTicketHeaders/{userId}")
	public ResponseEntity<?> getTicketHeaders(@PathVariable("userId") long userId) {

		List<TicketHeader> lista = null;
		
		logger.debug("TicketHeaderController - getTicketHeaders: Iniciando...");

		try {
			lista = ticketHeaderService.getTicketHeaderByUserId(userId);
		} catch (TicketHeaderException e) {
			logger.error("TicketHeaderController - getTicketHeaders: No se pudo obtener ningun ticket header con userId "+userId, e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo obtener ningun ticket header con userId "+userId),
					HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			logger.error("TicketHeaderController - getTicketHeaders: No se pudo obtener ningun ticket header con userId "+userId, e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo obtener ningun ticket header con userId "+userId),
					HttpStatus.BAD_REQUEST);
		}

		logger.debug("getTicketHeaders - getTicketHeaders: Finalizando...");

		return new ResponseEntity<List<TicketHeader>>(lista, HttpStatus.OK);
	}

}
