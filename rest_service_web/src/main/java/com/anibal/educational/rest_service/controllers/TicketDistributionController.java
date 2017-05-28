package com.anibal.educational.rest_service.controllers;

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

import com.anibal.educational.rest_service.comps.service.TicketDistributionException;
import com.anibal.educational.rest_service.comps.service.TicketDistributionService;
import com.anibal.educational.rest_service.domain.Message;
import com.anibal.educational.rest_service.domain.TicketDistribution;

@RestController
@ContextConfiguration(classes = RestServiceContextConfigurator.class, loader = AnnotationConfigContextLoader.class)
public class TicketDistributionController extends AbstractRestService {
	
	@Autowired
	private TicketDistributionService service;
	
	@RequestMapping(value = "/createDistribution", method = RequestMethod.POST)
	public ResponseEntity<?> createDistribution(@RequestBody TicketDistribution ticketDistribution) {

		logger.debug("TicketDistributionController - createDistribution: Iniciando...");

		
		try {
			ticketDistribution = service.createTicketDistribution(ticketDistribution);
		} catch (TicketDistributionException e) {
			logger.error("TicketDistributionController - createDistribution: No se pudo crear el TicketDistribution...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo crear el TicketDistribution"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.debug("TicketDistributionController - createDistribution: Finalizado ");

		return new ResponseEntity<TicketDistribution>(ticketDistribution, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/updateDistribution/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateDistribution(@PathVariable("id") long id, @RequestBody TicketDistribution ticketDistribution) {

		logger.debug("TicketDistributionController - updateDistribution: Iniciando...");

		try {
			service.updateTicketDistribution(id, ticketDistribution);
		} catch (TicketDistributionException e) {
			logger.error("TicketDistributionController - updateDistribution: No se pudo actualizar el TicketDistribution...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo actualizar el TicketDistribution"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		Message message = new Message(1, "TicketDistribution Actualizada");

		logger.debug("TicketDistributionController - updateDistribution: Finalizando...");

		return new ResponseEntity<Message>(message, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteDistribution/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteDistribution(@PathVariable("id") Long id) {

		logger.debug("TicketDistributionController - deleteDistribution: Iniciando...");

		try {
			service.deleteTicketDistribution(id);
		} catch (TicketDistributionException e) {
			logger.error("TicketDistributionController - deleteDistribution: No se pudo eliminar la TicketDistribution...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo eliminar la TicketDistribution " + id),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Message message = new Message(1, "TicketDistribution Eliminada");

		logger.debug("TicketDistributionController - deleteDistribution: Finalizando...");

		return new ResponseEntity<Message>(message, HttpStatus.OK);
	}
	
	@RequestMapping("/getDistribution/{id}") 
	public ResponseEntity<?> getDistribution(@PathVariable("id") long id) {

		logger.debug("TicketDistributionController - getDistribution: Iniciando...");

		TicketDistribution line = null;

		try {
			line = service.getTicketDistributionById(id);
		} catch (TicketDistributionException e) {
			logger.error("TicketDistributionController - getDistribution: No se pudo obtener el TicketDistribution...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo obtener el TicketDistribution"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.debug("TicketDistributionController - getDistribution: Finalizando...");

		return new ResponseEntity<TicketDistribution>(line, HttpStatus.OK);
	}
	

}
