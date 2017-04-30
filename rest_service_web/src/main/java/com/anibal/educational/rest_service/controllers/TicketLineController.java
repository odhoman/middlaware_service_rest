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

import com.anibal.educational.rest_service.comps.service.TicketLineService;
import com.anibal.educational.rest_service.comps.service.TicketLineServiceException;
import com.anibal.educational.rest_service.domain.Message;
import com.anibal.educational.rest_service.domain.TicketLine;

@RestController
@ContextConfiguration(classes = RestServiceContextConfigurator.class, loader = AnnotationConfigContextLoader.class)
public class TicketLineController extends AbstractRestService {
	
	@Autowired
	private TicketLineService ticketLineService;
	
	@RequestMapping("/getTicketLines/{ticketId}")
	public ResponseEntity<?> getTicketLines(@PathVariable("ticketId") long ticketId) {

		List<TicketLine> lista = null;
		
		logger.debug("TicketLineController - getTicketLines: Iniciando...");

		try {
			lista = ticketLineService.getTicketLinesByTicketId(ticketId);
		} catch (TicketLineServiceException e) {
			logger.error("TicketLineController - getTicketLines: No se pudo obtener ningun ticket line con ticketId "+ticketId, e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo obtener ningun ticket line con ticketId "+ticketId),
					HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			logger.error("TicketLineController - getTicketLines: No se pudo obtener ningun ticket line con ticketId "+ticketId, e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo obtener ningun ticket line con ticketId "+ticketId),
					HttpStatus.BAD_REQUEST);
		}

		logger.debug("getTicketLines - getTicketLines: Finalizando...");

		return new ResponseEntity<List<TicketLine>>(lista, HttpStatus.OK);
	}

}
