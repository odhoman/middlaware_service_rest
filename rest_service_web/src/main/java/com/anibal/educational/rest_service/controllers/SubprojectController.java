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

import com.anibal.educational.rest_service.comps.service.SubprojectService;
import com.anibal.educational.rest_service.comps.service.SubprojectServiceException;
import com.anibal.educational.rest_service.domain.Message;
import com.anibal.educational.rest_service.domain.Subproject;

@RestController
@ContextConfiguration(classes = RestServiceContextConfigurator.class, loader = AnnotationConfigContextLoader.class)
public class SubprojectController extends AbstractRestService {
	
	@Autowired
	SubprojectService service;
	
	@RequestMapping("/getSubprojectByUserId/{userId}")
	public ResponseEntity<?> getSubprojectByUserId(@PathVariable("userId")Long userId){
		List<Subproject> lista = null;
		
		logger.debug("SubprojectController - getSubprojectByUserId: Iniciando...");

		try {
			lista = service.getSubprojectByUserId(userId);
		} catch (SubprojectServiceException e) {
			logger.error("SubprojectController - getSubprojectByUserId: No se pudo obtener ningun ticket header con userId "+userId, e);
			return new ResponseEntity<>(new Message(1, "No se pudo obtener ningun project con userId "+userId),
					HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			logger.error("SubprojectController - getSubprojectByUserId: No se pudo obtener ningun project con userId "+userId, e);
			return new ResponseEntity<>(new Message(1, "No se pudo obtener ningun  project  con userId "+userId),
					HttpStatus.BAD_REQUEST);
		}

		logger.debug("getSubprojectByUserId - getSubprojectByUserId: Finalizando...");

		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/createSubproject", method = RequestMethod.POST)
	public ResponseEntity<?> createSubproject(@RequestBody Subproject pro) {

		logger.debug("SubprojectController - createSubproject: Iniciando...");
		
		try {
			service.createSubproject(pro);
		} catch (SubprojectServiceException e) {
			logger.error("SubprojectController - createSubproject: No se pudo crear el Subproject...", e);
			return new ResponseEntity<>(new Message(1, "No se pudo crear el Subproject"),
					HttpStatus.BAD_REQUEST);
		}

		logger.debug("SubprojectController - createSubproject: Finalizado ");

		return new ResponseEntity<>(pro, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateSubproject/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateSubproject(@PathVariable("id") long id, @RequestBody Subproject pro) {

		logger.debug("SubprojectController - updateSubproject: Iniciando...");

		try {
			service.updateSubproject(id, pro);
		} catch (SubprojectServiceException e) {
			logger.error("SubprojectController - updateSubproject: No se pudo actualizar el Subproject...", e);
			return new ResponseEntity<>(new Message(1, "No se pudo actualizar el Subproject"),
					HttpStatus.BAD_REQUEST);
		}
		
		Message message = new Message(1, "Subproject Actualizado");

		logger.debug("SubprojectController - updateSubproject: Finalizando...");

		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteSubproject/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteSubproject(@PathVariable("id") Long id) {

		logger.debug("SubprojectController - deleteSubproject: Iniciando...");

		try {
			service.deleteSubproject(id);
		} catch (SubprojectServiceException e) {
			logger.error("SubprojectController - deleteSubproject: No se pudo eliminar el Subproject...", e);
			return new ResponseEntity<>(new Message(1, "No se pudo eliminar el Subproject " + id),
					HttpStatus.BAD_REQUEST);
		}
		Message message = new Message(1, "Subproject Eliminado");

		logger.debug("SubprojectController - deleteSubproject: Finalizando...");

		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
