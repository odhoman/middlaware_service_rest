package com.anibal.educational.rest_service.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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

import com.anibal.educational.rest_service.comps.service.TicketUserAuteticationException;
import com.anibal.educational.rest_service.comps.service.TicketUserException;
import com.anibal.educational.rest_service.comps.service.TicketUserService;
import com.anibal.educational.rest_service.domain.Message;
import com.anibal.educational.rest_service.domain.TicketUser;
import com.anibal.educational.rest_service.domain.UserCredential;

@RestController
@ContextConfiguration(classes = RestServiceContextConfigurator.class, loader = AnnotationConfigContextLoader.class)
public class TicketUserController extends AbstractRestService {

	@Autowired
	private TicketUserService ticketUserService;

	@RequestMapping("/getUser/{userId}")
	public ResponseEntity<?> getUser(@PathVariable("userId") long userId) {

		TicketUser user = null;

		logger.debug("TicketUserController - getTicketusers: Iniciando...");

		try {
			user = ticketUserService.getUser(userId);
		} catch (TicketUserException e) {
			logger.error(
					"TicketUserController - getTicketusers: No se pudo obtener ningun ticket user con userId " + userId,
					e);
			return new ResponseEntity<Message>(
					new Message(1, "No se pudo obtener ningun ticket user con userId " + userId),
					HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error(
					"TicketUserController - getTicketusers: No se pudo obtener ningun ticket user con userId " + userId,
					e);
			return new ResponseEntity<Message>(
					new Message(1, "No se pudo obtener ningun ticket user con userId " + userId),
					HttpStatus.BAD_REQUEST);
		}

		logger.debug("TicketUserController - getTicketusers: Finalizando...");

		return new ResponseEntity<TicketUser>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody TicketUser user) {

		logger.debug("TicketUserController - createUser: Iniciando...");

		try {
			user = ticketUserService.createUser(user);
		} catch (TicketUserException e) {
			logger.error("TicketUserController - createGasto: No se pudo crear el TicketUser...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo crear el TicketUser"),
					HttpStatus.BAD_REQUEST);
		}

		logger.debug("TicketUserController - createUser: Finalizado ");

		return new ResponseEntity<TicketUser>(user, HttpStatus.OK);

	}

	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody TicketUser user) {

		logger.debug("TicketUserController - updateUser: Iniciando...");

		try {
			ticketUserService.updateUser(id, user);
		} catch (TicketUserException e) {
			logger.error("TicketUserController - updateUser: No se pudo actualizar el TicketUser...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo actualizar el TicketUser"),
					HttpStatus.BAD_REQUEST);
		}

		logger.debug("TicketUserController - updateUser: Finalizando...");

		Message message = new Message(1, "Usuario actualizado");

		return new ResponseEntity<Message>(message, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {

		logger.debug("TicketUserController - deleteUser: Iniciando...");

		try {
			ticketUserService.deleteUser(id);
		} catch (TicketUserException e) {
			logger.error("TicketUserController - deleteUser: No se pudo eliminar el usuario...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo eliminar el usuario " + id),
					HttpStatus.BAD_REQUEST);
		}
		Message message = new Message(1, "Usuario Eliminado");

		logger.debug("TicketUserController - deleteUser: Finalizando...");

		return new ResponseEntity<Message>(message, HttpStatus.OK);
	}

	@RequestMapping(value = "/uploadUserImage/{userId}", headers = ("content-type=multipart/form-data"), method = RequestMethod.POST)
	public ResponseEntity<?> handleFileUpload(@PathVariable("userId") long userId,
			@RequestParam("file") MultipartFile file) {

		if (file != null && !file.isEmpty()) {

			logger.debug("TicketUserController - uploadUserImage: Iniciando...");

			try {
				ticketUserService.createUserImage(userId, file.getInputStream(),
						buildFileNameUserImage("" + userId, file.getOriginalFilename()));
			} catch (TicketUserException e) {
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

	private String buildFileNameUserImage(String userId, String originalFileName) {

		String fileName = null;
		if (originalFileName != null && !originalFileName.isEmpty() && originalFileName.indexOf(".") > 0
				&& originalFileName.split("\\.").length == 2 && !originalFileName.split("\\.")[1].isEmpty()) {
			String[] aux = originalFileName.split("\\.");
			fileName = userId + "." + aux[1];
		} else {
			fileName = userId;
		}
		return fileName;
	}

	@RequestMapping(value = "/downloadUserImage/{userId}", method = RequestMethod.GET)
	public ResponseEntity<?> getFile(@PathVariable("userId") Long userId, HttpServletResponse response) {
		
		try {
			File initialFile = ticketUserService.getUserImage(userId);
			InputStream is = new FileInputStream(initialFile);

			IOUtils.copy(is, response.getOutputStream());
			response.setHeader("Content-disposition", "attachment; filename="+initialFile.getName());
			response.flushBuffer();
		} catch (IOException e) {
			logger.error("Hubo un error al querer enviar la imagen",e);
			return new ResponseEntity<String>("Hubo un error al querer enviar la imagen", HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (TicketUserException e) {
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
	
	@RequestMapping(value = "/performAuthentication", method = RequestMethod.POST)
	public ResponseEntity<?> performAuthentication(@RequestBody UserCredential user) {

		logger.debug("TicketUserController - performAuthentication: Iniciando...");
		
		TicketUser tu = null;
		
		try {
			tu = ticketUserService.performAuthentication(user.getUser(), user.getPass());
		} catch (TicketUserAuteticationException e) {
			logger.error("TicketUserController - performAuthentication: Credenciales incompletas o incorrectas...", e);
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
		} catch (TicketUserException e) {
			logger.error("TicketUserController - performAuthentication: No se pudo autenticar el user...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo autenticar el user"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.debug("TicketUserController - performAuthentication: Finalizado ");

		return new ResponseEntity<TicketUser>(tu, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/performForgotPass", method = RequestMethod.POST)
	public ResponseEntity<?> performForgotPass(@RequestBody UserCredential user) {

		logger.debug("TicketUserController - performForgotPass: Iniciando...");

		try {
			ticketUserService.performForgotPass(user.getUser());
		} catch (TicketUserException e) {
			logger.error("TicketUserController - createGasto: No se pudo crear el TicketUser...", e);
			return new ResponseEntity<Message>(new Message(1, "No se pudo realizar la accion"),
					HttpStatus.BAD_REQUEST);
		}

		logger.debug("TicketUserController - performForgotPass: Finalizado ");

		return new ResponseEntity<TicketUser>(HttpStatus.OK);

	}

}
