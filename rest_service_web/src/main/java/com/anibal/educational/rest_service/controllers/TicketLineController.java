package com.anibal.educational.rest_service.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.anibal.educational.rest_service.comps.service.TicketLineService;
import com.anibal.educational.rest_service.comps.service.TicketLineServiceException;
import com.anibal.educational.rest_service.comps.util.RestServiceUtil;
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
	public ResponseEntity<TicketLine> getLine(@PathVariable("id") long id) {

		logger.debug("TicketLineController - getLine: Iniciando...");

		TicketLine line = null;

		try {
			line = ticketLineService.getTicketLine(id);
		} catch (TicketLineServiceException e) {
			logger.error("TicketLineController - getLine: No se pudo obtener el line...", e);
			return new ResponseEntity<TicketLine>(new TicketLine(),
					HttpStatus.BAD_REQUEST);
		}

		logger.debug("TicketLineController - getLine: Finalizando...");

		return new ResponseEntity<TicketLine>(line, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/uploadTicketLineImage/{userId}", headers = ("content-type=multipart/form-data"), method = RequestMethod.POST)
	public ResponseEntity<?> handleFileUpload(@PathVariable("userId") long lineId,
			@RequestParam("file") MultipartFile file) {

		if (file != null && !file.isEmpty()) {

			logger.debug("TicketLineController - handleFileUpload: Iniciando...");

			try {
				ticketLineService.createLineImage(lineId, file.getInputStream(),
						RestServiceUtil.buildFileName("" + lineId, file.getOriginalFilename()));
			} catch (TicketLineServiceException e) {
				logger.error("No se pudo subir el file", e);
				return new ResponseEntity<String>("No se pudo subir el file", HttpStatus.INTERNAL_SERVER_ERROR);
			} catch (IOException e) {
				logger.error("No se pudo subir el file", e);
				return new ResponseEntity<String>("No se pudo subir el file", HttpStatus.INTERNAL_SERVER_ERROR);
			}

			logger.debug("Imagen de usuario guardada correctamente");
		} else {
			logger.error("File vacio o nulo");
			return new ResponseEntity<String>("No ha elegido un file", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>("Archivo subido correctamente", HttpStatus.OK);
	}

	@RequestMapping(value = "/downloadTicketLineImage/{userId}", method = RequestMethod.GET)
	public ResponseEntity<?> getFile(@PathVariable("userId") Long lineId, HttpServletResponse response) {
		
		try {
			File initialFile = ticketLineService.getLineImage(lineId);
			InputStream is = new FileInputStream(initialFile);

			IOUtils.copy(is, response.getOutputStream());
			response.setHeader("Content-disposition", "attachment; filename="+initialFile.getName());
			response.flushBuffer();
		} catch (IOException e) {
			logger.error("Hubo un error al querer enviar la imagen",e);
			return new ResponseEntity<String>("Hubo un error al querer enviar la imagen", HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (TicketLineServiceException e) {
			logger.error("Hubo un error al querer obtener la imagen",e);
			return new ResponseEntity<String>("Hubo un error al querer obtener la imagen", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// DOWNLOAD
//		try {
//			// reads input file from an absolute path
//			String filePath = "C:\\temp\\uploads\\imagen.jpg";
//			File downloadFile = new File(filePath);
//			FileInputStream inStream;
//			inStream = new FileInputStream(downloadFile);
//
//			// if you want to use a relative path to context root:
//			// String relativePath = getServletContext().getRealPath("");
//			// System.out.println("relativePath = " + relativePath);
//
//			// obtains ServletContext
//			// ServletContext context = getServletContext();
//
//			// gets MIME type of the file
//			// String mimeType = context.getMimeType(filePath);
//			// if (mimeType == null) {
//			// // set to binary type if MIME mapping not found
//			String mimeType = "application/octet-stream";
//			// }
//			System.out.println("MIME type: " + mimeType);
//
//			// modifies response
//			response.setContentType(mimeType);
//			response.setContentLength((int) downloadFile.length());
//
//			// forces download
//			String headerKey = "Content-Disposition";
//			String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
//			response.setHeader(headerKey, headerValue);
//
//			// obtains response's output stream
//			OutputStream outStream;
//			outStream = response.getOutputStream();
//
//			byte[] buffer = new byte[4096];
//			int bytesRead = -1;
//
//			while ((bytesRead = inStream.read(buffer)) != -1) {
//				outStream.write(buffer, 0, bytesRead);
//			}
//
//			inStream.close();
//			outStream.close();
//		} catch (FileNotFoundException e1) {
//			logger.error("No se pudo subir el file", e1);
//			return new ResponseEntity<String>("No se pudo subir el file", HttpStatus.INTERNAL_SERVER_ERROR);
//		} catch (IOException e) {
//			logger.error("No se pudo subir el file", e);
//			return new ResponseEntity<String>("No se pudo subir el file", HttpStatus.INTERNAL_SERVER_ERROR);
//		}

		return new ResponseEntity<String>("Archivo subido correctamente", HttpStatus.OK);

	}

}
