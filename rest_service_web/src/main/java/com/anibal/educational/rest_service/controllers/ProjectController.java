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

import com.anibal.educational.rest_service.comps.service.ProjectService;
import com.anibal.educational.rest_service.comps.service.ProjectServiceException;
import com.anibal.educational.rest_service.domain.Message;
import com.anibal.educational.rest_service.domain.Project;

@RestController
@ContextConfiguration(classes = RestServiceContextConfigurator.class, loader = AnnotationConfigContextLoader.class)
public class ProjectController extends AbstractRestService {
	
	@Autowired
	ProjectService service;
	
	@RequestMapping("/getProjectByUserId/{userId}")
	public ResponseEntity<?> getProjectByUserId(@PathVariable("userId")Long userId){
		List<Project> lista = null;
		
		logger.debug("ProjectController - getProjectByUserId: Iniciando...");

		try {
			lista = service.getProjectByUserId(userId);
		} catch (ProjectServiceException e) {
			logger.error("ProjectController - getProjectByUserId: No se pudo obtener ningun ticket header con userId "+userId, e);
			return new ResponseEntity<>(new Message(1, "No se pudo obtener ningun project con userId "+userId),
					HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			logger.error("ProjectController - getProjectByUserId: No se pudo obtener ningun project con userId "+userId, e);
			return new ResponseEntity<>(new Message(1, "No se pudo obtener ningun  project  con userId "+userId),
					HttpStatus.BAD_REQUEST);
		}

		logger.debug("getProjectByUserId - getProjectByUserId: Finalizando...");

		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/createProject", method = RequestMethod.POST)
	public ResponseEntity<?> createProject(@RequestBody Project pro) {

		logger.debug("ProjectController - createProject: Iniciando...");
		
		try {
			service.createProject(pro);
		} catch (ProjectServiceException e) {
			logger.error("ProjectController - createProject: No se pudo crear el Project...", e);
			return new ResponseEntity<>(new Message(1, "No se pudo crear el Project"),
					HttpStatus.BAD_REQUEST);
		}

		logger.debug("ProjectController - createProject: Finalizado ");

		return new ResponseEntity<>(pro, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateProject/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateProject(@PathVariable("id") long id, @RequestBody Project pro) {

		logger.debug("ProjectController - updateProject: Iniciando...");

		try {
			service.updateProject(id, pro);
		} catch (ProjectServiceException e) {
			logger.error("ProjectController - updateProject: No se pudo actualizar el Project...", e);
			return new ResponseEntity<>(new Message(1, "No se pudo actualizar el Project"),
					HttpStatus.BAD_REQUEST);
		}
		
		Message message = new Message(1, "Project Actualizado");

		logger.debug("ProjectController - updateProject: Finalizando...");

		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteProject/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProject(@PathVariable("id") Long id) {

		logger.debug("ProjectController - deleteProject: Iniciando...");

		try {
			service.deleteProject(id);
		} catch (ProjectServiceException e) {
			logger.error("ProjectController - deleteProject: No se pudo eliminar el Project...", e);
			return new ResponseEntity<>(new Message(1, "No se pudo eliminar el Project " + id),
					HttpStatus.BAD_REQUEST);
		}
		Message message = new Message(1, "Project Eliminado");

		logger.debug("ProjectController - deleteProject: Finalizando...");

		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
