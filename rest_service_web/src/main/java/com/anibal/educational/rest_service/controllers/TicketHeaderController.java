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
	public ResponseEntity<?> getTicketHeaders(@PathVariable("userId") Long userId) {

		List<TicketHeader> lista = null;
		
		logger.debug("TicketHeaderController - getTicketHeaders: Iniciando...");

		try {
			lista = ticketHeaderService.getTicketHeaderByUserId(userId);
		} catch (TicketHeaderException e) {
			logger.error("TicketHeaderController - getTicketHeaders: No se pudo obtener ningun ticket header con userId "+userId, e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo obtener ningun ticket header con userId "+userId),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}catch (Exception e) {
			logger.error("TicketHeaderController - getTicketHeaders: No se pudo obtener ningun ticket header con userId "+userId, e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo obtener ningun ticket header con userId "+userId),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.debug("getTicketHeaders - getTicketHeaders: Finalizando...");

		return new ResponseEntity<List<TicketHeader>>(lista, HttpStatus.OK);
	}
	
	@RequestMapping("/getTicketHeaders/{userId}/{ticketId}")
	public ResponseEntity<?> getTicketHeaderByUserAndTicketId(@PathVariable("userId") Long userId, @PathVariable("ticketId") Long ticketId) {

		List<TicketHeader> lista = null;
		
		logger.debug("TicketHeaderController - getTicketHeaderByUserAndTicketId: Iniciando...");

		try {
			lista = ticketHeaderService.getTicketHeaderByUserAndTicketId(userId,ticketId);
		} catch (TicketHeaderException e) {
			logger.error("TicketHeaderController - getTicketHeaderByUserAndTicketId: No se pudo obtener ningun ticket header con userId "+userId+" ticketId "+ticketId, e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo obtener ningun ticket header con userId "+userId),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}catch (Exception e) {
			logger.error("TicketHeaderController - getTicketHeaderByUserAndTicketId: No se pudo obtener ningun ticket header con userId "+userId+" ticketId "+ticketId, e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo obtener ningun ticket header con userId "+userId),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.debug("getTicketHeaders - getTicketHeaderByUserAndTicketId: Finalizando...");

		return new ResponseEntity<List<TicketHeader>>(lista, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/createTicket", method = RequestMethod.POST)
	public ResponseEntity<?> createTicket(@RequestBody TicketHeader ticketHeader) {

		logger.debug("TicketHeaderController - createTicket: Iniciando...");

		
		try {
			ticketHeader = ticketHeaderService.createTicketHeader(ticketHeader);
		} catch (TicketHeaderException e) {
			logger.error("TicketHeaderController - createGasto: No se pudo crear el TicketHeader...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo crear el TicketHeader"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.debug("TicketHeaderController - createTicket: Finalizado ");

		return new ResponseEntity<TicketHeader>(ticketHeader, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/updateTicket/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateTicket(@PathVariable("id") long id, @RequestBody TicketHeader ticketLine) {

		logger.debug("TicketHeaderController - updateTicket: Iniciando...");

		try {
			ticketHeaderService.updateTicketHeader(id, ticketLine);
		} catch (TicketHeaderException e) {
			logger.error("TicketHeaderController - updateTicket: No se pudo actualizar el TicketHeader...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo actualizar el TicketHeader"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		Message message = new Message(1, "Ticket Header Actualizada");

		logger.debug("TicketHeaderController - updateTicket: Finalizando...");

		return new ResponseEntity<Message>(message, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteTicket/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteTicket(@PathVariable("id") Long id) {

		logger.debug("TicketHeaderController - deleteTicket: Iniciando...");

		try {
			ticketHeaderService.deleteTicketHeader(id);
		} catch (TicketHeaderException e) {
			logger.error("TicketHeaderController - deleteTicket: No se pudo eliminar la TicketHeader...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo eliminar la TicketHeader " + id),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Message message = new Message(1, "Ticket Header Eliminada");

		logger.debug("TicketHeaderController - deleteTicket: Finalizando...");

		return new ResponseEntity<Message>(message, HttpStatus.OK);
	}
	
	@RequestMapping("/getTicket/{id}") 
	public ResponseEntity<?> getTicket(@PathVariable("id") long id) {

		logger.debug("TicketHeaderController - getTicket: Iniciando...");

		TicketHeader line = null;

		try {
			line = ticketHeaderService.getTicketHeaderById(id);
		} catch (TicketHeaderException e) {
			logger.error("TicketHeaderController - getTicket: No se pudo obtener el TicketHeader...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo obtener el TicketHeader"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.debug("TicketHeaderController - getTicket: Finalizando...");

		return new ResponseEntity<TicketHeader>(line, HttpStatus.OK);

	}
}
