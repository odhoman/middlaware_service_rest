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

import com.anibal.educational.rest_service.comps.service.MonedaService;
import com.anibal.educational.rest_service.domain.Message;
import com.anibal.educational.rest_service.domain.Moneda;

@RestController
@ContextConfiguration(classes = RestServiceContextConfigurator.class, loader = AnnotationConfigContextLoader.class)
public class MonedaController  extends AbstractRestService {
	
	@Autowired
	MonedaService service;
	
	@RequestMapping("/getMonedaById/{id}")
	public ResponseEntity<?> getMonedaById(@PathVariable("id")Long id){
		Moneda moneda = null;
		
		logger.debug("MonedaController - getMonedaById: Iniciando...");

		try {
			moneda = service.getMoneda(id);
		}catch (Exception e) {
			logger.error("MonedaController - getMonedaById: No se pudo obtener ninguna moneda con id "+id, e);
			return new ResponseEntity<>(new Message(1, "No se pudo obtener ninguna moneda con id "+id),
					HttpStatus.BAD_REQUEST);
		}

		logger.debug("getMonedaById - getMonedaById: Finalizando...");

		return new ResponseEntity<>(moneda, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateMoneda/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateMoneda(@PathVariable("id") long id, @RequestBody Moneda moneda) {

		logger.debug("MonedaController - updateMoneda: Iniciando...");

		try {
			service.updateMoneda(id, moneda);
		} catch (Exception e) {
			logger.error("MonedaController - updateMoneda: No se pudo actualizar la moneda ...", e);
			return new ResponseEntity<>(new Message(1, "No se pudo actualizar la moneda"),
					HttpStatus.BAD_REQUEST);
		}
		
		Message message = new Message(1, "Moneda Actualizada");

		logger.debug("MonedaController - updateMoneda: Finalizando...");

		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	

}
