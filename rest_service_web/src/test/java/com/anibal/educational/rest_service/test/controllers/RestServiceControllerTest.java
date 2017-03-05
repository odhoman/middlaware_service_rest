package com.anibal.educational.rest_service.test.controllers;

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

import com.anibal.educational.rest_service.comps.service.CabeceraGastoException;
import com.anibal.educational.rest_service.comps.service.CabeceraGastoService;
import com.anibal.educational.rest_service.comps.service.DetalleGastoService;
import com.anibal.educational.rest_service.comps.service.DetalleGastoServiceException;
import com.anibal.educational.rest_service.controllers.AbstractRestService;
import com.anibal.educational.rest_service.domain.CabeceraGasto;
import com.anibal.educational.rest_service.domain.DetalleGasto;
import com.anibal.educational.rest_service.domain.Message;

/**
 * Cotrolador de servicio REST
 */
@RestController
@ContextConfiguration(classes = RestServiceContextConfiguratorTest.class, loader = AnnotationConfigContextLoader.class)
public class RestServiceControllerTest extends AbstractRestService {

	@Autowired
	private CabeceraGastoService cabeceraGastoService;

	@Autowired
	private DetalleGastoService detalleGastoService;
	
	@RequestMapping(value = "/createGastoCabecera", method = RequestMethod.POST)
	public ResponseEntity<?> createGasto(@RequestBody CabeceraGasto cabeceraGasto) {

		logger.debug("RestServiceControllerTest - createGasto: Iniciando...");

		try {
			cabeceraGasto = cabeceraGastoService.createCabeceraGasto(cabeceraGasto);
		} catch (CabeceraGastoException e) {
			logger.error("RestServiceControllerTest - createGasto: No se pudo crear la cabecera gasto...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo crear la cabecera gasto"),
					HttpStatus.BAD_REQUEST);
		}

		logger.debug("RestServiceControllerTest - createGasto: Finalizado ");

		return new ResponseEntity<CabeceraGasto>(cabeceraGasto, HttpStatus.OK);

	}

	@RequestMapping(value = "/updateGasto/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateGasto(@PathVariable("id") long id, @RequestBody CabeceraGasto gasto) {

		logger.debug("RestServiceControllerTest - updateGasto: Iniciando...");

		try {
			cabeceraGastoService.updateCabeceraGasto(gasto, id);
		} catch (CabeceraGastoException e) {
			logger.error("RestServiceControllerTest - createGasto: No se pudo crear la cabecera gasto...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo actualizar la cabecera gasto"),
					HttpStatus.BAD_REQUEST);
		}

		logger.debug("RestServiceControllerTest - updateGasto: Finalizando...");

		return new ResponseEntity<CabeceraGasto>(gasto, HttpStatus.OK);
	}

	@RequestMapping("/getGasto/{id}") // GET
	public ResponseEntity<?> getGasto(@PathVariable("id") long id) {

		logger.debug("RestServiceControllerTest - getGasto: Iniciando...");

		CabeceraGasto obtained = null;
		CabeceraGasto filtro = new CabeceraGasto();
		filtro.setGastoId(id);

		try {
			obtained = cabeceraGastoService.getCabeceraGasto(filtro);
		} catch (CabeceraGastoException e) {
			logger.error("RestServiceControllerTest - createGasto: No se pudo crear la cabecera gasto...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo obtener la cabecera gasto"),
					HttpStatus.BAD_REQUEST);
		}

		logger.debug("RestServiceControllerTest - getGasto: Finalizando...");

		return new ResponseEntity<CabeceraGasto>(obtained, HttpStatus.OK);

	}

	@RequestMapping(value = "/deleteGasto/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteGasto(@PathVariable("id") Long id) {

		logger.debug("RestServiceControllerTest - getGasto: Iniciando...");

		try {
			cabeceraGastoService.deleteCabeceraGasto(id);
		} catch (CabeceraGastoException e) {
			logger.error("RestServiceControllerTest - deleteGasto: No se pudo crear la cabecera gasto...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo eliminar la cabecera gasto " + id),
					HttpStatus.BAD_REQUEST);
		}

		Message message = new Message(1, "Gasto Eliminado");

		logger.debug("RestServiceControllerTest - deleteGasto: Finalizando...");

		return new ResponseEntity<Message>(message, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteGastos", method = RequestMethod.PUT)
	public ResponseEntity<?> deleteGastos( @RequestBody List<CabeceraGasto> filtros) {

		logger.debug("RestServiceControllerTest - getGasto: Iniciando...");

		try {
			cabeceraGastoService.deleteCabecerasGasto(filtros);;
		} catch (CabeceraGastoException e) {
			logger.error("RestServiceControllerTest - deleteGastos: No se pudieron eliminar las cabeceras gastos...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudieron eliminar las cabeceras gastos "),
					HttpStatus.BAD_REQUEST);
		}

		Message message = new Message(1, "Se Eliminaron correctamente las cabeceras Gastos");

		logger.debug("RestServiceControllerTest - deleteGastos: Finalizando...");

		return new ResponseEntity<Message>(message, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/createDetallesGasto", method = RequestMethod.POST)
	public ResponseEntity<?> createDetallesGasto(@RequestBody List<DetalleGasto> detalles) {

		logger.debug("RestServiceControllerTest - createDetallesGasto: Iniciando...");

		try {
			 detalles = detalleGastoService.createDetallesGastos(detalles);
		} catch (DetalleGastoServiceException e) {
			logger.error("RestServiceControllerTest - createDetallesGasto: No se pudieron crear los detalles de gastos...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo crear la cabecera gasto"),
					HttpStatus.BAD_REQUEST);
		}

		logger.debug("RestServiceControllerTest - createDetallesGasto: Finalizado ");

		return new ResponseEntity<List<DetalleGasto>>(detalles, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/updateDetallesGasto", method = RequestMethod.PUT)
	public ResponseEntity<?> updateDetallesGasto(@RequestBody List<DetalleGasto> detalles) {

		logger.debug("RestServiceControllerTest - updateDetallesGasto: Iniciando...");

		try {
			detalleGastoService.updateDetallesGastos(detalles);
		} catch (DetalleGastoServiceException e) {
			logger.error("RestServiceControllerTest - updateDetallesGasto: No se actualizar los detalles de gastos...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo actualizar la cabecera gasto"),
					HttpStatus.BAD_REQUEST);
		}

		Message message = new Message(1, "Se actualizaron correctamente los detalles de gastos");
		
		logger.debug("RestServiceControllerTest - updateDetallesGasto: Finalizando...");

		return new ResponseEntity<Message>(message, HttpStatus.OK);

	}
	
	@RequestMapping("/getDetallesGasto/{gasto_id}") // GET
	public ResponseEntity<?> getDetallesGasto(@PathVariable("gasto_id") long id) {

		logger.debug("RestServiceControllerTest - getDetallesGasto: Iniciando...");

		List<DetalleGasto> detalles = null;
		
		DetalleGasto filtro = new DetalleGasto();
		filtro.setGastoId(id);
		try {
			detalles = detalleGastoService.getDetallesGastos(filtro);
		} catch (DetalleGastoServiceException e) {
			logger.error("RestServiceControllerTest - getDetallesGasto: No se pudieron obtener los detalles de gastos...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudieron obtener los detalles de gastos"),
					HttpStatus.BAD_REQUEST);
		}

		logger.debug("RestServiceControllerTest - getDetallesGasto: Finalizando...");

		return new ResponseEntity<List<DetalleGasto>>(detalles, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/deleteDetallesGasto", method = RequestMethod.PUT)
	public ResponseEntity<?> deleteDetallesGasto(@RequestBody List<DetalleGasto> detalles) {

		logger.debug("RestServiceControllerTest - deleteDetallesGasto: Iniciando...");

		try {
			detalleGastoService.deleteDetallesGastos(detalles);
		} catch (DetalleGastoServiceException e) {
			logger.error("RestServiceControllerTest - deleteDetallesGasto: No se pudieron eliminar los detalles de gastos...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudieron eliminar los detalles de gastos"),
					HttpStatus.BAD_REQUEST);
		}

		Message message = new Message(1, "Gasto Eliminado");

		logger.debug("RestServiceControllerTest - deleteDetallesGasto: Finalizando...");

		return new ResponseEntity<Message>(message, HttpStatus.OK);
	}



}
