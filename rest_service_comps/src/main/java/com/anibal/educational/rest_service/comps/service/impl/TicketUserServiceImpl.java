package com.anibal.educational.rest_service.comps.service.impl;

import java.io.File;
import java.io.InputStream;

import com.anibal.educational.rest_service.comps.service.FileManagingException;
import com.anibal.educational.rest_service.comps.service.FileManagingService;
import com.anibal.educational.rest_service.comps.service.TicketUserAuteticationException;
import com.anibal.educational.rest_service.comps.service.TicketUserException;
import com.anibal.educational.rest_service.comps.service.TicketUserService;
import com.anibal.educational.rest_service.comps.service.mail.MailContent;
import com.anibal.educational.rest_service.comps.service.mail.MailService;
import com.anibal.educational.rest_service.comps.service.mail.MailServiceImpl;
import com.anibal.educational.rest_service.comps.util.RestServiceConstant;
import com.anibal.educational.rest_service.comps.util.RestServiceUtil;
import com.anibal.educational.rest_service.domain.TicketUser;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.dao.AbstractAbmDAO;
import com.odhoman.api.utilities.dao.DAOException;
import com.odhoman.api.utilities.dao.ItemNotFoundException;

public class TicketUserServiceImpl extends AbstractService implements TicketUserService {

	private AbstractAbmDAO<TicketUser, TicketUser> dao;
	private FileManagingService fileService;
	
	public TicketUserServiceImpl(AbstractAbmDAO<TicketUser, TicketUser> dao, FileManagingService fileService) {
		super();
		this.dao = dao;
		this.fileService = fileService;
	}

	public TicketUserServiceImpl(AbstractAbmDAO<TicketUser, TicketUser> dao, FileManagingService fileService, AbstractConfig config) {
		super(config);
		this.dao = dao;
		this.fileService = fileService;
	}

	public TicketUser getUser(Long userId) throws TicketUserException {

		TicketUser user = null;

		logger.debug("TicketUserServiceImplImpl - getUser: iniciando");

		TicketUser filter = new TicketUser();
		filter.setUserId(userId);
		try {
			user = dao.getItem(filter);
		} catch (DAOException e) {
			logger.error("TicketUserServiceImplImpl - getUser: ocurrio un error al querer obtener el usuario", e);
			throw new TicketUserException(e);
		}

		logger.debug("TicketUserServiceImplImpl - getUser: finalizando");

		user.setUserPassword(null);
		
		return user;
	}

	public void updateUser(Long id, TicketUser user) throws TicketUserException {

		logger.debug("TicketUserServiceImplImpl - updateUser: iniciando");

		TicketUser filter = new TicketUser();
		filter.setUserId(id);
		try {
			dao.changeItem(filter, user);
		} catch (DAOException e) {
			throw new TicketUserException(e);
		}

		logger.debug("TicketUserServiceImplImpl - updateUser: finalizando");
	}

	public void deleteUser(Long userId) throws TicketUserException {

		logger.debug("TicketUserServiceImplImpl - deleteUser: iniciando");

		TicketUser filter = new TicketUser();
		filter.setUserId(userId);
		try {
			dao.deleteItem(filter);
		} catch (DAOException e) {
			throw new TicketUserException(e);
		}

		logger.debug("TicketUserServiceImplImpl - deleteUser: finalizando");

	}

	public TicketUser createUser(TicketUser user) throws TicketUserException {

		logger.debug("TicketUserServiceImplImpl - createUser: iniciando");

		TicketUser filter = new TicketUser();
		filter.setUserId(user.getUserId());
		try {
			dao.addItem(user);
		} catch (DAOException e) {
			throw new TicketUserException(e);
		}

		logger.debug("TicketUserServiceImplImpl - createUser: finalizando");

		return user;
	}

	public void createUserImage(Long userId, InputStream inputStream, String fileName) throws TicketUserException {

		logger.debug("TicketUserServiceImplImpl - createUserImage: iniciando");

		TicketUser user = new TicketUser();
		String folderPath = config.getProperty(RestServiceConstant.APP_FILE_SYSTEM_USER_FOLDER_DIR);

		logger.debug("TicketUserServiceImplImpl - se guarda la imagen " + fileName + " del usuario id " + userId);

		try {
			fileService.handleUpload(inputStream, folderPath, fileName);
		} catch (FileManagingException e) {
			logger.error("TicketUserServiceImplImpl - no se pudo  guarda la imagen " + fileName + " del usuario id "
					+ userId);
			throw new TicketUserException(e);
		}

		logger.debug("TicketUserServiceImplImpl - se actualizan los datos del usuario");

		user.setImageId(userId);
		user.setPathImage(folderPath + fileName);

		updateUser(userId, user);

		logger.debug("TicketUserServiceImplImpl - createUserImage: finalizando");

	}

	public File getUserImage(Long userId) throws TicketUserException {

		logger.debug("TicketUserServiceImplImpl - getUserImage: iniciando");
		File file = null;

		TicketUser user = getUser(userId);
		
		try {
			
			file = fileService.handleDownload(user.getPathImage());
			if (file == null || !file.exists()) {
				logger.error("No existe la imagen solicitada en el path " + user.getPathImage());
				throw new TicketUserException("No existe la imagen solicitada");
			}
		} catch (FileManagingException e) {
			throw new TicketUserException("No se pudo obtener la imagen del usuario");
		}

		logger.debug("TicketUserServiceImplImpl - getUserImage: finalizando");
		
		return file;
	}
	
	public TicketUser performAuthentication(String userName, String pass) throws TicketUserException {

		TicketUser user = null;
		
		
		if(userName==null || userName.isEmpty() || pass==null || pass.isEmpty()){
			logger.warn("TicketUserServiceImplImpl - performAuthentication: Credenciales incorrectas");
			throw new TicketUserAuteticationException("Credenciales incompletas");
		}

		logger.debug("TicketUserServiceImplImpl - performAuthentication: iniciando");

		TicketUser filter = new TicketUser();
		filter.setUserName(userName);
		try {
			user = dao.getItem(filter); 
		} catch (ItemNotFoundException e) {
			logger.warn("TicketUserServiceImplImpl - performAuthentication: Credenciales incorrectas",e);
			throw new TicketUserAuteticationException("Credenciales incorrectas");
		} catch (DAOException e) {
			logger.error("TicketUserServiceImplImpl - performAuthentication: ocurrio un error al realizar la autenticacion", e);
			throw new TicketUserException(e);
		}
		
		String userPass = user.getUserPassword();
		
		if(userPass==null || userPass.isEmpty() || !userPass.equals(pass)){
			logger.warn("TicketUserServiceImplImpl - performAuthentication: Credenciales incorrectas");
			throw new TicketUserAuteticationException("Credenciales incorrectas");
		}

		logger.debug("TicketUserServiceImplImpl - performAuthentication: finalizando");

		user.setUserPassword(null);
		
		return user;
	}

	public void performForgotPass(String userName) throws TicketUserException {
		
		TicketUser user;
		MailContent mc;
		
		TicketUser filter = new TicketUser();
		filter.setUserName(userName);
		try {
			user = dao.getItem(filter); 
		} catch (ItemNotFoundException e) {
			logger.warn("TicketUserServiceImplImpl - performForgotPass: No existe el usuario "+userName,e);
			throw new TicketUserAuteticationException("No existe el usuario "+userName);
		} catch (DAOException e) {
			logger.error("TicketUserServiceImplImpl - performForgotPass: ocurrio un error al querer buscar el usuario "+userName, e);
			throw new TicketUserException(e);
		}
		
		mc = new MailContent(
				config.getProperty(RestServiceConstant.APP_EMAIL_MESSAGE_SUBJECT), 
				config.getProperty(RestServiceConstant.APP_EMAIL_MESSAGE_BODY) + user.getUserPassword(), 
				user.getUserEmail(), config.getProperty(RestServiceConstant.APP_EMAIL_SMTP_FROM));
		MailService ms = new MailServiceImpl();
		
		try {
			ms.sendMail(mc, RestServiceUtil.createConfiguratorSmtpMailing(config));
		} catch (Exception e) {
			throw new TicketUserException(e);
		}
		
	}


}
