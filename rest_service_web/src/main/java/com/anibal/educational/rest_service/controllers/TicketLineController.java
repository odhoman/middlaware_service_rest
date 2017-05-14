package com.anibal.educational.rest_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	
	@RequestMapping(value = "/createLine", method = RequestMethod.POST)
	public ResponseEntity<?> createLine(@RequestBody TicketLine ticketLine) {

		logger.debug("TicketLineController - createLine: Iniciando...");

		
		try {
			ticketLine = ticketLineService.createTicketLine(ticketLine);
		} catch (TicketLineServiceException e) {
			logger.error("TicketLineController - createGasto: No se pudo crear el TicketLine...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo crear el TicketLine"),
					HttpStatus.BAD_REQUEST);
		}

		logger.debug("TicketLineController - createLine: Finalizado ");

		return new ResponseEntity<TicketLine>(ticketLine, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/updateLine/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateLine(@PathVariable("id") long id, @RequestBody TicketLine ticketLine) {

		logger.debug("TicketLineController - updateLine: Iniciando...");

		try {
			ticketLineService.updateTicketLine(id, ticketLine);
		} catch (TicketLineServiceException e) {
			logger.error("TicketLineController - updateLine: No se pudo actualizar el TicketLine...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo actualizar el TicketLine"),
					HttpStatus.BAD_REQUEST);
		}
		
		Message message = new Message(1, "Ticket Line Actualizada");

		logger.debug("TicketLineController - updateLine: Finalizando...");

		return new ResponseEntity<Message>(message, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteLine/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteLine(@PathVariable("id") Long id) {

		logger.debug("TicketLineController - deleteLine: Iniciando...");

		try {
			ticketLineService.deleteTicketLine(id);
		} catch (TicketLineServiceException e) {
			logger.error("TicketLineController - deleteLine: No se pudo eliminar la line...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo eliminar la line " + id),
					HttpStatus.BAD_REQUEST);
		}
		Message message = new Message(1, "Ticket Line Eliminada");

		logger.debug("TicketLineController - deleteLine: Finalizando...");

		return new ResponseEntity<Message>(message, HttpStatus.OK);
	}
	
	@RequestMapping("/getLine/{id}") 
	public ResponseEntity<?> getLine(@PathVariable("id") long id) {

		logger.debug("TicketLineController - getLine: Iniciando...");

		TicketLine line = null;

		try {
			line = ticketLineService.getTicketLine(id);
		} catch (TicketLineServiceException e) {
			logger.error("TicketLineController - getLine: No se pudo obtener el line...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo obtener el line"),
					HttpStatus.BAD_REQUEST);
		}

		logger.debug("TicketLineController - getLine: Finalizando...");

		return new ResponseEntity<TicketLine>(line, HttpStatus.OK);

	}

}
